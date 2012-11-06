/* 
 * GestioneRefertiUI.java
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
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import xyzt.orthopediatrics.client.Amministratore;
import xyzt.orthopediatrics.client.Prenotazione;
import xyzt.orthopediatrics.client.Referto;
import xyzt.orthopediatrics.client.creator.CAmministratore;
import xyzt.orthopediatrics.client.db.Database;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GestioneRefertiUI extends JFrame
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
	 * @uml.property  name="scrollPrenotazioni"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JScrollPane scrollPrenotazioni;
	/**
	 * @uml.property  name="listModel"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	private DefaultListModel listModel;
	/**
	 * @uml.property  name="listReservation"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JList listReservation;
	/**
	 * @uml.property  name="gl_contentPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private GroupLayout gl_contentPane;
	/**
	 * @uml.property  name="btnVisualizzaReferto"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnVisualizzaReferto;
	/**
	 * @uml.property  name="btnCreaReferto"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnCreaReferto;
	/**
	 * @uml.property  name="btnChiudi"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnChiudi;
	
	/**
	 * @uml.property  name="adminManager"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private CAmministratore adminManager;
	/**
	 * @uml.property  name="reservationList"
	 */
	private LinkedList<Prenotazione> reservationList;

	/**
	 * Creazione del frame
	 * Gestione Referti Medici
	 */
	public GestioneRefertiUI(final Database database, Amministratore admin, int sala)
	{
		setTitle("Orthopediatrics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestioneRefertiUI.class.getResource("/resources/icons/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 467);
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51))));
		setContentPane(contentPane);
		
		lblIcon = new JLabel("Gestione Referti");
		lblIcon.setForeground(new Color(30, 144, 255));
		lblIcon.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIcon.setIcon(new ImageIcon(GestioneRefertiUI.class.getResource("/resources/icons/icon-small.png")));
		
		btnVisualizzaReferto = new JButton("Visualizza");
		btnVisualizzaReferto.setIcon(new ImageIcon(GestioneRefertiUI.class.getResource("/resources/icons/report.png")));
		
		btnCreaReferto = new JButton("Crea/Modifica");
		btnCreaReferto.setIcon(new ImageIcon(GestioneRefertiUI.class.getResource("/resources/icons/bookmark-add.png")));
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.setIcon(new ImageIcon(GestioneRefertiUI.class.getResource("/resources/icons/exit2.png")));
		
		listModel = new DefaultListModel();
		listReservation = new JList(listModel);
		listReservation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listReservation.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		scrollPrenotazioni = new JScrollPane();
		scrollPrenotazioni.setViewportView(listReservation);
		
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addContainerGap()
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
		.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
		.addComponent(btnCreaReferto, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(btnVisualizzaReferto, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
		.addComponent(scrollPrenotazioni, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
		.addContainerGap()));
		
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addContainerGap()
		.addComponent(lblIcon)
		.addGap(18)
		.addComponent(scrollPrenotazioni, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(btnVisualizzaReferto)
		.addComponent(btnCreaReferto))
		.addComponent(btnChiudi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
		.addGap(12)));
		
		contentPane.setLayout(gl_contentPane);
		
		//******************************************************************************************************//
		
		adminManager = new CAmministratore(database);
		reservationList = new LinkedList<Prenotazione>();
		
		/**
		 * Caricamento di tutte le prenotazioni all'interno della lista
		 */
		reservationList = adminManager.fetchReservation(admin);
		for (Prenotazione reservation : reservationList) {
			listModel.addElement(reservation.toString());
		}
		
		/**
		 * Chiusura della finestra
		 */
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		/**
		 * Apertura del frame di creazione referto
		 */
		btnCreaReferto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = listReservation.getSelectedIndex();
				if (index >= 0)
				{
					Prenotazione prenotazione = reservationList.get(index);
					/* prima di creare il nuovo referto si verifica se la prenotazione
					 * non abbia gia' un referto associato in precedenza
					 */
					if ((adminManager.getReport(prenotazione.getId())) != null) {
						Referto referto = adminManager.getReport(prenotazione.getId());
						new UISupport().loadWindow(new CreazioneRefertoUI(prenotazione, database, referto));
					} else 
						new UISupport().loadWindow(new CreazioneRefertoUI(prenotazione, database, null));
				}
				else
					new UISupport().notifyDialogNoReservationSelected();
			}
		});
		
		/**
		 * Visualizzazione di un referto
		 */
		btnVisualizzaReferto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listReservation.getSelectedIndex();
				if (index >= 0) {
					int idPrenotazione = reservationList.get(index).getId();
					if (adminManager.getReport(idPrenotazione) != null)
						new UISupport().notifyDialog(adminManager.getReport(idPrenotazione).toString());
					else
						new UISupport().notifyDialogReservationNoReport();
				}
				else
					new UISupport().notifyDialogNoReservationSelected();
			}
		});
	}
}
