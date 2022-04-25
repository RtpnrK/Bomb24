package com.example.bomb24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Start extends AppCompatActivity {
    private Button blue_bt, red_bt, green_bt, yellow_bt;
    private TextView time_tv;
    private int intNum1, intNum2, intNum3, intNum4, score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        blue_bt = findViewById(R.id.blue_bt);
        red_bt = findViewById(R.id.red_bt);
        green_bt = findViewById(R.id.green_bt);
        yellow_bt = findViewById(R.id.yellow_bt);
        time_tv = findViewById(R.id.time_tv);
        String gameMode = getIntent().getStringExtra("gameMode");
        score = getIntent().getIntExtra("score",0);
        Intent intent;
        if (gameMode.equals("Easy")) {
            intent = new Intent(this, game_easy.class);
        } else if (gameMode.equals("Normal")) {
            intent = new Intent(this, game_normal.class);
        } else {
            intent = new Intent(this, game_hard.class);
        }
        while (true) {
            Random randNum = new Random();
            intNum1 = randNum.nextInt(9) + 1;
            intNum2 = randNum.nextInt(9) + 1;
            intNum3 = randNum.nextInt(9) + 1;
            intNum4 = randNum.nextInt(9) + 1;
            int[] numSet = new int[]{intNum1, intNum2, intNum3, intNum4};
            if (new UnsolvableSet().isSolvable(numSet)) {
                System.out.println("Solvable");
                break;
            }
        }
        String num1 = String.valueOf(intNum1);
        String num2 = String.valueOf(intNum2);
        String num3 = String.valueOf(intNum3);
        String num4 = String.valueOf(intNum4);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                blue_bt.setBackground(getDrawable(R.drawable.blue_button));
                blue_bt.setText(String.valueOf(intNum1));
            }
        },1000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                yellow_bt.setBackground(getDrawable(R.drawable.yellow_button));
                yellow_bt.setText(String.valueOf(intNum4));
            }
        },2000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                red_bt.setBackground(getDrawable(R.drawable.red_button));
                red_bt.setText(String.valueOf(intNum2));
            }
        },3000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                green_bt.setBackground(getDrawable(R.drawable.green_button));
                green_bt.setText(String.valueOf(intNum3));
            }
        },4000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time_tv.setText("Start!");
            }
        },5000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent.putExtra("num1", num1);
                intent.putExtra("num2", num2);
                intent.putExtra("num3", num3);
                intent.putExtra("num4", num4);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();
            }
        },6000);
    }

    @Override
    public void onBackPressed() {
    }

}