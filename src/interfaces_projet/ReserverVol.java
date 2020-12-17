package interfaces_projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import reservation_billets.Categorie;
import reservation_billets.Classe;
import reservation_billets.Connexion;
import reservation_billets.Reservation;

public class ReserverVol extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField cinField;
	private JTextField telField;
	private JTextField idvolField;
	private Vector<String> CATEGORIE_NORMAL_OPTION = Categorie.listeCategorie();
	private Vector<String> CLASSE_NORMAL_OPTION = Classe.listeClasses();
	JSpinner spinner = new JSpinner();
	private static int nb ;
	private static int nbPassager = 1 ;
	private static int clic=0 ;
	JPanel pan = new JPanel();
	JComboBox<String> sexeComboBoxe = new JComboBox<String>();	
	JComboBox<String> comboBoxClass = new JComboBox<String>();
	JComboBox<String> comboBoxCatego = new JComboBox<String>();
	private JTextField dateField;
	private static Connection conn=Connexion.getConnection();
	int num_reservation;
	
	public ReserverVol() {
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		
		JPanel reserverBilletPanel = new JPanel();
		reserverBilletPanel.setBackground(Color.WHITE);
		reserverBilletPanel.setBounds(6, 104, 1131, 371);
		panel.add(reserverBilletPanel);
		reserverBilletPanel.setLayout(null);
		
		try {
			PreparedStatement ps5=conn.prepareStatement("select max(num_reservation) from reservation ");
			ResultSet rs = ps5.executeQuery();
			rs.next();
			num_reservation = rs.getInt(1)+1;
		} catch (Exception e) {
			
		}
		
		
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(41, 200, 1131, 311);
				reserverBilletPanel.add(panel_1);
				panel_1.setBorder(new LineBorder(Color.CYAN, 3));
				panel_1.setBackground(Color.WHITE);
				panel_1.setLayout(null);
				
				JLabel lblNom = new JLabel("Nom :");
				lblNom.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNom.setBounds(34, 79, 75, 22);
				panel_1.add(lblNom);
				
				JLabel lblPrenom = new JLabel("Prenom :");
				lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblPrenom.setBounds(34, 142, 75, 22);
				panel_1.add(lblPrenom);
				
				JLabel lblCin = new JLabel("CIN :");
				lblCin.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCin.setBounds(34, 205, 56, 22);
				panel_1.add(lblCin);
				
				nomField = new JTextField();
				nomField.setBounds(130, 81, 104, 22);
				panel_1.add(nomField);
				nomField.setColumns(10);
				
				prenomField = new JTextField();
				prenomField.setColumns(10);
				prenomField.setBounds(130, 143, 104, 22);
				panel_1.add(prenomField);
				
				cinField = new JTextField();
				cinField.setColumns(10);
				cinField.setBounds(130, 207, 104, 22);
				panel_1.add(cinField);
				

				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new LineBorder(Color.CYAN, 2));
				panel_2.setBackground(Color.CYAN);
				panel_2.setBounds(0, 0, 185, 54);
				panel_1.add(panel_2);
				panel_2.setLayout(null);
				
				JLabel lblPassager = new JLabel("Passager 1");
				lblPassager.setFont(new Font("Tekton Pro", Font.BOLD, 15));
				lblPassager.setBounds(10, 14, 119, 28);
				panel_2.add(lblPassager);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\icons8_user_male_circle_filled_50px.png"));
				label.setBounds(106, -16, 50, 88);
				panel_2.add(label);
				
				JLabel lblTel = new JLabel("Tel :");
				lblTel.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblTel.setBounds(398, 142, 75, 22);
				panel_1.add(lblTel);
				

				JLabel lblClasse = new JLabel("Classe :");
				lblClasse.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblClasse.setBounds(732, 79, 75, 22);
				panel_1.add(lblClasse);
				
				JLabel lblCategorie = new JLabel("Categorie :");
				lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCategorie.setBounds(732, 142, 104, 22);
				panel_1.add(lblCategorie);
				
				telField = new JTextField();
				telField.setColumns(10);
				telField.setBounds(510, 143, 104, 22);
				panel_1.add(telField);
				
				JLabel lblIdvol = new JLabel("IDVOL :");
				lblIdvol.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblIdvol.setBounds(383, 205, 83, 22);
				panel_1.add(lblIdvol);
				
				idvolField = new JTextField();
				idvolField.setColumns(10);
				idvolField.setBounds(510, 206, 104, 22);
				panel_1.add(idvolField);
				
				JLabel lblDate = new JLabel("Date :");
				lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblDate.setBounds(394, 79, 104, 22);
				panel_1.add(lblDate);
				
				dateField = new JTextField("jj/mm/aaaa");
				dateField.setForeground(Color.GRAY);
				dateField.setColumns(10);
				dateField.setBounds(510, 78, 104, 25);
				dateField.addFocusListener(new FocusListener() {
					public void focusLost(FocusEvent arg0) {
						
					}
					public void focusGained(FocusEvent arg0) {
						dateField.setText("");
					}
					
				});
				panel_1.add(dateField);
				JButton btnSuivant = new JButton("Suivant");
				
				JLabel lblSexe = new JLabel("Sexe :");
				lblSexe.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblSexe.setBounds(732, 205, 104, 22);
				panel_1.add(lblSexe);
				
				
				sexeComboBoxe.setBounds(846, 206, 104, 23);
				sexeComboBoxe.addItem("Homme");
				sexeComboBoxe.addItem("Femme");	
				panel_1.add(sexeComboBoxe);
				
				
				comboBoxClass.setBounds(846, 82, 104, 23);
				panel_1.add(comboBoxClass);
				
				
				comboBoxCatego.setBounds(846, 141, 104, 23);
				panel_1.add(comboBoxCatego);
				
				JLabel lblNombreDePlace = new JLabel("Nombre de place : ");
				lblNombreDePlace.setBounds(54, 10, 147, 32);
				reserverBilletPanel.add(lblNombreDePlace);
				lblNombreDePlace.setFont(new Font("Tahoma", Font.BOLD, 15));
				spinner.setBounds(258, 10, 40, 32);
				reserverBilletPanel.add(spinner);
				
				JButton btnConfirmer = new JButton("Confirmer");
				btnConfirmer.setBounds(355, 16, 89, 23);
				reserverBilletPanel.add(btnConfirmer);
				btnConfirmer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							nb = (Integer) spinner.getValue();
							reserverBilletPanel.add(btnSuivant);
							reserverBilletPanel.remove(btnConfirmer);
							if(nb==1) {
								btnSuivant.setText("Confirmer");
							}
							ReserverVol.this.validate();
							ReserverVol.this.repaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				for(int i = 0 ; i<CLASSE_NORMAL_OPTION.size();i++) {
					comboBoxClass.addItem(CLASSE_NORMAL_OPTION.get(i));
					}
				for(int i = 0 ; i<CATEGORIE_NORMAL_OPTION.size();i++) {
					comboBoxCatego.addItem(CATEGORIE_NORMAL_OPTION.get(i));
					}
				
				
				btnSuivant.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						
						System.out.println(clic);
						for(int i=0 ; i<nb;i++) {
							if(clic==i) {
								JOptionPane.showMessageDialog(null, "Operation effectue ...");
							}
						}
						if(clic==nb-1) {
							btnSuivant.setVisible(false);
						}
						if(clic==nb-2 ) {
							btnSuivant.setText("Confirmer");
						}
						clic ++ ;
					}
				});

				btnSuivant.setBounds(483, 11, 119, 32);
				
				btnSuivant.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					try {
						String nomPassager = nomField.getText();
						String prenomPassager = prenomField.getText();
						String cinPassager = cinField.getText();
						String telPassager = telField.getText();
						String nomCategorie = (String) comboBoxCatego.getSelectedItem(); 
						String nomClasse = (String) comboBoxClass.getSelectedItem(); 
						String dateDepart = dateField.getText();
						boolean sexe =true ;
						if(sexeComboBoxe.getSelectedItem()=="Femme") {
							 sexe = true;
						}
						if(sexeComboBoxe.getSelectedItem()=="Homme") {
							 sexe = false;
						}
						String idVolText = idvolField.getText();
						int idVol = Integer.parseInt(idVolText);
						
						
						Reservation.reserverBillet(nomPassager, prenomPassager, telPassager, cinPassager, sexe, idVol, nomCategorie, nomClasse, dateDepart, num_reservation);

						if(clic<nb-1) {
							nbPassager ++ ;
						}
						lblPassager.setText("Passager "+nbPassager);
						lblPassager.setBounds(10, 14, 119, 28);
						nomField.setText("");
						prenomField.setText("");
						cinField.setText("");
						telField.setText("");
						idvolField.setText("");
						dateField.setText("");
						ReserverVol.this.validate();
						ReserverVol.this.repaint();
						
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					}
					});
		


		setSize(1200, 600);
		setVisible(true);
	}
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new ReserverVol();
	}
}
