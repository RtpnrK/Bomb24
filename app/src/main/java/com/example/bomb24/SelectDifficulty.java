package com.example.bomb24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectDifficulty extends AppCompatActivity {
    private TextView detail_tv;
    private Button easy_bt, normal_bt, hard_bt, next_bt, back_bt;
    private Intent next_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_diificulty);
        detail_tv = findViewById(R.id.detail_tv);
        easy_bt = findViewById(R.id.easy_bt);
        normal_bt = findViewById(R.id.normal_bt);
        hard_bt = findViewById(R.id.hard_bt);
        next_bt = findViewById(R.id.next_bt);
    }

    public void easy(View v) {
        v.setEnabled(false);
        next_bt.setEnabled(true);
        normal_bt.setEnabled(true);
        hard_bt.setEnabled(true);
        detail_tv.setText("Time will not decrease if the answer is wrong.");
        next_intent = new Intent(this, game_easy.class);
    }

    public void normal(View v) {
        v.setEnabled(false);
        next_bt.setEnabled(true);
        easy_bt.setEnabled(true);
        hard_bt.setEnabled(true);
        detail_tv.setText("Time will decrease if the answer is wrong.");
        next_intent = new Intent(this, game_normal.class);
    }

    public void hard(View v) {
        v.setEnabled(false);
        next_bt.setEnabled(true);
        easy_bt.setEnabled(true);
        normal_bt.setEnabled(true);
        detail_tv.setText("Game will over if the answer is wrong.");
        next_intent = new Intent(this, game_hard.class);
    }

    public void back(View v) {
        Intent back_intent = new Intent(this, MainActivity.class);
        startActivity(back_intent);
    }

    public void next(View v) {
        startActivity(next_intent);
    }
}