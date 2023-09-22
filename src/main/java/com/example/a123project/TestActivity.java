package com.example.a123project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TestActivity extends AppCompatActivity {

    EditText lgUsername;
    EditText lgPassword;

    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        lgUsername = findViewById(R.id.log_username);
        lgPassword = findViewById(R.id.log_password);
        b2 = findViewById(R.id.btn_login);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TestActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });
    }
}