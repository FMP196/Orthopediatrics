/* 
 * CalendarioUI.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics.gui;

import xyzt.orthopediatrics.Calendario;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.creator.CAmministratore;
import xyzt.orthopediatrics.client.db.Database;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.util.LinkedList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import xyzt.orthopediatrics.Type.Messaggio;

@SuppressWarnings("unused")
public class CalendarioUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPanel contentPane;
	/**
	 * @uml.property  name="table"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTable table;
	/**
	 * @uml.property  name="scrollPane"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JScrollPane scrollPane;
	/**
	 * @uml.property  name="separator"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JSeparator separator;
	/**
	 * @uml.property  name="btnNext"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnNext;
	/**
	 * @uml.property  name="btnPrev"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnPrev;
	/**
	 * @uml.property  name="btnConferma"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnConferma;
	/**
	 * @uml.property  name="btnInfo"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnInfo;
	/**
	 * @uml.property  name="btnCancella"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnCancella;
	/**
	 * @uml.property  name="btnSposta"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnSposta;
	/**
	 * @uml.property  name="lblGiorno"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblGiorno;
	/**
	 * @uml.property  name="lblCurrentDate"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblCurrentDate;
	/**
	 * @uml.property  name="tableModel"
	 * @uml.associationEnd  readOnly="true"
	 */
	private DefaultTableModel tableModel;

	/**
	 * @uml.property  name="calendario"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Calendario calendario;
	/**
	 * @uml.property  name="adminManager"
	 * @uml.associationEnd  readOnly="true"
	 */
	private CAmministratore adminManager;
	/**
	 * @uml.property  name="pList"
	 */
	private LinkedList<Prenotazione> pList;
	/**
	 * @uml.property  name="startDate"
	 */
	private Date startDate;
	/**
	 * @uml.property  name="endDate"
	 */
	private Date endDate;
	/**
	 * @uml.property  name="currentDate"
	 */
	private Date currentDate;
	
	/**
	 * @uml.property  name="sPOSTAMENTO"
	 */
	private boolean SPOSTAMENTO;
	/**
	 * @uml.property  name="weekday" multiplicity="(0 -1)" dimension="1"
	 */
	private String[] weekday;
	/**
	 * @uml.property  name="tableCurrentValue"
	 */
	private String tableCurrentValue;
	/**
	 * @uml.property  name="tableCurrentRow"
	 */
	private int tableCurrentRow;
	/**
	 * @uml.property  name="tableCurrentColumn"
	 */
	private int tableCurrentColumn;
	/**
	 * @uml.property  name="year"
	 */
	private int year;
	/**
	 * @uml.property  name="month"
	 */
	private int month;
	/**
	 * @uml.property  name="day"
	 */
	private int day;
	private boolean actionPerformed = false;
	private int typeOfMessage;
	private int sala;

	@SuppressWarnings("deprecation")
	public CalendarioUI(final AdminUI adminUI, final int reparto, final int sala, final int priorita, final Paziente paziente, final Database database, final int typeOfMessage)
	{		
		this.typeOfMessage = typeOfMessage;
		this.sala = sala;
		
		this.addWindowListener(new WindowListener() {
			@Override public void windowOpened(WindowEvent e) {}
			@Override public void windowIconified(WindowEvent e) {}
			@Override public void windowDeiconified(WindowEvent e) {}
			@Override public void windowDeactivated(WindowEvent e) {}
			@Override public void windowActivated(WindowEvent e) {}
			@Override public void windowClosed(WindowEvent e) {
				if (actionPerformed)
					adminUI.deleteMessage();
				adminUI.closedCalendar();
				if (actionPerformed == true) {
					adminUI.restorePriority();
					adminUI.restorePatient();
				}
			}
			@Override public void windowClosing(WindowEvent e) {
				if (actionPerformed)
					adminUI.deleteMessage();
				adminUI.closedCalendar();
				if (actionPerformed == true) {
					adminUI.restorePriority();
					adminUI.restorePatient();
				}
			}
		});
		
		setTitle("Orthopediatrics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalendarioUI.class.getResource("/resources/icons/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 997, 434);
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), new TitledBorder(new LineBorder(
				new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		separator = new JSeparator();

		lblGiorno = new JLabel("");
		lblGiorno.setIcon(new ImageIcon(CalendarioUI.class.getResource("/resources/icons/icon-small.png")));
		
		btnNext = new JButton(">");
		btnPrev = new JButton("<");

		btnConferma = new JButton("Conferma");
		btnConferma.setIcon(new ImageIcon(CalendarioUI.class.getResource("/resources/icons/confirm.png")));
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Dialog", Font.PLAIN, 12));
		table.setCellSelectionEnabled(true);
		
		btnInfo = new JButton("Info");
		btnInfo.setIcon(new ImageIcon(CalendarioUI.class.getResource("/resources/icons/prenotazione.png")));
		
		/* Inserimento del titolo della finestra; viene visualizzato il
		 * 'reparto' e la 'sala' di cui il calendario fa riferimento
		 */
		String titolo = "<html>";
		titolo += "Calendario delle prenotazioni settimanali<br>\n";
		if (reparto == xyzt.orthopediatrics.Type.Reparto.ORTOPEDIA ) {
			titolo += "Reparto di Ortopedia, ";
			if (sala == xyzt.orthopediatrics.Type.Sala.A1)
				titolo += " Sala A1";
			else if (sala == xyzt.orthopediatrics.Type.Sala.A2)
				titolo += " Sala A2";
		}
		else {
			titolo += "Reparto di Pediatria, ";
			if (sala == xyzt.orthopediatrics.Type.Sala.B1)
				titolo += " Sala B1";
			else if (sala == xyzt.orthopediatrics.Type.Sala.B2)
				titolo += " Sala B2";
		}		
		titolo += "</html>";
		lblGiorno.setText(titolo);
		
		btnCancella = new JButton("Cancella");
		btnCancella.setIcon(new ImageIcon(CalendarioUI.class.getResource("/resources/icons/delete.png")));
		
		btnSposta = new JButton("Sposta");
		btnSposta.setIcon(new ImageIcon(CalendarioUI.class.getResource("/resources/icons/move.png")));
		
		lblCurrentDate = new JLabel("...");
		lblCurrentDate.setFont(new Font("Dialog", Font.BOLD, 14));
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addComponent(lblGiorno, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
		.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
		.addComponent(lblCurrentDate).addGap(80))))
		.addGroup(gl_contentPane.createSequentialGroup()
		.addComponent(btnInfo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(btnCancella, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(btnSposta, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
		.addComponent(btnConferma))
		.addComponent(separator, GroupLayout.PREFERRED_SIZE, 949, Short.MAX_VALUE)
		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE))
		.addContainerGap()));
		
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
		.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addComponent(lblGiorno).addGroup(gl_contentPane.createSequentialGroup()
		.addComponent(lblCurrentDate).addGap(18)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(separator, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(btnConferma, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
		.addComponent(btnInfo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
		.addComponent(btnCancella, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
		.addComponent(btnSposta, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
		.addContainerGap()));
		
		contentPane.setLayout(gl_contentPane);

		// ****************************************************************************************************** //
		
		calendario = new Calendario();
		tableModel = new DefaultTableModel();
		adminManager = new CAmministratore(database);
		pList = new LinkedList<Prenotazione>();
		
		/* giorni della settimana
		 */
		weekday = new String[]{"Sab", "Dom", "Lun", "Mar", "Mer", "Gio", "Ven"};
		
		/* CARICAMENTO ORARIO NELLA TABELLA */
		String[] orario = new String[]{
				"08:00h - 09:00h", "09:00h - 10:00h", "10:00h - 11:00h", "11:00h - 12:00h",
				"12:00h - 13:00h", "13:00h - 14:00h", "14:00h - 15:00h", "15:00h - 16:00h",
				"16:00h - 17:00h", "17:00h - 18:00h",	"18:00h - 19:00h", "19:00h - 20:00h"
		};
		tableModel.addColumn("Orario", orario);		
		table.setModel(tableModel);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		/* indica che attualmente non ci sono operazioni di spostamento
		 * in corso
		 */
		SPOSTAMENTO = false;
		
		/* inizializzazione della data corrente
		 */
		year = calendario.getYear();
		month = calendario.getMonthInt();
		day = calendario.getDay();
		currentDate = new Date(year, month, day);
		
		/* caricamento delle prenotazioni sul calendario
		 */
		loadAllReservations(year, month, sala);
		
		/* in base al tipo di richiesta vengono abilitati/disabilitati
		 * i pulsanti corrispondenti all'azione predefinita
		 */
		switch (typeOfMessage) {
			case Messaggio.CANCEL:
				btnConferma.setEnabled(false);
				btnSposta.setEnabled(false);
				break;
			
			case Messaggio.POSTPONE:
				btnConferma.setEnabled(false);
				btnCancella.setEnabled(false);
				break;
			
			case Messaggio.REQUEST:
				btnSposta.setEnabled(false);
				btnCancella.setEnabled(false);
				break;
				
			default:
				return;
		}
		
		/**
		 * Visualizzazione delle prenotazioni del mese successivo
		 */
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (month < 10) {
					month = month + 1;
					loadAllReservations(year, month, sala);
				}
			}
		});
		
		/**
		 * Visualizzazione delle prenotazioni del mese precedente
		 */
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (month > 1) {
					month = month - 1;
					loadAllReservations(year, month, sala);
				}
			}
		});
		
		/**
		 * CONFERMA
		 * Conferma della prenotazione
		 */
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveReservation(paziente, priorita, sala, reparto);
			}
		});
		
		/**
		 * INFO
		 * Ottenimento informazioni sulla prenotazione
		 */
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = getTableSelectedValue();
				if (value != null) {
					int idPrenotazione = Integer.parseInt(value);
					Prenotazione prenotazione = database.getReservation(idPrenotazione);
					if (prenotazione != null)
						new UISupport().notifyDialogReservationInfo(prenotazione);
				}
				else
					new UISupport().notifyDialogNoReservationSelected();
			}
		});
		
		/**
		 * CANCELLAZIONE
		 * Cancellazione di una prenotazione
		 */
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = getTableSelectedValue();
				if (value != null) {
					int idPrenotazione = Integer.parseInt(value);
					Prenotazione prenotazione = database.getReservation(idPrenotazione);
					if ((adminManager.retireReservation(prenotazione)) == true) {
						loadAllReservations();
						btnCancella.setEnabled(false);
					}
					else
						new UISupport().notifyDialog("Errore durante la cancellazione della prenotazione");
				}
				else
					new UISupport().notifyDialogNoReservationSelected();
			}
		});
		
		/**
		 * SPOSTAMENTO
		 * Spostamento di una prenotazione
		 */
		btnSposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SPOSTAMENTO = true;
				tableCurrentRow = table.getSelectedRow();
				tableCurrentColumn = table.getSelectedColumn();
				tableCurrentValue = getTableSelectedValue();
			}
		});
		
		
		/**
		 * ONCLICK CELLA
		 * Ogni qualvolta si seleziona una cella si verifica se
		 * la scelta coinvolge un operazione di spostamento
		 */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SPOSTAMENTO == true) {
					if (tableCurrentValue != null) {
						String newValue = getTableSelectedValue();
						if (newValue == null)
						{
							/* il sabato e la domenica non e' possibile effettuare prenotazioni
							 * nei seguenti orari: dalle 12:00 alle 14:00 e dalle 18:00 alle 20:00
							 */
							if ((isFreeDay(getSelectedDate())) && (isClose(getTableSelectedHour())))
								new UISupport().notifyDialogFreeDayAndClose();
							else {
								int idPrenotazione = Integer.parseInt(tableCurrentValue);
								Prenotazione prenotazione = database.getReservation(idPrenotazione);
								Date now = getSelectedDate();
								
								if ((now.after(prenotazione.getData()))||(now.equals(prenotazione.getData()) && (prenotazione.getOra()<getTableSelectedHour()))) {
									adminManager.postponeReservation(prenotazione, now, getTableSelectedHour());
									loadAllReservations();
								}
								else
									new UISupport().notifyDialogErrorDateSelected();
							}
						}
						else
							new UISupport().notifyDialogPrevReservationExists();
					}
				}
				SPOSTAMENTO = false;
			}
		});
	}
	
	
	
	/**
	 * Caricamento delle prenotazioni all'interno del calendario
	 */
	@SuppressWarnings("deprecation")
	private void loadAllReservations(int year, int month, int sala)
	{
		int daysInMonth;
		String currentDateView;		
		
		/* cancellazione delle colonne della tabella
		 * (lascio la colonna a sinistra che indica l'ora)
		 */
		tableModel.setColumnCount(1);
		
		/* visualizzazione della data a cui le prenotazioni sul calendario
		 * fanno riferimento
		 */
		currentDateView = calendario.getMonthStr(month) + " " + year;
		lblCurrentDate.setText(currentDateView);
		
		daysInMonth = calendario.getDaysInMonth(month, year);
		
		btnNext.setText(calendario.getMonthStr(month + 1) + " >>");
		btnPrev.setText("<< " + calendario.getMonthStr(month - 1));
	
		/* ottengo le prenotazioni di tutto il mese corrente
		 * dal 1° all'ultimo giorno
		 */
		startDate = new Date(year, month, 0);
		endDate = new Date(year, month, (daysInMonth + 1));		
		pList = adminManager.getOccupiedMonthSlots(startDate, endDate, sala);
		
		/* popolazione della tabella con tutti i giorni del mese
		 */
		for (int i=1; i<=daysInMonth; i++) {
			Date d = new Date(year, month, i);
			tableModel.addColumn(weekday[d.getDay()] + " " + i);
		}

		/* Visualizzazione delle prenotazioni all'interno
		 * della tabella
		 */
		for (Prenotazione p : pList) {
			String ID = "" + p.getId();
			int giorno = (p.getData().getDate());
			int ora = (p.getOra() - 8);
			
			if (p.getSala() == sala) {
				tableModel.setValueAt(ID, ora, giorno);
			
				/* ogni qualvolta che una cella e' occupata in quanto e' presente
				 * una prenotazione, allora tale cella viene allargata in modo da
				 * visualizzare il proprio contenuto
				 */
				table.getColumnModel().getColumn(p.getData().getDate()).setPreferredWidth(90);
			}
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	private void loadAllReservations() {
		actionPerformed = true;
		table.removeAll();
		loadAllReservations(year, month, sala);
	}
	
	
	/**
	 * Salvataggio di una nuova prenotazione
	 */
	private void saveReservation(Paziente paziente, int priorita, int sala, int reparto)
	{
		if (getTableSelectedDay() > 0)
		{
			/* controllo che la data selezionata NON sia antecedente a quella
			 * attuale
			 */
			if (getSelectedDate().after(currentDate))
			{
				/* il sabato e la domenica non e' possibile effettuare prenotazioni
				 * nei seguenti orari: dalle 12:00 alle 14:00, dalle 18:00 alle 20:00
				 */
				if ((isFreeDay(getSelectedDate())) && (isClose(getTableSelectedHour())))
					new UISupport().notifyDialogFreeDayAndClose();
				else {
					Prenotazione prenotazione = new Prenotazione(getTableSelectedHour(), getSelectedDate(),
							paziente.getNomeutente(),priorita, sala, reparto);
				if ((adminManager.reserve(prenotazione)) == true) {
					btnConferma.setEnabled(false);
					loadAllReservations();
				} else
					new UISupport().notifyDialogReserveError();
				}
			}
			else
				new UISupport().notifyDialogErrorDateSelected();
		}
		else
			new UISupport().notifyDialog("La data selezionata non e' valida!");
	}
	
	/**
	 * In base alla cella selezionata nella tabella viene estratto
	 * il giorno di riferimento
	 */
	@SuppressWarnings("deprecation")
	private Date getSelectedDate() {
		int col = table.getSelectedColumn();
		return new Date(year, month, col);
	}
	
	/**
	 * Verifica se un determinato giorno cade di sabato
	 * o di domenica
	 */
	@SuppressWarnings("deprecation")
	private boolean isFreeDay(Date date) {
		return ((date.getDay() == 0) || (date.getDay() == 1));
	}
	
	/**
	 * Si verifica se l'orario selezionato per la prenotazione
	 * sia un intervallo dell'orario in cui la clinica rimane
	 * chiusa
	 */
	private boolean isClose(int orario) {
		return (((orario >= 14) && (orario <= 15)) ||
				((orario >= 18) && (orario <= 19)));
	}
	
	/**
	 * Estrazione di un valore dalla tabella
	 * @return Il valore estratto, NULL altrimenti
	 */
	private String getTableSelectedValue() {
		int col = table.getSelectedColumn();
		int row = table.getSelectedRow();
		if (col > 0)
			return (String) table.getValueAt(row, col);
		return null;
	}
	
	/**
	 * @return
	 *  Ora selezionata
	 */
	private int getTableSelectedHour() {
		return table.getSelectedRow() + 8;
	}
	
	/**
	 * @return
	 *  Giorno selezionato
	 */
	private int getTableSelectedDay() {
		int day = table.getSelectedColumn();
		if (day > 0)
			return day;
		return -1;
	}
}
