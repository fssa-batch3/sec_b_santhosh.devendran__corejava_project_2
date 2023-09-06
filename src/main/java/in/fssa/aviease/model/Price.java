package in.fssa.aviease.model;

public class Price extends PriceEntity{
	
	public Price(int id,String startDate,String endDate,String flightId,Double price) {
		super.setId(id);
		super.setStartDate(startDate);
		super.setEndDate(endDate);
		super.setFlightId(flightId);
		super.setPrice(price);
		
	}

	public Price() {
		super();
	}

	
}
