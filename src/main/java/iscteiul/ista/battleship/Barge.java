/**
 *
 */
package iscteiul.ista.battleship;

/**
 * 
 * this ship occupies only one position in the board and can be placed in any direction
 */


public class Barge extends Ship {

    /*
    here we are going to define the size and name of the barge (constructor)
    */

    private static final Integer SIZE = 1;
    /*
    this line shows the size of the barge
    */

    private static final String NAME = "Barca";
    /*
    this line shows the name of the barge (Barca)   
    */

    /**
     * @param bearing - barge bearing
     * @param pos     - upper left position of the barge
     */

    public Barge(Compass bearing, IPosition pos) {

        super(Barge.NAME, bearing, pos);

         /*
        in here we are going to call the constructor of the super class (Ship) and pass the name, direction and position of the barge
        */

        getPositions().add(new Position(pos.getRow(), pos.getColumn()));

        /*
        getPositions() method is used to get the positions of the barge and add the position of the barge to the list of positions
        */


    }

    @Override
    public Integer getSize() {
        return SIZE;

    /*
    this method is for the size of the barge
    */

    }

}
