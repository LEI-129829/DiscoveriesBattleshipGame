/**
 *
 */
package iscteiul.ista.battleship;

/**
 * This class represents a Galleon ship in the Battleship game.
 * It extends the Ship class and defines the specific characteristics of a Galleon, including its size and name.
 * The constructor initializes the Galleon's position based on its bearing and starting position.
 * 
 */

public class Galleon extends Ship {
    private static final Integer SIZE = 5;
    private static final String NAME = "Galeao";
    


    /**
     * @param bearing the bearing where the Galleon heads to
     * @param pos    initial point for positioning the Galleon
     * @exception IllegalArgumentException if the bearing is invalid
     * 
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");


        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;


            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon"); 
                
        }
    }

    /**    
     * 
     * @return the size of the Galleon ship. The size is set to 5.
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * 
     * @param pos the initial position for the Galleon when facing north
     */

    private void fillNorth(IPosition pos) { /* fill the positions for the galleon facing north */
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));  
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));

    }

    /**
     * 
     * @param pos the initial position for the Galleon when facing south
     */

    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * 
     * @param pos the initial position for the Galleon when facing east
     */

    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * 
     * @param pos the initial position for the Galleon when facing west
     */

    private void fillWest(IPosition pos) { 
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
