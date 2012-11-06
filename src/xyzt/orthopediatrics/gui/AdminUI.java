/* 
 * AdminUI.java
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
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import xyzt.orthopediatrics.Calendario;
import xyzt.orthopediatrics.Type;
import xyzt.orthopediatrics.client.Amministratore;
import xyzt.orthopediatrics.client.Messaggio;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.creator.CAmministratore;
import xyzt.orthopediatrics.client.creator.CPaziente;
import xyzt.orthopediatrics.client.db.Database;
import xyzt.orthopediatrics.gui.CalendarioUI;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

@SuppressWarnings("serial")
public class AdminUI extends JFrame
{
	// Panel
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPanel contentPane;
	
	/**
	 * @uml.property  name="panel"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPanel panel;
	
	/**
	 * @uml.property  name="panelPrenotazione"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPanel panelPrenotazione;
	
	/**
	 * @uml.property name="panelRED"
	 * @uml.associationEnd readOnly="true"
	 */
	private JPanel panelRED;
	
	/**
	 * @uml.property name="panelYELLOW"
	 * @uml.associationEnd readOnly="true"
	 */
	private JPanel panelYELLOW;
	
	/**
	 * @uml.property name="panelGREEN"
	 * @uml.associationEnd readOnly="true"
	 */
	private JPanel panelGREEN;
	
	/**
	 * @uml.property name="lblSala"
	 * @uml.associationEnd readOnly="true"
	 */
	private JLabel lblSala;
	
	/**
	 * @uml.property name="panelPriorita"
	 * @uml.associationEnd readOnly="true"
	 */
	private JPanel panelPriorita;
	
	// Models
	/**
	 * @uml.property name="model"
	 * @uml.associationEnd  readOnly="true" multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	private DefaultListModel model;
	
	// Frames
	/**
	 * @uml.property  name="internalFrame"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JInternalFrame internalFrame;
	
	// Scroll pane
	/**
	 * @uml.property  name="scrollPane"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JScrollPane scrollPane;
	
	/**
	 * @uml.property  name="scrollPaneNote"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JScrollPane scrollPaneNote;
	
	// Lists
	/**
	 * @uml.property  name="listRequests"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JList listRequests;
	
	// Text fields
	/**
	 * @uml.property  name="txtNote"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextArea txtNote;
	
	// Menu and Menu-bar
	/**
	 * @uml.property  name="mnFile"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JMenu mnFile;
	
	/**
	 * @uml.property  name="menuBar"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JMenuBar menuBar;
	
	/**
	 * @uml.property  name="cmbSala"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JComboBox cmbSala;
	
	// Radios
	/**
	 * @uml.property  name="radioRED"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JRadioButton radioRED;
	
	/**
	 * @uml.property  name="radioGREEN"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JRadioButton radioGREEN;
	
	/**
	 * @uml.property  name="radioYELLOW"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JRadioButton radioYELLOW;
	
	// Labels
	/**
	 * @uml.property  name="lblpaziente"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblpaziente;
	
	/**
	 * @uml.property  name="lblnote"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblnote;
	
	/**
	 * @uml.property  name="lblnomecognome"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblnomecognome;
	
	/**
	 * @uml.property  name="lblAmministrazione"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblAmministrazione;

	// Buttons
	/**
	 * @uml.property  name="btnAggiorna"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnAggiorna;
	
	/**
	 * @uml.property  name="btnCancella"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnCancella;
	
	/**
	 * @uml.property  name="btnReferti"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnReferti;
	
	/**
	 * @uml.property  name="btnChiudi"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnChiudi;
	
	/**
	 * @uml.property  name="btnCalendario"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnCalendario;
	
	/**
	 * @uml.property  name="btnAltro"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnAltro;
	
	// Menu
	/**
	 * @uml.property  name="mntmChiudi"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JMenuItem mntmChiudi;
	
	/**
	 * @uml.property  name="popupMenu"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPopupMenu popupMenu;
	
	/**
	 * @uml.property  name="mntmCancellaMessaggio"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JMenuItem mntmCancellaMessaggio;
	
	/**
	 * @uml.property  name="mntmAggiornaLista"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JMenuItem mntmAggiornaLista;
	
	// Strings
	/**
	 * @uml.property  name="descrizione"
	 */
	private String descrizione;
	
	/**
	 * @uml.property  name="listaSala" multiplicity="(0 -1)" dimension="1"
	 */
	private String[] listaSala;
	/**
	 * @uml.property  name="today"
	 */
	private String today;
	
	/**
	 * @uml.property  name="paziente"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Paziente paziente;
	
	/**
	 * @uml.property  name="msgList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="xyzt.orthopediatrics.client.Messaggio"
	 */
	private LinkedList<Messaggio> msgList;
	
	/**
	 * @uml.property  name="adminManager"
	 * @uml.associationEnd  readOnly="true"
	 */
	private CAmministratore adminManager;
	
	/**
	 * @uml.property  name="patientManager"
	 * @uml.associationEnd  readOnly="true"
	 */
	private CPaziente patientManager;
	
	/**
	 * @uml.property  name="calendario"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Calendario calendario;
	
	/**
	 * @uml.property  name="priorita"
	 */
	private int priorita;
	
	/**
	 * @uml.property  name="mnPreferenze"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JMenu mnPreferenze;
	
	/**
	 * @uml.property  name="mntmCambiaCredenzialiDi"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JMenuItem mntmCambiaCredenzialiDi;
	
	private int typeOfMessage;
	private Amministratore admin;
	private Database database;
	private boolean calendarIsOpen;
	
	/**
	 * Costruttore
	 * @param amministratore - Amministratore che gestisce il reparto
	 */
	public AdminUI(final Amministratore amministratore, final Database database)
	{
		this.admin = amministratore;
		this.database = database;
		this.calendarIsOpen = false;
	
		setTitle("Orthopediatrics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminUI.class.getResource("/resources/icons/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 588);
	
		scrollPane = new JScrollPane();
		panel = new JPanel();
		btnAltro = new JButton("");
		btnAltro.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/info.png")));
		radioRED = new JRadioButton("");
		radioGREEN = new JRadioButton("");
		radioYELLOW = new JRadioButton("");
		listaSala = new String[2];
		lblpaziente = new JLabel("ID Paziente");
		lblnote = new JLabel("Descrizione");
		lblnomecognome = new JLabel("...");		
		txtNote = new JTextArea("...");
		txtNote.setWrapStyleWord(true);
		txtNote.setEditable(false);
		txtNote.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		btnCalendario = new JButton("Calendario");
		btnCalendario.setToolTipText("Visualizza il calendario delle prenotazioni");
		btnCalendario.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/calendario.png")));

		mnFile = new JMenu(" File");
		mnFile.setFont(new Font("Dialog", Font.BOLD, 13));

		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Dialog", Font.BOLD, 12));
		setJMenuBar(menuBar);
		menuBar.add(mnFile);
		
		mntmChiudi = new JMenuItem("Chiudi");
		mntmChiudi.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/exit2.png")));
		mntmChiudi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnFile.add(mntmChiudi);
		
		mnPreferenze = new JMenu("Preferenze");
		menuBar.add(mnPreferenze);
		
		mntmCambiaCredenzialiDi = new JMenuItem("Cambia credenziali di accesso");
		mntmCambiaCredenzialiDi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UISupport().loadWindow(new AdminDBCredentials(amministratore, database));
			}
		});
		mntmCambiaCredenzialiDi.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/database.png")));
		mnPreferenze.add(mntmCambiaCredenzialiDi);
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(
				new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(51, 51, 51)), new TitledBorder(new LineBorder(
				new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		panelRED = new JPanel();
		panelRED.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,	TitledBorder.TOP, null, null));
		panelRED.setBackground(Color.RED);

		panelYELLOW = new JPanel();
		panelYELLOW.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelYELLOW.setBackground(Color.YELLOW);

		panelGREEN = new JPanel();
		panelGREEN.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,	TitledBorder.TOP, null, null));
		panelGREEN.setBackground(new Color(0, 128, 0));
		
		panelPriorita = new JPanel();
		panelPriorita.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229), 1, true),
				"Priorit\u00E0", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		panelPrenotazione = new JPanel();
		panelPrenotazione.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229), 1, true), "Prenotazione",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		descrizione = "Amministrazione pazienti del reparto di ";
		if (amministratore.getReparto() == xyzt.orthopediatrics.Type.Reparto.ORTOPEDIA) {
			descrizione += "Ortopedia";
			listaSala[0] = " Sala A1";
			listaSala[1] = " Sala A2";
		} else {
			descrizione += "Pediatria";
			listaSala[0] = " Sala B1";
			listaSala[1] = " Sala B2";
		}
		
		cmbSala = new JComboBox();
		cmbSala.setModel(new DefaultComboBoxModel(listaSala));

		lblAmministrazione = new JLabel(descrizione);
		lblAmministrazione.setForeground(new Color(30, 144, 255));
		lblAmministrazione.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAmministrazione.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/icon-small.png")));

		internalFrame = new JInternalFrame("");
		internalFrame.setEnabled(false);
		internalFrame.setFrameIcon(null);
		internalFrame.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		internalFrame.setVisible(true);
		
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229), 1, true), "Informazioni", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		lblnomecognome.setFont(new Font("Dialog", Font.BOLD, 14));
		
		txtNote.setBackground(UIManager.getColor("Button.background"));
		txtNote.setLineWrap(true);

		radioGREEN.setHorizontalAlignment(SwingConstants.CENTER);
		radioYELLOW.setHorizontalAlignment(SwingConstants.CENTER);
		radioRED.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblSala = new JLabel("<html>\nSelezionare la sala:\n</html>");
		
		model = new DefaultListModel();
		listRequests = new JList(model);
		listRequests.setSelectedIndex(0);
		listRequests.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listRequests.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listRequests.setValueIsAdjusting(true);
		
		scrollPaneNote = new JScrollPane();
		scrollPaneNote.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneNote.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		// indico che la priorita' non e' stata ancora impostata
		priorita = -1;
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/exit2.png")));

		btnReferti = new JButton("Gestione referti");
		btnReferti.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/report.png")));
	
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/update.png")));
		
		btnCancella = new JButton("Cancella");
		btnCancella.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/delete.png")));
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(internalFrame, Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAmministrazione, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addGap(9))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmministrazione)
						.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(internalFrame, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblpaziente)
						.addComponent(lblnote))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblnomecognome, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
							.addComponent(btnAltro, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneNote, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblpaziente)
								.addComponent(lblnomecognome)))
						.addComponent(btnAltro, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneNote, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
						.addComponent(lblnote))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		GroupLayout gl_panel_1 = new GroupLayout(panelPriorita);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(radioRED, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(panelRED, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panelYELLOW, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelGREEN, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(radioYELLOW, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(radioGREEN, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
					.addGap(10))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panelGREEN, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelYELLOW, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelRED, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(radioRED)
							.addComponent(radioYELLOW, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(radioGREEN, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panelPriorita.setLayout(gl_panel_1);
		
		GroupLayout groupLayout = new GroupLayout(internalFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAggiorna, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancella, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelPriorita, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelPrenotazione, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(panelPrenotazione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelPriorita, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAggiorna, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancella, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		
		GroupLayout gl_panel_5 = new GroupLayout(panelPrenotazione);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSala, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReferti, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(btnCalendario, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(cmbSala, Alignment.TRAILING, 0, 204, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSala)
						.addComponent(cmbSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCalendario)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReferti)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		panelPrenotazione.setLayout(gl_panel_5);
		internalFrame.getContentPane().setLayout(groupLayout);
		contentPane.setLayout(gl_contentPane);
		
		scrollPane.setViewportView(listRequests);
		
		popupMenu = new JPopupMenu();
		addPopup(listRequests, popupMenu);
		
		mntmCancellaMessaggio = new JMenuItem("Cancella messaggio");
		mntmCancellaMessaggio.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/delete.png")));
		mntmCancellaMessaggio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		popupMenu.add(mntmCancellaMessaggio);
		
		mntmAggiornaLista = new JMenuItem("Aggiorna lista messaggi");
		mntmAggiornaLista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAggiornaLista.setIcon(new ImageIcon(AdminUI.class.getResource("/resources/icons/update.png")));
		popupMenu.add(mntmAggiornaLista);
		scrollPaneNote.setViewportView(txtNote);

		/***********************************************************************************************/
		
		/**
		 * Inizializzazione oggetti
		 */
		paziente = null;
		calendario = new Calendario();
		adminManager = new CAmministratore(database);
		patientManager = new CPaziente(database);
		msgList = new LinkedList<Messaggio>();
		
				
		/**
		 * Impostiamo la data corrente nell'interfaccia dell'amministratore
		 */
		today = "Oggi: " + calendario.getWeekDay() + " " + calendario.getDay() + " " +
				calendario.getMonth() + " " + calendario.getYear();
		internalFrame.setTitle(today);
		
		
		/**
		 * Caricamento di tutti i messaggi di richiesta di prenotazione
		 * da parte dei pazienti
		 */
		loadMsgRequestList(amministratore);
		
		
		/**
		 * L'amministratore attribuisce alla prenotazione
		 * una priorita' VERDE
		 */
		radioGREEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioRED.setSelected(false);
				radioYELLOW.setSelected(false);
				radioGREEN.setSelected(true);
				priorita = xyzt.orthopediatrics.Type.Priorita.VERDE;
			}
		});
		
		
		/**
		 * L'amministratore attribuisce alla prenotazione
		 * una priorita' GIALLA
		 */
		radioYELLOW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioRED.setSelected(false);
				radioYELLOW.setSelected(true);
				radioGREEN.setSelected(false);
				priorita = xyzt.orthopediatrics.Type.Priorita.GIALLO;
			}
		});

		/**
		 * L'amministratore attribuisce alla prenotazione
		 * una priorita' ROSSA
		 */
		radioRED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radioRED.setSelected(true);
				radioYELLOW.setSelected(false);
				radioGREEN.setSelected(false);
				priorita = xyzt.orthopediatrics.Type.Priorita.ROSSO;
			}
		});
		
		
		/**
		 * Cliccando sul pulsante 'Info Paziente' l'amministratore ha
		 * accesso ai dati del paziente
		 */
		btnAltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (paziente != null)
					new UISupport().notifyDialogPatient(paziente);
				else
					new UISupport().notifyDialogNoRequestsSelected();
			}
		});		
		
		/**
		 * Chiudi il programma (da pulsante)
		 */
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new UISupport().closeDialog() == UISupport.YES)
					System.exit(NORMAL);
			}
		});
		
		/**
		 * Chiudi il programma (da menu)
		 */
		mntmChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new UISupport().closeDialog() == UISupport.YES)
					System.exit(NORMAL);
			}
		});
		
		/**
		 * Gestione referti
		 */
		btnReferti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UISupport().loadWindow(new GestioneRefertiUI(database, amministratore, -1));
			}
		});
		
		/**
		 * Quando l'amministratore seleziona sul lato sinistro le varie date di prenotazione,
		 * allora vengono aggiornati i campi sulla destra con le relative informazioni
		 * del paziente
		 */
		listRequests.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int pos = listRequests.getSelectedIndex();
				if (pos >= 0) {
					Messaggio msg = (Messaggio) msgList.get(pos);
					String msgType = "";
					
					if (msg.getTipo() == xyzt.orthopediatrics.Type.Messaggio.REQUEST)
						msgType = "RICHIESTA DI PRENOTAZIONE\n--";
					else if (msg.getTipo() == xyzt.orthopediatrics.Type.Messaggio.CANCEL)
						msgType = "RICHIESTA DI CANCELLAZIONE\n--";
					else if (msg.getTipo() == xyzt.orthopediatrics.Type.Messaggio.POSTPONE)
						msgType = "RICHIESTA DI SPOSTAMENTO\n--";
				
					// ottengo Nome e Cognome del paziente
					paziente = patientManager.getPaziente(msg.getMittente());
					typeOfMessage = msg.getTipo();
					lblnomecognome.setText(paziente.getNome() + " " + paziente.getCognome());
					txtNote.setText(msgType + "\n" + msg.getContent());
				
					// riporto il cursore all'inizio del testo
					txtNote.select(0, 0);
				}
			}
		});
		
		/**
		 * Apertura del calendario per visualizzare le prenotazioni
		 */
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (calendarIsOpen)
					return;
				
				if (paziente != null) {
					int reparto = amministratore.getReparto();
					int sala = cmbSala.getSelectedIndex();
					if (reparto == xyzt.orthopediatrics.Type.Reparto.PEDIATRIA)
						sala = sala + 2;
					if (typeOfMessage == Type.Messaggio.REQUEST) {
						if (priorita != -1) {
							openedCalendar();
							new UISupport().loadWindow(new CalendarioUI(AdminUI.this, reparto, sala, priorita, paziente, database,typeOfMessage));
						} else
							new UISupport().notifyDialogPriorityNotValid();
					}
					else if ((typeOfMessage == Type.Messaggio.CANCEL) || 
							 (typeOfMessage == Type.Messaggio.POSTPONE)) {
						openedCalendar();
						new UISupport().loadWindow(new CalendarioUI(AdminUI.this, reparto, sala, priorita, paziente, database,typeOfMessage));
					}
				} else
					new UISupport().notifyDialogNoRequestsSelected();
				

				/*
				if (paziente != null) {
					if (priorita == -1) {
						int reparto = amministratore.getReparto();
						int sala = cmbSala.getSelectedIndex();
						if (reparto == xyzt.orthopediatrics.Type.Reparto.PEDIATRIA) {
							/* Se il reparto e' di PEDIATRIA allora le sale interessate
							 * sono la B1=2, e B2=3; gli indici pero' partono da 0 e quindi
							 * e' necessario aumentare di 2 unita' *
							sala = sala + 2;
						}
						openedCalendar();
						new UISupport().loadWindow(new CalendarioUI(AdminUI.this, reparto, sala, priorita, paziente, database,typeOfMessage));
					}
					else
						new UISupport().notifyDialogPriorityNotValid();
				} else
					new UISupport().notifyDialogNoRequestsSelected();
				*/
			}
		});
		
		/**
		 * Cancellazione di un messaggio dalla lista dei messaggi
		 */
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteMessage();
			}
		});
		
		
		/**
		 * Menu di pop-up di cancellazione
		 * Implementa le stesse funzionalita' del pulsante di cancellazione
		 */
		mntmCancellaMessaggio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMessage();
			}
		});
		
		/**
		 * Aggiornamento dei messaggi
		 */
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadMsgRequestList(amministratore);
			}
		});
		
		/**
		 * Menu di cancellazione
		 */
		mntmAggiornaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadMsgRequestList(amministratore);
			}
		});
	}
	
	/**
	 * Caricamento di tutti i messaggi di richiesta di prenotazione
	 * da parte dei pazienti
	 */
	private void loadMsgRequestList(Amministratore amministratore)
	{		
		model.clear();
		txtNote.setText("...");
		lblnomecognome.setText("...");
		msgList = new LinkedList<Messaggio>();
		msgList = adminManager.fetchPendantRequest(amministratore);
		for (Messaggio m : msgList) {
			model.addElement(m.toString());
		}
	}
	
	/**
	 * Rimozione di un messaggio dalla lista dei messaggi provenienti 
	 * dal paziente. Quando chiamata la funzione rimuove il messaggio
	 * selezionato tra quelli provenienti dal paziente
	 */
	public void deleteMessage() {
		int index = listRequests.getSelectedIndex();
		if (index >= 0) {
			if ((this.database.deleteMessage(msgList.get(index))) == true)
				loadMsgRequestList(this.admin);
		}
		else
			new UISupport().notifyDialogNoRequestsSelected();
	}
	
	public void restorePriority() {
		this.priorita = -1;
		this.radioGREEN.setSelected(false);
		this.radioRED.setSelected(false);
		this.radioYELLOW.setSelected(false);
	}
	
	public void restorePatient() {
		this.paziente = null;
	}
	
	protected void closedCalendar() {
		if (calendarIsOpen == true)
			calendarIsOpen = false;
	}
	
	private void openedCalendar() {
		if (calendarIsOpen == false)
			calendarIsOpen = true;
	}
	
	/**
	 * Menu di popup
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
