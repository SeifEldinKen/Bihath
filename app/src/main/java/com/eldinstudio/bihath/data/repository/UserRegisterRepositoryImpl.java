package com.eldinstudio.bihath.data.repository;

import com.eldinstudio.bihath.data.model.UserProfile;
import com.eldinstudio.bihath.domain.repository.UserRegisterRepository;
import io.reactivex.rxjava3.core.Single;

public class UserRegisterRepositoryImpl implements UserRegisterRepository {

    @Override
    public Single<UserProfile> userRegisterWithEmailAndPassword(UserProfile userProfile) {
        return Single.create( (emitter) -> {

        });
    }

}