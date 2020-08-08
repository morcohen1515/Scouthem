package Model;

import java.io.Serializable;

public class Team implements Serializable{
	
	private String teamName;
	private Game MyGame;
	
	public Team() {

	}
	public Team(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {

		this.teamName = teamName;
	}
	public Game getMyGame() {
		return MyGame;
	}
	public void setMyGame(Game myGame) {
		MyGame = myGame;
	}

}
