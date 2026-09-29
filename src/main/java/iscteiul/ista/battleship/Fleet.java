/**
 *
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a fleet of ships in the Battleship game.
 * It implements the IFleet interface and provides methods to manage a collection of ships,
 * including adding ships, retrieving ships by category, checking for floating ships, and printing the status of the fleet.
 * 
 */

public class Fleet implements IFleet {
    /**
     *
     * @param ships The list of ships
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }


    private List<IShip> ships;

    public Fleet() {
        ships = new ArrayList<>();
    }

    /**    
     * 
     * @return the list of ships in the fleet 
     */

    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**    
     * 
     * @param s the ship to be added to the fleet
     * @return true if the ship was added successfully, false otherwise
     */

    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**    
     * 
     * @param category The category of ships to retrieve
     * @return the list of ships belonging to the specified category
     */

    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**    
     * 
     * @return the list of ships that are still floating
     */

    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
    * 
    * @param pos the position to check for the existence of a ship
    * @return the ship at the specified position, or null if no ship occupies that position
    */

    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * 
     * @param s the ship to check if it is inside the board
     * @return checks if the ship is within the boundaries of the board
     */

    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * 
     * @param s the ship to check for collision risk
     * @return true if there is a risk of collision with another ship, false otherwise
     */
    
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     *
     * @param category The category of ships of interest
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    void printAllShips() {
        printShips(ships);
    }

}
