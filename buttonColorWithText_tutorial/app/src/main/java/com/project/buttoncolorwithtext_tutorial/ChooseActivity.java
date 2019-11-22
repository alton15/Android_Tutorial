package com.project.buttoncolorwithtext_tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {

    Button btn_colorPick;
    EditText edt_diary;
    ImageView img_color;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        btn_colorPick = findViewById(R.id.btn_colorPick);
        btn_colorPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, ImagesActivity.class);
                startActivity(intent);
            }
        });

        edt_diary = findViewById(R.id.edt_diary);

        img_color = findViewById(R.id.img_color);

    }
}
