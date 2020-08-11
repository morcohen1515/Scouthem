package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.UserList;
import View.SignInScreen;
import View.SignUpScreen;

public class SignUpController {
	private SignUpScreen theView;
	private UserList theModel;
	
	public SignUpController(SignUpScreen theView, UserList theModel) {
	        this.theView = theView;
	        this.theModel = theModel;
	        this.theView.addSignUpActionListner(new signUpActionListner());
	        this.theView.addSignInActionListner(new signInActionListner());

	    }
	class signUpActionListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   boolean flag = false;
			   String messageToDisplay = "";
			   String userType = theView.getUserType();
			   String userName = theView.getUserName();
			   if (isValidUsername(userName)) {
				   String password = theView.getPassword();
				   if (!password.equals( "Enter Password") && !password.equals("") && !password.contains(" ")) {
					   if (userType == "Player") {
						   String playerName = theView.getPlayerName();
						   if (!playerName.equals("") && !playerName.equals("Enter Name")) {
							   String playerId = theView.getPlayerId();
							   if (!playerId.isEmpty() && !playerId.equals("ID Number")) {
								   String playerAge = theView.getPlayerAge();
								   int playerWeight = theView.getPlayerWeight();
								   int playerHeight = theView.getPlayerHeight();
								   String playerTeam = theView.getPlayerTeamName();
								   if (!playerTeam.equals("") && !playerTeam.equals("Enter Team name")) 
								   {
									   String playerRole = theView.getPlayerRole();
									   String playerEmail = theView.getPlayerEmail();
									   if (isValidEmail(playerEmail)) 
									   {
										   theModel.signUpPlayer(playerName, playerTeam, playerRole, playerAge, playerHeight, playerWeight, playerEmail, Integer.parseInt(playerId), userName, password);
										   flag = true;   
									   }
									   else 
									   {
										   messageToDisplay = "Player's Email is invalid";
									   }
								   }
								   else 
								   {
									   messageToDisplay = "Player's team name is invalid";

								   }
							   }
							   else 
							   {
								   messageToDisplay = "Player's ID is invalid";
							   }
						   }
						   else
						   {
							   messageToDisplay = "Player's Name is invalid";
						   }
					   }
					   else if (userType == "Scout") {
						   String scoutName = theView.getScoutName();
						   if (!scoutName.equals("") && !scoutName.equals("Enter Name")) 
						   {
							   String scoutId = theView.getScoutId();
							   if (!scoutId.isEmpty() && !scoutId.equals("ID Number")) 
							   {
								   String scoutTeam = theView.getScoutTeamName();
								   if(!scoutTeam.equals("") && !scoutTeam.equals("Enter Team name")) 
								   {
									   theModel.signUpScout(scoutName, scoutTeam, Integer.parseInt(scoutId), userName, password);
									   flag = true;
								   }
								   else 
								   {
									   messageToDisplay = "Scout's team name is invalid";
								   }
								   
							   }
							   else {
								   messageToDisplay = "Scout's ID is invalid";
							   }
						   }
						   else {
							   messageToDisplay = "Scout's Name is invalid";

						   }
					   }
					   else {
						   messageToDisplay = "Please select User type";
					   }
				   }
				   else {
					   messageToDisplay = "Password is invalid";
				   }
				   
			   }
			   else {
				   messageToDisplay = "Username is invalid";
			   }
		       if (flag == true) {
		    	   theView.setVisible(false);
				   SignInScreen newView = new SignInScreen();
				   UserList newModel = new UserList();
				   SignInController theController = new SignInController(newView,newModel);
			       newView.setVisible(true);
		       }
		       else
		       {
		    	   theView.setErrorMessage(messageToDisplay);
		       }
		   }
		   public boolean isValidUsername(String name) 
		    { 
		  		String regex = "^[aA-zZ]\\w{2,29}$"; 
		        Pattern p = Pattern.compile(regex); 
		        if (name == null) { 
		            return false; 
		        } 
		        Matcher m = p.matcher(name);  
		        return m.matches(); 
		    }
		   public boolean isValidEmail(String mail) 
		    { 
		  		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; 
		        Pattern p = Pattern.compile(regex); 
		        if (mail == null) { 
		            return false; 
		        } 
		        Matcher m = p.matcher(mail);  
		        return m.matches(); 
		    }
	}
	class signInActionListner implements ActionListener
	{
		   public void actionPerformed(ActionEvent e) 
		   {
			   System.out.println("SignUpController: Sign in action listner");
			   SignInScreen newView = new SignInScreen();
			   SignInController theController = new SignInController(newView,theModel);
			   theView.setVisible(false);
		       newView.setVisible(true);
		   }
	}
}

