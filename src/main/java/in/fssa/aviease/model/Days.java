package in.fssa.aviease.model;

public class Days extends DaysEntity{
	
	public Days(int id, String FlightNo,Boolean sun,Boolean mon,Boolean tue,Boolean wed,Boolean thu,Boolean fri,Boolean sat) {
		
		super.setId(id);
		super.setFlightNo(FlightNo);
		super.setSun(sun);
		super.setMon(mon);
		super.setTue(tue);
		super.setWed(wed);
		super.setThu(thu);
		super.setFri(fri);
		super.setSat(sat);
		
	}
public Days( String FlightNo,Boolean sun,Boolean mon,Boolean tue,Boolean wed,Boolean thu,Boolean fri,Boolean sat) {
		
		
		super.setFlightNo(FlightNo);
		super.setSun(sun);
		super.setMon(mon);
		super.setTue(tue);
		super.setWed(wed);
		super.setThu(thu);
		super.setFri(fri);
		super.setSat(sat);
		
	}
	
	public Days() {
		super();
	}

}
