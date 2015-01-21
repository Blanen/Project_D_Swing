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
    
    JPanel panel;
    int i;
    Level level;
    Panel pnl;
    
    public Frame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(410, 470);
        setVisible(true);
        //level = new Level();
        //add(level);

        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setFocusable(false);
        add(panel);
        this.setResizable(false);
        
        int posy = 95;
        for (i = 1; i < 4; i++) {
            panel.add(new levelButton(i, this, posy));
            
            posy = posy + 70;
            
        }
        
        
    }
    
    public void setLevel(int level) {
        buttonClicked(level);
    }
    
    public void buttonClicked(int lvl) {
        panel.setVisible(false);
        level = new Level(lvl);
        pnl = new Panel(this);
        level.setBounds(0, 35, 400, 400);
        //pnl.setBounds(0, 0, 400, 25);
        add(level);
        add(pnl);
        level.requestFocus();
        //level.buttonClicked();

    }
    
    public void TogglePaused(){
        level.TogglePaused();
    }
}
