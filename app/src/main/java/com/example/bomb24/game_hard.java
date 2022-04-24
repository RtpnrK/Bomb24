package com.example.bomb24;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class game_hard extends game_normal {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mode_tv.setText("Game mode: Hard");
        gameMode = "Hard";
        enter_bt.setOnClickListener(this::showAns);
    }

    @SuppressLint("SetTextI18n")
    public void showAns(View v) {
        try {
            String exp = result_tv.getText().toString();
            ExpressionBuilder eb = new ExpressionBuilder(exp);
            Intent intent;
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
                    result_tv.setText("Game Over!");
                    disableBT(allAL);
                    clear_bt.setEnabled(true);
                    cdt.cancel();
                    time_tv.setText("");
                    gameOver();
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