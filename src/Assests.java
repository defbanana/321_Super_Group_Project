import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
/**
 * Manages resources
 * stores global constants
 * @author Jesse_Macbook_Pro
 *
 */

public class Assests {

	///////////////////////////////////////////////////////////////
	// Load files into imageIcons ... seems to only work this way
	public static ImageIcon greenBubble = new ImageIcon("green.gif");
	public static ImageIcon blueBubble = new ImageIcon("blue.gif");
	public static ImageIcon redBubble = new ImageIcon("red.gif");
	public static ImageIcon yellowBubble = new ImageIcon("yellow.gif");
	public static ImageIcon shipImg = new ImageIcon("PlayerShip.gif");
	public static ImageIcon explosionImg = new ImageIcon("explosion1.gif");
	
	public static ImageIcon cannonStand = new ImageIcon("Cannon-Stand.gif");
	public static ImageIcon cannonPointer = new ImageIcon("cannon-pointer.gif");
	
	////////////////////////////////////////////////////////////////////
	// Global Constants
	///////////////////
	
	// Set debug to true to draw debug animations
	public static boolean debug = false;
	
	// Original Screen size of the Nintendo entertainment system... blown up by a factor of 2
	public static int screenWidth = 256 * 2;
	public static int screenHeight = 240 * 2;
	public static double scale = 2.0;
	
	// Size of bubbles
	public static int xSpacer = 32;
	public static int ySpacer = 32;
	public static int nook = xSpacer / 2;
	
	// Cannon placement
	public static int xCannon = screenWidth / 2 - 50;
	public static int yCannon = screenHeight / 2 + (screenHeight / 5);
	
	public static int leftSide = (screenWidth / 2) - (xSpacer * 4);
	public static int rightSide = (screenWidth / 2) + (xSpacer * 4);
	
	
	// Where the bubbles start in the level
	public static final int startX = leftSide;
	public static final int startY = 20;
	
	
	
}
