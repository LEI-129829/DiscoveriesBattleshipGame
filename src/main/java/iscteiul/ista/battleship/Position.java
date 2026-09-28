/**
 *
 */
package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * This class represents a position on the Battleship game board.
 * It implements the IPosition interface and provides methods to get the row and column of the position, 
 * check if it is occupied or hit, and determine if it is adjacent to another position. 
 * The class also overrides the equals and hashCode methods for proper comparison and hashing of Position objects.
 */

public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

 
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**    
     * @return the row of the position on the game board.
     */
    @Override
    public int getRow() {
        return row;
    }

    /**   
     * @return the column of the position on the game board.
     */
    @Override
    public int getColumn() {
        return column;
    }


    /**    
     * @return the hash code value for the position, based on its row, column, occupancy, and hit status.
     */

    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * @param otherPosition the object to compare with this position
     * @return true if the other object is a Position with the same row and column, false otherwise
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * @param other the other position to check adjacency with
     * @return true if the other position is adjacent to this position (including diagonally), false otherwise
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }


    @Override
    public void occupy() {
        isOccupied = true;
    }


    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * @return true if the position is occupied by a ship, false otherwise
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * @return true if the position has been hit by a shot, false otherwise
     */
    @Override
    public boolean isHit() {
        return isHit;
    }


    /**    
     * @return a string representation of the position, including its row and column values.
     * 
     */

    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}
