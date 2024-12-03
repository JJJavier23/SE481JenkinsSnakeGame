package org.psnbtech;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class BoardPanelTest {
	private BoardPanel boardPanel;

    @BeforeEach
    public void setUp() {
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
