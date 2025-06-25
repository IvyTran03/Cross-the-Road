package com.example.frogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinScreen extends AppCompatActivity {
    private Button restart;
    private Button exit;

    private TextView gameScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);
        restart = findViewById(R.id.startOverButton);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WinScreen.this, ConfigScreen.class);
                startActivity(intent);
            }
        });
        exit=findViewById(R.id.exitButton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WinScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

        int highScore = getIntent().getIntExtra("keymaxscore", 0);
        gameScore = findViewById(R.id.highestScore);
        gameScore.setText(Integer.toString(highScore));
    }
}