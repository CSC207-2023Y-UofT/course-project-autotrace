package com.course_project_autotrace;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth; // Import FirebaseAuth
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity{



    private FirebaseAuth mFirebaseAuth; //firebase aurthenation
    private DatabaseReference mDatabaseRef; //real time database.
    private EditText mEtEmail;



    private EditText mEtPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference(); // Initialize mDatabaseRef
        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_password);
        // private Button mBtnsignup;
        Button mbtnSignupContinue = findViewById(R.id.SignupContinue);
        ImageButton bckButton = findViewById(R.id.backButton5);


        mbtnSignupContinue.setOnClickListener(v -> {
            // will do sign up activity
            String strEmail = mEtEmail.getText().toString(); //for Enter Email.
            String strPwd = mEtPwd.getText().toString(); //for Enter pwd
            mFirebaseAuth = FirebaseAuth.getInstance();
            //Firebase auth ongo
            //mDatabaseRef - FirebaseDatabase.getInstance().getReference();
            //Firebase Auth Continue
            mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(Signup.this, task -> {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                    UserAccount account = new UserAccount(); //create instance.
                    assert firebaseUser != null;
                    account.setIDToken(firebaseUser.getUid());
                    account.setEmailId(firebaseUser.getEmail());
                    account.setPassword(strPwd);
                    mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                    Toast.makeText(Signup.this, "signup Successfull", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Signup.this, "signup failed2", Toast.LENGTH_SHORT).show();
                }
            });
        });
        bckButton.setOnClickListener(view -> {
            // Navigate to the Loginji screen when back button is clicked
            Intent intent = new Intent(Signup.this, Loginji .class);
            startActivity(intent);
            finish();
        });


    }
}
