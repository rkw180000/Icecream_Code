import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SaveCartTest {
	
	/*
    valid:
    Array contains at least 1 item, where each item does not exceed 25 copies and the minimum is 1.
    invalid:
    An empty array
    Any item with 0 or less copies bought
    
    Boundry conditions
    -1, 0, 1, 20, 24, 25, 26, 30
    */
	
	//Testing Save Cart Information Use Case
			@Test
		    void saveCart_TC1() {
		        // All values are valid
				String [][] Cart = { { "Strawberry", "1" }, { "Vanilla", "2"}};
		        assertEquals(SaveCart.checkCartValidity(Cart), "The cart has been updated");
		    }
			
			@Test
		    void saveCart_TC2() {
		        // The Cart is empty
				String [][] Cart = {};
		        assertEquals(SaveCart.checkCartValidity(Cart), "Please enter items into the cart");
		    }
			
			@Test
		    void saveCart_TC3() {
				// Cart item amount = -1 
				String [][] Cart = { { "Strawberry", "-1" }};
		        assertEquals(SaveCart.checkCartValidity(Cart), "Error, invalid value, please re-enter cart items");
		    }

			@Test
		    void saveCart_TC4() {
		        // Cart item amount = 0
				String [][] Cart = { { "Strawberry", "0" }};
		        assertEquals(SaveCart.checkCartValidity(Cart), "Error, invalid value, please re-enter cart items");
		    }
			
			@Test
		    void saveCart_TC5() {
		        // Cart item amount = 1
				String [][] Cart = { { "Strawberry", "1" }};
		        assertEquals(SaveCart.checkCartValidity(Cart), "The cart has been updated");
		    }
			
			@Test
		    void saveCart_TC6() {
		        // Cart item amount = 20
				String [][] Cart = { { "Strawberry", "20" }};
		        assertEquals(SaveCart.checkCartValidity(Cart), "The cart has been updated");
		    }
			
			@Test
		    void saveCart_TC7() {
		        // Cart item amount = 24
				String [][] Cart = { { "Strawberry", "24" }};
		        assertEquals(SaveCart.checkCartValidity(Cart), "The cart has been updated");
		    }
			
			@Test
		    void saveCart_TC8() {
		        // Cart item amount = 25
				String [][] Cart = { { "Strawberry", "25" }};
		        assertEquals(SaveCart.checkCartValidity(Cart), "The cart has been updated");
		    }
			
			@Test
		    void saveCart_TC9() {
		        // Cart item amount = 26
				String [][] Cart = { { "Strawberry", "26" }};
		        assertEquals(SaveCart.checkCartValidity(Cart), "Item purchasing amount excedes limits");
		    }
			
			@Test
		    void saveCart_TC10() {
		        // Cart item amount = 30
				String [][] Cart = { { "Strawberry", "30" }};
		        assertEquals(SaveCart.checkCartValidity(Cart), "Item purchasing amount excedes limits");
		    }
}
