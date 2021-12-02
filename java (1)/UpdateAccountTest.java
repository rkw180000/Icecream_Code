import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateAccountTest {
	
	/*
    valid:
        satisfies all the conditions & not in the system yet
        Username must be of length 8 to 20 
        Password must be of length 8 and 12
        Phone number length 10 and valid area code
        Valid email layout
        All fields may match the already existing values
    invalid:
        invalid email
        invalid phone number
        username already in the system unless it is the preexisting username
        username length invalid
        username has special characters
        password length invalid
        retyped password does not match
        password does not have atleast one letter number or special char
        Boundary conditions:
        username length: 1, 3, 5, 6, 10, 16, 20, 25
        password length: 1, 3, 5, 6, 10, 20, 25
        retyped password: non-matching with the password entered

     */
	
	//Testing Update Account information Use Case
		@Test
	    void updateAccount_TC1() {
	        // All values are valid
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The account information has been updated");
	    }
		
		@Test
	    void updateAccount_TC2() {
	        // new email is invalid
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("asd", "4694567890", "username", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The email entered is not valid");   	  
	    }
		
		@Test
	    void updateAccount_TC3() {
	        // new phone number is invalid
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "469456", "username", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The phone number entered is not valid");   	  
	    }		
		
		@Test
	    void updateAccount_TC4() {
	        // new username matches a username of another account
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");   	// This is the current account
			CreateNewAcc.create("bbbbeeee", "validPass2", "validPass2", "2144441234", "abc@gmail.com");		// This is a seperate unrelated account 
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "bbbbeeee", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The username entered is already in use");
	    
		}
		
		@Test
	    void updateAccount_TC5() {
	        // new username has special characters
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username!+", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The username entered is not valid");
		}
		
		@Test
	    void updateAccount_TC6() {
	        // Retyped password does not match
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "dshui!HSG2", "WrongPass", Account.CurrUser), "The retyped password does not match");
	    }
		
		@Test
	    void updateAccount_TC7() {
	        // Password does not have a special character or a number
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "dshuiHSG", "dshuiHSG", Account.CurrUser), "The password does not meet the requirements");
	    }
		
		@Test
	    void updateAccount_TC8() {
	        // Username length 1
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "x", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The username does not meet length requirements");
	    }

		@Test
	    void updateAccount_TC9() {
	        // Username length 3
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "xxx", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The username does not meet length requirements");
	    }

		@Test
	    void updateAccount_TC10() {
	        // Username length 5
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "xxxxx", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The username does not meet length requirements");
	    }

		@Test
	    void updateAccount_TC11() {
	        // Username length 6
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "xxxxxx", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The username does not meet length requirements");
	    }
		
		@Test
	    void updateAccount_TC12() {
	        // Username length 10
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "xxxxxxxxxx", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The account information has been updated");
	    }
		
		@Test
	    void updateAccount_TC13() {
	        // Username length 16
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "xxxxxxxxxxxxxxxx", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The account information has been updated");
	    }

		@Test
	    void updateAccount_TC14() {
	        // Username length 20
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "xxxxxxxxxxxxxxxxxxxx", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The account information has been updated");
	    }
		
		@Test
	    void updateAccount_TC15() {
	        // Username length 25
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "xxxxxxxxxxxxxxxxxxxxx", "dshui!HSG2", "dshui!HSG2", Account.CurrUser), "The username does not meet length requirements");
	    }
		
		@Test
	    void updateAccount_TC16() {
	        // Password length 1
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "1", "1", Account.CurrUser), "The password does not meet length requirements");
	    }

		@Test
	    void updateAccount_TC17() {
	        // Password length 3
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "1xx", "1xx", Account.CurrUser), "The password does not meet length requirements");
	    }

		@Test
	    void updateAccount_TC18() {
	        // Password length 5
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "1xxxx", "1xxxx", Account.CurrUser), "The password does not meet length requirements");
	    }

		@Test
	    void updateAccount_TC19() {
	        // Password length 6
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "1xxxxx", "1xxxxx", Account.CurrUser), "The password does not meet length requirements");
	    }
		
		@Test
	    void updateAccount_TC20() {
	        // Password length 10
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "1xxxxxxxxx", "1xxxxxxxxx", Account.CurrUser), "The account information has been updated");
	    }
		

		@Test
	    void updateAccount_TC21() {
	        // Password length 20
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "1xxxxxxxxxxxxxxxxxxx", "1xxxxxxxxxxxxxxxxxxx", Account.CurrUser), "The password does not meet length requirements");
	    }
		
		@Test
	    void updateAccount_TC22() {
	        // Password length 25
			CreateNewAcc.create("eeeebbbb", "validPass1", "validPass1", "2144443332", "jjb@gmail.com");
	        assertEquals(UpdateAccount.update("wky@gmail.com", "4694567890", "username", "1xxxxxxxxxxxxxxxxxxxxxxxx", "1xxxxxxxxxxxxxxxxxxxxxxxx", Account.CurrUser), "The password does not meet length requirements");
	    }
}
		

