package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends Ship implements ISteerable {
	
	private static final int DEGREES = 6;
	   
	private SteerableMissileLauncher playerML;
	
	public PlayerShip() {
		super(ColorUtil.GREEN);
		setLocation(0.0, 0.0);
		setDirection(90);
		setSpeed(0);
		setMissileCount(10);
		
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
