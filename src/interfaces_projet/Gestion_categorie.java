package interfaces_projet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import  javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

import reservation_billets.Categorie;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
public class Gestion_categorie  extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField nomCategorieAjoutField;
	private JTextField reductionAjoutField;
	private JTextField reductionModifField;
	private JTextField nomCategorieSuppField;
	private JTextField chercherNomCategorieField;
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel choicePanel = new JPanel();
	private JPanel ajouterButtonPanel = new JPanel();
	private JPanel modifierButtonPanel = new JPanel();
	private JPanel supprimerButtonPanel = new JPanel();
	private JPanel consulterButtonPanel = new JPanel();
	private JPanel ajouterPanel = new JPanel();
	private JPanel supprimerPanel = new JPanel();
	private JPanel modifierPanel = new JPanel();
	private JPanel supprimerMessagePanel = new JPanel();
	private JPanel tablePanel = new JPanel();
	private JPanel consulterPanel = new JPanel();
	private JTable table ;
	public Gestion_categorie() {		
		
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
		lblConsulter.setForeground(Color.BLACK);
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
		lblNewLabel_1.setForeground(Color.BLACK);
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
		lblNewLabel_2.setForeground(Color.BLACK);
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
		lblSupprimer.setForeground(Color.BLACK);
		lblSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupprimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSupprimer.setBounds(64, 14, 93, 32);
		supprimerButtonPanel.add(lblSupprimer);
		
		
		consulterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		consulterPanel.setBackground(Color.WHITE);
		consulterPanel.setBounds(0, 60, 809, 352);
		panel_1.add(consulterPanel);
		consulterPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Nom Categorie :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(91, 35, 119, 35);
		consulterPanel.add(lblNewLabel_5);
		
		chercherNomCategorieField = new JTextField();
		chercherNomCategorieField.setBounds(220, 35, 306,37);
		consulterPanel.add(chercherNomCategorieField);
		chercherNomCategorieField.setColumns(10);
		
		JButton chercherBtn = new JButton("Chercher");
		chercherBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		chercherBtn.setBounds(556, 31, 162, 40);
		chercherBtn.setBackground(new Color(163, 193, 246));
		consulterPanel.add(chercherBtn);
		
		
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
		
		// Panel for Deleting
		
		supprimerPanel.setBackground(Color.WHITE);
		supprimerPanel.setBounds(0, 61, 809, 351);
		supprimerPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nom Categorie a Supprimer  :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(62, 61, 199, 31);
		supprimerPanel.add(lblNewLabel_3);
		
		nomCategorieSuppField = new JTextField();
		nomCategorieSuppField.setBounds(256, 57, 306, 40);
		supprimerPanel.add(nomCategorieSuppField);
		nomCategorieSuppField.setColumns(10);
		
		JButton supprimerBtn = new JButton("Supprimer");
		supprimerBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		supprimerBtn.setBounds(575, 57, 162, 40);
		supprimerBtn.setBackground(new Color(163, 193, 246));
		supprimerPanel.add(supprimerBtn);
		
		supprimerMessagePanel.setBounds(220, 148, 369, 118);
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
		
		// Panel for modify
		
		modifierPanel.setBackground(Color.WHITE);
		modifierPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		modifierPanel.setBounds(0, 60, 809, 352);
		modifierPanel.setLayout(null);
		
		JLabel lblNomCategorie1 = new JLabel("Nom Categorie         :");
		lblNomCategorie1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomCategorie1.setBounds(115, 90, 154, 20);
		modifierPanel.add(lblNomCategorie1);
		
		JLabel lblReduction1 = new JLabel("nouvelle Reduction :");
		lblReduction1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReduction1.setBounds(115, 147, 142, 20);
		modifierPanel.add(lblReduction1);
		
		JTextField nomCategorieModifField = new JTextField();
		nomCategorieModifField.setBounds(279, 86, 283, 38);
		modifierPanel.add(nomCategorieModifField);
		nomCategorieModifField.setColumns(10);
		
		JButton modifierBtn = new JButton("Modifier");
		modifierBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		modifierBtn.setBounds(279, 211, 283, 38);
		modifierBtn.setBackground(new Color(163, 193, 246));
		modifierPanel.add(modifierBtn);
		
		reductionModifField = new JTextField();
		reductionModifField.setColumns(10);
		reductionModifField.setBounds(279, 148, 283, 38);
		modifierPanel.add(reductionModifField);
		
		//Panel for Insertion
		ajouterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ajouterPanel.setBackground(Color.WHITE);
		ajouterPanel.setBounds(0, 59, 809, 353);
		ajouterPanel.setLayout(null);
		
		JLabel lblNomCategorie = new JLabel("Nom Categorie  :");
		lblNomCategorie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomCategorie.setBounds(84, 111, 124, 23);
		ajouterPanel.add(lblNomCategorie);
		
		JLabel lblReduction = new JLabel("Reduction         :");
		lblReduction.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReduction.setBounds(84, 166, 106, 35);
		ajouterPanel.add(lblReduction);
		
		nomCategorieAjoutField = new JTextField();
		nomCategorieAjoutField.setBounds(225, 105, 277, 35);
		ajouterPanel.add(nomCategorieAjoutField);
		nomCategorieAjoutField.setColumns(10);
		
		reductionAjoutField = new JTextField();
		reductionAjoutField.setBounds(225, 166, 277, 35);
		ajouterPanel.add(reductionAjoutField);
		reductionAjoutField.setColumns(10);
		
		JButton ajouterBtn = new JButton("Ajouter");
		ajouterBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		ajouterBtn.setBounds(228, 224, 274, 35);
		ajouterBtn.setBackground(new Color(163, 193, 246));
		ajouterPanel.add(ajouterBtn);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(this.getClass().getResource("/hamid.png")));
		label_3.setBounds(541, 85, 185, 185);
		ajouterPanel.add(label_3);
		
		JLabel messageApresInsertion = new JLabel("Insertion effectue  ");
		messageApresInsertion.setFont(new Font("Tahoma", Font.BOLD, 14));
		messageApresInsertion.setBounds(250, 290, 164, 29);
		
		JLabel messageApresModification = new JLabel("Modification effectue  ");
		messageApresModification.setFont(new Font("Tahoma", Font.BOLD, 14));
		messageApresModification.setBounds(250, 290, 164, 29);
		
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(53, 111, 706, 220);
		consulterPanel.add(tablePanel);
		
		//  create the table
		DefaultTableModel model = new DefaultTableModel(Categorie.listeCategoriesData(), Categorie.listeCategoriesColumnName());
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
	        
	        ajouterBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nomCategorie = nomCategorieAjoutField.getText();
					String reductionText = reductionAjoutField.getText();
					double reduction = Double.parseDouble(reductionText);
					Categorie.ajouterCategorie(nomCategorie, reduction);
					ajouterPanel.add(messageApresInsertion);
					messageApresInsertion.setVisible(true);	
					nomCategorieAjoutField.setText("");
					reductionAjoutField.setText("");
				}
			});
	        
	        modifierBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nomCategorie = nomCategorieModifField.getText();
					String reductionText = reductionModifField.getText();
					double reduction = Double.parseDouble(reductionText);
					Categorie.modifierCategorie(nomCategorie, reduction);
					modifierPanel.add(messageApresModification);
					messageApresModification.setVisible(true);
					nomCategorieModifField.setText("");
					reductionModifField.setText("");
				}
			});
	        
	        supprimerBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nomCategorie = nomCategorieSuppField.getText();
					Categorie.supprimerCategorie(nomCategorie);
					supprimerPanel.add(supprimerMessagePanel);
					supprimerMessagePanel.setVisible(true);
					nomCategorieSuppField.setText("");
				}
			});
		
		chercherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idCategorieText = chercherNomCategorieField.getText();
				int idCategorie = Integer.parseInt(idCategorieText);
				DefaultTableModel model1 = new DefaultTableModel(Categorie.listeCategoriesData(idCategorie), Categorie.listeCategoriesColumnName());
				table.setModel(model1);
				chercherNomCategorieField.setText("");
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
				DefaultTableModel model = new DefaultTableModel(Categorie.listeCategoriesData(), Categorie.listeCategoriesColumnName());
				table.setModel(model);
				Gestion_categorie.this.validate();
				Gestion_categorie.this.repaint();
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
				Gestion_categorie.this.validate();
				Gestion_categorie.this.repaint();
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
				Gestion_categorie.this.validate();
				Gestion_categorie.this.repaint();
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
				Gestion_categorie.this.validate();
				Gestion_categorie.this.repaint();
			}
		});
		
		setSize(900,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Gestion_categorie();
	}
}
