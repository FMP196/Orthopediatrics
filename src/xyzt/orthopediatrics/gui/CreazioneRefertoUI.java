/* 
 * CreazioneReferto.java
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.Referto;
import xyzt.orthopediatrics.client.creator.CAmministratore;
import xyzt.orthopediatrics.client.db.Database;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class CreazioneRefertoUI extends JFrame
{
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel contentPane;
	/**
	 * @uml.property  name="lblIcon"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblIcon;
	/**
	 * @uml.property  name="lblMedico"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblMedico;
	/**
	 * @uml.property  name="scrollPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPane;
	/**
	 * @uml.property  name="gl_contentPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private GroupLayout gl_contentPane;
	/**
	 * @uml.property  name="btnSalva"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnSalva;
	/**
	 * @uml.property  name="btnChiudi"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnChiudi;
	/**
	 * @uml.property  name="txtMedico"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField txtMedico;
	/**
	 * @uml.property  name="lblDescrizione"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel lblDescrizione;
	/**
	 * @uml.property  name="txtDescrizione"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextArea txtDescrizione;
	
	/**
	 * @uml.property  name="adminManager"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private CAmministratore adminManager;

	/**
	 * Creazione del frame
	 * Gestione Referti Medici
	 */
	public CreazioneRefertoUI(final Prenotazione prenotazione, Database database, final Referto referto)
	{
		setTitle("Orthopediatrics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestioneRefertiUI.class.getResource("/resources/icons/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 360);
				
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		lblIcon = new JLabel("Creazione nuovo referto");
		lblIcon.setForeground(new Color(30, 144, 255));
		lblIcon.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIcon.setIcon(new ImageIcon(GestioneRefertiUI.class.getResource("/resources/icons/icon-small.png")));
		
		btnSalva = new JButton("Salva");
		btnSalva.setIcon(new ImageIcon(GestioneRefertiUI.class.getResource("/resources/icons/bookmark-add.png")));
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.setIcon(new ImageIcon(GestioneRefertiUI.class.getResource("/resources/icons/exit2.png")));
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		lblMedico = new JLabel("Medico:");
		
		String medico;
		String report;
		
		if (referto == null) {
			medico = "";
			report = "";
		}
		else {
			medico = referto.getMedico();
			report = referto.getContenuto();
		}
		
		txtMedico = new JTextField();
		txtMedico.setColumns(10);
		txtMedico.setText(medico);
		
		lblDescrizione = new JLabel("Descrizione:");

		txtDescrizione = new JTextArea();
		txtDescrizione.setText(report);
		scrollPane.setViewportView(txtDescrizione);
		
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
							.addGap(147))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMedico)
								.addComponent(lblDescrizione))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
									.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSalva, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtMedico, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))))))
					.addGap(7))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIcon)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMedico)
						.addComponent(txtMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescrizione)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalva)
						.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(11))
		);		
		contentPane.setLayout(gl_contentPane);
		
		/******************************************************************************************************/
		
		adminManager = new CAmministratore(database);

		/**
		 * Chiusura della finestra
		 */
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		/**
		 * Salvataggio di un nuovo referto all'interno del database
		 */
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				int idPrenotazione = prenotazione.getId();
				String contenuto = txtDescrizione.getText();
				String medico = txtMedico.getText();
				String paziente = prenotazione.getPaziente();
				
				if (referto == null) {
					if (adminManager.addReport(new Referto(idPrenotazione, contenuto, medico, paziente))) {
						new UISupport().notifyDialogReportSaved();
						dispose();
					}
					else
						new UISupport().notifyDialogReportSavedERROR();
				} 
				else {
					referto.setMedico(medico);
					referto.setContenuto(contenuto);
					if (adminManager.editReport(referto)) {
						new UISupport().notifyDialogReportSaved();
						dispose();
					}
					else
						new UISupport().notifyDialogReportSavedERROR();
				}
				
			}
		});
	}
}
