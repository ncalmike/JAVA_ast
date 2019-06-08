package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

/**
 * 
 * Abstract class that has core attributes and methods required for all game objects.
 * <p>
 * @author      Mike Morse
 * @author      Andrew Dang
 * @version     %I%, %G%
 */
public abstract class GameObject {
	private Point2D location;
	private int color;
	
	/**
	 * 
	 * Configures location of center of game object and the color that the game object will be drawn with.
	 * @param color int | color to use when drawwing object
	 *
	 */
	public GameObject(int color) {
		boolean isZero = this instanceof PlayerShip;
		int x = isZero ? 0 :  GameWorld.random.nextInt(1024);
		int y = isZero ? 0 :  GameWorld.random.nextInt(768);
		setColor(color);
		this.location = (new Point2D(x, y));
	}
	
	/**
	 * Getter method to access x coordinate of Point2D location
	 * @return x double 
	 *
	 */
	public double getLocationX() {
		return location.getX();
	}

	/**
	 * Accessor method to access y coordinate of Point2D location
	 * @return y double 
	 *
	 */
	public double getLocationY() {
		return location.getY();
	}
	
	/**
	 * Accessor method to get color value of game object.
	 * @return color int
	 *
	 */
	public int getColor() {
		return this.color;
	}
	
	
	/**
	 * 
	 * @return
	 *
	 */
	public String getLocation() {
		return "";
	}
	
	/**
	 * Set map location of game object 
	 * @param x double | x value of Point2D location
	 * @param y double | y value of Point2D location
	 *
	 */
	public void setLocation(double x, double y){
		if(this.location == null) {
			this.location = new Point2D(x, y);
		} else {
			this.location.setX(x);
			this.location.setY(y);
		}
	}
	
	/**
	 * Retrieves color value and returns readable format.
	 * @param color int | color of game object
	 * @return String | Readable value of color
	 *
	 */
	public static String getColorString(int color) { // why do I pass color?
		StringBuilder sb = new StringBuilder();
		sb.append(" [" + ColorUtil.red(color) + "," );
		sb.append(ColorUtil.green(color) + "," );
		sb.append(ColorUtil.blue(color) + "]" );
		return sb.toString();
	}
	
	/**
	 * Method to get closest int value of double
	 * @param num double | value to convert
	 * @return int | converted value
	 *
	 */
	public static double round(double num) {
		return Math.round(num);
	}
	
	/**
	 * Setter method to give public access to setting color value
	 * @param color int | value to set to color
	 *
	 */
	public void setColor(int color) {
		this.color = color;
	}
}
