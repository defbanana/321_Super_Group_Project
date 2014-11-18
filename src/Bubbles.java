import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.ImageIO;

public class Bubbles extends MovingTileObject {
	int points;
	Image myImage;
	int row;
	int column;
	boolean moving;
	boolean newBubble;
	
	private int numberOfAnimationFrames;
	private int currentAnimationFrame;
	ArrayList<Image> eachFrame;
	private boolean pauseAnimation;
	private boolean runAnimationOnceThenStop;
	
	private boolean Animate;


	public Bubbles(Point p, Rectangle r, Image i, double a, MyVector v, ArrayList<Image> eachF) {
		super(p, r, i, a, v, eachF);
		points=10;
		myImage = i;
		newBubble = true;
		
		// default. not assigned anywhere yet
		row = 99;
		column = 99;
		moving = false;
		runAnimationOnceThenStop = true;
		Animate = true;
		pauseAnimation = false;
        
		// TODO Auto-generated constructor stub
	}
	
	public boolean getMoving(){
		return moving;
	}
	
	public void setMoving(boolean m){
		moving = m;
	}
	
	public int getRow(){
		return row;
	}
	
	public void setRow(int r){
		row = r;
	}
	
	public int getColumn(){
		return column;
	}
	
	public void setColumn(int c){
		column = c;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void setPoints(int p){
		points = p;
	}
		
	//public void pop() throws IOException{
		//should use animation to show pop.For now.
		//call animation
	//	File image3 = new File("pop.gif");
	//	myImage = ImageIO.read(image3);
		
	//}
	
	/** @Override
	public void draw(Graphics g) {
		


		Graphics2D g2 = (Graphics2D) g;
		System.out.println(currentAnimationFrame);
		myImage = eachFrame.get(currentAnimationFrame);


		AffineTransform trans = new AffineTransform();
		trans.translate(location.x, location.y);

		g2.drawImage(myImage, trans, null);


		trans.rotate(Math.toRadians(this.getAngle()),
				myImage.getWidth(null) / 2, myImage.getHeight(null) / 2);

			
		if (!pauseAnimation) {						
			if (currentAnimationFrame == (numberOfAnimationFrames - 1)){
				if (!runAnimationOnceThenStop){
					currentAnimationFrame = 0;
				}
			}
			else
				currentAnimationFrame++;			
		}

	} */
}
