package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import  org.junit.*;

import implementation.MaintainItem;
import implementation.Item;

public class MaintainitemTest {
	
	@Test
	public void testLoad() {
		MaintainItem mi = new MaintainItem();
		ArrayList<Item> i = new ArrayList<Item>();
		
		try {
			mi.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\itemTest1.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		i.add(new Item("iPhone 13", "Phone", 1500, 3, false, "!"));
		
		assertEquals(i.get(0).getCategory(), mi.items.get(0).getCategory());
	}
	
	@Test
	public void testUpdate() {
		MaintainItem mi = new MaintainItem();
		Item item = new Item("iPhone 13", "Phone", 1500, 3, false, "!");
		mi.items.add(item);
		try {
			mi.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\itemTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mi.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\itemTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(item.getName(), mi.items.get(mi.items.size()-1).getName());
	}
	
	@Test
	public void testUpdate2() {
		MaintainItem mi = new MaintainItem();
		Item item = new Item("iPhone 13", "Phone", 1500, 3, false, "!");
		mi.items.add(item);
		try {
			mi.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\itemTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mi.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\itemTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(item.getName(), mi.items.get(mi.items.size()-1).getName());
	}

}
