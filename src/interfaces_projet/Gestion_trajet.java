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

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import reservation_billets.Trajet;
public class Gestion_trajet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField villeDepAjoutField;
	private JTextField villeArrAjoutField;
	private JTextField idTrajetsuppField;
	private JTextField textField_5;
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	JPanel choicePanel = new JPanel();
	JPanel consulterButtonPanel = new JPanel();
	JPanel ajouterButtonPanel = new JPanel();
	JPanel supprimerButtonPanel = new JPanel();
	JPanel supprimerPanel = new JPanel();
	JPanel consulterPanel = new JPanel();
	JPanel ajouterPanel = new JPanel();
	JPanel supprimerMessagePanel = new JPanel();
	JPanel tablePanel = new JPanel();
	private JTable table ;
	public Gestion_trajet() {

		
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
		
		//Panel for looking
		consulterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		consulterPanel.setBackground(Color.WHITE);
		consulterPanel.setBounds(0, 60, 809, 352);
		panel_1.add(consulterPanel);
		consulterPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Id Trajet ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(91, 35, 119, 35);
		consulterPanel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(220, 35, 306,37);
		consulterPanel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton chercherBtn = new JButton("Chercher");
		chercherBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		chercherBtn.setBounds(556, 31, 162, 40);
		chercherBtn.setBackground(new Color(163, 193, 246));
		consulterPanel.add(chercherBtn);

		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(53, 111, 706, 220);
		consulterPanel.add(tablePanel);
		
		// Panel for deleting
		
		supprimerPanel.setBackground(Color.WHITE);
		supprimerPanel.setBounds(0, 61, 809, 351);
		supprimerPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Id Trajet a Supprimer  :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(62, 61, 199, 31);
		supprimerPanel.add(lblNewLabel_3);
		
		idTrajetsuppField = new JTextField();
		idTrajetsuppField.setBounds(256, 57, 306, 40);
		supprimerPanel.add(idTrajetsuppField);
		idTrajetsuppField.setColumns(10);
		
		JButton suppBtn = new JButton("Supprimer");
		suppBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		suppBtn.setBounds(575, 57, 162, 40);
		suppBtn.setBackground(new Color(163, 193, 246));
		supprimerPanel.add(suppBtn);
		
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
		
		//Panel for Adding
		ajouterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ajouterPanel.setBackground(Color.WHITE);
		ajouterPanel.setBounds(0, 59, 809, 353);
		ajouterPanel.setLayout(null);
		
		JLabel lblNomCategorie = new JLabel("Ville Depart      :");
		lblNomCategorie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomCategorie.setBounds(167, 81, 106, 23);
		ajouterPanel.add(lblNomCategorie);
		
		JLabel lblReduction = new JLabel("Ville Arrivée     :");
		lblReduction.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReduction.setBounds(167, 146, 106, 35);
		ajouterPanel.add(lblReduction);
		
		villeDepAjoutField = new JTextField();
		villeDepAjoutField.setBounds(283, 76, 277, 35);
		ajouterPanel.add(villeDepAjoutField);
		villeDepAjoutField.setColumns(10);
		
		villeArrAjoutField = new JTextField();
		villeArrAjoutField.setBounds(283, 147, 277, 35);
		ajouterPanel.add(villeArrAjoutField);
		villeArrAjoutField.setColumns(10);
		
		JButton ajouterBtn = new JButton("Ajouter");
		ajouterBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		ajouterBtn.setBounds(286, 213, 274, 35);
		ajouterBtn.setBackground(new Color(163, 193, 246));
		ajouterPanel.add(ajouterBtn);
		
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
		
		JLabel messageApresInsertion = new JLabel("Insertion effectue  :");
		messageApresInsertion.setFont(new Font("Tahoma", Font.BOLD, 14));
		messageApresInsertion.setBounds(250, 290, 164, 29);
		
		// Create the table
		DefaultTableModel model = new DefaultTableModel(Trajet.listeTrajetData(), Trajet.listeTrajetColumnName());
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
        
        chercherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idTrajetText = textField_5.getText();
				int idTrajet = Integer.parseInt(idTrajetText);
				DefaultTableModel model1 = new DefaultTableModel(Trajet.listeTrajetData(idTrajet), Trajet.listeTrajetColumnName());
				table.setModel(model1);
			}
		});
        suppBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idTrajetText = idTrajetsuppField.getText();
				int idTrajet = Integer.parseInt(idTrajetText);
				Trajet.supprimerTrajet(idTrajet);
				supprimerPanel.add(supprimerMessagePanel);
				supprimerMessagePanel.setVisible(true);
				idTrajetsuppField.setText("");
				Gestion_trajet.this.validate();
				Gestion_trajet.this.repaint();
			}
		});
		ajouterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String villeDepart = villeDepAjoutField.getText();
				String villeArrive = villeArrAjoutField.getText();
				Trajet.ajouterTrajet(villeDepart, villeArrive);
				ajouterPanel.add(messageApresInsertion);
				messageApresInsertion.setVisible(true);
				villeDepAjoutField.setText("");
				villeArrAjoutField.setText("");
				Gestion_trajet.this.validate();
				Gestion_trajet.this.repaint();
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
				Gestion_trajet.this.validate();
				Gestion_trajet.this.repaint();
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
				DefaultTableModel model = new DefaultTableModel(Trajet.listeTrajetData(), Trajet.listeTrajetColumnName());
				table.setModel(model);
				textField_5.setText("");
				Gestion_trajet.this.validate();
				Gestion_trajet.this.repaint();
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
				Gestion_trajet.this.validate();
				Gestion_trajet.this.repaint();
			}
		});
		setSize(900,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new Gestion_trajet();
	}

}
