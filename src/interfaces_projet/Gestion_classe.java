package interfaces_projet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import reservation_billets.Classe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Gestion_classe extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField nomClasseAjouField;
	private JTextField prixAjoutField;
	private JTextField nouvPrixModifField;
	private JTextField nomClasseSuppField;
	private JTextField textField_5;
	private JTextField idAvionSuppField;
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
	JPanel supprimerMessagePanel = new JPanel();
	JPanel tablePanel = new JPanel();
	private JTable table ;
	public Gestion_classe()
	{
			
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
		
		// Panel for looking
		consulterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		consulterPanel.setBackground(Color.WHITE);
		consulterPanel.setBounds(0, 60, 809, 352);
		panel_1.add(consulterPanel);
		consulterPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Nom Classe   :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(91, 35, 119, 35);
		consulterPanel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(220, 35, 306,37);
		consulterPanel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton chercherBtn = new JButton("Chercher");
		chercherBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		chercherBtn.setBackground(new Color(163, 193, 246));
		chercherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		chercherBtn.setBounds(556, 31, 162, 40);
		consulterPanel.add(chercherBtn);
		
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(53, 111, 706, 220);
		consulterPanel.add(tablePanel);
		
		// Panel for Deleting
		supprimerPanel.setBackground(Color.WHITE);
		supprimerPanel.setBounds(0, 61, 809, 351);
		supprimerPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nom Classe a Supprimer  :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(62, 61, 199, 31);
		supprimerPanel.add(lblNewLabel_3);
		
		nomClasseSuppField = new JTextField();
		nomClasseSuppField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				nomClasseSuppField.setBorder(new LineBorder(Color.blue, 1));
			}
		});
	
		nomClasseSuppField.setBounds(256, 57, 306, 40);
		supprimerPanel.add(nomClasseSuppField);
		nomClasseSuppField.setColumns(10);
		
		JButton suppBtn = new JButton("Supprimer Classe d'un avion");
		suppBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		suppBtn.setBounds(100, 150, 300, 40);
		suppBtn.setBackground(new Color(163, 193, 246));
		supprimerPanel.add(suppBtn);
		
		JButton suppBtnDef = new JButton("Supprimer Classe definitevement");
		suppBtnDef.setFont(new Font("Tahoma", Font.BOLD, 18));
		suppBtnDef.setBounds(420, 150, 360, 40);
		suppBtnDef.setBackground(new Color(163, 193, 246));
		supprimerPanel.add(suppBtnDef);
		
		
		supprimerMessagePanel.setBounds(223, 200, 369, 118);
		supprimerMessagePanel.setBackground(Color.white);
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
		
		JLabel label = new JLabel("Id Avion                           :");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(62, 114, 199, 31);
		supprimerPanel.add(label);
		
		idAvionSuppField = new JTextField();
		idAvionSuppField.setColumns(10);
		idAvionSuppField.setBounds(256, 103, 306, 40);
		supprimerPanel.add(idAvionSuppField);
		
		// Panel for Modify
		modifierPanel.setBackground(Color.WHITE);
		modifierPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		modifierPanel.setBounds(0, 60, 809, 352);
		modifierPanel.setLayout(null);
		
		JLabel lblNomCategorie1 = new JLabel("Nom Classe                :");
		lblNomCategorie1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomCategorie1.setBounds(115, 90, 154, 20);
		modifierPanel.add(lblNomCategorie1);
		
		JLabel lblReduction1 = new JLabel("Nouveau Prix par KM :");
		lblReduction1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReduction1.setBounds(115, 147, 142, 20);
		modifierPanel.add(lblReduction1);
		
		JTextField nomClasseModiField = new JTextField();
		nomClasseModiField.setBounds(279, 86, 283, 38);
		modifierPanel.add(nomClasseModiField);
		nomClasseModiField.setColumns(10);
		
		JButton modifierBtn = new JButton("Modifier");
		modifierBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		modifierBtn.setBounds(279, 211, 283, 38);
		modifierBtn.setBackground(new Color(163, 193, 246));
		modifierPanel.add(modifierBtn);
		
		nouvPrixModifField = new JTextField();
		nouvPrixModifField.setColumns(10);
		nouvPrixModifField.setBounds(279, 148, 283, 38);
		modifierPanel.add(nouvPrixModifField);
		
		// Panel for Insertion
		ajouterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ajouterPanel.setBackground(Color.WHITE);
		ajouterPanel.setBounds(0, 59, 809, 353);
		ajouterPanel.setLayout(null);
		
		JLabel lblNomCategorie = new JLabel("Nom Classe     :");
		lblNomCategorie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomCategorie.setBounds(167, 81, 106, 23);
		ajouterPanel.add(lblNomCategorie);
		
		JLabel lblReduction = new JLabel("Prix Par KM     :");
		lblReduction.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReduction.setBounds(167, 146, 106, 35);
		ajouterPanel.add(lblReduction);
		
		nomClasseAjouField = new JTextField();
		nomClasseAjouField.setBounds(283, 76, 277, 35);
		ajouterPanel.add(nomClasseAjouField);
		nomClasseAjouField.setColumns(10);
		
		prixAjoutField = new JTextField();
		prixAjoutField.setBounds(283, 147, 277, 35);
		ajouterPanel.add(prixAjoutField);
		prixAjoutField.setColumns(10);
		
		JButton ajouterBtn = new JButton("Ajouter");
		ajouterBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		ajouterBtn.setBounds(286, 213, 274, 35);
		ajouterBtn.setBackground(new Color(163, 193, 246));
		ajouterPanel.add(ajouterBtn);
		
		JLabel label1 = new JLabel("");
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new menu_admin();
				dispose();
			}
		});
		label1.setIcon(new ImageIcon(this.getClass().getResource("/icons8_left_30px_1.png")));
		label1.setBounds(0, 0, 37, 32);
		panel.add(label1);
		
	//  create the table
		DefaultTableModel model = new DefaultTableModel(Classe.listeClassesData(), Classe.listeClassesColumnName());
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
		
        ajouterBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nomClasse = nomClasseAjouField.getText();
					String prixText = prixAjoutField.getText();
					double prix = Double.parseDouble(prixText);
					Classe.ajouterClasse(nomClasse, prix);
					ajouterPanel.add(messageApresInsertion);
					messageApresInsertion.setVisible(true);	
					nomClasseAjouField.setText("");
					prixAjoutField.setText("");
				}
			});
	        
	        modifierBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nomClasse = nomClasseModiField.getText();
					String prixText = nouvPrixModifField.getText();
					double prix = Double.parseDouble(prixText);
					Classe.modifierClassee(nomClasse, prix);
					modifierPanel.add(messageApresModification);
					messageApresModification.setVisible(true);
					nomClasseModiField.setText("");
					nouvPrixModifField.setText("");
				}
			});
	        
	        suppBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nomClasse = nomClasseSuppField.getText();
					String idAvionText = idAvionSuppField.getText();
					int idAvion = Integer.parseInt(idAvionText);
					Classe.supprimerClasseAvion(nomClasse,idAvion);
					supprimerPanel.add(supprimerMessagePanel);
					supprimerMessagePanel.setVisible(true);
					nomClasseSuppField.setText("");
				}
			});
	        
	        suppBtnDef.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nomClasse = nomClasseSuppField.getText();
					Classe.supprimerClasse(nomClasse);
					supprimerPanel.add(supprimerMessagePanel);
					supprimerMessagePanel.setVisible(true);
					nomClasseSuppField.setText("");
				}
			});
		
		chercherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idClasseText = textField_5.getText();
				int idClasse = Integer.parseInt(idClasseText);
				DefaultTableModel model1 = new DefaultTableModel(Classe.listeClassesData(idClasse),Classe.listeClassesColumnName());
				table.setModel(model1);
				textField_5.setText("");
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
				DefaultTableModel model = new DefaultTableModel(Classe.listeClassesData(), Classe.listeClassesColumnName());
				table.setModel(model);
				Gestion_classe.this.validate();
				Gestion_classe.this.repaint();
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
				Gestion_classe.this.validate();
				Gestion_classe.this.repaint();
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
				Gestion_classe.this.validate();
				Gestion_classe.this.repaint();
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
				Gestion_classe.this.validate();
				Gestion_classe.this.repaint();
			}
		});
		
		setSize(900,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new Gestion_classe();
	}

}
