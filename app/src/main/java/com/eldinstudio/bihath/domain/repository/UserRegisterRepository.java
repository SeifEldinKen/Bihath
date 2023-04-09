package com.eldinstudio.bihath.domain.repository;

import com.eldinstudio.bihath.data.model.UserProfile;
import io.reactivex.rxjava3.core.Single;

public interface UserRegisterRepository {

    Single<UserProfile> userRegisterWithEmailAndPassword(UserProfile userProfile);

}