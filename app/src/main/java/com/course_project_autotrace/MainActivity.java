package com.course_project_autotrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button move = findViewById(R.id.Move);
        move.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginScreen.class);
            startActivity(intent);
        });
    }
}