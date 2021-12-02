/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogInBlackBox {
    /*
    valid:
        username exists in system database
        password matches existing username in system
    invalid:
        username does not exist in system
        password is incorrect for username

     */
    

    @Test
    void create_BC_LoginAcc_TC1() {
        // login info is valid and account exists
        assertEquals(loginImplementation.login("xxxxbbbba", "validPass1"), "Successful login");
    }
    @Test
    void create_BC_LoginAcc_TC2() {
        // username is not in system with correct password
        assertEquals(loginImplementation.login("newAccount", "validPass1"), "Account does not exist");
    }
    @Test
    void create_BC_LoginAcc_TC3() {
        // username exists and is valid but incorrect password
        assertEquals(loginImplementation.login("xxxxbbbba", "falsePass1"), "Failed to log into account");
    }
    @Test
    void create_BC_LoginAcc_TC4() {
        // username exists invalid password, reset pass
        assertEquals(loginImplementation.login("xxxxbbbba", "invalidPass1"), "Failed to log into account");
    }
    @Test
    void create_BC_LoginAcc_TC5() {
        // forgot username
        assertEquals(loginImplementation.login("", "validPass1"), "Enter the email attached to your account");
    }
    
}
