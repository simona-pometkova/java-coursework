// This sets the available values of class Mouse's "mouseType" attribute
public enum MouseType {
	STANDARD,
	GAMING;
	
	public String toString() {
        return name().toLowerCase();
    }
}
