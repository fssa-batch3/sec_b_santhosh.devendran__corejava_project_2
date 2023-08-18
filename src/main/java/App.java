import java.sql.Time;

import in.fssa.aviease.exception.ValidationException;


import in.fssa.aviease.model.User;
import in.fssa.aviease.model.Flight;
import in.fssa.aviease.service.UserService;

import in.fssa.aviease.service.FlightService;


public class App {
	public static void main(String[] args) {
		
		
//		////////////////////user service
		
//		UserService us = new UserService();
//		
//		User user = new User();
//		
//		user.setEmail("santhosh75@gmail.com");
//		user.setFirstname("sandy");
//		user.setLastname("D");
//		user.setMobileNo(8925054176l);
//		user.setPassword("sanDhgdY@2002");
//		
//		try {
//			us.create(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//		try {
//			us.update(6,user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			System.out.print(us.findByMobileNo(9876543210l));
//		} catch (ValidationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		System.out.print(us.getAll());
		
		
		
//		//////////////////////////////// flight service
		
		
		
		
		
		
		FlightService fs=new FlightService();
		
	//	System.out.println(fs.findAll());
		
		
		String timeStr = "08:00:00"; // Replace this with your actual time string
        
       
       Flight flight=new Flight();
       
       flight.setId(3);
       flight.setSrc("chennai");
       flight.setDestination("delhi");
       flight.setAirlineCode("342");
       flight.setFlightNo("ai76");
       flight.setDayId(2);
       flight.setFlightStatus(true);
       flight.setFlightTimeString(timeStr);
       flight.setNoOfSeats(330);
       
       System.out.println(flight.toString());
       
       
       //create
//       try {
//		fs.create(flight);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
       
       //update
       
//       try {
//		fs.update(6, flight);
//	} catch (ValidationException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
       
       
		
		
        
	}
	
	
	

}
