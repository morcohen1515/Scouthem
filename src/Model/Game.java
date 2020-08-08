package Model;

import java.io.Serializable;

public class Game implements Serializable{
	
	private String date;
	private int yellowCard;
	private int redCard;
	private int playTimeGame;
	private String rivalTeam;
	private int numOfAssists;
	private int numOfGoals;
	
	public Game() {
	
	}
	public Game(String date, int yellowCard, int redCard, int playTimeGame, String rivalTeam, int numOfAssists,
			int numOfGoals) {
		this.date = date;
		this.yellowCard = yellowCard;
		this.redCard = redCard;
		this.playTimeGame = playTimeGame;
		this.rivalTeam = rivalTeam;
		this.numOfAssists = numOfAssists;
		this.numOfGoals = numOfGoals;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getYellowCard() {
		return yellowCard;
	}
	public void setYellowCard(int yellowCard) {
		this.yellowCard = yellowCard;
	}
	public int getRedCard() {
		return redCard;
	}
	public void setRedCard(int redCard) {
		this.redCard = redCard;
	}
	public int getPlayTimeGame() {
		return playTimeGame;
	}
	public void setPlayTimeGame(int playTimeGame) {
		this.playTimeGame = playTimeGame;
	}
	public String getRivalTeam() {
		return rivalTeam;
	}
	public void setRivalTeam(String rivalTeam) {
		this.rivalTeam = rivalTeam;
	}
	public int getNumOfAssists() {
		return numOfAssists;
	}
	public void setNumOfAssists(int numOfAssists) {
		this.numOfAssists = numOfAssists;
	}
	public int getNumOfGoals() {
		return numOfGoals;
	}
	public void setNumOfGoals(int numOfGoals) {
		this.numOfGoals = numOfGoals;
	}
	
	@Override
	public String toString() {
		return "game : [date=" + date + ", yellow-Card=" + yellowCard + ", red-Card=" + redCard + ", play-Time-Game="
				+ playTimeGame + ", rival-Team=" + rivalTeam + ", num-Of-Assists=" + numOfAssists + ", num-Of-Goals="
				+ numOfGoals + "." + "\n";
		
	}
}
