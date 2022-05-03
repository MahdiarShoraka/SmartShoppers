package test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import  org.junit.*;

import implementation.Item;
import implementation.MaintainStore;
import implementation.Store;
public class MaintainStoreTest {

	@Test
	public void testLoad() {
		MaintainStore ms = new MaintainStore();
		ArrayList<Store> s = new ArrayList<Store>();
		
		s.add(new Store("Toronto", null, 8, 15, "Phone", "Tablet", "Laptop", "Phone"));
		
		try {
			ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\storeTest1.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(s.get(0).getUpper(), ms.stores.get(0).getUpper());
	}
	
	@Test
	public void testUpdate() {
		MaintainStore ms = new MaintainStore();
		Store store = new Store("Toronto", null, 8, 15, "Phone", "Tablet", "Laptop", "Phone");
		ms.stores.add(store);
		
		try {
			ms.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\storeTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\storeTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(store.getUpper(), ms.stores.get(ms.stores.size()-1).getUpper());
	}
	
	@Test
	public void testUpdate2() {
		MaintainStore ms = new MaintainStore();
		Store store = new Store("Toronto", null, 8, 15, "Phone", "Tablet", "Laptop", "Phone");
		ms.stores.add(store);
		
		try {
			ms.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\storeTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\storeTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(store.getUpper(), ms.stores.get(ms.stores.size()-1).getUpper());
	}

}
