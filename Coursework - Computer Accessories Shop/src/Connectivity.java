// This sets the available values of class Product's "connectivity" attribute.
public enum Connectivity {
	WIRED,
	WIRELESS;
	
	public String toString() {
        return name().toLowerCase();
    }
}
