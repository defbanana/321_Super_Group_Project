import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


/**
 * The Score is a screen object that displays the current number
 * of points a player has achieved in the current game.
 * @author 
 *
 */
public class Score extends OnScreenObjects {

	private int score;
	
	/**
	 * Create the score at a particular location and size.
	 * The score starts at zero.
	 * @param location The starting location.
	 * @param size The size.
	 */
	public Score(Point location, Rectangle size) {
		super(location, size);
		score = 0;
	}

	/**
	 * To draw the score, convert the integer to a string.
	 */
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Serif", Font.BOLD, 36));
		g.drawString("" + score, location.x, location.y);

	}

	/**
	 * Retrieve the score.
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Change the score.
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
