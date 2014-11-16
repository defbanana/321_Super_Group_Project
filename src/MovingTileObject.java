import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Jesse_Macbook_Pro
 *
 */
public class MovingTileObject extends MovingObjects {
	
	private int numberOfAnimationFrames;
	private int currentAnimationFrame;
	ArrayList<Image> eachFrame;
	private boolean pauseAnimation;
	private boolean runAnimationOnceThenStop;
	
	/**
	 * @param location
	 * @param size
	 * @param i
	 * @param angle
	 * @param v
	 */
	public MovingTileObject(Point location, Rectangle size, Image i,
			double angle, MyVector v, ArrayList<Image> eachF) {
		super(location, size, i, angle, v);
		
		eachFrame = (ArrayList<Image>) eachF.clone();
		numberOfAnimationFrames = eachFrame.size();
		currentAnimationFrame = 0;
		pauseAnimation = false;

	}

	public boolean getPauseAnimation() {
		return pauseAnimation;
	}

	public void setPauseAnimation(boolean pauseAnimation) {
		this.pauseAnimation = pauseAnimation;
	}

	public boolean getRunAnimationOnceThenStop() {
		return runAnimationOnceThenStop;
	}

	public void setRunAnimationOnceThenStop(boolean runAnimationOnceThenStop) {
		this.runAnimationOnceThenStop = runAnimationOnceThenStop;
	}

	/* (non-Javadoc)
	 * @see OnScreenObjects#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;

		// This section will take care of the rotating gun
		AffineTransform trans = new AffineTransform();
		trans.translate(location.x, location.y);
//		trans.scale(0.25, 0.25);

		trans.rotate(Math.toRadians(this.getAngle()),
				myImage.getWidth(null) / 2, myImage.getHeight(null) / 2);

		Image myImage = null;
		myImage = eachFrame.get(currentAnimationFrame);
		g2.drawImage(myImage, trans, null);
		
		if (!pauseAnimation) {						
			if (currentAnimationFrame == (numberOfAnimationFrames - 1)){
				if (!runAnimationOnceThenStop)
					currentAnimationFrame = 0;
			}
			else
				currentAnimationFrame++;			
		}
	}


}
