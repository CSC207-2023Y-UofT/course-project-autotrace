package com.course_project_autotrace.SignupMVP;


public class SignupPresenter implements SignupModel.SignupListener{
    private SignupModel SuModel;
    private SignupView SuView;

    public void SignupUser(String Email,String Password,String name,String DriverLicense){
        SuModel.SignupUser(Email,Password, name,DriverLicense,SignupPresenter.this);
    }
    public SignupPresenter(SignupView SuView){
        this.SuView = SuView;
        this.SuModel = new SignupModel();
    }
    @Override
    public void SignupSuccess(){
        SuView.showSignupSuccess();
    }
    @Override
    public void SignupFailed(String Error){
        SuView.showSignupFailed(Error);

    }
}
