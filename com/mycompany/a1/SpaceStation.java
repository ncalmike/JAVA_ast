package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedGameObject {
	private int blinkRate;
	private boolean blinking;
	
	public SpaceStation() {
		super(ColorUtil.YELLOW);
		this.blinkRate = 6;
		this.blinking = false;
	}
	
	public void toggleBlink()
	{
		blinking = !blinking;
	}
	public int getBlinkRate()
	{
		return blinkRate;
	}
	
	public String toString() {
		return (
				"SpaceStation: loc =" + GameObject.round(getLocationX()) + "," + GameObject.round(getLocationY()) +
				" color = " + GameObject.getColorString(getColor()) + " Blink rate: " + this.blinkRate
		);		
	}

}
