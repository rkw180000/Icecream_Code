import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MakePaymentTest {
	
	/*
    valid:
    The card passes Luhn algorithm,
    CVV and other identifiying values are valid
    Delivery address is valid
    invalid:
    If any of the fields are empty
    
    */
	
		//Testing Make Payment Use Case
			@Test
		    void makePayment_TC1() {
		        // All values are valid
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "FullCorrectAddress", "4111111111111111", 0122, 123, "ValidDeliveryAddress"), "The payment has been verified");
		    }

			@Test
		    void makePayment_TC2() {
		        // Card does not pass Luhn Algorithm
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "FullCorrectAddress", "1111111111111111", 0122, 123, "ValidDeliveryAddress"), "Please re-enter the billing information");
		    }
			
			@Test
		    void makePayment_TC3() {
		        // card number is empty
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "FullCorrectAddress", "", 0122, 123, "ValidDeliveryAddress"), "Please enter all of the fields");
		    }
			
			@Test
		    void makePayment_TC4() {
		        // First name is incorrect
				assertEquals(MakePayment.checkCardValidity("WrongFName", "LName", "FullCorrectAddress", "4111111111111111", 0122, 123, "ValidDeliveryAddress"), "Please re-enter the billing information");
		    }
			
			@Test
		    void makePayment_TC5() {
		        // First name is empty
				assertEquals(MakePayment.checkCardValidity("", "LName", "FullCorrectAddress", "4111111111111111", 0122, 123, "ValidDeliveryAddress"), "Please enter all of the fields");
		    }
			
			@Test
		    void makePayment_TC6() {
		        // Last name is incorrect
				assertEquals(MakePayment.checkCardValidity("FName", "WrongLName", "FullCorrectAddress", "4111111111111111", 0122, 123, "ValidDeliveryAddress"), "Please re-enter the billing information");
		    }
			
			@Test
		    void makePayment_TC7() {
		        // Last name is empty
				assertEquals(MakePayment.checkCardValidity("FName", "", "FullCorrectAddress", "4111111111111111", 0122, 123, "ValidDeliveryAddress"), "Please enter all of the fields");
		    }
			
			@Test
		    void makePayment_TC8() {
		        // Address is incorrect
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "IncorrectAddress", "4111111111111111", 0122, 123, "ValidDeliveryAddress"), "Please re-enter the billing information");
		    }
			
			@Test
		    void makePayment_TC9() {
		        // Address is empty
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "", "4111111111111111", 0122, 123, "ValidDeliveryAddress"), "Please enter all of the fields");
		    }
			
			@Test
		    void makePayment_TC10() {
		        // expiration date is incorrect
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "FullCorrectAddress", "4111111111111111", 1111, 123, "ValidDeliveryAddress"), "Please re-enter the billing information");
		    }
			
			@Test
		    void makePayment_TC11() {
		        // expiration date is empty
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "FullCorrectAddress", "4111111111111111", null , 123, "ValidDeliveryAddress"), "Please enter all of the fields");
		    }
			
			
			@Test
		    void makePayment_TC12() {
		        // CCV is incorrect
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "FullCorrectAddress", "4111111111111111", 0122, 111, "ValidDeliveryAddress"), "Please re-enter the billing information");
		    }
			
			@Test
		    void makePayment_TC13() {
		        // CCV is empty
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "FullCorrectAddress", "4111111111111111", 0122, null , "ValidDeliveryAddress"), "Please enter all of the fields");
		    }
			
			
			@Test
		    void makePayment_TC14() {
		        // delivery address is incorrect
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "FullCorrectAddress", "4111111111111111", 0122, 123, "InvalidDeliveryAddress"), "Please re-enter the billing information");
		    }
			
			@Test
		    void makePayment_TC15() {
		        // delivery address is empty
				assertEquals(MakePayment.checkCardValidity("FName", "LName", "FullCorrectAddress", "4111111111111111", 0122, 123 , ""), "Please enter all of the fields");
		    }
}
