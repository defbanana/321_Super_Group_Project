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


	public Bubbles(Point p, Rectangle r, Image i, MyVector v) throws IOException{
		super(p, r, i,v);
		points=10;
		File image2 = new File("greenBubble.gif");
        myImage = ImageIO.read(image2);
		// TODO Auto-generated constructor stub
	}
public int getPoints(){
	return points;
}
public void setPoints(int p){
	points=p;
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
