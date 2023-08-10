package com.course_project_autotrace.UserProfile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.course_project_autotrace.R;
public class ProfileView extends AppCompatActivity {

    private ProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        ProfileModel model = new ProfileModel();
        presenter = new ProfilePresenter(model, this);

        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> {
            presenter.onBackButtonClicked();
        });

        Button rateBtn = findViewById(R.id.buttonRateUs);
        rateBtn.setOnClickListener(v -> {
            presenter.onRateUsButtonClicked();
        });

        Button editBtn = findViewById(R.id.buttonProfileInformation);
        editBtn.setOnClickListener(v -> {
            presenter.onEditProfileButtonClicked();
        });

        Button logoutBtn = findViewById(R.id.buttonLogout);
        logoutBtn.setOnClickListener(v -> {
            presenter.onLogoutButtonClicked();
        });

        // Navigation

        ImageButton violationBtn = findViewById(R.id.violationBtn);
        violationBtn.setOnClickListener(v -> presenter.onViolationBtnClicked());

        ImageButton profileBTN = findViewById(R.id.profileBTN);
        profileBTN.setOnClickListener(v -> presenter.onProfileBtnClicked());

        ImageButton CarInfoB = findViewById(R.id.CarInfoBtn);
        CarInfoB.setOnClickListener(v -> presenter.onCarInfoBtnClicked());

        ImageButton HomeBtn = findViewById(R.id.HomeButton);
        HomeBtn.setOnClickListener(v -> presenter.onHomeBtnClicked());

        presenter.initProfile();
    }

    public void setUserEmail(String email) {
        TextView userEmail = findViewById(R.id.userEmail);
        userEmail.setText(email);
    }

    public void setUserName(String userName) {
        TextView userNameTextView = findViewById(R.id.userName);
        userNameTextView.setText(userName);
    }

    public void setPresenter(ProfilePresenter presenter) {
        this.presenter = presenter;
    }
}
