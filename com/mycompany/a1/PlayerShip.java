package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

/**
 * 
 * Describe class or intrerface
 * <p>
 * @author      Mike Morse
 * @author      Andrew Dang
 * @version     %I%, %G%
 */
public class PlayerShip extends Ship implements ISteerable {
	
	private static final int DEGREES = 6;
	   
	private SteerableMissileLauncher playerML;

	/**
	 * 
	 * Initializes 
	 *
	 */
	public PlayerShip() {
		super(ColorUtil.GREEN);
		
		playerML = new SteerableMissileLauncher();
		playerML.setDirection(getDirection());
		playerML.setSpeed(getSpeed());
	}

	@Override
	public void turnLeft() {
		setDirection(getDirection() + DEGREES);
	}
	public int getDirectionML()
	{
		return playerML.getDirection();
	}

	@Override
	public void turnRight() {
		setDirection(getDirection() - DEGREES);
	}
	
	public void turnML() { playerML.turnRight(); }
	
	public void replenishMissiles() { this.setMissileCount(this.MAX_PS_MISSILES); }
	
	public String toString() {
		return (
				"PlayerShip: loc =" + GameObject.round(getLocationX()) + "," + GameObject.round(getLocationY()) +
				" color = " + GameObject.getColorString(getColor()) +
				" speed = " + GameObject.round(getSpeed()) +
				" dir = " + getDirection() + 
				" missiles = " + getMissileCount() +
				" missile launcher dir = " + playerML.getDirection()
				
		);		
	}
}
