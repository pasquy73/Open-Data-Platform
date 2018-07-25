package sacher.fiware.org;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Config {

	private static Logger logger = LoggerFactory.getLogger(Config.class.getName());

	private static final String FILE_PROPERTIES = "config.properties";
	
	private static final String ORION_URL = "orion.url";
	private static final String FIWARE_SERVICE = "fiware.service";
	private static final String FIWARE_SERVICEPATH = "fiware.servicepath";
	private static final String FIWARE_ENTITY_ID = "fiware.entity.id";
	private static final String FIWARE_ENTITY_TYPE = "fiware.entity.type";
	
	private static final String MAX_NUMBER_ENTITIES = "max.number.entities";
	private static final String WAITING_TIME = "waiting.time";

	private static Properties properties = null;

	private static Properties getProperties() {

		if (properties == null) {
			properties = new Properties();
			InputStream propertiesStream = Config.class.getClassLoader().getResourceAsStream(FILE_PROPERTIES);

			if (propertiesStream != null) {
				try {
					properties.load(propertiesStream);
					logger.debug("Load properties file with successful");
				} catch (IOException e) {
					logger.error("Error in getProperties: " + e.getMessage());
				}
			} else {
				logger.debug("Error: file properties not found");
			}
		}
		return properties;
	}

	protected static String getOrionURL() {
		return getProperties().get(Config.ORION_URL).toString();
	}

	protected static String getFiwareService() {
		return getProperties().get(Config.FIWARE_SERVICE).toString();
	}
	
	protected static String getFiwareServicePath() {
		return getProperties().get(Config.FIWARE_SERVICEPATH).toString();
	}
	
	protected static String getFiwareEntityId() {
		return getProperties().get(Config.FIWARE_ENTITY_ID).toString();
	}
	
	protected static String getFiwareEntityType() {
		return getProperties().get(Config.FIWARE_ENTITY_TYPE).toString();
	}
	
	protected static int getMaxNumberEntities() {		
		int max = 10; // set as default
		try {
			max = new Integer(getProperties().get(Config.MAX_NUMBER_ENTITIES).toString());
		}catch (NumberFormatException e){
			logger.warn("Error in getMaxNumberEntities: " + e.getMessage() + " : set as default = " + max);
		}
		return max;
	}
	
	protected static int getWaitingTime() {		
		int time = 10; // set as default
		try {
			time = new Integer(getProperties().get(Config.WAITING_TIME).toString());
		}catch (NumberFormatException e){
			logger.warn("Error in getWaitingTime: " + e.getMessage() + " : set as default = " + time);
		}
		return time;
	}
}