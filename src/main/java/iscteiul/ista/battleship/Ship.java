package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * This class represents a ship in the Battleship game.
 *  It provides methods to get the ship's category, bearing, position, and size, as well as methods to check if 
 * the ship is still floating, if it occupies a given position, and if it is too close to another ship or position. 
 * It also provides a method to shoot at a given position and a string representation of the ship.
 */
public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * 
     * @param shipKind string representing the kind of ship to be built (e.g., "galeao", "fragata", "nau", "caravela", "barca")
     * @param bearing the bearing of the ship (e.g., NORTH, EAST, SOUTH, WEST)
     * @param pos the position of the ship on the game board
     * @return a new instance of a Ship subclass based on the provided shipKind, bearing, and position
     */

    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }


    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List<IPosition> positions;


    /**
     * Constructs a new Ship with the specified category, bearing, and position.
     * @param category the category of the ship (e.g., "galeao", "fragata", "nau", "caravela", "barca")
     * @param bearing the bearing of the ship (e.g., NORTH, EAST, SOUTH, WEST)
     * @param pos the position of the ship on the game board
     */

    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**    
     * 
     * @return the category of the ship
     */
    
    @Override
    public String getCategory() {
        return category;
    }

    /**   
     * 
     * @return the size of the ship (number of positions it occupies)
     */

    public List<IPosition> getPositions() {
        return positions;
    }

    /**    
     * 
     * @return the size of the ship (number of positions it occupies)
     */

    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**   
     * 
     * @return the size of the ship (number of positions it occupies)
     */
    
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**   
     * 
     * @return true if the ship is still floating (not all positions are hit), false otherwise
     */
    
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**    
     * 
     * @return the topmost row index occupied by the ship
     */
    
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }


    /**   
     * 
     * @return the bottommost row index occupied by the ship
     */
    
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**    
     * 
     * @return the leftmost column index occupied by the ship
     */

    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**    
     * 
     * @return the rightmost column index occupied by the ship
     */
    
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**    
     * 
     * @param pos the position to check if the ship occupies
     * @return true if the ship occupies the specified position, false otherwise
     */
    
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**    
     * 
     * @param other the other ship to check if this ship is too close to
     * @return true if this ship is too close to the other ship, false otherwise
     */
    
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**    
     * 
     * @param pos the position to check if this ship is too close to
     * @return true if this ship is too close to the specified position, false otherwise
     */

    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }


    /**    
     * 
     * @param pos the position to shoot at
     */
    
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }

    /**    
     * 
     * @return a string representation of the ship, including its category, bearing, and position
     */

    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }

}