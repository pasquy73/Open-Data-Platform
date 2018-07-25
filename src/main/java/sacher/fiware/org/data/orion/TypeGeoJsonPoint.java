package sacher.fiware.org.data.orion;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TypeGeoJsonPoint {

	private GeometryPoint value;
	private String type = "geo:json";
	
	@JsonIgnore
	private Metadata metadata;

	public TypeGeoJsonPoint(GeometryPoint value) {
		super();
		this.value = value;
	}

	public TypeGeoJsonPoint() {
		super();
	}

	public GeometryPoint getValue() {
		return value;
	}

	public void setValue(GeometryPoint value) {
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
