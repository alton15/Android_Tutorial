package com.example.tutorial_calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        tv_result = findViewById(R.id.tv_result);
    }

    public void plusClick(View V) {
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        tv_result.setText(Integer.toString(n1 + n2));
    }

    public void minusClick(View V) {
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        tv_result.setText(Integer.toString(n1 - n2));
    }

    public void multiplicationClick(View V) {
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        tv_result.setText(Integer.toString(n1 * n2));
    }

    public void divisionClick(View V) {
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        tv_result.setText(Integer.toString(n1 / n2));
    }
}
