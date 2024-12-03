import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import org.psnbtech.BoardPanel;
import org.psnbtech.Clock;
import org.psnbtech.Direction;
import org.psnbtech.SnakeGame;
import org.psnbtech.TileType;

public class BoardPanelTest {
	private BoardPanel boardPanel;
    private TestSnakeGame game;

    @Before
    public void setUp() {
        game = new TestSnakeGame();
        boardPanel = new BoardPanel(game);
    }

    @Test
    public void testDrawTile_Path_1_2_9() {
        BufferedImage image = new BufferedImage(BoardPanel.COL_COUNT * BoardPanel.TILE_SIZE,
                BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        boardPanel.drawTile(0, 0, TileType.Fruit, graphics);
        assertTrue(isTileColorPresent(image, Color.RED));
    }
}
