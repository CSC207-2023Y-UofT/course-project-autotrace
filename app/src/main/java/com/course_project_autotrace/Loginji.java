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
    private FirebaseAuth mFirebaseAuth; // for firebase autheniation
    private DatabaseReference mDatabaseRef; //for realtime database.
    private EditText mEtEmail; //for edit text.
    private EditText mEtPwd;
    private ImageButton backButton;
    //private Button mBtnsignup; //since we using imagebutton on frontend , we use above.

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
        startActivity(new Intent(Loginji.this, Signup.class));

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
