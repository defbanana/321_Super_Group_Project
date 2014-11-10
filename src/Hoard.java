import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * 
 */

/**
 * @author sjs7338
 *
 */
public class Hoard {
	//ArrayList<ArrayList<Bubbles>> bunch;
	int rowCounter;
	int columnCounter;
	int hex;
	int why;
	Image redImage;
	Image yellowImage;
	Image greenImage;
	Image blueImage;
	MyVector victor;
    Image bubbleImage;
	ArrayList<Bubbles> clump;
	public Hoard() throws IOException{
		victor=new MyVector(0,0);
		redImage=ImageIO.read(new File("red.gif"));
		yellowImage=ImageIO.read(new File("yellow.gif"));
		greenImage=ImageIO.read(new File("green.gif"));
		blueImage=ImageIO.read(new File("blue.gif"));
		//Bubbles b = new Bubbles(p,r,redImage,victor);
		Rectangle r = new Rectangle(5,5);
		File bubbleFile = new File("bubbles.txt");
		rowCounter=4;
		columnCounter=8;
		//bunch = new ArrayList<ArrayList<Bubbles>>();
		clump = new ArrayList<Bubbles>();
	    Scanner sc = new Scanner(bubbleFile);
	    while (sc.hasNextLine()) {
	    	for(int i=0; i <= columnCounter; i++){
	    		for(int j =0; j<=rowCounter;j++){
	    	if (sc.next().equals("red")){
	    		bubbleImage=redImage;
	    	}
	    	if (sc.next().equals("green")){
	    		bubbleImage = greenImage;
	    	}
	    	if (sc.next().equals("yellow")){
	    		bubbleImage=yellowImage;
	    	}
	    	if (sc.next().equals("blue")){
	    		bubbleImage=blueImage;
	    	}
	    	Point nuP = new Point(i,j);
			Bubbles b = new Bubbles(nuP,r,bubbleImage,victor);
			//ArrayList<Bubbles>  clump = new ArrayList<Bubbles>();
			clump.add(b);
	    	}
	    	}
	    }
	    sc.close();
		
		
	}
	public void Boom(Bubbles popped) throws IOException{
		popped.pop();
		int bi = clump.indexOf(popped);
		clump.remove(bi);
		
	}
public void changeY(int why){
	for(Bubbles b : clump){
		b.changeY(why);
	}
}

}
