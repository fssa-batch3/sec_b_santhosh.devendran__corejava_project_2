package in.fssa.aviease;


import in.fssa.aviease.service.UserService;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import in.fssa.aviease.exception.ValidationException;
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

	    @Test
	    public void testGetAllUsers() {
	        List<User> userList = userService.getAllUser();
	        assertNotNull(userList);
	        assertTrue(userList.size() > 0);
	    }

	    @Test
	    public void testCountUsers() {
	        int userCount = userService.count();
	        assertTrue(userCount >= 0);
	    }
}

