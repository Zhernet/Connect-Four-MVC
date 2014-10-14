package connectfour.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import connectfour.view.MockView;

public class GameTest {
    
    private Game game;
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Game( new MockView() );
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDisc method, of class Game.
     */
    @Test
    public void testAddDisc() {
        try {
            game.initialize();
            game.addDisc(0);   
            game.addDisc(0);
            game.addDisc(0);
            game.addDisc(0);
            game.addDisc(0);
            game.addDisc(0);
            game.addDisc(0);
            game.addDisc(0);
            game.addDisc(0);
            
        } catch (SamePlayerTwiceException e) {
            fail("SamePlayerTwiceException triggered.");
        }
        
    }
    
}
