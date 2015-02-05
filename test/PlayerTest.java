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
    public void WalkTest1(){
        Counter counter = new Counter(0, 0);
        Level level = new Level(100, counter);
        Player player = level.getPlayer();
        level.getBoxArray()[10][10].addObject(player);
        Box box = player.getBox();
        player.setDirection(Direction.Left);
        player.inputDirection(Direction.Left);
        
        assertEquals(box.getNeighboor(Direction.Left).getObject(), player);
        assertEquals(player.getLastDir(), Direction.Left);
        
        
        
        
        
    }
    
    @Test
    public void WalkTest2(){
        Counter counter = new Counter(0, 0);
        Level level = new Level(100, counter);
        Player player = level.getPlayer();
        level.getBoxArray()[10][10].addObject(player);
        Box box = player.getBox();
        player.setDirection(Direction.Left);
        box.getNeighboor(Direction.Left).addObject(new Wall());
        player.inputDirection(Direction.Left);
        
        assertEquals(box, player.getBox());
        assertEquals(player.getLastDir(), Direction.Left);
        
        
        
        
        
    }
    @Test
    public void WalkTest3(){
        Counter counter = new Counter(0, 0);
        Level level = new Level(100, counter);
        Player player = level.getPlayer();
        level.getBoxArray()[10][10].addObject(player);
        Box box = player.getBox();
        player.setDirection(Direction.Right);
        player.inputDirection(Direction.Left);
        
        assertEquals(box, player.getBox());
        assertEquals(player.getLastDir(), Direction.Left);
        
        
        
        
        
    }
    @Test
    public void WalkTest4(){
        Counter counter = new Counter(0, 0);
        Level level = new Level(100, counter);
        Player player = level.getPlayer();
        level.getBoxArray()[10][10].addObject(player);
        Box box = player.getBox();
        player.setDirection(Direction.Left);
        player.inputDirection(Direction.Right);
        
        assertEquals(box, player.getBox());
        assertEquals(player.getLastDir(), Direction.Right);
        
        
        
        
        
    }
    
    @Test
    public void Shoot(){
        Counter counter = new Counter(0, 0);
        Level level = new Level(100, counter);
        Player player = level.getPlayer();
        level.getBoxArray()[10][10].addObject(player);
        Box box = player.getBox();
        
        player.setWeapon();
        
        box.getNeighboor(Direction.Left).addObject(new Wall());
        player.setDirection(Direction.Left);
        player.shoot();
        
        assertEquals(box.getNeighboor(Direction.Left).getObject(), null);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
