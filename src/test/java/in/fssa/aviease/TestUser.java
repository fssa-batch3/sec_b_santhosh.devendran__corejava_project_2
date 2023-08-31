package in.fssa.aviease;


import in.fssa.aviease.service.UserService;



import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import in.fssa.aviease.model.User;
public class TestUser {

	UserService userService=new UserService();


	    @Test
	    public void testFindUserById() {
	        int existingUserId = 1; 

	        assertDoesNotThrow(() -> {
	            User user = userService.findUserById(existingUserId);
	            assertNotNull(user);
	        });
	    }

	    @Test
	    public void testFindUserByEmail() {
	        String existingEmail = "santhosh@gmail.com"; 

	        assertDoesNotThrow(() -> {
	            User user = userService.findUserByEmail(existingEmail);
	            assertNotNull(user);
	        });
	    }

	    @Test
	    public void testFindUserByMobileNo() {
	        long existingMobileNo = 8925054118l; // Replace with an existing mobile number

	        assertDoesNotThrow(() -> {
	            User user = userService.findUserByMobileNo(existingMobileNo);
	            assertNotNull(user);
	        });
	    }

}
