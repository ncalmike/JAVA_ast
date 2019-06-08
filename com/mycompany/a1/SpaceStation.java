package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

/**
 * Game object that provides way to refuel and restock amunitions for player ship
 * <p>
 * @author      Mike Morse
 * @author      Andrew Dang
 * @version     %I%, %G%
 */
public class SpaceStation extends FixedGameObject {
	private int blinkRate;
	private boolean blinking;
	
	/**
	 * Initialize values specifically used for instance and propagate color value for GameObject
	 *
	 */
	public SpaceStation() {
		super(ColorUtil.YELLOW);
		this.blinkRate = 6;
		this.blinking = false;
	}
	
	/**
	 * Set blink to new state 
	 *
	 */
	public void toggleBlink()
	{
		blinking = !blinking;
	}
	
	/**
	 * Accessor method to retrieve value of blink rate
	 * @return int | blink rate of instance
	 *
	 */
	public int getBlinkRate()
	{
		return blinkRate;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return (
				"SpaceStation: loc =" + GameObject.round(getLocationX()) + "," + GameObject.round(getLocationY()) +
				" color = " + GameObject.getColorString(getColor()) + " Blink rate: " + this.blinkRate
		);		
	}

}
