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
	
	// Set debug to true to draw debug animations
	public static boolean debug = false;
	
	public static int screenWidth = 600;
	public static int screenHeight = 500;
	
	// Size of bubbles
	public static int xSpacer = 20;
	public static int ySpacer = 20;
	public static int nook = xSpacer / 2;


	
	// Cannon placement
	public static int xCannon = screenWidth / 2 - (xSpacer / 2);
	public static int yCannon = screenHeight / 2 + (screenHeight / 5);
	
	public static int leftSide = (screenWidth / 2) - (xSpacer * 4);
	public static int rightSide = (screenWidth / 2) + (xSpacer * 4);
	
	// Where the bubbles start in the level
	public static final int startX = leftSide;
	public static final int startY = (screenHeight / 5);
	
	
}