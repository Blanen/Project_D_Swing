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
public class Wall extends GameObject {



    @Override
    public ObjectType getType() {
        return ObjectType.Wall;
    }

    @Override
    public void interactWith(GameObject go) {
        
    }
    
}
