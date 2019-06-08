package com.mycompany.a1;

public class Ship extends MovableGameObject {
	
	private int missileCount;
	
	public Ship(int color) {
		super(color);

		boolean isPS = this instanceof PlayerShip;
		int missleCount = isPS ? 10 : 4;
		setMissileCount(missleCount);
	}

	public void decrementMissleCount() {
		missileCount--;
	}
	
	public int getMissileCount() { return missileCount; }
	
	
	public void setMissileCount(int count) {
		this.missileCount = count;
	}
}
