import junit.framework.*;

public class flavorDataImplement {
	/* Valid:
	 * 		Username exists in database
	 * 		Password is the correct one associated with the username
	 * 		The user is an administrator
	 * 		Name is of length between 1 and 15
	 * 		Price is between 0.01 and 10.00
	 * Invalid:
	 * 		Username does not exist in database
	 * 		Password is not correct
	 * 		User is not an administrator
	 * 		Name is less than 1 length or greater than 20 length
	 * 		Price is less than 0.01 or more than 10.00
	 * 		New ice-cream flavor name already exists
	 * 		New ice-cream description already exists */
	
	public static final int MIN_LENGTH_NAME = 1;
	public static final int MAX_LENGTH_NAME = 20;
	public static final double MIN_LENGTH_PRICE = 0.01;
	public static final double MAX_LENGTH_PRICE = 10.00;
	
	public static String adminUsername = "xxxxxxxxxx";
	public static String adminPassword = "Yyyyyy@13";
	public static String[] flavorName = {"Vanilla", "Chocolate", "Cookies N' Cream"};
	public static String[] flavorDescription = {"Sweet ice-cream", "Chocolate flavored, sweet", "Ice-cream with bits of Cookies"};
    
	public static String change(String u, String p, String name, double price, String description) {
		if(!(u.equalsIgnoreCase(adminUsername)))
			return "Invalid Username and/or Password";
		
		if(!(p.equals(adminPassword)))
			return "Invalid Username and/or Password";
		
		if(name.length() < MIN_LENGTH_NAME)
			return "Type in an ice-cream flavor name";
		
		if(name.length() > MAX_LENGTH_NAME)
			return "Type in ice-cream flavor name again";
		
		for(String n : flavorName) {
			if(name.equalsIgnoreCase(n)) {
				return "Ice-cream flavor name already exists";
			}
		}
		
		if(price < MIN_LENGTH_PRICE)
			return "Price is not valid";
		
		if(price > MAX_LENGTH_PRICE)
			return "Price is too high";
		
		for(String d : flavorDescription) {
			if(description.equalsIgnoreCase(d)) {
				return "Description already exists";
			}
		}
		
		return "New flavor has been added";
	}
	
}