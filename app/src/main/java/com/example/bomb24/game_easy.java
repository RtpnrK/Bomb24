package com.example.bomb24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class game_easy extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView show_tv;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        show_tv = findViewById(R.id.textView4);
        show_tv.setText("Easy");
    }
}