package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class SteerableMissileLauncher extends MissileLauncher implements ISteerable
{
   private static final int DEGREES = 6;
	
	private int angle;
   
   public SteerableMissileLauncher()
   {
      super(ColorUtil.GREEN);
      this.angle = getDirection();
   }
   
   public void turnLeft() {}
   public void turnRight() { angle = angle - DEGREES; }
}
