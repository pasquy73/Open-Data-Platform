package sacher.fiware.org;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import sacher.datamodel.Data;
import sacher.fiware.org.data.orion.GeometryPoint;
import sacher.fiware.org.data.orion.PayloadPoi;
import sacher.fiware.org.data.orion.PoiSacherEntity;
import sacher.fiware.org.data.orion.TypeGeoJsonPoint;
import sacher.fiware.org.data.orion.TypeList;
import sacher.fiware.org.data.orion.TypeText;

public class Sacher {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String URL_ORION = Config.getOrionURL() + "/v2/op/update";
	private final String fiware_service = Config.getFiwareService();
	private final String fiware_servicepath = Config.getFiwareServicePath();
	private final String fiware_entity_id = Config.getFiwareEntityId();
	private final String fiware_entity_type = Config.getFiwareEntityType();
	
	private static int MAX = Config.getMaxNumberEntities();
	private static int WAITING_TIME = Config.getWaitingTime();

	private RestTemplate restTmp = new RestTemplate();
	
	protected void execute(String file) {		
		logger.info("Start of the task");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

		try {
			File f = new File(file);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String readLine = "";
			logger.info("Reading JSON data from " + file + " file line by line");
			int i = 0, failed = 0, group = 0;
			boolean send_data = false, create_payload = true;
			Data data = null;

			PayloadPoi payloadPoi = null;
			String payload = null;
			String json = null;
			
			logger.info("Sending data to Orion grouped by " + MAX +" entities");

			while ((readLine = b.readLine()) != null) {
				
				if (create_payload){//create payload
					payloadPoi = new PayloadPoi();
					logger.debug("Create payload[" + ++group + "]");
					payloadPoi.setActionType("APPEND");
					send_data = false;
					create_payload = false;
				}
				
				if (!readLine.isEmpty()){
					json = cleanJson(readLine);
					logger.debug("Read line " + ++i + " - " + json);
					data = mapper.readValue(json, Data.class);
	
					logger.debug("Add entity to payload with id = " + data.get_id());
					payloadPoi.addEntity(getEntity(data));
					
					if ((i % MAX) == 0){ // store data
						payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payloadPoi);
						logger.info("Payload[" + group + "] - " + MAX + " entities to send to Orion");
						logger.debug("Payload to send:\n" + payload);
						
						if (sendToOrion(payloadPoi)){
							logger.debug("Send payload to orion endpoint url [" + URL_ORION + "] with successful");
						}else{
							failed++;
							logger.info("Cannot send Payload[" + group + "] - lines from " + (MAX *(group-1) + 1)  + " to " + i);
						}	

						send_data = true;
						create_payload = true;
						//init params
						payloadPoi = null;
					}
				}
			}
			b.close();
			//check
			if (!send_data && payloadPoi != null){
				payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payloadPoi);
				logger.info("Payload[" + group + "] - " + (i - (group-1)*MAX) + " entities to send to Orion");
				logger.debug("Payload to send:\n" + payload);
				
				if (sendToOrion(payloadPoi)){
					logger.debug("Send payload to orion endpoint url [" + URL_ORION + "] with successful");
				}else{
					failed++;
					logger.info("Cannot send Payload[" + group + "] - lines from " + (MAX *(group-1) + 1)  + " to " + i);
				}	
			}
			
			logger.info("Total lines read = " + i + "; Payloads sent with successful = " + (group - failed) + "; Payloads failed = " + failed);
							
			logger.info("End of the task");

		} catch (IOException e) {
			logger.error("Error in execute: " + e.getMessage());
		}
	}

	private PoiSacherEntity getEntity(Data data) {

		PoiSacherEntity entity = new PoiSacherEntity();
		// id
		entity.setId(fiware_entity_id);
		// type
		entity.setType(fiware_entity_type);
		
		// _id
		entity.setUid(new TypeText(cleanText(data.get_id())));
		// name
		String name = data.getAttivita().getAttivita() + " - " + data.getAttivita().getAmbito();
		entity.setName(new TypeText(cleanText(name)));
		// category
		List<String> category = new ArrayList<String>();
		category.add(Category.Tourist_Information_Services.getValue());// 34,113,311,439
		entity.setCategory(new TypeList(category));
		// location
		List<Double> coordinates = new ArrayList<Double>();
		coordinates.add(getDoubleValue(data.getLocation().getLon()));// lon
		coordinates.add(getDoubleValue(data.getLocation().getLat()));// lat
		GeometryPoint gp = new GeometryPoint();
		gp.setType("Point");
		gp.setCoordinates(coordinates);
		entity.setLocation(new TypeGeoJsonPoint(gp));

		// description
		String description = data.getAttivita().getAmbito() + " - " + data.getAttivita().getSubattivita();
		entity.setDescription(new TypeText(cleanText(description)));

		/**
		 * attributi sacher
		 */
		// materiale_id
		entity.setMateriale_id(new TypeText(cleanText(data.getMateriale_id())));
		// start_date
		entity.setStart_date(new TypeText(cleanText(data.getStart_date())));
		// end_date
		entity.setEnd_date(new TypeText(cleanText(data.getEnd_date())));
		// location_id
		entity.setLocation_id(new TypeText(cleanText(data.getLocation_id())));
		// attivita_id
		entity.setAttivita_id(new TypeText(cleanText(data.getAttivita_id())));
		
		/*** materiale ***/
		// category
		entity.setMateriale_category(new TypeText(cleanText(data.getMateriale().getCategory())));
		// type
		entity.setMateriale_type(new TypeText(cleanText(data.getMateriale().getType())));
		// subtype
		entity.setMateriale_subtype(new TypeText(cleanText(data.getMateriale().getSubtype())));

		/*** attivita ***/
		// attivita
		entity.setAttivita(new TypeText(cleanText(data.getAttivita().getAttivita())));
		// ambito
		entity.setAmbito(new TypeText(cleanText(data.getAttivita().getAmbito())));
		// subattivita
		entity.setSubattivita(new TypeText(cleanText(data.getAttivita().getSubattivita())));
		// l1
		entity.setL1(new TypeText(cleanText(data.getAttivita().getL1())));
		// l0
		entity.setL0(new TypeText(cleanText(data.getAttivita().getL0())));
		
		/*** date ***/
		// date
		entity.setDate(new TypeText(cleanText(data.getDate().getDate())));
		// 	timestamp
		entity.setTimestamp(new TypeText(cleanText(data.getDate().getTimestamp())));
		// weekend
		entity.setWeekend(new TypeText(cleanText(data.getDate().getWeekend())));
		// day_of_week
		entity.setDay_of_week(new TypeText(cleanText(data.getDate().getDay_of_week())));
		// month
		entity.setMonth(new TypeText(cleanText(data.getDate().getMonth())));
		// month_day
		entity.setMonth_day(new TypeText(cleanText(data.getDate().getMonth_day())));
		// year
		entity.setYear(new TypeText(cleanText(data.getDate().getYear())));
		// week_starting_monday
		entity.setWeek_starting_monday(new TypeText(cleanText(data.getDate().getWeek_starting_monday())));

		/*** location ***/
		// gid
		entity.setGid(new TypeText(cleanText(data.getLocation().getGid())));
		// nome
		entity.setNome(new TypeText(cleanText(data.getLocation().getNome())));
		// denominazioni
		entity.setDenominazioni(new TypeText(cleanText(data.getLocation().getDenominazioni())));
		// proprietario_pubblico
		entity.setProprietario_pubblico(new TypeText(cleanText(data.getLocation().getProprietario_pubblico())));
		// tipologie_cronologie
		entity.setTipologie_cronologie(new TypeText(cleanText(data.getLocation().getTipologie_cronologie())));
		// categoria
		entity.setCategoria(new TypeText(cleanText(data.getLocation().getCategoria())));
		// eta
		entity.setEta(new TypeText(cleanText(data.getLocation().getEta())));
		// eta_attestazione;
		entity.setEta_attestazione(new TypeText(cleanText(data.getLocation().getEta_attestazione())));
		// WKT
		entity.setWKT(new TypeText(cleanText(data.getLocation().getWKT())));
		// provincia
		entity.setProvincia(new TypeText(cleanText(data.getLocation().getProvincia())));
		// comune
		entity.setComune(new TypeText(cleanText(data.getLocation().getComune())));
		// diocesi
		entity.setDiocesi(new TypeText(cleanText(data.getLocation().getDiocesi())));
		// frazione
		entity.setFrazione(new TypeText(cleanText(data.getLocation().getFrazione())));
		// indirizzo
		entity.setIndirizzo(new TypeText(cleanText(data.getLocation().getIndirizzo())));
		
		return entity;
	}

	private boolean sendToOrion(PayloadPoi payload) {

		// POST Call to orion
		try{
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Fiware-Service", fiware_service);
			headers.set("Fiware-ServicePath", fiware_servicepath);
			
			restTmp.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			restTmp.getMessageConverters().add(new StringHttpMessageConverter());

			HttpEntity<PayloadPoi> entity = new HttpEntity<PayloadPoi>(payload, headers);

			restTmp.postForObject(URL_ORION, entity, PayloadPoi.class);
			
			logger.info("Sending data ...");
			Thread.sleep(WAITING_TIME * 1000);
			
		} catch (Exception e) {
			logger.error("Error in execute: " + e.getMessage());
			return false;
		}
		return true;
	}

	
	private String cleanJson(String data){	
		logger.debug("Cleaning JSON payload before to send it to Orion");
		//remove empty values as [] in empty ("")
		String json = data.replace("[]", "\"\"");
		// replace '(' and ')' with '[' and ']' - orion doesn't accept '(' and ')'
		//json = json.replace("(", "[");
		//json = json.replace(")", "]");
				
		return json;
	}
	
	private String cleanText(String text){
		//special characters that orion doesn't accept <, >, ", ', =, ;, (, )
		text = text.replace("<", "%3C").replace(">", "%3E");
		text = text.replace("\"", "%22").replace("'", "%27");
		text = text.replace("=", "%3D").replace(";", "%3B");
		text = text.replace("(", "%28").replace(")", "%29");

		return text.replaceAll("[^\\p{ASCII}]", "");
	}
	
	private Double getDoubleValue(String value){
		Double number = 0.0;// use 0.0 as default value
		try {
			number = new Double(value);
		}catch (NumberFormatException e){
			logger.warn("Error in getDoubleValue: " + e.getMessage() + " : set as default = " + number);
		}
		return number;
	}
	
	/**
	 * enumeration of marker
	 */
	
	private enum Category {

		Beaches("113"), 
		Museums("311"), 
		Tourist_Information_Services("439");

		private String value;

		private Category(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

	}
}
