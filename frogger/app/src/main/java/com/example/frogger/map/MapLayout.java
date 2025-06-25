package com.example.frogger.map;

public class MapLayout {
    public static final int TILE_WIDTH_PIXELS = 98;
    public static final int TILE_HEIGHT_PIXELS = 98;
    public static final int NUMBER_OF_ROW = 20;
    public static final int NUMBER_OF_COLUMN = 11;

    private int[][] layout;
    public MapLayout() {
        initializeMap();
    }

    public int[][] getLayout(){
        return layout;
    }
    private void initializeMap() {
        layout = new int[][] {
                {3,4,3,4,3,4,3,4,3,4,3},
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,2,2,2,2,2,2,2},
                {2,2,2,2,2,2,2,2,2,2,2},
                {2,2,2,2,2,2,2,2,2,2,2},
                {2,2,2,2,2,2,2,2,2,2,2},
                {2,2,2,2,2,2,2,2,2,2,2},
                {2,2,2,2,2,2,2,2,2,2,2},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0}
        };
    }
}