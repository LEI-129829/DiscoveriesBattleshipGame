/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * 
 * This interface represents a ship in the Battleship game. It defines the essential methods that any ship must implement;
 * including retrieving its category, size, positions, and bearing. It also includes methods to check if the ship is still floating,
 * if it occupies a specific position, and if it is too close to another ship or position. Additionally,
 * it provides a method to handle shooting at the ship.
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

    

    boolean occupies(IPosition pos);

    

    boolean tooCloseTo(IShip other);

    

    boolean tooCloseTo(IPosition pos);

    

    void shoot(IPosition pos);
}
