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
public abstract class GameObject {
    
    public abstract ObjectType getType();
    
    public Boolean walkable(){
        return true;
    }
    
    Box box;
    
   
    
    public void destroy(){
        this.box.removeObject();
    }
    public void setBox(Box box){
        this.box = box;
    }
    
    public Box getBox(){
        return box;
    }
    
    public abstract void interactWith(GameObject go);
}
