package in.fssa.aviease.model;

public class DaysEntity implements Comparable<DaysEntity>{
    
    
    private int id;
    private String FlightNo;
    private Boolean sun;
    private Boolean mon;
    private Boolean tue;
    private Boolean wed;
    private Boolean thu;
    private Boolean fri;
    private Boolean sat;
    
 

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFlightNo() {
		return FlightNo;
	}



	public void setFlightNo(String flightNo) {
		FlightNo = flightNo;
	}



	public Boolean getSun() {
		return sun;
	}



	public void setSun(Boolean sun) {
		this.sun = sun;
	}



	public Boolean getMon() {
		return mon;
	}



	public void setMon(Boolean mon) {
		this.mon = mon;
	}



	public Boolean getTue() {
		return tue;
	}



	public void setTue(Boolean tue) {
		this.tue = tue;
	}



	public Boolean getWed() {
		return wed;
	}



	public void setWed(Boolean wed) {
		this.wed = wed;
	}



	public Boolean getThu() {
		return thu;
	}



	public void setThu(Boolean thu) {
		this.thu = thu;
	}



	public Boolean getFri() {
		return fri;
	}



	public void setFri(Boolean fri) {
		this.fri = fri;
	}



	public Boolean getSat() {
		return sat;
	}



	public void setSat(Boolean sat) {
		this.sat = sat;
	}



	@Override
	public int compareTo(DaysEntity o) {
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

}


