package interfaces_projet;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

import reservation_billets.Avion;
import reservation_billets.Trajet;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class gestion_avion extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField matriculeField;
	private JTextField heureArriveField;
	private JTextField jourField;
	private JTextField autonomieField;
	private JTextField heureDepartField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel choicePanel = new JPanel();
	private JPanel ajouterButtonPanel = new JPanel();
	private JPanel consulterPanel = new JPanel();
	private JPanel supprimerButtonPanel = new JPanel();
	private JPanel consulterButtonPanel = new JPanel();
	private JPanel ajouterPanel = new JPanel();
	private JPanel supprimerPanel = new JPanel();
	private JPanel supprimerMessagePanel = new JPanel();
	private JPanel tablePanel = new JPanel();
	private JTable table ;
	private Vector<Integer> NORMAL_OPTION = Trajet.listeTrajet();
	public gestion_avion() {

		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panel_1.setBounds(38, 27, 809, 412);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		choicePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		choicePanel.setBounds(0, 0, 809, 61);
		panel_1.add(choicePanel);
		choicePanel.setLayout(new GridLayout(1, 4, 0, 0));
		
		consulterButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
		choicePanel.add(consulterButtonPanel);
		consulterButtonPanel.setLayout(null);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon(this.getClass().getResource("/chercher_chibi.png")));
		label_2.setBounds(10, 11, 43, 43);
		consulterButtonPanel.add(label_2);
		
		JLabel lblConsulter = new JLabel("Consulter");
		lblConsulter.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsulter.setBounds(60, 14, 93, 32);
		consulterButtonPanel.add(lblConsulter);


		ajouterButtonPanel.setBackground(Color.WHITE);
		choicePanel.add(ajouterButtonPanel);
		ajouterButtonPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/ajouter_chibi.png")));
		lblNewLabel.setBounds(22, 11, 43, 43);
		ajouterButtonPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(60, 14, 93, 32);
		ajouterButtonPanel.add(lblNewLabel_1);
		
	
		supprimerButtonPanel.setBackground(Color.WHITE);
		choicePanel.add(supprimerButtonPanel);
		supprimerButtonPanel.setLayout(null);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/supprimer chibi.png")));
		label_1.setBounds(10, 11, 43, 43);
		supprimerButtonPanel.add(label_1);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupprimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSupprimer.setBounds(64, 14, 93, 32);
		supprimerButtonPanel.add(lblSupprimer);
		
	
		consulterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		consulterPanel.setBackground(Color.WHITE);
		consulterPanel.setBounds(0, 59, 809, 353);
		panel_1.add(consulterPanel);
		consulterPanel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Id Avion a Chercher :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(85, 48, 164, 32);
		consulterPanel.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(230, 48, 280, 32);
		consulterPanel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton chercherBtn = new JButton("Chercher");
		chercherBtn.setForeground(Color.black);
		chercherBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
		chercherBtn.setBackground(new Color(163, 193, 246));
		
		chercherBtn.setBounds(522, 42, 200, 41);
		consulterPanel.add(chercherBtn);
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(53, 111, 706, 220);
		consulterPanel.add(tablePanel);
		tablePanel.setLayout(null);
		
        //  create the table
		DefaultTableModel model = new DefaultTableModel(Avion.listeAvionsData(), Avion.listeAvionsColumnName());
        table = new JTable(model);
        JPanel panelo = new JPanel();
        panelo.setLayout(new GridLayout(1, 1));
		panelo.setBounds(0, 0,706, 141);
		tablePanel.add(panelo);
        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(706,141));
        panelo.setBackground(Color.white);
        panelo.add(scrollPane);
        
        
        chercherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idAvionText = textField_5.getText();
				int idAvion = Integer.parseInt(idAvionText);
				DefaultTableModel model1 = new DefaultTableModel(Avion.listeAvionsData(idAvion), Avion.listeAvionsColumnName());
				table.setModel(model1);
			}
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/icons8_left_30px_1.png")));
		label.setBounds(0, 0, 37, 32);
		panel.add(label);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new menu_admin();
				dispose();
			}
		});
		
		//panel de suppresion

		supprimerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		supprimerPanel.setBackground(Color.WHITE);
		supprimerPanel.setBounds(0, 60, 809, 352);
		supprimerPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Id Avion a Supprimer :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(85, 48, 164, 32);
		supprimerPanel.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(266, 50, 221, 30);
		supprimerPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton supprimerBtn = new JButton("Supprimer");
		supprimerBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		supprimerBtn.setBounds(521, 48, 200, 35);
		supprimerBtn.setBackground(new Color(163, 193, 246));
		supprimerPanel.add(supprimerBtn);
		
		
		supprimerMessagePanel.setBackground(Color.white);
		supprimerMessagePanel.setForeground(Color.RED);
		supprimerMessagePanel.setBounds(161, 147, 478, 123);
		supprimerMessagePanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(this.getClass().getResource("/delplane.png")));
		lblNewLabel_4.setBounds(53, 24, 77, 77);
		supprimerMessagePanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("l'Avion a \u00E9te Supprim\u00E9e Avec succ\u00E8s");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBackground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(164, 49, 250, 25);
		supprimerMessagePanel.add(lblNewLabel_5);
		
		supprimerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idAvionText = textField_4.getText();
				int idAvion = Integer.parseInt(idAvionText);
				Avion.SupprimerAvion(idAvion);
				supprimerPanel.add(supprimerMessagePanel);
				supprimerMessagePanel.setVisible(true);
				gestion_avion.this.validate();
				gestion_avion.this.repaint();
			}
		});
		
		//panel for adding
		ajouterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ajouterPanel.setBackground(Color.WHITE);
		ajouterPanel.setBounds(0, 60, 809, 352);
		ajouterPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Matricule      :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(36, 42, 95, 29);
		ajouterPanel.add(lblNewLabel_2);
		
		matriculeField = new JTextField();
		matriculeField.setBounds(141, 42, 199, 32);
		ajouterPanel.add(matriculeField);
		matriculeField.setColumns(10);
		
		heureArriveField = new JTextField();
		heureArriveField.setColumns(10);
		heureArriveField.setBounds(563, 221, 199, 32);
		ajouterPanel.add(heureArriveField);
		
		jourField = new JTextField();
		jourField.setColumns(10);
		jourField.setBounds(141, 166, 199, 32);
		ajouterPanel.add(jourField);
		
		autonomieField = new JTextField();
		autonomieField.setColumns(10);
		autonomieField.setBounds(141, 101, 199, 32);
		ajouterPanel.add(autonomieField);
		
		heureDepartField = new JTextField();
		heureDepartField.setColumns(10);
		heureDepartField.setBounds(563, 166, 199, 32);
		ajouterPanel.add(heureDepartField);
		
		JLabel lblAutonomie = new JLabel("Autonomie :");
		lblAutonomie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutonomie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutonomie.setBounds(10, 101, 117, 29);
		ajouterPanel.add(lblAutonomie);
		
		JLabel lblJour = new JLabel("Jour             :");
		lblJour.setHorizontalAlignment(SwingConstants.LEFT);
		lblJour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJour.setBounds(36, 166, 93, 29);
		ajouterPanel.add(lblJour);
		
		JLabel lblTrajet = new JLabel("Trajet          :");
		lblTrajet.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrajet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrajet.setBounds(36, 221, 93, 29);
		ajouterPanel.add(lblTrajet);
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(141, 221, 200, 32);
		for(int i = 0 ; i<NORMAL_OPTION.size();i++) {
		comboBox.addItem(NORMAL_OPTION.get(i));
		}
		ajouterPanel.add(comboBox);
		
		JLabel lblHeuredepart = new JLabel("Heure-Depart               :");
		lblHeuredepart.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeuredepart.setBounds(390, 166, 163, 29);
		ajouterPanel.add(lblHeuredepart);
		
		JLabel lblHeurearrive = new JLabel("Heure-Arrive                :");
		lblHeurearrive.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeurearrive.setBounds(390, 221, 163, 29);
		ajouterPanel.add(lblHeurearrive);
		
		JLabel lblNombredePlacesclasse = new JLabel("Capacite Affaire            :");
		lblNombredePlacesclasse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombredePlacesclasse.setBounds(390, 42, 163, 29);
		ajouterPanel.add(lblNombredePlacesclasse);
		
		JSpinner spinnerAffaire = new JSpinner();
		spinnerAffaire.setBounds(563, 41, 199, 34);
		ajouterPanel.add(spinnerAffaire);
		
		JSpinner spinnerEconomique = new JSpinner();
		spinnerEconomique.setBounds(563, 100, 199, 34);
		ajouterPanel.add(spinnerEconomique);
		
		JLabel lblCapaciteEconomique = new JLabel("Capacite Economique  :");
		lblCapaciteEconomique.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCapaciteEconomique.setBounds(390, 101, 164, 29);
		ajouterPanel.add(lblCapaciteEconomique);
		
		JLabel messageApresInsertion = new JLabel("Insertion effectue  :");
		messageApresInsertion.setFont(new Font("Tahoma", Font.BOLD, 14));
		messageApresInsertion.setBounds(250, 290, 164, 29);
		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAjouter.setBounds(563, 287, 199, 34);
		btnAjouter.setBackground(new Color(163, 193, 246));
		ajouterPanel.add(btnAjouter);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matricule = matriculeField.getText();
				String jourVol = jourField.getText();
				String autonomieText = autonomieField.getText();
				double autonomie = Double.parseDouble(autonomieText);
				String heureDepartText = heureDepartField.getText();
				Time heureDepart = Time.valueOf(heureDepartText);
				String heureArriveText = heureArriveField.getText();
				Time heureArrive = Time.valueOf(heureArriveText);
				int p_d_affaire = (Integer) spinnerAffaire.getValue();
				int p_d_economique = (Integer) spinnerEconomique.getValue();
				int idTrajet = (int) comboBox.getSelectedItem();
				Avion.ajouterAvion(autonomie, matricule,idTrajet,jourVol,heureDepart,heureArrive,p_d_affaire,p_d_economique);
				ajouterPanel.add(messageApresInsertion);
				messageApresInsertion.setVisible(true);
				matriculeField.setText("");
				jourField.setText("");
				autonomieField.setText("");
				heureArriveField.setText("");
				heureDepartField.setText("");
				spinnerAffaire.setValue(0);
				spinnerEconomique.setValue(0);
				gestion_avion.this.validate();
				gestion_avion.this.repaint();
			}
		});
		
		ajouterButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ajouterButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				consulterButtonPanel.setBackground(Color.white);
				supprimerButtonPanel.setBackground(Color.white);
				consulterPanel.setVisible(false);
				supprimerPanel.setVisible(false);
				panel_1.add(ajouterPanel);
				ajouterPanel.setVisible(true);
				messageApresInsertion.setVisible(false);
				gestion_avion.this.validate();
				gestion_avion.this.repaint();
			}
		});
		consulterButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ajouterButtonPanel.setBackground(Color.white);
				consulterButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				supprimerButtonPanel.setBackground(Color.white);
				ajouterPanel.setVisible(false);
				supprimerPanel.setVisible(false);
				consulterPanel.setVisible(true);
				DefaultTableModel model = new DefaultTableModel(Avion.listeAvionsData(), Avion.listeAvionsColumnName());
				table.setModel(model);
				textField_5.setText("");
				gestion_avion.this.validate();
				gestion_avion.this.repaint();
			}
		});
		supprimerButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ajouterButtonPanel.setBackground(Color.white);
				consulterButtonPanel.setBackground(Color.white);
				supprimerButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				consulterPanel.setVisible(false);
				ajouterPanel.setVisible(false);
				panel_1.add(supprimerPanel);
				supprimerPanel.setVisible(true);
				supprimerMessagePanel.setVisible(false);
				textField_4.setText("");
				gestion_avion.this.validate();
				gestion_avion.this.repaint();
			}
		});
		setSize(900,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new gestion_avion();
	}
}
