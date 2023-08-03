package com.course_project_autotrace;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

//import org.w3c.dom.Text;

public class Loginji extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth; // for firebase autheniation
    private EditText mEtEmail; //for edit text.
    private EditText mEtPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginji);
        mFirebaseAuth = FirebaseAuth.getInstance();
        //for realtime database.
        FirebaseDatabase.getInstance().getReference();
        mEtEmail = findViewById(R.id.editEmail);
        //diler put sigup button as text.

        mEtPwd = findViewById(R.id.editPassword);
        //TextView textViewForgotpwd = findViewById(R.id.textView..)
        Button mBtnContinueLogin = findViewById(R.id.continueButton2);
       // Initialize the backButton using findViewById
        //private Button mBtnsignup; //since we using imagebutton on frontend , we use above.
        TextView textViewForgotpwd = findViewById(R.id.Forgotpwd);
        TextView textViewSignUp = findViewById(R.id.signup);

        mBtnContinueLogin.setOnClickListener(v -> {
            String strEmail = mEtEmail.getText().toString();
            String strPwd = mEtPwd.getText().toString();

            // Check if the email or password fields are empty
            if(strEmail.isEmpty() || strPwd.isEmpty()){
                Toast.makeText(Loginji.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                return;  // stop further execution if fields are empty
            }

            mFirebaseAuth.signInWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(Loginji.this, task -> {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Loginji.this,HomeScreen.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Loginji.this, "Failed login", Toast.LENGTH_SHORT).show();
                }
            });
        });

//        startActivity(new Intent(Loginji.this, Signup.class));
        textViewForgotpwd.setOnClickListener(v-> {

                //  code for Forgotpassword clicked
                Intent intent = new Intent(Loginji.this, ForgotPassword1.class);
                startActivity(intent);

        });

        textViewSignUp.setOnClickListener(v -> {
            // Your existing code for textViewSignUp click
            Intent intent = new Intent(Loginji.this, Signup.class);
            startActivity(intent);
        });

        Button continueBt2 = findViewById(R.id.continueBtn2);
        continueBt2.setOnClickListener(v -> {
            Intent intent = new Intent(Loginji.this, BasicCarInfo.class);
            startActivity(intent);
        });

    }


}
