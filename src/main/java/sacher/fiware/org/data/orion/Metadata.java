package sacher.fiware.org.data.orion;

import java.io.Serializable;

public class Metadata implements Serializable {

	private static final long serialVersionUID = -8160058552320925780L;
	private String type;
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Metatada [type=" + type + ", value=" + value + "]";
	}
}
