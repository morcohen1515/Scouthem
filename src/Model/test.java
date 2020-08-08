package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class test {
	
	private final String playersFileTest = "testPlayers.txt";
	private final String usersFileTest = "testUers.txt";
	
	private ArrayList<User> testUserList;
	private ArrayList<Player> testplayersList;
	
	private UserList u;
	private Scout s;

	public test() {
		this.testUserList = new ArrayList<User>();
		this.testplayersList = new ArrayList<Player>();
		this.u = new UserList();
		this.s = new Scout();
	}

	public ArrayList<User> getUserList() {
		testReadUsersFile();
		return testUserList;
	}

	public ArrayList<Player> getTestplayersList() {
		testReadPlayersFile();
		return testplayersList;
	}
	
	public void testSignUpPlayer(String playerName ,String team, String role, int age, double height, double weight, String mail, int idPlayer,String userName, String password)
	{
		User P = new Player(playerName, team, role, age, height, weight, mail, idPlayer, userName, password);
		testUserList.add(P);
		testplayersList.add((Player) P);
		testWriteToUserListFile(testUserList);
		testWriteToPlayersListFile(testplayersList);
	}
	public void testSignUpScout(String scoutName, String team, int scoutId, String userName, String password)
	{	
		User U = new Scout(scoutName, team, scoutId, userName,password);
		testUserList.add(U);
		testWriteToUserListFile(testUserList);

	}
	
	public void testWriteToUserListFile(List<User> testUserList) {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(usersFileTest)))
		{
			objectOutputStream.writeObject(testUserList);
			objectOutputStream.flush();
			objectOutputStream.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void testReadUsersFile(){
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(usersFileTest))) 
		  {
			testUserList = (ArrayList<User>) input.readObject();
			  input.close();
		  }
		catch (Exception e) 
		  {
			testUserList = new ArrayList<User>();
		  }
	}

	public void testWriteToPlayersListFile(ArrayList<Player> testplayersList) {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(playersFileTest)))
		{
			objectOutputStream.writeObject(testplayersList);
			objectOutputStream.flush();
			objectOutputStream.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void testReadPlayersFile(){
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(playersFileTest))) 
		  {
			testplayersList = (ArrayList<Player>) input.readObject();
			  input.close();
		  }
		catch (Exception e) 
		  {
			testplayersList = new ArrayList<Player>();
		  }
	}
	
}
