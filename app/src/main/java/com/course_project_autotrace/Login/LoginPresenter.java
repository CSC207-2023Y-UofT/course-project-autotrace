package com.course_project_autotrace.Login;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class LoginPresenter {

    private final LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void CheckLogin(String email, String password, FirebaseAuth mFirebaseAuth) {
        if(email.isEmpty() || password.isEmpty()){
            view.ShowEmptyError(); //checking whether edit inputs are empty
            return;
        }

        mFirebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        view.ClickToHomeScreen();
                        view.ShowLoginSuccessful();
                    } else {
                        view.ShowLoginError();
                    }
                });
    }

    public void LinkForgotPassword() {

        view.ClickToForgotPassword();
    }

    public void LinkSignUp() {
        view.ClickToSignUp();
    }

    public void CheckBasicCarInfo(String licensePlate, DatabaseReference referenceToCars) {
        if(licensePlate.isEmpty()){
            view.ShowEmptyError();
            return;
        }

        referenceToCars.child(licensePlate).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String carName = dataSnapshot.child("Name").getValue(String.class);
                    String model = dataSnapshot.child("Model").getValue(String.class);
                    String info = dataSnapshot.child("Insurance").getValue(String.class);
                    String insurance = dataSnapshot.child("Insurance").getKey();

                    if (carName != null && model != null && info != null && insurance != null) {
                        view.ClickToBasicCarInfo(carName, model, info, insurance);
                    } else { //
                        view.ShowCarNotFoundError();
                    }
                } else {
                    view.ShowCarNotFoundError();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                view.ShowCarNotFoundError();
            }
        });
    }
}
