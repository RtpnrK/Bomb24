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
    protected SharedPreferences.Editor editor;
    protected int currentScore;
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
        int score = getIntent().getIntExtra("score", 0);
        SharedPreferences settings = getSharedPreferences("GAME_DATA", MODE_PRIVATE );
        currentScore = settings.getInt("CURRENT_SCORE", 0) + score;
        editor = settings.edit();
        editor.putInt("CURRENT_SCORE", currentScore);
        editor.commit();
        score_tv.setText(String.valueOf(currentScore));
        highScore_tv.setText(String.valueOf(currentScore));
        }


    public void changeDifficulty(View v) {
        editor.remove("CURRENT_SCORE");
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
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
    }
}