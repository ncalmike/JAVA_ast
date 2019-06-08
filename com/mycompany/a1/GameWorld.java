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
	
	public GameObject getGameObject(Class<?> class1) {

		boolean found = false;
		GameObject item = null;
		
		Iterator<GameObject> itr = gameObjs.iterator();
		while(itr.hasNext() && !found) {

			item =  itr.next();
			found = item.getClass().equals(class1);
		}
		return item;
	}
	
	public boolean removeGameObject(Class<?> class1) {
		
		boolean found	= false;
		boolean removed = false;
		GameObject item = null;
		
		Iterator<GameObject> itr = gameObjs.iterator();
		while(itr.hasNext() && !found) {

			item =  itr.next();
			found = item.getClass().equals(class1); // will need to add code to identify correct item, probably relative location of objects
			if(found) removed = gameObjs.remove(item);
		}
		return removed;
	}
	
	public void addNewAsteroid() {
		gameObjs.add(new Asteroid());
	}
	
	public void killAsteroid() {
		removeGameObject(Asteroid.class);
	}
	
	public void addNonPlayerShip() {
		
		gameObjs.add(new NonPlayerShip());
	}
	
	public void addSpaceStation() {
		gameObjs.add(new SpaceStation());
	}
	
	/**
	 * 
	 * Adds player ship to game. If player is out of chances, informs user to start new game.
	 *
	 */
	public void addPlayerShip() {
		if(!hasPlayerShip && numLives > 0)
		{
			gameObjs.add(new PlayerShip());
		}else
		{
			System.out.println("Player Ship Already Exists. Stop.");
		}
	}
	
	public void explodePS() {
		// get PlayerShip - need location for expload graphic
		removeGameObject(PlayerShip.class);
		// add player ship should be done after explosion is complete
	}
	
	public void collisionAtoPS() {

		GameObject obj1	= getGameObject(PlayerShip.class);
		GameObject obj2	= getGameObject(Asteroid.class);
		
		if(obj1 != null && obj2 != null) {
			PlayerShip PS = (PlayerShip) obj1;
			Asteroid ast = (Asteroid) obj2;
			gameObjs.remove(PS);
			gameObjs.remove(ast);
		}
	}
	
	public void collisionNPS() {
		
		boolean succeed = false;
		
		GameObject obj1	= getGameObject(PlayerShip.class);
		GameObject obj2	= getGameObject(NonPlayerShip.class);
		
		if(obj1 != null && obj2 != null) {
			PlayerShip PS = (PlayerShip) obj1;
			Asteroid ast = (Asteroid) obj2;
			succeed = gameObjs.remove(PS) && gameObjs.remove(ast);
		}
		if(!succeed) out("custom message for failure");
	}
	
	public void eliminate() {

		boolean succeed = false;
		
		GameObject obj1	= getGameObject(NonPlayerShip.class);
		GameObject obj2	= getGameObject(Missile.class);
		
		if(obj1 != null && obj2 != null) {
			NonPlayerShip NPS = (NonPlayerShip) obj1;
			Missile missile = (Missile) obj2;
			succeed = gameObjs.remove(NPS) && gameObjs.remove(missile);
		}
		if(!succeed) out("custom message for failure");
	}
	
	public void reloadSupply() {
		GameObject gamePiece = getGameObject(PlayerShip.class);
		if(gamePiece != null) {
			PlayerShip PS = (PlayerShip)gamePiece;
			PS.replenishMissiles();
		}
	}
	public void increaseSpeed() {
		GameObject gamePiece = getGameObject(PlayerShip.class);
		if(gamePiece != null) {
			PlayerShip PS = (PlayerShip)gamePiece;
			PS.setSpeed(PS.getSpeed() + 1);
		}
	}
	
	public void decreaseSpeed() {
		GameObject gamePiece = getGameObject(PlayerShip.class);
		if(gamePiece != null) {
			PlayerShip PS = (PlayerShip)gamePiece;
			PS.setSpeed(PS.getSpeed() - 1);
		}
	}
	
	public void turnRight() {
		GameObject gamePiece = getGameObject(PlayerShip.class);
		if(gamePiece != null) {
			PlayerShip PS = (PlayerShip)gamePiece;
			PS.turnRight();
		}
	}
	
	public void turnLeft() {
		GameObject gamePiece = getGameObject(PlayerShip.class);
		if(gamePiece != null) {
			PlayerShip PS = (PlayerShip)gamePiece;
			PS.turnLeft();
		}
	}
	
	public void rotateMissileLauncher() {
		GameObject gamePiece = getGameObject(PlayerShip.class);
		if(gamePiece != null) {
			PlayerShip PS = (PlayerShip)gamePiece;
			PS.turnML();
		}
	}
	
	public void addMissile(Ship ship, int direction) {
		Missile msl = new Missile(ship);
		msl.setLocation(ship.getLocationX(),ship.getLocationY());
		msl.setDirection(direction);
		msl.setSpeed(ship.getSpeed() + 2);
		gameObjs.add(msl);
	}
	
	/**
	 * 
	 * Fires missile from player ship.
	 *
	 */
	public void fireMissile()
	{
		
		GameObject gamePiece = getGameObject(PlayerShip.class);
		
		if(gamePiece != null) {
			PlayerShip PS = (PlayerShip)gamePiece;
			PS.decrementMissleCount();
			addMissile((Ship)PS, PS.getDirectionML());
		}
	}
	
	

	/**
	 * 
	 * Launches missile from enemy ship
	 *
	 */
	public void launchMissile() {
		
		GameObject item = getGameObject(NonPlayerShip.class);
		if(item != null) {
			NonPlayerShip NPS = (NonPlayerShip)item;
			NPS.decrementMissleCount();
			addMissile((Ship)NPS, NPS.getDirection());
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
	
	public void out(String s) { System.out.println(s); }
	
	//public void increase
}
