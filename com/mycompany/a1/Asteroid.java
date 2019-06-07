package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Asteroid extends MovableGameObject {
	private int size;
	
	public Asteroid() {
		super(ColorUtil.rgb(153, 102, 0));
		this.size = ( 6 + GameWorld.random.nextInt(25));
	}
	
	public int getSize(){
		return size;
	}
	public String toString() {
		return (
				"Asteroid: loc =" + GameObject.round(getLocationX()) + "," + GameObject.round(getLocationY()) +
				" color = " + GameObject.getColorString(getColor()) +
				" speed = " + GameObject.round(getSpeed()) +
				" dir = " + getDirection() + 
				" size = " + this.getSize()
		);		
	}
}
