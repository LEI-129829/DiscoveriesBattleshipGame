/**
 *
 */
package iscteiul.ista.battleship;

/**
 * @author fba
 */
public enum Compass {
    NORTH('n'), SOUTH('s'), EAST('e'), WEST('o'), UNKNOWN('u');

    /*
    we are going to define the directions of the compass (NORTH, SOUTH, EAST, WEST, UNKNOWN) 
    and their corresponding characters
    */

    private final char c; /* here is where the character for each compass direction is defined */

    Compass(char c) {
        this.c = c;
    }

    public char getDirection() { 
        return c;
    }

    @Override
    public String toString() { /* here we are going to define the string representation of each compass direction */
        return "" + c;
    }

    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH; /* this is the north direction */
                break;
            case 's':
                bearing = SOUTH; /* this is the south direction */
                break;
            case 'e':
                bearing = EAST; /* this is the east direction */
                break;
            case 'o':
                bearing = WEST; /* this is the west direction */
                break;
            default:
                bearing = UNKNOWN; /* this is the unknown direction */
        }

        return bearing; /* return the compass direction corresponding to the character */
    }
}
