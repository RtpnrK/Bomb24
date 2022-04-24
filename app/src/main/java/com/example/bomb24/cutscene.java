package com.example.bomb24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class cutscene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutscene);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button next_bt = findViewById(R.id.cutscene_next_bt);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                next_bt.setVisibility(View.VISIBLE);
            }
        },3000);
    }

    public void next(View v) {
        Intent intent = new Intent(this, Start.class);
        String gameMode = getIntent().getStringExtra("gameMode");
        intent.putExtra("gameMode", gameMode);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
    }
}