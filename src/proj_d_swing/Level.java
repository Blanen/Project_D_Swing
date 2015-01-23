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
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;
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
    boolean paused = true;
    Counter counter;

    Box[][] boxArray = new Box[20][20];

    public Level(int lvl, Counter counter) {

        this.lvl = lvl;
        this.counter = counter;

        setFocusable(true);
        this.requestFocusInWindow();

        this.setMaximumSize(new Dimension(400, 400));
        player = new Player(this);
        initboxArray();

        //panel.setLayout(null);
        this.setVisible(true);
        setBackground(Color.black);
        loadImages();
        Keypressed();

        requestFocus();
        loadLevel();

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

        for (int i = 0; i < boxArray.length; i++) {
            for (int j = 0; j < boxArray[0].length; j++) {
                if (j > 0) {
                    boxArray[i][j].addNeighboor(Direction.Up, boxArray[i][j - 1]);
                }
                if (i > 0) {
                    boxArray[i][j].addNeighboor(Direction.Left, boxArray[i - 1][j]);
                }
                if (j < boxArray[0].length - 1) {
                    boxArray[i][j].addNeighboor(Direction.Down, boxArray[i][j + 1]);
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

    public void TogglePaused() {

        paused = !paused;
        System.out.println(paused);
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
                if (!paused) {
                    if ((e.getKeyCode() == KeyEvent.VK_UP)) {
                        System.out.println("UP!");

                        counter.CounterTeller();
                        player.inputDirection(Direction.Up);

                        repaint();
                    }
                    if ((e.getKeyCode() == KeyEvent.VK_RIGHT)) {
                        System.out.println("RIGHT!");

                        counter.CounterTeller();

                        player.inputDirection(Direction.Right);
                        repaint();
                    }
                    if ((e.getKeyCode() == KeyEvent.VK_LEFT)) {
                        System.out.println("LEFT!");

                        counter.CounterTeller();
                        player.inputDirection(Direction.Left);
                        repaint();

                    }
                    if ((e.getKeyCode() == KeyEvent.VK_DOWN)) {
                        System.out.println("DOWN!");

                        counter.CounterTeller();
                        player.inputDirection(Direction.Down);
                        repaint();

                    }
                    if ((e.getKeyCode() == KeyEvent.VK_SPACE)) {
                        System.out.println("POW!");
                        player.shoot();
                        repaint();

                    }
                }
            }

        });
    }

    private void loadLevel() {
        if (lvl == 1) {
            String[][] array = {
                {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                {"W", "o", "o", "W", "W", "o", "o", "o", "o", "o", "o", "o", "o", "W", "o", "o", "o", "o", "W", "W"},
                {"W", "o", "W", "W", "W", "o", "W", "W", "W", "W", "W", "W", "o", "W", "W", "o", "W", "o", "W", "W"},
                {"W", "o", "o", "W", "W", "o", "W", "W", "W", "W", "o", "o", "o", "o", "o", "o", "W", "o", "W", "W"},
                {"W", "W", "o", "W", "W", "o", "W", "W", "W", "W", "W", "W", "W", "o", "W", "W", "W", "o", "W", "W"},
                {"W", "o", "o", "W", "W", "o", "W", "W", "W", "W", "W", "o", "W", "o", "W", "W", "W", "o", "W", "W"},
                {"W", "o", "W", "W", "W", "o", "o", "o", "W", "W", "W", "o", "W", "o", "W", "o", "W", "o", "W", "W"},
                {"W", "o", "W", "W", "W", "W", "W", "o", "W", "W", "W", "o", "W", "o", "W", "o", "W", "o", "o", "W"},
                {"W", "o", "o", "o", "o", "o", "o", "o", "o", "o", "W", "o", "o", "o", "o", "o", "W", "W", "o", "W"},
                {"W", "o", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "o", "W", "W", "W", "W", "W", "o", "W"},
                {"W", "o", "o", "W", "W", "W", "W", "W", "W", "W", "W", "W", "o", "W", "W", "W", "o", "o", "o", "W"},
                {"W", "W", "o", "W", "W", "W", "W", "W", "W", "W", "W", "W", "o", "W", "W", "W", "o", "W", "W", "W"},
                {"W", "o", "o", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "o", "o", "o", "W"},
                {"W", "o", "W", "o", "o", "o", "o", "o", "o", "o", "o", "W", "W", "W", "W", "W", "o", "W", "o", "W"},
                {"W", "o", "W", "W", "o", "W", "W", "W", "W", "W", "o", "W", "W", "o", "o", "o", "o", "o", "o", "W"},
                {"W", "o", "W", "W", "o", "o", "W", "o", "W", "W", "o", "W", "W", "W", "o", "W", "W", "W", "W", "W"},
                {"W", "o", "W", "W", "W", "o", "W", "o", "W", "o", "o", "W", "W", "W", "o", "W", "W", "W", "W", "W"},
                {"W", "o", "W", "W", "W", "o", "W", "o", "W", "o", "W", "W", "W", "W", "o", "o", "o", "o", "o", "W"},
                {"W", "o", "o", "o", "o", "o", "W", "o", "o", "o", "W", "W", "W", "W", "W", "W", "W", "W", "P", "E"},
                {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}};
            readArray(array);
        } else if (lvl == 2) {
            System.out.println("Level 2!");
            String[][] array = {
                {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "o", "o", "o", "o", "W", "o", "E"},
                {"W", "W", "o", "o", "o", "o", "o", "o", "o", "o", "o", "W", "W", "o", "o", "o", "o", "W", "o", "W"},
                {"W", "W", "o", "W", "o", "W", "W", "W", "W", "W", "o", "W", "W", "o", "o", "o", "o", "W", "o", "W"},
                {"W", "W", "o", "W", "o", "W", "W", "o", "W", "o", "o", "o", "W", "W", "o", "o", "W", "W", "o", "W"},
                {"W", "W", "o", "W", "o", "W", "W", "o", "W", "o", "W", "o", "W", "W", "W", "o", "o", "o", "o", "W"},
                {"W", "o", "o", "W", "W", "W", "o", "o", "W", "o", "W", "o", "o", "o", "W", "W", "o", "o", "o", "W"},
                {"W", "o", "W", "W", "W", "W", "o", "o", "W", "o", "W", "W", "W", "W", "W", "W", "W", "W", "o", "W"},
                {"W", "o", "o", "o", "o", "o", "o", "o", "W", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "W"},
                {"W", "W", "W", "W", "W", "W", "W", "o", "W", "W", "W", "W", "o", "o", "W", "W", "W", "W", "W", "W"},
                {"W", "o", "o", "o", "o", "o", "W", "o", "W", "W", "W", "o", "o", "o", "o", "o", "o", "o", "o", "W"},
                {"W", "o", "W", "W", "W", "o", "W", "o", "o", "o", "W", "o", "o", "o", "o", "o", "o", "o", "o", "W"},
                {"W", "o", "W", "W", "o", "o", "W", "W", "W", "o", "W", "W", "W", "W", "W", "W", "W", "W", "o", "W"},
                {"W", "o", "W", "W", "o", "W", "W", "W", "W", "o", "W", "W", "W", "W", "W", "W", "W", "W", "o", "W"},
                {"W", "o", "W", "W", "o", "W", "W", "W", "W", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "W"},
                {"W", "o", "W", "W", "o", "o", "o", "o", "o", "o", "W", "W", "W", "W", "W", "W", "o", "W", "W", "W"},
                {"W", "o", "W", "W", "W", "o", "W", "W", "W", "o", "W", "W", "W", "W", "W", "W", "o", "W", "o", "W"},
                {"W", "o", "W", "W", "W", "o", "W", "W", "W", "o", "W", "W", "W", "W", "W", "W", "o", "o", "o", "W"},
                {"W", "P", "W", "W", "W", "W", "W", "o", "o", "o", "o", "o", "o", "o", "o", "W", "W", "W", "W", "W"},
                {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
            };
            readArray(array);

        } else if (lvl == 3) {

            boxArray[10][10].addObject(player);

        }
    }

    public void LevelUp() {
        lvl++;
        restart();

    }

    private void readArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals("W")) {
                    boxArray[array.length - 1 - i][j].addObject(new Wall());
                }
                if (array[i][j].equals("E")) {
                    boxArray[array.length - 1 - i][j].addObject(new End());
                }
                if (array[i][j].equals("P")) {
                    boxArray[array.length - 1 - i][j].addObject(player);
                }
            }
        }
    }

    public void shortestPath() {
        ArrayList<Box> Unvisited = new ArrayList<>();
        for (int i = 0; i < boxArray.length; i++) {
            for (int j = 0; i < boxArray[0].length; j++) {
                boxArray[i][j].distance = 0;
                Unvisited.add(boxArray[i][j]);
            }
        }
        Box currentBox = player.getBox();
        currentBox.distance = Integer.MAX_VALUE;
        while (true) {

        }
    }

    public Player getPlayer() {
        return player;
    }

    public void restart() {
        player = new Player(this);
        initboxArray();
        loadLevel();
        repaint();
        counter.reset();
    }

    public void pathFind() {
        ArrayList<Box> unvisitedList = new ArrayList<>();
        ArrayList<Box> visitedList = new ArrayList<>();

        int distanceto = Integer.MAX_VALUE;
        for (int i = 0; i < boxArray.length; i++) {
            for (int j = 0; j < boxArray[0].length; j++) {
                if (boxArray[i][j].getObject() == null) {
                    boxArray[i][j].distance = Integer.MAX_VALUE;
                    //unvisitedList.add(boxArray[i][j]);

                }
            }

        }

        Box sourceBox = player.getBox();
        sourceBox.distance = 0;
        unvisitedList.add(sourceBox);

        while (!unvisitedList.isEmpty()) {

            Box currentBox = getBoxWithLowestDistance(unvisitedList);

            unvisitedList.remove(currentBox);
            visitedList.add(currentBox);

            evaluateNeighbors(currentBox, visitedList, unvisitedList);

        }
        
    }

    public Box getBoxWithLowestDistance(ArrayList<Box> boxList) {

        int distance = Integer.MAX_VALUE;

        Box returnBox = null;

        for (Box box : boxList) {

            if (box.distance < distance) {
                returnBox = box;

            }

        }

        return returnBox;

    }

    private void evaluateNeighbors(Box box, ArrayList<Box> visitedList, ArrayList<Box> unvisitedList) {
        for (Map.Entry<Direction, Box> destinationEntry : box.getBoxMap().entrySet()) {
            if (destinationEntry.getValue() != null) {

                if (destinationEntry.getValue().getObject() == null) {

                    int edgeDistance = 1;
                    int newDistance = box.distance + edgeDistance;
                    if (destinationEntry.getValue().distance > newDistance) {
                        destinationEntry.getValue().distance = newDistance;
                        unvisitedList.add(destinationEntry.getValue());
                    }
                }
            }
        }
    }

}
