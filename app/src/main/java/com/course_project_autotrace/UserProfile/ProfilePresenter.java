package com.course_project_autotrace.UserProfile;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.course_project_autotrace.CarInformation.CarInfo;
import com.course_project_autotrace.Hompage.HomeScreen;
import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.ProfileAccessories.EditProfileScreen;
import com.course_project_autotrace.TrafficViolations.TrafficViolations;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfilePresenter {

    private final ProfileModel model;
    private final ProfileView view;

    public ProfilePresenter(ProfileModel model, ProfileView view) {
        this.model = model;
        this.view = view;
    }

    public void initProfile() {
        FirebaseUser currentUser = model.getCurrentUser();
        if (currentUser != null) {
            view.setUserEmail(currentUser.getEmail());
            fetchAndSetUserName(currentUser.getUid());
        } else {
            view.setUserEmail("Not logged in.");
            view.setUserName("");
        }
    }

    public void onBackButtonClicked() {
        Intent intent = new Intent(view, HomeScreen.class);
        view.startActivity(intent);
    }

    public void onLogoutButtonClicked() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(view, LoginScreen.class);
        view.startActivity(intent);
        view.finish();
        Toast.makeText(view, "Logout successfully", Toast.LENGTH_SHORT).show();
    }

    public void onRateUsButtonClicked() {
        String githubUrl = "https://github.com/CSC207-2023Y-UofT/course-project-autotrace";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
        view.startActivity(intent);
    }

    public void onEditProfileButtonClicked() {
        Intent intent = new Intent(view, EditProfileScreen.class);
        view.startActivity(intent);
    }

    // Navigation

    public void onHomeBtnClicked() {
        Intent intent = new Intent(view, HomeScreen.class);
        view.startActivity(intent);
    }

    public void onViolationBtnClicked() {
        Intent intent = new Intent(view, TrafficViolations.class);
        view.startActivity(intent);
    }
    public void onProfileBtnClicked() {
        Intent intent = new Intent(view, ProfileView.class);
        view.startActivity(intent);
    }

    public void onCarInfoBtnClicked() {
        Intent intent = new Intent(view, CarInfo.class);
        view.startActivity(intent);
    }

    private void fetchAndSetUserName(String userId) {
        model.fetchUserName(userId, new ProfileModel.UserNameCallback() {
            @Override
            public void onUserNameFetched(String userName) {
                view.setUserName(userName);
            }

            @Override
            public void onError(String errorMessage) {
                view.setUserName(errorMessage);
            }
        });
    }
}
