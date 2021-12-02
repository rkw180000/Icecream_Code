import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CreateUserBlackBoxFinal {
    /*
    valid:
        satisfies all the conditions & not in the system yet
        Username must be of length 8 and 20 or less
        Password must be of length 8 and 12
        Phone number length 10 and valid area code
        Valid email layout
    invalid:
        invalid email
        invalid phone number
        ids already in the system
        id length invalid
        id has special characters
        password length invalid
        retyped password does not match
        password does not have atleast one letter number or special char
        Boundary conditions:
        login length: 1, 3, 5, 6, 10, 16, 20, 25
        password length: 1, 3, 5, 6, 10, 20, 25
        retyped password: non-matching with the password entered

     */
    

    @Test
    void create_BC_LoginLength_TC1() {
        // loginID length 1
        assertEquals(CreateAccountFinalImplementation.create("e", "validPass1!", "validPass1!", "2144443332", "jjb@gmail.com"), "Login ID does not meet requirments");
    }
    @Test
    void create_BC_LoginLength_TC2() {
        // loginID length 21
        assertEquals(CreateAccountFinalImplementation.create("aeeahhhhddddjjjjkkkkee", "validPass1!", "validPass1!", "2144443332", "jjb@gmail.com"), "Login ID does not meet requirments");
    }
    @Test
    void create_BC_LoginLength_TC4a() {
        // loginID length 8
        assertEquals(CreateAccountFinalImplementation.create("eeeebbbb", "validPass1!", "validPass1!", "2144443332", "jjb@gmail.com"), "Account creation is Successful");
    }
    void create_BC_LoginLength_TC4b() {
        // loginID length 8 but has space in it
        assertEquals(CreateAccountFinalImplementation.create("eeee bbb", "validPass1!", "validPass1!", "2144443332", "jjb@gmail.com"), "Username has an invalid character");
    }
    void create_BC_LoginLength_TC4c() {
        // loginID length 8 but has & in it
        assertEquals(CreateAccountFinalImplementation.create("eee&bbbb", "validPass1!", "validPass1!", "2144443332", "jjb@gmail.com"), "Username has an invalid character");
    }
        
   //password length tests 1, 5, 8, 10, 25
    @Test
    void create_BC_PwdLength_TC1() {
        // pwd length 1
        assertEquals(CreateAccountFinalImplementation.create("axxxxxxxx", "x", "x" , "2144443332", "jjb@gmail.com"), "Password does not meet requirements");
    }
    @Test
    void create_BC_PwdLength_TC2() {
        // pwd length 5
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxx", "xxx1!", "xxx1!" , "2144443332", "jjb@gmail.com"), "Password does not meet requirements");
    }
   
    
    @Test
    void create_BC_PwdLength_TC3a() {
        // pwd length 8 but has invalid char in it
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxx/1!", "xxxxxxxx/1!" , "2144443332", "jjb@gmail.com"), "Password does not meet requirements");
    }
    @Test
    void create_BC_PwdLength_TC3b() {
        // pwd length 8 but has space char in it
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxx 1!", "xxxxxxxx 1!" , "2144443332", "jjb@gmail.com"), "Password does not meet requirements");
    }
    @Test
    void create_BC_PwdLength_TC3c() {
        // pwd length 8 but has no special char in it
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxxxx11", "xxxxxxxxx11" , "2144443332", "jjb@gmail.com"), "Password does not meet requirements");
    }
    @Test
    void create_BC_PwdLength_TC3d() {
        // pwd length 8 but has no letter char in it
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "111111**11", "111111**11" , "2144443332", "jjb@gmail.com"), "Password does not meet requirements");
    }
    @Test
    void create_BC_PwdLength_TC3e() {
        // pwd length 8 but has no number in it
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxxxxx!", "xxxxxxxxxx!", "2144443332", "jjb@gmail.com"), "Password does not meet requirements");
    }
    @Test
    void create_BC_PwdLength_TC4() {
        // pwd length 10
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "validPas1!", "validPas1!", "2144443332", "jjb@gmail.com"), "Account creation is Successful");
    }
    @Test
    void create_BC_PwdLength_TC5() {
        // pwd length 20
        assertEquals(CreateAccountFinalImplementation.create("a1@bc.com", "validPass1!xxxxxxxxx", "validPass1!xxxxxxxxx", "2144443332", "jjb@gmail.com"), "Password does not meet requirements");
    }
    
    @Test
    void create_BC_Retype_TC1() {
        // retyped pwd matches
        assertEquals(CreateAccountFinalImplementation.create("a1@bc.com", "validPass1!", "validPass1!", "2144443332", "jjb@gmail.com"), "Account creation is Successful");
    }
    @Test
    void create_BC_Retype_TC2() {
        // retyped pwd does not match
        assertEquals(CreateAccountFinalImplementation.create("a1@bc.com", "validPass1!", "validPas1!", "2144443332", "jjb@gmail.com"), "Retyped password does not match the password");
    }
    
    
    
    //phone number test case length 5, 10, 15
    //valid and invalid area code
    
    @Test
    void create_BC_NumberLen_TC1() {
        // phone number has length 5
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxxxx1!", "xxxxxxxxx1!", "23332", "jjb@gmail.com"), "Invalid Phone Number");
    }
    @Test
    void create_BC_NumberLen_TC2a() {
        // phone number has length 10
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxxxx1!", "xxxxxxxxx1!", "2143333342", "jjb@gmail.com"), "Account creation is Successful");
    }
    @Test
    void create_BC_NumberLen_TC2b() {
        // phone number has length 10 but invalid area code
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxxxx1!", "xxxxxxxxx1!", "4443333342", "jjb@gmail.com"), "Invalid Phone Number");
    }
    @Test
    void create_BC_NumberLen_TC3() {
        // phone number has length 15
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxxxx1!", "xxxxxxxxx1!", "214333334233333", "jjb@gmail.com"), "Invalid Phone Number");
    }
    //email test cases invalid char in email, correct and incorrect form
    
    @Test
    void create_BC_Email_TC1a() {
        // email has valid layout
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxxxx1!", "xxxxxxxxx1!", "2143333342", "jjb@gmail.com"), "Account creation is Successful");
    }
    void create_BC_Email_TC1b() {
        // email has valid layout but invalid char
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxxxx1!", "xxxxxxxxx1!", "2143333342", "jjb@gma/il.com"), "Invalid Email Address");
    }
    @Test
    void create_BC_Email_TC2() {
        // email has invalid layout
        assertEquals(CreateAccountFinalImplementation.create("xxxxxxxxxx", "xxxxxxxxx1!", "xxxxxxxxx1!", "2143333342", "@jjgmail.com"), "Invalid Email Address");
    }
    
   


}

