/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * This interface defines the structure and behavior of a fleet in the Battleship game.
 * It includes methods for managing ships, retrieving information about the fleet, and printing the fleet's status.
 */

public interface IFleet {
    Integer BOARD_SIZE = 10;
    Integer FLEET_SIZE = 10;

    List<IShip> getShips();

    /**
     * 
     * @param s the ship to be added to the fleet
     */

    boolean addShip(IShip s);

    /**
     * 
     * @param category the category of ships to be retrieved from the fleet
     */

    List<IShip> getShipsLike(String category);

    List<IShip> getFloatingShips();

    /**
     * 
     * @param pos the position to check for a ship in the fleet
     */

    IShip shipAt(IPosition pos);

    void printStatus();
}
