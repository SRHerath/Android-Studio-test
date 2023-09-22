package com.example.a123project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewActivity extends AppCompatActivity {

    Button Dashboard;

    Button NewMat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Dashboard = findViewById(R.id.dashbtn);
        NewMat = findViewById(R.id.addmatbtn);


        Dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });

        NewMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewActivity.this, AddMaterials.class);
                startActivity(i);
            }
        });
    }
}