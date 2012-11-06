package xyzt.orthopediatrics.client;

public class Referto
{
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="prenotazione"
	 */
	private int prenotazione;
	/**
	 * @uml.property  name="contenuto"
	 */
	private String contenuto;
	/**
	 * @uml.property  name="medico"
	 */
	private String medico;
	/**
	 * @uml.property  name="paziente"
	 */
	private String paziente;
	
	/**
	 * Costruttore di default
	 * (senza parametri)
	 */
	public Referto() {}
	
	/**
	 * Costruttore del referto (con parametri)
	 * @param prenotazione - Identificativo della prenotazione
	 * @param contenuto    - contenuto del referto
	 * @param medico       - Nome del medico che ha effettauato il referto
	 */
	public Referto(int prenotazione, String contenuto, String medico, String paziente) {
		/**
		 * identificativo del referto
		 * <ID_REFERTO> = <ID_PRENOTAZIONE> - <10000>
		 */
		this.id = (prenotazione - 10000);
		this.prenotazione = prenotazione;
		this.contenuto = contenuto;
		this.medico = medico;
		this.paziente = paziente;
	}
	
	// -- GET
	
	/**
	 * @return  identificazione del referto
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return  riferimento alla prenotazione
	 * @uml.property  name="prenotazione"
	 */
	public int getPrenotazione() {
		return prenotazione;
	}
	
	/**
	 * @return  Contenuto del referto
	 * @uml.property  name="contenuto"
	 */
	public String getContenuto() {
		return contenuto;
	}
	
	
	/**
	 * @return
	 * @uml.property  name="medico"
	 */
	public String getMedico() {
		return medico;
	}
	
	/**
	 * @return
	 * @uml.property  name="paziente"
	 */
	public String getPaziente() {
		return paziente;
	}
	
	// -- SET
	
	/**
	 * Impostazione di un nuovo ID
	 * @param id  - Identificativo del referto
	 * @uml.property  name="id"
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Impostazione dell'identificativo della prenotazione
	 * @param prenotazione  - Identificativo della prenotazione
	 * @uml.property  name="prenotazione"
	 */
	public void setPrenotazione(int prenotazione) {
		this.prenotazione = prenotazione;
	}
	
	/**
	 * Impostazione del contenuto del referto
	 * @param contenuto  - Contenuto del referto
	 * @uml.property  name="contenuto"
	 */
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	
	/**
	 * Imposta il medico che ha eseguito il referto
	 * @param medico  - Nome del medico
	 * @uml.property  name="medico"
	 */
	public void setMedico(String medico) {
		this.medico = medico;
	}
	
	/**
	 * @param paziente
	 * @uml.property  name="paziente"
	 */
	public void setPaziente(String paziente) {
		this.paziente = paziente;
	}
	
	@Override
	public String toString() {
		String referto = "";
		referto += "Referto ID: " + id + "\n";
		referto += "Prenotazione ID: " + prenotazione + "\n";
		referto += "Medico: " + medico + "\n";
		referto += "Paziente: " + paziente + "\n";
		referto += "Contenuto: " + contenuto;
		return (referto);
	}
	
	@Override
	public boolean equals(Object o) {
		if ((o != null) && (o instanceof Referto)) {
			Referto r = (Referto) o;
			return ((this.prenotazione == r.getPrenotazione()) &&
					(this.id == r.getId()) &&
					(this.contenuto.equals(r.getContenuto())) &&
					(this.medico.equals(r.getMedico())) &&
					(this.paziente.equals(r.getPaziente())));
		}
		return false;
	}
	
}