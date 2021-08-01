// This sets the available values of class Keyboard's "keyboardType" attribute
public enum KeyboardType {
	STANDARD,
	GAMING,
	INTERNET,
	FLEXIBLE;
	
	public String toString() {
        return name().toLowerCase();
    }
}
