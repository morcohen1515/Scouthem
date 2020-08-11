package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player extends User implements Serializable{

	private final String playersFileName = "players.txt";	
	private String playerName;
	private String role;
	private String mail;
	private double height;
	private double weight;
	private String age;
	private int yellowCard;
	private int redCard;
	private int totalPlayingTime;
	private int numOfAssists;
	private int goals;
	private Team MyTeam;
	private int idPlayer;
	private List<Player> ArraylistPlayer;
	/////////////////////////////////////////
	
	public Player(String playerName,String team, String role, String age, double height, double weight, String mail, int idPlayer,String userName, String password) {
		      super(userName, password);
		      this.setPlayerName(playerName);
		      MyTeam= new Team(team);
		      this.setRole(role);
		      this.setAge(age);
		      this.setHeight(height);
		      this.setWeight(weight);
		      this.setMail(mail);
		      this.setIdPlayer(idPlayer);
	}
	public Player()
	{
		
	}
	/////////////////////////////////////////
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
			this.playerName = playerName;		
	}
	public String getRole() {	
		return role;
	}
	public void setRole(String role) {
			this.role = role;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
			this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
			this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {

			this.weight = weight;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
			this.mail = mail;
	}
	public int getYellowCard() {
		return yellowCard;
	}
	public void setYellowCard(int yellowCard) {
			this.yellowCard += yellowCard;
	}
	public int getRedCard() {
		return redCard;
	}
	public void setRedCard(int redCard) {
		this.redCard = redCard;
	}
	public int getTotalPlayingTime() {
		return totalPlayingTime;
	}
	public void setTotalPlayingTime(int totalPlayingTime) {

			this.totalPlayingTime += totalPlayingTime;
	}
	public int getNumOfAssists() {
		return numOfAssists;
	}
	public void setNumOfAssists(int numOfAssists) {
			this.numOfAssists += numOfAssists;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals += goals;
	}
	public Team getMyTeam() {
		return MyTeam;
	}
	public void setMyTeam(Team myTeam) {
		MyTeam = myTeam;
	}
	public int getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}
	////////////////////////////////////////////////
	
	public void addGame(Game g)
	{
		readPlayersFile();
		
		for(int i=0; i<ArraylistPlayer.size(); i++)
		{	
			if(ArraylistPlayer.get(i).getIdPlayer() == this.getIdPlayer()) {
				
				ArraylistPlayer.get(i).setYellowCard(g.getYellowCard());
				ArraylistPlayer.get(i).setRedCard(g.getRedCard());
				ArraylistPlayer.get(i).setTotalPlayingTime(g.getPlayTimeGame());
				ArraylistPlayer.get(i).setNumOfAssists(g.getNumOfAssists());
				ArraylistPlayer.get(i).setGoals(g.getNumOfGoals());
				
				setYellowCard(g.getYellowCard());
				setRedCard(g.getRedCard());
				setTotalPlayingTime(g.getPlayTimeGame());
				setNumOfAssists(g.getNumOfAssists());
				setGoals(g.getNumOfGoals());
				
				break;
			}
		}
		
			writeToListPlayersFie(ArraylistPlayer);		
	}
	public void writeToListPlayersFie(List<Player> ArraylistPlayer) {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(playersFileName)))
		{
			objectOutputStream.writeObject(ArraylistPlayer);
			objectOutputStream.flush();
			objectOutputStream.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void readPlayersFile() {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(playersFileName))) 
		  {
			  ArraylistPlayer = (List<Player>) input.readObject();
			  input.close();

		  } 
		  catch (Exception e) 
		  {
			  ArraylistPlayer= new ArrayList<Player>();
		  }	
	}

}
