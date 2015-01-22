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

    BufferedImage wallImage;
    BufferedImage playerLeftImage;
    BufferedImage playerRightImage;
    BufferedImage playerUpImage;
    BufferedImage playerDownImage;
    BufferedImage helperImage;
    BufferedImage endImage;
    BufferedImage weaponImage;
    
    int height = 0;
    Box[][] boxArray = new Box[20][20];

    public Level() {
        setFocusable(true);
        requestFocus();
        loadImages();
        this.setMaximumSize(new Dimension(400, 400));
        setVisible(true);
        setBackground(Color.red);
        setBounds(0, 50, 400, 400);
        

        initboxArray();

        //LevelButton lButton = new LevelButton(1, this)
    }

    public void setLevel(int level) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(int i = 0; i<boxArray.length;i++){
            for(int j=0; j<boxArray[0].length;j++){
                if(boxArray[i][j].getObject().getType()==ObjectType.Player){
                    
                   Player player = (Player)boxArray[i][j].getObject();
                   if(player.getLastDir()==Direction.Down){
                       g.drawImage(playerDownImage, i*20, j*20, null);
                   }
                   else if(player.getLastDir()==Direction.Left){
                       g.drawImage(playerLeftImage, i*20, j*20, null);
                   }
                   else if(player.getLastDir()==Direction.Up){
                       g.drawImage(playerUpImage, i*20, j*20, null);
                   }
                   else if(player.getLastDir()==Direction.Right){
                       g.drawImage(playerRightImage, i*20, j*20, null);
                   }
                    
                }
                else if(boxArray[i][j].getObject().getType()==ObjectType.Wall){
                    
                    g.drawImage(wallImage, i*20, j*20, null);
                    
                }
                else if(boxArray[i][j].getObject().getType()==ObjectType.End){
                    
                    g.drawImage(endImage, i*20, j*20, null);
                    
                }
                else if(boxArray[i][j].getObject().getType()==ObjectType.Weapon){
                    
                    //g.drawImage(Image, i*20, j*20, null);
                    
                }
                else if(boxArray[i][j].getObject().getType()==ObjectType.Helper){
                    
                    g.drawImage(helperImage, i*20, j*20, null);
                    
                }
            }
        }
        

    }

    public final void initboxArray() {
        for (Box[] boxArray1 : boxArray) {
            for (int j = 0; j < boxArray[0].length; j++) {
                boxArray1[j] = new Box(boxArray.length, boxArray[0].length);
            }
        }
        for (int i = 0; i < boxArray.length; i++) {
            for (int j = 0; j < boxArray[0].length; j++) {
                if (j > 0) {
                    boxArray[i][j].addNeighboor(Direction.Down, boxArray[i][j - 1]);
                }
                if (i > 0) {
                    boxArray[i][j].addNeighboor(Direction.Left, boxArray[i - 1][j]);
                }
                if (j < boxArray[0].length - 1) {
                    boxArray[i][j].addNeighboor(Direction.Up, boxArray[i][j + 1]);
                }
                if (i < boxArray.length - 1) {
                    boxArray[i][j].addNeighboor(Direction.Right, boxArray[i + 1][j]);
                }
            }
        }
    }

    private void loadImages() {
        
        try {
            playerLeftImage = ImageIO.read(new File("Player_Left.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            playerRightImage = ImageIO.read(new File("Player_Right.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            playerDownImage = ImageIO.read(new File("Player_Down.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            playerUpImage = ImageIO.read(new File("Player_Up.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            wallImage = ImageIO.read(new File("wall.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            helperImage = ImageIO.read(new File("Circle_small.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            endImage = ImageIO.read(new File("Circle.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            weaponImage = ImageIO.read(new File("Circle.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        
        
    }

}
