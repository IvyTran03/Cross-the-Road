package com.example.frogger;

import android.content.Context;
import android.os.Looper;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
//public class ExampleInstrumentedTest {
//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.frogger", appContext.getPackageName());
//    }
//}

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    //test to see if points reset on vehicle collision
    @Test
    public void SeanVehicleCollisionPoints() {
        GameData gameData = new GameData();
        gameData.setPoints(100);
        assertEquals(gameData.getPoints(), 100);
        gameData.hitVehicle();
        assertEquals(gameData.getPoints(), 0);
    }

    //test to see if lives decrease on vehicle collision
    @Test
    public void SeanVehicleCollisionLives() {
        GameData gameData = new GameData();
        gameData.setLives(5);
        assertEquals(gameData.getLives(), 5);
        gameData.hitVehicle();
        assertEquals(gameData.getLives(), 4);
    }

    //test to see if points reset on water tile collision
    @Test
    public void AngelWaterCollisionPoints() {
        GameData gameData = new GameData();
        gameData.setPoints(100);
        assertEquals(gameData.getPoints(), 100);
        gameData.fallWater();
        assertEquals(gameData.getPoints(), 0);
    }

    //test to see if lives decrease on water collision
    @Test
    public void AngelWaterCollisionLives() {
        GameData gameData = new GameData();
        gameData.setLives(5);
        assertEquals(gameData.getLives(), 5);
        gameData.fallWater();
        assertEquals(gameData.getLives(), 4);
    }

    //test to see if you go to gameOverScreen after losing last life on water
    @Test
    public void KeiuGoesToGameOverScreenFromWaterTile() {
        GameData gameData = new GameData();
        gameData.setOnGameOverScreen(false);
        gameData.setLives(1);
        assertFalse(gameData.getOnGameOverScreen());
        GameData.loseGameWaterTile();
        assertTrue(gameData.getOnGameOverScreen());
    }

    //test to see if you go to gameOver after losing last life from vehicle
    @Test
    public void KeiuGoesToGameOverScreenFromVehicle() {
        GameData gameData = new GameData();
        gameData.setOnGameOverScreen(false);
        gameData.setLives(1);
        assertFalse(gameData.getOnGameOverScreen());
        GameData.loseGameVehicle();
        assertTrue(gameData.getOnGameOverScreen());
    }

    //test to see if position resets to start after life lose on water
    @Test
    public void TommyWaterToStartingPoint() {
        GameData gameData = new GameData();
        gameData.setPosX(900);
        gameData.setPosY(900);
        assertEquals(gameData.getPosX(), 900);
        assertEquals(gameData.getPosY(), 900);
        gameData.fallWater();
        assertEquals(gameData.getPosX(), 490);
        assertEquals(gameData.getPosY(), 1764);
    }

    //test to see if position resets if life lost from vehicle
    @Test
    public void TommyVehicleToStartingPoint() {
        GameData gameData = new GameData();
        gameData.setPosX(600);
        gameData.setPosY(600);
        assertEquals(gameData.getPosX(), 600);
        assertEquals(gameData.getPosY(), 600);
        gameData.fallWater();
        assertEquals(gameData.getPosX(), 490);
        assertEquals(gameData.getPosY(), 1764);
    }

    //test to see if maxScore is kept if you lose game
    @Test
    public void HopeKeepMaxScore() {
        GameData gameData = new GameData();
        gameData.setPoints(800);
        gameData.setMaxScore(gameData.getPoints());
        gameData.setLives(1);
        assertEquals(gameData.getMaxScore(), 800);
        gameData.loseGame();
        assertEquals(gameData.getLives(), 0);
        assertEquals(gameData.getPoints(), 0);
        assertEquals(gameData.getMaxScore(), 800);
    }

    //test to see if you move to config screen if you click restart
    @Test
    public void HopeMoveToConfigScreen() {
        GameData gameData = new GameData();
        gameData.setOnConfigScreen(false);
        gameData.setOnGameOverScreen(true);
        assertEquals(gameData.getOnConfigScreen(), false);
        assertEquals(gameData.getOnGameOverScreen(), true);
        gameData.clickRestart();
        assertEquals(gameData.getOnConfigScreen(), true);
        assertEquals(gameData.getOnGameOverScreen(), false);
    }


//    @Rule
//    public ActivityScenarioRule<GameScreen> activityRule =
//            new ActivityScenarioRule<>(GameScreen.class);
//
//    //tests that the correct vehicle is generated
//    @Test
//    public void SeanTestCorrectVehicle() {
//        Vehicle generator = new Vehicle();
//        Player sprite = generator.Vehicle();
//
//        assertNotNull(sprite);
//        assertEquals(sprite.getSpeed(), 50);
//        assertEquals(sprite.getSize(), 50);
//        assertTrue(sprite.getImage().contains("vehicle"));
//        assertFalse(sprite.isAnimated());
//    }
//
//    //test vehicle moves horizontally
//    @Test
//    public void SeanTestVehicleHorizontalMovement() {
//        Vehicle vehicle = new Vehicle(0, 0);
//
//        //moves vehicle to the right by velocity 5
//        vehicle.setVelocity(5, 0);
//        vehicle.update(1);
//        assertEquals(vehicle.getVehicleX(), 5);
//        assertEquals(vehicle.getVehicleY(), 0);
//    }
//
//    //tests that the vehicle doesn't move vertically
//    @Test
//    public void KieuTestVehicleVerticalMovement() {
//        Vehicle vehicle = new Vehicle(0, 0);
//
//        //vehicle moves vertically but the vehicle shouldn't be able to
//        vehicle.setVelocity(0, 5);
//        vehicle.update(1);
//        assertNotEquals(vehicle.getVehicleY(), 5);
//    }
//
//    //test that vehicles don't collide
//    @Test
//    public void KieuTestNoCollision() {
//        Vehicle vehicle1 = new Vehicle(0, 0);
//        Vehicle vehicle2 = new Vehicle(20, 20);
//
//        assertFalse(vehicle1.collidesWith(vehicle2));
//    }
//
//    //checks it can spawn from the the right or left side of the screen
//    @Test
//    public void AngelTestSideToSide() {
//        Vehicle newV = new Vehicle();
//
//        // Spawn multiple vehicles and ensure they all spawn from either the left or right
//        for (int i = 0; i < 10; i++) {
//            Vehicle vehicle = newV.Vehicle();
//            assertTrue(vehicle.getVehicleX() == 0 || vehicle.getVehicleX() == newV.getScreenWidth());
//        }
//    }
//
//    //checks that the vehicle moves all the way across the screen moving right
//    @Test
//    public void AngelTestVehicleCrossesScreenMovingRight() {
//        Vehicle vehicle = new Vehicle(0, 100);
//        vehicle.setVelocity(10, 0);
//
//        // Move the vehicle across the screen
//        int screenWidth = 800;
//        int initialX = 0;
//        int finalX = screenWidth - vehicle.getWidth();
//        while (vehicle.getVehicleX() != finalX) {
//            vehicle.update();
//        }
//
//        assertTrue(vehicle.getVehicleX() == finalX);
//    }
//
//    //checks that the vehicle moves all the way across the screen moving left
//    @Test
//    public void TommyTestVehicleCrossesScreenMovingLeft() {
//        // Create a vehicle with initial position and velocity
//        Vehicle vehicle = new Vehicle(800, 100);
//        vehicle.setVelocity(-10, 0);
//
//        // Move the vehicle across the screen
//        int screenWidth = 800;
//        int initialX = screenWidth - vehicle.getWidth();
//        int finalX = 0;
//        while (vehicle.getVehicleX() != finalX) {
//            vehicle.update();
//        }
//
//        // Check that the vehicle has reached the other side of the screen
//        assertTrue(vehicle.getVehicleX() == finalX);
//    }
//
//    //checks that score increases with upward movement
//    @Test
//    public void TommyTestScoreIncreasesOnMoveUp() {
//        Player player = new Player(0);
//
//        // Move the player up the screen
//        player.setSpriteX(0);
//        player.setSpriteY(100);
//        player.setVelocity(0, -10);
//        player.update();
//        player.update();
//
//        // Check that the player's score has increased
//        assertTrue(player.getPoints() > 0);
//    }
//
//    //check that score starts at 0
//    @Test
//    public void HopeTestScoreStartsAtZero() {
//        Player player = new Player();
//
//        // Check that the score starts at 0
//        assertEquals(0, score.getPoints());
//    }
//
//    //check that the score doesn't increase with horizontal or downward movement
//    @Test
//    public void HopeTestScoreHorizontalAndBack() {
//        // Create a new score object and player object
//        Score score = new Score();
//        Player player = new Player();
//
//        // Move the player horizontally, down, and left
//        player.setSpriteX(10);
//        score.updatePoints(player.getSpriteX(), player.getspriteY());
//        player.setSpriteY(10);
//        score.updatePoints(player.getSpriteX(), player.getSpriteY());
//        player.setSpriteX(-10, 0);
//        score.updatePoints(player.getSpriteX(), player.getSpriteY());
//
//        // Check that the score has not increased
//        assertEquals(0, score.getPoints());
//    }
//




//    ConfigScreen config = new ConfigScreen();
//    GameScreen screen = new GameScreen();
//    GameScreen gameScreen = new GameScreen();
//    private Looper looper;
//
//    @Mock
//    private Context context;
//
//    @Before
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//        looper = mock(Looper.class);
//        Context ctx = mock(Context.class);
//        when(ctx.getMainLooper()).thenReturn(looper);
//        gameScreen = new GameScreen();
//    }
//
//    @Test
//    public void SeanTestLiveNumber() {
//        int LivesEq = 4;
//        gameScreen.setLiveNumber(2);
//        when(gameScreen.getLiveNumber()).thenReturn(LivesEq);
//
//        int result = gameScreen.getLiveNumber();
//        assertEquals(LivesEq, result);
//
//        verify(gameScreen).getLiveNumber();
//    }
//
//    @Test
//    public void SeanTestDifficultySetting() {
//        String difLvl = "Easy";
//        gameScreen.setDifficultyLevel("Easy");
//        when(gameScreen.getDifficultyLevel()).thenReturn(difLvl);
//
//        String result = gameScreen.getDifficultyLevel();
//        assertEquals(difLvl, result);
//
//        verify(gameScreen).getLiveNumber();
//    }
//
//    @Test
//    public void angelVerifyNameIsValid() {
//        String name1 = null;
//        String name2 = "";
//
//        config.name = name1;
//
//        assertTrue(config.nonValidName);
//
//        config.name = name2;
//
//        assertTrue(config.nonValidName);
//    }
//    @Test
//    public void angelCheckLivesByDifficulty() {
//        //3 cases
//        screen.setDifficultyLevel = 1;
//        assertEquals(5, screen.numLives);
//
//        screen.setDifficultyLevel = 2;
//        assertEquals(4, screen.numLives);
//
//        screen.setDifficultyLevel = 3;
//        assertEquals(3, screen.numLives);
//    }
//
//    @Test
//    public void hopeTestSpriteMovesUp() {
//        // Get a reference to the sprite ImageView
//        onView(withId(R.id.spriteImage1)).check(matches(isDisplayed()));
//        onView(withId(R.id.spriteImage1)).perform(swipeUp());
//        onView(withId(R.id.spriteImage1)).check(matches(withTranslationY(-10f)));
//    }
//
//    @Test
//    public void hopeTestSpriteMovesDown() {
//        // Get a reference to the sprite ImageView
//        onView(withId(R.id.spriteImage1)).check(matches(isDisplayed()));
//        onView(withId(R.id.spriteImage1)).perform(swipeDown());
//        onView(withId(R.id.spriteImage1)).check(matches(withTranslationY(0f)));
//    }
//
//    @Test
//    public void tommyTestSpriteMovesLeft() {
//        // Get a reference to the sprite ImageView
//        onView(withId(R.id.spriteImage1)).check(matches(isDisplayed()));
//        onView(withId(R.id.spriteImage1)).perform(swipeLeft());
//        onView(withId(R.id.spriteImage1)).check(matches(withTranslationX(-10f)));
//    }
//
//    public void tommyTestSpriteMovesRight() {
//        // Get a reference to the sprite ImageView
//        onView(withId(R.id.spriteImage1)).check(matches(isDisplayed()));
//        onView(withId(R.id.spriteImage1)).perform(swipeRight());
//        onView(withId(R.id.spriteImage1)).check(matches(withTranslationX(0f)));
//    }
//
//    public void KieuInitialPointTest() {
//        assertEquals(0, gameScreen.getPoint());
//    }
//
//    public void KieuGetPointTest() {
//        gameScreen.setPoint(10);
//        assertEquals(10, gameScreen.getPoint());
//
//        gameScreen.setPoint(20);
//        assertEquals(20, gameScreen.getPoint());
//
//        gameScreen.setPoint(100);
//        assertEquals(100, gameScreen.getPoint());
//    }
}