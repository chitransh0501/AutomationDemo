package pojo;

public class Places {

	private String placeName;

	private String longitude;

	private String state;

	private String latitude;

	private String stateabbreviation;

	public Places() {

	}

	public Places(String placeName, String longitude, String state, String latitude, String stateabbreviation) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.placeName = placeName;
		this.state = state;
		this.stateabbreviation = stateabbreviation;
	}

	public String getState() {
		return state;
	}

	public String getPlaceName() {
		return placeName;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getStateabbreviation() {
		return stateabbreviation;
	}
}
