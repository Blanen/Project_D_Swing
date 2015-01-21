/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Bart
 */
public class Level extends javax.swing.JPanel {
    
    BufferedImage image;
    int height = 0;
    
    public Level(){
        this.setMaximumSize(new Dimension(400, 400));
        setVisible(true);
        setBackground(Color.red);
        setBounds(0, 50, 400, 400);
        try{
            image = ImageIO.read(new File("wall.png"));
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                height+= 50;
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        //LevelButton lButton = new LevelButton(1, this)
    }
    
    public void setLevel(int level){
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, height, 50, null);
        
    }

    
    
    
    
}
