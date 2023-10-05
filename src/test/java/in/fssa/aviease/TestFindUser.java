package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.model.User;
import in.fssa.aviease.service.UserService;

public class TestFindUser {

	UserService us=new UserService();
	
	 @Test
	    void testfindUserWithEmail() {

	        assertDoesNotThrow(() -> {
	         us.findUserByEmail("santhosh0075santhosh@gmail.com");
	        });
	    }
	 
	 @Test
	    void testfindUserWithId() {

	        assertDoesNotThrow(() -> {
	         us.findUserById(1);
	        });
	    }
	 
	 @Test
	    void testfindUserWithMobileNumber() {

	        assertDoesNotThrow(() -> {
	         us.findUserByMobileNo(8925054119l);
	        });
	    }
	 
	 @Test
	    void testfindAllUser() {

	        assertDoesNotThrow(() -> {
	         us.getAllUser();
	        });
	    }
	 
	 
	 @Test
	    void testFindUserCount() {

	        assertDoesNotThrow(() -> {
	         us.getCount();
	        });
	    }
	 
}
