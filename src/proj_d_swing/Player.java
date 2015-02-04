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
    Level level;
    boolean weapon = false;

    public Player(Level level) {
        this.level = level;
    }

    public void setWeapon() {
        weapon = true;
    }

    @Override
    public void interactWith(GameObject go) {
        System.out.println("INTERACT");
        

       
       
    }

    @Override
    public ObjectType getType() {
        return ObjectType.Player;
    }

    public Direction getLastDir() {
        return lastDir;
    }

    public void shoot() {
        if(weapon){
            getBox().getNeighboor(lastDir).getShot();
            weapon =false;
        }
    }

    public void inputDirection(Direction d) {
        if (lastDir == d) {
            Move(d);
        }
        lastDir = d;
    }

    public void setDirection(Direction d) {
        lastDir = d;
    }

    public Direction getDirection() {
        
        return lastDir;

    }
}
