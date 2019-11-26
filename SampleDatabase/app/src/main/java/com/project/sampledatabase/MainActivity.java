package com.project.sampledatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    SQLiteDatabase database;

    EditText editText2;
    String tableName;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        textView.findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String databaseName = editText.getText().toString();
                createDatabase(databaseName);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableName = editText2.getText().toString();
                createTable(tableName);
                insertRecord();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeQuery();
            }
        });
    }

    private void createDatabase(String name) {
        database = openOrCreateDatabase(name, MODE_PRIVATE, null);
    }

    private void createTable(String name) {
        if(database == null) {
            return;
        }
        database.execSQL("create table if not exists "+name
                + "("
                + "_id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + "age integer, "
                + "mobile text"
                + ")"
        );
    }

    private void insertRecord() {
        if (database == null) return;
        if (tableName == null) return;
        database.execSQL(
                "insert into " + tableName
                + "(name, age, mobile) "
                + " values "
                + "( 'John' , 20 , '010-1000-1000' )"
        );
    }

    public void printEvent(String msg) {
        textView.append(msg + "\n");
    }

    public void executeQuery() {
        printEvent("excuteQuery 호출됨.");
        int recordCount = 0;
        Cursor cursor;

        try {
            cursor = database.rawQuery(
                    "select * from " + tableName, null);
            recordCount = cursor.getCount();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < recordCount; i++) {
            cursor.moveToNext();
            int fieldNo = 0;
            int id = cursor.getInt(fieldNo++);
            stringBuilder.append(Integer.toString(id)+ " : ");
            String name = cursor.getString(fieldNo++);
            stringBuilder.append(name + " , ");

            int age = cursor.getInt(fieldNo++);
            stringBuilder.append(Integer.toString(age) + " , ");
            String mobile = cursor.getString(fieldNo++);
            stringBuilder.append(mobile);
            printEvent(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }
        cursor.close();
    }

}
