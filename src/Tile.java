import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;



/**
 * 
 * Creates a tile object that, provided individual sprite frames, will
 * go through each frame in the array list with each tick
 * 
 * You can pause the animation at any time by calling its pauseAnimation setter
 * You can cause the animation to run only once by setting "runAnimationOnceThenStop"
 * boolean to true
 * 
 * @author Jesse_Macbook_Pro
 *
 */

public class Tile extends OnScreenObjects {

	private int numberOfAnimationFrames;
	private int currentAnimationFrame;
	ArrayList<ImageIcon> eachFrame;
	private boolean pauseAnimation;
	private boolean runAnimationOnceThenStop;
	
	/**
	 * @param p
	 * @param r
	 * @param frames
	 */
	public Tile(Point p, Rectangle r, ArrayList<ImageIcon> eachF) {
		super(p, r);
		// TODO Auto-generated constructor stub
		
		eachFrame = (ArrayList<ImageIcon>) eachF.clone();
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
		ImageIcon myImage = null;
		myImage = eachFrame.get(currentAnimationFrame);
		g.drawImage(myImage.getImage(),location.x,location.y,size.width,size.height,null);
		
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
