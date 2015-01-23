/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proj_d_swing.*;

/**
 *
 * @author Bart
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void InputTestWall(){
        Counter counter = new Counter(0, 0);
        Level level = new Level(3, counter);
        Player player = level.getPlayer();
        Box box = player.getBox();
        player.getBox().getNeighboor(Direction.Down).addObject(new Wall());
        player.inputDirection(Direction.Down);
        assertTrue(box.getObject().equals(player)&& !(box.getNeighboor(Direction.Down).getObject().equals(player)));
        
        
        
    }
    
    @Test
    public void InputTestNoWall(){
        Counter counter = new Counter(0, 0);
        Level level = new Level(3, counter);
        Player player = level.getPlayer();
        Box box = player.getBox();
        player.inputDirection(Direction.Down);
        assertTrue(box.getObject()==null&& box.getNeighboor(Direction.Down).getObject().equals(player));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
