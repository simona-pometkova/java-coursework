/* Abstract Use class. Specifies the common attributes
 * between Customer and Admin classes, as well as the abstract
 * method toString(), further defined in each child class.
 */
public abstract class User {
	private int userID;
	private String username, surname;
	private Address address;
	
	//Constructor
	public User(int userID, 
				String username, 
				String surname, 
				Address address) {
		this.userID = userID;
		this.username = username;
		this.surname = surname;
		this.address = address;
	}
	public int getID() {
		return this.userID;
	}
	public String getUsername() {
		return this.username;
	}
	public String getSurname() {
		return this.surname;
	}
	public Address getAddress() {
		return this.address;
	}
	//Abstract method
	public abstract String toString();
}
