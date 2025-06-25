package com.example.frogger;

import android.graphics.Rect;
import android.widget.TextView;

public class GameDisplay {
    private final double displayCenterX;
    private final double displayCenterY;
    private final int widthPixels;
    private final int heightPixels;
    public final Rect DISPLAY_RECT;
    public double gameToDisplayCoorOffsetX;
    public double gameToDisplayCoorOffsetY;

    public GameDisplay(int widthPixels, int heightPixels) {
        this.widthPixels = widthPixels;
        this.heightPixels = heightPixels;
        DISPLAY_RECT = new Rect(0, 0, widthPixels, heightPixels);

        displayCenterX = widthPixels/2.0;
        displayCenterY = heightPixels/2.0;
    }

    public void update() {
    }

    public double gameToDisplayCoorOffsetX(double x) {
        return x + gameToDisplayCoorOffsetX;
    }

    public double gameToDisplayCoorOffsetY(double y) {
        return y + gameToDisplayCoorOffsetY;
    }

    public Rect getGameRect() {
        return new Rect(
                (int) (displayCenterX - widthPixels/2),
                (int) (displayCenterY - heightPixels/2),
                (int) (displayCenterX + widthPixels/2),
                (int) (displayCenterY + heightPixels/2)
        );
    }

    public int getScreenWidth() {
        return widthPixels;
    }
    public int getHeightPixels() {
        return heightPixels;
    }
}
