package com.example.bomb24;

import android.os.Bundle;
import android.view.WindowManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HighScore extends game_easy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void CheckHighScore(){

        if (highScore.equals("")){

            highScore = this.getHighScore();
            highScoreTV.setText(highScore);
        }
        else if (score > Integer.parseInt(highScore)){
            highScore = String.valueOf(score);

            File scoreFile = new File("highScore.dat");
            if (!scoreFile.exists()){
                try {
                    scoreFile.createNewFile();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileWriter writerFile = null;
            BufferedWriter writer = null;

            try {
                writerFile = new FileWriter(scoreFile);
                writer = new BufferedWriter(writerFile);
                writer.write(this.highScore);
            } catch (Exception e) {
                e.printStackTrace();
            }

            finally {
                try {

                    if (writer != null)
                        writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public String getHighScore(){
        FileReader readFile = null;
        BufferedReader reader = null;
        try{
            readFile = new FileReader("highScore.dat");
            reader = new BufferedReader(readFile);
            return reader.readLine();

        }
        catch (Exception e) {
            return "0";
        }
        finally {
            try {

                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}