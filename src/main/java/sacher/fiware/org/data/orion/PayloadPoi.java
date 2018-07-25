package sacher.fiware.org.data.orion;

import java.util.ArrayList;
import java.util.List;

public class PayloadPoi {

	private String actionType;
	private List<PoiEntity> entities;

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public List<PoiEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<PoiEntity> entities) {
		this.entities = entities;
	}
	
	public void addEntity (PoiEntity e){
		if (entities == null)
			entities = new ArrayList<PoiEntity>();
		entities.add(e);
	}
}
