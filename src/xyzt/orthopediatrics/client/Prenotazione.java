package xyzt.orthopediatrics.client;

import java.sql.Date;
import xyzt.orthopediatrics.Calendario;
import xyzt.orthopediatrics.Type;

public class Prenotazione
{	
	/**
	 * @uml.property  name="id"
	 */
	private int id;	
	/**
	 * @uml.property  name="ora"
	 */
	private int ora;
	/**
	 * @uml.property  name="data"
	 */
	private Date data;
	/**
	 * @uml.property  name="paziente"
	 */
	private String paziente;
	/**
	 * @uml.property  name="priorita"
	 */
	private int priorita;
	/**
	 * @uml.property  name="sala"
	 */
	private int sala;
	/**
	 * @uml.property  name="reparto"
	 */
	private int reparto;
	/**
	 * @uml.property  name="calendario"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Calendario calendario;
	
	/**
	 * Costruttore di default
	 * (senza parametri)
	 */
	public Prenotazione() {
		this.calendario = new Calendario();
	}
	
	/**
	 * Costruttore con parametri
	 * @param priorita - Priorita' della prenotazione
	 * @param medico   - Medico della visita
	 * @param data     - 
	 * @param ora      -
	 */
	public Prenotazione(int ora, Date data, String paziente, int priorita, int sala, int reparto) {
		this.ora = ora;
		this.data = data;
		this.paziente = paziente;
		this.priorita = priorita;
		this.sala = sala;
		this.reparto = reparto;
		this.id = createID();
		this.calendario = new Calendario();
	}
		
	// -- GET
	
	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return
	 * @uml.property  name="paziente"
	 */
	public String getPaziente() {
		return paziente;
	}
	
	/**
	 * @return
	 * @uml.property  name="priorita"
	 */
	public int getPriorita() {
		return priorita;
	}
	
	/**
	 * @return
	 * @uml.property  name="data"
	 */
	public Date getData() {
		return data;
	}
	
	/**
	 * @return
	 * @uml.property  name="ora"
	 */
	public int getOra() {
		return ora;
	}
	
	/**
	 * @return
	 * @uml.property  name="sala"
	 */
	public int getSala() {
		return sala;
	}
	
	/**
	 * @return
	 * @uml.property  name="reparto"
	 */
	public int getReparto() {
		return reparto;
	}
		
	// -- SET
	
	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @param paziente
	 * @uml.property  name="paziente"
	 */
	public void setPaziente(String paziente) {
		this.paziente = paziente;
	}
	
	/**
	 * @param priorita
	 * @uml.property  name="priorita"
	 */
	public void setPriorita(int priorita) {
		this.priorita = priorita;
	}
	
	/**
	 * @param ora
	 * @uml.property  name="ora"
	 */
	public void setOra(int ora) {
		this.ora = ora;
	}
	
	/**
	 * @param sala
	 * @uml.property  name="sala"
	 */
	public void setSala(int sala) {
		this.sala = sala;
	}
	
	/**
	 * @param data
	 * @uml.property  name="data"
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
	/**
	 * @param reparto
	 * @uml.property  name="reparto"
	 */
	public void setReparto(int reparto) {
		this.reparto = reparto;
	}
	
	
	/**
	 * Creazione di un identificativo per la prenotazione
	 * L'identificativo della prenotazione e' formato dalla
	 * concatenazione delle seguenti stringhe:
	 *  ID = <sala> + <ora> + <data>
	 * @return
	 *  Identificativo della prenotazione;
	 */
	@SuppressWarnings("deprecation")
	private int createID() {
		String ID = "" + data.getYear() + "" + (data.getMonth()+1) + 
				"" + data.getDate() + "" + ora + "" + sala;
		return (Integer.parseInt(ID));
	}
	
	@Override
	public String toString() {
		String prenotazione = "";		
		prenotazione += "Prenotazione n. " + id + ", ";
		prenotazione += "confermata per il giorno " + calendario.parse(data) + ", ";
		prenotazione += "alle ore " + ora + ":00, ";
		
		if (sala == Type.Sala.A1)
			prenotazione += "in Sala A1, ";
		else if (sala == Type.Sala.A2)
			prenotazione += "in Sala A2, ";
		else if (sala == Type.Sala.B1)
			prenotazione += "in Sala B1, ";
		else if (sala == Type.Sala.B2)
			prenotazione += "in Sala B2, ";
		
		if ((sala == Type.Sala.A1) || (sala == Type.Sala.A2))
			prenotazione += "reparto di Ortopedia";
		else if ((sala == Type.Sala.B1) || (sala == Type.Sala.B2))
			prenotazione += "reparto di Pediatria";
		
		return (prenotazione);
	}
	
	
	/**
	 * Due prenotazioni sono uguali solo se hanno lo stesso
	 * codice identificativo
	 */
	@Override
	public boolean equals(Object o) {
		if ((o != null) && (o instanceof Prenotazione))
		{
			Prenotazione p = (Prenotazione) o;
			return ((p.getId() == id) && (p.getOra() == p.getOra()) && (p.getSala() == sala) &&
					(p.getData().equals(data)) && (p.getPriorita() == priorita) && 
					(p.getReparto() == reparto) && (p.getPaziente().equals(paziente)));
		}
		
		return false;
	}
}
