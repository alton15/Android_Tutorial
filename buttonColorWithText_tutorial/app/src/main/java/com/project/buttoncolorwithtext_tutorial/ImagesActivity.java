package com.project.buttoncolorwithtext_tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImagesActivity extends AppCompatActivity {

    ImageView img_happy, img_sad, img_upset, img_fun, img_regret, img_shame, img_lovely, img_soso, img_complexity, img_depress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        img_happy = findViewById(R.id.img_happy);
        img_sad = findViewById(R.id.img_sad);
        img_upset = findViewById(R.id.img_upset);
        img_fun = findViewById(R.id.img_fun);
        img_regret = findViewById(R.id.img_regret);
        img_shame = findViewById(R.id.img_shame);
        img_lovely = findViewById(R.id.img_lovely);
        img_soso = findViewById(R.id.img_soso);
        img_complexity = findViewById(R.id.img_complexity);
        img_depress = findViewById(R.id.img_depress);

    }

}
