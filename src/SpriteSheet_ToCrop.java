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
	// The constructor will build all the array lists for each sprite that animates
	// with each sprite there should be a corresponding array-list listed here
	private Point firstPoint;
	private Rectangle firstSize;
	// A singleton that is reused to get smaller images from a larger one
	private Crop cropASpriteSheet;
	

	/////////////////////////////////////////////////////////////////////////////////////////////
	// Initialization work for the blow_bubble_character sprite sheet   
	private ImageIcon blow_bubble_character = new ImageIcon("blow_bubble_character.png");
	public ArrayList<Image> blow_bubble_characterList = new ArrayList<Image>();

	/////////////////////////////////////////////////////////////////////////////////////////////
	// Initialization work for the ... sprite sheet   
	private ImageIcon normal_bubbles = new ImageIcon("normal_bubbles.png");
	public ArrayList<Image> blue_bubbleList = new ArrayList<Image>();
	public ArrayList<Image> red_bubbleList = new ArrayList<Image>();
	public ArrayList<Image> green_bubbleList = new ArrayList<Image>();
	public ArrayList<Image> yellow_bubbleList = new ArrayList<Image>();
	public ArrayList<Image> violet_bubbleList = new ArrayList<Image>();
	public ArrayList<Image> silver_bubbleList = new ArrayList<Image>();
	public ArrayList<Image> orange_bubbleList = new ArrayList<Image>();
	public ArrayList<Image> black_bubbleList = new ArrayList<Image>();


	/////////////////////////////////////////////////////////////////////////////////////////
	// Once all the variables are defined... use the constructor to do all the cropping and
	// ArrayList building
	public SpriteSheet_ToCrop() {
		Blow_Bubble_Character();
		Blue_Bubble();
		Silver_Bubble();
		Red_Bubble();
		Green_Bubble();
		Yellow_Bubble();
		Black_Bubble();
		Orange_Bubble();
		Violet_Bubble();

		
	}
	
	private void Blow_Bubble_Character(){
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
		int imageSizeMultiplier = 18;
		int numberOfFrames = 5;
		// Get the sprite-sheet from file
		firstPoint = new Point(10,10);
		firstSize = new Rectangle(18, 18);
		cropASpriteSheet = new Crop(bb_characterSheet, firstPoint, firstSize);
		System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			blow_bubble_characterList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier + 3;

			try{
				cropASpriteSheet.setImage(bb_characterSheet, firstPoint, firstSize);
			}
			catch(Exception e){
				if (Assests.debug)
					System.out.println(e.toString());
			}
		}
	}
	///////////////////////////////////////////////////////////////////////////////
	private void Blue_Bubble(){

		BufferedImage normal_bubblesIcon = new BufferedImage(
				normal_bubbles.getIconWidth(),
				normal_bubbles.getIconHeight(),
				
			    BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = normal_bubblesIcon.createGraphics();
		// paint the Icon to the BufferedImage.
		normal_bubbles.paintIcon(null, g2, 0,0);
		g2.dispose();
		
		// each sprite is ... pixels long for example
		int imageSizeMultiplier = 18;
		int numberOfFrames = 5;
		// Get the sprite-sheet from file
		firstPoint = new Point(10,8);
		firstSize = new Rectangle(16, 16);
		cropASpriteSheet = new Crop(normal_bubblesIcon, firstPoint, firstSize);
		//System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			blue_bubbleList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier +  2;
			cropASpriteSheet.setImage(normal_bubblesIcon, firstPoint, firstSize);

		}
	}
	
	///////////////////////////////////////////////////////////////////////////////
	private void Silver_Bubble(){

		BufferedImage normal_bubblesIcon = new BufferedImage(
				normal_bubbles.getIconWidth(),
				normal_bubbles.getIconHeight(),
				
			    BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = normal_bubblesIcon.createGraphics();
		// paint the Icon to the BufferedImage.
		normal_bubbles.paintIcon(null, g2, 0,0);
		g2.dispose();
		
		// each sprite is ... pixels long for example
		int imageSizeMultiplier = 18;
		int numberOfFrames = 5;
		// Get the sprite-sheet from file
		firstPoint = new Point(10,34);
		firstSize = new Rectangle(16, 16);
		cropASpriteSheet = new Crop(normal_bubblesIcon, firstPoint, firstSize);
		//System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			silver_bubbleList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier +  2;
			cropASpriteSheet.setImage(normal_bubblesIcon, firstPoint, firstSize);

		}
	}
	
	///////////////////////////////////////////////////////////////////////////////
	private void Red_Bubble(){

		BufferedImage normal_bubblesIcon = new BufferedImage(
				normal_bubbles.getIconWidth(),
				normal_bubbles.getIconHeight(),
				
			    BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = normal_bubblesIcon.createGraphics();
		// paint the Icon to the BufferedImage.
		normal_bubbles.paintIcon(null, g2, 0,0);
		g2.dispose();
		
		// each sprite is ... pixels long for example
		int imageSizeMultiplier = 18;
		int numberOfFrames = 5;
		// Get the sprite-sheet from file
		firstPoint = new Point(10,60);
		firstSize = new Rectangle(16, 16);
		cropASpriteSheet = new Crop(normal_bubblesIcon, firstPoint, firstSize);
		//System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			red_bubbleList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier +  2;
			cropASpriteSheet.setImage(normal_bubblesIcon, firstPoint, firstSize);

		}
	}
	
	///////////////////////////////////////////////////////////////////////////////
	private void Yellow_Bubble(){

		BufferedImage normal_bubblesIcon = new BufferedImage(
				normal_bubbles.getIconWidth(),
				normal_bubbles.getIconHeight(),
				
			    BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = normal_bubblesIcon.createGraphics();
		// paint the Icon to the BufferedImage.
		normal_bubbles.paintIcon(null, g2, 0,0);
		g2.dispose();
		
		// each sprite is ... pixels long for example
		int imageSizeMultiplier = 18;
		int numberOfFrames = 5;
		// Get the sprite-sheet from file
		firstPoint = new Point(10,86);
		firstSize = new Rectangle(16, 16);
		cropASpriteSheet = new Crop(normal_bubblesIcon, firstPoint, firstSize);
		//System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			yellow_bubbleList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier +  2;
			cropASpriteSheet.setImage(normal_bubblesIcon, firstPoint, firstSize);

		}
	}
	
	///////////////////////////////////////////////////////////////////////////////
	private void Green_Bubble(){

		BufferedImage normal_bubblesIcon = new BufferedImage(
				normal_bubbles.getIconWidth(),
				normal_bubbles.getIconHeight(),
				
			    BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = normal_bubblesIcon.createGraphics();
		// paint the Icon to the BufferedImage.
		normal_bubbles.paintIcon(null, g2, 0,0);
		g2.dispose();
		
		// each sprite is ... pixels long for example
		int imageSizeMultiplier = 18;
		int numberOfFrames = 5;
		// Get the sprite-sheet from file
		firstPoint = new Point(319,8);
		firstSize = new Rectangle(16, 16);
		cropASpriteSheet = new Crop(normal_bubblesIcon, firstPoint, firstSize);
		//System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			green_bubbleList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier +  2;
			cropASpriteSheet.setImage(normal_bubblesIcon, firstPoint, firstSize);

		}
	}
	
	///////////////////////////////////////////////////////////////////////////////
	private void Black_Bubble(){

		BufferedImage normal_bubblesIcon = new BufferedImage(
				normal_bubbles.getIconWidth(),
				normal_bubbles.getIconHeight(),
				
			    BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = normal_bubblesIcon.createGraphics();
		// paint the Icon to the BufferedImage.
		normal_bubbles.paintIcon(null, g2, 0,0);
		g2.dispose();
		
		// each sprite is ... pixels long for example
		int imageSizeMultiplier = 18;
		int numberOfFrames = 5;
		// Get the sprite-sheet from file
		firstPoint = new Point(319,34);
		firstSize = new Rectangle(16, 16);
		cropASpriteSheet = new Crop(normal_bubblesIcon, firstPoint, firstSize);
		//System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			black_bubbleList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier +  2;
			cropASpriteSheet.setImage(normal_bubblesIcon, firstPoint, firstSize);

		}
	}
	
	///////////////////////////////////////////////////////////////////////////////
	private void Orange_Bubble(){

		BufferedImage normal_bubblesIcon = new BufferedImage(
				normal_bubbles.getIconWidth(),
				normal_bubbles.getIconHeight(),
				
			    BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = normal_bubblesIcon.createGraphics();
		// paint the Icon to the BufferedImage.
		normal_bubbles.paintIcon(null, g2, 0,0);
		g2.dispose();
		
		// each sprite is ... pixels long for example
		int imageSizeMultiplier = 18;
		int numberOfFrames = 5;
		// Get the sprite-sheet from file
		firstPoint = new Point(319,60);
		firstSize = new Rectangle(16, 16);
		cropASpriteSheet = new Crop(normal_bubblesIcon, firstPoint, firstSize);
		//System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			orange_bubbleList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier +  2;
			cropASpriteSheet.setImage(normal_bubblesIcon, firstPoint, firstSize);

		}
	}
	
	///////////////////////////////////////////////////////////////////////////////
	private void Violet_Bubble(){

		BufferedImage normal_bubblesIcon = new BufferedImage(
				normal_bubbles.getIconWidth(),
				normal_bubbles.getIconHeight(),
				
			    BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = normal_bubblesIcon.createGraphics();
		// paint the Icon to the BufferedImage.
		normal_bubbles.paintIcon(null, g2, 0,0);
		g2.dispose();
		
		// each sprite is ... pixels long for example
		int imageSizeMultiplier = 18;
		int numberOfFrames = 5;
		// Get the sprite-sheet from file
		firstPoint = new Point(319,86);
		firstSize = new Rectangle(16, 16);
		cropASpriteSheet = new Crop(normal_bubblesIcon, firstPoint, firstSize);
		//System.out.println(cropASpriteSheet.getImage().toString());
		
		// Do the work of getting the frames put into the array
		for (int i = 0; i < numberOfFrames; i++){
			// Crop and add to the blow bubbles frame list
			violet_bubbleList.add((Image)cropASpriteSheet.getImage());
			
			// Move crop to the next frame on the sheet
			firstPoint.x += imageSizeMultiplier +  2;
			cropASpriteSheet.setImage(normal_bubblesIcon, firstPoint, firstSize);

		}
	}
	
	
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
	
}

 