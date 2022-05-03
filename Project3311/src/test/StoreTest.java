package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.*;

import implementation.Item;
import implementation.Store;

public class StoreTest {
	
	@Test
	public void storeTest() {
		Store s = new Store();
		assertNotNull(s);
	}
	
	@Test
	public void getLocationTest() {
		Store s = new Store("Toronto", new ArrayList<Item>());
		assertEquals("Toronto", s.getLocation());
	}
	
	@Test
	public void getItemsTest() {
		Store s = new Store("Toronto", new ArrayList<Item>());
		s.items.add(new Item());
		assertNotNull(s.getItems());
	}
	
	@Test
	public void openingHourTest() {
		Store s = new Store();
		s.setOpeningHour(8);
		assertEquals(8,s.getOpeningHour(),0.0001);
	}
	
	@Test
	public void closingHourTest() {
		Store s = new Store();
		s.setClosingHour(20);
		assertEquals(20,s.getClosingHour(),0.0001);
	}
	
	@Test
	public void upperTest() {
		Store s = new Store();
		s.setUpper("Phone");
		assertEquals("Phone",s.getUpper());
	}
	
	@Test
	public void lowerTest() {
		Store s = new Store();
		s.setLower("Phone");
		assertEquals("Phone",s.getLower());
	}
	
	@Test
	public void rightTest() {
		Store s = new Store();
		s.setRight("Phone");
		assertEquals("Phone",s.getRight());
	}
	
	@Test
	public void leftTest() {
		Store s = new Store();
		s.setLeft("Phone");
		assertEquals("Phone",s.getLeft());
	}
	
	@Test
	public void setItemsTest() {
		ArrayList<Item> items = new ArrayList<Item>();
		Store s = new Store();
		Item i1 = new Item();
		Item i2 = new Item();
		items.add(i1);
		items.add(i2);
		s.setItems(items);
		assertEquals(items, s.getItems());
	}

}
