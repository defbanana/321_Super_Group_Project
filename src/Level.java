/**
 * The game's Level determines how hard the game is for the user.
 * For instance, at each level, there may be more asteroids.
 * (In the rules for the game, the small saucer becomes much
 * more accurate in its aim.)
 * @author guinnc
 *
 */
public class Level {

	private int levelNumber;
	
	/**
	 * Each Level has an associated number starting at "number".
	 * Subsequent levels are higher.  
	 * @param number The level value.
	 */
	public Level(int number) {
		levelNumber = number;
	}

	/**
	 * Returns the number of asteroids for a given level.  It is
	 * calculated by adding 1 to the level number.
	 * @return The number of asteroids for a level.  
	 */
	public int getNumberOfAsteroid() {
		return levelNumber + 1;
	}
	/**
	 * Retrieves the level number.
	 * @return the levelNumber
	 */
	public int getLevelNumber() {
		return levelNumber;
	}

	/**
	 * Changes the level number.
	 * @param levelNumber the levelNumber to set
	 */
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	

}
