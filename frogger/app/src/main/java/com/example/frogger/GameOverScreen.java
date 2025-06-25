package com.example.frogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverScreen extends AppCompatActivity {
    private Button restart;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_screen);
        restart=findViewById(R.id.startover);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOverScreen.this, ConfigScreen.class);
                startActivity(intent);
            }
        });
        exit=findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOverScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView gameScore = findViewById(R.id.score);
        gameScore.setText(Integer.toString(GameInfo.getPoints()));
    }
}