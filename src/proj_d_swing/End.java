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
public class End extends GameObject {
    
    Level level;

    public End(Level level){
        this.level = level;
    }

    @Override
    public ObjectType getType() {
        return ObjectType.End;
    }
    
    @Override
    public void interactWith(GameObject go){
        level.addLvl();
        level.restart();
    }
    
}
