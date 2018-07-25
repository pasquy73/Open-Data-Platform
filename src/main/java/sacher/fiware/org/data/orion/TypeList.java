package sacher.fiware.org.data.orion;

import java.util.List;

public class TypeList {

	private List<String> value;
	private String type = "List";

	public TypeList(List<String> value) {
		this.value = value;
	}

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
