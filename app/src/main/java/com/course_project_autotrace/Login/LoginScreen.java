package com.course_project_autotrace.Login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.course_project_autotrace.BasicCarInfo.BasicCarInfoModel;
import com.course_project_autotrace.ForgotPassword.ForgotPassword;
import com.course_project_autotrace.Hompage.HomeScreen;
import com.course_project_autotrace.R;
import com.course_project_autotrace.SignupMVP.SignupModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginScreen extends AppCompatActivity implements LoginView {

    private FirebaseAuth mFirebaseAuth;
    private EditText mEtEmail, mEtPwd, licenseNum;
    private DatabaseReference referenceToCars;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        mFirebaseAuth = FirebaseAuth.getInstance(); //Database Auth
        referenceToCars = FirebaseDatabase.getInstance().getReference().child("Cars"); //databaseref from dbof car.

        mEtEmail = findViewById(R.id.editEmail);
        mEtPwd = findViewById(R.id.editPassword);
        licenseNum = findViewById(R.id.edit_licensePlate);
        Button mBtnContinueLogin = findViewById(R.id.continueButton2);
        TextView textViewForgotpwd = findViewById(R.id.Forgotpwd);
        TextView textViewSignUp = findViewById(R.id.signup);
        TextView continue2 = findViewById(R.id.continueBtn2);

        presenter = new LoginPresenter(this);
        //this is where SignupModel
        mBtnContinueLogin.setOnClickListener(v -> {
            String strEmail = mEtEmail.getText().toString();
            String strPwd = mEtPwd.getText().toString();
            presenter.CheckLogin(strEmail, strPwd, mFirebaseAuth);
        });

        textViewForgotpwd.setOnClickListener(v -> presenter.LinkForgotPassword());
        textViewSignUp.setOnClickListener(v -> presenter.LinkSignUp());

        continue2.setOnClickListener(v -> {
            String enteredLicensePlate = licenseNum.getText().toString();
            presenter.CheckBasicCarInfo(enteredLicensePlate, referenceToCars);
        });
    }
    public void ShowLoginSuccessful(){
        Toast.makeText(this,"Login Success :)",Toast.LENGTH_SHORT).show();
    }
    public void ShowLoginError(){
        Toast.makeText(this, "Login failed:(", Toast.LENGTH_SHORT).show();
    }


    @Override

    public void ShowCarNotFoundError(){
        Toast.makeText(this,"Incomplete car Data or not in database ", Toast.LENGTH_SHORT).show();
    }


    @Override //to use MVP/CA we use it as overriding method.(listenr is already on above codes.)
    public void ClickToHomeScreen() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        finish();
    }
    public void ShowEmptyError(){
        Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ClickToForgotPassword() {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }

    @Override
    public void ClickToSignUp() {
        Intent intent = new Intent(this, SignupModel.class);
        startActivity(intent);
    }

    @Override
    public void ClickToBasicCarInfo(String carName, String model, String info, String insurance) {
        Intent intent = new Intent(this, BasicCarInfoModel.class);
        intent.putExtra("carName", carName);
        intent.putExtra("model", model);
        intent.putExtra("info", info);
        intent.putExtra("insurance", insurance);
        startActivity(intent);
        finish();
    }
}
