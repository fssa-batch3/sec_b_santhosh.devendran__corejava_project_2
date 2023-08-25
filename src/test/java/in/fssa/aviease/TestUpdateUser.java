package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.User;
import in.fssa.aviease.service.UserService;

public class TestUpdateUser {

	UserService userService=new UserService();
	@Test
	public void testUpdateUserWithInvalidId() {
        int nonExistingUserId = -1;
        User updatedUser = new User();
        updatedUser.setFirstname("sandy");
        updatedUser.setLastname("d");

        Exception exception = assertThrows(ValidationException.class, () -> {
        	
        	 User newUser = new User();
 	        newUser.setFirstname("Santhosh");
 	        newUser.setLastname("Devendren");
 	       newUser.setMobileNo(7865489395l);
 	        newUser.setEmail("sandy1@gmail.com");
 	        newUser.setPassword("Azxcv@123");
        	
            userService.updateUser(nonExistingUserId,newUser );
        });
        String expectedMessage = "Invalid user id";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));
    }
	
	
	@Test
	public void testUpdateUserWithNotExistId() {
        int nonExistingUserId = 34;
        User updatedUser = new User();
        updatedUser.setFirstname("sandy");
        updatedUser.setLastname("d");

        Exception exception = assertThrows(ValidationException.class, () -> {
        	
        	 User newUser = new User();
 	        newUser.setFirstname("Santhosh");
 	        newUser.setLastname("Devendren");
 	       newUser.setMobileNo(7865489395l);
 	        newUser.setEmail("sandy1@gmail.com");
 	        newUser.setPassword("Azxcv@123");
        	
            userService.updateUser(nonExistingUserId,newUser );
        });
        String expectedMessage = "user not found";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));
    }
	
	


    @Test
    public void testUpdateUser() {
        int existingUserId = 1; 
        User updatedUser = new User();
        updatedUser.setFirstname("john");
        updatedUser.setLastname("meclearn");

        assertDoesNotThrow(() -> {
            userService.updateUser(existingUserId, updatedUser);
        });
    }

   
}
