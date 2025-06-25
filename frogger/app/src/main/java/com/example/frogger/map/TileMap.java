package com.example.frogger.map;

import static com.example.frogger.map.MapLayout.NUMBER_OF_COLUMN;
import static com.example.frogger.map.MapLayout.NUMBER_OF_ROW;
import static com.example.frogger.map.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.frogger.map.MapLayout.TILE_WIDTH_PIXELS;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.frogger.GameDisplay;
import com.example.frogger.GameScreen;
import com.example.frogger.graphics.SpriteSheet;

public class TileMap {
    private final MapLayout mapLayout;
    private Tile[][] tilemap;
    private SpriteSheet spriteSheet;
    private Bitmap mapBitmap;

    public TileMap(SpriteSheet spriteSheet){
        mapLayout = new MapLayout();
        this.spriteSheet = spriteSheet;
        initializeTileMap();
    }
    private void initializeTileMap() {
        int[][] layout = mapLayout.getLayout();
        tilemap = new Tile[NUMBER_OF_ROW][NUMBER_OF_COLUMN];

        for(int row = 0; row < NUMBER_OF_ROW; row++) {
            for(int column = 0; column < NUMBER_OF_COLUMN; column++){
                tilemap[row][column] = Tile.getTile(
                        layout[row][column],
                        spriteSheet,
                        getRect(row, column)
                );
            }
        }

        mapBitmap = createMapBitmap();
        Canvas mapCanvas = new Canvas(mapBitmap);
        drawTilesOnCanvas(mapCanvas);
    }

    private Bitmap createMapBitmap() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        return Bitmap.createBitmap(
                NUMBER_OF_COLUMN * TILE_WIDTH_PIXELS,
                NUMBER_OF_ROW * TILE_HEIGHT_PIXELS,
                config
        );
    }

    private void drawTilesOnCanvas(Canvas mapCanvas) {
        for(int row = 0; row < NUMBER_OF_ROW; row++) {
            for (int column = 0; column < NUMBER_OF_COLUMN; column++) {
                tilemap[row][column].draw(mapCanvas);
            }
        }
    }


    private Rect getRect(int rowInd, int columnInd) {
        return new Rect(
                columnInd * TILE_WIDTH_PIXELS,
                rowInd * TILE_HEIGHT_PIXELS,
                (columnInd + 1) * TILE_WIDTH_PIXELS,
                (rowInd + 1) * TILE_HEIGHT_PIXELS
        );
    }
    public void draw(Canvas canvas, GameDisplay gameDisplay){
        canvas.drawBitmap(mapBitmap, gameDisplay.getGameRect(), gameDisplay.DISPLAY_RECT, null);
    }
}
