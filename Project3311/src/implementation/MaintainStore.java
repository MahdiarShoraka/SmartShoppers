package implementation;
import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainStore {
	
	public ArrayList<Store> stores = new ArrayList<Store>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Store store = new Store();
			
			store.setLocation(reader.get("Location"));
			store.setOpeningHour(Double.valueOf(reader.get("Opening")));
			store.setClosingHour(Double.valueOf(reader.get("Closing")));
			store.setUpper(reader.get("Upper"));
			store.setLower(reader.get("Lower"));
			store.setRight(reader.get("Right"));
			store.setLeft(reader.get("Left"));
			stores.add(store);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, true), ',');

//				csvOutput.write("FirstName");
//				csvOutput.write("LastName");
//		    	csvOutput.write("Address");
//				csvOutput.write("Email");
//				csvOutput.write("Password");
//				csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
				for(Store s : stores){
					csvOutput.write(s.getLocation());
					csvOutput.write(Double.toString(s.getOpeningHour()));
					csvOutput.write(Double.toString(s.getClosingHour()));
					csvOutput.write(s.getUpper());
					csvOutput.write(s.getLower());
					csvOutput.write(s.getRight());
					csvOutput.write(s.getLeft());
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

		csvOutput.write("Location");
		csvOutput.write("Opening");
    	csvOutput.write("Closing");
		csvOutput.write("Upper");
		csvOutput.write("Lower");
		csvOutput.write("Right");
		csvOutput.write("Left");
		csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
				for(Store s : stores){
					csvOutput.write(s.getLocation());
					csvOutput.write(Double.toString(s.getOpeningHour()));
					csvOutput.write(Double.toString(s.getClosingHour()));
					csvOutput.write(s.getUpper());
					csvOutput.write(s.getLower());
					csvOutput.write(s.getRight());
					csvOutput.write(s.getLeft());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	


}
