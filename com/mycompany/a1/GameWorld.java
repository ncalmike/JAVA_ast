package com.mycompany.a1;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;

/**
 * 
 * Maintains logical state of the game.
 * <p>
 * @author      Mike Morse
 * @author      Andrew Dang
 * @version     %I%, %G%
 */
public class GameWorld {
	
	public static Random random;
	private Vector<GameObject> gameObjs;
	private boolean hasPlayerShip;
	private int numLives;
	private int gameTime;
	private int playerScore;
	private int numPSMissles;
	private double width;
	private double height;
	
	/**
	 * 
	 * Initializes instances of logical components used for game functionality.
	 *
	 */
	public GameWorld() {
		
		this.random = new Random();
		gameObjs = new  Vector<GameObject>();
		
		this.width = 1024;
		this.height = 768;
		
		this.hasPlayerShip = false;
		this.gameTime = 0;
		this.playerScore = 0;
		
		this.numLives = 3;
	}
	
	/**
	 * 
	 * Adds player ship to game components and initializes values needed to manage game ship.
	 *
	 */
	public void init() {
		this.addPlayerShip();
		this.hasPlayerShip = true;
		 numPSMissles = 10;
	}
	
	public void addNewAsteroid() {
		gameObjs.add(new Asteroid());
	}
	
	public void addNonPlayerShip() {
		
		gameObjs.add(new NonPlayerShip());
	}
	
	public void addSpaceStation() {
		gameObjs.add(new SpaceStation());
	}
	
	/**
	 * 
	 * Fires missile from player ship.
	 *
	 */
	public void fireMissile()
	{
		boolean found = false;
		
		Iterator<GameObject> itr = gameObjs.iterator();
		
		while(itr.hasNext() && !found) {

			GameObject item =  itr.next();
			found = item instanceof PlayerShip;
			if(found) {
				PlayerShip PS = (PlayerShip)item;
				PS.decrementMissleCount();
				Missile temp = new Missile(PS);
				temp.setLocation(PS.getLocationX(),PS.getLocationY());
				temp.setDirection(PS.getDirectionML());
				temp.setSpeed(PS.getSpeed() + 2);
				gameObjs.add(temp);
			}
		}
	}
	
	/**
	 * 
	 * Launches missile from enemy ship
	 *
	 */
	public void launchMissile() {
		boolean found = false;
		
		Iterator<GameObject> itr = gameObjs.iterator();
		
		while(itr.hasNext() && !found) {

			GameObject item =  itr.next();
			found = item instanceof NonPlayerShip;
			if(found) {
				NonPlayerShip NPS = (NonPlayerShip)item;
				NPS.decrementMissleCount();
				Missile temp = new Missile(NPS);
				temp.setLocation(NPS.getLocationX(), NPS.getLocationY());
				temp.setDirection(NPS.getDirection());
				temp.setSpeed(NPS.getSpeed() + 2);
				gameObjs.add(temp);
			}
		}
	}

	/**
	 * 
	 * Adds player ship to game. If player is out of chances, informs user to start new game.
	 *
	 */
	public void addPlayerShip() {
		if(!hasPlayerShip && numLives > 0)
		{
			double x = 0, y = 0;
			int color = ColorUtil.BLUE, speed = 0, direction = 0;
			gameObjs.add(new PlayerShip());
		}else
		{
			System.out.println("Player Ship Already Exists. Stop.");
		}
	}
	
	/**
	 * 
	 * Updates view to reflect current game objects and their respective locations.
	 *
	 */
	public void display() {
		Iterator<GameObject> iter = gameObjs.iterator();
		while(iter.hasNext()) System.out.println(iter.next());
	}
	
	/**
	 * 
	 * Displays game object locations.
	 *
	 */
	public void displayMap() {
		display();
	}
	
	//public void increase
}
