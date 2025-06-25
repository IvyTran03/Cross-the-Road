package com.example.frogger.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.frogger.graphics.Sprite;
import com.example.frogger.graphics.SpriteSheet;

public class BushTile extends Tile {
    private final Sprite sprite;

    public BushTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getBushSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
