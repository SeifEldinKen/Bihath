package com.eldinstudio.bihath.domain.usecase;

import com.eldinstudio.bihath.data.model.UserProfile;
import com.eldinstudio.bihath.data.repository.UserRegisterRepositoryImpl;
import io.reactivex.rxjava3.core.Single;

public class UserRegisterUseCase {

    private UserRegisterRepositoryImpl registerRepositoryImpl;


    public UserRegisterUseCase(UserRegisterRepositoryImpl registerRepositoryImpl) {
        this.registerRepositoryImpl = registerRepositoryImpl;
    }


    public Single<UserProfile> execute(UserProfile userProfile) {
        return registerRepositoryImpl.userRegisterWithEmailAndPassword(userProfile);
    }

}
