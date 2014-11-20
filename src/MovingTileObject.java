import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;


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
	private boolean Animate;
	private Random rand;
	private boolean RandomMoving;

	
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
		
		eachFrame = new ArrayList<Image>();
		eachFrame.addAll(eachF);
		
		numberOfAnimationFrames = eachFrame.size();
		currentAnimationFrame = 0;
		pauseAnimation = false;
		Animate = false;
		RandomMoving = true;
		runAnimationOnceThenStop = true;

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
		int n;
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform trans = new AffineTransform();
		
	 	if (Animate){

			if (Assests.debug)
			{
				System.out.println("Current Animation Frame:");
				System.out.println(currentAnimationFrame);
			}
			
			myImage = eachFrame.get(currentAnimationFrame);
	
			// This section will take care of the rotating gun

			trans.translate(location.x, location.y);
			trans.scale(Assests.scale, Assests.scale);
			trans.rotate(Math.toRadians(this.getAngle()),
					myImage.getWidth(null) / 2, myImage.getHeight(null) / 2);
			g2.drawImage(myImage, trans, null);
	
	
			if (!pauseAnimation) {						
				if (currentAnimationFrame == (numberOfAnimationFrames - 1)){
					if (!runAnimationOnceThenStop){
						currentAnimationFrame = 0;						
					}
					else
						Animate = false;

				}
				else
					currentAnimationFrame++;			
			}
		}
		else 
		{
			if (RandomMoving)
			{
				rand = new Random();
				n = rand.nextInt(1000);
				if (n > 995)
					Animate = true;
			}
			

			System.out.println(currentAnimationFrame);
			myImage = eachFrame.get(currentAnimationFrame);

			trans.translate(location.x, location.y);
			trans.scale(Assests.scale, Assests.scale);
			trans.rotate(Math.toRadians(this.getAngle()),
					myImage.getWidth(null) / 2, myImage.getHeight(null) / 2);
			g2.drawImage(myImage, trans, null);
		}
	}
	
}
