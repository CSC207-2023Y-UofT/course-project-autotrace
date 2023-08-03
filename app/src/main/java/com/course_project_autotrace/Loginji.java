package com.course_project_autotrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
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

//import org.w3c.dom.Text;

public class Loginji extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth; // for firebase autheniation
    private EditText mEtEmail; //for edit text.
    private EditText mEtPwd;
    private TextView textViewForgotpwd;

    //private Button mBtnsignup; //since we using imagebutton on frontend , we use above.

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginji);
        mFirebaseAuth = FirebaseAuth.getInstance();
        //for realtime database.
        FirebaseDatabase.getInstance().getReference();
        mEtEmail = findViewById(R.id.editEmail);
        //diler put sigup button as text.
        TextView textViewSignUp = findViewById(R.id.textView7);
        mEtPwd = findViewById(R.id.editPassword);

        
        textViewForgotpwd = findViewById(R.id.Forgotpwd); // Initialize the backButton using findViewById
        //TextView textViewForgotpwd = findViewById(R.id.textView..)
        Button mBtnContinueLogin = findViewById(R.id.continueButton2);
        ImageButton backButton = findViewById(R.id.BackBtn); // Initialize the backButton using findViewById

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

        textViewForgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  code for Forgotpassword clicked
                Intent intent = new Intent(Loginji.this, ForgotPassword1.class);
                startActivity(intent);
            }
        });

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  code for textViewSignUp click
                Intent intent = new Intent(Loginji.this, Signup.class);
                startActivity(intent);
            }

        });
    }

}
