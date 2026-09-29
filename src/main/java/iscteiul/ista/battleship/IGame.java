/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * This interface defines the contract for a Battleship game. 
 * It provides methods for firing shots, retrieving game statistics, and printing information about the game state. 
 * Implementing classes must provide concrete implementations for these methods to manage the game's logic and state.
 * 
 */

public interface IGame {

    /**
    * Fires a shot at the specified position.
    * @param pos the position where the shot is fired
    */

    IShip fire(IPosition pos);

    List<IPosition> getShots();

    int getRepeatedShots();

    int getInvalidShots();

    int getHits();

    int getSunkShips();

    int getRemainingShips();

    void printValidShots();

    void printFleet();
}
