package pojo;

import io.cucumber.messages.com.google.gson.annotations.SerializedName;

public class PostCodeDetails {

	@SerializedName("post code")
	private String postcode;
	private String country;
	private String countryabbreviation;
	private Places places;

	public PostCodeDetails() {

	}

	public PostCodeDetails(String postcode, String country, String countryabbreviation, Places places) {
		this.postcode = postcode;
		this.country = country;
		this.countryabbreviation = countryabbreviation;
		this.places = places;
	}



	public String getPostcode() {
		return postcode;
	}

	public String getCountry() {
		return country;
	}

	public String getCountryabbreviation() {
		return countryabbreviation;
	}

	public Places getPlaces() {
		return places;
	}

}
