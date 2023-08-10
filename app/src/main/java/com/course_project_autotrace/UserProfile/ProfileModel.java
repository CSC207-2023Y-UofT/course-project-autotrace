package com.course_project_autotrace.UserProfile;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileModel {

    interface UserNameCallback {
        void onUserNameFetched(String userName);
        void onError(String errorMessage);
    }

    FirebaseUser getCurrentUser() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    void fetchUserName(String userId, UserNameCallback callback) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserAccount");
        databaseReference.child(userId).child("fullName").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String userName = dataSnapshot.getValue(String.class);
                callback.onUserNameFetched(userName);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onError("Error fetching username");
            }
        });
    }
}
