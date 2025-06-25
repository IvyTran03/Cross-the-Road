package com.example.frogger;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class Sprint5Tests {

    @Test
    public void SeanJumpingLogNoLife() {
        GameData gameData = new GameData();
        gameData.setOnLog(false);
        gameData.setLives(1);
        assertEquals(gameData.getLives(), 1);
        assertEquals(gameData.getOnLog(), false);
        gameData.jumpOnLog();
        assertEquals(gameData.getOnLog(), true);
        assertEquals(gameData.getLives(), 1);
    }

    @Test
    public void SeanJumpingLogSamePos() {
        GameData gameData = new GameData();
        gameData.setOnLog(false);
        gameData.setPosY(1372);
        gameData.setPosX(490);
        gameData.setLogPosX(490);
        gameData.setLogPosY(1274);
        assertEquals(gameData.getOnLog(), false);
        gameData.jumpOnLog();
        gameData.logMove();
        assertEquals(gameData.getLogPosY(), 1274);
        assertEquals(gameData.getLogPosX(), 588);
        assertEquals(gameData.getPosY(), 1274);
        assertEquals(gameData.getPosX(), 588);
    }

    @Test
    public void AngelGoalTilePoints() {
        GameData gameData = new GameData();
        gameData.setOnGameWinScreen(false);
        gameData.setPoints(0);
        assertEquals(gameData.getPoints(), 0);
        gameData.reachGoalTile();
        assertEquals(gameData.getPoints(), 1000);
    }

    @Test
    public void AngelRestartGameFromWin() {
        GameData gameData = new GameData();
        gameData.setOnGameWinScreen(true);
        gameData.restartFromWinScreen();
        assertEquals(gameData.getOnGameWinScreen(), false);
        assertEquals(gameData.getOnConfigScreen(), true);
    }

    @Test
    public void TommyLogSurfaceArea() {
        GameData gameData = new GameData();
        gameData.setLogSpeed(1);
        gameData.setLogSA2(1);
        assertEquals(gameData.getLogSA2(), 1);
        gameData.logSpeedRowTwo();
        assertEquals(gameData.getLogSA2(), 2);
    }

    @Test
    public void TommyLogMovePlayerOffScreen() {
        GameData gameData = new GameData();
        gameData.setPosX(980);
        gameData.setLogPosX(980);
        gameData.setLives(2);
        gameData.jumpOnLog();
        gameData.logMove();
        assertEquals(gameData.getLives(), 1);
        assertEquals(gameData.getPosX(), 490);
        assertEquals(gameData.getPosY(), 1764);
    }

    @Test
    public void HopeReachWinScreen() {
        GameData gameData = new GameData();
        gameData.setOnGameWinScreen(false);
        assertEquals(gameData.getOnGameWinScreen(), false);
        gameData.reachGoalTile();
        assertEquals(gameData.getOnGameWinScreen(), true);
    }

    @Test
    public void HopeExitGameFromWin() {
        GameData gameData = new GameData();
        gameData.setOnGameWinScreen(true);
        gameData.setOnStartScreen(false);
        gameData.exitFromWinScreen();
        assertEquals(gameData.getOnGameWinScreen(), false);
        assertEquals(gameData.getOnStartScreen(), true);
    }

    @Test
    public void KeiuWinScreenHighestScore() {
        GameData gameData = new GameData();
        gameData.setOnGameWinScreen(false);
        gameData.setMaxScore(3000);
        assertEquals(gameData.getMaxScore(), 3000);
        gameData.reachGoalTile();
        assertEquals(gameData.getMaxScore(), 4000);
    }

    @Test
    public void KeiuWinScreenText() {
        GameData gameData = new GameData();
        gameData.setCongrats("");
        gameData.setOnGameWinScreen(false);
        gameData.reachGoalTile();
        assertEquals(gameData.getOnGameWinScreen(), true);
        assertEquals(gameData.getCongrats(), "You Win");
    }
}
