package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Missile extends MovableGameObject {
	private int fuelLevel;
	private Ship owner;
	
	public Missile(Ship owner) {
		super(ColorUtil.rgb(153, 102, 0));
		this.owner = owner;
		this.fuelLevel = 15;
	}
	
	public void decrementFuelLevel() { this.fuelLevel--; }
	
	public int getFuelLevel() { return this.fuelLevel; }

	public String toString() {
		String str = (owner instanceof PlayerShip) ? "PS" : "NPS";
		
		return (
				str + "Missle: loc =" + GameObject.round(getLocationX()) + "," + GameObject.round(getLocationY()) +
				" color = " + GameObject.getColorString(getColor()) +
				" speed = " + GameObject.round(getSpeed()) +
				" dir = " + getDirection() + 
				" fuel = " + this.getFuelLevel()
		);		
	}
}
