package com.example.frogger;

import static com.example.frogger.Player.ORIGINAL_X;
import static com.example.frogger.Player.ORIGINAL_Y;
import static com.example.frogger.map.MapLayout.NUMBER_OF_COLUMN;
import static com.example.frogger.map.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.frogger.map.MapLayout.TILE_WIDTH_PIXELS;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Paint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.lang.Math;
import java.util.logging.Handler;
import java.util.List;
import java.util.ArrayList;

import com.example.frogger.map.TileMap;
import com.example.frogger.graphics.SpriteSheet;
public class GameScreen extends SurfaceView implements SurfaceHolder.Callback {
    private List<Vehicle> vehicles;
    private Vehicle truck1; //firetruck
    private Vehicle truck1_2;
    private Vehicle truck1_3;

    private Vehicle truck2; //long truck
    private Vehicle car1; //yellow car
    private Vehicle car1_2;
    private Vehicle car1_3;

    private Vehicle car2; //green car
    private Vehicle car2_2;
    private Vehicle car2_3;
    private Vehicle car3; //blue car
    private Vehicle car3_2;
    private Vehicle car3_3;
    private Vehicle car3_4;

    private Vehicle car31_l3;
    private Vehicle car32_l3;

    private Log log1_1;
    private Log log2_1;
    private Log log3_1;
    private Log log4_1;
    private Log log5_1;
    private Log log6_1;
    private Log log7_1;
    private Log log8_1;
    private Log log9_1;

    private Log log1_2;
    private Log log2_2;
    private Log log3_2;
    private Log log4_2;
    private Log log5_2;
    private Log log6_2;
    private Log log7_2;
    private Log log8_2;
    private Log log9_2;

    private Log log1_3;
    private Log log2_3;
    private Log log3_3;
    private Log log4_3;
    private Log log5_3;
    private Log log6_3;
    private Log log7_3;
    private Log log8_3;
    private Log log9_3;
    private Log log1_4;
    private Log log2_4;
    private Log log3_4;
    private Log log4_4;
    private Log log5_4;
    private Log log6_4;
    private Log log7_4;
    private Log log8_4;
    private Log log9_4;

    private Log logList[];



    private final Player player;
    private final TileMap tilemap;
    private GameDisplay gameDisplay;
    private Gameloop gameLoop;
    private Context context;
    private double maxY = ORIGINAL_Y;

    private int maxScore = 0;

    public GameScreen(Context context) {
        super(context);

        // Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.context = context;
        gameLoop = new Gameloop(this, surfaceHolder);

        // Initialize game objects
        SpriteSheet spriteSheet = new SpriteSheet(context);

        int spriteNum = GameInfo.getSprite();
        player = new Player(ORIGINAL_X,ORIGINAL_Y,1,
                spriteSheet.getPlayerSprite(spriteNum));

        // Initialize display and center it around the player
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        gameDisplay = new GameDisplay(displayMetrics.widthPixels, displayMetrics.heightPixels);

        // Create vehicle objects
        truck1 = new Vehicle(1120, 1176, 3, spriteSheet.getTruck1());
        truck1_2 = new Vehicle(1520, 1176, 3,  spriteSheet.getTruck1());
        truck1_3 = new Vehicle(1920, 1176, 3,  spriteSheet.getTruck1());

        truck2 = new Vehicle( -460, 1274, 5, spriteSheet.getTruck2());

        car31_l3 = new Vehicle(1120, 1372, 2, spriteSheet.getCar3());
        car32_l3 = new Vehicle(1420, 1372, 2, spriteSheet.getCar3());

        car1 = new Vehicle(1120, 1470, 2, spriteSheet.getCar1());
        car1_2 = new Vehicle(1520, 1470, 2, spriteSheet.getCar1());
        car1_3 = new Vehicle(1920, 1470, 2, spriteSheet.getCar1());

        car2 = new Vehicle(-190, 1568, 2, spriteSheet.getCar2());
        car2_2 = new Vehicle(-490, 1568, 2,  spriteSheet.getCar2());
        car2_3 = new Vehicle(-790, 1568, 2, spriteSheet.getCar2());

        car3 = new Vehicle(1120, 1666, 2,  spriteSheet.getCar3());
        car3_2 = new Vehicle(1520, 1666, 2, spriteSheet.getCar3());
        car3_3 = new Vehicle(1920, 1666, 2, spriteSheet.getCar3());
        car3_4 = new Vehicle(2320, 1666, 2, spriteSheet.getCar3());

        vehicles = new ArrayList<>();
        vehicles.add(truck1);
        vehicles.add(truck1_2);
        vehicles.add(truck1_3);
        vehicles.add(truck2);
        vehicles.add(car1);
        vehicles.add(car1_2);
        vehicles.add(car1_3);
        vehicles.add(car2);
        vehicles.add(car2_2);
        vehicles.add(car2_3);
        vehicles.add(car3);
        vehicles.add(car3_2);
        vehicles.add(car3_3);
        vehicles.add(car3_4);
        vehicles.add(car31_l3);
        vehicles.add(car32_l3);


        //Add Logs
        log1_1 = new Log(1500, 882, 5,  spriteSheet.getLog1());
        log2_1 = new Log(-1550, 784, 3, spriteSheet.getLog2());
        log3_1 = new Log(1500, 686, 4, spriteSheet.getLog3());
        log4_1 = new Log(1500, 588, 5, spriteSheet.getLog1());
        log5_1 = new Log(-1550, 490, 3, spriteSheet.getLog2());
        log6_1 = new Log(1500, 392, 4, spriteSheet.getLog3());
        log7_1 = new Log(1500, 294, 5, spriteSheet.getLog1());
        log8_1 = new Log(-1550, 196, 3, spriteSheet.getLog2());
        log9_1 = new Log(1500, 98, 4, spriteSheet.getLog3());

        log1_2 = new Log(1950, 882, 5,  spriteSheet.getLog1());
        log2_2 = new Log(-1850, 784, 3, spriteSheet.getLog2());
        log3_2 = new Log(1900, 686, 4, spriteSheet.getLog3());
        log4_2 = new Log(1950, 588, 5, spriteSheet.getLog1());
        log5_2 = new Log(-1850, 490, 3, spriteSheet.getLog2());
        log6_2 = new Log(1900, 392, 4, spriteSheet.getLog3());
        log7_2 = new Log(1950, 294, 5, spriteSheet.getLog1());
        log8_2 = new Log(-1850, 196, 3, spriteSheet.getLog2());
        log9_2 = new Log(1900, 98, 4, spriteSheet.getLog3());

        log1_3 = new Log(2400, 882, 5,  spriteSheet.getLog1());
        log2_3 = new Log(-2150, 784, 3, spriteSheet.getLog2());
        log3_3 = new Log(2300, 686, 4, spriteSheet.getLog3());
        log4_3 = new Log(2400, 588, 5, spriteSheet.getLog1());
        log5_3 = new Log(-2150, 490, 3, spriteSheet.getLog2());
        log6_3 = new Log(2300, 392, 4, spriteSheet.getLog3());
        log7_3 = new Log(2400, 294, 5, spriteSheet.getLog1());
        log8_3 = new Log(-2150, 196, 3, spriteSheet.getLog2());
        log9_3 = new Log(2300, 98, 4, spriteSheet.getLog3());

        log1_4 = new Log(2850, 882, 5,  spriteSheet.getLog1());
        log2_4 = new Log(-2450, 784, 3, spriteSheet.getLog2());
        log3_4 = new Log(2700, 686, 4, spriteSheet.getLog3());
        log4_4 = new Log(2850, 588, 5, spriteSheet.getLog1());
        log5_4 = new Log(-2450, 490, 3, spriteSheet.getLog2());
        log6_4 = new Log(2700, 392, 4, spriteSheet.getLog3());
        log7_4 = new Log(2850, 294, 5, spriteSheet.getLog1());
        log8_4 = new Log(-2450, 196, 3, spriteSheet.getLog2());
        log9_4 = new Log(2700, 98, 4, spriteSheet.getLog3());

        //store all logs inside an array
        logList = new Log[36];
        logList[0] = log1_1;
        logList[1] = log2_1;
        logList[2] = log3_1;
        logList[3] = log4_1;
        logList[4] = log5_1;
        logList[5] = log6_1;
        logList[6] = log7_1;
        logList[7] = log8_1;
        logList[8] = log9_1;
        logList[9] = log1_2;
        logList[10] = log2_2;
        logList[11] = log3_2;
        logList[12] = log4_2;
        logList[13] = log5_2;
        logList[14] = log6_2;
        logList[15] = log7_2;
        logList[16] = log8_2;
        logList[17] = log9_2;
        logList[18] = log1_3;
        logList[19] = log2_3;
        logList[20] = log3_3;
        logList[21] = log4_3;
        logList[22] = log5_3;
        logList[23] = log6_3;
        logList[24] = log7_3;
        logList[25] = log8_3;
        logList[26] = log9_3;
        logList[27] = log1_4;
        logList[28] = log2_4;
        logList[29] = log3_4;
        logList[30] = log4_4;
        logList[31] = log5_4;
        logList[32] = log6_4;
        logList[33] = log7_4;
        logList[34] = log8_4;
        logList[35] = log9_4;



        // Initialize Tilemap
        tilemap = new TileMap(spriteSheet);
        setFocusable(true);

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    //Check for collision and goal tile
    public void update() {
        gameDisplay.update();
        player.update();
        checkCollision(player, vehicles);
        moveWithLogs();
        checkGoal();
    }

    // Draw paint onto screen
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        tilemap.draw(canvas, gameDisplay);

        if (truck1.getPositionX() >= -1520) {
            truck1.incPositionX(-8);
        } else {
            truck1.setPositionX(1120);
        }
        truck1.draw(canvas, gameDisplay);

        if (truck1_2.getPositionX() >= -1120) {
            truck1_2.incPositionX(-8);
        } else {
            truck1_2.setPositionX(1520);
        }
        truck1_2.draw(canvas, gameDisplay);

        if (truck1_3.getPositionX() >= -720) {
            truck1_3.incPositionX(-8);
        } else {
            truck1_3.setPositionX(1920);
        }
        truck1_3.draw(canvas, gameDisplay);


        if (truck2.getPositionX() <= 1060) {
            truck2.incPositionX(7);
        } else {
            truck2.setPositionX(-460);
        }
        truck2.draw(canvas, gameDisplay);

        if (car1.getPositionX() >= -1920) {
            car1.incPositionX(-10);
        } else {
            car1.setPositionX(1120);
        }
        car1.draw(canvas, gameDisplay);

        if (car1_2.getPositionX() >= -1520) {
            car1_2.incPositionX(-10);
        } else {
            car1_2.setPositionX(1520);
        }
        car1_2.draw(canvas, gameDisplay);

        if (car1_3.getPositionX() >= -1120) {
            car1_3.incPositionX(-10);
        } else {
            car1_3.setPositionX(1920);
        }
        car1_3.draw(canvas, gameDisplay);

        if (car2.getPositionX() <= 2050) {
            car2.incPositionX(12);
        } else {
            car2.setPositionX(-190);
        }
        car2.draw(canvas, gameDisplay);

        if (car2_2.getPositionX() <= 1650) {
            car2_2.incPositionX(12);
        } else {
            car2_2.setPositionX(-590);
        }
        car2_2.draw(canvas, gameDisplay);

        if (car2_3.getPositionX() <= 1250) {
            car2_3.incPositionX(12);
        } else {
            car2_3.setPositionX(-990);
        }
        car2_3.draw(canvas, gameDisplay);


        if (car3.getPositionX()>= -2320) {
            car3.incPositionX(-15);
        } else {
            car3.setPositionX(1120);
        }
        car3.draw(canvas, gameDisplay);
        if (car3_2.getPositionX() >= -1920) {
            car3_2.incPositionX(-15);
        } else {
            car3_2.setPositionX(1520);
        }
        car3_2.draw(canvas, gameDisplay);
        if (car3_3.getPositionX() >= -1520) {
            car3_3.incPositionX(-15);
        } else {
            car3_3.setPositionX(1920);
        }
        car3_3.draw(canvas, gameDisplay);
        if (car3_4.getPositionX() >= -1120) {
            car3_4.incPositionX(-15);
        } else {
            car3_4.setPositionX(2320);
        }
        car3_4.draw(canvas, gameDisplay);

        if (car31_l3.getPositionX() >= -1420) {
            car31_l3.incPositionX(-15);
        } else {
            car31_l3.setPositionX(1120);
        }
        car31_l3.draw(canvas, gameDisplay);
        if (car32_l3.getPositionX() >= -1120) {
            car32_l3.incPositionX(-15);
        } else {
            car32_l3.setPositionX(1420);
        }
        car32_l3.draw(canvas, gameDisplay);





        if (log1_1.getPositionX() >= -2850) {
            log1_1.incPositionX(-5);
        } else {
            log1_1.setPositionX(1500);
        }
        log1_1.draw(canvas, gameDisplay);
        if (log2_1.getPositionX() <= 2450) {
            log2_1.incPositionX(5);
        } else {
            log2_1.setPositionX(-1550);
        }
        log2_1.draw(canvas, gameDisplay);
        if (log3_1.getPositionX() >= -2700) {
            log3_1.incPositionX(-5);
        } else {
            log3_1.setPositionX(1500);
        }
        log3_1.draw(canvas, gameDisplay);
        if (log4_1.getPositionX() >= -2850) {
            log4_1.incPositionX(-5);
        } else {
            log4_1.setPositionX(1500);
        }
        log4_1.draw(canvas, gameDisplay);
        if (log5_1.getPositionX() <= 2450) {
            log5_1.incPositionX(5);
        } else {
            log5_1.setPositionX(-1550);
        }
        log5_1.draw(canvas, gameDisplay);
        if (log6_1.getPositionX() >= -2700) {
            log6_1.incPositionX(-5);
        } else {
            log6_1.setPositionX(1500);
        }
        log6_1.draw(canvas, gameDisplay);
        if (log7_1.getPositionX() >= -2850) {
            log7_1.incPositionX(-5);
        } else {
            log7_1.setPositionX(1500);
        }
        log7_1.draw(canvas, gameDisplay);
        if (log8_1.getPositionX() <= 2450) {
            log8_1.incPositionX(5);
        } else {
            log8_1.setPositionX(-1550);
        }
        log8_1.draw(canvas, gameDisplay);
        if (log9_1.getPositionX() >= -2700) {
            log9_1.incPositionX(-5);
        } else {
            log9_1.setPositionX(1500);
        }
        log9_1.draw(canvas, gameDisplay);







        if (log1_2.getPositionX() >= -2400) {
            log1_2.incPositionX(-5);
        } else {
            log1_2.setPositionX(1950);
        }
        log1_2.draw(canvas, gameDisplay);
        if (log2_2.getPositionX() <= 2150) {
            log2_2.incPositionX(5);
        } else {
            log2_2.setPositionX(-1850);
        }
        log2_2.draw(canvas, gameDisplay);
        if (log3_2.getPositionX() >= -2300) {
            log3_2.incPositionX(-5);
        } else {
            log3_2.setPositionX(1900);
        }
        log3_2.draw(canvas, gameDisplay);
        if (log4_2.getPositionX() >= -2400) {
            log4_2.incPositionX(-5);
        } else {
            log4_2.setPositionX(1950);
        }
        log4_2.draw(canvas, gameDisplay);
        if (log5_2.getPositionX() <= 2150) {
            log5_2.incPositionX(5);
        } else {
            log5_2.setPositionX(-1850);
        }
        log5_2.draw(canvas, gameDisplay);
        if (log6_2.getPositionX() >= -2300) {
            log6_2.incPositionX(-5);
        } else {
            log6_2.setPositionX(1900);
        }
        log6_2.draw(canvas, gameDisplay);
        if (log7_2.getPositionX() >= -2400) {
            log7_2.incPositionX(-5);
        } else {
            log7_2.setPositionX(1950);
        }
        log7_2.draw(canvas, gameDisplay);
        if (log8_2.getPositionX() <= 2150) {
            log8_2.incPositionX(5);
        } else {
            log8_2.setPositionX(-1850);
        }
        log8_2.draw(canvas, gameDisplay);
        if (log9_2.getPositionX() >= -2300) {
            log9_2.incPositionX(-5);
        } else {
            log9_2.setPositionX(1900);
        }
        log9_2.draw(canvas, gameDisplay);






        if (log1_3.getPositionX() >= -1950) {
            log1_3.incPositionX(-5);
        } else {
            log1_3.setPositionX(2400);
        }
        log1_3.draw(canvas, gameDisplay);
        if (log2_3.getPositionX() <= 1850) {
            log2_3.incPositionX(5);
        } else {
            log2_3.setPositionX(2150);
        }
        log2_3.draw(canvas, gameDisplay);
        if (log3_3.getPositionX() >= -1900) {
            log3_3.incPositionX(-5);
        } else {
            log3_3.setPositionX(2300);
        }
        log3_3.draw(canvas, gameDisplay);
        if (log4_3.getPositionX() >= -1950) {
            log4_3.incPositionX(-5);
        } else {
            log4_3.setPositionX(2400);
        }
        log4_3.draw(canvas, gameDisplay);
        if (log5_3.getPositionX() <= 1850) {
            log5_3.incPositionX(5);
        } else {
            log5_3.setPositionX(-2150);
        }
        log5_3.draw(canvas, gameDisplay);
        if (log6_3.getPositionX() >= -1900) {
            log6_3.incPositionX(-5);
        } else {
            log6_3.setPositionX(2300);
        }
        log6_3.draw(canvas, gameDisplay);
        if (log7_3.getPositionX() >= -1950) {
            log7_3.incPositionX(-5);
        } else {
            log7_3.setPositionX(2400);
        }
        log7_3.draw(canvas, gameDisplay);
        if (log8_3.getPositionX() <= 1850) {
            log8_3.incPositionX(5);
        } else {
            log8_3.setPositionX(-2150);
        }
        log8_2.draw(canvas, gameDisplay);
        if (log9_3.getPositionX() >= -1900) {
            log9_3.incPositionX(-5);
        } else {
            log9_3.setPositionX(2300);
        }
        log9_3.draw(canvas, gameDisplay);






        if (log1_4.getPositionX() >= -1500) {
            log1_4.incPositionX(-5);
        } else {
            log1_4.setPositionX(2850);
        }
        log1_4.draw(canvas, gameDisplay);
        if (log2_4.getPositionX() <= 1550) {
            log2_4.incPositionX(5);
        } else {
            log2_4.setPositionX(-2450);
        }
        log2_4.draw(canvas, gameDisplay);
        if (log3_4.getPositionX() >= -1500) {
            log3_4.incPositionX(-5);
        } else {
            log3_4.setPositionX(2700);
        }
        log3_4.draw(canvas, gameDisplay);
        if (log4_4.getPositionX() >= -1500) {
            log4_4.incPositionX(-5);
        } else {
            log4_4.setPositionX(2850);
        }
        log4_4.draw(canvas, gameDisplay);
        if (log5_4.getPositionX() <= 1550) {
            log5_4.incPositionX(5);
        } else {
            log5_4.setPositionX(-2450);
        }
        log5_4.draw(canvas, gameDisplay);
        if (log6_4.getPositionX() >= -1500) {
            log6_4.incPositionX(-5);
        } else {
            log6_4.setPositionX(2700);
        }
        log6_4.draw(canvas, gameDisplay);
        if (log7_4.getPositionX() >= -1500) {
            log7_4.incPositionX(-5);
        } else {
            log7_4.setPositionX(2850);
        }
        log7_4.draw(canvas, gameDisplay);
        if (log8_4.getPositionX() <= 1550) {
            log8_4.incPositionX(5);
        } else {
            log8_4.setPositionX(-2450);
        }
        log8_4.draw(canvas, gameDisplay);
        if (log9_4.getPositionX() >= -1500) {
            log9_4.incPositionX(-5);
        } else {
            log9_4.setPositionX(2700);
        }
        log9_4.draw(canvas, gameDisplay);

        // Draw player
        player.draw(canvas, gameDisplay);
        // Draw displays
        drawName(canvas);
        drawDif(canvas);
        drawLives(canvas);
        drawPoints(canvas);
    }


    // Create name, lives, points, and difficulty level paint
    public void drawName(Canvas canvas) {
        String username = GameInfo.getName();
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.black);
        paint.setColor(color);
        paint.setTextSize(35);
        canvas.drawText(username, 50, 1825, paint);
    }

    public void drawLives(Canvas canvas) {
        String userLives = Integer.toString(GameInfo.getLives());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.black);
        paint.setColor(color);
        paint.setTextSize(35);
        canvas.drawText("Lives: " + userLives, 895, 1875, paint);
    }

    public void drawDif(Canvas canvas) {
        String userDif = Integer.toString(GameInfo.getDif());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.black);
        paint.setColor(color);
        paint.setTextSize(35);
        canvas.drawText("Dif: " + userDif, 895, 1825, paint);
    }

    public void drawPoints(Canvas canvas) {
        String userPoints = Integer.toString(GameInfo.getPoints());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.black);
        paint.setColor(color);
        paint.setTextSize(35);
        canvas.drawText("Points: " + userPoints, 50, 1875, paint);
    }

    // Compare the player position at the current y
    // with the highest y location that the player has landed on
    public boolean isHigher() {
        if (player.getPositionY() < maxY) {
            maxY = player.getPositionY();
            return true;
        }
        return false;
    }

    // Update points and maxScore according to what tile the player is on
    public void updatePoints(){
        if (isHigher()) {
            // Goal tile
            if (player.getPositionY() < TILE_HEIGHT_PIXELS) {
                GameInfo.incPoints(100);
                // River tile
            } else if (player.getPositionY() >= TILE_HEIGHT_PIXELS
                    && player.getPositionY() < (TILE_HEIGHT_PIXELS * 10)) {
                GameInfo.incPoints(20);
                // Safe tile
            } else if (player.getPositionY() >= (TILE_HEIGHT_PIXELS * 10)
                    && player.getPositionY() < (TILE_HEIGHT_PIXELS * 12)) {
                GameInfo.incPoints(5);
                // Last 2 road tiles that is more difficult than the rest
            } else if (player.getPositionY() >= (TILE_HEIGHT_PIXELS * 12)
                    && player.getPositionY() < (TILE_HEIGHT_PIXELS * 14)) {
                GameInfo.incPoints(20);
                // Road tile
            } else {
                GameInfo.incPoints(10);
            }
        }
        if (GameInfo.getPoints() > maxScore) {
            maxScore = GameInfo.getPoints();
        }
    }

    // Movement according to where user clicks
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            // Move right
            if (touchX > player.getPositionX() && (touchY < player.getPositionY()
                    + TILE_HEIGHT_PIXELS && touchY > player.getPositionY() )) {
                if  (player.getPositionX() + TILE_WIDTH_PIXELS
                        < (TILE_WIDTH_PIXELS * NUMBER_OF_COLUMN)) {
                    player.incPositionX(TILE_WIDTH_PIXELS);
                }
                // Move left
            } else if (touchX < player.getPositionX() && (touchY <
                    player.getPositionY() + TILE_HEIGHT_PIXELS && touchY > player.getPositionY())) {
                player.incPositionX(-(TILE_WIDTH_PIXELS));
                // Move down
            } else if (touchY > player.getPositionY() && (touchX < player.getPositionX()
                    + TILE_WIDTH_PIXELS && touchX > player.getPositionX())) {
                if (player.getPositionY() < ORIGINAL_Y) {
                    player.incPositionY(TILE_HEIGHT_PIXELS);
                }
                // Move up
            } else if (touchY < player.getPositionY() && (touchX < player.getPositionX()
                    + TILE_WIDTH_PIXELS && touchX > player.getPositionX())) {
                if (player.getPositionY() > TILE_HEIGHT_PIXELS || isGoalTile()) {
                    player.incPositionY(-(TILE_HEIGHT_PIXELS));
                    updatePoints();
                }

            }

        }
        return true;
    }

    // If lives is greater than 0, move sprite to initial point, decrease points and lives.
    // Else go to game over screen
    public void checkLives() {
        if (GameInfo.getLives() > 0) {
            player.setPositionX(ORIGINAL_X);
            player.setPositionY(ORIGINAL_Y);
            GameInfo.points = 0;
            GameInfo.decLives();
        } else  {
            Intent next = new Intent(context, GameOverScreen.class);
            context.startActivity(next);
        }
    }

    // Check if player collides w/ vehicles and use checkLives() to decrease lives and points
    private void checkCollision(Player player, List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (player.intersects(vehicle)) {
                checkLives();
                maxY = ORIGINAL_Y;
            }
        }
    }

    //updates the player's position based on the log's x position
    public void moveWithLogs() {
        //check if player is inside river section
        if ((player.getPositionY() > 0) && (player.getPositionY() <= 882)) {
            int i = 0;
            while (i < logList.length && !(player.intersects(logList[i]))) {
                i++;
            }
            //checks if the log intersects with the player position
            if (i < logList.length && player.intersects(logList[i])) {
                //checks if the player is within the game screen
                if ((player.getRight() < gameDisplay.getScreenWidth()) &&
                        (player.getLeft() > 0)) {
                    player.incPositionX(logList[i].getRate());
                } else {
                    checkLives();
                }
            } else if (i >= logList.length) {
                checkLives();
            }
        }
    }


    //Check if the tile above is a goal tile
    public boolean isGoalTile() {
        return (player.getPositionY() == TILE_HEIGHT_PIXELS);
//                && (player.getPositionX() == TILE_WIDTH_PIXELS * 1 ||
//                        player.getPositionX() == TILE_WIDTH_PIXELS * 3 ||
//                        player.getPositionX() == TILE_WIDTH_PIXELS * 5 ||
//                        player.getPositionX() == TILE_WIDTH_PIXELS * 7 ||
//                        player.getPositionX() == TILE_WIDTH_PIXELS * 9 ));
    }

    // Check if the player is on the goal tile
    public void checkGoal() {
        if (player.getPositionY() == 0) {
            Intent intent = new Intent(context, WinScreen.class);
            intent.putExtra("keymaxscore", maxScore);
            context.startActivity(intent);
        }
    }
    //Pause game
    public void pause() {
        gameLoop.stopLoop();
    }
}
