import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;


/**
 * 
 * @author Jesse_Macbook_Pro
 *
 */
public class SpriteSheet_ToCrop {
	//////////////////////////////////////////////////////////////////////
	// Go to the Game.java constructor to see how this ends up being used
	
	
	// A singleton that is reused to get smaller images from a larger one
	private Crop cropASpriteSheet;
	
	// The constructor will build all the array lists for each sprite that animates
	// with each sprite there should be a corresponding array-list listed here
	public static ArrayList<Image> blow_bubble_characterList = new ArrayList<Image>();
	private Point firstPoint;
	private Rectangle firstSize;
	

	/////////////////////////////////////////////////////////////////////////////////////////////
	// Initialization work for the blow_bubble_character sprite sheet   
	private ImageIcon blow_bubble_character = new ImageIcon("blow_bubble_character.png");


	// This just helps to read what is contained in the index of an array
	// may not actually be needed in this class since they are only being built here.
	private enum indexBB_CharacterSheet{
		
		// use these words to refer to a specific frame in the index
		// just an example
		HAPPY(1), SAD(2);
		
		//////////////////////////////////////////////////////////////
		// A constructor. It establishes the values associated with the 
		// enumerated words.
		private int indexValue;	
		indexBB_CharacterSheet(int i) {
			this.indexValue = i;
		}
		///////////////////////////////////////////////////////////////
	}
	// End of blow_bubble_character sprite sheet initialization
	/////////////////////////////////////////////////////////////////////////////////////////////
 
	/////////////////////////////////////////////////////////////////////////////////////////////
	// Initialization work for the next sprite sheet
	// etc...

	/////////////////////////////////////////////////////////////////////////////////////////
	// Once all the variables are defined... use the constructor to do all the cropping and
	// ArrayList building
	public SpriteSheet_ToCrop() {
		///////////////////////////////////////////////////////////////////////////////
		// build the blow_bubble_character sprite array list
		BufferedImage bb_characterSheet = new BufferedImage(
				blow_bubble_character.getIconWidth(),
				blow_bubble_character.getIconHeight(),
				
			    BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = bb_characterSheet.createGraphics();
		// paint the Icon to the BufferedImage.
		blow_bubble_character.paintIcon(null, g, 0,0);
		g.dispose();
		
		// each sprite is 20 pixels long for example
		int imageSizeMultiplier = 30;
		int numberOfFrames = 6;
		// Get the sprite-sheet from file
		firstPoint = new Point(0,0);
		firstSize = new Rectangle(30, 30);
		cropASpriteSheet = new Crop(bb_characterSheet, firstPoint, firstSize);
		System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			blow_bubble_characterList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier;

			try{
				cropASpriteSheet.setImage(bb_characterSheet, firstPoint, firstSize);
			}
			catch(Exception e){
				if (Assests.debug)
					System.out.println(e.toString());
			}
		}


		// End of he blow_bubble_character sprite array list construction

		///////////////////////////////////////////////////////////////////////////////
		// build the next sprite array list
		
		
	}
	
	
}

 