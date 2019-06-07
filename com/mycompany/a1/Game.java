package com.mycompany.a1;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;

/**
 * 
 */


public class Game extends Form {
	
	private GameWorld gw;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
		private void play()
      {
	      Label myLabel=new Label("Enter a Command:");
	      this.addComponent(myLabel);
	      final TextField myTextField=new TextField();
	      this.addComponent(myTextField);
	      this.show();
	      myTextField.addActionListener(new ActionListener()
		                                    {
		                                       public void actionPerformed(ActionEvent evt)
		                                       {
		                                          String sCommand=myTextField.getText().toString();
		                                          myTextField.clear();
		                                          if(sCommand.length() > 0) {
			                                          switch (sCommand.charAt(0))
			                                          {
			                                             /*case 'e':
			                                                gw.eliminate();
			                                                break;*/
			                                             case 'a':
			                                                gw.addNewAsteroid();
			                                                break;
			                                             case 'y':
			                                                gw.addNonPlayerShip();
			                                                break;
			                                             case 'b':
			                                                gw.addSpaceStation();
			                                                break;
			                                             case 's':
			                                                gw.addPlayerShip();
			                                                break;
			                                             /*case 'i':
			                                                gw.increaseSpeed();
			                                                break;
			                                             case 'd':
			                                                gw.decreaseSpeed();
			                                                break;
			                                             case 'l':
			                                                gw.turnLeft();
			                                                break;
			                                             case 'r':
			                                                gw.turnRight();
			                                                break;
			                                             case '>':
			                                                gw.rotateMissleLauncher();
			                                                break;*/
			                                             case 'f':
			                                                gw.fireMissile();
			                                                break;
			                                             case 'L':
			                                                gw.launchMissile();
			                                                break;
			                                             /*case 'j':
			                                                gw.jumpHyper();
			                                                break;
			                                             case 'n':
			                                                gw.reloadSupply();
			                                                break;
			                                             case 'k':
			                                                gw.killAsteroid();
			                                                break;
			                                             case 'e':
			                                                gw.ElimnateNonPS();
			                                                break;
			                                             case 'E':
			                                                gw.explodePS();
			                                                break;
			                                             case 'c':
			                                                gw.collisionAtoPS();
			                                                break;
			                                             case 'h':
			                                                gw.collisionNPS();
			                                                break;
			                                             case 't':
			                                                gw.tick();
			                                                break;*/
			                                             case 'p':
			                                                gw.display();
			                                                break;
			                                             case 'm':
			                                                gw.displayMap();
			                                                break;
			                                             case 'q':
			                                                quit();
			                                                break;
			                                          } //switch
		                                          } // if
		                                       } //actionPerformed
		                                    } //new ActionListener() 
		                                    ); //addActionListener} //play
	}
		public void quit() {
			System.out.println("Exiting ...");
			System.exit(0);
			// Dialog.show("Quit", "Are you sure you want to Quit?", "OK", "Cancel");
		}
}