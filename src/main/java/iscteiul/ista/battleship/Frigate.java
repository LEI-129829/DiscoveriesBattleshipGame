/**
 *
 */
package iscteiul.ista.battleship;

/**
 * This class represents a Frigate ship in the Battleship game.
 * It extends the Ship class and defines the specific characteristics of a Frigate, including its size and name.
 * The constructor initializes the Frigate's position based on its bearing and starting position.
 * 
 */

public class Frigate extends Ship {
    private static final Integer SIZE = 4;
    private static final String NAME = "Fragata";

    /**
     * @param bearing the bearing where the Frigate heads to
     * @param pos     initial point for positioning the Frigate
     * @exception IllegalArgumentException if the bearing is invalid
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the frigate");
        }
    }

    /**
     * @return the size of the Frigate ship. The size is set to 4.
     *
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}
