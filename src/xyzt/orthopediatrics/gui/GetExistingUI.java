/* 
 * GetExistingUI.java
 * This file is part of Orthopediatrics
 *
 * Copyright (C) 2012 Fabian Priftaj <fabian.priftaj@gmail.com>
 * 
 * Piattaforma di moduli applicativi gestionali per l'informatizzazione di 
 * cliniche e strutture ospedaliere, realizzando un sistema informativo
 * completo per il reparto di Pediatria e Ortopedia.
 */

package xyzt.orthopediatrics.gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.Tutore;
import xyzt.orthopediatrics.client.creator.CPaziente;
import xyzt.orthopediatrics.client.creator.CTutore;
import xyzt.orthopediatrics.client.db.Database;

@SuppressWarnings("serial")
public class GetExistingUI extends JFrame
{
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel contentPane;
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
	/**
	 * @uml.property  name="lblLogin"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblLogin;
	/**
	 * @uml.property  name="btnLogin"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnLogin;
	/**
	 * @uml.property  name="separator"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JSeparator separator;
	
	/**
	 * @uml.property  name="tutorManager"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private CTutore tutorManager;
	/**
	 * @uml.property  name="patientManager"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private CPaziente patientManager;
	
	/**
	 * Costruttore della classe
	 * Quest'oggetto verra' richiamato solo in fase di registrazione nel caso in
	 * cui un utente precedentemente registrato presso il sistema come paziente/tutore
	 * decide di registrarsi con un nuovo ruolo: tutore/paziente;
	 * @param usertype - Tipo dell'utente (paziente, tutore)
	 * @param database - Database 
	 */
	public GetExistingUI(final int usertype, final Database database)
	{		
		setResizable(false);
		setTitle("Orthopediatrics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BindingTutorUI.class.getResource("/resources/icons/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 287, 263);
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), 
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, 
				TitledBorder.TOP, null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtPassword = new JPasswordField();
		separator = new JSeparator();	
		
		btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(BindingTutorUI.class.getResource("/resources/icons/login.png")));
		
		lblLogin = new JLabel("Login");
		lblLogin.setIcon(new ImageIcon(BindingTutorUI.class.getResource("/resources/icons/icon-small.png")));
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 17));
		lblLogin.setForeground(new Color(30, 144, 255));
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addComponent(lblUsername)
		.addComponent(lblPassword))
		.addPreferredGap(ComponentPlacement.UNRELATED)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		.addComponent(txtPassword)
		.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
		.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		.addContainerGap(18, Short.MAX_VALUE))
		.addGroup(gl_contentPane.createSequentialGroup()
		.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
		.addGap(18))))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 74, Short.MAX_VALUE)
		.addGap(24)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(lblUsername)
		.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(ComponentPlacement.UNRELATED)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(lblPassword)
		.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(ComponentPlacement.UNRELATED)
		.addComponent(separator, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(btnLogin)
		.addGap(5))
		);
		contentPane.setLayout(gl_contentPane);
		
		//*******************************************************************************************************//
		
		tutorManager = new CTutore(database);
		patientManager = new CPaziente(database);
		
		/**
		 * Autenticazione dell'utente
		 * Nel caso l'autenticazione avviene con successo allora nello stesso
		 * momento avviene anche il binding tra tutore e paziente
		 */
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0)
			{
				Paziente paziente = null;
				Tutore tutore = null;
				
				String username = txtUsername.getText().toUpperCase();
				String password = txtPassword.getText();			
				
				/* L'utente risulta precedentemente registrato come 'PAZIENTE'
				 * e quindi e' necessario estrarre le sue informazioni, e 
				 * registrarlo anche come 'TUTORE'
				 */
				if (usertype == xyzt.orthopediatrics.Type.User.PATIENT) {
					paziente = patientManager.login(username, password);
					if (paziente == null)
						new UISupport().loginErrorAuthentication();
					else {
						tutore = new Tutore(paziente.getNomeutente(), paziente.getPassword(),
								paziente.getNome(), paziente.getCognome(), paziente.getIndirizzo(),
								paziente.getTelefono(), paziente.getEmail(), paziente.getNascita());
						
						if ((tutorManager.registerNewTutor(tutore)) == true)
							new UISupport().tutorRegisteredDialog(tutore);
						else
							new UISupport().notifyDialogUserAlreadyExists();
					}
				}
				/* L'utente risulta precedentemetne registrato come 'TUTORE'
				 * e quindi e' necessario estrarre le sue informazioni, e 
				 * registrarlo anche come 'PAZIENTE'
				 */
				else if (usertype ==  xyzt.orthopediatrics.Type.User.TUTOR) {
					tutore = tutorManager.login(username, password);
					if (tutore == null)
						new UISupport().loginErrorAuthentication();
					else {
						paziente = new Paziente(tutore.getNomeutente(), tutore.getPassword(), tutore.getNome(),
								tutore.getCognome(), tutore.getIndirizzo(), tutore.getTelefono(), tutore.getEmail(),
								tutore.getNascita(), null);
						if ((patientManager.registerNewPatient(paziente)) == true)
							new UISupport().patientRegisteredDialog(paziente);
						else
							new UISupport().notifyDialogUserAlreadyExists();
					}
				}
				
				new UISupport().loadWindow(new ClientUI(database));
				dispose();
			}
		});
	}
}
