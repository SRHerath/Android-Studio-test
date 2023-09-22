package com.example.a123project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMaterials extends AppCompatActivity {

    EditText MatID;
    EditText MatCode;
    EditText MatDesc;
    EditText MatQuantity;

    Button MatAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_materials);

        MatID = findViewById(R.id.mat_id);
        MatCode = findViewById(R.id.mat_code);
        MatDesc = findViewById(R.id.mat_des);
        MatQuantity = findViewById(R.id.mat_quan);
        MatAdd = findViewById(R.id.addmat);

        MatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(AddMaterials.this, ViewActivity.class);
               startActivity(i);
            }
        });

    }
}