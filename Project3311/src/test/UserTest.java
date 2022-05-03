package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.*;
import implementation.User;

public class UserTest {
	
	@Test
	public void testUser() {
		User u = new User("Troy","Banks","123 St","tr@gmail.com","1234","Toronto");
		assertNotNull(u);
	}
	
	@Test
	public void getFirstNameTest() {
		User u = new User("Troy","Banks","123 St","tr@gmail.com","1234","Toronto");
		assertEquals("Troy",u.getFirstName());
	}
	
	@Test
	public void getLastNameTest() {
		User u = new User("Troy","Banks","123 St","tr@gmail.com","1234","Toronto");
		assertEquals("Banks",u.getLastName());
	}
	
	@Test
	public void getAddressTest() {
		User u = new User("Troy","Banks","123 St","tr@gmail.com","1234","Toronto");
		assertEquals("123 St",u.getAddress());
	}
	
	@Test
	public void getEmailTest() {
		User u = new User("Troy","Banks","123 St","tr@gmail.com","1234","Toronto");
		assertEquals("tr@gmail.com",u.getEmail());
	}
	
	@Test
	public void getPasswordTest() {
		User u = new User("Troy","Banks","123 St","tr@gmail.com","1234","Toronto");
		assertEquals("1234",u.getPassword());
	}
	
	@Test
	public void getStoreLocTest() {
		User u = new User("Troy","Banks","123 St","tr@gmail.com","1234","Toronto");
		assertEquals("Toronto",u.getStore());
	}
	
	@Test
	public void setFirstNameTest() {
		User u = new User();
		u.setFirstName("Troy");
		assertEquals("Troy", u.getFirstName());
	}
	
	@Test
	public void setLastNameTest() {
		User u = new User();
		u.setLastName("Banks");
		assertEquals("Banks", u.getLastName());
	}
	
	@Test
	public void setAddressTest() {
		User u = new User();
		u.setAddress("123 St");
		assertEquals("123 St", u.getAddress());
	}
	
	@Test
	public void setEmailTest() {
		User u = new User();
		u.setEmail("tr@gmail.com");
		assertEquals("tr@gmail.com", u.getEmail());
	}
	
	@Test
	public void setPasswordTest() {
		User u = new User();
		u.setPassword("1234");
		assertEquals("1234", u.getPassword());
	}
	
	@Test
	public void setStoreLocTest() {
		User u = new User();
		u.setStore("Toronto");
		assertEquals("Toronto", u.getStore());
	}
}
