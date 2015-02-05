/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Bart
 */
public class Box {

    int distance = 0;
    Boolean visible = true;

    GameObject gameObject;
    int x, y;

    Map<Direction, Box> boxMap = new EnumMap<>(Direction.class);

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addObject(GameObject go) {
        gameObject = go;
        gameObject.setBox(this);
        if (go.getType() == ObjectType.Player) {
            setVisible(true);
            for (Map.Entry<Direction, Box> boxEntry : boxMap.entrySet()) {
                boxEntry.getValue().setVisible(true);
            }

        }
    }

    public void removeObject() {
        gameObject = null;
    }

    public void addNeighboor(Direction d, Box b) {
        boxMap.put(d, b);
    }

    public Box getNeighboor(Direction d) {
        return boxMap.get(d);
    }

    public GameObject getObject() {
        return gameObject;
    }

    public void moveObject(Direction d) {
        if (getNeighboor(d).walkable()) {

            getNeighboor(d).interactObjects(gameObject);
            getNeighboor(d).addObject(gameObject);
            removeObject();

        }
    }

    public void interactObjects(GameObject go) {
        if (gameObject != null) {
            gameObject.interactWith(go);
        }
    }

    public Map<Direction, Box> getBoxMap() {

        return boxMap;

    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getVisible() {
        return visible;
    }

    public Box lowerDistanceNeighboor() {

        Box box = new Box(0, 0);
        box.distance = Integer.MAX_VALUE;

        for (Map.Entry<Direction, Box> boxEntry : boxMap.entrySet()) {
            if (distance != 1) {
                if (boxEntry.getValue().distance != 0 && boxEntry.getValue().distance < box.distance) {
                    box = boxEntry.getValue();
                }
            }
            else{
                if(boxEntry.getValue().distance<box.distance){
                    box = boxEntry.getValue();
                }
            }
        }

        return box;

    }

    public void makePath() {
        

        System.out.println(distance);
        if (distance != 0) {
            lowerDistanceNeighboor().makePath();
            if (gameObject == null) {
                addObject(new PathPoint());
            }
        }
    }

    public boolean walkable() {
        if (gameObject == null) {
            return true;
        } else {
            return gameObject.walkable();
        }
    }

    public void getShot() {
        if (gameObject != null) {
            gameObject.getShot();
        }
    }

}
