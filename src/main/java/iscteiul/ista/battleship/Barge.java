/**
 *
 */
package iscteiul.ista.battleship;


/**
 * This class represents a Barge ship in the Battleship game. 
 * It extends the Ship class and defines the specific characteristics of a Barge, including its size and name. 
 * The constructor initializes the Barge's position based on its bearing and starting position.
 *
 */

public class Barge extends Ship {

    private static final Integer SIZE = 1;
    
    private static final String NAME = "Barca";

    /**
     * @param bearing - barge bearing
     * @param pos     - upper left position of the barge
     */

    public Barge(Compass bearing, IPosition pos) {

        super(Barge.NAME, bearing, pos);


        getPositions().add(new Position(pos.getRow(), pos.getColumn()));



    }

/**    
     * @return the size of the barge ship. The size is set to 1.
     * 
     */

    @Override
    public Integer getSize() {
        return SIZE;
    }

}
