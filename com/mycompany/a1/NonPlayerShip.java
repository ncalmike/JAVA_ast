package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class NonPlayerShip extends Ship
{
   private MissileLauncher enemyGun;
   private int size;
   
   public NonPlayerShip()
   {
      super(ColorUtil.rgb(255,  0,  0));
      this.enemyGun= new MissileLauncher(ColorUtil.rgb(255, 0, 0));
      this.size = GameWorld.random.nextInt(2) == 0 ? 15 : 25;
     
      //System.out.println("test location set: " + GameObject.round(getLocationX()) + "," + GameObject.round(getLocationY()));
   }
   
   public int getSize() { return this.size; }
   
   public String toString() {
		return (
				"NonPlayerShip: loc =" + GameObject.round(getLocationX()) + "," + GameObject.round(getLocationY()) +
				" color = " + GameObject.getColorString(getColor()) +
				" speed = " + GameObject.round(getSpeed()) +
				" dir = " + getDirection() + 
				" size = " + this.getSize()
		);		
	}
}