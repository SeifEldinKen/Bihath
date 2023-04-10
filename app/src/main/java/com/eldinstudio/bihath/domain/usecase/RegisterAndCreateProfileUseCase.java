package com.eldinstudio.bihath.domain.usecase;

import android.annotation.SuppressLint;

import com.eldinstudio.bihath.data.model.UserProfile;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class RegisterAndCreateProfileUseCase {

    private final UserRegisterUseCase registerUseCase;

    private final UserProfileCreateUseCase userProfileCreateUseCase;


    public RegisterAndCreateProfileUseCase(UserRegisterUseCase registerUseCase, UserProfileCreateUseCase userProfileCreateUseCase) {
        this.registerUseCase = registerUseCase;
        this.userProfileCreateUseCase = userProfileCreateUseCase;
    }



    public Single<UserProfile> execute(UserProfile userProfile) {
        return Single.create( (emitter) -> {

            registerUseCase.execute(userProfile).subscribeOn(Schedulers.io()).subscribe( (currentUser, error) -> {

                if (error == null) {

                    userProfileCreateUseCase.execute(userProfile).subscribeOn(Schedulers.io()).subscribe(
                            () -> {
                                emitter.onSuccess(currentUser);
                            },
                            throwable -> {
                                emitter.onError(throwable);
                            }
                    );

                } else {

                    emitter.onError(error);

                }

            });

        });
    }

}
