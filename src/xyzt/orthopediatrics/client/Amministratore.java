/* 
 * Amministratore.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics.client;

public class Amministratore implements Guest
{
	private String nomeutente;
	private String password;
	private int reparto;
		
	/**
	 * Costruttore di default (senza parametri)
	 */
	public Amministratore() { }
	
	/**
	 * Costruttore con parametri
	 * @param reparto    - Riferimento al reparto (ORTOPEDIA, PEDIATRIA)
	 * @param nomeutente - Nomeutente dell'amministratore
	 * @param password   - Password dell'amministratore
	 */
	public Amministratore(int reparto, String nomeutente, String password) {
		this.reparto = reparto;
		this.nomeutente = nomeutente;
		this.password = password;
	}
	
	/**
	 * Ottenimento del reparto a cui appartiene l'amministratore
	 * @return  Reparto di appartenenza dell'amministratore.
	 * @uml.property  name="reparto"
	 */
	public int getReparto() {
		return reparto;
	}
	
	/**
	 * @return
	 * @uml.property  name="password"
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 * @uml.property  name="nomeutente"
	 */
	@Override
	public String getNomeutente() {
		return nomeutente;
	}

	/**
	 * @param nomeutente
	 * @uml.property  name="nomeutente"
	 */
	@Override
	public void setNomeutente(String nomeutente) {
		this.nomeutente = nomeutente;
	}

	/**
	 * @param password
	 * @uml.property  name="password"
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Imposta il reparto di appartenenza dell'amministratore
	 * @param reparto  - Reparto dell'amministratore
	 * @uml.property  name="reparto"
	 */
	public void setReparto(int reparto) {
		this.reparto = reparto;
	}
	
	@Override
	public boolean equals(Object o) {
		if ((o != null) && (o instanceof Amministratore)) {
			Amministratore admin = (Amministratore) o;
			return ((admin.getNomeutente().equals(nomeutente)) &&
					(admin.getPassword().equals(password)) &&
					(admin.getReparto() == reparto));
		}
		return false;
	}
}
