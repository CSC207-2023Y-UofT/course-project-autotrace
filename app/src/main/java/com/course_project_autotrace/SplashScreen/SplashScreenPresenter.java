package com.course_project_autotrace.SplashScreen;
import android.os.Handler;

public class SplashScreenPresenter {
    private final SplashScreenView view;

    //setting presenter
    public SplashScreenPresenter(SplashScreenView view) {
        this.view = view;
    }
    // setting a 2 sec delay
    public void startSplashTimer() {
        new Handler().postDelayed(view::ToLoginScreen, 2000);
    }
}
