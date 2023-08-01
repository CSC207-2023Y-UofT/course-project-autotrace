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



    private FirebaseAuth mFirebaseAuth; //firebase인증
    private DatabaseReference mDatabaseRef; //실시간 데이터 베이스.
    private EditText mEtEmail; //버튼들 사용가능하게만들


    private ImageButton button;
    private EditText mEtPwd;
   // private Button mBtnsignup; //밑에꺼대신씀.
    private Button mbtnSignupContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference(); // Initialize mDatabaseRef
        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_password);
        mbtnSignupContinue = findViewById(R.id.SignupContinue);


        mbtnSignupContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // will do sign up activity
                String strEmail = mEtEmail.getText().toString(); //입력 장치
                String strPwd = mEtPwd.getText().toString(); //입려장치
                mFirebaseAuth = FirebaseAuth.getInstance();
                //Firebase auth ongo
                //mDatabaseRef - FirebaseDatabase.getInstance().getReference();
                //Firebase Auth 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount(); //객체 생성.
                            account.setIDToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd);
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                            Toast.makeText(Signup.this, "signup Successfull", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Signup.this, "signup failed2", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}
