import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Point;



public abstract class OnScreenObjects {
	
	private int numberOfAnimationFrames;
	private int currentAnimationFrame;
	
	
	int hex;
	int why;
	protected Point location;
	protected Rectangle size;
	
	public OnScreenObjects(Point p,Rectangle r, int frames){
		location=p;
		size=r;
		
		numberOfAnimationFrames = frames;
		currentAnimationFrame = 1;
	}
	public Point getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Point location) {
		this.location = location;
	}

	/**
	 * @return the size
	 */
	public Rectangle getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Rectangle size) {
		this.size = size;
	}
	
	public void changeY(int y){
		int hex = location.x;
		int why = y;
		location=new Point(hex,why);
	}
	// should this be abstract
	abstract public void draw(Graphics g);
}
