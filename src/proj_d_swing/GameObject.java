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
    
    Box box;
    
   
    
    public void destroy(){
        this.box.removeObject();
    }
    public void setBox(Box box){
        this.box = box;
    }
    
    public abstract void interactWith(GameObject go);
}
