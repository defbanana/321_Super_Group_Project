
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

	
/**
 * The screen holds and displays all of the screen objects.
 * It also contains the listener for the keyboard.
 * It also contains the timer for animation.
 * 
 * @author 
 *
 */
public class Game extends JPanel implements KeyListener {

	public static ArrayList<OnScreenObjects> gameObjects;	
	private SpriteSheet_ToCrop newSpriteSheet;
	private Score theScore;
	
	private javax.swing.Timer timer;
	
	private Level currentLevel;
	
	private int lives = 3;
	
	private boolean displayPlayNextLife = false;
	private boolean displayGameOver = false;
	private boolean displayNewLevel = false;
	
	// Used to store a list of animation frames before passing it to the tile object
	private ArrayList<Image> tempFrameList;

	/**
	 * The screen has a black background.
	 * score are added.  The timer begins.
	 */
	public Game() {
		setPreferredSize(new Dimension(Assests.screenWidth, Assests.screenHeight));
		setBackground(Color.black);
		gameObjects = new ArrayList<OnScreenObjects>();
		
		currentLevel = new Level(1);
		
		//////////////////////////////////////////////////
		// cropping images from a single sprite sheet. Loading them into frame arrays
		// Then assigning them to tiles that animate.
		loadSprites();
		
		addPuzzle();
		
		theScore = new Score(new Point(Assests.screenWidth/2 - 5, 30),
				new Rectangle(0,0));
		gameObjects.add(theScore);
		
		this.addKeyListener(this);

		timer = new javax.swing.Timer(45, new TimerListener());
		timer.start();
		

	}
	
	
	///////////////////////////////////////////////////////////
	// Load all the game sprites
	public void loadSprites() {
		newSpriteSheet = new SpriteSheet_ToCrop();
		
		///////////////////////////////////////////////////////////
		//First Sprite
		Point point = new Point(0,0);
		Rectangle size = new Rectangle(10,10);
		//Tile Blow_Bubble_Character = new Tile(point, size, newSpriteSheet.blow_bubble_characterList);
		//gameObjects.add(Blow_Bubble_Character);
		
		//Next sprite
		// etc ...
	}
	
	
	/**
	 * This method removes all moving objects from the screen and
	 * creates and adds new ones.  
	 */
	public void addPuzzle() {
		
		// remove all moving objects
		Iterator<OnScreenObjects> it = gameObjects.iterator();
		while (it.hasNext()) {
			OnScreenObjects obj = it.next();
			if (obj instanceof MovingObjects) {
				it.remove();
			}
		}

			
		//////////////////////////////////////////////////////////////////////
		// layer the different parts of the cannon
		ScreenProps cannonProp = new ScreenProps(new Point(Assests.xCannon + 24, Assests.yCannon), 
				new Rectangle(10,10),Assests.cannonStand.getImage());
		gameObjects.add(0, cannonProp);
		
		Cannon player = new Cannon(new Point(Assests.xCannon, Assests.yCannon), 
				new Rectangle(10,10),
				Assests.cannonPointer.getImage(), 270, new MyVector(0, 0));

		gameObjects.add(1, player); // always at index 1
		
		//////////////////////
		// first bubble
		
		double a = player.getAngle();
		Point firstP = new Point(player.getLocation().x + 40, player.getLocation().y + 15);

		////////////////////////////////////////////////////
		// TODO logic to decide which bubble to send up
		MyVector v = new MyVector(0,0);
		
		
		Bubbles firstBubble = new Bubbles(firstP, new Rectangle(Assests.xSpacer, Assests.ySpacer),
				Assests.greenBubble.getImage(),a,v, newSpriteSheet.blue_bubbleList);
		
		gameObjects.add(2, firstBubble);

		//////////////////////////////////////////////////////////////////////////////////
		// add initial bubbles
		//////////////////////////////////////////////////////////////////////////////////
		for (Bubbles bubble : currentLevel.theHorde){
			
			gameObjects.add(bubble);
		}
		
		/////////////////////////////////////////////////////////////////////////////////
		// add row collision targets
		/////////////////////////////
		Point p = new Point(Assests.leftSide, Assests.startY - Assests.ySpacer);
		Rectangle r = new Rectangle(Assests.xSpacer * 8, Assests.ySpacer);
		HitRow hitRow = new HitRow(p, r, true, true);
		
		for (int i = 0; i < 10; i++) {
			p = new Point(Assests.leftSide, Assests.startY + (i * Assests.ySpacer));
			r = new Rectangle(Assests.xSpacer * 8, Assests.ySpacer);

			if (i % 2 == 0)
				hitRow = new HitRow(p, r, true, false);
			else
				hitRow = new HitRow(p, r, false, false);
			
			gameObjects.add(hitRow);
		}

		
	}
	
	/**
	 * To paint, draw all the screen objects. 
	 * Depending on the state of the game (player wins/loses,
	 * new game, etc.) display some optional text.
	 * @param g The graphics object for the Screen.
	 */
	public void paintComponent(Graphics g) {
		Assests.screenWidth = this.getWidth();
		Assests.screenHeight = this.getHeight();

		super.paintComponent(g);
		// g.drawImage(backgroundImg.getImage(),
		// 0, 0, screenWidth, screenHeight, null);

		// draw objects
		for (OnScreenObjects obj : gameObjects) {
			obj.draw(g);
		}
		
		
		if (this.displayPlayNextLife) {
			g.setColor(Color.white);
			g.setFont(new Font("Serif", Font.BOLD, 36));
			g.drawString("You have " + lives + " lives left.", 150, (int) (0.4*Assests.screenHeight));
			
			g.drawString("Press Enter to Continue", 135, (int) (0.6*Assests.screenHeight));

		}
		
		if (this.displayGameOver) {
			g.setColor(Color.white);
			g.setFont(new Font("Serif", Font.BOLD, 36));
			g.drawString("Game Over", 205, (int) (0.4*Assests.screenHeight));
			
			g.drawString("Would you like to play again? (Y/N)", 30, (int) (0.6*Assests.screenHeight));

		}
		
		if (this.displayNewLevel) {
			g.setColor(Color.white);
			g.setFont(new Font("Serif", Font.BOLD, 36));
			g.drawString("You won Level " + 
					currentLevel.getLevelNumber(), 190, (int) (0.4*Assests.screenHeight));
			
			g.drawString("Press Enter to Continue", 135, (int) (0.6*Assests.screenHeight));

		}
	}

	/**
	 * Retrieve the timer.
	 * @return the timer
	 */
	public javax.swing.Timer getTimer() {
		return timer;
	}

	/**
	 * Change the timer.
	 * @param timer
	 *            the timer to set
	 */
	public void setTimer(javax.swing.Timer timer) {
		this.timer = timer;
	}

	/*
	 * The timer listener handles the event of the timer
	 * going off.
	 */
	private class TimerListener implements ActionListener {

		/*
		 * Remove any objects that are beyond their maximum age.
		 * See if there are any collisions.  Remove asteroids,
		 * shots, and the ship if necessary.  Add an explosion for collisions.
		 * 
		 * Move each object.
		 * Then repaint.  
		 */
		public void actionPerformed(ActionEvent arg0) {

			// remove things that are too old
			/** for (int i = 0; i < gameObjects.size(); i++) {
				OnScreenObjects obj = gameObjects.get(i);
				if (obj instanceof MovingObjects) {
					MovingObjects movingObj = (MovingObjects) obj;
					if (movingObj.getAge() > movingObj.getMaxAge()) {
						gameObjects.remove(obj);
					}
				}
			} */
			
			////////////////////////////////////////////////////////////
			// TODO bubble logic here
			//
			// before moving, see if there were collisions from
			// the last movement
			for (int i = 0; i < gameObjects.size(); i++) {
				OnScreenObjects obj = gameObjects.get(i);
				
				if (obj instanceof MovingObjects) {
					MovingObjects movingObj = (MovingObjects) obj;
					
					// now see if it collides with any other objects
					for (int j = i + 1; j < gameObjects.size(); j++) {
						OnScreenObjects otherObj = gameObjects.get(j);
						if (!(otherObj instanceof HitRow)) {
							continue;
						}
						if (movingObj == otherObj) {
							continue;  // in other words, don't compare to self
						}
						
						if (otherObj instanceof HitRow) {
							System.out.println("HitRow");
							
							if (movingObj.collide(otherObj)) {
								// Find where it collided, and if a bubble exists there
								System.out.println(otherObj);
								((HitRow) otherObj).setHit(true);
								
							}
						}
					}
				}
			}
			
						
			// move each object
			for (OnScreenObjects obj : gameObjects) {
				if (obj instanceof MovingObjects) {
					MovingObjects movingObj = (MovingObjects) obj;
					movingObj.move();
				}
			}
			
						
			// if lose - stop game and display Next Life 
			// if there are more lives
			boolean alive = false;
			boolean bubblesFound = false;
			for (OnScreenObjects obj : gameObjects) {
				if (obj instanceof Cannon) {
					alive = true;
				} 
				else if (obj instanceof Bubbles) {
					bubblesFound = true;
				}
			}
			if (!alive) {
				timer.stop();
				lives--;
				if (lives > 0) {
					displayPlayNextLife = true;
				}
				else {
					displayGameOver = true;
				}
			}
			else {
				if (!bubblesFound) {
					timer.stop();
					displayNewLevel = true;
				}
			// if there are no bubbles left
			// level is won.
			// Game is won when we run out of levels
			
			}

			repaint();

		}

	}

	/**
	 * Handle keyboard events relevant to the game.
	 * Player ship controls, starting a new game, continuing
	 * a game.
	 */
	public void keyPressed(KeyEvent event) {
		int keyCode = event.getKeyCode();
		Cannon player = null;
		if (gameObjects.get(1) instanceof Cannon) {
			player = (Cannon) gameObjects.get(1);
		}
		switch (keyCode) {
		
		case KeyEvent.VK_ENTER:

			if (displayPlayNextLife) {
				addPuzzle();
				this.displayPlayNextLife = false;
				timer.start();
			}
			else if (displayNewLevel) {
				currentLevel.setLevelNumber(
						currentLevel.getLevelNumber() + 1);
				addPuzzle();
				this.displayNewLevel = false;
				timer.start();
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			if (player != null) {
				double newAngle = player.getAngle() + 5;
				if (newAngle > 355) {
					newAngle = 355;
				}
				player.setAngle(newAngle);
			}

			break;
		case KeyEvent.VK_LEFT:
			if (player != null) {
				double newAngle = player.getAngle() - 5;
				if (newAngle < 185) {
					newAngle = 185;
				}
				player.setAngle(newAngle);
			}
			break;

		case KeyEvent.VK_SPACE:
			////////////////////////////////////////////////////
			// TODO logic to decide which bubble to send up
			if (player != null) {
				double a = player.getAngle();
				Point p = new Point();
				p.x = player.getLocation().x + 40;
				p.y = player.getLocation().y + 15;
				MyVector loadedV = new MyVector(0,0);


				
				////////////////////////////////////////////////////
				// First, shoot the bubble waiting in the queue
				MyVector v = new MyVector(Math.cos(Math.toRadians(a)), Math.sin(Math.toRadians(a)));
				Bubbles shotBubble = (Bubbles) gameObjects.get(2);
				gameObjects.remove(2);
				shotBubble.vector = v;
				gameObjects.add(shotBubble);
				
				////////////////////////////////////////////////////
				// load next bubble
				Bubbles bubble = new Bubbles(p,new Rectangle(Assests.xSpacer, Assests.ySpacer),
						Assests.greenBubble.getImage(),a,loadedV, newSpriteSheet.blue_bubbleList);
				
				bubble.setMoving(true);
				gameObjects.add(2, bubble);
			}

			break;
			
			
		case KeyEvent.VK_Y:
			if (displayGameOver) {
				lives = 3;
				theScore.setScore(0);
				currentLevel.setLevelNumber(1);
				addPuzzle();
				displayGameOver = false;
				timer.start();
			}
			break;
			
		case KeyEvent.VK_N:
			if (displayGameOver) {
				System.exit(0);
			}
			break;
		
			
		}
		
		
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


}
