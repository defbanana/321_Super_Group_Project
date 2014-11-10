import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Point;



public abstract class OnScreenObjects {
	int hex;
	int why;
	protected Point location;
	protected Rectangle size;
	public OnScreenObjects(Point p,Rectangle r){
		location=p;
		size=r;
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
