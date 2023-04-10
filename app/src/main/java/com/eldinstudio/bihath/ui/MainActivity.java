package com.eldinstudio.bihath.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.eldinstudio.bihath.R;
import com.eldinstudio.bihath.data.model.UserProfile;
import com.eldinstudio.bihath.data.repository.UserProfileRepositoryImpl;
import com.eldinstudio.bihath.data.repository.UserRegisterRepositoryImpl;
import com.eldinstudio.bihath.databinding.ActivityMainBinding;
import com.eldinstudio.bihath.domain.usecase.RegisterAndCreateProfileUseCase;
import com.eldinstudio.bihath.domain.usecase.UserProfileCreateUseCase;
import com.eldinstudio.bihath.domain.usecase.UserRegisterUseCase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import io.reactivex.rxjava3.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    private UserRegisterUseCase registerUseCase;

    private UserRegisterRepositoryImpl registerRepositoryImpl;
    private UserProfileRepositoryImpl userProfileRepositoryImpl;
    private UserProfileCreateUseCase userProfileCreateUseCase;

    private RegisterAndCreateProfileUseCase registerAndCreateProfileUseCase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        registerRepositoryImpl = new UserRegisterRepositoryImpl(firebaseAuth);
        registerUseCase = new UserRegisterUseCase(registerRepositoryImpl);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        userProfileRepositoryImpl = new UserProfileRepositoryImpl(firestore);
        userProfileCreateUseCase = new UserProfileCreateUseCase(userProfileRepositoryImpl);


        registerAndCreateProfileUseCase = new RegisterAndCreateProfileUseCase(registerUseCase, userProfileCreateUseCase);

        UserProfile userProfile = new UserProfile(
                "",
                "Seif Eldin",
                "seifeldintrader@gmail.com",
                "seaways22",
                "seaways22",
                false
        );


        binding.buttonRegister.setOnClickListener(v -> {
            
            registerAndCreateProfileUseCase.execute(userProfile).subscribeOn(Schedulers.io()).subscribe( (currentUser, error) -> {

                if (error == null) {

                    Log.d(TAG, "userId: " + currentUser.getUserId());

                } else {

                    Log.d(TAG, "error: " + error.getMessage());

                }

            });

        });

    }
}