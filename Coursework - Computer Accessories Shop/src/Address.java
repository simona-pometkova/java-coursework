/* This class is used to create the address of the user.
 * The address consists of a house number, postcode and city.
 */
public class Address {
	private int houseNum;
	private String postcode, city;
	
	//Constructor
	public Address(int houseNum, String postcode, String city) {
		this.houseNum = houseNum;
		this.postcode = postcode;
		this.city = city;
	}
	public int getHouseNum() {
		return this.houseNum;
	}
	public String getPostcode() {
		return this.postcode;
	}
	public String getCity() {
		return this.city;
	}
	public String toString() {
		return (+getHouseNum()+", "+getPostcode()+", "+getCity());
	}
	public static Address parse(int num, String s1, String s2) {
		//This method is used to parse the address string from ActivityLog.txt into an Address object.
		Address address = new Address (num, s1, s2);
		return address;
	}
}
