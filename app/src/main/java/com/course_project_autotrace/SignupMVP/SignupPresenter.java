package com.course_project_autotrace.SignupMVP;

import com.course_project_autotrace.Entities.UserAccountEntity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class SignupPresenter {

    private SignupView view;

    public SignupPresenter(SignupView view) {
        this.view = view;
    }

    public void CheckSignup(String Email, String Password, String Name, FirebaseAuth Auth, DatabaseReference DBref) {
        if (Email.isEmpty() || Password.isEmpty() || Name.isEmpty()) {
            view.ShowEmptyFieldError();
            return;
        }

        Auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                FirebaseUser firebaseUser = Auth.getCurrentUser();
                if (firebaseUser != null) {
                    UserAccountEntity account = new UserAccountEntity();
                    account.setIDToken(firebaseUser.getUid());
                    account.setEmailId(Email);
                    account.setPassword(Password);
                    account.setFullName(Name);
                    DBref.child("UserAccountEntity").child(firebaseUser.getUid()).setValue(account);
                    view.ShowSignupSuccess();
                    view.BackToLogin();
                } else {
                    view.ShowSignupFailed();
                }
            } else {
                view.ShowSignupFailed();
            }
        });
    }
    public void LinkToLogin() {
        view.BackToLogin();
    }


}
