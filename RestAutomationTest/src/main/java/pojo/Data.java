package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

	private String id;
	
	private String email;
	
	private String first_name;
	
	private String last_name;;
	
	private String avatar;
	
	public Data() {
		
		
	}
	
	public Data(String id, String email, String first_name, String last_name, String avatar) {
		this.id = id;
		this.email = email;
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getAvatar() {
		return avatar;
	}
	
	public String toString() {
		return this.id;
	}
}
