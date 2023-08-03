package com.course_project_autotrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth; // Import FirebaseAuth
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity{



    private FirebaseAuth mFirebaseAuth; //firebase authentication
    private DatabaseReference mDatabaseRef; //real time database.
    private EditText mEtEmail;
    private EditText mEtPwd;
    private EditText mName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference(); // Initialize mDatabaseRef
        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_password);
        mName = findViewById(R.id.fullName);
        Button mbtnSignupContinue = findViewById(R.id.SignupContinue);


        mbtnSignupContinue.setOnClickListener(v -> {
            // Get user input
            String strEmail = mEtEmail.getText().toString();
            String strPwd = mEtPwd.getText().toString();
            String strName = mName.getText().toString();

            // Check if any field is empty
            if (strEmail.isEmpty() || strPwd.isEmpty() || strName.isEmpty()) {
                Toast.makeText(Signup.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Continue with Firebase Authentication
            mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                        if (firebaseUser != null) {
                            // Create a new instance of UserAccount with name, email, and password
                            UserAccount account = new UserAccount();
                            account.setIDToken(firebaseUser.getUid());
                            account.setEmailId(strEmail);
                            account.setPassword(strPwd);
                            account.setFullName(strName); // Set the name in the UserAccount

                            // Save the UserAccount to the Realtime Database
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(Signup.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Signup.this, Loginji.class);
                            startActivity(intent);
                            finish(); // Close the current activity to prevent going back with the back button

                            // You can add further actions like opening a new activity here
                        } else {
                            Toast.makeText(Signup.this, "Error: User is null", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Signup.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });


    }
}
