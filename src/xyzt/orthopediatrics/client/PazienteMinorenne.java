package xyzt.orthopediatrics.client;

import java.sql.Date;

public class PazienteMinorenne extends Paziente
{
	
	public PazienteMinorenne(String nomeutente, String password,
			String nome, String cognome, String indirizzo, String telefono,
			String email, Date nascita, String tutore)
	{
		super(nomeutente, password, nome, cognome, indirizzo, telefono,
				email, nascita, tutore);
	}
	
	/**
	 * Ogni paziente minorenne dispone di un tutore; questo deve essere
	 * creato al momento in cui avviene la creazione anche del paziente 
	 * minorenne
	 * @param nomeutente - Nomeutente del tutore
	 * @param password   - Password del tutore
	 * @param nome       - Nome del tutore
	 * @param cognome    - Cognome
	 * @param indirizzo  - Indirizzo (via, n. civico, cap, ...)
	 * @param telefono   - Numero di telefono
	 * @param email      - Indirizzo email
	 * @param nascita    - Data di nascita
	 * @return
	 */
	public Tutore createTutor(String nomeutente, String password, String nome, String cognome,
			String indirizzo, String telefono, String email, Date nascita)
	{
		return new Tutore(nomeutente, password, nome, cognome, indirizzo,
				telefono, email, nascita);
	}
}
