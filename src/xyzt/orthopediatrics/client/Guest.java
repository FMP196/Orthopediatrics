/* 
 * Guest.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics.client;

public interface Guest
{	
	/**
	 * @return Password dell'utente
	 */
	public String getPassword();
	
	/**
	 * @return Username dell'utente
	 */
	public String getNomeutente();
	
		
	/**
	 * Imposta il nomeutente dell'utente
	 * @param nomeutente - Nomeutente
	 */
	public void setNomeutente(String nomeutente);
	
	/**
	 * Imposta la password dell'utente
	 * @param password - Password dell'utente
	 */
	public void setPassword(String password);
}
