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

public class rserrver extends JFrame {
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
	
	public rserrver() {
		getContentPane().setLayout(null);
		
		
		
		
		
		JPanel reserverBilletPanel = new JPanel();
		reserverBilletPanel.setBounds(26, 133, 1121, 365);
		reserverBilletPanel.setBackground(Color.WHITE);
		getContentPane().add(reserverBilletPanel);
		reserverBilletPanel.setLayout(null);
		
		try {
			PreparedStatement ps5=conn.prepareStatement("select max(num_reservation) from reservation ");
			ResultSet rs = ps5.executeQuery();
			rs.next();
			num_reservation = rs.getInt(1)+1;
		} catch (Exception e) {
			
		}
				JButton btnSuivant = new JButton("Suivant");
				
				JButton btnConfirmer = new JButton("Confirmer");
				btnConfirmer.setBounds(701, 16, 178, 41);
				reserverBilletPanel.add(btnConfirmer);
				spinner.setBounds(357, 20, 303, 32);
				reserverBilletPanel.add(spinner);
				
				JLabel lblNombreDePlace = new JLabel("Nombre de place : ");
				lblNombreDePlace.setBounds(224, 19, 147, 32);
				reserverBilletPanel.add(lblNombreDePlace);
				lblNombreDePlace.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				
						JPanel panilo = new JPanel();
						panilo.setBounds(41, 72, 1033, 274);
						reserverBilletPanel.add(panilo);
						panilo.setBorder(new LineBorder(Color.CYAN, 3));
						panilo.setBackground(Color.WHITE);
						panilo.setLayout(null);
						
								
								JPanel reserverBilletPanel1 = new JPanel();
								reserverBilletPanel1.setBorder(new LineBorder(new Color(0, 0, 205), 2));
								reserverBilletPanel1.setBounds(0, 0, 1033, 274);
								panilo.add(reserverBilletPanel1);
								reserverBilletPanel1.setBackground(Color.WHITE);
								reserverBilletPanel1.setLayout(null);
								

								JPanel panfu = new JPanel();
								panfu.setBounds(0, 0, 202, 47);
								reserverBilletPanel1.add(panfu);
								panfu.setBorder(new LineBorder(new Color(0, 0, 205), 2));
								panfu.setBackground(Color.CYAN);
								panfu.setLayout(null);
								
								JLabel lblPassager = new JLabel("Passager 1");
								lblPassager.setFont(new Font("Tekton Pro", Font.BOLD, 15));
								lblPassager.setBounds(65, 6, 112, 28);
								panfu.add(lblPassager);
								
								JLabel lblNewLabel = new JLabel("New label");
								lblNewLabel.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\yt.png"));
								lblNewLabel.setBounds(17, 3, 36, 36);
								panfu.add(lblNewLabel);
								
								nomField = new JTextField();
								nomField.setBounds(99, 85, 252, 34);
								reserverBilletPanel1.add(nomField);
								nomField.setColumns(10);
								
								prenomField = new JTextField();
								prenomField.setBounds(99, 139, 252, 34);
								reserverBilletPanel1.add(prenomField);
								prenomField.setColumns(10);
								
								cinField = new JTextField();
								cinField.setBounds(425, 128, 252, 34);
								reserverBilletPanel1.add(cinField);
								cinField.setColumns(10);
								
								telField = new JTextField();
								telField.setBounds(100, 195, 251, 34);
								reserverBilletPanel1.add(telField);
								telField.setColumns(10);
								
								idvolField = new JTextField();
								idvolField.setBounds(425, 194, 252, 34);
								reserverBilletPanel1.add(idvolField);
								idvolField.setColumns(10);
								
								dateField = new JTextField("jj/mm/aaaa");
								dateField.setBounds(426, 85, 252, 33);
								reserverBilletPanel1.add(dateField);
								dateField.setForeground(Color.GRAY);
								dateField.setColumns(10);
								comboBoxClass.setBounds(761, 85, 252, 34);
								reserverBilletPanel1.add(comboBoxClass);
								
								JLabel lblCategorie = new JLabel("Categorie :");
								lblCategorie.setBounds(683, 145, 80, 22);
								reserverBilletPanel1.add(lblCategorie);
								lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 13));
								comboBoxCatego.setBounds(761, 140, 249, 33);
								reserverBilletPanel1.add(comboBoxCatego);
								sexeComboBoxe.setBounds(761, 195, 249, 34);
								reserverBilletPanel1.add(sexeComboBoxe);
								
								JLabel lblTel = new JLabel("Tel      :");
								lblTel.setBounds(363, 145, 75, 22);
								reserverBilletPanel1.add(lblTel);
								lblTel.setFont(new Font("Tahoma", Font.BOLD, 13));
								
								JLabel lblIdvol = new JLabel("IdVol   :");
								lblIdvol.setBounds(360, 201, 75, 22);
								reserverBilletPanel1.add(lblIdvol);
								lblIdvol.setFont(new Font("Tahoma", Font.BOLD, 13));
								
								JLabel lblDate = new JLabel("Date   :");
								lblDate.setBounds(363, 91, 65, 22);
								reserverBilletPanel1.add(lblDate);
								lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
								
								JLabel lblSexe = new JLabel("Sexe        :");
								lblSexe.setBounds(689, 201, 74, 22);
								reserverBilletPanel1.add(lblSexe);
								lblSexe.setFont(new Font("Tahoma", Font.BOLD, 13));
								
								JLabel lblNom = new JLabel("Nom       :");
								lblNom.setBounds(24, 91, 75, 22);
								reserverBilletPanel1.add(lblNom);
								lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
								

								JLabel lblClasse = new JLabel("Classe      :");
								lblClasse.setBounds(688, 91, 75, 22);
								reserverBilletPanel1.add(lblClasse);
								lblClasse.setFont(new Font("Tahoma", Font.BOLD, 13));
								
								JLabel lblPrenom = new JLabel("Pr\u00E9nom  :");
								lblPrenom.setBounds(24, 145, 75, 22);
								reserverBilletPanel1.add(lblPrenom);
								lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 13));
								
								JLabel lblCin = new JLabel("CIN         :");
								lblCin.setBounds(24, 201, 65, 22);
								reserverBilletPanel1.add(lblCin);
								lblCin.setFont(new Font("Tahoma", Font.BOLD, 13));
								sexeComboBoxe.addItem("Homme");
								sexeComboBoxe.addItem("Femme");
								dateField.addFocusListener(new FocusListener() {
									public void focusLost(FocusEvent arg0) {
										
									}
									public void focusGained(FocusEvent arg0) {
										dateField.setText("");
									}
									
								});
				btnConfirmer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							nb = (Integer) spinner.getValue();
							reserverBilletPanel1.add(btnSuivant);
							reserverBilletPanel1.remove(btnConfirmer);
							if(nb==1) {
								btnSuivant.setText("Confirmer");
							}
							rserrver.this.validate();
							rserrver.this.repaint();
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
						rserrver.this.validate();
						rserrver.this.repaint();
						
						
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
		new rserrver();
	}
}
