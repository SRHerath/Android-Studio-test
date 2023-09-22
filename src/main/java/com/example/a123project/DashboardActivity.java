package com.example.a123project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button Addbuttn;
    Button Viewbuttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Addbuttn = findViewById(R.id.addbtn);
        Viewbuttn = findViewById(R.id.viwbtn);

        Addbuttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, AddMaterials.class);
                startActivity(i);
            }
        });

        Viewbuttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, ViewActivity.class);
                startActivity(i);
            }
        });
    }
}