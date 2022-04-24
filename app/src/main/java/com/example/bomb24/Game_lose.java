package com.example.bomb24;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

    public class Game_lose extends AppCompatActivity {
        private String gameMode;
        private Button changeDff_bt, retry_bt;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lose);
            changeDff_bt = findViewById(R.id.changeDff_bt);
            changeDff_bt.setOnClickListener(this::changeDifficulty);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            gameMode = getIntent().getStringExtra("gameMode");
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
    }
