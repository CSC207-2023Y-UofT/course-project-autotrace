package com.course_project_autotrace.ProfileAccessories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.course_project_autotrace.R;
import com.course_project_autotrace.UserProfile.ProfileView;

public class EditProfileScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_screen);
        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileScreen.this, ProfileView.class);
            startActivity(intent);
        });
    }
}