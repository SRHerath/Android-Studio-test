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

public class RegisterActivity extends AppCompatActivity {

    EditText Name;
    EditText Email;
    EditText Username;
    EditText Password;
    //EditText teConPassword;

    String NameHolder, EmailHolder, UsernameHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";
    Button b3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name = findViewById(R.id.te_name);
        Email = findViewById(R.id.te_email);
        Username = findViewById(R.id.te_username);
        Password = findViewById(R.id.te_password);
        // teConPassword = findViewById(R.id.te_con_password);
        b3 = findViewById(R.id.page2);
        sqLiteHelper = new SQLiteHelper(this);

        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      // Creating SQLite database if dose n't exists
                                      SQLiteDataBaseBuild();
                                      // Creating SQLite table if dose n't exists.
                                      SQLiteTableBuild();
                                      // Checking EditText is empty or Not.
                                      CheckEditTextStatus();
                                      // Method to check Email is already exists or not.
                                      CheckingEmailAlreadyExistsOrNot();
                                      // Empty EditText After done inserting process.
                                      EmptyEditTextAfterDataInsert();

                                  }
                              }
        );

    }

    private void SQLiteDataBaseBuild() {
        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }


    private void SQLiteTableBuild() {
        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAME + "(" + SQLiteHelper.Table_Column_ID + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + SQLiteHelper.Table_Column_1_Name + " VARCHAR, " + SQLiteHelper.Table_Column_2_Name + " VARCHAR, " + SQLiteHelper.Table_Column_3_name + " VARCHAR, " + SQLiteHelper.Table_Column_4_Password + " VARCHAR);");
    }


    public void InsertDataIntoSQLiteDatabase() {
        // If editText is not empty then this block will executed.
        if (EditTextEmptyHolder == true) {
            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (Name,Email,Username,Password) VALUES('" + NameHolder + "', '" + EmailHolder + "','" + UsernameHolder + "', '" + PasswordHolder + "');";
            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
            // Closing SQLite database object.
            sqLiteDatabaseObj.close();
            // Printing toast message after done inserting.
            Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
        }
        // This block will execute if any of the registration EditText is empty.
        else {
            // Printing toast message if any of EditText is empty.
            Toast.makeText(RegisterActivity.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
        }
    }

    private void EmptyEditTextAfterDataInsert() {
        Name.getText().clear();
        Email.getText().clear();
        Username.getText().clear();
        Password.getText().clear();
    }

    private void CheckEditTextStatus() {
        NameHolder = Name.getText().toString();
        EmailHolder = Email.getText().toString();
        UsernameHolder = Username.getText().toString();
        PasswordHolder = Password.getText().toString();
        if (TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(UsernameHolder) || TextUtils.isEmpty(PasswordHolder)) {
            EditTextEmptyHolder = false;
        } else {
            EditTextEmptyHolder = true;
        }
    }


    private void CheckingEmailAlreadyExistsOrNot() {
        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Name + "=?", new String[]{EmailHolder}, null, null, null);
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                cursor.moveToFirst();
                // If Email is already exists then Result variable value set as Email Found.
                F_Result = "Email Found";
                // Closing cursor.
                cursor.close();
            }
        }
// Calling method to check final result and insert data into SQLite database.
        CheckFinalResult();

    }

    private void CheckFinalResult() {
        // Checking whether email is already exists or not.
        if(F_Result.equalsIgnoreCase("Email Found"))
        {
            // If email is exists then toast msg will display.
            Toast.makeText(RegisterActivity.this,"Email Already Exists",Toast.LENGTH_LONG).show();
        }
        else {
            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();
        }
        F_Result = "Not_Found" ;
    }
}

