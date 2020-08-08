package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class PlayerList implements Serializable{
	
	private final String playersFileName = "players.txt";
	private ArrayList<Player> ArraylistPlayer= new ArrayList<Player>();
			 
	public PlayerList() {
		readFile();
		}
	
	public ArrayList<Player> getArraylistPlayer() {
		return ArraylistPlayer;
	}

	
	//design pattern of sorting
	public Player[] SortByInt(String x){
		// sorting -> goal/assists/playing time.
		switch(x) {
		 case "goal":
			 return sortByX(x);
		 case "assists":
			 return sortByX(x);
		 case "playing time":
			 return sortByX(x);
		  default:
		   break;
		}
		return null;
	}
	private Player[] sortByX(String x) {
		// sort by: total playing time||assists||goal
		 Player[] sortByPlayingTime = new Player[ArraylistPlayer.size()];
		 
		 copylist(ArraylistPlayer, sortByPlayingTime);
		 mergeSort(sortByPlayingTime, sortByPlayingTime.length, x);
		 return sortByPlayingTime;
		}

	public Player[] sortByString(String x, String y) {
		// sorting -> role/player name/team.
		switch(x) {
		 case "role":
			 return sortByRole(x, y);
		 case "player name":
			 return sortByplayerName(x, y);
		 case "team":
			 return sortByTeam(x, y);
		 default:
			 break;			 
		}
		return null;
	}
	private Player[] sortByRole(String x, String y)
	{
		 Player[] sortByRole = new Player[ArraylistPlayer.size()];
		 int j=0;
		 for (int i = 0; i < ArraylistPlayer.size(); i++) 
				if(ArraylistPlayer.get(i).getRole().contentEquals(y))
					sortByRole[j++] = ArraylistPlayer.get(i);
		return sortByRole;		
	}
	private Player[] sortByplayerName(String x, String y)
	{
		 Player[] sortByplayerName = new Player[ArraylistPlayer.size()];
		 int j=0;
		 for (int i = 0; i < ArraylistPlayer.size(); i++) 
				if(ArraylistPlayer.get(i).getPlayerName().contentEquals(y))
					sortByplayerName[j++] = ArraylistPlayer.get(i);
		return sortByplayerName;
	}	
	private Player[] sortByTeam(String x, String y)
	{
		 Player[] sortByTeam = new Player[ArraylistPlayer.size()];
		 int j=0;
		 for (int i = 0; i < ArraylistPlayer.size(); i++) 
				if(ArraylistPlayer.get(i).getMyTeam().getTeamName().contentEquals(y))
				{
					sortByTeam[j++] = ArraylistPlayer.get(i);
				}
		return sortByTeam;		
	}

	public Player[] sortByAge(int y)
	{
		 Player[] sortByAge = new Player[ArraylistPlayer.size()];
		 for (int i = 0; i < ArraylistPlayer.size(); i++) 
				if(ArraylistPlayer.get(i).getAge() == y)
					sortByAge[i] = ArraylistPlayer.get(i);
		return sortByAge;
	}
	
	private void copylist(ArrayList<Player> arraylistPlayer, Player[] sortByGoal) {
		for(int i=0; i<arraylistPlayer.size();i++)
		{
			sortByGoal[i]=arraylistPlayer.get(i);
		}
	}
	private void mergeSort(Player[] a, int n, String x) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    Player[] l = new Player[mid];
	    Player[] r = new Player[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid, x);
	    mergeSort(r, n - mid, x);
	 
	    
	    merge(a, l, r, mid, n - mid, x);	    
	}
	private void merge(Player[] a, Player[] l, Player[] r, int left, int right, String x) {
			  
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {
			    	if (x == "goal")
			    	{
					        if (l[i].getGoals() <= r[j].getGoals()) 
					            a[k++] = l[i++];
					        else 
					            a[k++] = r[j++];
			    	}
			    	else if (x == "assists")
			    	{
					        if (l[i].getNumOfAssists() <= r[j].getNumOfAssists()) {
					        	if(l[i].getNumOfAssists() == r[j].getNumOfAssists() && l[i].getGoals() >= r[j].getGoals())
					        	{
					        		a[k++] = r[j++];
					        	}
					        	else
					        	{
					            a[k++] = l[i++];
					        	}
					        
					        }
					        else 
					            a[k++] = r[j++];
			    	}
			    	else if (x == "playing time")
			    	{	        if (l[i].getTotalPlayingTime() <= r[j].getTotalPlayingTime()) 
						            a[k++] = l[i++];
						        else 
						            a[k++] = r[j++];
			    	}
			    } 

			    while (i < left) {
			        a[k++] = l[i++];
			    }
			    while (j < right) {
			        a[k++] = r[j++];
			    }	
	}
	
	void readFile() {
		  try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(playersFileName))) {
			  ArraylistPlayer = (ArrayList<Player>) input.readObject();
		  } catch (Exception e) {
			  ArraylistPlayer = new ArrayList<Player>();
			  }	
	}
}
