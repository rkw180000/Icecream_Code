import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class flavorDatabaseBlackBox {
	
	/* Administrator adds ice-cream flavors
	 * Valid:
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
	
	 /* old ice-cream flavor name is "Vanilla"
	  * old ice-cream description is "Sweet ice-cream" */
	
	@Test
	void flavorDatabase_TC1() {
		// User is an admin and the changed data is within the limit
		assertEquals(flavorDataImplement.change("xxxxxxxxxx", "Yyyyyy@13", "Dark", 5.00, "Sweet dark chocolate ice-cream"),"New flavor has been added");
	}
	
	@Test
	void flavorDatabase_TC2() {
		// Username is not valid
		assertEquals(flavorDataImplement.change("ahdbcgdusj", "Yyyyyy@13", "Dark", 5.00, "Sweet dark chocolate ice-cream"),"Invalid Username and/or Password");
	}
	
	@Test
	void flavorDatabase_TC3() {
		// Password is not valid
		assertEquals(flavorDataImplement.change("xxxxxxxxxx", "hjsdhjbdc83", "Dark", 5.00, "Sweet dark chocolate ice-cream"),"Invalid Username and/or Password");
	}
	
	// Problems with ice-cream flavor name
	@Test
	void flavorDatabase_TC4a() {
		// User is an admin but name is length 0
		assertEquals(flavorDataImplement.change("xxxxxxxxxx", "Yyyyyy@13", "", 5.00, "Sweet dark chocolate ice-cream"),"Type in an ice-cream flavor name");
	}
	@Test
	void flavorDatabase_TC4b() {
		// User is an admin but name length is above the limit
		assertEquals(flavorDataImplement.change("xxxxxxxxxx", "Yyyyyy@13", "ksdjncksjncksjncskjdncjsncsnk", 5.00, "Sweet dark chocolate ice-cream"),"Type in ice-cream flavor name again");
	}
	@Test
	void flavorDatabase_TC4c() {
		// User is an admin but name already exists
		assertEquals(flavorDataImplement.change("xxxxxxxxxx", "Yyyyyy@13", "Vanilla", 5.00, "Sweet dark chocolate ice-cream"),"Ice-cream flavor name already exists");
	}
	
	// Problems with ice-cream flavor price
	@Test
	void flavorDatabase_TC5a() {
		// User is an admin but price is negative
		assertEquals(flavorDataImplement.change("xxxxxxxxxx", "Yyyyyy@13", "Dark", -2.00, "Sweet dark chocolate ice-cream"),"Price is not valid");
	}
	@Test
	void flavorDatabase_TC5b() {
		// User is an admin but price is 0
		assertEquals(flavorDataImplement.change("xxxxxxxxxx", "Yyyyyy@13", "Dark", 0.00, "Sweet dark chocolate ice-cream"),"Price is not valid");
	}
	@Test
	void flavorDatabase_TC5c() {
		// User is an admin but price is above the limit
		assertEquals(flavorDataImplement.change("xxxxxxxxxx", "Yyyyyy@13", "Dark", 12.00, "Sweet dark chocolate ice-cream"),"Price is too high");
	}
	
	@Test
	void flavorDatabase_TC6() {
		// User is an admin but description already exists
		assertEquals(flavorDataImplement.change("xxxxxxxxxx", "Yyyyyy@13", "Dark", 5.00, "Sweet ice-cream"),"Description already exists");
	}
}