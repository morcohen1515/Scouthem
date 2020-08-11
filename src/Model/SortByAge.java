package Model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SortByAge implements SortingwithStrategyDesignPattern {
	
	
	private ArrayList<Player> ArraylistPlayer= new ArrayList<Player>();
	private final String playersFileName = "players.txt";
	
	public SortByAge() {
		readFile();
	}
	
	@Override
	public Player[] SortByString(String x) {
		 Player[] sortByAge = new Player[ArraylistPlayer.size()];
		 for (int i = 0; i < ArraylistPlayer.size(); i++) 
				if(ArraylistPlayer.get(i).getAge() == x)
					sortByAge[i] = ArraylistPlayer.get(i);
		return sortByAge;
	}

	@Override
	public Player[] Sort() {
		// TODO Auto-generated method stub
		return null;
	}

	void readFile() {
		  try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(playersFileName))) {
			  ArraylistPlayer = (ArrayList<Player>) input.readObject();
		  } catch (Exception e) {
			  ArraylistPlayer = new ArrayList<Player>();
			  }	
	}
}
