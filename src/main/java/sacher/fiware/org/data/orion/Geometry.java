package sacher.fiware.org.data.orion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

	@JsonProperty("type")
	private String type;

	public Geometry() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}