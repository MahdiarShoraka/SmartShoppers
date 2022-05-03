package implementation;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;


public class MaintainItem {
	
	public ArrayList<Item> items = new ArrayList<Item>();
	public String path;
		
	public void load(String path) throws Exception {
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
			
		while(reader.readRecord()){ 
			Item item = new Item();
			item.setName(reader.get("Name"));
			item.setCategory(reader.get("Category"));
			item.setPrice(Double.valueOf(reader.get("Price")));
			item.setAmount(Integer.valueOf(reader.get("Amount")));
			item.setSale(Boolean.valueOf(reader.get("Sale")));
			item.setDesc(reader.get("Description"));
			items.add(item);
		}
	}
		
	public void update(String path) throws Exception{
		try 
		{		
			CsvWriter csvOutput = new CsvWriter(new FileWriter(path, true), ',');

		// write out a few records
			for(Item item: items)
			{
				csvOutput.write(item.getName());
				csvOutput.write(item.getCategory());
				csvOutput.write(Double.toString(item.getPrice()));
				csvOutput.write(Integer.toString(item.getAmount()));
				csvOutput.write(Boolean.toString(item.getSale()));
				csvOutput.write(item.getDesc());

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
			csvOutput.write("Category");
	    	csvOutput.write("Price");
			csvOutput.write("Amount");
			csvOutput.write("Sale");
			csvOutput.write("Description");

			csvOutput.endRecord();
					
			for(Item item: items)
			{
				csvOutput.write(item.getName());
				csvOutput.write(item.getCategory());
				csvOutput.write(Double.toString(item.getPrice()));
				csvOutput.write(Integer.toString(item.getAmount()));
				csvOutput.write(Boolean.toString(item.getSale()));
				csvOutput.write(item.getDesc());

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
//		String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
//		MaintainItem maintain = new MaintainItem();
//	
//		maintain.load(path);
//		for(Item u: maintain.items){
//			System.out.println(u.getSale());
//		}
//		Item item = new Item("Samsung Galaxy Note 10", "Phone", 1700,3,true);
//		maintain.items.add(item);
//		maintain.update2(path);
//
//	}
}
