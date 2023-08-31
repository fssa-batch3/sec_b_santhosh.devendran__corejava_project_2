package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.SecureRandom;
import java.util.Random;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.User;
import in.fssa.aviease.service.UserService;

public class TestCreateUser {

	
	  
	UserService  userService = new UserService();
	
	
	
	 private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    
	    public static String generateRandomString(int length) {
	        SecureRandom random = new SecureRandom();
	        StringBuilder stringBuilder = new StringBuilder(length);
	        
	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(CHARACTERS.length());
	            char randomChar = CHARACTERS.charAt(randomIndex);
	            stringBuilder.append(randomChar);
	        }
	        
	        return stringBuilder.toString();
	    }
	    
	    public static long generateRandomLong() {
	         Random random = new Random();
	        long min = 6000000000L; // 10-digit minimum value (1000000000)
	        long max = 9999999999L; // 10-digit maximum value (9999999999)
	        long range = max - min + 1;
	        long randomNumber = (long) (random.nextDouble() * range) + min;
	        return randomNumber;
	    }


	    @Test
	   public void testCreateUserWithValidDataInput() {
	        User newUser = new User();
	        newUser.setFirstname("itachi");
	        newUser.setLastname("Uchiga");
	        long randomLong = generateRandomLong();
	        String randomString = generateRandomString(5);

	        newUser.setMobileNo(randomLong);
	      	newUser.setEmail(randomString.concat("@gmail.com"));
	        newUser.setPassword("Azxcv@123");

	        assertDoesNotThrow(() -> {
	            userService.createUser(newUser);
	        });
	    }

	    @Test
	    public void testCreateUserWithInvalidData() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	            userService.createUser(null);
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
	            userService.createUser(newUser);
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
		        
		        String randomString = generateRandomString(5);
		        newUser.setMobileNo(4245054128l);
		        newUser.setEmail(randomString.concat("@gmail.com"));
		        newUser.setPassword("Azxcv@123");
	            userService.createUser(newUser);
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
	            userService.createUser(newUser);
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
	            userService.createUser(newUser);
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
	            userService.createUser(newUser);
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
	            userService.createUser(newUser);
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
	            userService.createUser(newUser);
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
	            userService.createUser(newUser);
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
	            userService.createUser(newUser);
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
	            userService.createUser(newUser);
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
	            userService.createUser(newUser);
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
		        long randomLong = generateRandomLong();
		        String randomString = generateRandomString(5);
		        newUser.setMobileNo(randomLong);
		        newUser.setEmail(randomString.concat("1@gmail.com"));
		        newUser.setPassword("A3766");
	            userService.createUser(newUser);
	        });
	        String expectedMessage = "Invalid password format";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }

}
