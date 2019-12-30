package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Example {

	private Data data;

	public Example() {

	}

	public Example(Data data) {
		this.data = data;
	}

	public Data getUserDetails() {
		return data;
	}

	public String toString() {
		return "Data " + this.data;
	}

}
