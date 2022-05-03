package implementation;
import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainUser {
	public ArrayList<User> users = new ArrayList<User>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user = new User();
			
			user.setFirstName(reader.get("FirstName"));
			user.setLastName(reader.get("LastName"));
			user.setAddress(reader.get("Address"));
			user.setEmail(reader.get("Email"));
			user.setPassword(reader.get("Password"));
			user.setStore(reader.get("Pref Store"));
			users.add(user);
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
				for(User u: users){
					csvOutput.write(u.getFirstName());
					csvOutput.write(u.getLastName());
					csvOutput.write(u.getAddress());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(u.getStore());
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
    	csvOutput.write("Address");
		csvOutput.write("Email");
		csvOutput.write("Password");
		csvOutput.write("Pref Store");
		csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: users){
					csvOutput.write(u.getFirstName());
					csvOutput.write(u.getLastName());
					csvOutput.write(u.getAddress());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(u.getStore());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	


}
