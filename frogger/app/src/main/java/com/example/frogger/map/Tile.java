package com.example.frogger.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.frogger.graphics.SpriteSheet;

abstract class Tile {
    protected final Rect mapLocationRect;

    public Tile(Rect mapLocationRect) {
        this.mapLocationRect = mapLocationRect;
    }

    public enum TileType {
        SAFE_TILE,
        RIVER_TILE,
        ROAD_TILE,
        BUSH_TILE,
        GOAL_TILE
    }
    public static Tile getTile(int tileIndex, SpriteSheet spriteSheet, Rect mapLocationRect) {
        switch(TileType.values()[tileIndex]) {
            case SAFE_TILE:
                return new SafeTile(spriteSheet, mapLocationRect);
            case RIVER_TILE:
                return new RiverTile(spriteSheet, mapLocationRect);
            case ROAD_TILE:
                return new RoadTile(spriteSheet, mapLocationRect);
            case BUSH_TILE:
                return new BushTile(spriteSheet, mapLocationRect);
            case GOAL_TILE:
                return new GoalTile(spriteSheet, mapLocationRect);
            default:
                return null;
        }
    }

    public abstract void draw(Canvas canvas);
}