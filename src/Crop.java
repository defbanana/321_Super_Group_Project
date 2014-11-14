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
public class Crop extends JPanel
{
    private BufferedImage image;

    private Point cropLocation;
    private Rectangle cropSize;
    
    private ImageIcon cropImageIcon;
    
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
    	setImageIcon(i, cropL, size);  
    }
    
    public ImageIcon getImageIcon() {
    	return cropImageIcon;
    }
    
    public void setImageIcon(BufferedImage i, Point cropL, Rectangle size) {
        image = i;        
        BufferedImage clipped;       
        cropLocation = cropL;
        cropSize = size;
            
		try
        {
            clipped = image.getSubimage(cropLocation.x, cropLocation.y, cropSize.width, cropSize.height);
        }
        catch(RasterFormatException rfe)
        {
            System.out.println("raster format error: " + rfe.getMessage());
            return;
        }
        ImageIcon newImageIcon = new ImageIcon(clipped);
        
        if (Assests.debug)
        	System.out.println("clipped at " + Integer.toString(cropLocation.x));
    }
    

}
