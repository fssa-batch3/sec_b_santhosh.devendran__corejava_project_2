package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.service.AirLineService;

public class TestFindAirline {

	AirLineService airLineService=new AirLineService();
	
	 @Test
	    void testFindAllAirline() {

	        assertDoesNotThrow(() -> {
	        	airLineService.findAll();
	        });
	    }
	 @Test
	    void testFindAllAirlineById() {

	        assertDoesNotThrow(() -> {
	        	airLineService.findById(1);
	        });
	    }
}
