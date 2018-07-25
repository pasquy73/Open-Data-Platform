package sacher.fiware.org.data.orion;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TypeFloat {
	
	private Double value;
	private String type = "Float";
	
	@JsonIgnore
	private Metadata metadata;

	public TypeFloat() {
		metadata = new Metadata();
	}

	public TypeFloat(Double value) {
		super();
		this.value = value;
		metadata = new Metadata();
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
}
