/* This is used to create a credit card object, which
 * the user then uses to pay for the items in their
 * basket.
 */
public class CreditCard {
	private long cardNumber;
	private int securityCode;
	
	//Constructor
	public CreditCard (long cardNumber, int securityCode) {
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
	}
	public long getCardNumber() {
		return this.cardNumber;
	}
	public int getSecurityCode() {
		return this.securityCode;
	}
	//Verifies the length of the credit card number; must be 16 digits
	public static boolean verifyNumber(CreditCard card) {
		int numLength = String.valueOf(card.getCardNumber()).length();
		if (numLength == 16) {
			return true;
		} else {
			return false;
		}
	}
	//Verifies the length of the credit card security code; must be 3 digits
	public static boolean verifyCode(CreditCard card) {
		int codeLength = String.valueOf(card.getSecurityCode()).length();
		if (codeLength == 3) {
			return true;
		} else {
			return false;
		}
	}
}
