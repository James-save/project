package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 隱藏標題欄
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // 設置佈局
        setContentView(R.layout.activity_main);

        // init UI setting
        ImageView leftCircleIcon = findViewById(R.id.leftCircleIcon);
        ImageView rightCircleIcon = findViewById(R.id.rightCircleIcon);
        Button buttonUp = findViewById(R.id.buttonUp);
        Button buttonDown = findViewById(R.id.buttonDown);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        Button buttonRight = findViewById(R.id.buttonRight);

        // create object of event handler
        TemperatureAndSmokeHandler tempSmokeHandler = new TemperatureAndSmokeHandler(leftCircleIcon, rightCircleIcon);
        ButtonHandler buttonHandler = new ButtonHandler();

        // Temp and smoke
        tempSmokeHandler.startMonitoring();

        // button event
        buttonUp.setOnClickListener(v -> buttonHandler.handleUp());
        buttonDown.setOnClickListener(v -> buttonHandler.handleDown());
        buttonLeft.setOnClickListener(v -> buttonHandler.handleLeft());
        buttonRight.setOnClickListener(v -> buttonHandler.handleRight());
    }
}