import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bubbles extends MovingObjects {
	int points;
	Image myImage;
	int row;
	int column;
	boolean moving;


	public Bubbles(Point p, Rectangle r, Image i, double a, MyVector v) {
		super(p, r, i, a, v);
		points=10;
		myImage = i;
		
		// default. not assigned anywhere yet
		row = 99;
		column = 99;
		moving = false;
        
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
	
	public void why(int y){
		super.changeY(y);
	}
	
	
	
	public void pop() throws IOException{
		//should use animation to show pop.For now.
		//call animation
		File image3 = new File("pop.gif");
		myImage = ImageIO.read(image3);
		
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(myImage,location.x,location.y,size.width,size.height,null);
		
	}
}
