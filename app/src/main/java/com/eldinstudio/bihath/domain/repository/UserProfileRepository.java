package com.eldinstudio.bihath.domain.repository;

import com.eldinstudio.bihath.data.model.UserProfile;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface UserProfileRepository {

    Single<UserProfile> createUserProfile(UserProfile userProfile);

    Single<UserProfile> getUserProfileById(String userId);

    Completable updateUserProfileById(String userId);

    Completable deleteUserById(String userId);

}
