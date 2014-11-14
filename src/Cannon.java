import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;



/**
 * A Ship is the player controlled object that has a particular
 * location, size, image, and angle.  
 * @author 
 *
 */
public class Cannon extends MovingObjects {


	/**
	 * Create the ship at a location.
	 * @param location Starting location.
	 * @param size Starting size.
	 * @param i Image of the ship.
	 */
	public Cannon(Point location, Rectangle size, Image i, double angle, MyVector v) {
		super(location, size, i, angle, v);

		
	}
	



}