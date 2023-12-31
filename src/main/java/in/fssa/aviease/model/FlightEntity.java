package in.fssa.aviease.model;

import java.sql.Time;
import java.util.List;

public abstract class FlightEntity implements Comparable<FlightEntity> {
	    
	    private int id;
	    private String src;
	    private String destination;
	    private String airlineCode;
	    private String flightNo;
	    private int dayId;
	    private boolean flightStatus;
	    private Time flightTime;
	    private int noOfSeats;
	    private double price;
	    
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getSrc() {
			return src;
		}
		public void setSrc(String src) {
			this.src = src;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public String getAirlineCode() {
			return airlineCode;
		}
		public void setAirlineCode(String airlineCode) {
			this.airlineCode = airlineCode;
		}
		public String getFlightNo() {
			return flightNo;
		}
		public void setFlightNo(String flightNo) {
			this.flightNo = flightNo;
		}
		public int getDayId() {
			return dayId;
		}
		public void setDayId(int dayId) {
			this.dayId = dayId;
		}
		public boolean isFlightStatus() {
			return flightStatus;
		}
		public void setFlightStatus(boolean flightStatus) {
			this.flightStatus = flightStatus;
		}
		public Time getFlightTime() {
			return flightTime;
		}
		public void setFlightTime(Time flightTime) {
			
			this.flightTime = flightTime;
		}
		public void setFlightTimeString(String flightTime) {
			
			Time time = Time.valueOf(flightTime);
			
			this.flightTime = time;
		}
		
		public int getNoOfSeats() {
			return noOfSeats;
		}
		public void setNoOfSeats(int noOfSeats) {
			this.noOfSeats = noOfSeats;
		}
		@Override
		public String toString() {
			return "FlightEntity [id=" + id + ", src=" + src + ", destination=" + destination + ", airlineCode="
					+ airlineCode + ", flightNo=" + flightNo + ", dayId=" + dayId + ", flightStatus=" + flightStatus
					+ ", flightTime=" + flightTime + ", noOfSeats=" + noOfSeats + "]";
		}
	    
		public int compareTo(FlightEntity o) {
			if (this.getId() == o.getId()) {
				return 0;
			} else {
				if (this.getId() < (o.getId())) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		
		public static int binarySearch(List<Flight> arr, int key) {
		    int left = 0;
		    int right = arr.size() - 1;

		    while (left <= right) {
		        int mid = left + (right - left) / 2;

		        if (arr.get(mid).getId() == key) {
		            return mid; 
		        }

		        if (arr.get(mid).getId() < key) {
		            left = mid + 1; 
		        } else {
		            right = mid - 1; 
		        }
		    }

		    return -1; 
		}
	    
}
