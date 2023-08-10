package com.course_project_autotrace.Login;

public interface LoginView {
    void ShowLoginError();
    void ShowEmptyError();
    void ShowLoginSuccessful();
    void ClickToHomeScreen();
    void ClickToForgotPassword();
    void ClickToSignUp();
    void ClickToBasicCarInfo(String carName, String model, String info, String insurance);
    void ShowCarNotFoundError();

}
