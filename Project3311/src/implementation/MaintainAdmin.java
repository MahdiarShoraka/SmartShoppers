package implementation;
import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainAdmin {
	public ArrayList<Admin> admins = new ArrayList<Admin>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Admin admin = new Admin();
			
			admin.setFirstName(reader.get("FirstName"));
			admin.setLastName(reader.get("LastName"));
			admin.setEmail(reader.get("Email"));
			admin.setPassword(reader.get("Password"));
			admins.add(admin);
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
				for(Admin a : admins){
					csvOutput.write(a.getFirstName());
					csvOutput.write(a.getLastName());
					csvOutput.write(a.getEmail());
					csvOutput.write(a.getPassword());
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
		csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
		for(Admin a : admins){
			csvOutput.write(a.getFirstName());
			csvOutput.write(a.getLastName());
			csvOutput.write(a.getEmail());
			csvOutput.write(a.getPassword());
			csvOutput.endRecord();
		}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}


}
