package com.example.frogger.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.frogger.R;
public class SpriteSheet {
    private static final int SPRITE_WIDTH_PIXELS = 98;
    private static final int SPRITE_HEIGHT_PIXELS = 98;

    private Bitmap bitmap;

    public SpriteSheet(Context context) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite_sheet98,
                bitmapOptions);
    }

    public Sprite getPlayerSprite(int index) {
        return new Sprite(this,
                new Rect((index - 1) * SPRITE_WIDTH_PIXELS,
                        0,
                        index * SPRITE_WIDTH_PIXELS,
                        SPRITE_HEIGHT_PIXELS)
        );
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
    public Sprite getSafeSprite() {
        return getSpriteByIndex(1, 0, 1);
    }
    public Sprite getRiverSprite() {
        return getSpriteByIndex(1, 1, 1);
    }
    public Sprite getRoadSprite() {
        return getSpriteByIndex(1, 2, 1);
    }
    public Sprite getBushSprite() {
        return getSpriteByIndex(1, 3, 1);
    }
    public Sprite getGoalSprite() {
        return getSpriteByIndex(1, 4, 1);
    }


    // Get vehicle sprites
    public Sprite getTruck1() {
        return getSpriteByIndex(3, 0, 3);
    }
    public Sprite getTruck2() {
        return getSpriteByIndex(4, 0, 5);
    }
    public Sprite getCar1() {
        return getSpriteByIndex(5, 0, 2);
    }
    public Sprite getCar2() {
        return getSpriteByIndex(6, 0, 2);
    }
    public Sprite getCar3() {
        return getSpriteByIndex(7, 0, 2);
    }

    //Get log sprites
    public Sprite getLog1() {
        return getSpriteByIndex(8, 0, 5);
    }
    public Sprite getLog2() {
        return getSpriteByIndex(9, 0, 3);
    }
    public Sprite getLog3() {
        return getSpriteByIndex(10, 0, 4);
    }


    private Sprite getSpriteByIndex(int row, int column, int length) {
        return new Sprite(this, new Rect(
                column * SPRITE_WIDTH_PIXELS,
                row * SPRITE_HEIGHT_PIXELS,
                (column + 1) * SPRITE_WIDTH_PIXELS * length,
                (row + 1) * SPRITE_HEIGHT_PIXELS
        ));
    }
}
