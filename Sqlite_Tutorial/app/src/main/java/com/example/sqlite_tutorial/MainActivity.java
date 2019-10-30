package com.example.sqlite_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqLiteDatabase = init_database();

        init_tables();

        load_values();

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_values();
            }
        });

        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete_values();
            }
        });
    }

    private SQLiteDatabase init_database() {

        SQLiteDatabase db = null;

        File file = new File(getFilesDir(), "contact.db");

        System.out.println("PATH : " + file.toString());
        try {
            db = SQLiteDatabase.openOrCreateDatabase(file, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(db == null) {
            System.out.println("DB creation failed." + file.getAbsolutePath());
        }

        return db;
    }

    private void init_tables() {

        if(sqLiteDatabase != null) {
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS CONTACT_T (" +
                    "NO "    + "INTEGER NOT NULL," +
                    "NAME"   + "TEXT," +
                    "PHONE " + "TEXT," +
                    "OVER20 "+ "INTEGER" + ")";
            System.out.println(sqlCreateTable);

            sqLiteDatabase.execSQL(sqlCreateTable);
        }
    }

    private void load_values() {
        if(sqLiteDatabase != null) {
            String sqlQueryTable = "SELECT * FROM CONTACT_T";
            Cursor cursor = null;

            cursor = sqLiteDatabase.rawQuery(sqlQueryTable, null);

            if(cursor.moveToNext()) {
                int no = cursor.getInt(0);
                EditText editTextNo = findViewById(R.id.editTextNo);
                editTextNo.setText(Integer.toString(no));

                String name = cursor.getString(1);
                EditText editTextName = findViewById(R.id.editTextName);
                editTextName.setText(name);

                String phone = cursor.getString(2);
                EditText editTextPhone = findViewById(R.id.editTextPhone);
                editTextPhone.setText(phone);

                int over20 = cursor.getInt(3);
                CheckBox checkBoxOver20 = findViewById(R.id.checkBoxOver20);
                if(over20 == 0) {
                    checkBoxOver20.setChecked(false);
                } else {
                    checkBoxOver20.setChecked(true);
                }
            }
        }
    }

    private void save_values() {
        if(sqLiteDatabase != null) {
            sqLiteDatabase.execSQL("DELETE FROM CONTACT_T");

            EditText editTextNo = findViewById(R.id.editTextNo);
            String noText = editTextNo.getText().toString();
            int no = 0;
            if(noText != null && !noText.isEmpty()) {
                no = Integer.parseInt(noText);
            }

            EditText editTextName = findViewById(R.id.editTextName);
            String name = editTextName.getText().toString();

            EditText editTextPhone = findViewById(R.id.editTextPhone);
            String phone = editTextPhone.getText().toString();

            CheckBox checkBoxOver20 = findViewById(R.id.checkBoxOver20);
            boolean isOver20 = checkBoxOver20.isChecked();

            String sqlInsert = "INSERT INTO CONTACT_T " +
                    "(NO, NAME, PHONE, OVER20) VALUES (" +
                    Integer.toString(no) + "," +
                    "'" + name + "'," +
                    "'" + phone + "'," +
                    ((isOver20 == true) ? "1" : "0") + ")";

            System.out.println(sqlInsert);

            sqLiteDatabase.execSQL(sqlInsert);
        }
    }

    private void delete_values() {
        if(sqLiteDatabase != null) {
            String sqlDelete = "DELETE FROM CONTACT_T";

            sqLiteDatabase.execSQL(sqlDelete);

            EditText editTextNo = findViewById(R.id.editTextNo) ;
            editTextNo.setText("") ;

            EditText editTextName = findViewById(R.id.editTextName) ;
            editTextName.setText("") ;

            EditText editTextPhone = findViewById(R.id.editTextPhone) ;
            editTextPhone.setText("") ;

            CheckBox checkBoxOver20 = findViewById(R.id.checkBoxOver20) ;
            checkBoxOver20.setChecked(false) ;
        }
    }

}
