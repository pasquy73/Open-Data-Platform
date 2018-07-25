package sacher.fiware.org.data.orion;

public class TypeText {

	private String value;
	private String type = "Text";
	
	public TypeText(){		
	}
	
	public TypeText(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
