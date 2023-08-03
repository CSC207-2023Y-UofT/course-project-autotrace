package com.course_project_autotrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth; // Import FirebaseAuth
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity{



    private FirebaseAuth mFirebaseAuth; //firebase aurthenation
    private DatabaseReference mDatabaseRef; //real time database.
    private EditText mEtEmail;


    private ImageButton button;
    private EditText mEtPwd;
   // private Button mBtnsignup;
    private Button mbtnSignupContinue;
    private ImageButton bckButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference(); // Initialize mDatabaseRef
        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_password);
        mbtnSignupContinue = findViewById(R.id.SignupContinue);
        bckButton = findViewById(R.id.backButton5);


        mbtnSignupContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // will do sign up activity
                String strEmail = mEtEmail.getText().toString(); //for Enter Email.
                String strPwd = mEtPwd.getText().toString(); //for Enter pwd
                mFirebaseAuth = FirebaseAuth.getInstance();
                //Firebase auth ongo
                //mDatabaseRef - FirebaseDatabase.getInstance().getReference();
                //Firebase Auth Continue
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount(); //create instance.
                            account.setIDToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd);
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                            Toast.makeText(Signup.this, "signup Successfull", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Signup.this, "signup failed2", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

        });
        bckButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Navigate to the Loginji screen when back button is clicked
                Intent intent = new Intent(Signup.this, Loginji.class);
                startActivity(intent);
                finish();
            }


        });
    }
}
