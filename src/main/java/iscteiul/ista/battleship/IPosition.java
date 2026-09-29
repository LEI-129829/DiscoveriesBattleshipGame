/**
 *
 */
package iscteiul.ista.battleship;

/**
 * This interface defines the contract for a position in the Battleship game.
 * It provides methods to retrieve the row and column of the position, check for equality with another position, 
 * determine adjacency to another position, occupy the position, shoot at the position, and check if the position is occupied or hit.
 * @author fba
 */
public interface IPosition {
    int getRow();

    int getColumn();

    /**
     * @param other the other position to compare with
     */

    boolean equals(Object other);

    /**
     * 
     * @param other the other position to check adjacency with
     */

    boolean isAdjacentTo(IPosition other);

    void occupy();

    void shoot();

    boolean isOccupied();

    boolean isHit();
}
