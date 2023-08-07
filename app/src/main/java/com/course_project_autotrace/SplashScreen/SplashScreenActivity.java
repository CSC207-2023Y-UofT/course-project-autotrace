package com.course_project_autotrace.SplashScreen;
import com.course_project_autotrace.Login.LoginScreen;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.course_project_autotrace.R;
import android.annotation.SuppressLint;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity implements SplashScreenView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SplashScreenPresenter presenter = new SplashScreenPresenter(this);
        presenter.startSplashTimer();
    }

    @Override
    public void ToLoginScreen() {
        Intent intent = new Intent(SplashScreenActivity.this, LoginScreen.class);
        startActivity(intent);
        finish();
    }
}
