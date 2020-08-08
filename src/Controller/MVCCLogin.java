package Controller;

import java.io.IOException;

import Model.Scout;
import Model.User;
import Model.UserList;
import View.SignInScreen;
public class MVCCLogin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		SignInScreen theView = new SignInScreen();
		UserList theModel = new UserList();
    	SignInController theController = new SignInController(theView,theModel);
        theView.setVisible(true);
	}

}
