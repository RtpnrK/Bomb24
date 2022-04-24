package com.example.bomb24;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void howToPlay(View view) {
        Intent intent = new Intent(this, HowToPlay.class);
        startActivity(intent);
    }

    public void selectDifficulty(View view) {
        Intent intent = new Intent(this, SelectDifficulty.class);
        startActivity(intent);
    }

    public void quit(View view) {
        alert(this);
    }

    @Override
    public void onBackPressed() {
        alert(this);
    }

    public void alert(Context context) {
        new AlertDialog.Builder(context).setMessage("Do you want to quit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}