/* 
 * ClientUI.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import xyzt.orthopediatrics.client.Amministratore;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.creator.CAmministratore;
import xyzt.orthopediatrics.client.creator.CPaziente;
import xyzt.orthopediatrics.client.db.Database;
import xyzt.orthopediatrics.gui.AdminUI;
import xyzt.orthopediatrics.gui.RegistrationUI;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

@SuppressWarnings("serial")
public class ClientUI extends JFrame
{
	// Separators
	/**
	 * @uml.property  name="separator"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JSeparator separator;
	/**
	 * @uml.property  name="separator_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JSeparator separator_1;

	// Panels
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel contentPane;
	/**
	 * @uml.property  name="panel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel panel;
	
	// Text-fields
	/**
	 * @uml.property  name="txtUsername"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField txtUsername;
	/**
	 * @uml.property  name="txtPassword"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPasswordField txtPassword;
	
	// Labels
	/**
	 * @uml.property  name="lblIcon"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblIcon;
	/**
	 * @uml.property  name="lblOrthopediatrics"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblOrthopediatrics;
	/**
	 * @uml.property  name="lblDescrizione"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblDescrizione;
	/**
	 * @uml.property  name="lblStatus"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblStatus;
	/**
	 * @uml.property  name="lblUsername"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblUsername;
	/**
	 * @uml.property  name="lblPassword"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblPassword;
	
	// Box (check-box e combo-box)
	/**
	 * @uml.property  name="chckbxRegistrazione"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JCheckBox chckbxRegistrazione;
	/**
	 * @uml.property  name="chckbxAmministrazione"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JCheckBox chckbxAmministrazione;
	
	// Combo box
	/**
	 * @uml.property  name="cmbReparto"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JComboBox cmbReparto;
	/**
	 * @uml.property  name="cmbUtente"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JComboBox cmbUtente;

	// Buttons
	/**
	 * @uml.property  name="btnLogin"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnLogin;
	/**
	 * @uml.property  name="btnRegistrazione"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnRegistrazione;
	/**
	 * @uml.property  name="btnChiudi"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnChiudi;
	
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
	/**
	 * @uml.property  name="mnAbout"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenu mnAbout;
	/**
	 * @uml.property  name="mntmChiudiProgramma"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmChiudiProgramma;
	/**
	 * @uml.property  name="mntmXyztGroup"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmXyztGroup;
	/**
	 * @uml.property  name="mntmOrthopediatrics"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmOrthopediatrics;
	/**
	 * @uml.property  name="mntmHelp"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmHelp;


	/**
	 * Costruttore della classe
	 */
	public ClientUI(final Database database)
	{		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientUI.class.getResource("/resources/icons/icon.png")));
		setTitle("Orthopediatrics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu(" File");
		menuBar.add(mnFile);
		
		mntmChiudiProgramma = new JMenuItem(" Chiudi ");
		mntmChiudiProgramma.setIcon(new ImageIcon(ClientUI.class.getResource("/resources/icons/exit-menu.png")));
		mntmChiudiProgramma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnFile.add(mntmChiudiProgramma);
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		mntmXyztGroup = new JMenuItem(" XYZT Group ");
		mntmXyztGroup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnAbout.add(mntmXyztGroup);
		
		mntmOrthopediatrics = new JMenuItem(" Orthopediatrics ");
		mnAbout.add(mntmOrthopediatrics);
		
		separator_1 = new JSeparator();
		mnAbout.add(separator_1);
		
		mntmHelp = new JMenuItem(" Help ");
		mntmHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		mntmHelp.setIcon(new ImageIcon(ClientUI.class.getResource("/resources/icons/help.png")));
		mnAbout.add(mntmHelp);
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), 
				"", TitledBorder.LEADING, TitledBorder.TOP, null, 
				new Color(51, 51, 51)), 
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		separator = new JSeparator();
		
		lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(ClientUI.class.getResource("/resources/icons/icon-small.png")));
		
		lblOrthopediatrics = new JLabel("Orthopediatrics");
		lblOrthopediatrics.setForeground(new Color(30, 144, 255));
		lblOrthopediatrics.setFont(new Font("Dialog", Font.BOLD, 17));
		
		chckbxRegistrazione = new JCheckBox("registrazione");
		chckbxAmministrazione = new JCheckBox("amministrazione");
		
		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtPassword = new JPasswordField();
		
		// Reparto (Ortopedia, Pediatria)
		cmbReparto = new JComboBox();
		cmbReparto.setEnabled(false);
		cmbReparto.setModel(new DefaultComboBoxModel(new String[] {" Ortopedia", " Pediatria"}));
		
		lblDescrizione = new JLabel("<html>Piattaforma di moduli applicativi gestionali per l'informatizzazione " +
				"di cliniche e strutture ospedaliere, realizzando un sistema informativo completo per il reparto di " +
				"Pediatria e Ortopedia.</html>");
		
		// Indica il tipo di operazione che il paziente sta eseguendo;
		lblStatus = new JLabel("Status: Login paziente");

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		cmbUtente = new JComboBox();
		cmbUtente.setEnabled(false);
		cmbUtente.setModel(new DefaultComboBoxModel(new String[] {" Paziente", " Tutore"}));
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.setIcon(new ImageIcon(ClientUI.class.getResource("/resources/icons/exit2.png")));
		
		btnRegistrazione = new JButton("Register");
		btnRegistrazione.setIcon(new ImageIcon(ClientUI.class.getResource("/resources/icons/adduser.png")));
		btnRegistrazione.setEnabled(false);
		
		btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(ClientUI.class.getResource("/resources/icons/login.png")));		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblIcon)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDescrizione, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
										.addComponent(lblOrthopediatrics, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
									.addComponent(btnRegistrazione, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblStatus))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(175)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(162)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIcon)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblOrthopediatrics)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDescrizione)))
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(lblStatus)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnRegistrazione)
						.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPassword)
								.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxAmministrazione)
								.addComponent(chckbxRegistrazione))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbReparto, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbUtente, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))))
					.addGap(27))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxRegistrazione)
						.addComponent(cmbUtente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxAmministrazione)
						.addComponent(cmbReparto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		/***********************************************************************************************/
		
		/* Selezione Check-box registrazione
		 */
		chckbxRegistrazione.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (chckbxRegistrazione.isSelected())
				{
					cmbReparto.setEnabled(false);
					chckbxAmministrazione.setSelected(false);
					btnLogin.setEnabled(false);
					txtUsername.setEnabled(false);
					txtPassword.setEnabled(false);
					cmbUtente.setEnabled(true);
					btnRegistrazione.setEnabled(true);
					lblStatus.setText("Status: Registrazione nuovo paziente");
				}
				else
				{
					cmbUtente.setEnabled(false);
					btnRegistrazione.setEnabled(false);
					txtUsername.setEnabled(true);
					txtPassword.setEnabled(true);
					btnLogin.setEnabled(true);
					lblStatus.setText("Status: Login paziente");
				}
			}
		});
		
		/* selezione check-box amministratore
		 */
		chckbxAmministrazione.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (chckbxAmministrazione.isSelected()) {
					cmbReparto.setEnabled(true);
					chckbxRegistrazione.setSelected(false);
					btnRegistrazione.setEnabled(false);
					btnLogin.setEnabled(true);
					lblStatus.setText("Status: Login Amministratore");
				}
				else {
					cmbReparto.setEnabled(false);
					lblStatus.setText("Status: Login paziente");
				}
			}
		});
		
		/* Visualizzazione di un messaggio con le informazioni
		 * sui componenti del gruppo
		 */
		mntmXyztGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = "";
				s += "Project Manager: Matej Torok\n";
				s += "Quality Manager: Giacomo Bergami\n";
				s += "Tool Specialist: Paolo De Luca\n";
				s += "Developer: Fabian Priftaj\n";
				new UISupport().notifyDialog(s);
			}
		});
		
		/* Visualizzazione di un messaggio con la descrizione
		 * dell'applicazione
		 */
		mntmOrthopediatrics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = "";
				s += "Piattaforma di moduli applicativi gestionali per l'informatizzazione\n";
				s += "di cliniche e strutture ospedaliere, realizzando un sistema informativo\n";
				s += "completo per il reparto di Pediatria e Ortopedia";
				new UISupport().notifyDialog(s);
			}
		});
		
		/* Visualizzazione di un messaggio di pop-up per la chiusura
		 * dell'applicazione; a seconda dell'opzione scelta 'YES','NO'
		 * l'applicazione continua oppure termina
		 */
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (new UISupport().closeDialog() == UISupport.YES)
					System.exit(NORMAL);
			}
		});
		
		/* Chiusura del programma (da menu)
		 */
		mntmChiudiProgramma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (new UISupport().closeDialog() == UISupport.YES)
					System.exit(NORMAL);
			}
		});
		
		
		/* Combo box per l'utente; tale opzione serve per la registrazione
		 * di due tipi di utenti: tutore o paziente
		 */
		cmbUtente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if  (cmbUtente.getSelectedIndex() == 0)
					lblStatus.setText("Status: Registrazione nuovo paziente");
				else
					lblStatus.setText("Status: Registrazione nuovo tutore");		
			}
		});
		
		
		/* Registrazione di un paziente o di un tutore;
		 */
		btnRegistrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int userType = -1;

				/* controllo chi e' l'utente che tenta di eseguire
				 * la registrazione: un tutore oppure un paziente
				 */
				int choice = cmbUtente.getSelectedIndex();
				if (choice == 0)
					userType = xyzt.orthopediatrics.Type.User.PATIENT;
				else if (choice == 1)
					userType = xyzt.orthopediatrics.Type.User.TUTOR;
				
				/* caricamento della schermata di Registrazione per  un paziente o
				 * un tutore, a seconda di cosa contiene il campo 'userType'
				 */
				new UISupport().loadWindow(new RegistrationUI(database, userType));
				dispose();
			}
		});
		
		
		/* Autenticazione di un utente;
		 * l'utente in questione puo' essere un Paziente o Amministratore
		 */
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				
				if (chckbxAmministrazione.isSelected())	{
					/* Autenticazione Amministratore
					 */
					int reparto = -1;
					if (cmbReparto.getSelectedIndex() == 0)
						reparto = xyzt.orthopediatrics.Type.Reparto.ORTOPEDIA;
					else if (cmbReparto.getSelectedIndex() == 1)
						reparto = xyzt.orthopediatrics.Type.Reparto.PEDIATRIA;

					Amministratore admin = null;
					CAmministratore adminManager = new CAmministratore(database);
					
					/* Connessione al database per verificare l'esistenza
					 * dell'amministratore; se l'amministratore esiste allora
					 * verra creata un'istanza di tale oggetto con i campi
					 * opportunamente settati, altrimenti verra' restituito NULL
					 */
					admin = adminManager.login(reparto, username, password);					
					if (admin == null)
						new UISupport().loginErrorAuthentication();
					else {
						new UISupport().loadWindow(new AdminUI(admin, database));
						dispose();
					}
				}
				else
				{	
					/* Autenticazione paziente
					 */
					Paziente paziente = null;
					CPaziente patientManager = new CPaziente(database);
					
					/* Connessione al database per verificare l'esistenza
					 * del paziente; se il paziente esiste allora verra creata
					 * un'istanza di tale oggetto con i campi opportunamente settati
					 * altrimenti verra' restituito NULL
					 */
					paziente = patientManager.login(username.toUpperCase(), password);
										
					if (paziente == null)
						new UISupport().loginErrorAuthentication();
					else {
						
						/* Viene controllato se il paziente e' minorenne ed in tal caso
						 * il tutore di tale paziente deve effettuare il login
						 */
						if (paziente.isMajor())
							new UISupport().loadWindow(new PatientUI(paziente, database));
						else
							new UISupport().loadWindow(new LoginTutorUI(paziente, database));
						
						// chiudo la finestra corrente
						dispose();
					}
				}
			}
		});
		
	}
}
