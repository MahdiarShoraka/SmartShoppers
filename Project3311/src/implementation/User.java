package implementation;

public class User {

	public String firstName;
	public String lastName;
	public String address;
	public String email;
	public String password;
	public String store;
	
	public User(String firstName,String lastName,String address, String email, String password, String store) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.password = password;
		this.store = store;
	}
	
	public User()
	{
		super();
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setStore(String store) {
		this.store = store;
	}
	
	public String getStore() {
		return store;
	}
}

