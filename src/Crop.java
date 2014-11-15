import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
 


/**
 * Instantiate new cropped image
 * retrieve new image with getImageIcon
 * 
 * @author Jesse_Macbook_Pro
 *
 *
 */
public class Crop
{
    private BufferedImage image;

    private Point cropLocation;
    private Rectangle cropSize;
    
    private Image cropImage;
    
    /**
     * 
     * @param i
     * 			Provide the sprite sheet to crop from
     * @param cropL
     * 			x,y where we are cropping
     * @param size
     * 			the size of the sprite
     */
    public Crop(BufferedImage i, Point cropL, Rectangle size)
    {
    	setImage(i, cropL, size);  
    }
    
    public Image getImage() {
    	return cropImage;
    }
    
    public void setImage(BufferedImage i, Point cropL, Rectangle size) {
        image = i;        
        BufferedImage clipped;       
        cropLocation = cropL;
        cropSize = size;
            
		try
        {
            cropImage = image.getSubimage(cropLocation.x, cropLocation.y, cropSize.width, cropSize.height);
        }
        catch(RasterFormatException rfe)
        {
            System.out.println("raster format error: " + rfe.getMessage());
            return;
        }
        
        if (Assests.debug)
        	System.out.println("clipped at " + Integer.toString(cropLocation.x));
    }
    

}
