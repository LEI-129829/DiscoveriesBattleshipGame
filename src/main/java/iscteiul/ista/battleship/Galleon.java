/**
 *
 */
package iscteiul.ista.battleship;

public class Galleon extends Ship {
    private static final Integer SIZE = 5;
    private static final String NAME = "Galeao";
    
    /*
    Where the size and name of the galleon are defined (constructor)
    */

    /**
     * @param bearing
     * @param pos
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos); /* where the galleon is initialized with its name, bearing, 
                                              and position with the super constructor */

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        /* where the positions of the galleon are filled based on its bearing */

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

                /* here we are filling the positions based on the bearing */

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon"); 
                /* 
                An exception is thrown if the bearing is invalid
                */
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
        /* return the galleon´s size */
    }

    private void fillNorth(IPosition pos) { /* fill the positions for the galleon facing north */
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));  
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));

    }

    private void fillSouth(IPosition pos) { /* fill the positions for the galleon facing south */
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    private void fillEast(IPosition pos) { /* fill the positions for the galleon facing east*/
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    private void fillWest(IPosition pos) { /* fill the positions for the galleon facing west */
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
