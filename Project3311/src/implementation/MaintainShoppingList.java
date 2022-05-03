package implementation;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;


public class MaintainShoppingList {
	
	public ArrayList<Item> items = new ArrayList<Item>();
	public ArrayList<User> users = new ArrayList<User>();
	public String path;
		
	public void load(String path) throws Exception {
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
			
		while(reader.readRecord()){ 
			Item item = new Item();
			item.setName(reader.get("Name"));
			item.setPrice(Double.valueOf(reader.get("Price")));
			items.add(item);
			
			User user = new User();
			user.setEmail(reader.get("Email"));
			user.setStore(reader.get("Store"));
			users.add(user);
		}
	}
		
	public void update(String path) throws Exception{
		try 
		{		
			CsvWriter csvOutput = new CsvWriter(new FileWriter(path, true), ',');
			

			// write out a few records
			for(int i=0; i<items.size(); i++)
			{
				
				csvOutput.write(items.get(i).getName());
				csvOutput.write(Double.toString(items.get(i).getPrice()));

				csvOutput.write(users.get(i).getEmail());
				csvOutput.write(users.get(i).getStore());
				
				csvOutput.endRecord();
			}
			csvOutput.close();
				
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
		
	public void update2(String path) throws Exception{
		try {		
			CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
			csvOutput.write("Name");
			csvOutput.write("Price");
	    	csvOutput.write("Email");
			csvOutput.write("Store");

			csvOutput.endRecord();

			// write out a few records
			for(int i=0; i<items.size(); i++)
			{
				
				csvOutput.write(items.get(i).getName());
				csvOutput.write(Double.toString(items.get(i).getPrice()));

				csvOutput.write(users.get(i).getEmail());
				csvOutput.write(users.get(i).getStore());
				
				csvOutput.endRecord();
			}
			csvOutput.close();
				
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
//	public static void main(String [] args) throws Exception{
//		String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\OrderList.csv";
//		MaintainShoppingList maintain = new MaintainShoppingList();
//	
//		maintain.load(path);
//		for(Item u: maintain.items)
//		{
//			System.out.println(u.getName());
//		}
//		User user = new User("M","A","123", "@", "1234", "Toronto");
//		Item item = new Item("iPad", "Tablet", 2000, 2, true, "...");
//		Item item2 = new Item("iPad Air", "Tablet", 1300,52, true, ".");
//		maintain.users.add(user);
//		maintain.items.add(item);
//		maintain.items.add(item2);
//		maintain.update(path);
//		
//
//	}
}
