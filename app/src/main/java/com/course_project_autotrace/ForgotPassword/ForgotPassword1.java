package com.course_project_autotrace.ForgotPassword;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.R;

public class ForgotPassword1 extends AppCompatActivity implements ForgotPassword1View{
    private EditText edtEmail;
    private Button btnResetCont;
    private ImageButton bckBtn;
    private ForgotPassword1Presenter FPpresenter;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_forgot_password1));
        edtEmail=findViewById(R.id.editTextEmail);
        bckBtn=findViewById(R.id.BackBtn);
        btnResetCont = findViewById(R.id.btnResetPwdContinue);
        FPpresenter = new ForgotPassword1Presenter(this);
        btnResetCont.setOnClickListener(view -> {
            String strEmail= edtEmail.getText().toString().trim();
            if(!TextUtils.isEmpty(strEmail)){
                FPpresenter.ResetPassword1(strEmail);
            }
            else{
                edtEmail.setError("Enter the email");
            }
        });
        bckBtn.setOnClickListener(view -> {
            Intent intent = new Intent(ForgotPassword1.this, LoginScreen.class);
            startActivity(intent);
        });
    }
    public void showPasswordResetSuccess(){
        Toast.makeText(ForgotPassword1.this,"Reset Password Link has been sent to your registered Email",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ForgotPassword1.this,LoginScreen.class);
        startActivity(intent);
        finish();
    }
    public void showPasswordResetFailed(String Error){
        Toast.makeText(ForgotPassword1.this,"Error:"+Error,Toast.LENGTH_SHORT).show();
    }
}