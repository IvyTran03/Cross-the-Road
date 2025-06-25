package com.example.frogger;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class Gameloop extends Thread {
    private boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    private GameScreen game;

    public Gameloop(GameScreen game, SurfaceHolder surfaceHolder) {
        this.game = game;
        this.surfaceHolder = surfaceHolder;
    }
    public void startLoop() {
        isRunning = true;
        start();
    }

    @Override
    public void run() {
        super.run();

        Canvas canvas;
        while(isRunning) {
            try {
                canvas = surfaceHolder.lockCanvas();
                game.update();
                game.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }
    }
    public void stopLoop() {
        isRunning = false;
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
