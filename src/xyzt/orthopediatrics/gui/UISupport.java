/* 
 * UISupport.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics.gui;

import java.awt.EventQueue;
import java.awt.Window;
import javax.swing.JOptionPane;
import xyzt.orthopediatrics.Calendario;
import xyzt.orthopediatrics.Type;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.Tutore;

public class UISupport
{
	public static final int YES = JOptionPane.YES_OPTION;
	public static final int NO  = JOptionPane.NO_OPTION;
	
	public int confirmDialog(String message) {
		return (JOptionPane.showConfirmDialog(null, message,
				"Orthopediatrics", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE));
	}
	
	public void notifyDialog(String message) {
		JOptionPane.showConfirmDialog(null, message, 
				"Orthopediatrics", JOptionPane.CLOSED_OPTION,	JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void notifyDialogFreeDayAndClose() {
		String s = "";
		s += "Non e' possibile effettuare prenotazioni nei seguenti giorni e orari:\n";
		s += "Sabato e Domenica:\n";
		s += " dalle 14:00h alle 16:00h\n";
		s += " dalle 18:00h alle 20:00h\n";
		notifyDialog(s);
	}
	
	public void notifyDialogPrevReservationExists() {
		notifyDialog("La data e' occupata da un altra prenotazione\n");
	}
	
	public void notifyDialogReportSaved() {
		notifyDialog("Aggiunto nuovo referto!");
	}
	
	public void notifyDialogReportSavedERROR() {
		notifyDialog("Impossibile aggiungere il referto!");
	}
	
	public int closeDialog() {
		return confirmDialog("Sei sicuro di voler uscire dal programma?");
	}
	
	public void notifyDialogMessage(String msg) {
		notifyDialog(msg);
	}

	public void notifyDialogUserAlreadyExists() {
		notifyDialog("L'utente risulta gia' presente all'interno del sistema\n");
	}
	
	public void notifyDialogPasswordNotValid() {
		notifyDialog("Attenzione: la password inserita deve coincidere con la password confermata,\n" +
				"e deve avere una lunghezza minima di 6 caratteri");
	}
	
	public void notifyDialogPatient(Paziente paziente) {
		String str = "Dati personali del paziente\n";
		str += "\nNome: " + paziente.getNome();
		str += "\nCognome: " + paziente.getCognome();
		str += "\nIndirizzo: " + paziente.getIndirizzo();
		str += "\nData di Nascita: " + paziente.getNascita();
		str += "\nTelefono: " + paziente.getTelefono();
		str += "\nEmail: " + paziente.getEmail();
		if (paziente.getTutore() != null)
			str += "\nTutore: " + paziente.getTutore();
		notifyDialog(str);
	}
	
	public void notifyDialogErrorDateSelected() {
		notifyDialog("La data selezionata non deve essere antecedente a quella attuale!");
	}
	
	public void notifyDialogRequestReservation() {
		notifyDialog("Richiesta di prenotazione effettuata con successo!\n" +
				"Entro 24 ore ricevera' la notifica della prenotazione\n");
	}
	
	public void notifyDialogNoRequestsSelected() {
		notifyDialog("Nessuna richiesta di prenotazione selezionata");
	}
	
	public void notifyDialogTutorNoMajor() {
		notifyDialog("Il tutore non puo' essere minorenne");
	}
	
	public void notifyDialogCFNotValid() {
		notifyDialog("Il codice fiscale deve avere una lunghezza di 16 caratteri");
	}
	
	public void notifyDialogDateNotValid() {
		notifyDialog("Data di nascita non valida!\nFormato: gg-mm-aaaa");
	}	
	
	public void loginErrorAuthentication() {
		notifyDialog("Autenticazione non valida!");
	}
	
	public void notifyDialogNomeCognomeNotValid() {
		notifyDialog("Controllare nome/cognome!");
	}
	
	public void notifyDialogTelefonoNotValid() {
		notifyDialog("Numero di telefono non valido!");
	}
	
	public void notifyDialogEmailNotValid() {
		notifyDialog("Indirizzo email non valido!");
	}
	
	public int patientRegisteredDialog(Paziente paziente) {
		String str = "";
		str += "Registrazione del paziente avvenuta con successo!\n";
		str += "Si consiglia di conservare i seguenti dati in un luogo\n";
		str += "sicuro in quanto necessari per accedere al sistema:\n\n";
		str += "Username: " + paziente.getNomeutente() + "\n";
		str += "Password: " + paziente.getPassword() + "\n";
		return(JOptionPane.showConfirmDialog(null, str, "Orthopediatrics",
				JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE));
	}
	
	public int tutorRegisteredDialog(Tutore tutore) {
		String str = "";
		str += "Registrazione del tutore avvenuta con successo!\n";
		str += "Si consiglia di conservare i seguenti dati in un luogo\n";
		str += "sicuro in quanto necessari per accedere al sistema:\n\n";
		str += "Username: " + tutore.getNomeutente() + "\n";
		str += "Password: " + tutore.getPassword() + "\n";
		return(JOptionPane.showConfirmDialog(null, str, "Orthopediatrics",
				JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE));
	}
	
	public void notifyDialogReservationInfo(Prenotazione p) {
		String str = "";
		str += "ID: " + p.getId() + "\n";
		str += "Data: " + new Calendario().parse(p.getData()) + "\n";
		str += "Orario: " + p.getOra() + ":00h - " + (p.getOra() + 1) + ":00h" + "\n";
		str += "Paziente: " + p.getPaziente() + "\n";
		
		if (p.getPriorita() == Type.Priorita.GIALLO)
			str += "Priorita: GIALLO\n";
		else if (p.getPriorita() == Type.Priorita.VERDE)
			str += "Priorita: VERDE\n";
		else if (p.getPriorita() == Type.Priorita.ROSSO)
			str += "Priorita: ROSSO\n";
		if (p.getSala() == Type.Sala.A1)
			str += "Sala: Sala A1\n";
		else if (p.getSala() == Type.Sala.A2)
			str += "Sala: Sala A2\n";
		else if (p.getSala() == Type.Sala.B1)
			str += "Sala: Sala B1\n";
		else if (p.getSala() == Type.Sala.B2)
			str += "Sala: Sala B2";
		notifyDialog(str);
	}
	
	public void notifyDialogReservationNoReport() {
		notifyDialog("La prenotazione non dispone di un referto!");
	}
	
	public void notifyDialogReservationExistReport() {
		notifyDialog("La prenotazione dispone gia' di un referto!");
	}
	
	public void notifyDialogMoveRequestOK() {
		notifyDialog("Richiesta di spostamento della prenotazione inviata!");
	}
	
	public void notifyDialogMoveRequestERROR() {
		String s = "Error durante l'invio della richiesta di spostamento " +
				"della prenotazione.\nImpossibile inviare la richiesta!";
		notifyDialog(s);
	}
	
	public void notifyDialogNoReservationSelected() {
		notifyDialog("Nessuna prenotazione selezionata");
	}
	
	public void notifyDialogTutorNotValid(String tutorname) {
		notifyDialog("Il tutore '" + tutorname + "' non esiste!");
	}
	
	public void notifyDialogPriorityNotValid() {
		notifyDialog("Selezionare la priorita' da attribuire alla prenotazione");
	}
		
	public void notifyDialogReserveError() {
		notifyDialog("La prenotazione NON e' avvenuta a causa di un errore sconosciuto!");
	}
	
	public void notifyDialogRetireReservation() {
		notifyDialog("Richiesta di cancellazione della prenotazione inviata!");
	}
	
	public void notifyDialogRetireRequestERROR() {
		String s = "Error durante l'invio della richiesta di spostamento " +
				"della prenotazione.\nImpossibile inviare la richiesta!";
		notifyDialog(s);	}
	
	/**
	 * Visualizzazione di un frame.
	 * Puo' esistere un solo thread in esecuzione dedicato
	 * alla UserInterface per visualizzare le finestre
	 * @param w - Frame da visualizzare
	 */
	public void loadWindow(final Window w) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					w.setVisible(true);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
