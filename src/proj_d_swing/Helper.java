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
        level.shortestPath();

    }

    public void addPath(Box[][] array) {
        Box endBox = findEnd(array);
        
        if(endBox!=null){
            
            endBox.lowestDistanceNeighboor().makePath();
            
        }
        else{
            System.out.println("EndBox = null");
        }
    }

    private Box findEnd(Box[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j].getObject() != null) {
                    if (array[i][j].getObject().getType().equals(ObjectType.End)) {
                        return array[i][j];
                    }

                }
            }

        }
        return null;

    }

}
