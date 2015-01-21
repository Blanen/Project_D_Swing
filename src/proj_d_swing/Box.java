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
        if (getNeighboor(d) != null) {

            if (boxMap.get(d).getObject() == null || boxMap.get(d).getObject().getType() != ObjectType.Wall) {
                getNeighboor(d).addObject(gameObject);
                removeObject();

            } else if (boxMap.get(d).getObject().getType() != ObjectType.Wall) {
                gameObject.interactWith(getNeighboor(d).getObject());
                getNeighboor(d).addObject(gameObject);
                removeObject();
            }

        }
    }

}
