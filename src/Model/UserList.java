package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UserList implements Serializable{
	
	private final String usersFileName = "users.txt";
	private List<User> userList = null; 
	private final String playersFileName = "players.txt";
	private List<Player> playersList = null;
	
	public UserList(){
		  readUsersFile();
		  readPlayersFile();
	}

	public List<User> getUserList(){
		readUsersFile();
		return  userList;
	}
	public List<Player> getPlayerList(){
		readPlayersFile();
		return  playersList;
	}
	public void addUser(User u)
	{
		userList.add(u);
		writeToUserListFile(userList);
	}
	public User login(String userName, String password)
	{
		for(int i=0;i<playersList.size();i++)
		{
			 if((playersList.get(i).getUserName().equals(userName)) && (playersList.get(i).getPassword().equals(password))) 
			 {
					return playersList.get(i);
			 }
		}
		
		for(int i=0;i<userList.size();i++)
		{
			 if((userList.get(i).getUserName().equals(userName)) && (userList.get(i).getPassword().equals(password))) 
			 {
					return userList.get(i);
			 }
		}
		
		return null;
	}
	public void signUpPlayer(String playerName ,String team, String role, int age, double height, double weight, String mail, int idPlayer,String userName, String password)
	{
		User P = new Player(playerName, team, role, age, height, weight, mail, idPlayer, userName, password);
		userList.add(P);
		playersList.add((Player) P);
		writeToUserListFile(userList);
		writeToListPlayersFie(playersList);
	}
	public void signUpScout(String scoutName, String team, int scoutId, String userName, String password)
	{	
		User U = new Scout(scoutName, team, scoutId, userName,password);
		userList.add(U);
		writeToUserListFile(userList);

	}
	public void writeToUserListFile(List<User> userList) {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(usersFileName)))
		{
			objectOutputStream.writeObject(userList);
			objectOutputStream.flush();
			objectOutputStream.close();
			System.out.println("Write to users file succeed");
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
		
	public void writeToListPlayersFie(List<Player> ArraylistPlayer) {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(playersFileName)))
		{
			objectOutputStream.writeObject(ArraylistPlayer);
			objectOutputStream.flush();
			objectOutputStream.close();
			System.out.println("Write to players file succeed");
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void readUsersFile(){
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(usersFileName))) 
		  {
			  userList = (List<User>) input.readObject();
			  input.close();
			  System.out.println("Read users file succeed");
			  System.out.println("Userlist value is:" + userList);

		  }
		catch (Exception e) 
		  {
			System.out.println("Userlist value is:" + userList);
			if (userList == null) {
				 userList = new ArrayList<User>();
				 System.out.println("Created users list");
			}
			  
		  }
	}
	public void readPlayersFile() {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(playersFileName))) 
		  {
			  playersList = (List<Player>) input.readObject();
			  input.close();
			  System.out.println("Read players file succeed");
			  System.out.println("playerslist value is:" + playersList);
		  } 
		  catch (Exception e) 
		  {
			System.out.println("playerslist value is:" + playersList);
			if (playersList == null) 
			{
			  playersList= new ArrayList<Player>();
			  System.out.println("Created players list");
			}
		  }	
	
	}
		
}
