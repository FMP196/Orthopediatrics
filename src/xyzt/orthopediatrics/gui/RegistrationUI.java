/* 
 * RegistrationUI.java
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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import xyzt.orthopediatrics.Calendario;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Tutore;
import xyzt.orthopediatrics.client.creator.CPaziente;
import xyzt.orthopediatrics.client.creator.CTutore;
import xyzt.orthopediatrics.client.db.Database;
import xyzt.orthopediatrics.gui.ClientUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class RegistrationUI extends JFrame
{
	// Panels
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
	
	// Labels
	/**
	 * @uml.property  name="lblNome"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblNome;
	/**
	 * @uml.property  name="lblCognome"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblCognome;
	/**
	 * @uml.property  name="lblPassword"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblPassword;
	/**
	 * @uml.property  name="lblConferma"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblConferma;
	/**
	 * @uml.property  name="lblCodiceFiscale"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblCodiceFiscale;
	/**
	 * @uml.property  name="lblNascita"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblNascita;
	/**
	 * @uml.property  name="lblSesso"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblSesso;
	/**
	 * @uml.property  name="lblTelefono"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblTelefono;
	/**
	 * @uml.property  name="lblIndirizzo"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblIndirizzo;
	/**
	 * @uml.property  name="lblEmail"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblEmail;
	/**
	 * @uml.property  name="lblNewLabel"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblNewLabel;
	/**
	 * @uml.property  name="lblMinus"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblMinus;
	/**
	 * @uml.property  name="lblMinus2"

	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblMinus2;
	/**
	 * @uml.property  name="lblRegistrazione"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblRegistrazione;
	
	// Buttons
	/**
	 * @uml.property  name="btnChiudi"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnChiudi;
	/**
	 * @uml.property  name="btnRegistra"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnRegistra;

	// Text fields
	/**
	 * @uml.property  name="txtNome"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextField txtNome;
	/**
	 * @uml.property  name="txtCognome"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextField txtCognome;
	/**
	 * @uml.property  name="txtGiorno"
	 * @uml.associationEnd  readOnly="true"
	 * s[0].matches("[A-Za-z][A-Za-z ]+")
	 */
	private JTextField txtGiorno;
	/**
	 * @uml.property  name="txtTelefono"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextField txtTelefono;
	/**
	 * @uml.property  name="txtEmail"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextField txtEmail;
	/**
	 * @uml.property  name="txtIndirizzo"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextField txtIndirizzo;
	/**
	 * @uml.property  name="txtCodiceFiscale"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextField txtCodiceFiscale;
	/**
	 * @uml.property  name="txtMese"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextField txtMese;
	/**
	 * @uml.property  name="txtAnno"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextField txtAnno;
	
	// Password-text fields
	/**
	 * @uml.property  name="txtPassword"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPasswordField txtPassword;
	/**
	 * @uml.property  name="txtConfirmPassword"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPasswordField txtConfirmPassword;
	
	// Combo-box, Check-Box, separators
	/**
	 * @uml.property  name="cmbSesso"

	 * @uml.associationEnd  readOnly="true"
	 */
	private JComboBox cmbSesso;
	/**
	 * @uml.property  name="cmbUser"s[0].matches("[A-Za-z][A-Za-z ]+")
	 * @uml.associationEnd  readOnly="true"
	 */
	private JComboBox cmbUser;
	/**
	 * @uml.property  name="chboxRegistratone
"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JCheckBox chboxRegistratone;
	/**
	 * @uml.property  name="separator"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JSeparator separator;
	
	/**
	 * @uml.property  name="usertype"
	 */
	private int usertype;
	/**
	 * @uml.property  name="alreadyRegistered"
	 */
	private boolean alreadyRegistered = false;
	/**
	 * @uml.property  name="patientCreator"
	 * @uml.associationEnd  readOnly="true"
	 */
	private CPaziente patientCreator;
	/**

	 * @uml.property  name="tutorCreator"
	 * @uml.associationEnd  readOnly="true"
	 */
	private CTutore tutorCreator;
	
		
	public RegistrationUI(final Database database, final int userType)
	{	
		setResizable(false);
		setTitle("Orthopediatrics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrationUI.class.getResource("/resources/icons/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 546, 547);
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		lblRegistrazione = new JLabel();

		lblRegistrazione.setForeground(new Color(30, 144, 255));
		lblRegistrazione.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRegistrazione.setIcon(new ImageIcon(RegistrationUI.class.getResource("/resources/icons/icon-small.png")));
		panel = new JPanel();
		lblNome = new JLabel("Nome");
		lblCognome = new JLabel("Cognome");
		lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblNascita = new JLabel("Data di nascita");
		lblSesso = new JLabel("Sesso");
		lblTelefono = new JLabel("Telefono");
		lblIndirizzo = new JLabel("Indirizzo");
		lblEmail = new JLabel("E-Mail");
		
		lblPassword = new JLabel("Password");
		lblConferma = new JLabel("Conferma");
		lblPassword.setForeground(SystemColor.activeCaption);
		lblConferma.setForeground(SystemColor.activeCaption);

		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("+39 ");
		txtTelefono.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtIndirizzo = new JTextField();
		txtIndirizzo.setColumns(10);
		
		txtCodiceFiscale = new JTextField();
		txtCodiceFiscale.setColumns(10);
		
		txtGiorno = new JTextField();
		txtGiorno.setColumns(10);
		
		txtMese = new JTextField();
		txtMese.setColumns(10);
		
		txtAnno = new JTextField();
		txtAnno.setColumns(10);

		
		cmbSesso = new JComboBox();
		cmbSesso.setModel(new DefaultComboBoxModel(new String[] {" Maschio", " Femmina"}));

		lblMinus = new JLabel("-");
		lblMinus2 = new JLabel("-");
		
		lblNewLabel = new JLabel("<html>Al termine della registrazione ti verrà fornito una coppia di chiavi:" +
				"username, password che dovrai utilizzare per l'autenticazione all'interno del sistema.</html>");
		
		separator = new JSeparator();
	
		cmbUser = new JComboBox();
		cmbUser.setEnabled(false);
		cmbUser.setModel(new DefaultComboBoxModel(new String[] {" Paziente", " Tutore"}));
		
		chboxRegistratone = new JCheckBox("precedentemente registrato come ");
				
		btnRegistra = new JButton("Registra");
		btnRegistra.setIcon(new ImageIcon(RegistrationUI.class.getResource("/resources/icons/adduser.png")));
		

		btnChiudi = new JButton("Chiudi");
		btnChiudi.setIcon(new ImageIcon(RegistrationUI.class.getResource("/resources/icons/exit2.png")));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_panel.createSequentialGroup()
		.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
		.addContainerGap().addComponent(lblNome).addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblCognome)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(txtCognome, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
		.addGroup(gl_panel.createSequentialGroup().addGap(53)
		.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(lblCodiceFiscale).addPreferredGap(ComponentPlacement.UNRELATED)
		.addComponent(txtCodiceFiscale, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
		.addGroup(gl_panel.createSequentialGroup().addComponent(lblNascita)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(txtGiorno, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		.addGap(2).addComponent(lblMinus).addGap(6)
		.addComponent(txtMese, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		.addGap(2).addComponent(lblMinus2, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
		.addGap(1).addComponent(txtAnno, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
		.addComponent(lblSesso).addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(cmbSesso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		.addGroup(gl_panel.createSequentialGroup().addGap(54)
		.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup().addComponent(lblIndirizzo)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(txtIndirizzo, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
		.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
		.addGroup(gl_panel.createSequentialGroup().addComponent(lblPassword)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
		.addGroup(gl_panel.createSequentialGroup().addComponent(lblTelefono)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(txtTelefono))).addPreferredGap(ComponentPlacement.RELATED)
		.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
		.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE).addComponent(lblEmail)
		.addPreferredGap(ComponentPlacement.RELATED)).addGroup(gl_panel.createSequentialGroup()
		.addComponent(lblConferma).addGap(8))).addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
		.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
		.addComponent(txtConfirmPassword)))))).addContainerGap()));
		
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup().addGap(25)
		.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
		.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(lblCognome)
		.addComponent(txtCognome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(lblNome))
		.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
		.addComponent(txtCodiceFiscale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(lblCodiceFiscale)).addPreferredGap(ComponentPlacement.UNRELATED)
		.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNascita)
		.addComponent(txtGiorno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(cmbSesso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(lblMinus)
		.addComponent(txtMese, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(lblMinus2)
		.addComponent(txtAnno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(lblSesso))
		.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
		.addComponent(lblIndirizzo)
		.addComponent(txtIndirizzo, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
		.addComponent(lblTelefono)
		.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(lblEmail))
		.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
		.addComponent(lblPassword)
		.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addComponent(lblConferma)
		.addComponent(txtConfirmPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		.addContainerGap(48, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);		
		
		// GROUP LAYOUTS
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
							.addComponent(btnRegistra, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblRegistrazione, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
						.addComponent(lblNewLabel)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(chboxRegistratone)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(cmbUser, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblRegistrazione)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)

					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chboxRegistratone)

						.addComponent(cmbUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnChiudi)
						.addComponent(btnRegistra))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		/************************************************************************************************/
		
		/**
		 * creazione del manager del tutore e del paziente
		 */
		patientCreator = new CPaziente(database);
		tutorCreator = new CTutore(database);
		
		/**
		 * Imposto il titolo della finestra di registrazione
		 * a seconda del tipo di utente che si registra: Tutore o Paziente
		 */
		switch (userType) {
		case xyzt.orthopediatrics.Type.User.PATIENT:
			lblRegistrazione.setText("Registrazione nuovo paziente");
			break;
		case xyzt.orthopediatrics.Type.User.TUTOR:
			lblRegistrazione.setText("Registrazione nuovo tutore");
			break;
		}
		
		/**
		 * Chiusura dell'applicazione
		 */
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new UISupport().closeDialog() == UISupport.YES)
					System.exit(NORMAL);
			}
		});
		
		/**

		 * Viene determinato il tipo di paziente che si era precedentemente
		 * registrato: tutore o paziente;
		 */
		cmbUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cmbUser.getSelectedIndex() == 0)
					usertype = xyzt.orthopediatrics.Type.User.PATIENT;
				else
					usertype = xyzt.orthopediatrics.Type.User.TUTOR;
			}
		});
		
		
		/**
		 * Abilita/Disabilita la checkbox (sopra) in cui si decide che tipo
		 * di utente si era precedentemente registrato
		 */
		chboxRegistratone.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chboxRegistratone.isSelected()) {
					alreadyRegistered = true;
					cmbUser.setEnabled(true);
					txtNome.setEnabled(false);
					txtCognome.setEnabled(false);
					txtCodiceFiscale.setEnabled(false);
					txtIndirizzo.setEnabled(false);
					txtGiorno.setEnabled(false);
					txtMese.setEnabled(false);
					txtAnno.setEnabled(false);
					cmbSesso.setEnabled(false);
					txtTelefono.setEnabled(false);
					txtEmail.setEnabled(false);
					txtPassword.setEnabled(false);
					txtConfirmPassword.setEnabled(false);
				}
				else {
					alreadyRegistered = false;
					cmbUser.setEnabled(false);
					txtNome.setEnabled(true);
					txtCognome.setEnabled(true);
					txtCodiceFiscale.setEnabled(true);
					txtIndirizzo.setEnabled(true);
					txtGiorno.setEnabled(true);
					txtMese.setEnabled(true);
					txtAnno.setEnabled(true);
					cmbSesso.setEnabled(true);
					txtTelefono.setEnabled(true);
					txtEmail.setEnabled(true);
					txtPassword.setEnabled(true);
					txtConfirmPassword.setEnabled(true);
				}
			}
		});
		
		/**
		 * Registrazione di un nuovo paziente o tutore
		 */
		btnRegistra.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				/* L'utente risulta gia' precedentemente registrato come
				 * un tutore o come un paziente; e' necessario quindi solo
				 * verificare l'identita' dell'utente per estendere le sue
				 * funzionalita' facendolo diventare tutore o paziente
				 */
				if (alreadyRegistered == true) {
					new UISupport().loadWindow(new GetExistingUI(usertype, database));
					dispose();
				}
				else
				{
					/* verifichiamo che la password sia stata scritta 'uguale'
					 * due volte, e che la password abbia una lunghezza minima
					 * di 6 caratteri
					 */
					if (!((txtPassword.getText().equals(txtConfirmPassword.getText())) &&
							(txtPassword.getText().length() >= 6))) {
						new UISupport().notifyDialogPasswordNotValid();
						return;
					}
					
					/* controllo del codice fiscale
					 */
					if (txtCodiceFiscale.getText().length() != 16) {
						new UISupport().notifyDialogCFNotValid();
						return;
					}
					
					/* controllo della data di nascita
					 */
					if (!(isValidDate(txtAnno.getText(),txtMese.getText(),txtGiorno.getText()))) {
						new UISupport().notifyDialogDateNotValid();
						return;
					}
					
					/* Controllo nome e cognome
					 */
					if (!((isAlphabetic(txtNome.getText())) && (isAlphabetic(txtCognome.getText())))) {
						new UISupport().notifyDialogNomeCognomeNotValid();
						return;
					}
					
					/* controlla se e' un numero di telefono corretto
					 */
					if (!isTelephone(txtTelefono.getText())) {
						new UISupport().notifyDialogTelefonoNotValid();
						return;
					}
					
					/* Controlla se e' una email valida
					 */
					if (!isEmail(txtEmail.getText())) {
						new UISupport().notifyDialogEmailNotValid();
						return;
					}

					String nomeutente = txtCodiceFiscale.getText().toUpperCase();
					String password = txtPassword.getText();
					String nome = txtNome.getText();
					String cognome = txtCognome.getText();
					String indirizzo = txtIndirizzo.getText();
					String telefono = txtTelefono.getText();
					String email = txtEmail.getText();
					
					int gg = Integer.parseInt(txtGiorno.getText());
					int mm = (Integer.parseInt(txtMese.getText()) - 1);
					int aa = (Integer.parseInt(txtAnno.getText()) - 1900);
					Date nascita = new Date(aa, mm, gg);				

					if (userType == xyzt.orthopediatrics.Type.User.PATIENT)
					{												
						/**
						 * Registrazione Paziente
						 */
						Paziente paziente = new Paziente(nomeutente, password, nome, cognome,
								indirizzo, telefono, email, nascita, null);
						
						/* si controlla che il paziente sia o meno minorenne, ed in tal caso
						 * si chiede che il tutor associato al paziente effettui il login
						 */
						if (paziente.isMinor()) {
							new UISupport().loadWindow(new BindingTutorUI(paziente, database));
							dispose();
						}
						else
							if ((patientCreator.registerNewPatient(paziente))) {
								new UISupport().patientRegisteredDialog(paziente);
								new UISupport().loadWindow(new ClientUI(database));
								dispose();
							}
							else 
								new UISupport().notifyDialogUserAlreadyExists();
					}
					else
					{
						/**
						 * Registrazione TUTORE
						 */
												
						/* Se l'utente che si sta registrando e' un tutore, allora
						 * questo deve essere obbligatoriamente maggiorenne
						 */
						if (((new Calendario().getYear() - aa) - 1900) >= 18) {													
							Tutore tutor = new Tutore(nomeutente, password, nome, cognome,
									indirizzo, telefono, email, nascita);
							if ((tutorCreator.registerNewTutor(tutor)) == true) {
								new UISupport().tutorRegisteredDialog(tutor);
								new UISupport().loadWindow(new ClientUI(database));
								dispose();
							}
							else
								new UISupport().notifyDialogUserAlreadyExists();	
						}
						else
							new UISupport().notifyDialogTutorNoMajor();
					}
				}
				
			}
		});
		
	}
	

	/**
	 * Validazione di una stringa utilizzata per il nome/cognome
	 * degli utenti, evitando che questi inseriscano numeri o 
	 * segni di punteggiatura
	 * @return
	 *  TRUE in caso di nome/cognome valido,
	 *  FALSE altrimenti
	 */
	public static boolean isAlphabetic(String str) {
		return str.matches("[A-Za-z][A-Za-z ]+");
	}
	
	/**
	 * Validazione del numero di telefono; il telefono puo' iniziare
	 * con un "+" sostituendo lo "00" iniziale del prefisso internazionale
	 * @return
	 * 	TRUE se il numero di tel e' valido,
	 *  FALSE altrimenti
	 */
	private boolean isTelephone(String s) {
		return (s.matches("[+][0-9]+")&&(s.length()>9));
	}
  
	/**
	 * Validazione dell'indirizzo email
	 * @return
	 *  TRUE se l'indirizzo e' valida,
	 *  FALSE altrimenti
	 */
	private boolean isEmail(String s) {
		return (s.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));
	}
	
	/**
	 * Validazione della data
	 * @return
	 *  TRUE se la data inserita e' valida,
	 *  FALSE altrimenti
	 */
	private boolean isValidDate(String year, String month, String day)
	{
		SimpleDateFormat dateFormat;
		String date;
		
		if ((year == null) || (month == null) || (day == null))
			return false;
		
		date = year + "-" + month + "-" + day;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		if (date.trim().length() != dateFormat.toPattern().length())
			return false;
		
		dateFormat.setLenient(false);
		
		try {
			dateFormat.parse(date.trim());
		} 
		catch (ParseException pe) {
			return false;
		}
		
		return true;
	}
	
}
