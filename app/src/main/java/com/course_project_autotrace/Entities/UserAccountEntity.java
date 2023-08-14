package com.course_project_autotrace.Entities;


public class UserAccountEntity {

    public UserAccountEntity() {
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

    public String getDriverLicense() {
        return DriverLicense;
    }

    public void setDriverLicense(String DriverLicense) {
        this.DriverLicense = DriverLicense;
    }

    private String DriverLicense;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
