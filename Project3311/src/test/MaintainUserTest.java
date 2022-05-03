package test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import  org.junit.*;

import implementation.MaintainUser;
import implementation.User;

public class MaintainUserTest {
	
	@Test
	public void testUpload() {
		MaintainUser mu = new MaintainUser();
		ArrayList<User> users = new ArrayList<User>();
		
		users.add(new User("Willy", "Rock", "123 St", "r@gmail.com", "1234", "Toronto"));
		try {
			mu.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\userTest1.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(users.get(0).getAddress(), mu.users.get(0).getAddress());
	}
	
	@Test
	public void testUpdate() {
		MaintainUser mu = new MaintainUser();
		User u = new User("Willy", "Rock", "123 St", "r@gmail.com", "1234", "Toronto");
		
		mu.users.add(u);
		try {
			mu.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\userTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mu.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\userTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(u.getAddress(), mu.users.get(mu.users.size()-1).getAddress());
	}
	
	@Test
	public void testUpdate2() {
		MaintainUser mu = new MaintainUser();
		User u = new User("Willy", "Rock", "123 St", "r@gmail.com", "1234", "Toronto");
		
		mu.users.add(u);
		try {
			mu.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\userTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mu.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\userTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(u.getAddress(), mu.users.get(mu.users.size()-1).getAddress());
	}

}
