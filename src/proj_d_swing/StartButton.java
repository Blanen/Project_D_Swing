/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import java.awt.Dimension;
import javax.swing.JToggleButton;

/**
 *
 * @author Bart
 */
public class StartButton extends JToggleButton{
    
    int height = 25;
    int width = 150;
    int posx;
    int posy;
    
    public StartButton(int posx, int posy){
        this.setMinimumSize(new Dimension(width,height));
         this.posx = posx;
        this.posy = posy;
        this.setSize(25, 150);
       this.setBounds( posx, posy, width, height);
      this.setText("Start");
      setVisible(true);
        System.out.println("Start");
    }
}
