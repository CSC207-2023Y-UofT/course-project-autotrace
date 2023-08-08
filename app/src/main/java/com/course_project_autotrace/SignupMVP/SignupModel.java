package com.course_project_autotrace.SignupMVP;

import com.course_project_autotrace.Login.UserAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupModel{
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseRef;
    public SignupModel(){
        mAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
    }
    public interface SignupListener{
        void SignupSuccess();
        void SignupFailed(String Error);
    }
    public void SignupUser(String Email,String Password,String name,String DriverLicense, SignupListener listener){
        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                if(firebaseUser !=null){
                    UserAccount useraccount = new UserAccount();
                    useraccount.setIDToken(firebaseUser.getUid());
                    useraccount.setEmailId(Email);
                    useraccount.setPassword(Password);
                    useraccount.setDriverLicense(DriverLicense);
                    useraccount.setFullName(name);
                    mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(useraccount);
                    listener.SignupSuccess();

                }
                else {
                    listener.SignupFailed("Error:User is Empty");
                }
            }else {
                listener.SignupFailed("Signup Failed");
            }

        });
    }
}