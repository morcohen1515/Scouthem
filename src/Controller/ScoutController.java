package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Model.Player;
import Model.Scout;
import Model.SortByAge;
import Model.SortByRole;
import Model.SortByTeam;
import Model.SortByTimePlaying;
import Model.SortingByGoal;
import Model.SortingwithStrategyDesignPattern;
import Model.SotrByAssists;
import Model.UserList;
import View.SignInScreen;
import View.ScoutScreen;

public class ScoutController {
	private ScoutScreen theView;
	private Scout theModel;
	private UserList userList;
	
	public ScoutController(ScoutScreen theView, Scout theModel, UserList users) 
	{
	        this.theView = theView;
	        this.theModel = theModel;
	        userList = users;
	        this.theView.addSignOutListener(new signOutButtonListner());
	        this.theView.addFindPlayersListener(new findPlayersListner());
	        this.theView.addShowPlayersListener(new showPlayersListner());
	        this.theView.addAddPlayerListener(new addPlayerListner());
	        this.theView.addRemovePlayerListener(new removePlayerListner());
	        this.theView.addSortByGoalsListener(new sortByGoalsListner());
	        this.theView.addFilterByTeamListener(new filterByTeamListner());
	        this.theView.addFilterByRoleListener(new filterByRoleListner());
	        this.theView.addFilterByAgeListener(new filterByAgeListner());
	        this.theView.addSortByAssistsListener(new sortByAssistsListner());
	        this.theView.addSortByPlayingTimeListener(new sortByPlayingTimeListner());
	}
	class filterByTeamListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   SortingwithStrategyDesignPattern players = new SortByTeam();
			   String teamName = theView.getTeamName();
			   Player[] listOfPlayers = null;
			   if (teamName.equals("Team") ) 
			   {
				   theView.setMessage("Enter valid team name");
			   }
			   else 
			   {
				   listOfPlayers = players.SortByString(teamName);
			   }
			   if (listOfPlayers != null) {
				   theView.initFindPlayersTable();
				   theView.showFindPlayersTable();
					for (Player i: listOfPlayers) 
					{
						if(i != null)
						{
							theView.addItemToFindPlayersTable(i.getPlayerName(), i.getMyTeam().getTeamName(), i.getRole(), i.getGoals(), i.getNumOfAssists(), i.getTotalPlayingTime(), i.getYellowCard(), i.getRedCard(), i.getAge(), i.getIdPlayer());
				   		
						}
				   	}
			   }
		   }
	}
	class filterByRoleListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   SortingwithStrategyDesignPattern players = new SortByRole();
			   String role = theView.getPlayerRole();
			   Player[] listOfPlayers = null;
			   listOfPlayers = players.SortByString(role);
			   if (listOfPlayers != null) 
			   {
				   theView.initFindPlayersTable();
				   theView.showFindPlayersTable();
					for (Player i: listOfPlayers) 
					{
						if(i != null)
						{
							theView.addItemToFindPlayersTable(i.getPlayerName(), i.getMyTeam().getTeamName(), i.getRole(), i.getGoals(), i.getNumOfAssists(), i.getTotalPlayingTime(), i.getYellowCard(), i.getRedCard(), i.getAge(), i.getIdPlayer());
				   		
						}
				   	}
			   }
		   }
	}
	class filterByAgeListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   SortingwithStrategyDesignPattern players = new SortByAge();
			   String Age = theView.getAge();
			   Player[] listOfPlayers = null;
			   listOfPlayers = players.SortByString(Age);
			   if (listOfPlayers != null) 
			   {
				   theView.initFindPlayersTable();
				   theView.showFindPlayersTable();
					for (Player i: listOfPlayers) 
					{
						if(i != null)
						{
							theView.addItemToFindPlayersTable(i.getPlayerName(), i.getMyTeam().getTeamName(), i.getRole(), i.getGoals(), i.getNumOfAssists(), i.getTotalPlayingTime(), i.getYellowCard(), i.getRedCard(), i.getAge(), i.getIdPlayer());
				   		
						}
				   	}
			   }
		   }
	}

	class sortByPlayingTimeListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   SortingwithStrategyDesignPattern players = new SortByTimePlaying();
			   Player[] listOfPlayers = players.Sort();
			   	theView.initFindPlayersTable();
			   	theView.showFindPlayersTable();
			   	for (Player i: listOfPlayers) {
			   		theView.addItemToFindPlayersTable(i.getPlayerName(), i.getMyTeam().getTeamName(), i.getRole(), i.getGoals(), i.getNumOfAssists(), i.getTotalPlayingTime(), i.getYellowCard(), i.getRedCard(), i.getAge(), i.getIdPlayer());
			   	}
			   
		   }
	}
	class sortByAssistsListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   SortingwithStrategyDesignPattern players = new SotrByAssists();
			   Player[] listOfPlayers = players.Sort();
			   	theView.initFindPlayersTable();
			   	theView.showFindPlayersTable();
			   	for (Player i: listOfPlayers) {
			   		theView.addItemToFindPlayersTable(i.getPlayerName(), i.getMyTeam().getTeamName(), i.getRole(), i.getGoals(), i.getNumOfAssists(), i.getTotalPlayingTime(), i.getYellowCard(), i.getRedCard(), i.getAge(), i.getIdPlayer());
			   	}
			   
		   }
	}
	class sortByGoalsListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   SortingwithStrategyDesignPattern SortByGoal = new SortingByGoal();
			   Player[] listOfPlayers = SortByGoal.Sort();
			   	theView.initFindPlayersTable();
			   	theView.showFindPlayersTable();
			   	for (Player i: listOfPlayers) {
			   		theView.addItemToFindPlayersTable(i.getPlayerName(), i.getMyTeam().getTeamName(), i.getRole(), i.getGoals(), i.getNumOfAssists(), i.getTotalPlayingTime(), i.getYellowCard(), i.getRedCard(), i.getAge(), i.getIdPlayer());
			   	}
			   
		   }
	}
	class removePlayerListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   	int row = theView.getSelectedRowInInterestTable();
			   	Object id = theView.getValueFromInterestTable(row, 9);
			   	if (id != null) 
			   	{
			   		theModel.removeInterestingPlayer((int) id);
				   	theView.initInterestTable();
				   	theView.showInterestTable();
				   	List<Player> InterestList = theModel.getInterestList();
				   	if (InterestList.isEmpty()) 
				   	{
				   		theView.setMessage("Player removed, Interest list is empty");
				   		theView.setVisibleOfRemoveButton(false);
				   	}
				   	else 
				   	{
				   		for (Player i: InterestList) 
					   	{
					   		theView.addItemToInterestTable(i.getPlayerName(), i.getMyTeam().getTeamName(), i.getRole(), i.getGoals(), i.getNumOfAssists(), i.getTotalPlayingTime(), i.getYellowCard(), i.getRedCard(), i.getAge(), i.getIdPlayer());
					   	}
					   	theView.setMessage("Player removed");
				   		theView.setVisibleOfRemoveButton(true);
				   	}
			   	}
			   	else
			   	{
			   		theView.setMessage("Please select a player to remove");
			   	}
			   	
		   }
	}
	class addPlayerListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   	int row = theView.getSelectedRowInFindPlayersTable();
			   	Object id = theView.getValueFromFindPlayersTable(row, 9);
			   	if (id != null) {
			   		theModel.addInterestingPlayer((int) id);
				   	theView.setMessage("Player added");
			   	}
			   	else 
			   	{
			   		theView.setMessage("Please select player from the list");
			   	}
			   	
		   }
	}
	class signOutButtonListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			    System.out.println("ScoutController: Sign out action listner");
			   	SignInScreen newView = new SignInScreen();
				UserList newModel = new UserList();
		    	SignInController theController = new SignInController(newView,newModel);
		        theView.setVisible(false);
		        newView.setVisible(true);
		   }
	}
	class findPlayersListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   	theView.initFindPlayersTable();
			   	theView.showFindPlayersTable();
			   	ArrayList<Player> findPlayersList = theModel.getPlayers();
			   	if (findPlayersList.isEmpty()) {
			   		theView.setVisibleOfAddButton(false);
			   		theView.setMessage("No current players available");
			   	}
			   	else 
			   	{
				   	for (Player i: findPlayersList) 
				   	{
				   		theView.addItemToFindPlayersTable(i.getPlayerName(), i.getMyTeam().getTeamName(), i.getRole(), i.getGoals(), i.getNumOfAssists(), i.getTotalPlayingTime(), i.getYellowCard(), i.getRedCard(), i.getAge(), i.getIdPlayer());
				   	}
			   		theView.setVisibleOfAddButton(true);

			   	}

		   }
	}
	class showPlayersListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   	theView.initInterestTable();
			   	theView.showInterestTable();
			   	List<Player> InterestList = theModel.getInterestList();
			   	if (InterestList.isEmpty())
			   	{
			   		theView.setVisibleOfRemoveButton(false);
			   		theView.setMessage("Interest list is empty");
			   	}
			   	else 
			   	{
			   		for (Player i: InterestList) 
			   		{
				   		theView.addItemToInterestTable(i.getPlayerName(), i.getMyTeam().getTeamName(), i.getRole(), i.getGoals(), i.getNumOfAssists(), i.getTotalPlayingTime(), i.getYellowCard(), i.getRedCard(), i.getAge(), i.getIdPlayer());
				   	}
			   		theView.setVisibleOfRemoveButton(true);
			   	}
			   	
		   }
	}
	
}
