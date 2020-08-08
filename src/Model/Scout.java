package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scout extends User implements Serializable{
	
	private final String playersFileName = "players.txt";
	private final String interestListFileName = "InterestList";
	
	private String scoutName;
	private int scoutId;
	private Team MyTeam;
	private ArrayList<Player> players;
	private ArrayList<Player> InterestList;
	
	public Scout(String scoutName, String team, int scoutId, String userName, String password) {
		super(userName, password);
		this.scoutName = scoutName;
		this.scoutId=scoutId;
		MyTeam =new Team(team);
		InterestList = new ArrayList<Player>();
	}
	public Scout() {
		
	}
	
	public String getScoutName() {
		return scoutName;
	}
	public void setScoutName(String scoutName) {
		this.scoutName = scoutName;
	}
	public int getScoutId() {
		return scoutId;
	}
	public void setScoutId(int scoutId) {
		this.scoutId = scoutId;
	}
	public Team getMyTeam() {
		return MyTeam;
	}
	public void setMyTeam(Team myTeam) {
		MyTeam = myTeam;
	}
	public List<Player> getInterestList() {
		readInterestingPlayerFile();
		return InterestList;
	}
	public void setInterestList(ArrayList<Player> InterestList) {
		this.InterestList = InterestList;
	}
	public ArrayList<Player> getPlayers() {
		readPlayersFile();
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	@Override
	public String toString() {
		return  "Username:" + this.getUserName() + "\n" +
				"Password:" + this.getPassword() + "\n" +
				"scout - [scoutName = " + scoutName  + ", team = " +  MyTeam.getTeamName() + "]" + "." + "\n" + "\n";
	}
	
	public void addInterestingPlayer(int idPlayer)
	{
		readPlayersFile();
		readInterestingPlayerFile();
		System.out.print("Inside add player");
		for(int i=0; i<players.size(); i++) {
			if(players.get(i).getIdPlayer() == idPlayer) {
				InterestList.add(players.get(i));
				System.out.print("Found");
				break;
			}
		}
		writeToInterestListPlayersFile(InterestList);
	}
	public void removeInterestingPlayer(int idPlayer)
	{
		readInterestingPlayerFile();
		
		for(int i=0; i<InterestList.size(); i++)
		{
			if(InterestList.get(i).getIdPlayer() == idPlayer) {
				InterestList.remove(i);	
				}
		}
		
		writeToInterestListPlayersFile(InterestList);
	}
	
	public void readPlayersFile() {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(playersFileName))) 
		  {
			players = (ArrayList<Player>) input.readObject();
		  } 
		  catch (Exception e) 
		  {
			  players = new ArrayList<Player>();
		  }	
	}
	public void readInterestingPlayerFile() {
		String fileName = interestListFileName +  this.scoutId + ".txt";
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) 
		  {
			InterestList = new ArrayList<Player>();
			InterestList = (ArrayList<Player>) input.readObject();
		  } 
		  catch (Exception e) 
		  {
			  InterestList = new ArrayList<Player>();
		  }	
	}

	public void writeToInterestListPlayersFile(List<Player> InterestList)
	{
		String fileName = interestListFileName +  this.scoutId + ".txt";
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
			objectOutputStream.writeObject(InterestList);
			objectOutputStream.flush();
			objectOutputStream.close();
		}catch(IOException e) {
			e.printStackTrace();		
		}
	}

}
