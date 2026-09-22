/**
 * Package containing classes for the Battleship game implementation.
 */
package iscteiul.ista.battleship;

/**
 * Represents a Carrack ship (Nau) with a fixed size of 3 units.
 * Handles the positioning of the ship across the board depending on its orientation.
 */
public class Carrack extends Ship {
    
    // Constant defining the size (length in grid cells) of the Carrack
    private static final Integer SIZE = 3;
    
    // Constant defining the display name of the ship
    private static final String NAME = "Nau";

    /**
     * Constructs a Carrack ship at a specific position with a given bearing orientation.
     * 
     * @param bearing the compass direction the ship is facing (NORTH, SOUTH, EAST, WEST)
     * @param pos     the starting coordinate position on the grid
     * @throws IllegalArgumentException if an invalid bearing is provided
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        // Call the parent Ship constructor with name, bearing, and initial position
        super(Carrack.NAME, bearing, pos);
        
        // Determine grid placement based on the ship's orientation
        switch (bearing) {
            case NORTH:
            case SOUTH:
                // Vertical alignment: increment the row index for each segment of the ship
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
                
            case EAST:
            case WEST:
                // Horizontal alignment: increment the column index for each segment of the ship
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
                
            default:
                // Handle unexpected or invalid bearings
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Returns the size of the Carrack ship.
     * 
     * @return an Integer representing the ship's grid length (3)
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }
}