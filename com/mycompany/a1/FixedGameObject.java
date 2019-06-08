package com.mycompany.a1;

/**
 * Base properties and method needed for game objects that are immovable.
 * <p>
 * @author      Mike Morse
 * @author      Andrew Dang
 * @version     %I%, %G%
 */
public class FixedGameObject extends GameObject {
	
	private static int id;
	
	/**
	 * Accepts color value and propagates value to GameObject
	 * @param color int | sets color to draw object
	 *
	 */
	public FixedGameObject(int color) {
		super(color);
	}
	
	/**
	 * Creates unique id for immovable objects.
	 * @return int | unique id
	 *
	 */
	public int getNextID() {
		return ++id;
	}
}
