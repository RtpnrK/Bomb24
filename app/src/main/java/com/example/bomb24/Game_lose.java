package com.example.bomb24;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class Game_lose extends Game_win {
        private String gameMode;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lose);
            TextView score_tv = findViewById(R.id.score);
            Button changeDff_bt = findViewById(R.id.changeDff_bt);
            Button retry_bt = findViewById(R.id.retry_bt);
            retry_bt.setOnClickListener(this::next);
            changeDff_bt.setOnClickListener(this::changeDifficulty);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            gameMode = getIntent().getStringExtra("gameMode");
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
            startActivity(intent);
            finish();
        }

        @Override
        public void onBackPressed() {
        }
    }

