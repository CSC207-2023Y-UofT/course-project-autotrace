package com.course_project_autotrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth; // Import FirebaseAuth
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Loginji extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth; //firebase인증
    private DatabaseReference mDatabaseRef; //실시간 데이터 베이스.
    private EditText mEtEmail; //버튼들 사용가능하게만들
    private EditText mEtPwd;
    //private Button mBtnsignup; 밑에꺼대신씀.

    TextView textViewSignUp = findViewById(R.id.textView7);//diler put sigup button as text.
   //TextView textViewForgotpwd = findViewById(R.id.textView..)
    private Button mBtnContinueLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginji);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mEtEmail = findViewById(R.id.editEmail);
        mEtPwd = findViewById(R.id.editPassword);
        //same as  mBtnsignup.setOnClickListener(new View.OnClickListner(){
        // @override
        //public void onClick(View v){
        //String  strEmail
        mBtnContinueLogin = findViewById(R.id.continueButton2);

        mBtnContinueLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtPwd.getText().toString();
                mFirebaseAuth.signInWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(Loginji.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(Loginji.this,HomeScreen.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(Loginji.this, "Failed login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        startActivity(new Intent(Loginji.this, Signup.class)); //사인업 스크린으로 이동.
    }
}
