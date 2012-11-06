/* 
 * Paziente.java
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

public class Paziente implements Guest
{
	private String nomeutente;
	/**
	 * @uml.property  name="password"
	 */
	private String password;
	/**
	 * @uml.property  name="nome"
	 */
	private String nome;
	/**
	 * @uml.property  name="cognome"
	 */
	private String cognome;
	/**
	 * @uml.property  name="indirizzo"
	 */
	private String indirizzo;
	/**
	 * @uml.property  name="telefono"
	 */
	private String telefono;
	/**
	 * @uml.property  name="email"
	 */
	private String email;
	/**
	 * @uml.property  name="nascita"
	 */
	private Date   nascita;
	/**
	 * @uml.property  name="tutore"
	 */
	private String tutore;	
	/**
	 * @uml.property  name="calendario"
	 * @uml.associationEnd  
	 */
	private Calendario calendario;
	
	/**
	 * Costruttore di default
	 * (senza parametri)
	 */
	public Paziente() { }

	/**
	 * Costruttore di default (9 parametri)
	 * @param nomeutente - Username del paziente
	 * @param password   - Password del paziente
	 * @param nome       - Nome
	 * @param cognome    - Cognome
	 * @param indirizzo  - Indirizzo
	 * @param telefono   - Telefono
	 * @param email      - Email
	 * @param nascita    - Anno di nascita
	 * @param tutorep     - Tutore (questo campo vale NULL
	 *                     per i pazienti maggiorenni)
	 */
	public Paziente(String nomeutente, String password,	String nome, String cognome,
			String indirizzo, String telefono, String email, Date nascita, String tutore)
	{
		this.nomeutente = nomeutente;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.email = email;
		this.nascita = nascita;
		this.tutore = tutore;		
		this.calendario = new Calendario();
	}
	
	/**
	 * @return  Nome utente del paziente
	 * @uml.property  name="nomeutente"
	 */
	@Override
	public String getNomeutente() {
		return nomeutente;
	}
	
	/**
	 * @return  Password del paziente
	 * @uml.property  name="password"
	 */
	@Override
	public String getPassword() {
		return password;
	}
	
	/**
	 * @return  Nome del paziente
	 * @uml.property  name="nome"
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @return  Cognome del paziente
	 * @uml.property  name="cognome"
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * @return  Indirizzo del paziente
	 * @uml.property  name="indirizzo"
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	
	/**
	 * @return  Telefono del paziente
	 * @uml.property  name="telefono"
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * @return  Email del paziente
	 * @uml.property  name="email"
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @return  Data di nascita
	 * @uml.property  name="nascita"
	 */
	public Date getNascita() {
		return nascita;
	}
	
	/**
	 * @return  Tutore del paziente; vale NULL nel caso in   cui il paziente e' minorenne
	 * @uml.property  name="tutore"
	 */
	public String getTutore() {
		return tutore;
	}
	
	/**
	 * Imposta il nomeutente di un paziente
	 * @param nomeutente  - Nome utente
	 * @uml.property  name="nomeutente"
	 */
	@Override
	public void setNomeutente(String nomeutente) {
		this.nomeutente = nomeutente;
	}
	
	/**
	 * Imposta la password di un paziente
	 * @param password  - Password
	 * @uml.property  name="password"
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Imposta il nome del paziente
	 * @param nome  - Nome
	 * @uml.property  name="nome"
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Imposta il cognome del paziente
	 * @param cognome  - Cognome
	 * @uml.property  name="cognome"
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Imposta l'indirizzo del paziente
	 * @param indirizzo  - Indirizzo
	 * @uml.property  name="indirizzo"
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Imposta il telefono del paziente
	 * @param telefono  - Telefono
	 * @uml.property  name="telefono"
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Imposta l'email del paziente
	 * @param email  - Email
	 * @uml.property  name="email"
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Imposta la data di nascita
	 * @param nascita  - Data di nascita
	 * @uml.property  name="nascita"
	 */
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	
	
	/**
	 * Imposta un nuovo tutorep per il paziente
	 * @param  tutorep
	 * @uml.property  name="tutore"
	 */
	public void setTutore(String tutore) {
		this.tutore = tutore;
	}
	
	// ---
	
	/**
	 * Verifica se un paziente e' maggiorenne
	 * @return
	 *   TRUE se il paziente e' maggiorenne, FALSE altrimenti
	 */
	@SuppressWarnings("deprecation")
	public boolean isMajor() {
		return ((calendario.getYear() - (nascita.getYear() + 1900)) >= 18);
	}
	
	/**
	 * Verifica se un paziente e' minorenne
	 * @return
	 *   TRUE se il paziente e' minorenne, FALSE altrimenti
	 */
	public boolean isMinor() {
		return (!isMajor());
	}
	
	/**
	 * Due pazienti sono uguali se hanno tutti i campi uguali
	 * @return
	 *  TRUE se i due pazienti sono uguali, FALSE altrimenti;
	 */
	@Override
	public boolean equals(Object o) {
		if ((o != null) && (o instanceof Paziente)) {
			Paziente p = (Paziente) o;
			return ((p.getNomeutente().equals(getNomeutente())) && (p.getPassword().equals(getPassword())) &&
					(p.getNome().equals(getNome())) && (p.getCognome().equals(getCognome())));
		}
		
		return false;
	}
	
}
