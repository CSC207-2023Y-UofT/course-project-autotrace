package com.course_project_autotrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth; // Import FirebaseAuth
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Loginji extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth; //firebase인증
    private DatabaseReference mDatabaseRef; //실시간 데이터 베이스.
    private EditText mEtEmail; //버튼들 사용가능하게만들
    private EditText mEtPwd;
    private ImageButton backButton;
    //private Button mBtnsignup; 밑에꺼대신씀.

    private TextView textViewSignUp;//diler put sigup button as text.
   //TextView textViewForgotpwd = findViewById(R.id.textView..)
    private Button mBtnContinueLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginji);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mEtEmail = findViewById(R.id.editEmail);
        textViewSignUp = findViewById(R.id.textView7);
        mEtPwd = findViewById(R.id.editPassword);
        mBtnContinueLogin = findViewById(R.id.continueButton2);
        backButton = findViewById(R.id.BackBtn); // Initialize the backButton using findViewById

        mBtnContinueLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Your existing code for continue login button click
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your existing code for backButton click
                Intent intent = new Intent(Loginji.this, Signup.class);
                startActivity(intent);
            }
        });

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your existing code for textViewSignUp click
                Intent intent = new Intent(Loginji.this, Signup.class);
                startActivity(intent);
            }
        });
    }

}
