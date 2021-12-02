/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author ejb23
 */
public class DeleteAccountBlackBox {
     /*
    valid:
        account does exist
        confirmation processed
    invalid:
       account cannot be found
        deletion cancelled

     */
    

    @Test
    void create_BC_DelAcc_TC1() {
        // user selects delete and confirm on a valid account
        assertEquals(DeleteAccImplementation.delete("grefw", "yes"), "Account found and deleted.");
    }

    @Test
    void create_BC_DelAcc_TC2() {
        // user selects delete but exception occurs and account cannot be found
        assertEquals(DeleteAccImplementation.delete("bad_acc", "yes"), "Account cannot be found and cannot be deleted, exiting");
    }
    
    @Test
    void create_BC_DelAcc_TC3() {
        // user selects delete but cancels the delete 
        assertEquals(DeleteAccImplementation.delete("grefw", "no"), "Account was not deleted");
    }
}
