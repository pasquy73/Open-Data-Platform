package sacher.fiware.org.data.orion;

public class PoiEntity {

	private String id;
	private String type;
	private TypeText name;
	private TypeText description;
	private TypeList category;
	private TypeGeoJsonPoint location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TypeText getName() {
		return name;
	}

	public void setName(TypeText name) {
		this.name = name;
	}

	public TypeText getDescription() {
		return description;
	}

	public void setDescription(TypeText description) {
		this.description = description;
	}

	public TypeList getCategory() {
		return category;
	}

	public void setCategory(TypeList category) {
		this.category = category;
	}

	public TypeGeoJsonPoint getLocation() {
		return location;
	}

	public void setLocation(TypeGeoJsonPoint location) {
		this.location = location;
	}

}
