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
        enter_bt.setOnClickListener(this::showAns);
        startTimeMillis = 120000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cdt.cancel();
                timeUpdate(startTimeMillis);
            }
        },1000);
    }

    @SuppressLint("SetTextI18n")
    public void showAns(View v) {
        try {
            String exp = result_tv.getText().toString();
            ExpressionBuilder eb = new ExpressionBuilder(exp);
            Expression e = eb.build();
            @SuppressLint("DefaultLocale") String ans = String.format("%.2f", e.evaluate());
            if (numAL.size() == 4) {
                if (e.evaluate() == 24) {
                    gameWin = true;
                    ans_tv.setText(ans);
                    result_tv.setText("Bomb Defuse!");
                    time_tv.setTextColor(Color.GREEN);
                    ans_tv.setTextColor(Color.GREEN);
                    disableBT(allAL);
                    gameOver();
                } else {
                    gameWin = false;
                    ans_tv.setText(ans);
                    result_tv.setText("Try again!");
                    disableBT(allAL);
                    clear_bt.setEnabled(true);
                    currentTimeMillis -= 10000;
                    cdt.cancel();
                    timeUpdate(currentTimeMillis);
                }
            } else {
                ans_tv.setText(ans + " ");
                enableBT(opAL);
            }
        } catch (Exception e) {
            ans_tv.setText("ERROR!");
            disableBT(allAL);
            clear_bt.setEnabled(true);
        }
    }
}