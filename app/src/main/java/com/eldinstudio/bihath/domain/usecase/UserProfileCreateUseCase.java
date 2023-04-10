package com.eldinstudio.bihath.domain.usecase;

import com.eldinstudio.bihath.data.model.UserProfile;
import com.eldinstudio.bihath.data.repository.UserProfileRepositoryImpl;
import io.reactivex.rxjava3.core.Completable;

public class UserProfileCreateUseCase {

    private final UserProfileRepositoryImpl userProfileRepositoryImpl;


    public UserProfileCreateUseCase(UserProfileRepositoryImpl userProfileRepositoryImpl) {
        this.userProfileRepositoryImpl = userProfileRepositoryImpl;
    }


    public Completable execute(UserProfile userProfile) {
        return userProfileRepositoryImpl.createUserProfile(userProfile);
    }

}
