package com.project.asyncstep1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    Button btn_toast1, btn_toast2, btn_sleep, btn_task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);

        btn_toast1 = findViewById(R.id.btn_toast1);
        btn_toast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(btn_toast1);
            }
        });
        btn_toast2 = findViewById(R.id.btn_toast2);
        btn_toast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(btn_toast2);
            }
        });

        btn_sleep = findViewById(R.id.btn_sleep);
        btn_sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleepUntilFor(btn_sleep);
            }
        });

        btn_task = findViewById(R.id.btn_task);
        btn_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTask(btn_task);
            }
        });
    }

    public void displayToast(View v) {
        Button btn = (Button)v;
        String strMsg = btn.getText().toString();
        Toast.makeText(this, strMsg, Toast.LENGTH_SHORT).show();
    }

    public void sleepUntilFor(View v) {
        int s = 10000;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startTask(View v) {
        mTextView.setText("잠자는 중입니다.");
        new MyAsyncTask(mTextView).execute();
    }
}
