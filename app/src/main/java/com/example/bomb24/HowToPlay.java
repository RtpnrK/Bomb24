package com.example.bomb24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HowToPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button back_bt;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        back_bt = findViewById(R.id.back_bt);
    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}