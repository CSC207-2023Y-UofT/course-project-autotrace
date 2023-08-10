package com.course_project_autotrace.ForgotPassword;

public interface Observable {
    void addObserver(Observer o);
    void deleteObserver(Observer o);
    void notifyObservers(String message);
}
