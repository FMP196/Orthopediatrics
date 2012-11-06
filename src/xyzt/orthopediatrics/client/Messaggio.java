/* 
 * Messaggio.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics.client;

import java.sql.Date;
import xyzt.orthopediatrics.Calendario;
import xyzt.orthopediatrics.Type;

public class Messaggio
{
	private int tipo;
	private Date data;
	private String orario;
	private String mittente;
	private String destinatario;
	private String content;
	private int prenotazione;
	
	/**
	 * Costruttore di default
	 * (senza parametri)
	 */
	public Messaggio() { }

	/**
	 * Costruttore del messaggio
	 * @param tipo         - Tipo del messaggio (CONFERMA, SPOSTAMENTO, ... )
	 * @param mittente     - Mittente del messaggio
	 * @param destinatario - Destinatario del messaggio
	 * @param contenuto    - Contenuto del messaggio
	 */
	public Messaggio(int tipo, Date data, String orario, String mittente, String destinatario, String content, int prenotazione) {
		this.tipo = tipo;
		this.data = data;
		this.orario = orario;
		this.mittente = mittente;
		this.destinatario = destinatario;
		this.content = content;		
		this.prenotazione = prenotazione;
	}

	/**
	 * Costruttore del messaggio
	 * @param tipo         - Tipo del messaggio (CONFERMA, SPOSTAMENTO, ... )
	 * @param mittente     - Mittente del messaggio
	 * @param destinatario - Destinatario del messaggio
	 * @param contenuto    - Contenuto del messaggio
	 */
	public Messaggio(int tipo, String mittente, String destinatario, String content, int prenotazione) {
		this.tipo = tipo;
		this.data = new Calendario().getCurrentDate();
		this.orario = new Calendario().getCurrentTime();
		this.mittente = mittente;
		this.destinatario = destinatario;
		this.content = content;		
		this.prenotazione = prenotazione;
	}
	
	// -- GET
	
	/**
	 * @return  Tipo del messaggio
	 * @see  Types.Messaggio
	 * @uml.property  name="tipo"
	 */
	public int getTipo() {
		return tipo;
	}
	
	/**
	 * @return  Data di creazione del messaggio
	 * @uml.property  name="data"
	 */
	public Date getData() {
		return data;
	}
	
	/**
	 * @return  Orario di creazione
	 * @uml.property  name="orario"
	 */
	public String getOrario() {
		return orario;
	}
	
	/**
	 * @return  Mittente
	 * @uml.property  name="mittente"
	 */
	public String getMittente() {
		return mittente;
	}
	
	/**
	 * @return  Destinatario
	 * @uml.property  name="destinatario"
	 */
	public String getDestinatario() {
		return destinatario;
	}
	
	/**
	 * @return  Contenuto del messaggio
	 * @uml.property  name="content"
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * @return  ID di prenotazione
	 * @uml.property  name="prenotazione"
	 */
	public int getPrenotazione() {
		return prenotazione;
	}
	
	
	/**
	 * Imposta il tipo del messaggio
	 * @param tipo  - Tipo del messaggio
	 * @uml.property  name="tipo"
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Imposta la data di creazione del messaggio
	 * @param data  - Data di creazione
	 * @uml.property  name="data"
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
	/**
	 * Imposta l'orario di creazione
	 * @param orario  - Orario di creazione
	 * @uml.property  name="orario"
	 */
	public void setOrario(String orario) {
		this.orario = orario;
	}
	
	/**
	 * Imposta il mittente del messaggio
	 * @param mittente  - Mittente
	 * @uml.property  name="mittente"
	 */
	public void setMittente(String mittente) {
		this.mittente = mittente;
	}
	
	/**
	 * Imposta il destinatario del messaggio 
	 * @param destinatario  - Destinatario
	 * @uml.property  name="destinatario"
	 */
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	/**
	 * Imposta il contenuto del messaggio
	 * @param content  - Contenuto
	 * @uml.property  name="content"
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Imposta l'ID della prenotazione 
	 * @param prenotazione  - ID prenotazione
	 * @uml.property  name="prenotazione"
	 */
	public void setPrenotazione(int prenotazione) {
		this.prenotazione = prenotazione;
	}
	
	@Override
	public String toString() {
		String msg = "";
		switch (tipo) {
			case Type.Messaggio.CANCEL:   msg += " CANCEL"; break;
			case Type.Messaggio.CONFIRM:  msg += " CONFIRM"; break;
			case Type.Messaggio.POSTPONE: msg += " POSTPONE"; break;
			case Type.Messaggio.REQUEST:  msg += " REQUEST"; break;
			default: msg += "<UNKNOWN>";
		}
		msg += ": " + new Calendario().parse(data) + " alle ore " + orario + " ";
		return msg;
	}
	
	/**
	 * Due messaggi sono uguali se hanno tutti i campi uguali
	 * @return
	 *  TRUE se i due messaggi sono uguali, FALSE altrimenti;
	 */
	@Override
	public boolean equals(Object o) {
		if ((o != null) && (o instanceof Messaggio)) {
			Messaggio m = (Messaggio)o;
			return ((this.tipo == m.getTipo()) && 
					(this.prenotazione == m.getPrenotazione()) && 
					(this.mittente.equals(m.getMittente())) &&
					(this.destinatario.equals(m.getDestinatario())) &&
					(this.content.equals(m.getContent())));
		}
		return false;
	}
}
