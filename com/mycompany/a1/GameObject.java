package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {
	private Point2D location;
	private int color;
	
	public GameObject(int color) {
		setColor(color);
		this.location = (new Point2D( GameWorld.random.nextInt(1024), GameWorld.random.nextInt(768)));
	}
	
	public double getLocationX() {
		return location.getX();
	}
	
	public double getLocationY() {
		return location.getY();
	}
	
	public int getColor() {
		return this.color;
	}
	
	
	public String getLocation() {
		return "";
	}
	public void setLocation(double x, double y){
		if(this.location == null) {
			this.location = new Point2D(x, y);
		} else {
			this.location.setX(x);
			this.location.setY(y);
		}
	}
	
	public static String getColorString(int color) {
		StringBuilder sb = new StringBuilder();
		sb.append(" [" + ColorUtil.red(color) + "," );
		sb.append(ColorUtil.green(color) + "," );
		sb.append(ColorUtil.blue(color) + "]" );
		return sb.toString();
	}
	
	public static double round(double num) {
		return Math.round(num);
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	
	
}
