package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import implementation.Manager;
import implementation.Store;


public class ManagerTest {
	
	@Test
	public void managerTest() {
		Manager m = new Manager();
		assertNotNull(m);
	}
	
	@Test
	public void getFirstNameTest() {
		Store store = new Store();
		Manager m = new Manager("Mike","Lee","lee@gmail.com","1234",store);
		assertEquals("Mike",m.getFirstName());
	}
	
	@Test
	public void getLastNameTest() {
		Store store = new Store();
		Manager m = new Manager("Mike","Lee","lee@gmail.com","1234",store);
		assertEquals("Lee",m.getLastName());
	}
	
	
	@Test
	public void getEmailTest() {
		Store store = new Store();
		Manager m = new Manager("Mike","Lee","lee@gmail.com","1234",store);
		assertEquals("lee@gmail.com",m.getEmail());
	}
	
	@Test
	public void getPasswordTest() {
		Store store = new Store();
		Manager m = new Manager("Mike","Lee","lee@gmail.com","1234",store);
		assertEquals("1234",m.getPassword());
	}
	
	@Test
	public void getStoreTest() {
		Store store = new Store();
		Manager m = new Manager("Mike","Lee","lee@gmail.com","1234",store);
		assertNotNull(m.getStore());
	}
	
	@Test
	public void setFirstNameTest() {
		Store store = new Store();
		Manager m = new Manager("Mike","Lee","lee@gmail.com","1234",store);
		m.setFirstName("Troy");
		assertEquals("Troy", m.getFirstName());
	}
	
	@Test
	public void setLastNameTest() {
		Store store = new Store();
		Manager m = new Manager("Mike","Lee","lee@gmail.com","1234",store);
		m.setLastName("Banks");
		assertEquals("Banks", m.getLastName());
	}
	
	
	@Test
	public void setEmailTest() {
		Store store = new Store();
		Manager m = new Manager("Mike","Lee","lee@gmail.com","1234",store);
		m.setEmail("tr@gmail.com");
		assertEquals("tr@gmail.com", m.getEmail());
	}
	
	@Test
	public void setPasswordTest() {
		Store store = new Store();
		Manager m = new Manager("Mike","Lee","lee@gmail.com","1234",store);
		m.setPassword("6789");
		assertEquals("6789", m.getPassword());
	}
	
	@Test
	public void setStoreTest() {
		Store store = new Store();
		Manager m = new Manager();
		m.setStore(store);
		assertNotNull(m.getStore());
	}

}
