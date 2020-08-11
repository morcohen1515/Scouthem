package Model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SortingByGoal implements SortingwithStrategyDesignPattern {
	
	private ArrayList<Player> ArraylistPlayer= new ArrayList<Player>();
	private final String playersFileName = "players.txt";
	
	public SortingByGoal() {
		readFile();
	}

	@Override
	public Player[] Sort() {
		
		 Player[] sortByPlayingTime = new Player[ArraylistPlayer.size()];
		 
		 copylist(ArraylistPlayer, sortByPlayingTime);
		 mergeSort(sortByPlayingTime, sortByPlayingTime.length);
		 return sortByPlayingTime;
	}
	
	@Override
	public Player[] SortByString(String x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void copylist(ArrayList<Player> arraylistPlayer, Player[] sortByGoal) {
		for(int i=0; i<arraylistPlayer.size();i++)
		{
			sortByGoal[i]=arraylistPlayer.get(i);
		}
	}
	
	private void mergeSort(Player[] a, int n) {
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
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	 
	    
	    merge(a, l, r, mid, n - mid);	    
	}
	private void merge(Player[] a, Player[] l, Player[] r, int left, int right) {
			  
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {

					        if (l[i].getGoals() <= r[j].getGoals()) 
					            a[k++] = l[i++];
					        else 
					            a[k++] = r[j++];
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
