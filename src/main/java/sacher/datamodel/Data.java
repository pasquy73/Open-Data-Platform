package sacher.datamodel;

public class Data {

	private String _id;
	private String materiale_id;
	private String start_date;
	private String end_date;
	private String location_id;
	private String attivita_id;
	private Materiale materiale;
	private Attivita attivita;
	private Location location;
	private Date date;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getMateriale_id() {
		return materiale_id;
	}

	public void setMateriale_id(String materiale_id) {
		this.materiale_id = materiale_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getAttivita_id() {
		return attivita_id;
	}

	public void setAttivita_id(String attivita_id) {
		this.attivita_id = attivita_id;
	}

	public Materiale getMateriale() {
		return materiale;
	}

	public void setMateriale(Materiale materiale) {
		this.materiale = materiale;
	}

	public Attivita getAttivita() {
		return attivita;
	}

	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
