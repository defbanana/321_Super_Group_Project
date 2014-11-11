

/**
 * Stores the change in X and change in Y for an object.
 * The idea is that when the timer goes off, these values will
 * be added to the position of the object.  
 * @author 
 *
 */
public class MyVector {
	private double changeX;
	private	double changeY;
	/**
	 * Create the vector with starting values.
	 * @param changeX The starting change in X.
	 * @param changeY The starting change in Y.
	 */
	public MyVector(double changeX, double changeY) {
		super();
		this.changeX = changeX;
		this.changeY = changeY;
	}
	/**
	 * Retrieve the change in X.
	 * @return the changeX
	 */
	public double getChangeX() {
		return changeX;
	}
	/**
	 * Change the change in X.
	 * @param changeX the changeX to set
	 */
	public void setChangeX(double changeX) {
		this.changeX = changeX;
	}
	/**
	 * Retrieve the change in Y.
	 * @return the changeY
	 */
	public double getChangeY() {
		return changeY;
	}
	/**
	 * Change the change in Y.
	 * @param changeY the changeY to set
	 */
	public void setChangeY(double changeY) {
		this.changeY = changeY;
	}
	
	/**
	 * Get the direction of the vector
	 * @return
	 */
	public double getAngleDeg() {
		return Math.toDegrees(Math.atan2(getChangeY(), getChangeX()));
	}
}
