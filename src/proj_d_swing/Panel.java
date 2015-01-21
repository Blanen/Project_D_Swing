/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class Panel extends JPanel {

    StartButton start;
    RestartButton restart;
    Counter counter;

    public Panel(Frame frame) {
        // this.setMaximumSize(new Dimension(400, 400));
        this.setMinimumSize(new Dimension(400, 25));
        this.setBounds(0, 0, 400, 25);
        start = new StartButton(0, 0,frame);
        restart = new RestartButton(150, 0);
        counter = new Counter(300, 0);
        this.setBackground(Color.black);

        add(start);
        add(restart);
        add(counter);
        setVisible(true);
    }
}
