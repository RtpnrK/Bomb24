package com.example.bomb24;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class game_normal extends game_easy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mode_tv.setText("Game mode: Normal");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cdt = new CountDownTimer(120000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        String strTime = String.valueOf(millisUntilFinished / 1000);
                        //strTime เปลี่ยนเป็นปุ่มกดหน้าก่อนเข้าไปเล่นเกม
                        time_tv.setText(strTime);
                    }

                    public void onFinish() {
                        time_tv.setText("0");
                        result_tv.setText("Time Out!");
                    }
                };
                cdt.start();
            }
        }, 1000);
    }
}