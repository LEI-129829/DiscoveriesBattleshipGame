/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * This interface defines the contract for a ship in the Battleship game. 
 * It specifies the methods that any ship class must implement, including retrieving the ship's category, size, positions, bearing, and status (whether it is still floating). 
 * Additionally, it includes methods for determining proximity to other ships or positions and handling shooting at the ship.
 * 
 */

public interface IShip {
    String getCategory();

    Integer getSize();

    List<IPosition> getPositions();

    IPosition getPosition();

    Compass getBearing();

    boolean stillFloating();

    int getTopMostPos();

    int getBottomMostPos();

    int getLeftMostPos();

    int getRightMostPos();

    /**
     * 
     * @param pos the position to check if the ship occupies
     */

    boolean occupies(IPosition pos);

    /**
     * 
     * @param other the other ship to check proximity
     */

    boolean tooCloseTo(IShip other);

    /**
     * 
     * @param pos the position to check proximity
     */

    boolean tooCloseTo(IPosition pos);

    /**
     * 
     * @param pos the position to shoot at the ship
     */

    void shoot(IPosition pos);
}
