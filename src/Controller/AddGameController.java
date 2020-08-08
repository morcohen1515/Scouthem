package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Game;
import Model.Player;
import View.PlayerScreen;
import View.AddGameScreen;

public class AddGameController {
	private AddGameScreen theView;
	private Player theModel;
	
	public AddGameController(AddGameScreen theView, Player theModel) {
	        this.theView = theView;
	        this.theModel = theModel;
	        this.theView.addAddGameListner(new addAddGameListner());
	        this.theView.addBackButtonListner(new backButtonListner());

	    }
	class addAddGameListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   int goalsCount = theView.getGoalsCount();
			   int numOfAssists = theView.getAssistsCount();
			   int totalPlayingTime = theView.gettotalPlayingTimeValue();
			   int redCard = theView.getRedCardCount();
			   int yellowCard = theView.getYellowCardCount();
			   Game gameToAdd = new Game("10.10.2020", yellowCard, redCard, totalPlayingTime, "Maccabi" ,numOfAssists,
						goalsCount);
			   theModel.addGame(gameToAdd);
			   theView.setVisible(false);
			   PlayerScreen playerScreen = new PlayerScreen((Player) theModel);
			   playerScreen.setVisible(true);
			   PlayerController playersControl = new PlayerController(playerScreen, (Player) theModel);
		   }
	}
	class backButtonListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   System.out.println("GameController: Back button action listner");
			   theView.setVisible(false);
			   PlayerScreen playerScreen = new PlayerScreen((Player) theModel);
			   playerScreen.setVisible(true);
			   PlayerController playersControl = new PlayerController(playerScreen, (Player) theModel);
		   }
	}
}
