package test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import  org.junit.*;

import implementation.MaintainManager;
import implementation.Manager;
import implementation.Store;

public class MaintainManagerTest {
	
	@Test
	public void testLoad() {
		MaintainManager mm = new MaintainManager();
		ArrayList<Manager> m = new ArrayList<Manager>();	//expected values are stored
		
		try {
			mm.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\managerTest1.csv");	//actual 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m.add(new Manager("Roger", "Miller", "r@gmail.com","1234",new Store()));
		m.get(0).getStore().setLocation("Toronto");
		
		assertEquals(m.get(0).getStore().getLocation(),mm.managers.get(0).getStore().getLocation());
	}
	
	@Test
	public void testUpdate() {
		MaintainManager mm = new MaintainManager();
		Manager m1= new Manager("Roger", "Miller", "r@gmail.com","1234",new Store());
		m1.getStore().setLocation("Toronto");
		mm.managers.add(m1);
		
		try {
			mm.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\managerTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mm.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\managerTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(m1.getStore().getLocation(), mm.managers.get(mm.managers.size()-1).getStore().getLocation());
	}
	
	@Test
	public void testUpdate2() {
		MaintainManager mm = new MaintainManager();
		Manager m1= new Manager("Roger", "Miller", "r@gmail.com","1234",new Store());
		m1.getStore().setLocation("Toronto");
		mm.managers.add(m1);
		
		try {
			mm.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\managerTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mm.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\managerTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(m1.getStore().getLocation(), mm.managers.get(mm.managers.size()-1).getStore().getLocation());
	}
	
	

}
