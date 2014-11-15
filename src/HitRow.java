import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;


/**
 * 
 * An OnScreenObject To provide logic for bubbles entering each row of the level
 * Is not drawn
 * @author Jesse_Macbook_Pro
 *
 */
public class HitRow extends OnScreenObjects{
	
	protected boolean eightRow;
	ArrayList<BubbleBoundary> bubbleBoundaries;

	private boolean hit;
	
	HitRow(Point p,Rectangle r, boolean e, boolean c){
		super(p,r);		
		hit = false;
		
		bubbleBoundaries = new ArrayList<BubbleBoundary>();
		eightRow = e;
		
		if (e){
			for(int i = 0; i < 8; i++){
				BubbleBoundary b;
				b = new BubbleBoundary(Assests.leftSide + (i * Assests.xSpacer), 
						Assests.leftSide + ((i+1) * Assests.xSpacer ) - 1);				
				bubbleBoundaries.add(b);
			}
		}else if (!c){
			for(int i = 0; i < 7; i++){
				BubbleBoundary b;
				b = new BubbleBoundary(Assests.nook + Assests.leftSide + (i * Assests.xSpacer), 
						Assests.nook + Assests.leftSide + ((i+1) * Assests.xSpacer ) - 1);				
				bubbleBoundaries.add(b);
			}
		}
	}
	
	public void setHit(boolean flag){
		hit = flag;
	}
	
	public boolean getHit(){
		return hit;
	}
	
	private class BubbleBoundary {
		
	    private int xLeft;
	    private int xRight;
	    
	    BubbleBoundary(int newXLeft, int newXRight) {
	    	xLeft = newXLeft;
	    	xRight = newXRight;
	    }
		
		public int getLeftX() {
			return xLeft;
		}
		
	    void setXLeft(int newX) {
	    	xLeft = newX;
	    }

		public int getXRight() {
			return xRight;
		}
		
	    void setY(int newX) {
	    	xRight = newX;
	    }
	}

	@Override
	public void draw(Graphics g) {
		// draws if debug is turned on
		if (Assests.debug && hit){
			g.drawImage(Assests.greenBubble.getImage(), location.x, location.y, size.width, size.height, null);
		}	
	}
	

	

}
