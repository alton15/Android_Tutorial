package com.example.changeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView text_name = findViewById(R.id.text_name);
        Intent intent = getIntent();
        text_name.setText(intent.getStringExtra("text_name").toString());
    }
}
