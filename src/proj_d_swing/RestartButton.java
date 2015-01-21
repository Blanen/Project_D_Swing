/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import javax.swing.JButton;

/**
 *
 * @author Asus
 */
public class RestartButton extends JButton {

    int height = 25;
    int width = 150;
    int posx;
    int posy;

    public RestartButton(int posx, int posy) {
        this.posx = posy;
        this.posy = posy;
        this.setBounds(posx, posy, width, height);
        this.setText("Restart");
        setVisible(true);
    }
}
