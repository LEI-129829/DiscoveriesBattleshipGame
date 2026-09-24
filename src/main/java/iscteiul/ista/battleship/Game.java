/**
 * Represents the main game class for the Battleship game.
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class implements the IGame interface and represents the main game logic for the Battleship game.
 * It manages the fleet of ships, tracks shots fired, and provides methods to fire shots, retrieve game statistics, and print the game board.
 * The class maintains counters for invalid shots, repeated shots, hits, and sunk ships.
 * 
 * @author fba
 *
 */
public class Game implements IGame {
    private IFleet fleet;
    private List<IPosition> shots;

    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;


    /**
     * @param fleet the fleet of ships for the game
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /**    
     * @param pos the position where the shot is fired
     * @return the ship that was sunk as a result of the shot, or null if no ship was sunk
     * 
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**    
     * @return the list of shots fired in the game
     * 
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

   /**  
    * @return the number of repeated shots fired in the game
    * 
    */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**    
     * @return the number of invalid shots fired in the game
     * 
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**    
     * @return the number of hits made in the game
     * 
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**    
     * @return the number of ships sunk in the game
     * 
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**    
     * @return the number of remaining ships that are still floating in the game
     * 
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * 
     * @param pos the position to check for validity
     * @return true if the position is valid for firing a shot, false otherwise
     */

    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * 
     * @param pos the position to check for repeated shots
     * @return true if the position has already been shot at, false otherwise
     */

    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * 
     * @param positions the list of positions to mark on the board
     * @param marker    the character to use for marking the positions
     */

    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }

    }

    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}
