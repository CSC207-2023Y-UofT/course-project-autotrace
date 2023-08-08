package com.course_project_autotrace.SignupMVP;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.course_project_autotrace.ForgotPassword.ForgotPassword1;
import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.Login.UserAccount;
import com.course_project_autotrace.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity{
    private EditText mEtEmail;
    private EditText mEtName;
    private EditText mEtPwd;
    private EditText DriverLicense;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mEtEmail=findViewById(R.id.et_email);
        mEtName = findViewById(R.id.fullName);
        mEtPwd = findViewById(R.id.et_password);
        DriverLicense = findViewById(R.id.DriverLicense);
        Button mbtnSignupCont = findViewById(R.id.SignupContinue);

        mbtnSignupCont.setOnClickListener(view -> {
            String strEmail = mEtEmail.getText().toString();
            String strName = mEtName.getText().toString();
            String strPwd = mEtPwd.getText().toString();
            String strDriverLicense = DriverLicense.getText().toString();
            if(strEmail.isEmpty()||strPwd.isEmpty()||strName.isEmpty()){
                Toast.makeText(Signup.this,"Please fill all fields",Toast.LENGTH_SHORT).show();

            }
            mFirebaseAuth.createUserWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(Signup.this,task -> {
                if(task.isSuccessful()){
                    FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                    if(firebaseUser!=null){
                        UserAccount useraccount = new UserAccount();
                        useraccount.setFullName(strName);
                        useraccount.setPassword(strPwd);
                        useraccount.setDriverLicense(strDriverLicense);
                        useraccount.setEmailId(strEmail);
                        useraccount.setIDToken(firebaseUser.getUid());
                        mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(useraccount);
                        Toast.makeText(Signup.this,"Signup Successful",Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(Signup.this, LoginScreen.class);
                        startActivity(intent);
                        finish();


                    }
                    else{
                        Toast.makeText(Signup.this,"Error:User is Empty", Toast.LENGTH_SHORT).show();

                    }

                }else{
                    Toast.makeText(Signup.this,"Signup Failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
        ImageButton BackBtn = findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(v->{
            Intent intent= new Intent(Signup.this,LoginScreen.class);
            startActivity(intent);
        });
    }
}