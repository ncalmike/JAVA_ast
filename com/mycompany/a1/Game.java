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
 * Controller class that contains an instance of the GameWorld (model class).
 * <p>
 * Translates action commands and performs the prescribed action for that command.
 * @author      Mike Morse
 * @author      Andrew Dang
 * @version     %I%, %G%
 */
public class Game extends Form {
	
	private GameWorld gw;
	
	/**
	 * 
	 * instantiates instance of GameWorld and invokes method to initialize the model class.
	 * <p>
	 * Invokes play method.
	 */
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	/**
	 * 	Creates ActionListener to receive events and interpret events into actions.
	 *
	 */
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
			                                             case 'i':
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
			                                                gw.rotateMissileLauncher();
			                                                break;
			                                             case 'f':
			                                                gw.fireMissile();
			                                                break;
			                                             case 'L':
			                                                gw.launchMissile();
			                                                break;
			                                             /*case 'j':
			                                                gw.jumpHyper();
			                                                break; */
			                                             case 'n':
			                                                gw.reloadSupply();
			                                                break;
			                                             case 'k':
			                                                gw.killAsteroid();
			                                                break;
			                                             case 'e':
			                                                gw.eliminate();
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
			                                                /*case 't':
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
	
	/**
	 * 
	 * Confirms if user wants to quit and quits game based on confirmation.
	 *
	 */
	public void quit() {
		System.out.println("Exiting ...");
		System.exit(0);
		// Dialog.show("Quit", "Are you sure you want to Quit?", "OK", "Cancel");
	}
}
