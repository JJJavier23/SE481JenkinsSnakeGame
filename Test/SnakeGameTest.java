import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import org.junit.Test;
import org.psnbtech.Clock;
import org.psnbtech.Direction;
import org.psnbtech.SnakeGame;
import org.psnbtech.TileType;

public class SnakeGameTest {
	
	@Test
	public void testGameStart() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        assertEquals(snakeGame.isNewGame, true);
	}
	
	@Test
	public void testGamePause() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);
        
        assertEquals(snakeGame.isPaused, false);
	}
	
	@Test
	public void testGamePauseGameOver() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(1000);
        Thread.sleep(1000);
        
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);
        
        assertEquals(snakeGame.isPaused, false);

	}
	
	@Test
	public void testNewGame() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(1000);
        Thread.sleep(1000);
        
        assertEquals(snakeGame.isGameOver, true);

        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        assertEquals(snakeGame.isNewGame, false);

	}
	
	@Test
	public void testSnakeGameKeyListener() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        
		Direction last = snakeGame.directions.getFirst();
			
        assertEquals(Direction.North, last); //checks the previous key direction which was W = north
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        
        last = snakeGame.directions.getFirst();
        
        assertEquals(last, Direction.West); //checks the previous key direction which was A = West
        
        
        robot.delay(100);
        Thread.sleep(500);

        
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        
        last = snakeGame.directions.getFirst();
        
        
        assertEquals(last, Direction.South); //checks the previous key direction which was S = South
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        
        last = snakeGame.directions.getFirst();
        
        
        assertEquals(last, Direction.East); //checks the previous key direction which was D = East
        
        
	}
	
	@Test
	public void testSnakeGamePausedKeyListener() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        
        assertEquals(snakeGame.isPaused, true);

        
	}
	
	@Test
	public void testUpdateGameNextFruitScore10() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        for(int i = 0; i < 8; i++) {
        	robot.delay(100);
        	Thread.sleep(200);
        
        	robot.keyPress(KeyEvent.VK_W);
        	robot.keyRelease(KeyEvent.VK_W);
        
        	robot.delay(100);
        	Thread.sleep(200);
        
        	robot.keyPress(KeyEvent.VK_A);
        	robot.keyRelease(KeyEvent.VK_A);
        
        	robot.delay(100);
        	Thread.sleep(200);
        
        	robot.keyPress(KeyEvent.VK_S);
        	robot.keyRelease(KeyEvent.VK_S);
        
        	robot.delay(100);
        	Thread.sleep(200);
        
        	robot.keyPress(KeyEvent.VK_D);
        	robot.keyRelease(KeyEvent.VK_D);
        }
        
        assertEquals(snakeGame.nextFruitScore, 10);
        
	}
    
	@Test
	public void testSnakeGameGameOverKeyListener() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(1000);
        Thread.sleep(1000);
        
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        
        robot.delay(100);
        Thread.sleep(500);

        
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        
        robot.delay(100);
        Thread.sleep(500);

        
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        
        assertEquals(snakeGame.isGameOver, true);
        
	}
	
	@Test
	public void testEnter() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(100);
        Thread.sleep(500);
        
        assertFalse(snakeGame.isNewGame);
	}
	
	@Test
    public void testFruit() throws InterruptedException, AWTException {
		
        SnakeGame sg = new SnakeGame();
        
        sg.random = new Random();
        sg.snake = new LinkedList<>();
        sg.directions = new LinkedList<>();
        sg.logicTimer = new Clock(9.0f);
        sg.isNewGame = true;

        sg.snake.clear();
        Point head = new Point(5, 5);
        sg.snake.add(head);
        sg.board.setTile(head.x, head.y, TileType.SnakeHead);
        sg.board.setTile(head.x + 1, head.y, TileType.Fruit); 
        sg.directions.add(Direction.East);
        sg.updateGame();
        
        assertEquals("Fruits eaten should increment", 1, sg.fruitsEaten); 
      
	}
	
	@Test
	public void testNoneKey() throws IOException, InterruptedException, AWTException {
        SnakeGame snakeGame = new SnakeGame();

		Thread gameThread = new Thread(() -> {
            snakeGame.startGame();
        });
        gameThread.start();

        Thread.sleep(1000);
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);
        
        robot.delay(100);
        Thread.sleep(500);
        
        assertTrue(snakeGame.isNewGame);
	}
	
	@Test
    public void testDirSize() throws InterruptedException, AWTException {
		
        SnakeGame snakeG = new SnakeGame();
        
        snakeG.random = new Random();
        snakeG.snake = new LinkedList<>();
        snakeG.directions = new LinkedList<>();
        snakeG.logicTimer = new Clock(9.0f);
        snakeG.isNewGame = true;

        snakeG.directions.add(Direction.East);
        snakeG.directions.add(Direction.West);
        snakeG.directions.add(Direction.North);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(1000);
        Thread.sleep(1000);
        
        snakeG.directions.add(Direction.East);
        snakeG.directions.add(Direction.West);
        snakeG.directions.add(Direction.North);
        snakeG.directions.add(Direction.South);
        
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        
        snakeG.directions.add(Direction.East);
        snakeG.directions.add(Direction.West);
        snakeG.directions.add(Direction.North);
        snakeG.directions.add(Direction.South);
        
        robot.delay(100);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        
        snakeG.directions.add(Direction.East);
        snakeG.directions.add(Direction.West);
        snakeG.directions.add(Direction.North);
        snakeG.directions.add(Direction.South);
        
        robot.delay(100);
        Thread.sleep(500);

        
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        
        snakeG.directions.add(Direction.East);
        snakeG.directions.add(Direction.West);
        snakeG.directions.add(Direction.North);
        snakeG.directions.add(Direction.South);
        
        robot.delay(100);
        Thread.sleep(500);

        
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
      
	}
	
	@Test
    public void testDirPeekLast1() throws InterruptedException, AWTException {
		
        SnakeGame snakeG = new SnakeGame();
        
        Thread gameThread = new Thread(() -> {
            snakeG.startGame();
        });
        gameThread.start();


        Robot robot = new Robot();
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(500);
        Thread.sleep(500);
        
        snakeG.directions.addLast(Direction.West);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.delay(500);
        Thread.sleep(500);
	}
	
	@Test
    public void testDirPeekLast2() throws InterruptedException, AWTException {
		
        SnakeGame snakeG = new SnakeGame();
        
        Thread gameThread = new Thread(() -> {
            snakeG.startGame();
        });
        gameThread.start();


        Robot robot = new Robot();
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(500);
        Thread.sleep(500);
        
        snakeG.directions.addLast(Direction.East);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.delay(500);
        Thread.sleep(500);
	}
	
	@Test
    public void testDirPeekLast3() throws InterruptedException, AWTException {
		
        SnakeGame snakeG = new SnakeGame();
        
        Thread gameThread = new Thread(() -> {
            snakeG.startGame();
        });
        gameThread.start();


        Robot robot = new Robot();
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(500);
        Thread.sleep(500);
        
        snakeG.directions.addLast(Direction.East);
        
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.delay(500);
        Thread.sleep(500);
	}
	
	@Test
    public void testDirPeekLast4() throws InterruptedException, AWTException {
		
        SnakeGame snakeG = new SnakeGame();
        
        Thread gameThread = new Thread(() -> {
            snakeG.startGame();
        });
        gameThread.start();


        Robot robot = new Robot();
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(500);
        Thread.sleep(500);
        
        snakeG.directions.addLast(Direction.West);
        
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.delay(500);
        Thread.sleep(500);
	}
	
	@Test
    public void testDirPeekLast5() throws InterruptedException, AWTException {
		
        SnakeGame snakeG = new SnakeGame();
        
        Thread gameThread = new Thread(() -> {
            snakeG.startGame();
        });
        gameThread.start();


        Robot robot = new Robot();
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(500);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        
        robot.delay(500);
        Thread.sleep(500);
        
        snakeG.directions.addLast(Direction.North);
        
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.delay(500);
        Thread.sleep(500);
	}
	
	@Test
    public void testDirPeekLast6() throws InterruptedException, AWTException {
		
        SnakeGame snakeG = new SnakeGame();
        
        Thread gameThread = new Thread(() -> {
            snakeG.startGame();
        });
        gameThread.start();


        Robot robot = new Robot();
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(500);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        
        robot.delay(500);
        Thread.sleep(500);
        
        snakeG.directions.addLast(Direction.South);
        
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.delay(500);
        Thread.sleep(500);
	}
	
	
	@Test
    public void testDirPeekLast7() throws InterruptedException, AWTException {
		
        SnakeGame snakeG = new SnakeGame();
        
        Thread gameThread = new Thread(() -> {
            snakeG.startGame();
        });
        gameThread.start();


        Robot robot = new Robot();
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(500);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        
        robot.delay(500);
        Thread.sleep(500);
        
        snakeG.directions.addLast(Direction.South);
        
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.delay(500);
        Thread.sleep(500);
	}
	
	@Test
    public void testDirPeekLast8() throws InterruptedException, AWTException {
		
        SnakeGame snakeG = new SnakeGame();
        
        Thread gameThread = new Thread(() -> {
            snakeG.startGame();
        });
        gameThread.start();


        Robot robot = new Robot();
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.delay(500);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        
        robot.delay(500);
        Thread.sleep(500);
        
        snakeG.directions.addLast(Direction.North);
        
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.delay(500);
        Thread.sleep(500);
	}
}
