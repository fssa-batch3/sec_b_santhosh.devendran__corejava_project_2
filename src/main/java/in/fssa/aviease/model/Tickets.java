package in.fssa.aviease.model;

public class Tickets extends TicketsEntity{

	public Tickets(int id,int userId,int fligthId,int priceId,String travelDate) {
		super.setId(id);
		super.setUserId(userId);
		super.setFlightId(fligthId);
		super.setPriceId(priceId);
		super.setTravelDate(travelDate);
		
		
	}
	
	public Tickets() {
		super();
	}
}
