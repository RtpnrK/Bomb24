package com.example.bomb24;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.Random;

public class game_easy extends AppCompatActivity {
    protected Button blue_bt, red_bt, green_bt, yellow_bt, plus_bt, minus_bt, multiply_bt, divide_bt,
            power_bt, open_bt, close_bt, undo_bt, clear_bt;
    protected TextView result_tv, time_tv;
    protected ArrayList<Button> numAL, opAL, allAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        numAL = new ArrayList<Button>();
        opAL = new ArrayList<Button>();
        allAL = new ArrayList<Button>();
        result_tv = findViewById(R.id.result_tv);
        blue_bt = findViewById(R.id.blue_bt);
        red_bt = findViewById(R.id.red_bt);
        green_bt = findViewById(R.id.green_bt);
        yellow_bt = findViewById(R.id.yellow_bt);
        plus_bt = findViewById(R.id.plus_bt);
        minus_bt = findViewById(R.id.minus_bt);
        multiply_bt = findViewById(R.id.multiply_bt);
        divide_bt = findViewById(R.id.divide_bt);
        power_bt = findViewById(R.id.power_bt);
        open_bt = findViewById(R.id.open_bt);
        close_bt = findViewById(R.id.close_bt);
        undo_bt = findViewById(R.id.undo_bt);
        clear_bt = findViewById(R.id.clear_bt);
        opAL.add(plus_bt);
        opAL.add(minus_bt);
        opAL.add(multiply_bt);
        opAL.add(divide_bt);
        opAL.add(power_bt);
        allAL.add(blue_bt);
        allAL.add(red_bt);
        allAL.add(green_bt);
        allAL.add(yellow_bt);
        allAL.add(plus_bt);
        allAL.add(minus_bt);
        allAL.add(multiply_bt);
        allAL.add(divide_bt);
        allAL.add(open_bt);
        allAL.add(close_bt);
        allAL.add(undo_bt);
        allAL.add(clear_bt);
        Random randNum = new Random();
        String num1 = String.valueOf(randNum.nextInt(10));
        String num2 = String.valueOf(randNum.nextInt(10));
        String num3 = String.valueOf(randNum.nextInt(10));
        String num4 = String.valueOf(randNum.nextInt(10));
        blue_bt.setText(num1);
        red_bt.setText(num2);
        green_bt.setText(num3);
        yellow_bt.setText(num4);
        result_tv.setText("");
    }

    public void blueClick(View v) {
        numAL.add(blue_bt);
        v.setEnabled(false);
        red_bt.setEnabled(false);
        green_bt.setEnabled(false);
        yellow_bt.setEnabled(false);
        result_tv.append(blue_bt.getText() + " ");
        if (numAL.size() == 4) {
            disableBT(opAL);
        } else {
            enableBT(opAL);
        }
    }

    public void redClick(View v) {
        numAL.add(red_bt);
        v.setEnabled(false);
        blue_bt.setEnabled(false);
        green_bt.setEnabled(false);
        yellow_bt.setEnabled(false);
        result_tv.append(red_bt.getText() + " ");
        if (numAL.size() == 4) {
            disableBT(opAL);
        } else {
            enableBT(opAL);
        }
    }

    public void greenClick(View v) {
        numAL.add(green_bt);
        v.setEnabled(false);
        red_bt.setEnabled(false);
        blue_bt.setEnabled(false);
        yellow_bt.setEnabled(false);
        result_tv.append(green_bt.getText() + " ");
        if (numAL.size() == 4) {
            disableBT(opAL);
        } else {
            enableBT(opAL);
        }
    }

    public void yellowClick(View v) {
        numAL.add(yellow_bt);
        v.setEnabled(false);
        red_bt.setEnabled(false);
        green_bt.setEnabled(false);
        blue_bt.setEnabled(false);
        result_tv.append(yellow_bt.getText() + " ");
        if (numAL.size() == 4) {
            disableBT(opAL);
        } else {
            enableBT(opAL);
        }
    }

    public void plus(View v) {
        disableBT(opAL);
        result_tv.append(plus_bt.getText() + " ");
        blue_bt.setEnabled(true);
        red_bt.setEnabled(true);
        green_bt.setEnabled(true);
        yellow_bt.setEnabled(true);
        disableBT(numAL);
    }

    public void minus(View v) {
        disableBT(opAL);
        result_tv.append(minus_bt.getText() + " ");
        blue_bt.setEnabled(true);
        red_bt.setEnabled(true);
        green_bt.setEnabled(true);
        yellow_bt.setEnabled(true);
        disableBT(numAL);
    }

    public void multiply(View v) {
        disableBT(opAL);
        result_tv.append(multiply_bt.getText() + " ");
        blue_bt.setEnabled(true);
        red_bt.setEnabled(true);
        green_bt.setEnabled(true);
        yellow_bt.setEnabled(true);
        disableBT(numAL);
    }

    public void divide(View v) {
        disableBT(opAL);
        result_tv.append(divide_bt.getText() + " ");
        blue_bt.setEnabled(true);
        red_bt.setEnabled(true);
        green_bt.setEnabled(true);
        yellow_bt.setEnabled(true);
        disableBT(numAL);
    }

    public void power(View v) {
        disableBT(opAL);
        result_tv.append(power_bt.getText() + " ");
        blue_bt.setEnabled(true);
        red_bt.setEnabled(true);
        green_bt.setEnabled(true);
        yellow_bt.setEnabled(true);
        disableBT(numAL);
    }

    public void openPara(View v) {
        result_tv.append("( ");
        blue_bt.setEnabled(true);
        red_bt.setEnabled(true);
        green_bt.setEnabled(true);
        yellow_bt.setEnabled(true);
        disableBT(numAL);
    }

    public void closePara(View v) {
        result_tv.append(") ");
        blue_bt.setEnabled(true);
        red_bt.setEnabled(true);
        green_bt.setEnabled(true);
        yellow_bt.setEnabled(true);
        disableBT(numAL);
    }

    public void undo(View v) {
        String[] temp = result_tv.getText().toString().split(" ");
        String text = "";
        for (int i = 0; i < temp.length - 1; i++) {
            text = text + temp[i] + " ";
        }
        result_tv.setText(text);
    }

    public void clear(View v) {
        result_tv.setText("");
        enableBT(allAL);
        numAL.clear();
    }

    public static void enableBT(ArrayList<Button> btAL) {
        for (Button b : btAL) {
            b.setEnabled(true);
        }
    }

    public static void disableBT(ArrayList<Button> btAL) {
        for (Button b : btAL) {
            b.setEnabled(false);
        }
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
                    result_tv.setText(ans + ", You Win!");
                    disableBT(allAL);
                } else {
                    result_tv.setText(ans + ", try again");
                    disableBT(allAL);
                    clear_bt.setEnabled(true);
                }
            } else {
                result_tv.setText(ans + " ");
                enableBT(opAL);
            }
        } catch (Exception e) {
            result_tv.setText("ERROR!");
            disableBT(allAL);
            clear_bt.setEnabled(true);
        }
    }
}