package com.example.frogger;

import android.content.Context;
import android.graphics.Canvas;

import com.example.frogger.graphics.Sprite;

public class Player extends Rectangle {
    private final Sprite sprite;
    static final double ORIGINAL_X = 490;
    static final double ORIGINAL_Y = 1764;


    public Player(double positionX, double positionY, int length, Sprite sprite) {
        super(positionX, positionY, length);
        this.sprite = sprite;
    }

    public void update() {
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        sprite.draw(canvas, (int) super.getPositionX(), (int) super.getPositionY());
    }


}