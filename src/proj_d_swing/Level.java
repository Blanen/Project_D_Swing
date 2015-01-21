/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Bart
 */
public class Level extends javax.swing.JPanel {

    BufferedImage image;
    int i;

    JPanel panel;
    Frame frame;

    public Level(int lvl) {

        this.setMaximumSize(new Dimension(400, 400));

        //panel.setLayout(null);
        this.setVisible(true);
        setBackground(Color.black);

        try {
            image = ImageIO.read(new File("wall.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        g.create();
    }

    /**
     *
     */
}
