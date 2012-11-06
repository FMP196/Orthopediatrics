package xyzt.orthopediatrics.client;

import java.sql.Date;

public class Tutore implements Guest
{
	/**
	 * @uml.property  name="nomeutente"
	 */
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
	 * @uml.property  name="logged"
	 */
	private boolean logged;

	public Tutore() { }
	
	/**
	 * Costruttore di default (9 parametri)
	 * @param nomeutente - Username del tutore
	 * @param password   - Password del tutore
	 * @param nome       - Nome
	 * @param cognome    - Cognome
	 * @param indirizzo  - Indirizzo
	 * @param telefono   - Telefono
	 * @param email      - Email
	 * @param nascita    - Data di nascita
	 */
	public Tutore(String nomeutente, String password,	String nome, String cognome,
			String indirizzo, String telefono, String email, Date nascita)
	{
		this.nomeutente = nomeutente;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.email = email;
		this.nascita = nascita;		
		this.logged = false;
	}
	
	// -- GET
	
	/**
	 * @return  Nome utente del tutore
	 * @uml.property  name="nomeutente"
	 */
	public String getNomeutente() {
		return nomeutente;
	}
	
	/**
	 * @return  Password del tutore
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @return  Nome del tutore
	 * @uml.property  name="nome"
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @return  Cognome del tutore
	 * @uml.property  name="cognome"
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * @return  Indirizzo del tutore
	 * @uml.property  name="indirizzo"
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	
	/**
	 * @return  Telefono del tutore
	 * @uml.property  name="telefono"
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * @return  Email del tutore
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
	 * @return
	 *   Stato in cui si trova il tutore all'interno
	 *   del sistema (TRUE loggato, FALSE altrimenti)
	 */
	public boolean getLogged() {
		return logged;
	}
	
	// -- SET
	
	/**
	 * Imposta il nomeutente di un tutore
	 * @param nomeutente  - Nome utente
	 * @uml.property  name="nomeutente"
	 */
	public void setNomeutente(String nomeutente) {
		this.nomeutente = nomeutente;
	}
	
	/**
	 * Imposta la password di un tutore
	 * @param password  - Password
	 * @uml.property  name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Imposta il nome del tutore
	 * @param nome  - Nome
	 * @uml.property  name="nome"
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Imposta il cognome del tutore
	 * @param cognome  - Cognome
	 * @uml.property  name="cognome"
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Imposta l'indirizzo del tutore
	 * @param indirizzo  - Indirizzo
	 * @uml.property  name="indirizzo"
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Imposta il telefono del tutore
	 * @param telefono  - Telefono
	 * @uml.property  name="telefono"
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Imposta l'email del tutore
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
	 * Imposta lo stato del tutore all'interno di un sistema: LOGGED = {true, false}
	 * @param logged  - Stato
	 * @uml.property  name="logged"
	 */
	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	
	/**
	 * Due tutori sono uguali se hanno tutti i campi uguali
	 * @return
	 *  TRUE se i due tutori sono uguali, FALSE altrimenti;
	 */
	@Override
	public boolean equals(Object o) {
		if ((o != null) && (o instanceof Tutore)) {
			Tutore p = (Tutore) o;
			return ((p.getNome().equals(nome)) && (p.getCognome().equals(cognome)) &&
				(p.getNomeutente().equals(nomeutente)) && (p.getPassword().equals(password)) &&
				(p.getNascita().equals(nascita)) && (p.getTelefono().equals(telefono)) &&
				(p.getEmail().equals(email)) && (p.getIndirizzo().equals(indirizzo)));
		}
		
		return false;
	}
	
}
