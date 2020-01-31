package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "email", "first_name", "last_name", "avatar" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

	@JsonProperty("id")
	private String id;

	@JsonProperty("email")
	private String email;

	@JsonProperty("first_name")
	private String first_name;

	@JsonProperty("last_name")
	private String last_name;;

	@JsonProperty("avatar")
	private String avatar;

	public Data(String id, String email, String first_name, String last_name, String avatar) {
		this.id = id;
		this.email = email;

		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("first_name")
	public String getFirst_name() {
		return first_name;
	}

	@JsonProperty("last_name")
	public String getLast_name() {
		return last_name;
	}

	@JsonProperty("avatar")
	public String getAvatar() {
		return avatar;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("first_name")
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@JsonProperty("last_name")
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@JsonProperty("avatar")
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return getId() + ", " + getEmail() + ", " + getFirst_name() + ", " + getLast_name() + ", " + getAvatar();
	}

	public Data() {

	}
}
