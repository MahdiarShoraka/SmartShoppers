package implementation;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainManager {

		public ArrayList<Manager> managers = new ArrayList<Manager>();
		public String path;
		
		public void load(String path) throws Exception{
			CsvReader reader = new CsvReader(path); 
			reader.readHeaders();
			
			while(reader.readRecord()){ 
				Manager manager = new Manager();
				
				manager.setFirstName(reader.get("FirstName"));
				manager.setLastName(reader.get("LastName"));
				manager.setEmail(reader.get("Email"));
				manager.setPassword(reader.get("Password"));
				String location = reader.get("Store");
				
				Store store = new Store();
				store.setLocation(location);
				MaintainItem mi = new MaintainItem();
				if(location.equals("Toronto"))
				{
					mi.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv");
					store.setItems(mi.items);
				}
				else if(location.equals("Vaughan"))
				{
					mi.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv");
					store.setItems(mi.items);
				}
				else if(location.equals("New Market"))
				{
					mi.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv");
					store.setItems(mi.items);
				}
				else if(location.equals("North York"))
				{
					mi.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv");
					store.setItems(mi.items);
				}
				manager.setStore(store);
				managers.add(manager);
			}
		}
		
		public void update(String path) throws Exception{
			try {		
					CsvWriter csvOutput = new CsvWriter(new FileWriter(path, true), ',');

//					csvOutput.write("FirstName");
//					csvOutput.write("LastName");
//			    	csvOutput.write("Address");
//					csvOutput.write("Email");
//					csvOutput.write("Password");
//					csvOutput.endRecord();
					
					// else assume that the file already has the correct header line
					// write out a few records
					for(Manager m : managers){
						csvOutput.write(m.getFirstName());
						csvOutput.write(m.getLastName());
						csvOutput.write(m.getEmail());
						csvOutput.write(m.getPassword());
						csvOutput.write(m.getStore().getLocation());
						csvOutput.endRecord();
					}
					csvOutput.close();
				
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		public void update2(String path) throws Exception{
			try {		
					CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');

			csvOutput.write("FirstName");
			csvOutput.write("LastName");
			csvOutput.write("Email");
			csvOutput.write("Password");
			csvOutput.write("Store");
			csvOutput.endRecord();
					
					// else assume that the file already has the correct header line
					// write out a few records
			for(Manager m : managers){
				csvOutput.write(m.getFirstName());
				csvOutput.write(m.getLastName());
				csvOutput.write(m.getEmail());
				csvOutput.write(m.getPassword());
				csvOutput.write(m.getStore().getLocation());
				csvOutput.endRecord();
			}
					csvOutput.close();
				
				}catch (Exception e) {
					e.printStackTrace();
				}
		}


}
