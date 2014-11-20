import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

/**
 * 
 */

/**
 * @author Jesse_Macbook_Pro
 *
 */
public class ScreenProps extends OnScreenObjects {

	private Image image;
	/**
	 * @param p
	 * @param r
	 */
	public ScreenProps(Point p, Rectangle r, Image i) {
		super(p, r);
		image = i;
	}

	/* (non-Javadoc)
	 * @see OnScreenObjects#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		AffineTransform trans = new AffineTransform();
		trans.translate(location.x, location.y);
		trans.scale(Assests.scale, Assests.scale);

		g2.drawImage(image, trans, null);

	}

}
