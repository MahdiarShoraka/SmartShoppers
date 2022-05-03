package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import  org.junit.*;

import implementation.Admin;
import implementation.MaintainAdmin;

public class MaintainAdminTest {
	
	@Test
	public void testLoad() {
		MaintainAdmin ma = new MaintainAdmin();
		ArrayList<Admin> a = new ArrayList<Admin>();	//expected values are stored
		
		try {
			ma.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\adminTest1.csv");	//actual 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		a.add(new Admin("Roger", "Miller", "r@gmail.com","1234"));
		
		assertEquals(a.get(0).getFirstName(), ma.admins.get(0).getFirstName());
	}
	
	@Test
	public void testUpdate() {
		Admin admin = new Admin("Roger", "Miller", "r@gmail.com","1234");
		MaintainAdmin ma = new MaintainAdmin();
		ma.admins.add(admin);
		try {
			ma.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\adminTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ma.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\adminTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(admin.getLastName(),ma.admins.get(ma.admins.size()-1).getLastName());
	}
	
	@Test
	public void testUpdate2() {
		Admin admin = new Admin("Roger", "Miller", "r@gmail.com","1234");
		MaintainAdmin ma = new MaintainAdmin();
		ma.admins.add(admin);
		try {
			ma.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\adminTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ma.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\adminTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(admin.getLastName(),ma.admins.get(ma.admins.size()-1).getLastName());
	}
}
