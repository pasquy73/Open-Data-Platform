package sacher.fiware.org.data.orion;

public class PoiSacherEntity extends PoiEntity {

	// attributi
	// _id => uid
	private TypeText uid;

	private TypeText materiale_id;
	private TypeText start_date;
	private TypeText end_date;
	private TypeText location_id;
	private TypeText attivita_id;

	// materiale
	private TypeText materiale_category;
	private TypeText materiale_type;
	private TypeText materiale_subtype;

	// attivita
	private TypeText attivita;
	private TypeText ambito;
	private TypeText subattivita;
	private TypeText l1;
	private TypeText l0;

	// date
	private TypeText date;
	private TypeText timestamp;
	private TypeText weekend;
	private TypeText day_of_week;
	private TypeText month;
	private TypeText month_day;
	private TypeText year;
	private TypeText week_starting_monday;

	// location
	private TypeText gid;
	private TypeText nome;
	private TypeText denominazioni;
	private TypeText proprietario_pubblico;
	private TypeText tipologie_cronologie;
	private TypeText categoria;
	private TypeText eta;
	private TypeText eta_attestazione;
	private TypeText WKT;
	private TypeText provincia;
	private TypeText comune;
	private TypeText diocesi;
	private TypeText frazione;
	private TypeText indirizzo;

	public TypeText getUid() {
		return uid;
	}

	public void setUid(TypeText uid) {
		this.uid = uid;
	}

	public TypeText getMateriale_id() {
		return materiale_id;
	}

	public void setMateriale_id(TypeText materiale_id) {
		this.materiale_id = materiale_id;
	}

	public TypeText getStart_date() {
		return start_date;
	}

	public void setStart_date(TypeText start_date) {
		this.start_date = start_date;
	}

	public TypeText getEnd_date() {
		return end_date;
	}

	public void setEnd_date(TypeText end_date) {
		this.end_date = end_date;
	}

	public TypeText getLocation_id() {
		return location_id;
	}

	public void setLocation_id(TypeText location_id) {
		this.location_id = location_id;
	}

	public TypeText getAttivita_id() {
		return attivita_id;
	}

	public void setAttivita_id(TypeText attivita_id) {
		this.attivita_id = attivita_id;
	}

	public TypeText getMateriale_category() {
		return materiale_category;
	}

	public void setMateriale_category(TypeText materiale_category) {
		this.materiale_category = materiale_category;
	}

	public TypeText getMateriale_type() {
		return materiale_type;
	}

	public void setMateriale_type(TypeText materiale_type) {
		this.materiale_type = materiale_type;
	}

	public TypeText getMateriale_subtype() {
		return materiale_subtype;
	}

	public void setMateriale_subtype(TypeText materiale_subtype) {
		this.materiale_subtype = materiale_subtype;
	}

	public TypeText getAttivita() {
		return attivita;
	}

	public void setAttivita(TypeText attivita) {
		this.attivita = attivita;
	}

	public TypeText getAmbito() {
		return ambito;
	}

	public void setAmbito(TypeText ambito) {
		this.ambito = ambito;
	}

	public TypeText getSubattivita() {
		return subattivita;
	}

	public void setSubattivita(TypeText subattivita) {
		this.subattivita = subattivita;
	}

	public TypeText getL1() {
		return l1;
	}

	public void setL1(TypeText l1) {
		this.l1 = l1;
	}

	public TypeText getL0() {
		return l0;
	}

	public void setL0(TypeText l0) {
		this.l0 = l0;
	}

	public TypeText getDate() {
		return date;
	}

	public void setDate(TypeText date) {
		this.date = date;
	}

	public TypeText getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(TypeText timestamp) {
		this.timestamp = timestamp;
	}

	public TypeText getWeekend() {
		return weekend;
	}

	public void setWeekend(TypeText weekend) {
		this.weekend = weekend;
	}

	public TypeText getDay_of_week() {
		return day_of_week;
	}

	public void setDay_of_week(TypeText day_of_week) {
		this.day_of_week = day_of_week;
	}

	public TypeText getMonth() {
		return month;
	}

	public void setMonth(TypeText month) {
		this.month = month;
	}

	public TypeText getMonth_day() {
		return month_day;
	}

	public void setMonth_day(TypeText month_day) {
		this.month_day = month_day;
	}

	public TypeText getYear() {
		return year;
	}

	public void setYear(TypeText year) {
		this.year = year;
	}

	public TypeText getWeek_starting_monday() {
		return week_starting_monday;
	}

	public void setWeek_starting_monday(TypeText week_starting_monday) {
		this.week_starting_monday = week_starting_monday;
	}

	public TypeText getGid() {
		return gid;
	}

	public void setGid(TypeText gid) {
		this.gid = gid;
	}

	public TypeText getNome() {
		return nome;
	}

	public void setNome(TypeText nome) {
		this.nome = nome;
	}

	public TypeText getDenominazioni() {
		return denominazioni;
	}

	public void setDenominazioni(TypeText denominazioni) {
		this.denominazioni = denominazioni;
	}

	public TypeText getProprietario_pubblico() {
		return proprietario_pubblico;
	}

	public void setProprietario_pubblico(TypeText proprietario_pubblico) {
		this.proprietario_pubblico = proprietario_pubblico;
	}

	public TypeText getTipologie_cronologie() {
		return tipologie_cronologie;
	}

	public void setTipologie_cronologie(TypeText tipologie_cronologie) {
		this.tipologie_cronologie = tipologie_cronologie;
	}

	public TypeText getCategoria() {
		return categoria;
	}

	public void setCategoria(TypeText categoria) {
		this.categoria = categoria;
	}

	public TypeText getEta() {
		return eta;
	}

	public void setEta(TypeText eta) {
		this.eta = eta;
	}

	public TypeText getEta_attestazione() {
		return eta_attestazione;
	}

	public void setEta_attestazione(TypeText eta_attestazione) {
		this.eta_attestazione = eta_attestazione;
	}

	public TypeText getWKT() {
		return WKT;
	}

	public void setWKT(TypeText wKT) {
		WKT = wKT;
	}

	public TypeText getProvincia() {
		return provincia;
	}

	public void setProvincia(TypeText provincia) {
		this.provincia = provincia;
	}

	public TypeText getComune() {
		return comune;
	}

	public void setComune(TypeText comune) {
		this.comune = comune;
	}

	public TypeText getDiocesi() {
		return diocesi;
	}

	public void setDiocesi(TypeText diocesi) {
		this.diocesi = diocesi;
	}

	public TypeText getFrazione() {
		return frazione;
	}

	public void setFrazione(TypeText frazione) {
		this.frazione = frazione;
	}

	public TypeText getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(TypeText indirizzo) {
		this.indirizzo = indirizzo;
	}

}
