/* 
 * Main.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */


package xyzt.orthopediatrics;

import xyzt.orthopediatrics.client.db.Database;
import xyzt.orthopediatrics.gui.ClientUI;
import xyzt.orthopediatrics.gui.UISupport;

public class Main {
	public static void main(String[] args)
	{
		Database database = new Database();
		
		/* Controllo sull'esistenza del database
		 */	
		if (database.existsDatabase() == false)
		{
			String s = "Attenzione!\n";
			s += "Si e' verificato un errore durante l'accesso al database\n";
			s += "Il database a cui si tenta di accedere non esiste.\n";
			s += "Si desidera creare il database ?";
			
			if ((new UISupport().confirmDialog(s)) == UISupport.YES) {
				if ((database.createDatabase()) == true) {
					String str = "Database creato con successo. E' necessario riavviare l'applicazione!";
					new UISupport().notifyDialog(str);
				}
				else {
					String str = "Errore durante la creazione del database!";
					new UISupport().notifyDialog(str);
				}
			}
			
			System.exit(1);
		}
		
		new UISupport().loadWindow(new ClientUI(database));		
	}
}
