package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.SecureRandom;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.AirLine;
import in.fssa.aviease.validator.AirLineValidator;

public class TestCreateAirLine {

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

    @Test
    public void testValidateAirLineValidAirLine() {
    	String randomString = generateRandomString(5);
    	String randomString1 = generateRandomString(10);
        AirLine airLine = new AirLine(3,randomString, randomString1);
        assertDoesNotThrow(() -> AirLineValidator.validateAirLine(airLine));
    }

    @Test
    public void testValidateAirLineNullAirLine() {
        ValidationException exception = assertThrows(ValidationException.class, () -> AirLineValidator.validateAirLine(null));
        assertTrue(exception.getMessage().contains("invalid airline input"));
    }

    @Test
    public void testValidateAirLineInvalidAirLineCode() {
    	String randomString = generateRandomString(5);
        AirLine airLine = new AirLine(1,"", randomString);
        ValidationException exception = assertThrows(ValidationException.class, () -> AirLineValidator.validateAirLine(airLine));
        assertTrue(exception.getMessage().contains("Airline code"));
    }

    @Test
    public void testValidateAirLineInvalidAirLineName() {
    	String randomString = generateRandomString(5);
        AirLine airLine = new AirLine(4,randomString,"");
        ValidationException exception = assertThrows(ValidationException.class, () -> AirLineValidator.validateAirLine(airLine));
        assertTrue(exception.getMessage().contains("Airline name"));
    }

 

  
}
