import javax.swing.ImageIcon;
/**
 * Manages resources
 * stores global constants
 * @author Jesse_Macbook_Pro
 *
 */

public class Assests {
	public static ImageIcon greenBubble = new ImageIcon("green.gif");
	public static ImageIcon blueBubble = new ImageIcon("blue.gif");
	public static ImageIcon redBubble = new ImageIcon("red.gif");
	public static ImageIcon yellowBubble = new ImageIcon("yellow.gif");
	
	public static ImageIcon shipImg = new ImageIcon("PlayerShip.gif");
	public static ImageIcon explosionImg = new ImageIcon("explosion1.gif");
	
	////////////////////////////////////////////////////////////////////
	// Global Constants
	///////////////////
	
	public static int screenWidth = 600;
	public static int screenHeight = 500;
	
	// Where the bubbles start in the level
	public static final int startX = 220;
	public static final int startY = 100;
	
	// Size of bubbles
	public static int xSpacer = 20;
	public static int ySpacer = 20;
	
	// Cannon placement
	public static int xCannon = screenWidth / 2 - 10;
	public static int yCannon = screenHeight / 2 + 100;
}
