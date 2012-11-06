/* 
 * PrenotazioneUI.java
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
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import xyzt.orthopediatrics.client.Messaggio;
import xyzt.orthopediatrics.client.Paziente;
import xyzt.orthopediatrics.client.creator.CAmministratore;
import xyzt.orthopediatrics.client.creator.CPaziente;
import xyzt.orthopediatrics.client.db.Database;

@SuppressWarnings("serial")
public class PrenotazioneUI extends JFrame
{
	// Panels
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JPanel contentPane;
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
	
	// Labels
	/**
	 * @uml.property  name="lblTitolo"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblTitolo;
	/**
	 * @uml.property  name="lblPaziente"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblPaziente;
	/**
	 * @uml.property  name="lblNomeCognome"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblNomeCognome;
	/**
	 * @uml.property  name="lblDescrizione"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JLabel lblDescrizione;
	
	// String
	/**
	 * @uml.property  name="titolo"
	 */
	private String titolo;
	/**
	 * @uml.property  name="btnPrenota"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JButton btnPrenota;
	
	// TextAreas
	/**
	 * @uml.property  name="txtDescrizione"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextArea txtDescrizione;
	
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


	/* Costruttore della classe
	 */
	public PrenotazioneUI(final int reparto, final Paziente paziente, final Database database)
	{
		setResizable(false);
		setTitle("Orthopediatrics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrenotazioneUI.class.getResource("/resources/icons/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 426);
		
		separator = new JSeparator();
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), 
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), 
				"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		lblTitolo = new JLabel();
		lblTitolo.setForeground(new Color(30, 144, 255));
		lblTitolo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitolo.setIcon(new ImageIcon(PrenotazioneUI.class.getResource("/resources/icons/icon-small.png")));
		
		lblPaziente = new JLabel("Paziente:");
		lblDescrizione = new JLabel("Descrizione:");

		lblNomeCognome = new JLabel( paziente.getNome() + " " + paziente.getCognome());
		lblNomeCognome.setFont(new Font("Dialog", Font.BOLD, 13));
		
		txtDescrizione = new JTextArea();
		txtDescrizione.setToolTipText("Inserire una descrizione");
		txtDescrizione.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(txtDescrizione);
		
		btnPrenota = new JButton("Prenota");
		btnPrenota.setIcon(new ImageIcon(PrenotazioneUI.class.getResource("/resources/icons/prenotazione.png")));
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTitolo, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDescrizione)
									.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPaziente)
									.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
									.addComponent(lblNomeCognome, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPrenota, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitolo)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPaziente)
						.addComponent(lblNomeCognome))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescrizione)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPrenota)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		/***********************************************************************************************/
		
		adminManager = new CAmministratore(database);
		patientManager = new CPaziente(database);

		/**
		 * in base al tipo di reparto in cui si desidera effettuare la
		 * prenotazione, viene stabilito il titolo per la finestra
		 */
		if (reparto == xyzt.orthopediatrics.Type.Reparto.ORTOPEDIA)
			titolo = "Prenotazione Visita Ortopedica";
		else 
			titolo = "Prenotazione Visita Pediatrica";
		lblTitolo.setText(titolo);
		
		/**
		 * RICHIESTA DI PRENOTAZIONE
		 * Il paziente invia un messaggio di richiesta di prenotazione
		 * al sistema
		 */
		btnPrenota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{	
				int type = xyzt.orthopediatrics.Type.Messaggio.REQUEST;
				String str = txtDescrizione.getText();
				String mitt = paziente.getNomeutente();
				String dest = adminManager.getAdmin(reparto).getNomeutente();
				if ((patientManager.reserveVisit(new Messaggio(type, mitt, dest, str, -1)))) {
					new UISupport().notifyDialogRequestReservation();
					dispose();
				}
			}
		});
	}
}
