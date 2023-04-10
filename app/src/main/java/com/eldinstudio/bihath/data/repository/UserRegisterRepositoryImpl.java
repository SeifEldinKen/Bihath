package com.eldinstudio.bihath.data.repository;

import android.util.Log;
import com.eldinstudio.bihath.data.model.UserProfile;
import com.eldinstudio.bihath.domain.repository.UserRegisterRepository;
import com.google.firebase.auth.FirebaseAuth;
import io.reactivex.rxjava3.core.Single;

public class UserRegisterRepositoryImpl implements UserRegisterRepository {
    private static final String TAG = "MainActivity";
    private final FirebaseAuth firebaseAuth;


    public UserRegisterRepositoryImpl(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }


    @Override
    public Single<UserProfile> userRegisterWithEmailAndPassword(UserProfile userProfile) {

        return Single.create( (emitter) -> {

            try {
                firebaseAuth.createUserWithEmailAndPassword(
                        userProfile.getEmail(),
                        userProfile.getPassword()
                ).addOnSuccessListener( (authResult) -> {

                    userProfile.setUserId(authResult.getUser().getUid());
                    emitter.onSuccess(userProfile);

                }).addOnFailureListener( (error) -> {

                    emitter.onError(error);

                });

            } catch (Exception error) {

                emitter.onError(error);

            }

        });
    }

}