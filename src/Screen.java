import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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
public class Screen extends JPanel implements KeyListener {

	public static int screenWidth = 600;
	public static int screenHeight = 500;
	public static ImageIcon backgroundImg = new ImageIcon("space.jpg");
	public static ImageIcon asteroidImg = new ImageIcon("SingleAsteroid.gif");
	public static ImageIcon shipImg = new ImageIcon("PlayerShip.gif");
	public static ImageIcon explosionImg = new ImageIcon("explosion1.gif");

	public static int asteroidWidth = 80;
	public static int asteroidHeight = 80;
	public static int asteroidPoints = 10;

	private ArrayList<OnScreenObjects> screenObjects;
	private Score theScore;
	
	private javax.swing.Timer timer;
	
	private Level currentLevel;
	
	private int lives = 3;
	
	private boolean displayPlayNextLife = false;
	private boolean displayGameOver = false;
	private boolean displayNewLevel = false;

	/**
	 * The screen has a black background.  When first
	 * create the game Level is 1.  Asteroids, ships, and the
	 * score are added.  The timer begins.
	 */
	public Screen() {
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.black);
		screenObjects = new ArrayList<ScreenObject>();
		
		currentLevel = new Level(1);

		
		addPuzzle();
		
		theScore = new Score(new Point(screenWidth/2 - 5, 30),
				new Rectangle(0,0));
		screenObjects.add(theScore);
		
		this.addKeyListener(this);

		timer = new javax.swing.Timer(30, new TimerListener());
		timer.start();

	}

	/**
	 * This method removes all moving objects from the screen and
	 * creates and adds new ones.  
	 */
	public void addPuzzle() {
		
		
		// remove all moving objects
		Iterator<ScreenObject> it = screenObjects.iterator();
		while (it.hasNext()) {
			ScreenObject obj = it.next();
			if (obj instanceof MovingScreenObject) {
				it.remove();
			}
		}
		
		Random generator = new Random();

		// add player's ship // for simplicity, let's always add the ship at
		// index 0
		int x = screenWidth / 2 - 10;
		int y = screenHeight / 2;
		Ship playerShip = new Ship(new Point(x, y), new Rectangle(20, 20),
				shipImg.getImage());
		playerShip.setVector(new MyVector(0, 0));
		playerShip.setAngle(0);
		screenObjects.add(0, playerShip); // always at index 0

		// for loop to add asteroids
		for (int count = 0; count < currentLevel.getNumberOfAsteroid(); count++) {
			// generate random location
			x = generator.nextInt(screenWidth);
			y = generator.nextInt(screenHeight);
			// generate size
			int width = asteroidWidth;
			int height = asteroidHeight; // trial sizes

			int points = asteroidPoints; // trial points

			Asteroid asteroid = new Asteroid(new Point(x, y), new Rectangle(
					width, height), points, asteroidImg.getImage());

			// generate trial vector
			double dx = 10 * Math.random() - 5;
			double dy = 10 * Math.random() - 5;
			asteroid.setVector(new MyVector(dx, dy));

			screenObjects.add(asteroid);

		} // finished adding asteroids

		
	}
	
	/**
	 * To paint, draw all the screen objects. 
	 * Depending on the state of the game (player wins/loses,
	 * new game, etc.) display some optional text.
	 * @param g The graphics object for the Screen.
	 */
	public void paintComponent(Graphics g) {
		screenWidth = this.getWidth();
		screenHeight = this.getHeight();

		super.paintComponent(g);
		// g.drawImage(backgroundImg.getImage(),
		// 0, 0, screenWidth, screenHeight, null);

		// draw objects
		for (ScreenObject obj : screenObjects) {
			obj.draw(g);
		}
		
		
		if (this.displayPlayNextLife) {
			g.setColor(Color.white);
			g.setFont(new Font("Serif", Font.BOLD, 36));
			g.drawString("You have " + lives + " ships left.", 150, (int) (0.4*screenHeight));
			
			g.drawString("Press Enter to Continue", 135, (int) (0.6*screenHeight));

		}
		
		if (this.displayGameOver) {
			g.setColor(Color.white);
			g.setFont(new Font("Serif", Font.BOLD, 36));
			g.drawString("Game Over", 205, (int) (0.4*screenHeight));
			
			g.drawString("Would you like to play again? (Y/N)", 30, (int) (0.6*screenHeight));

		}
		
		if (this.displayNewLevel) {
			g.setColor(Color.white);
			g.setFont(new Font("Serif", Font.BOLD, 36));
			g.drawString("You won Level " + 
					currentLevel.getLevelNumber(), 190, (int) (0.4*screenHeight));
			
			g.drawString("Press Enter to Continue", 135, (int) (0.6*screenHeight));

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
			for (int i = 0; i < screenObjects.size(); i++) {
				ScreenObject obj = screenObjects.get(i);
				if (obj instanceof MovingScreenObject) {
					MovingScreenObject movingObj = (MovingScreenObject) obj;
					if (movingObj.getAge() > movingObj.getMaxAge()) {
						screenObjects.remove(obj);
					}
				}
			}
			// before moving, see if there were collisions from
			// the last movement

			for (int i = 0; i < screenObjects.size(); i++) {
				ScreenObject obj = screenObjects.get(i);

				if (obj instanceof MovingScreenObject) {
					MovingScreenObject movingObj = (MovingScreenObject) obj;
					// now see if it collides with any other objects
					for (int j = i + 1; j < screenObjects.size(); j++) {
						ScreenObject otherObj = screenObjects.get(j);
						if (!(otherObj instanceof MovingScreenObject)) {
							continue;
						}
						if (movingObj == otherObj) {
							continue;  // in other words, don't compare to self
						}
						if (otherObj instanceof MovingScreenObject) {
							MovingScreenObject otherMovingObj = (MovingScreenObject) otherObj;
							if (movingObj.collide(otherMovingObj)) {
								;
								; // do something

								if (movingObj instanceof Ship) {
									// ship is destroyed if it hits anything
									
									// if the 2nd object is a shot, make
									// sure it is older than 2 time clicks
									// This prevents the ship from shooting itself.
									if (otherMovingObj instanceof Shot) {
										if (otherMovingObj.getAge() <= 4) {
											continue;
										}
									}
									Explosion explosion = new Explosion(
											movingObj.location,
											movingObj.getSize(),
											explosionImg.getImage(), 0);
									explosion.setVector(new MyVector(0, 0));
									screenObjects.add(explosion);
									screenObjects.remove(movingObj);// ship must be at zero
									break;
								}

								else if (movingObj instanceof Asteroid
										&& otherMovingObj instanceof Shot) {
									Asteroid asteroid = (Asteroid) movingObj;
									theScore.setScore(theScore.getScore() +
											asteroid.getPointValue());
									
									if (movingObj.getSize().getWidth() >= asteroidWidth) {
										// break into two
										screenObjects.remove(movingObj);
										Point p = movingObj.location;

										for (int count = 0; count < 2; count++) {
											Asteroid small1 = new Asteroid(
													new Point(
															p.x
																	+ count
																	* asteroidWidth
																	/ 2, p.y),
													new Rectangle(
															asteroidWidth / 2,
															asteroidHeight / 2),
													2 * asteroidPoints,
													asteroidImg.getImage());
											// generate trial vector
											double dx = 20 * Math.random() - 10;
											double dy = 20 * Math.random() - 10;
											small1.setVector(new MyVector(dx,
													dy));

											screenObjects.add(small1);
										}

									} else {
										// destroy the asteroid
										screenObjects.remove(movingObj);
									}
									Explosion explosion = new Explosion(
											movingObj.location,
											movingObj.getSize(),
											explosionImg.getImage(), 0);
									explosion.setVector(new MyVector(0, 0));
									screenObjects.add(explosion);
									screenObjects.remove(otherMovingObj);
								}
							}
						}
					}
				}

			}
			// move each object
			for (ScreenObject obj : screenObjects) {
				if (obj instanceof MovingScreenObject) {
					MovingScreenObject movingObj = (MovingScreenObject) obj;
					movingObj.move();
				}
			}
			
			// if no ship and no explosions, then stop game and display Next Life 
			// if there are more lives
			boolean shipFound = false;
			boolean explosionFound = false;
			boolean asteroidFound = false;
			for (ScreenObject obj : screenObjects) {
				if (obj instanceof Ship) {
					shipFound = true;
				} 
				else if (obj instanceof Explosion) {
					explosionFound = true;
				}
				else if (obj instanceof Asteroid) {
					asteroidFound = true;
				}
			}
			if (!shipFound && !explosionFound) {
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
				if (!asteroidFound) {
					timer.stop();
					displayNewLevel = true;
				}
			// if there are no asteroids or saucers left
			// level is won.
			
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
		Ship playerShip = null;
		if (screenObjects.get(0) instanceof Ship) {
			playerShip = (Ship) screenObjects.get(0);
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
			
				
			case KeyEvent.VK_UP:
			// handle up
			// go forward
			if (playerShip != null) {
				Point location = playerShip.getLocation();
				double angle = playerShip.getAngle();
				// set up changeX and changeY
				// first assume the end point is 5 pixels to the right
				double endX = location.x + 5;
				double endY = location.y;
	
				// vector = new MyVector(0, 0);
	
				double newEndX = location.x + (endX - location.x)
						* Math.cos(Math.toRadians(angle)) - (endY - location.y)
						* Math.sin(Math.toRadians(angle));
				double newEndY = location.y + (endX - location.x)
						* Math.sin(Math.toRadians(angle));
	
				double changeX = (newEndX - location.x);
				double changeY = (newEndY - location.y);
				MyVector vector = new MyVector(changeX, changeY);
				playerShip.setVector(vector);
			}

			break;
		case KeyEvent.VK_DOWN:
			// handle down
			if (playerShip != null) {
				MyVector vector = new MyVector(0, 0);
				playerShip.setVector(vector);
			}

			break;
		case KeyEvent.VK_RIGHT:
			if (playerShip != null) {
				double newAngle = playerShip.getAngle() + 5;
				if (newAngle > 360) {
					newAngle -= 360;
				}
				playerShip.setAngle(newAngle);
			}

			break;
		case KeyEvent.VK_LEFT:
			if (playerShip != null) {
				double newAngle = playerShip.getAngle() - 5;
				if (newAngle < 0) {
					newAngle += 360;
				}
				playerShip.setAngle(newAngle);
			}
			break;

		case KeyEvent.VK_SPACE:
			if (playerShip != null) {
				Point p = playerShip.getLocation();
				double a = playerShip.getAngle();
				Rectangle r = playerShip.getSize();
				Shot shot = new Shot(new Point(p.x + r.width / 2, p.y + r.height
						/ 2), new Rectangle(15, 2), null, a);
	
				screenObjects.add(shot);
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
