package in.fssa.aviease.model;

public class AirLineEntity implements Comparable<AirLineEntity> {
	
	
	    
	    
	    private int id;
	   private String airLineName;
	   private String airLineCode;
	   
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getAirLineName() {
		return airLineName;
	}


	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}


	public String getAirLineCode() {
		return airLineCode;
	}


	public void setAirLineCode(String airLineCode) {
		this.airLineCode = airLineCode;
	}


	public int compareTo(AirLineEntity o) {
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
