/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_d_swing;

/**
 *
 * @author Bart
 */
public class Player extends Movable {

    Direction lastDir = Direction.Down;

    boolean weapon = true;

    public void setWeapon() {
        weapon = true;
    }

    @Override
    public void interactWith(GameObject go) {

    }

    @Override
    public ObjectType getType() {
        return ObjectType.Player;
    }

    public Direction getLastDir() {
        return lastDir;
    }

    public void shoot() {
        if (weapon) {
            if (box.getNeighboor(lastDir) != null) {
                if (box.getNeighboor(lastDir).getObject() != null) {
                    if (box.getNeighboor(lastDir).getObject().getType() != ObjectType.End) {
                        box.getNeighboor(lastDir).removeObject();
                    }
                }

                weapon = false;
            }
        }
    }

    public void inputDirection(Direction d) {
        if (lastDir == d) {
            Move(d);
        }
        lastDir = d;
    }

}
