package com.example.bomb24;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class game_easy extends AppCompatActivity {
    protected Button blue_bt, red_bt, green_bt, yellow_bt, plus_bt, minus_bt, multiply_bt, divide_bt,
            power_bt, open_bt, close_bt, undo_bt, clear_bt, enter_bt, resume_bt, change_bt, mainMenu_bt;
    protected ImageView background, menu_bt;
    protected TextView result_tv, time_tv, ans_tv, mode_tv;
    protected ArrayList<Button> numAL, opAL, allAL;
    protected CountDownTimer cdt;
    protected boolean gameWin;
    protected long startTimeMillis, currentTimeMillis;
    protected int score = 0;
    protected String highScore = " ";
    protected String gameMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gameMode = "Easy";
        Handler handler = new Handler();
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
        time_tv = findViewById(R.id.time_tv);
        ans_tv = findViewById(R.id.ans_tv);
        mode_tv = findViewById(R.id.mode_tv);
        enter_bt = findViewById(R.id.enter_bt);
        background = findViewById(R.id.blur_background);
        resume_bt = findViewById(R.id.resume_bt);
        change_bt = findViewById(R.id.change_bt);
        mainMenu_bt = findViewById(R.id.mainMenu_bt);
        menu_bt = findViewById(R.id.menu_bt);
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
        allAL.add(power_bt);
        allAL.add(open_bt);
        allAL.add(close_bt);
        allAL.add(undo_bt);
        allAL.add(clear_bt);
        allAL.add(enter_bt);
        mode_tv.setText("Game mode: Easy");
        time_tv.setText("Start!");
        startTimeMillis = 180000;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timeUpdate(startTimeMillis);
            }
        },1000);
        String num1 = getIntent().getStringExtra("num1");
        String num2 = getIntent().getStringExtra("num2");
        String num3 = getIntent().getStringExtra("num3");
        String num4 = getIntent().getStringExtra("num4");
        blue_bt.setText(num1);
        red_bt.setText(num2);
        green_bt.setText(num3);
        yellow_bt.setText(num4);
        result_tv.setText("");
    }

    public void timeUpdate(long timeInMillis) {
        cdt = new CountDownTimer(timeInMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                currentTimeMillis = millisUntilFinished;
                timeFormat();
            }
            public void onFinish() {
                time_tv.setText("0");
                result_tv.setText("Time Out!");
                gameOver();
            }
        };
        cdt.start();
    }

    public void timeFormat() {
        int minutes = (int) (currentTimeMillis / 1000) / 60;
        int seconds = (int) (currentTimeMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d" , minutes, seconds);
        time_tv.setText(timeFormatted);
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

    public void openParentheses(View v) {
        result_tv.append("( ");
        blue_bt.setEnabled(true);
        red_bt.setEnabled(true);
        green_bt.setEnabled(true);
        yellow_bt.setEnabled(true);
        disableBT(numAL);
    }

    public void closeParentheses(View v) {
        result_tv.append(") ");
        blue_bt.setEnabled(true);
        red_bt.setEnabled(true);
        green_bt.setEnabled(true);
        yellow_bt.setEnabled(true);
        disableBT(numAL);
    }

    public void undo(View v) {
        ans_tv.setText("");
        if (numAL.size() != 0) {
            String[] temp = result_tv.getText().toString().split(" ");
            String text = "";
            for (int i = 0; i < temp.length - 1; i++) {
                text = text + temp[i] + " ";
            }
            boolean isOP = checkAL(temp[temp.length - 1], opAL);
            result_tv.setText(text);
            if (isOP) {
                enableBT(opAL);
            } else {
                enableBT(allAL);
                disableBT(numAL);
                disableBT(opAL);
                numAL.get(numAL.size() - 1).setEnabled(true);
                numAL.remove(numAL.size() - 1);
            }
        }
        }

    public void clear(View v) {
        result_tv.setText("");
        ans_tv.setText("");
        enableBT(allAL);
        disableBT(opAL);
        numAL.clear();
    }

    public void menuOpen(View v) {
        for (Button b : allAL) {
            b.setClickable(false);
        }
        background.setVisibility(View.VISIBLE);
        resume_bt.setVisibility(View.VISIBLE);
        change_bt.setVisibility(View.VISIBLE);
        mainMenu_bt.setVisibility(View.VISIBLE);
        menu_bt.setVisibility(View.INVISIBLE);
    }

    public void resume(View v) {
        for (Button b : allAL) {
            b.setClickable(true);
        }
        background.setVisibility(View.INVISIBLE);
        resume_bt.setVisibility(View.INVISIBLE);
        change_bt.setVisibility(View.INVISIBLE);
        mainMenu_bt.setVisibility(View.INVISIBLE);
        menu_bt.setVisibility(View.VISIBLE);
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

    public void mainMenu(View v) {
        new AlertDialog.Builder(this).setMessage("Do you want to go back to main menu")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", null)
                .show();
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

    public static boolean checkAL(String s, ArrayList<Button> aL) {
        for (int i = 0; i < aL.size(); i++) {
            if (s.equals(aL.get(i).getText())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {

    }

    @SuppressLint("SetTextI18n")
    public void showAns(View v) {
        try{
            String exp = result_tv.getText().toString();
            ExpressionBuilder eb = new ExpressionBuilder(exp);
            Expression e = eb.build();
            @SuppressLint("DefaultLocale") String ans = String.format("%.2f", e.evaluate());
            if (numAL.size() == 4) {
                if (e.evaluate() == 24) {
                    gameWin = true;
                    ans_tv.setText(ans);
                    result_tv.setText("Bomb Defuse!");
                    result_tv.setTextColor(Color.GREEN);
                    ans_tv.setTextColor(Color.GREEN);
                    disableBT(allAL);
                    score++;
                    gameOver();
                } else {
                    gameWin = false;
                    ans_tv.setText(ans);
                    result_tv.setText("Try again!");
                    disableBT(allAL);
                    clear_bt.setEnabled(true);
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

    public void gameOver() {
        Intent intent;
        if (gameWin) {
            intent = new Intent(this, Game_win.class);
        } else {
            intent = new Intent(this, Game_lose.class);
        }
        intent.putExtra("gameMode", gameMode);
        intent.putExtra("score", score);
        cdt.cancel();
        time_tv.setText("");
        Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent,b);
            }
        },2000);
    }
}