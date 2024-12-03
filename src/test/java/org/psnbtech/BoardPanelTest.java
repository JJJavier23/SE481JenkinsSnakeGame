package org.psnbtech;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardPanelTest {

    @Test
    public void testTileSize() {
        assertEquals(20, BoardPanel.TILE_SIZE, "Tile size should be 20 pixels");
    }

    @Test
    public void testBoardDimensions() {
        assertEquals(25, BoardPanel.COL_COUNT, "Board should be 25 columns wide");
        assertEquals(25, BoardPanel.ROW_COUNT, "Board should be 25 rows high");
    }

    @Test
    public void testBoardSize() {
        int expectedWidth = BoardPanel.TILE_SIZE * BoardPanel.COL_COUNT;  // 20 * 25 = 500
        int expectedHeight = BoardPanel.TILE_SIZE * BoardPanel.ROW_COUNT; // 20 * 25 = 500
        
        assertEquals(500, expectedWidth, "Board width should be 500 pixels");
        assertEquals(500, expectedHeight, "Board height should be 500 pixels");
    }
}
