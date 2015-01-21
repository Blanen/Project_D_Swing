/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Bart
 */
public class Frame extends JFrame {
    
    public Frame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 450);
        setVisible(true);
        Level level = new Level();
        add(level);
        level.setBounds(0, 50, 400, 400);
    }
    
}
