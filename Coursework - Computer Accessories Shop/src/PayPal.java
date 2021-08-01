/* This is used to create a PayPal object, which
 * the user then uses to pay for the items in their
 * basket.
 */
public class PayPal {
	private String email;
	
	//Constructor
	public PayPal (String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	// Verifies that the email is valid. It must contain "@".
	public static boolean verifyEmail(PayPal pp) {
		if (pp.getEmail().indexOf("@") != -1) {
			return true;
		} else {
			return false;
		}
	}
}
