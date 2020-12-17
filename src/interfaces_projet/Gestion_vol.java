package interfaces_projet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import reservation_billets.Avion;
import reservation_billets.Connexion;
import reservation_billets.Reservation;
import reservation_billets.Trajet;
import reservation_billets.Vol;
public class Gestion_vol extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField jourAjoutField;
	private JTextField idVolSupField;
	private JTextField idVolCherField;
	private JTextField heureDepAjoutField;
	private JTextField heureArrivAjouField;
	private JTextField idVolModifField;
	private JTextField jourField;
	private JTextField heureDepField;
	private JTextField heureArrField;
	JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel choicePanel = new JPanel();
	JPanel consulterButtonPanel = new JPanel();
	JPanel ajouterButtonPanel = new JPanel();
	JPanel modifierButtonPanel = new JPanel();
	JPanel supprimerButtonPanel = new JPanel();
	JPanel consulterPanel = new JPanel();
	JPanel supprimerPanel = new JPanel();
	JPanel modifierPanel = new JPanel();
	JPanel ajouterPanel = new JPanel();
	JPanel tablePanel = new JPanel();
	private JTable table ;
	private Vector<Integer> NORMAL_OPTION_TRAJET = Trajet.listeTrajet();
	private Vector<Integer> NORMAL_OPTION_AVION = Avion.listeAvions();
	private Connection conn= Connexion.getConnection() ;
	public Gestion_vol() {
		
		
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
		
		
		modifierButtonPanel.setBackground(Color.WHITE);
		choicePanel.add(modifierButtonPanel);
		modifierButtonPanel.setLayout(null);
		
		JLabel lblNewLabe2 = new JLabel("New label");
		lblNewLabe2.setIcon(new ImageIcon(this.getClass().getResource("/modifier_chibi.png")));
		lblNewLabe2.setBounds(22, 11, 43, 43);
		modifierButtonPanel.add(lblNewLabe2);
		
		JLabel lblNewLabel_2 = new JLabel("Modifier");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(60, 14, 93, 32);
		modifierButtonPanel.add(lblNewLabel_2);
		
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
		
		// Panel for Looking
		consulterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		consulterPanel.setBackground(Color.WHITE);
		consulterPanel.setBounds(0, 60, 809, 352);
		panel_1.add(consulterPanel);
		consulterPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Id Vol                 :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(77, 35, 133, 35);
		consulterPanel.add(lblNewLabel_5);
		
		idVolCherField = new JTextField();
		idVolCherField.setBounds(220, 35, 306,37);
		consulterPanel.add(idVolCherField);
		idVolCherField.setColumns(10);
		
		JButton cherBtn = new JButton("Chercher");
		cherBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		cherBtn.setBounds(556, 31, 162, 40);
		cherBtn.setBackground(new Color(163, 193, 246));
		consulterPanel.add(cherBtn);
		
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(53, 111, 706, 220);
		consulterPanel.add(tablePanel);
		
		// Panel for Deleting
		supprimerPanel.setBackground(Color.WHITE);
		supprimerPanel.setBounds(0, 61, 809, 351);
		supprimerPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Id Vol a Supprimer     :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(62, 61, 199, 31);
		supprimerPanel.add(lblNewLabel_3);
		
		idVolSupField = new JTextField();
		idVolSupField.setBounds(256, 57, 306, 40);
		supprimerPanel.add(idVolSupField);
		idVolSupField.setColumns(10);
		
		JButton supBtn = new JButton("Supprimer");
		supBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		supBtn.setBounds(575, 57, 162, 40);
		supBtn.setBackground(new Color(163, 193, 246));
		supprimerPanel.add(supBtn);
		
		JPanel supprimerMessagePanel = new JPanel();
		supprimerMessagePanel.setBounds(220, 148, 369, 118);
		supprimerPanel.add(supprimerMessagePanel);
		supprimerMessagePanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(this.getClass().getResource("/dele.png")));
		lblNewLabel_4.setBounds(29, 27, 60, 63);
		supprimerMessagePanel.add(lblNewLabel_4);
		
		JLabel lblSuppressionEfectueAvec = new JLabel("Suppression effectu\u00E9e avec succ\u00E9s");
		lblSuppressionEfectueAvec.setForeground(Color.RED);
		lblSuppressionEfectueAvec.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSuppressionEfectueAvec.setBounds(91, 38, 236, 39);
		supprimerMessagePanel.add(lblSuppressionEfectueAvec);
		
		// Panel for Modify
		modifierPanel.setBackground(Color.WHITE);
		modifierPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		modifierPanel.setBounds(0, 60, 809, 352);
		modifierPanel.setLayout(null);
		
		JLabel lblNomCategorie1 = new JLabel("Id Avion                 :");
		lblNomCategorie1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomCategorie1.setBounds(67, 85, 154, 20);
		modifierPanel.add(lblNomCategorie1);
		
		JLabel lblReduction1 = new JLabel("Jour                       :");
		lblReduction1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReduction1.setBounds(67, 142, 142, 20);
		modifierPanel.add(lblReduction1);
		
		JTextField idAvionModifField = new JTextField();
		idAvionModifField.setBounds(218, 82, 544, 28);
		modifierPanel.add(idAvionModifField);
		idAvionModifField.setColumns(10);
		
		JLabel lblIdVol = new JLabel("Id vol  a Modifier   :");
		lblIdVol.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdVol.setBounds(67, 32, 130, 20);
		modifierPanel.add(lblIdVol);
		
		JLabel lblHeureDeapart = new JLabel("Heure Depart        :");
		lblHeureDeapart.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHeureDeapart.setBounds(67, 191, 154, 20);
		modifierPanel.add(lblHeureDeapart);
		
		JLabel lblHeureArrive_1 = new JLabel("Heure Arriv\u00E9e       :");
		lblHeureArrive_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHeureArrive_1.setBounds(67, 241, 154, 20);
		modifierPanel.add(lblHeureArrive_1);
		
		idVolModifField = new JTextField();
		idVolModifField.setColumns(10);
		idVolModifField.setBounds(218, 29, 350, 28);
		modifierPanel.add(idVolModifField);
		
		jourField = new JTextField();
		jourField.setColumns(10);
		jourField.setBounds(218, 139, 544, 28);
		modifierPanel.add(jourField);
		
		heureDepField = new JTextField();
		heureDepField.setColumns(10);
		heureDepField.setBounds(218, 188, 544, 28);
		modifierPanel.add(heureDepField);
		
		heureArrField = new JTextField();
		heureArrField.setColumns(10);
		heureArrField.setBounds(218, 238, 544, 28);
		modifierPanel.add(heureArrField);
		
		JButton btnNewButton_3 = new JButton("Rechercher");
		btnNewButton_3.setBounds(596, 24, 166, 38);
		btnNewButton_3.setBackground(new Color(163, 193, 246));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// get idPassager
				PreparedStatement ps;
				try {
					ps = conn.prepareStatement(" SELECT id_avion,jour_vol,heure_depart,heure_arrivee FROM vol"
							+ " where id_vol=?");
					String idVolText = idVolModifField.getText();
					int idVol = Integer.parseInt(idVolText);
			        ps.setInt(1, idVol);
					ResultSet rs= ps.executeQuery();
					rs.next();
					idAvionModifField.setText(String.valueOf(rs.getInt(1)));
					jourField.setText(rs.getString(2));
					heureDepField.setText(String.valueOf(rs.getTime(3)));
					heureArrField.setText(String.valueOf(rs.getTime(4)));
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		modifierPanel.add(btnNewButton_3);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModifier.setBounds(310, 283, 350, 38);
		btnModifier.setBackground(new Color(163, 193, 246));
		modifierPanel.add(btnModifier);
		
		// Panel for Insertion
		ajouterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ajouterPanel.setBackground(Color.WHITE);
		ajouterPanel.setBounds(0, 59, 809, 353);
		ajouterPanel.setLayout(null);
		
		JLabel lblNomCategorie = new JLabel("Id Trajet                :");
		lblNomCategorie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomCategorie.setBounds(105, 44, 131, 23);
		ajouterPanel.add(lblNomCategorie);
		
		jourAjoutField = new JTextField();
		jourAjoutField.setBounds(246, 124, 489, 35);
		ajouterPanel.add(jourAjoutField);
		jourAjoutField.setColumns(10);
		
		JButton ajoutBtn = new JButton("Ajouter");
		ajoutBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		ajoutBtn.setBounds(366, 281, 274, 35);
		ajoutBtn.setBackground(new Color(163, 193, 246));
		ajouterPanel.add(ajoutBtn);
		
		JLabel lblIdAvion = new JLabel("Id Avion                 :");
		lblIdAvion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdAvion.setBounds(105, 90, 131, 23);
		ajouterPanel.add(lblIdAvion);
		
		JLabel lblJour = new JLabel("Jour                       :");
		lblJour.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJour.setBounds(105, 134, 131, 23);
		ajouterPanel.add(lblJour);
		
		JLabel lblHeureDepart = new JLabel("Heure Depart        :");
		lblHeureDepart.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHeureDepart.setBounds(105, 178, 131, 23);
		ajouterPanel.add(lblHeureDepart);
		
		JLabel lblHeureArrive = new JLabel("Heure Arriv\u00E9e       :");
		lblHeureArrive.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHeureArrive.setBounds(105, 229, 131, 23);
		ajouterPanel.add(lblHeureArrive);
		
		heureDepAjoutField = new JTextField();
		heureDepAjoutField.setColumns(10);
		heureDepAjoutField.setBounds(246, 170, 489, 35);
		ajouterPanel.add(heureDepAjoutField);
		
		heureArrivAjouField = new JTextField();
		heureArrivAjouField.setColumns(10);
		heureArrivAjouField.setBounds(246, 217, 489, 35);
		ajouterPanel.add(heureArrivAjouField);
		
		JComboBox<Integer> idTrajetAjoutCombo = new JComboBox<Integer>();
		idTrajetAjoutCombo.setEditable(true);
		idTrajetAjoutCombo.setForeground(Color.WHITE);
		idTrajetAjoutCombo.setBounds(246, 30, 491, 35);
		for(int i = 0 ; i<NORMAL_OPTION_TRAJET.size();i++) {
			idTrajetAjoutCombo.addItem(NORMAL_OPTION_TRAJET.get(i));
			}
		ajouterPanel.add(idTrajetAjoutCombo);
		
		JComboBox<Integer> idAvionAjoutCombo = new JComboBox<Integer>();
		idAvionAjoutCombo.setEditable(true);
		idAvionAjoutCombo.setBounds(246, 78, 489, 35);
		for(int i = 0 ; i<NORMAL_OPTION_AVION.size();i++) {
			idAvionAjoutCombo.addItem(NORMAL_OPTION_AVION.get(i));
			}
		ajouterPanel.add(idAvionAjoutCombo);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new menu_admin();
				dispose();
			}
		});
		label.setIcon(new ImageIcon(this.getClass().getResource("/icons8_left_30px_1.png")));
		label.setBounds(0, 0, 37, 32);
		panel.add(label);
		
		//  create the table
		DefaultTableModel model = new DefaultTableModel(Vol.listeVolsData(), Vol.listeVolsColumnName());
        table = new JTable(model);
        JPanel panelo = new JPanel();
        panelo.setLayout(new GridLayout(1, 1));
		panelo.setBounds(0, 0,706, 241);
		tablePanel.add(panelo);
        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(706,141));
        panelo.setBackground(Color.white);
        panelo.add(scrollPane);
        
        JLabel messageApresInsertion = new JLabel("Insertion effectue  ");
		messageApresInsertion.setFont(new Font("Tahoma", Font.BOLD, 14));
		messageApresInsertion.setBounds(250, 290, 164, 29);
		
		JLabel messageApresModification = new JLabel("Modification effectue  ");
		messageApresModification.setFont(new Font("Tahoma", Font.BOLD, 14));
		messageApresModification.setBounds(250, 290, 164, 29);
		
        ajoutBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String jour = jourAjoutField.getText();
					String heureDepartText = heureDepAjoutField.getText();
					Time heureDepart = Time.valueOf(heureDepartText);
					String heureArriveText = heureArrivAjouField.getText();
					Time heureArrive = Time.valueOf(heureArriveText);
					int idTrajet = (int) idTrajetAjoutCombo.getSelectedItem();
					int idAvion = (int) idAvionAjoutCombo.getSelectedItem();
					Vol.ajouterVolSeul(idTrajet, jour, heureDepart, heureArrive, idAvion);
					ajouterPanel.add(messageApresInsertion);
					messageApresInsertion.setVisible(true);	
					jourAjoutField.setText("");
					heureArrivAjouField.setText("");
					heureDepAjoutField.setText("");
				}
			});
	        
        btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String jourVol = jourField.getText();
				String heureDepartText = heureDepField.getText();
				Time heureDepart = Time.valueOf(heureDepartText);
				String heureArriveText = heureArrField.getText();
				Time heureArrive = Time.valueOf(heureArriveText);
				String idVolText = idVolModifField.getText();
				int idVol = Integer.parseInt(idVolText);
				String idAvionText = idAvionModifField.getText();
				int idAvion = Integer.parseInt(idAvionText);
				Vol.modifierVol(idVol, jourVol, heureDepart, heureArrive, idAvion);
				modifierPanel.add(messageApresModification);
				messageApresModification.setVisible(true);
				jourField.setText("");
				heureDepField.setText("");
				heureArrField.setText("");
				idVolModifField.setText("");
				idAvionModifField.setText("");
			}
		});
        
        supBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idVolText = idVolSupField.getText();
				int idVol = Integer.parseInt(idVolText);
				Vol.supprimerVol(idVol);
				supprimerPanel.add(supprimerMessagePanel);
				supprimerMessagePanel.setVisible(true);
				idVolSupField.setText("");
			}
		});
		
		cherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idVolText = idVolCherField.getText();
				int idVol = Integer.parseInt(idVolText);
				DefaultTableModel model1 = new DefaultTableModel(Vol.listeVolsData(idVol), Vol.listeVolsColumnName());
				table.setModel(model1);
				idVolCherField.setText("");
			}
		});
		
		consulterButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				consulterButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				modifierButtonPanel.setBackground(Color.WHITE);
				ajouterButtonPanel.setBackground(Color.WHITE);
				supprimerButtonPanel.setBackground(Color.WHITE);
				ajouterPanel.setVisible(false);
				supprimerPanel.setVisible(false);
				modifierPanel.setVisible(false);
				panel_1.add(consulterPanel);
				consulterPanel.setVisible(true);
				DefaultTableModel model = new DefaultTableModel(Vol.listeVolsData(), Vol.listeVolsColumnName());
				table.setModel(model);
				Gestion_vol.this.validate();
				Gestion_vol.this.repaint();
			}
		});
		ajouterButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ajouterButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				modifierButtonPanel.setBackground(Color.WHITE);
				consulterButtonPanel.setBackground(Color.WHITE);
				supprimerButtonPanel.setBackground(Color.WHITE);
				consulterPanel.setVisible(false);
				supprimerPanel.setVisible(false);
				modifierPanel.setVisible(false);
				panel_1.add(ajouterPanel);
				ajouterPanel.setVisible(true);
				messageApresInsertion.setVisible(false);
				Gestion_vol.this.validate();
				Gestion_vol.this.repaint();
			}
		});
		modifierButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modifierButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				consulterButtonPanel.setBackground(Color.WHITE);
				ajouterButtonPanel.setBackground(Color.WHITE);
				supprimerButtonPanel.setBackground(Color.WHITE);
				ajouterPanel.setVisible(false);
				supprimerPanel.setVisible(false);
				consulterPanel.setVisible(false);
				panel_1.add(modifierPanel);
				modifierPanel.setVisible(true);
				messageApresModification.setVisible(false);	
				Gestion_vol.this.validate();
				Gestion_vol.this.repaint();
			}
		});
		supprimerButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				supprimerButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				modifierButtonPanel.setBackground(Color.WHITE);
				ajouterButtonPanel.setBackground(Color.WHITE);
				consulterButtonPanel.setBackground(Color.WHITE);
				ajouterPanel.setVisible(false);
				consulterPanel.setVisible(false);
				modifierPanel.setVisible(false);
				panel_1.add(supprimerPanel);
				supprimerPanel.setVisible(true);
				supprimerMessagePanel.setVisible(false);
				Gestion_vol.this.validate();
				Gestion_vol.this.repaint();
			}
		});
		
		setSize(900,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new Gestion_vol();
	}
}
