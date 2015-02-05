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
public class Helper extends GameObject {

    Level level;

    public Helper(Level level) {
        this.level = level;
    }

    @Override
    public ObjectType getType() {
        return ObjectType.Helper;
    }

    @Override
    public void interactWith(GameObject go) {
        level.pathFind();

    }

}
