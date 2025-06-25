package com.example.frogger;


import static com.example.frogger.map.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.frogger.map.MapLayout.TILE_WIDTH_PIXELS;

import android.content.Context;
import android.graphics.Canvas;

public class Rectangle {
    private double positionX;
    private double positionY;
    private int length;
    private double left;
    private double right;
    private double top;
    private double bottom;
    private int rateX;

    public Rectangle (double positionX, double positionY, int length) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.length = length;
        updateBounds();
    }

    private void updateBounds() {
        this.left = positionX + 1;
        this.right = positionX + (length * TILE_WIDTH_PIXELS) - 1;
        this.top = positionY + 1;
        this.bottom = positionY + TILE_HEIGHT_PIXELS - 1;
    }
    public double getPositionX () {
        return positionX;
    }
    public void setPositionX (double positionX) {
        this.positionX = positionX;
        updateBounds();

    }

    public void incPositionX (int moveX) {
        rateX = moveX;
        positionX += moveX;
        updateBounds();

    }

    public double getPositionY() {
        return positionY;
    }
    public void setPositionY (double positionY) {
        this.positionY = positionY;
        updateBounds();

    }

    public void incPositionY(int moveY) {
        positionY += moveY;
        updateBounds();

    }

    public boolean intersects (Rectangle other) {
        return !(this.left > other.right || this.right < other.left || this.top > other.bottom ||
                this.bottom < other.top);
    }


    public int getRate() {
        return rateX;
    }

    public double getLeft() {
        return this.left;
    }
    public double getRight() {
        return this.right;
    }

    public double getTop() {
        return this.top;
    }
    public double getBottom() {
        return this.bottom;
    }
}