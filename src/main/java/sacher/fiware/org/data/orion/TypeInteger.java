package sacher.fiware.org.data.orion;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TypeInteger {

	private Integer value;
	private String type = "Integer";

	@JsonIgnore
	private Metadata metadata;
	
	public TypeInteger() {
		metadata = new Metadata();
	}

	public TypeInteger(Integer value) {
		super();
		this.value = value;
		metadata = new Metadata();
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
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
