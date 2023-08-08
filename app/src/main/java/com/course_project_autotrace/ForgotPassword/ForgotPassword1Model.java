package com.course_project_autotrace.ForgotPassword;

import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword1Model{
    private FirebaseAuth mAuth;
    public ForgotPassword1Model(){
        mAuth=FirebaseAuth.getInstance();
    }
    public interface ResetPassword1Listener{
        void ResetPassword1Success();
        void ResetPassword1Failed(String Error);
    }
    public void ResetPassword1(String Email,ResetPassword1Listener listener){
        mAuth.sendPasswordResetEmail(Email).addOnSuccessListener(unused -> listener.ResetPassword1Success())
                .addOnFailureListener(e -> listener.ResetPassword1Failed(e.getMessage()));
    }
}