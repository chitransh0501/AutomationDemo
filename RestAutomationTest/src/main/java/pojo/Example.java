package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data" })
public class Example {

	public Example(Data data) {
		super();
		this.data = data;
	}

	public Example() {

	}// This is mandatory

	@JsonProperty("data")
	private Data data;

	@JsonProperty("data")
	public Data getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Example [data=" + data + "]";
	}

}
