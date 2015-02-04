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
public class Enemy extends Movable{

    @Override
    public void interactWith(GameObject go) {
         Player player = (Player)go;
         player.level.restart();
    }

    @Override
    public ObjectType getType() {
        return ObjectType.Enemy;
    }
    
}
