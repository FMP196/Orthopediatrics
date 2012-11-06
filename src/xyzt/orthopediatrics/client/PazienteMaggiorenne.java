package xyzt.orthopediatrics.client;

import java.sql.Date;

public class PazienteMaggiorenne extends Paziente
{ 
	public PazienteMaggiorenne(String nomeutente, String password, String nome,
			String cognome, String indirizzo, String telefono, String email,
			Date nascita, String tutore)
	{
		super(nomeutente, password, nome, cognome, indirizzo, telefono,
				email, nascita, null);
	}

}