package com.example.a123project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Email;
    EditText Username;
    EditText Password;

    String NameHolder, EmailHolder, UsernameHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";

    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.te_firstname);
        Email = findViewById(R.id.te_email);
        Username = findViewById(R.id.te_username);
        Password = findViewById(R.id.te_password);
        b1 = findViewById(R.id.page1);
        sqLiteHelper = new SQLiteHelper(this);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      Intent i = new Intent(MainActivity.this, TestActivity.class);
                                      startActivity(i);
                                  }
                              }
        );

    }
}