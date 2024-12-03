package org.psnbtech;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

public class BoardPanelTest {
	private BoardPanel boardPanel;
	private SnakeGame game;

    @BeforeEach
    public void setUp() {
        game = new SnakeGame();
        boardPanel = new BoardPanel(game);
    }

    @Test
    public void testDrawTile_Path_1_2_9() {
        BufferedImage image = new BufferedImage(BoardPanel.COL_COUNT * BoardPanel.TILE_SIZE,
                BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        boardPanel.drawTile(0, 0, TileType.Fruit, graphics);
        
        int rgb = image.getRGB(BoardPanel.TILE_SIZE/2, BoardPanel.TILE_SIZE/2);
        Color pixelColor = new Color(rgb);
        assertEquals(Color.RED, pixelColor);
    }
}
