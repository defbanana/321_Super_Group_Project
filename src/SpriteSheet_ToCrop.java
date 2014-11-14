import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class SpriteSheet_ToCrop {
	
	BufferedImage image;
    private Point cropLocation;
    private Rectangle cropSize;
    
    ArrayList<ImageIcon> cropped;
	
    
    
    /**
     * 
     * @param i
     * 			Provide the sprite sheet to crop from
     * @param cropL
     * 			x,y where we are cropping
     * @param size
     * 			the size of the sprite
     */
	public SpriteSheet_ToCrop(BufferedImage i, Point cropL,
								Rectangle size){
        image = i;        
        BufferedImage clipped;       
        cropLocation = cropL;
        cropSize = size;
		
		
								}
	
	
	
}

 