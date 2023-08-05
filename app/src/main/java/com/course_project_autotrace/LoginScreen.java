package com.course_project_autotrace;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

//import org.w3c.dom.Text;

public class LoginScreen extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth; // for firebase autheniation
    private EditText mEtEmail; //for edit text.
    private EditText mEtPwd;
    public EditText licenseNum;
    private DatabaseReference referenceToCars;
    private DataSnapshot car;
    public String carName, model,info;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
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
                Toast.makeText(LoginScreen.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                return;  // stop further execution if fields are empty
            }

            mFirebaseAuth.signInWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(LoginScreen.this, task -> {
                if(task.isSuccessful()){
                    Intent intent = new Intent(LoginScreen.this,HomeScreen.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginScreen.this, "Failed login", Toast.LENGTH_SHORT).show();
                }
            });
        });

//        startActivity(new Intent(LoginScreen.this, Signup.class));
        textViewForgotpwd.setOnClickListener(v-> {

                //  code for Forgotpassword clicked
                Intent intent = new Intent(LoginScreen.this, ForgotPassword1.class);
                startActivity(intent);

        });

        textViewSignUp.setOnClickListener(v -> {
            // Your existing code for textViewSignUp click
            Intent intent = new Intent(LoginScreen.this, Signup.class);
            startActivity(intent);
        });

        // Basic Car info code
        licenseNum = findViewById(R.id.edit_licensePlate);
        Button continue2 = findViewById(R.id.continueBtn2);
        continue2.setOnClickListener(v -> {
            final String enteredLicensePlate = licenseNum.getText().toString();

            referenceToCars.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        if (Objects.equals(snapshot.getKey(), enteredLicensePlate)){
                            car = snapshot;
                        }
                    }

                    if (car == null) {
                        Toast.makeText(LoginScreen.this, "Car does not exist in the database", Toast.LENGTH_LONG).show();
                    }
                    carName = String.valueOf(car.child("Name").getValue());
                    model = String.valueOf(car.child("Model"));
                    info = String.valueOf(car.child("Insurance"));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            Intent intent = new Intent(LoginScreen.this, BasicCarInfo.class);  // Assuming your Home screen is HomeScreenActivity
            startActivity(intent);
            finish();
        });
    }


}
