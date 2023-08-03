package com.course_project_autotrace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UserAccount{
    public UserAccount(){

    }
    public String getIDToken(){
        return idToken;
    }
    public void setIDToken(String idToken){
        this.idToken = idToken;
    }
    private String idToken;
    public String getEmailId(){return emailId;}
    public void setEmailId(String emailId){this.emailId = emailId;}
    private String emailId;
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
    private String password;



        }