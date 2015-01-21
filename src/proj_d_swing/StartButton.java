/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JToggleButton;

/**
 *
 * @author Bart
 */
public class StartButton extends JToggleButton {

    int height = 25;
    int width = 150;
    int posx;
    int posy;
    Frame frame;

    public StartButton(int posx, int posy, Frame frame) {
        this.setMinimumSize(new Dimension(width, height));
        this.posx = posx;
        this.posy = posy;
        this.setSize(25, 150);
        this.setBounds(posx, posy, width, height);
        this.setText("Start");
        setVisible(true);
        this.frame=frame;
        System.out.println("Start");
        this.setFocusable(false);
        ButtonPressed();

    }

    public void ButtonPressed() {

        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed

                frame.TogglePaused();
            }
        });
    }
}
