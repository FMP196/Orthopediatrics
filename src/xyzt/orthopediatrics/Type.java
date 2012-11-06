/* 
 * Type.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics;

/**
 * Modulo contenente tutti i tipi utilizzati 
 * nel sistema
 */
public class Type
{
	/**
	 * Utenti del sistema
	 */
	public static class User
	{
		public static final int PATIENT = 0;
		public static final int TUTOR   = 1;
		public static final int ADMIN   = 2;
	}
	
	/**
	 * Priorita' della visita
	 */
	public static class Priorita
	{
		public static final int VERDE  = 0;
		public static final int GIALLO = 1;
		public static final int ROSSO  = 2;
	}
	
	/**
	 * Reparto (Ortopedia, Pediatria)
	 */
	public static class Reparto
	{
		public static final int ORTOPEDIA = 0;
		public static final int PEDIATRIA = 1;
	}
	
	/**
	 * Messaggi che si scambiano gli utenti all'interno
	 * del sistema
	 */
	public static class Messaggio
	{
		public static final int REQUEST  = 0;
		public static final int CONFIRM  = 1;
		public static final int CANCEL   = 2;
		public static final int POSTPONE = 3;
	}
	
	/**
	 * Sale a disposizione in cui avvengono le visite
	 */
	public static class Sala
	{
		public static final int A1 = 0;
		public static final int A2 = 1;
		public static final int B1 = 2;
		public static final int B2 = 3;
	}
}
