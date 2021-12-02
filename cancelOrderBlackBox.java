import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class cancelOrderBlackBlock {
	
	/* Valid:
	 * 		Username exists in database
	 * 		Password is the correct one associated with the username
	 * 		Order has not been started yet
	 * Invalid:
	 * 		Username does not exist in database
	 * 		Password is not correct
	 * 		Order has been started on or completed*/
	
    @Test
    void cancelOrder_TC1() {
    	// User selects an order and confirms deletion
    	assertEquals(cancelOrder.delete("zzzzzzzzzz", "Aaaaaa@13", "Order 5", "confirm"), "Order is cancelled");
    }
    
    @Test
    void cancelOrder_TC2() {
    	// Username is not valid
    	assertEquals(cancelOrder.delete("ahdbcgdusj", "Aaaaaa@13", "Order 5", "confirm"), "Username is not valid");
    }
    
    @Test
    void cancelOrder_TC3() {
    	// Password is not valid
    	assertEquals(cancelOrder.delete("zzzzzzzzzz", "hjsdhjbdc83", "Order 5", "confirm"), "Password is not valid");
    }
    
    @Test
    void cancelOrder_TC4() {
    	// Order has been started on or has been completed
    	assertEquals(cancelOrder.delete("zzzzzzzzzz", "Aaaaaa@13", "Order 1", "confirm"), "Order cannot be cancelled");
    }
    
    @Test
    void cancelOrder_TC5() {
    	// User selects an order and confirms deletion
    	assertEquals(cancelOrder.delete("zzzzzzzzzz", "Aaaaaa@13", "Order 5", "no"), "Order cancellation aborted");
    }
}