/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Bart
 */
public class Frame extends JFrame {
    
    JPanel levelButtonPanel;
    int i;
    Level level;
    Panel controlPanel;
    Counter counter;
    
    public Frame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(410, 470);
        setVisible(true);
        //level = new Level();
        //add(level);

        levelButtonPanel = new JPanel();
        levelButtonPanel.setBackground(Color.black);
        levelButtonPanel.setFocusable(false);
        add(levelButtonPanel);
        
        this.setResizable(false);
        
        int posy = 95;
        for (i = 1; i < 4; i++) {
            levelButtonPanel.add(new levelButton(i, this, posy));
            
            posy = posy + 70;
            
        }
        
        
    }
    
    public void setLevel(int level) {
        buttonClicked(level);
    }
    
    public void buttonClicked(int lvl) {
        levelButtonPanel.setVisible(false);
        
        
        controlPanel = new Panel(this);
        this.counter=controlPanel.counter;
        level = new Level(lvl,counter);
        level.setBounds(0, 35, 400, 400);
        //pnl.setBounds(0, 0, 400, 25);
        
        add(level);
        add(controlPanel);
        level.requestFocus();
        //level.buttonClicked();

    }
    
    public void TogglePaused(){
        level.TogglePaused();
    }
    
    public void restart(){
        level.restart();
    }
}
