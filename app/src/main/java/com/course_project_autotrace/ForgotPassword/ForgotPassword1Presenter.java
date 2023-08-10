package com.course_project_autotrace.ForgotPassword;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class ForgotPassword1Presenter implements Observable {

    private ForgotPassword1View view;
    private FirebaseAuth mAuth;
    private List<Observer> observers = new ArrayList<>();

    public ForgotPassword1Presenter(ForgotPassword1View view, FirebaseAuth mAuth) {
        this.view = view;
        this.mAuth = mAuth;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String notification) {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }

    public void CheckForgotPassword(String Email) {
        if (Email.isEmpty()) {
            view.ShowEmptyError();
            return;
        }

        mAuth.sendPasswordResetEmail(Email)
                .addOnSuccessListener(unused -> {
                    notifyObservers("success");
                    view.BackToLogin();
                })
                .addOnFailureListener(e -> {
                    notifyObservers("failed");
                });
    }

    public void handleBack() {
        view.BackToLogin();
    }
}
