/**
 *
 */
package iscteiul.ista.battleship;

/**
 * This class represents the compass directions used to position ships in the Battleship game.
 *  Each direction is associated with a character representation. 
 * 
 * @author fba
 */
public enum Compass {
    NORTH('n'), SOUTH('s'), EAST('e'), WEST('o'), UNKNOWN('u');


    private final char c;

    Compass(char c) {
        this.c = c;
    }

    /**
     * 
     * @return the character representation of the compass direction.
     */

    public char getDirection() { 
        return c;
    }

    /**    
     * 
     * @return the string representation of the compass direction, which is the character associated with it.
     */

    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * 
     * @param ch the character to be converted to a Compass direction 
     * @return the corresponding Compass direction based on the provided character.
     *         If the character does not match any known direction, it returns UNKNOWN.
     */

    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
