package test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import  org.junit.*;
import implementation.MaintainItem;
import implementation.MaintainShoppingList;
import implementation.User;
import implementation.Item;


public class MaintainShoppingListTest {
	
	@Test 
	public void testLoad() {
		MaintainShoppingList ms = new MaintainShoppingList();
		 ArrayList<Item> items = new ArrayList<Item>();
		 ArrayList<User> users = new ArrayList<User>();
		 
		 try {
			ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\shoppingListTest1.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 items.add(new Item("iPhone 13", "Phone", 1500, 3, false, "!"));
		 users.add(new User("Willy", "Rock", "123 St", "r@gmail.com", "1234", "Toronto"));
		 
		 assertEquals(items.get(0).getName(), ms.items.get(0).getName());
	}
	
	@Test
	public void testUpdate() {
		MaintainShoppingList ms = new MaintainShoppingList();
		Item i = new Item("iPhone 13", "Phone", 1500, 3, false, "!");
		User u = new User("Willy", "Rock", "123 St", "r@gmail.com", "1234", "Toronto");
		ms.items.add(i);
		ms.users.add(u);
		
		try {
			ms.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\shoppingListTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\shoppingListTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(i.getName(), ms.items.get(ms.items.size()-1).getName());
		assertEquals(u.getEmail(), ms.users.get(ms.users.size()-1).getEmail());
	}
	
	@Test
	public void testUpdate2() {
		MaintainShoppingList ms = new MaintainShoppingList();
		Item i = new Item("iPhone 13", "Phone", 1500, 3, false, "!");
		User u = new User("Willy", "Rock", "123 St", "r@gmail.com", "1234", "Toronto");
		ms.items.add(i);
		ms.users.add(u);
		
		try {
			ms.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\shoppingListTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\shoppingListTest2.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(i.getName(), ms.items.get(ms.items.size()-1).getName());
		assertEquals(u.getEmail(), ms.users.get(ms.users.size()-1).getEmail());
	}

}
