/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import proj_d_swing.Level;

/**
 *
 * @author Asus
 */
public class levelButton extends JButton {

    int x = 35;
    int y = 200;
    int level;
    int posx = 95;
    int posy;
    

    public levelButton(final int lvl, final Frame frame, int posy) {
        setVisible(true);
        this.posy = posy;
        this.setBounds(posx, posy, y, x);
        this.setText("Level " + lvl);
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                System.out.println("You clicked the button "+ lvl);
                frame.setLevel(lvl);
                
                
            }
        });
    }
}
