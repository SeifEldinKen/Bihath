package com.eldinstudio.bihath.data.repository;

import com.eldinstudio.bihath.data.model.UserProfile;
import com.eldinstudio.bihath.domain.repository.UserProfileRepository;
import com.eldinstudio.bihath.util.FirestoreConstants;
import com.google.firebase.firestore.FirebaseFirestore;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class UserProfileRepositoryImpl implements UserProfileRepository {

    private final FirebaseFirestore firestore;



    public UserProfileRepositoryImpl(FirebaseFirestore firestore) {
        this.firestore = firestore;
    }



    @Override
    public Completable createUserProfile(UserProfile userProfile) {
        return Completable.create( (emitter) -> {

            try {

                firestore.collection(FirestoreConstants.COLLECTION_NAME_USERS).document(userProfile.getUserId()).set(
                        userProfile
                ).addOnSuccessListener(command -> {

                    emitter.onComplete();

                }).addOnFailureListener( (error) -> {

                    emitter.onError(error);

                });

            } catch (Exception error) {

                emitter.onError(error);

            }

        });
    }




    @Override
    public Single<UserProfile> getUserProfileById(String userId) {
        return null;
    }

    @Override
    public Completable updateUserProfileById(String userId) {
        return null;
    }

    @Override
    public Completable deleteUserById(String userId) {
        return null;
    }
}
