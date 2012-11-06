/* 
 * PatientUI.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.creator.CPaziente;
import xyzt.orthopediatrics.client.db.Database;
import xyzt.orthopediatrics.gui.PrenotazioneUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class PatientUI extends JFrame
{
	// List
	/**
	 * @uml.property  name="list"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JList list;
	
	// Buttons
	/**
	 * @uml.property  name="btnSposta"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnSposta;
	/**
	 * @uml.property  name="btnChiudi"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnChiudi;
	/**
	 * @uml.property  name="btnPrenota"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnPrenota;
	/**
	 * @uml.property  name="btnVisualizzaReferto"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnVisualizzaReferto;
	/**
	 * @uml.property  name="btnCancella"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnCancella;
	
	// Panels
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel contentPane;
	
	// Menu
	/**
	 * @uml.property  name="menuBar"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuBar menuBar;
	/**
	 * @uml.property  name="mnFile"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenu mnFile;
	
	// Lables
	/**
	 * @uml.property  name="lblOrthopediatrics"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblOrthopediatrics;
	/**
	 * @uml.property  name="lblselezionaIlReparto"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblselezionaIlReparto;
	
	//Frame
	/**
	 * @uml.property  name="framePrenotazioni"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JInternalFrame framePrenotazioni;
	/**
	 * @uml.property  name="internalFrame"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JInternalFrame internalFrame;
	
	//Others
	/**
	 * @uml.property  name="model"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	private DefaultListModel model;
	/**
	 * @uml.property  name="scrollPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane;
	/**
	 * @uml.property  name="cmbReparto"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JComboBox cmbReparto;
	
	/**
	 * @uml.property  name="patientManager"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private CPaziente patientManager;
	/**
	 * @uml.property  name="pList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="xyzt.orthopediatrics.client.Prenotazione"
	 */
	private LinkedList<Prenotazione> pList;
	/**
	 * @uml.property  name="mntmChiudi"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmChiudi;
	/**
	 * @uml.property  name="popupMenu"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPopupMenu popupMenu;
	/**
	 * @uml.property  name="mntmCancella"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmCancella;
	/**
	 * @uml.property  name="mntmSposta"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmSposta;
	/**
	 * @uml.property  name="separator"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JSeparator separator;
	/**
	 * @uml.property  name="mntmVisualizza"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmVisualizza;
	/**
	 * @uml.property  name="mntmAggiorna"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmAggiorna;
	
	public PatientUI(final Paziente paziente, final Database database)
	{		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PatientUI.class.getResource("/resources/icons/icon.png")));
		setTitle("Orthopediatrics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 542);
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), 
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, 
				TitledBorder.TOP, null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		mnFile = new JMenu(" File");
		menuBar = new JMenuBar();
		menuBar.add(mnFile);
		
		mntmChiudi = new JMenuItem(" Chiudi programma");
		mntmChiudi.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/exit2.png")));
		mntmChiudi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnFile.add(mntmChiudi);
		setJMenuBar(menuBar);
		
		lblselezionaIlReparto = new JLabel("<html>Selezionare il reparto per il quale si desidera effettuare la prenotazione della visita</html>");

		lblOrthopediatrics = new JLabel("Orthopediatrics");
		lblOrthopediatrics.setForeground(new Color(30, 144, 255));
		lblOrthopediatrics.setFont(new Font("Dialog", Font.BOLD, 17));
		lblOrthopediatrics.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/icon-small.png")));
		
		framePrenotazioni = new JInternalFrame("Prenotazione Visite");
		framePrenotazioni.setFrameIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/prescription.png")));
		framePrenotazioni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		framePrenotazioni.setVisible(true);
		
		internalFrame = new JInternalFrame("Notifica prenotazioni");
		internalFrame.setFrameIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/clipboard.png")));
		internalFrame.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		internalFrame.setVisible(true);
		
		cmbReparto = new JComboBox();
		cmbReparto.setToolTipText("Scegli un reparto");
		cmbReparto.setModel(new DefaultComboBoxModel(new String[] {" Visita Ortopedica", " Visita Pediatrica"}));
		
		model = new DefaultListModel();
		
		list = new JList(model);
		list.setVisibleRowCount(2);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/exit2.png")));
		
		btnPrenota = new JButton("Prenotazione Visita");
		btnPrenota.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/bookmark-add.png")));
		btnPrenota.setToolTipText("Clicca qui per prenotare la visita");
		
		btnVisualizzaReferto = new JButton("Visualizza Referto");
		btnVisualizzaReferto.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/bookmark2.png")));
		btnVisualizzaReferto.setToolTipText("Visualizza il referto medico associato alla prenotazione");
		
		btnCancella = new JButton("Cancella");
		btnCancella.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/delete.png")));
		btnCancella.setToolTipText("Cancella la prenotazione");

		btnSposta = new JButton("Sposta");
		btnSposta.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/move.png")));
		btnSposta.setToolTipText("Sposta la prenotazione");
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		
		popupMenu = new JPopupMenu();
		addPopup(list, popupMenu);
		
		mntmAggiorna = new JMenuItem("Aggiorna");
		mntmAggiorna.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/update.png")));
		popupMenu.add(mntmAggiorna);
		
		mntmCancella = new JMenuItem("Cancella");
		mntmCancella.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/delete.png")));
		popupMenu.add(mntmCancella);
		
		mntmSposta = new JMenuItem("Sposta");
		mntmSposta.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/move.png")));
		popupMenu.add(mntmSposta);
		
		separator = new JSeparator();
		popupMenu.add(separator);
		
		mntmVisualizza = new JMenuItem("Visualizza");
		mntmVisualizza.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/bookmark2.png")));
		popupMenu.add(mntmVisualizza);
		
		// -------------------------------------------------------------------------------------------------
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(framePrenotazioni, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(internalFrame, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblOrthopediatrics, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrthopediatrics)
						.addComponent(btnChiudi))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(internalFrame)
						.addComponent(framePrenotazioni))
					.addGap(20))
		);
		
		JButton btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setIcon(new ImageIcon(PatientUI.class.getResource("/resources/icons/update.png")));
		btnAggiorna.setToolTipText("Sposta la prenotazione");
		GroupLayout groupLayout_1 = new GroupLayout(internalFrame.getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(btnVisualizzaReferto)
							.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
							.addComponent(btnAggiorna)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSposta, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancella)))
					.addContainerGap())
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancella, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSposta, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnVisualizzaReferto, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAggiorna, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		GroupLayout groupLayout = new GroupLayout(framePrenotazioni.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cmbReparto, 0, 215, Short.MAX_VALUE)
						.addComponent(lblselezionaIlReparto)
						.addComponent(btnPrenota, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblselezionaIlReparto)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbReparto, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPrenota)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		framePrenotazioni.getContentPane().setLayout(groupLayout);
		contentPane.setLayout(gl_contentPane);
		internalFrame.getContentPane().setLayout(groupLayout_1);		
		
		//*****************************************************************************************************//
		
		pList = new LinkedList<Prenotazione>();
		patientManager = new CPaziente(database);
		
		// visualizzazione delle prenotazioni
		showReservationList(paziente);
		
		/**
		 * Chiudi programma da pulsante
		 * Visualizzazione di un messaggio di chiusura
		 */
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (new UISupport().closeDialog() == UISupport.YES)
					System.exit(NORMAL);
			}
		});
		
		/**
		 * Chiudi programma da Menu
		 * Visualizzazione di un messaggio di chiusura
		 */
		mntmChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new UISupport().closeDialog() == UISupport.YES)
					System.exit(NORMAL);
			}
		});
		
		/**
		 * Prenotazione visita
		 * Visualizzazione di una finestra per l'inserimento della
		 * descrizione del malore che il paziente sente
		 */
		btnPrenota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reparto = -1;
				if (cmbReparto.getSelectedIndex() == 0)
					reparto = xyzt.orthopediatrics.Type.Reparto.ORTOPEDIA;
				else
					reparto = xyzt.orthopediatrics.Type.Reparto.PEDIATRIA;
				new UISupport().loadWindow(new PrenotazioneUI(reparto, paziente, database));
			}
		});
		
		/**
		 * Sposta prenotazione
		 * Viene inviato un messaggio al sistema per lo spostamento
		 * di una prenotazione
		 */
		btnSposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveRequest();
			}
		});
		
		/**
		 * Sposta prenotazione (da menu)
		 * Viene inviato un messaggio al sistema per lo spostamento
		 * di una prenotazione
		 */
		mntmSposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveRequest();
			}
		});
		
		/**
		 * Richiesta di cancellazione
		 * Invio di un messaggio all'amministratore per richiedere
		 * la cancellazione della visita prenotata
		 */
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelRequest();
			}
		});
		
		/**
		 * Richiesta di cancellazione (da menu)
		 */
		mntmCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelRequest();
			}
		});
		
		/**
		 * Visualizzazione del referto associato alla prenotazione
		 * da bottone
		 */
		btnVisualizzaReferto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewReport();
			}
		});
		
		/**
		 * Visualizzazione del referto associato alla prenotazione
		 * da menu
		 */
		mntmVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewReport();
			}
		});
		
		
		/**
		 * Aggiornamento della lista (da bottone)
		 */
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showReservationList(paziente);
			}
		});
		
		/**
		 * Aggiornamento della lista (da menu)
		 */
		mntmAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showReservationList(paziente);
			}
		});
	}
	
	/**
	 * Caricamento di tutte le prenotazioni nel database
	 * con riferimento ad uno specifico paziente
	 * @param paziente - Paziente
	 */
	private void showReservationList(Paziente paziente) {
		model.clear();
		loadReservationList(paziente);
	}
	
	/**
	 * Visualizzazione delle prenotazioni
	 */
	private void loadReservationList(Paziente paziente) {
		pList = patientManager.fetchReservation(paziente);
		for (Prenotazione prenotazione : pList) {
			model.addElement(prenotazione.toString());
		}
	}
	
	/**
	 * Richiesta di cancellazione
	 * Invio di un messaggio all'amministratore per richiedere
	 * la cancellazione della visita prenotata
	 */
	private void cancelRequest() {
		int index = list.getSelectedIndex();
		if (index >= 0) {
			if (patientManager.retireReservation(pList.get(index)))
				new UISupport().notifyDialogRetireReservation();
			else
				new UISupport().notifyDialogRetireRequestERROR();
		}
		else
			new UISupport().notifyDialogNoReservationSelected();
	}
	
	/**
	 * Sposta prenotazione
	 * Viene inviato un messaggio al sistema per lo spostamento
	 * di una prenotazione
	 */
	private void moveRequest() {
		int index = list.getSelectedIndex();
		if (index >= 0) {
			if (patientManager.deferReservation(pList.get(index)) == true)
				new UISupport().notifyDialogMoveRequestOK();
			else
				new UISupport().notifyDialogMoveRequestERROR();
		}
		else
			new UISupport().notifyDialogNoReservationSelected();
	}
	
	/**
	 * Visualizzazione del referto
	 */
	private void viewReport() {
		int index = list.getSelectedIndex();
		if (index >= 0) {
			int idPrenotazione = pList.get(index).getId();
			if (patientManager.fetchReport(idPrenotazione) != null)
				new UISupport().notifyDialog(patientManager.fetchReport(idPrenotazione).toString());
			else
				new UISupport().notifyDialogReservationNoReport();
		}
		else
			new UISupport().notifyDialogNoReservationSelected();
	}
	
	
	/**
	 * Menu di popup
	 * @param component
	 * @param popup
	 */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
}
