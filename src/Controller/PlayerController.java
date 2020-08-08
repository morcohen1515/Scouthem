package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Player;
import Model.UserList;
import View.SignInScreen;
import View.PlayerScreen;
import View.AddGameScreen;

public class PlayerController {

	private PlayerScreen theView;
	private Player theModel;
	
	public PlayerController(PlayerScreen theView, Player theModel) {
	        this.theView = theView;
	        this.theModel = theModel;
	        this.theView.addGameListener(new addGameListener());
	        this.theView.addSignOutListener(new signOutButtonListner());

	    }
	class addGameListener implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
	            AddGameScreen newView = new AddGameScreen(theModel);
	            AddGameController gameControl = new AddGameController(newView,theModel);
	            theView.setVisible(false);
			    newView.setVisible(true);		   
		   }
	}
	class signOutButtonListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			    System.out.println("PlayerController: Sign out action listner");
			   	SignInScreen newView = new SignInScreen();
				UserList newModel = new UserList();
		    	SignInController theController = new SignInController(newView,newModel);
		    	theView.setVisible(false);
			    newView.setVisible(true);
		   }
	}
}