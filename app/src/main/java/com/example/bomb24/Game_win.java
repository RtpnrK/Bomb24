package com.example.bomb24;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Game_win extends AppCompatActivity {
    private String gameMode;
    protected int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        Button next_bt = findViewById(R.id.win_next_bt);
        Button changeDff_bt = findViewById(R.id.changeDff_bt);
        next_bt.setOnClickListener(this::next);
        changeDff_bt.setOnClickListener(this::changeDifficulty);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gameMode = getIntent().getStringExtra("gameMode");
        TextView score_tv = findViewById(R.id.score);
        TextView highScore_tv = findViewById(R.id.highScore);
        score = getIntent().getIntExtra("score", 0);
        score_tv.setText(String.valueOf(score));
        }


    public void changeDifficulty(View v) {
        Intent intent = new Intent(this, SelectDifficulty.class);
        new AlertDialog.Builder(this).setMessage("Do you want to change difficulty")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void next(View v) {
        Intent intent = new Intent(this, Start.class);
        intent.putExtra("gameMode", gameMode);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
    }
}