package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.*;
import implementation.Admin;

public class AdminTest {
	
	@Test
	public void adminTest() {
		Admin admin = new Admin();
		assertNotNull(admin);
	}
	
	@Test
	public void getFirstNameTest() {
		Admin admin = new Admin("Bob","Oz","oz@gmail.com","1234");
		assertEquals("Bob",admin.getFirstName());
	}
	
	@Test
	public void getLastNameTest() {
		Admin admin = new Admin("Bob","Oz","oz@gmail.com","1234");
		assertEquals("Oz",admin.getLastName());
	}
	
	@Test
	public void getEmailTest() {
		Admin admin = new Admin("Bob","Oz","oz@gmail.com","1234");
		assertEquals("oz@gmail.com",admin.getEmail());
	}
	
	@Test
	public void getPasswordTest() {
		Admin admin = new Admin("Bob","Oz","oz@gmail.com","1234");
		assertEquals("1234",admin.getPassword());
	}
	
	@Test
	public void setFirstNameTest() {
		Admin admin = new Admin();
		admin.setFirstName("Bob");
		assertEquals("Bob",admin.getFirstName());
	}
	
	@Test
	public void setLastNameTest() {
		Admin admin = new Admin();
		admin.setLastName("Oz");
		assertEquals("Oz",admin.getLastName());
	}
	
	@Test
	public void setEmailTest() {
		Admin admin = new Admin();
		admin.setEmail("oz@gmail.com");
		assertEquals("oz@gmail.com",admin.getEmail());
	}
	
	@Test
	public void setPasswordTest() {
		Admin admin = new Admin();
		admin.setPassword("1234");
		assertEquals("1234",admin.getPassword());
	}
	
}
