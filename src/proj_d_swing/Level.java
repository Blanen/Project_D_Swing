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
import javax.swing.JPanel;

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
    int lvl;
    Player player;

    Box[][] boxArray = new Box[20][20];

    public Level(int lvl) {

        setFocusable(true);
        this.requestFocusInWindow();

        this.setMaximumSize(new Dimension(400, 400));
        player = new Player();
        initboxArray();

        //panel.setLayout(null);
        this.setVisible(true);
        setBackground(Color.black);
        loadImages();
        Keypressed();

        requestFocus();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("PAINT");

        for (int i = 0; i < boxArray.length; i++) {
            for (int j = 0; j < boxArray[0].length; j++) {
                if (boxArray[i][j].getObject() != null) {
                    if (boxArray[i][j].getObject().getType() == ObjectType.Player) {

                        Player player1 = (Player) boxArray[i][j].getObject();
                        if (player1.getLastDir() == Direction.Down) {
                            g.drawImage(playerDownImage, i * 20, j * 20, null);
                        } else if (player1.getLastDir() == Direction.Left) {
                            g.drawImage(playerLeftImage, i * 20, j * 20, null);
                        } else if (player1.getLastDir() == Direction.Up) {
                            g.drawImage(playerUpImage, i * 20, j * 20, null);
                        } else if (player1.getLastDir() == Direction.Right) {
                            g.drawImage(playerRightImage, i * 20, j * 20, null);
                        }

                    } else if (boxArray[i][j].getObject().getType() == ObjectType.Wall) {

                        g.drawImage(wallImage, i * 20, j * 20, null);

                    } else if (boxArray[i][j].getObject().getType() == ObjectType.End) {

                        g.drawImage(endImage, i * 20, j * 20, null);

                    } else if (boxArray[i][j].getObject().getType() == ObjectType.Weapon) {

                        //g.drawImage(Image, i*20, j*20, null);
                    } else if (boxArray[i][j].getObject().getType() == ObjectType.Helper) {

                        g.drawImage(helperImage, i * 20, j * 20, null);

                    }
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

        boxArray[10][10].addObject(player);
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

    public void Keypressed() {
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_UP)) {
                    System.out.println("woot!");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_UP)) {
                    //System.out.println("woot!");
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_UP)) {
                    System.out.println("UP!");
                    player.Move(Direction.Up);

                    repaint();
                }
                if ((e.getKeyCode() == KeyEvent.VK_RIGHT)) {
                    System.out.println("RIGHT!");
                    player.Move(Direction.Right);
                    repaint();
                }
                if ((e.getKeyCode() == KeyEvent.VK_LEFT)) {
                    System.out.println("LEFT!");
                    player.Move(Direction.Left);
                    repaint();

                }
                if ((e.getKeyCode() == KeyEvent.VK_DOWN)) {
                    System.out.println("DOWN!");
                    player.Move(Direction.Down);
                    repaint();

                }
                if ((e.getKeyCode() == KeyEvent.VK_SPACE)) {
                    System.out.println("POW!");
                    //player.Move(Direction.Space);
                    repaint();
                    
                }
            }

        });
    }
}
