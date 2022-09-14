package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private String username;
    private String role;
    private TextView Username;
    private TextView Role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Username = findViewById(R.id.User_name);
        Role = findViewById(R.id.Role);
        Intent intent = getIntent();
        username = intent.getStringExtra("UserName");
        role = intent.getStringExtra("Role");
        Username.setText(username);
        Role.setText(role);

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
