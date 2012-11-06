/* 
 * AdminDBCredentials.java
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

import xyzt.orthopediatrics.client.Amministratore;
import xyzt.orthopediatrics.client.creator.CAmministratore;
import xyzt.orthopediatrics.client.db.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminDBCredentials extends JFrame
{
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel contentPane;
	/**
	 * @uml.property  name="txtPassword"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPasswordField txtPassword;
	/**
	 * @uml.property  name="txtConfermaPassword"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPasswordField txtConfermaPassword;
	/**
	 * @uml.property  name="txtUsername"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField txtUsername;
	/**
	 * @uml.property  name="lblPassword"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblPassword;
	/**
	 * @uml.property  name="lblPasswordConfirm"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblPasswordConfirm;
	/**
	 * @uml.property  name="lblInserireLeCredenziali"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblInserireLeCredenziali;
	/**
	 * @uml.property  name="btnSalva"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnSalva;
	/**
	 * @uml.property  name="lblUsername"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblUsername;

	/**
	 * Create the frame.
	 */
	public AdminDBCredentials(final Amministratore admin, final Database database)
	{
		setResizable(false);
		setTitle("Orthopediatrics");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		lblPassword = new JLabel("Password");
		lblPasswordConfirm = new JLabel("Conferma");
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtConfermaPassword = new JPasswordField();
		
		lblInserireLeCredenziali = new JLabel("<html>Inserire i nuovi dati di accesso al database</html>");
		
		btnSalva = new JButton("Salva");
		btnSalva.setIcon(new ImageIcon(DBAccessUI.class.getResource("/resources/icons/dbsave.png")));
		
		lblUsername = new JLabel("Username");
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPassword)
										.addComponent(lblPasswordConfirm)
										.addComponent(lblUsername))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
										.addComponent(txtConfermaPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
										.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
							.addGap(15))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnSalva, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(17, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblInserireLeCredenziali)
							.addContainerGap(17, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInserireLeCredenziali)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtConfermaPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPasswordConfirm))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalva, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		// ******************************************************************************************************* //
		
		/**
		 * Salvataggio delle credenziali di accesso al database
		 */
		btnSalva.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (txtPassword.getText().equals(txtConfermaPassword.getText())) {
					CAmministratore adminCreator = new CAmministratore(database);
					adminCreator.changeCredentials(admin, txtUsername.getText(), txtPassword.getText());
					new UISupport().notifyDialog("Le credenziali di accesso al database sono state modificate");
					dispose();
				}
				else
					new UISupport().notifyDialog("Confermare la password in modo corretto!");
			}
		});
	}
}
