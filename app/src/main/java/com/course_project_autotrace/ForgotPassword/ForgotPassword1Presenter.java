package com.course_project_autotrace.ForgotPassword;
public class ForgotPassword1Presenter implements ForgotPassword1Model.ResetPassword1Listener{
    private ForgotPassword1View FPview;
    private ForgotPassword1Model FPmodel;
    public ForgotPassword1Presenter(ForgotPassword1View FPview){
        this.FPview = FPview;
        this.FPmodel=new ForgotPassword1Model();
    }

    public void ResetPassword1(String Email){
        FPmodel.ResetPassword1(Email,ForgotPassword1Presenter.this);
    }
    @Override
    public void ResetPassword1Success(){
        FPview.showPasswordResetSuccess();
    }
    public void ResetPassword1Failed(String Error) {
        FPview.showPasswordResetFailed(Error);
    }

}