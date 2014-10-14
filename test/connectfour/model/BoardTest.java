package connectfour.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    
    private Board board;
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board = new Board();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of reset method.
     */
    @Test
    public void testReset() {
        board.reset();
        assertTrue( boardIsEmpty( board.getBoard() ) );
        
        for (int i = 0; i < board.getBoard().length; i++) {
            board.addDisc(Cell.PLAYER1, i);
            board.addDisc(Cell.PLAYER2, i);
        }
        assertFalse( boardIsEmpty( board.getBoard() ) );
        
        board.reset();
        assertTrue( boardIsEmpty( board.getBoard() ) );
    }
    
    public boolean boardIsEmpty(Cell[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] != Cell.EMPTY)
                    return false;
        
        return true;
    }

    /**
     * Test of addDisc method.
     */
    @Test
    public void testAddDisc() {
        board.reset();        
        board.addDisc(Cell.PLAYER1, 0);
        assertTrue(board.getBoard()[0][0] == Cell.EMPTY);
        assertTrue(board.getBoard()[0][Board.HEIGHT - 1] == Cell.PLAYER1);
        
        board.reset();   
        board.addDisc(Cell.PLAYER2, 3);
        assertTrue(board.getBoard()[3][0] == Cell.EMPTY);
        assertTrue(board.getBoard()[3][Board.HEIGHT - 1] == Cell.PLAYER2);
        
        board.reset();   
        board.addDisc(Cell.PLAYER1, Board.WIDTH- 1);
        assertTrue(board.getBoard()[Board.WIDTH- 1][0] == Cell.EMPTY);
        assertTrue(board.getBoard()[Board.WIDTH- 1][Board.HEIGHT - 1] == Cell.PLAYER1);
    }
    
    /**
     * Test of addDisc method with invalid cells.
     */    
    @Test
    public void testAddDiscWithInvalidCell() {
        try {
            board.addDisc(null, 0);            
            fail("NullCellException was expected");            
        } catch (NullCellException e) {
        }
        
        try {
            board.addDisc(Cell.EMPTY, 0);            
            fail("NullCellException was expected");            
        } catch (NullCellException e) {
        }
        
    }
    
    /**
     * Test of addDisc method with an invalid column.
     */        
    @Test
    public void testAddDiscWithInvalidColumn() {
        try {
            board.addDisc(Cell.PLAYER1, -1);            
            fail("InvalidColumnException was expected");            
        } catch (InvalidColumnException e) {
        }
        
        try {
            board.addDisc(Cell.PLAYER2, -1);            
            fail("InvalidColumnException was expected");            
        } catch (InvalidColumnException e) {
        }
        
        try {
            board.addDisc(Cell.PLAYER1, Board.WIDTH);            
            fail("InvalidColumnException was expected");            
        } catch (InvalidColumnException e) {
        }
            
        try {
            board.addDisc(Cell.PLAYER2, Board.WIDTH);            
            fail("InvalidColumnException was expected");            
        } catch (InvalidColumnException e) {
        }
    }

    /**
     * Test of addDisc method with a full column.
     */    
    @Test(expected = ColumnFullException.class)
    public void testAddDiscWithFullColumn() {
        for (int i = 0; i < Board.HEIGHT + 9999999; i++)
                board.addDisc(Cell.PLAYER1, 0);
    }    
              
    /**
     * Test of boardIsFull method.
     */
    @Test
    public void testBoardIsFull() {
        assertFalse( board.boardIsFull() );
        
        for (int col = 0; col < Board.WIDTH; col++)
            for (int i = 0; i < Board.HEIGHT; i++)
                board.addDisc(Cell.PLAYER1, col);
        assertTrue( board.boardIsFull() );
        
        board.reset();
        assertFalse( board.boardIsFull() );
    }

    /**
     * Test of playerHasWon method as horizontal Connect Four.
     */
    @Test
    public void testConnectFourHorizontal() {
        assertFalse( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
        
        board.addDisc(Cell.PLAYER1, 0);
        board.addDisc(Cell.PLAYER1, 1);
        board.addDisc(Cell.PLAYER1, 2);
        board.addDisc(Cell.PLAYER1, 3);   
        assertTrue( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
        
        board.reset();
        board.addDisc(Cell.PLAYER1, 0);
        board.addDisc(Cell.PLAYER1, 1);
        board.addDisc(Cell.PLAYER1, 3);
        board.addDisc(Cell.PLAYER1, 4); 
        assertFalse( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
    }
    
    /**
     * Test of playerHasWon method as vertical Connect Four.
     */
    @Test
    public void testConnectFourVertical() {
        assertFalse( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
        
        board.addDisc(Cell.PLAYER1, 0);
        board.addDisc(Cell.PLAYER1, 0);
        board.addDisc(Cell.PLAYER1, 0);
        board.addDisc(Cell.PLAYER1, 0);
        assertTrue( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
        
        board.reset();
        board.addDisc(Cell.PLAYER1, 0);
        board.addDisc(Cell.PLAYER1, 0);
        board.addDisc(Cell.PLAYER2, 0);
        board.addDisc(Cell.PLAYER1, 0);
        board.addDisc(Cell.PLAYER1, 0);
        assertFalse( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
    }
    
    /**
     * Test of playerHasWon method as diagonal lower right Connect Four.
     */
    @Test
    public void testConnectFourDiagonalLowerRight() {
        assertFalse( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
        
        board.addDisc(Cell.PLAYER1, Board.WIDTH - 1);
        board.addDisc(Cell.PLAYER2, Board.WIDTH -  2);        
        board.addDisc(Cell.PLAYER1, Board.WIDTH -  2);
        board.addDisc(Cell.PLAYER2, Board.WIDTH -  3);        
        board.addDisc(Cell.PLAYER1, Board.WIDTH -  3);
        board.addDisc(Cell.PLAYER2, Board.WIDTH -  4);        
        board.addDisc(Cell.PLAYER1, Board.WIDTH -  3);
        board.addDisc(Cell.PLAYER2, Board.WIDTH -  4);        
        board.addDisc(Cell.PLAYER1, Board.WIDTH -  4);
        board.addDisc(Cell.PLAYER2, 0);        
        board.addDisc(Cell.PLAYER1, Board.WIDTH -  4);
        
        assertTrue( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
    }
    
    /**
     * Test of playerHasWon method as diagonal lower left Connect Four.
     */
    @Test
    public void testConnectFourDiagonalLowerLeft() {
        assertFalse( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
        
        board.addDisc(Cell.PLAYER1, 0);
        board.addDisc(Cell.PLAYER2, 1);        
        board.addDisc(Cell.PLAYER1, 1);
        board.addDisc(Cell.PLAYER2, 2);        
        board.addDisc(Cell.PLAYER1, 2);
        board.addDisc(Cell.PLAYER2, 3);        
        board.addDisc(Cell.PLAYER1, 2);
        board.addDisc(Cell.PLAYER2, 3);        
        board.addDisc(Cell.PLAYER1, 3);
        board.addDisc(Cell.PLAYER2, Board.WIDTH - 1);        
        board.addDisc(Cell.PLAYER1, 3);
        
        assertTrue( board.playerHasWon(Cell.PLAYER1) );
        assertFalse( board.playerHasWon(Cell.PLAYER2) );
    }
}
