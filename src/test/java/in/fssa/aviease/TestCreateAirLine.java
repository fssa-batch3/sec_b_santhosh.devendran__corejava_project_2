package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.SecureRandom;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.exception.ServiceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.AirLine;
import in.fssa.aviease.service.AirLineService;
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

   
      
    AirLineService airLineService = new AirLineService();
    

    @Test
    void testCreateValidAirLine() {
        String randomString = generateRandomString(5);
        String randomString1 = generateRandomString(10);
        AirLine airLine = new AirLine(3, randomString, randomString1);
        assertDoesNotThrow(() -> airLineService.create(airLine));
    }



    @Test
    void testCreateInvalidAirLine() {
        // Test creating an invalid AirLine
        AirLine invalidAirLine = new AirLine(2,"", "InvalidName");
        ValidationException exception = assertThrows(ValidationException.class, () -> airLineService.create(invalidAirLine));
        assertTrue(exception.getMessage().contains("Airline code cannot be Null or Empty"));
    }

    @Test
    void testUpdateValidAirLine() {
        String randomString = generateRandomString(5);
        AirLine airLine = new AirLine(4, randomString, "UpdatedName");
        assertDoesNotThrow(() -> airLineService.update(4, airLine));
    }



    @Test
    void testFindByAirLineCode() {
       
        String existingCode = "UAE";
        AirLine foundAirLine = assertDoesNotThrow(() -> airLineService.findByAirLineCode(existingCode));
        assertNotNull(foundAirLine);
        assertEquals(existingCode, foundAirLine.getAirLineCode());
    }

    @Test
    void testFindByInvalidAirLineCode() {
        // Test finding an AirLine with an invalid code
        String invalidCode = null;
        ValidationException exception = assertThrows(ValidationException.class, () -> airLineService.findByAirLineCode(invalidCode));
        assertTrue(exception.getMessage().contains("airLine code cannot be Null or Empty"));
    }

    
  
}
