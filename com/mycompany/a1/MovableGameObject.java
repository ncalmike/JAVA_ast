package com.mycompany.a1;

public abstract class MovableGameObject extends GameObject implements IMovable{
	private int speed;
	private int direction;
	
	public MovableGameObject(int color) {
		super(color);
		this.setSpeed(1 + GameWorld.random.nextInt(20));
		setDirection(GameWorld.random.nextInt(360));
	}
	
	public int getSpeed() { return this.speed; }
	
	public int getDirection() { return this.direction; }
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void move() {
		double xMove = speed * (Math.cos(this.direction));
		double yMove = speed * (Math.sin(this.direction));
		this.setLocation(xMove, yMove);
	}
}
