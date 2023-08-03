package com.course_project_autotrace;


public class UserAccount {
    public UserAccount() {
    }

    public String getIDToken() {
        return idToken;
    }

    public void setIDToken(String idToken) {
        this.idToken = idToken;
    }

    private String idToken;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private String emailId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    // Add a new private variable for the name
    private String fullName;

    // Provide a getter and setter for the name
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
