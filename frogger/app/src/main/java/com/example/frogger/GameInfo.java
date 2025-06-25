package com.example.frogger;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Point;
import android.os.Bundle;

public class GameInfo extends AppCompatActivity{
    private static String name;
    private static int lives;
    private static int difficulty;
    static int points;
    private static int sprite;
    private GameScreen game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get name, difficulty level, sprite from ConfigScreen
        name = getIntent().getStringExtra("keyname");
        difficulty = getIntent().getIntExtra("keydifficulty", 0);
        sprite = getIntent().getIntExtra("keysprite", 0);
        points = 0;
        //Lives is determine by 6 - difficulty level
        //Difficulty: 1, Lives: 5; Difficulty: 2, Lives: 4; Difficulty: 3, Lives: 3
        lives = 6 - difficulty;

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        game = new GameScreen(this);
        setContentView(game);
    }
    protected void onPause() {
        game.pause();
        super.onPause();
    }

    //Increase points according to the input amount
    public static void incPoints(int amount) {
        points += amount;
    }
    public static void decLives() {
        lives -= 1;
    }

    // Getters for game information
    public static int getSprite() {
        return sprite;
    }
    public static String getName() {
        return name;
    }
    public static int getPoints() {
        return points;
    }
    public static int getDif() {
        return difficulty;
    }

    public static int getLives() {
        return lives;
    }
}