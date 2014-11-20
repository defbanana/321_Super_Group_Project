import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;


/**
 * The game's Level 
 * @author guinnc
 *
 */
public class Level {
		
	private int levelNumber;
	private int bubblesInLevel;
	private SpriteSheet_ToCrop newSpriteSheet;

	public ArrayList<Bubbles> theHorde = new ArrayList<Bubbles>();
	
	/**
	 * Each Level has an associated number starting at "number".
	 * Subsequent levels are higher.  
	 * @param number The level value.
	 */
	public Level(int number) {
		newSpriteSheet = new SpriteSheet_ToCrop();
		levelNumber = number;
		File bubbleFile = new File("bubbles"+ Integer.toString(number) + ".txt");
		bubblesInLevel = -1;
		int bubbleCount = 0;
		int column = 1;
		int row = -1;
		int nook = 0;
		
		Scanner sc = null;
	    try {			
	    	sc = new Scanner(bubbleFile);
	    	
			Bubbles newBubble = null;
		    while (sc.hasNextLine()) {
		    	bubbleCount++;
		    	bubblesInLevel++;
		    	row++;
		    	////////////////////////////////////////
		    	// position
		    	if (bubbleCount == 24){
		    		column = 4;
		    		row = 0;
		    		nook = Assests.xSpacer / 2;
		    	}
		    	else if (bubbleCount == 16) {
		    		column = 3;
		    		row = 0;
		    		nook = 0;
		    	}
		    	else if (bubbleCount == 9) {
		    		row = 0;
		    		column = 2;
		    		nook = Assests.xSpacer / 2;
		    	}

		    	
		    	////////////////////////////////////////
		    	// level position
		    	Point p = new Point();
		    	p.x = Assests.startX + (row * Assests.xSpacer) + nook;
		    	p.y = Assests.startY + (column * Assests.ySpacer);
		    	
		    	Rectangle r = new Rectangle(Assests.xSpacer, Assests.ySpacer);
		    	
		    	MyVector v = new MyVector(0, 0);
		    	
		    	double a = 0.0;
		    	////////////////////////////////////////
		    	// bubble color from level file
		    	
		    	//  Increment to the next line on the text file
		    	String bubbleColor = "";
		    	
		    	// Catch if we are at end of the file
		    	try{
		    		bubbleColor = sc.next();
		    	
			    	if (bubbleColor.equals("red")){
			    		
			    		newBubble = new Bubbles(p, r, Assests.redBubble.getImage(), a, v, newSpriteSheet.red_bubbleList);
			    		newBubble.newBubble = false;
			    		theHorde.add(newBubble);
			
			    		
			    	} else if (bubbleColor.equals("green")){
			    		
			    		newBubble = new Bubbles(p, r, Assests.greenBubble.getImage(), a, v, newSpriteSheet.green_bubbleList);
			    		newBubble.newBubble = false;
			    		theHorde.add(newBubble);
			 
			    		
			    	} else if (bubbleColor.equals("yellow")){
			    		
			    		newBubble = new Bubbles(p, r, Assests.yellowBubble.getImage(), a, v, newSpriteSheet.yellow_bubbleList);
			    		newBubble.newBubble = false;
			    		theHorde.add(newBubble);
			 
			    		
			    	} else if (bubbleColor.equals("blue")){
			    		
			    		newBubble = new Bubbles(p, r, Assests.blueBubble.getImage(), a, v, newSpriteSheet.blue_bubbleList);	
			    		newBubble.newBubble = false;
			    		theHorde.add(newBubble);
			    	
			    		
			    	} else {
			    		
			    		bubblesInLevel--;
			    		System.out.print("No bubble here at " + Integer.toString(bubbleCount));
			    	}
		    	}
		    	catch(NoSuchElementException e){
		    		System.out.print(e.toString());
		    		bubblesInLevel--;
		    	}
		    	
		    }
		    sc.close();
	    } 
	    catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the number of starting bubbles to the level
	 * @return The number of starting bubbles  
	 */
	public int getNumberOfBubbles() {

		return bubblesInLevel;
	}
	/**
	 * Retrieves the level number.
	 * @return the levelNumber
	 */
	public int getLevelNumber() {
		return levelNumber;
	}

	/**
	 * Changes the level number.
	 * @param levelNumber the levelNumber to set
	 */
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	
	/** public void Boom(Bubbles popped) throws IOException{
	popped.pop();
	int bi = clump.indexOf(popped);
	clump.remove(bi);
	
} */
}
