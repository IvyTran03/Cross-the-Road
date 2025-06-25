package com.example.frogger;

import android.content.Context;
import android.graphics.Canvas;

import com.example.frogger.graphics.Sprite;

public class Vehicle extends Rectangle{
    private Sprite sprite;

    public Vehicle(double positionX, double positionY, int length, Sprite sprite) {
        super(positionX, positionY, length);
        this.sprite = sprite;
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        sprite.draw(canvas, (int) super.getPositionX(), (int) super.getPositionY());
    }
}