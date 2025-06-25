package com.example.frogger;

public class GameData {
    public static int points;
    public static int lives;
    public static boolean onGameOverScreen;
    public static boolean onConfigScreen;
    public static int posX;
    public static int posY;

    public static int logPosX;

    public static int logPosY;
    public static int maxScore;
    public static int logSA;
    public static int logSA2;
    public static boolean onGameWinScreen;
    public static boolean onStartScreen;
    public static boolean onScreen;
    public static boolean onLog;
    public static String congrats;

    public void setCongrats(String c) {
        congrats = c;
    }

    public String getCongrats() {
        return congrats;
    }

    public int getLogSA2() {
        return logSA2;
    }

    public void setLogSA2(int log2) {
        logSA2 = log2;
    }

    public int getLogPosY() {
        return logPosY;
    }

    public void setLogPosY(int logPosY) {
        GameData.logPosY = logPosY;
    }

    public int getLogPosX() {
        return logPosX;
    }

    public void setLogPosX(int logPosX) {
        GameData.logPosX = logPosX;
    }

    public int getLogSA() {
        return logSA;
    }
    public void setLogSpeed(int logSpeed1) {
        logSA = logSpeed1;
    }
    public void setOnGameWinScreen(boolean winScreenStatus) {
        onGameWinScreen = winScreenStatus;
    }
    public boolean getOnGameWinScreen() {
        return onGameWinScreen;
    }

    public void setOnStartScreen(boolean startScreenStatus) {
        onStartScreen = startScreenStatus;
    }

    public boolean getOnStartScreen() {
        return onStartScreen;
    }

    public void setOnScreen(boolean onScreen1) {
        onScreen = onScreen1;
    }

    public boolean getOnScreen() {
        return onScreen;
    }

    public void setOnLog(boolean onLog1) {
        onLog = onLog1;
    }

    public boolean getOnLog() {
        return onLog;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int p) {
        points = p;
    }

    public static int getLives() {
        return lives;
    }

    public void setLives(int l) {
        lives = l;
    }

    public void jumpOnLog() {
        onLog = true;
        posY -= 98;
    }

    public void logMove() {
        if (onLog) {
            posX += 98;
        }
        logPosX += 98;
        if (posX > 980) {
            lives -= 1;
            posX = 490;
            posY = 1764;
        }
    }

    public void reachGoalTile() {
        onGameWinScreen = true;
        points += 1000;
        maxScore += 1000;
        congrats = "You Win";
    }

    public void restartFromWinScreen() {
        if (onGameWinScreen) {
            onGameWinScreen = false;
            onConfigScreen = true;
        }
    }

    public void exitFromWinScreen() {
        if (onGameWinScreen) {
            onGameWinScreen = false;
            onStartScreen = true;
        }
    }

    public void logSpeedRowTwo() {
        logSA2 = logSA + 1;
    }

    public void hitVehicle() {
        points = 0;
        lives -= 1;
        posX = 490;
        posY = 1764;
    }

    public void fallWater() {
        points = 0;
        lives -= 1;
        posX = 490;
        posY = 1764;
    }

    public boolean getOnGameOverScreen() {
        return onGameOverScreen;
    }

    public void setOnGameOverScreen(boolean ogos) {
        onGameOverScreen = ogos;
    }

    public static void loseGame() {
        lives -= 1;
        points = 0;
        if (getLives() == 0) {
            onGameOverScreen = true;
        }
    }

    public static void loseGameWaterTile() {
        lives -= 1;
        points = 0;
        if (getLives() == 0) {
            onGameOverScreen = true;
        }
    }

    public static void loseGameVehicle() {
        lives -= 1;
        points = 0;
        if (getLives() == 0) {
            onGameOverScreen = true;
        }
    }

    public void setPosX(int X) {
        posX = X;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosY(int Y) {
        posY = Y;
    }

    public int getPosY() {
        return posY;
    }

    public void setMaxScore(int max) {
        maxScore = max;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setOnConfigScreen(boolean ocs) {
        onConfigScreen = ocs;
    }

    public boolean getOnConfigScreen() {
        return onConfigScreen;
    }

    public void clickRestart() {
        if (onGameOverScreen) {
            onConfigScreen = true;
            onGameOverScreen = false;
        }
    }
}
