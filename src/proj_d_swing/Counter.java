/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class Counter extends JLabel {

    int height = 25;
    int width = 100;
    int count = 0;
    int posx;
    int posy;

    public Counter(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        this.setBounds(posx, posy, width, height);
        this.setText(Integer.toString(count));
        setVisible(true);
        System.out.println("counter");
        this.setForeground(Color.white);
        this.setFocusable(false);
        
    }

    public void CounterTeller(){
        count++;
        setText(Integer.toString(count));
    
    }
    
    public void reset(){
        count = 0;
        setText(Integer.toString(count));
    }
}
