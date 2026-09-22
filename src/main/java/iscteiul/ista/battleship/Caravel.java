/**
 *
 */
package iscteiul.ista.battleship;

/**
 * This class represents a Caravel ship in the Battleship game. 
 * It extends the Ship class and defines the specific characteristics of a Caravel, including its size and name. 
 * The constructor initializes the Caravel's position based on its bearing and starting position.
 *
 */

public class Caravel extends Ship {
    private static final Integer SIZE = 2;
    private static final String NAME = "Caravela";

    /**
     * @param bearing the bearing where the Caravel heads to
     * @param pos     initial point for positioning the Caravel
     * @throws NullPointerException     if the bearing is null
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

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
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /*
     * Returns the size of the Caravel ship as an Integer. The size is defined as 2.
     * 
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}

