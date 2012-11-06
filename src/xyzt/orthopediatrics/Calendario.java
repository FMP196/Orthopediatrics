/* 
 * Calendario.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendario
{
	private String[] month;
	private String[] week;
	private GregorianCalendar calendar;
		
	/**
	 * Inizializzazione del calendario.
	 */
	public Calendario() {
		calendar = new GregorianCalendar();
		month = new String[] {
				"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", 
				"Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
		week = new String[] {
				"Domenica", "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato"};
	}
	
	/**
	 * @return
	 *   Giorno del mese
	 */
	public int getDay() {
		return calendar.get(Calendar.DATE);
	}
	
	/**
	 * @return
	 *   Mese dell'anno.
	 */
	public String getMonth() {
		return month[calendar.get(Calendar.MONTH)];
	}
	
	/**
	 * @return
	 *  Il nome del mese dell'anno
	 */
	public String getMonthStr(int m) {
		return month[m];
	}
	
	/**
	 * @return
	 *  Nome del giorno di settimana
	 */
	public String getWeekStr(int weekday) {
		return week[weekday];
	}
	
	/**
	 * @return
	 *   Mese dell'anno sotto forma di numero.
	 */
	public int getMonthInt() {
		return calendar.get(Calendar.MONTH);
	}
	
	/**
	 * @return
	 *   Anno corrente
	 */
	public int getYear() {
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * @return
	 *   Giorno della settimana (Lunedi, Martedi, ...)
	 */
	public String getWeekDay() {
		return week[calendar.get(Calendar.DAY_OF_WEEK)-1];
	}

	/**
	 * Estrazione del numero di giorni in uno specifico mese
	 * dell'anno.
	 * @param month - Mese (partenza da 0)
	 * @param year  - Anno
	 * @return
	 *  Restituisce il numero di giorni in un mese;
	 *  -1 in caso di errore;
	 */
	public int getDaysInMonth(int month, int year) {
		int days = -1;
		switch (month) {
			case 0:  // GENNAIO
			case 2:  // MARZO
			case 4:  // MAGGIO
			case 6:  // LUGLIO
			case 7:  // AGOSTO
			case 9:  // OTTOBRE
			case 11: // DICEMBRE
				days = 31;
				break;
				
			case 1: // FEBBRAIO
				if (calendar.isLeapYear(year))
					days = 29;
				else
					days = 28;
				break;
				
			case 3: // APRILE
			case 5: // GIUGNO
			case 8: // SETTEMBRE
			case 10: // NOVEMBRE
				days = 30;
				break;

			default:
				days = -1;
				break;
		}
		
		return days;
	}
	
	/**
	 * @return
	 *  Data corrente secondo il formato SQL Data
	 */
	@SuppressWarnings("deprecation")
	public Date getCurrentDate() {
		int year = getYear();
		int month = getMonthInt();
		int day = getDay();
		return new Date(year, month, day);
	}
	
	/**
	 * @return
	 *  Stringa contenente l'orario corrente secondo 
	 *  il seguente formato: "hh:mm:ss"
	 */
	@SuppressWarnings("deprecation")
	public String getCurrentTime() {
		int hh = calendar.getTime().getHours();
		int mm = calendar.getTime().getMinutes();
		int ss = calendar.getTime().getSeconds();
		return (hh+":"+mm+":"+ss);
	}
	
	/**
	 * Trasforma la data in una stringa
	 * @param data - Data
	 * @return
	 *  Stringa contenente la data corrente nel seguente formato
	 *  "5 maggio 2012"
	 */
	@SuppressWarnings("deprecation")
	public String parse(Date data) {
		int gg = data.getDate();
		int mm = data.getMonth();
		int aa = data.getYear();
		return (gg + " " + month[mm] + " " + aa);
	}
	
	/**
	 * @return
	 *  Data corrente in forma di stringa
	 */
	@Override
	public String toString() {
		String str =
				" " + getWeekDay() +
				" " + getDay() +
				" " + getMonth() +
				" " + getYear();
		return str;
	}
}
