import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;



/**
 * @author Jesse_Macbook_Pro
 *
 */
public class Tile extends OnScreenObjects {

	private int numberOfAnimationFrames;
	private int currentAnimationFrame;
	ArrayList<ImageIcon> eachFrame;
	
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

	}

	/* (non-Javadoc)
	 * @see OnScreenObjects#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		ImageIcon myImage = null;

		myImage = eachFrame.get(currentAnimationFrame);
		g.drawImage(myImage.getImage(),location.x,location.y,size.width,size.height,null);
		
		if (currentAnimationFrame == (numberOfAnimationFrames - 1))
			currentAnimationFrame = 0;
		else
			currentAnimationFrame++;
		
	}

}
