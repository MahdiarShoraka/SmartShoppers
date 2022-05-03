package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.*;


import implementation.Item;

public class ItemTest {
	
	@Test
	public void itemTest() {
		Item i = new Item();
		assertNotNull(i);
	}
	
	@Test
	public void getNameTest() {
		Item i = new Item("iPad", "Tablet", 1000, 5, false, "nothing");
		assertEquals("iPad",i.getName());
	}
	
	@Test
	public void getCategoryTest() {
		Item i = new Item("iPad", "Tablet", 1000, 5, false, "nothing");
		assertEquals("Tablet",i.getCategory());
	}
	
	@Test
	public void getPriceTest() {
		Item i = new Item("iPad", "Tablet", 1000, 5, false, "nothing");
		assertEquals(1000, i.getPrice(),0.0001);
	}
	
	@Test
	public void getAmountTest() {
		Item i = new Item("iPad", "Tablet", 1000, 5, false, "nothing");
		assertEquals(5, i.getAmount());
	}
	
	@Test
	public void getSaleTest() {
		Item i = new Item("iPad", "Tablet", 1000, 5, false, "nothing");
		assertFalse(i.getSale());
	}
	
	@Test
	public void getDescTest() {
		Item i = new Item("iPad", "Tablet", 1000, 5, false, "nothing");
		assertEquals("nothing",i.getDesc());
	}
	
	@Test
	public void setNameTest() {
		Item i = new Item();
		i.setName("iPad");
		assertEquals("iPad",i.getName());
	}
	
	@Test
	public void setCategoryTest() {
		Item i = new Item();
		i.setCategory("Tablet");
		assertEquals("Tablet",i.getCategory());
	}
	
	@Test
	public void setPriceTest() {
		Item i = new Item();
		i.setPrice(1000);
		assertEquals(1000,i.getPrice(),0.0001);
	}
	
	@Test
	public void setAmountTest() {
		Item i = new Item();
		i.setAmount(5);
		assertEquals(5,i.getAmount());
	}
	
	@Test
	public void setSaleTest() {
		Item i = new Item();
		i.setSale(false);
		assertFalse(i.getSale());
	}
	
	@Test
	public void setDescTest() {
		Item i = new Item();
		i.setDesc("nothing");
		assertEquals("nothing",i.getDesc());
	}

}
