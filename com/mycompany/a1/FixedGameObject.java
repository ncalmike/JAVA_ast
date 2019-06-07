package com.mycompany.a1;

public class FixedGameObject extends GameObject {
	
	private static int id;
	
	public FixedGameObject(int color) {
		super(color);
	}
	
	public int getNextID() {
		return ++id;
	}
}
