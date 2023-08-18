package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.User;
import in.fssa.aviease.service.UserService;

public class TestCreateUser {

	
	  
	UserService  userService = new UserService();
	    

	    @Test
	   public void testCreateUserWithValidDataInput() {
	        User newUser = new User();
	        newUser.setFirstname("Santhosh");
	        newUser.setLastname("Devendren");
	        newUser.setMobileNo(7865489399l);
	        newUser.setEmail("sandy12@gmail.com");
	        newUser.setPassword("Azxcv@123");

	        assertDoesNotThrow(() -> {
	            userService.create(newUser);
	        });
	    }

	    @Test
	    public void testCreateUserWithInvalidData() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	            userService.create(null);
	        });
	        String expectedMessage = "invalid user input";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidFname() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("");
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail("sandy1@gmail.com");
		        newUser.setPassword("Azxcv@123");
	            userService.create(newUser);
	        });
	        String expectedMessage = "Firstname cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidMobileNo() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("sandy");
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(4925054128l);
		        newUser.setEmail("sand@gmail.com");
		        newUser.setPassword("Azxcv@123");
	            userService.create(newUser);
	        });
	        String expectedMessage = "invalid mobile number";
	      
	        String actualMessage = exception.getMessage();
	       
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithAlreadyExistMobileNo() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("sandy");
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(8925054118l);
		        newUser.setEmail("sandy@gmail.com");
		        newUser.setPassword("Azxcv@123");
	            userService.create(newUser);
	        });
	        String expectedMessage = "mobile number already exist";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidFnameNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname(null);
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail("sandy156@gmail.com");
		        newUser.setPassword("Azxcv@123");
	            userService.create(newUser);
	        });
	        String expectedMessage = "Firstname cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    @Test
	    public void testCreateUserWithInvalidLname() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("Santhosh");
		        newUser.setLastname("");
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail("sandy187@gmail.com");
		        newUser.setPassword("Azxcv@123");
	            userService.create(newUser);
	        });
	        String expectedMessage = "Lastname cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidLnameNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("Santhosh");
		        newUser.setLastname(null);
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail("sandy981@gmail.com");
		        newUser.setPassword("Azxcv@123");
	            userService.create(newUser);
	        });
	        String expectedMessage = "Lastname cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidemail() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("Santhosh");
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail("");
		        newUser.setPassword("Azxcv@123");
	            userService.create(newUser);
	        });
	        String expectedMessage = "Email cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidemailNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("Santhosh");
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail(null);
		        newUser.setPassword("Azxcv@123");
	            userService.create(newUser);
	        });
	        String expectedMessage = "Email cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidemailPattern() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("Santhosh");
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail("sandy1.com");
		        newUser.setPassword("Azxcv@123");
	            userService.create(newUser);
	        });
	        String expectedMessage = "Invalid email format";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidPassword() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("Santhosh");
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail("sandy1@gmail.com");
		        newUser.setPassword("");
	            userService.create(newUser);
	        });
	        String expectedMessage = "Password cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidPasswordNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("Santhosh");
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail("sandy1@gmail.com");
		        newUser.setPassword(null);
	            userService.create(newUser);
	        });
	        String expectedMessage = "Password cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateUserWithInvalidPasswordPatern() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	        	User newUser = new User();
		        newUser.setFirstname("Santhosh");
		        newUser.setLastname("Devendren");
		        newUser.setMobileNo(7865489395l);
		        newUser.setEmail("sandy1@gmail.com");
		        newUser.setPassword("Az123766");
	            userService.create(newUser);
	        });
	        String expectedMessage = "Invalid password format";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }

}
