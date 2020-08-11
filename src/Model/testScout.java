package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testScout {
	
	private test t;
	private Scout s;
	private ArrayList<User> InterestListplayer;
	
	@Before
	public void setUp() {
		t = new test();	
		s = new Scout();
		InterestListplayer = new ArrayList<User>();
	}
	
	@Test
	public void addPlayerToInterestingListTest()
	{
		t.testSignUpPlayer("mor", "hapoel tel aviv", "center back", "15", 1.83, 76.5, "mor@gmail.com", 123456789, "mor", "1");
		InterestListplayer = (ArrayList<User>) t.getUserList();
		int n = InterestListplayer.size();
		assertEquals("when adding new player , number of Interest players should be 1!",1 ,n);
		assertNotNull("After adding player the Interest List players will return and not NULL",InterestListplayer);	
	}
	
	@Test
	public void removePlayerFromInterestingListTest()
	{
		t.testSignUpPlayer("mor", "hapoel tel aviv", "center back", "15", 1.83, 76.5, "mor@gmail.com", 123456789, "mor", "1");
		InterestListplayer = (ArrayList<User>) t.getUserList();
		int n = InterestListplayer.size();
		assertEquals("when adding new player , number of Interest players should be 1!",1 ,n);
			
		int idPlayer = ((Player) InterestListplayer.get(0)).getIdPlayer();
		
		t.testReadUsersFile();

		for(int i=0; i<InterestListplayer.size(); i++)
		{
			if(((Player) InterestListplayer.get(i)).getIdPlayer() == idPlayer) {
				InterestListplayer.remove(i);	
				}
		}
		
		t.testWriteToUserListFile(InterestListplayer);
		
		InterestListplayer = (ArrayList<User>) t.getUserList();
		n = InterestListplayer.size();
		assertEquals("when adding new player , number of Interest players should be 1!",0 ,n);
	}
		
	@After
	public void tearDown() {
		 File myObj = new File("testUers.txt");
		 myObj.delete();
	}
}
