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
public abstract class Movable extends GameObject {

    public Movable(Box box) {
        super(box);
    }

    
    public void Move(Direction d){
        box.moveObject(d);
    }
    
    public void setBox(Box box){
        this.box = box;
    }
    
    @Override
    public abstract void interactWith(GameObject go);
    
}
