package interfaces_projet;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import reservation_billets.Classe;
import reservation_billets.Connexion;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Form extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField numReservationField;
	private static Connection conn=Connexion.getConnection();
	public Form() {
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("Form");
		setSize(1300, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1294, 79);
		getContentPane().add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(83, 170, 1121, 475);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 56, 1121, 399);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNumReservation = new JLabel("Num Reservation");
		lblNumReservation.setBounds(247, 35, 103, 41);
		panel_3.add(lblNumReservation);
		
		numReservationField = new JTextField();
		numReservationField.setBounds(374, 37, 221, 36);
		panel_3.add(numReservationField);
		numReservationField.setColumns(10);
		
		JButton btnNewButton = new JButton("Chercher");
		btnNewButton.setBounds(637, 37, 177, 37);
		panel_3.add(btnNewButton);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 92, 1131, 371);
		panel_8.setBackground(Color.white);
//		panel_3.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblPassagers = new JLabel("Passagers :");
		lblPassagers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassagers.setBounds(20, 6, 102, 23);
		panel_8.add(lblPassagers);
		
		JLabel lblIdLock = new JLabel("Id Reservation :");
		lblIdLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdLock.setBounds(66, 40, 112, 23);
		panel_8.add(lblIdLock);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(90, 87, 64, 23);
		
		JLabel lblNomLock = new JLabel("Nom:");
		lblNomLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomLock.setBounds(204, 40, 64, 23);
		panel_8.add(lblNomLock);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setBounds(200, 87, 64, 23);
		
		JLabel lblPrenomLock = new JLabel("Prenom :");
		lblPrenomLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrenomLock.setBounds(337, 40, 64, 23);
		panel_8.add(lblPrenomLock);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setBounds(352, 87, 64, 23);
		
		JLabel lblClasseLock = new JLabel("Classe :");
		lblClasseLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClasseLock.setBounds(501, 40, 64, 23);
		panel_8.add(lblClasseLock);
		
		JLabel lblClasse = new JLabel("classe");
		lblClasse.setBounds(514, 87, 64, 23);
		
		JLabel lblCategorieLock = new JLabel("Categorie :");
		lblCategorieLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategorieLock.setBounds(639, 40, 64, 23);
		panel_8.add(lblCategorieLock);
		
		JLabel lblCategorie = new JLabel("categorie");
		lblCategorie.setBounds(652, 87, 64, 23);
		
		JLabel lblPrixLock = new JLabel("Prix :");
		lblPrixLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrixLock.setBounds(809, 40, 64, 23);
		panel_8.add(lblPrixLock);
		
		JLabel lblPrix = new JLabel("prix");
		lblPrix.setBounds(825, 87, 64, 23);
		
		JLabel lblId_1 = new JLabel("id");
		lblId_1.setBounds(90, 122, 64, 23);
		
		JLabel lblNom_1 = new JLabel("nom");
		lblNom_1.setBounds(200, 122, 64, 23);
		
		JLabel lblPrenom_1 = new JLabel("prenom");
		lblPrenom_1.setBounds(352, 122, 64, 23);
		
		JLabel lblClasse_1 = new JLabel("classe");
		lblClasse_1.setBounds(514, 122, 64, 23);
		
		JLabel lblCategorie_1 = new JLabel("categorie");
		lblCategorie_1.setBounds(652, 122, 64, 23);
		
		JLabel lblPrix_1 = new JLabel("prix");
		lblPrix_1.setBounds(825, 122, 64, 23);
		
		JLabel lblId_2 = new JLabel("id");
		lblId_2.setBounds(90, 157, 64, 23);
		
		JLabel lblNom_2 = new JLabel("nom");
		lblNom_2.setBounds(200, 157, 64, 23);
		
		JLabel lblPrenom_2 = new JLabel("prenom");
		lblPrenom_2.setBounds(352, 157, 64, 23);
		
		JLabel lblClasse_2 = new JLabel("classe");
		lblClasse_2.setBounds(514, 157, 64, 23);
		
		JLabel lblCat_2 = new JLabel("categorie");
		lblCat_2.setBounds(652, 157, 64, 23);
		
		JLabel lblPrix_2 = new JLabel("prix");
		lblPrix_2.setBounds(825, 157, 64, 23);
		
		JLabel lblId_3 = new JLabel("id");
		lblId_3.setBounds(90, 192, 64, 23);
		
		JLabel lblNom_3 = new JLabel("nom");
		lblNom_3.setBounds(200, 192, 64, 23);
		
		JLabel lblPrenom_3 = new JLabel("prenom");
		lblPrenom_3.setBounds(352, 192, 64, 23);
		
		JLabel lblClasse_3 = new JLabel("classe");
		lblClasse_3.setBounds(514, 192, 64, 23);
		
		JLabel lblCategorie_3 = new JLabel("categorie");
		lblCategorie_3.setBounds(652, 192, 64, 23);
		
		JLabel lblPrix_3 = new JLabel("prix");
		lblPrix_3.setBounds(825, 192, 64, 23);
		
		JLabel lblId_4 = new JLabel("id");
		lblId_4.setBounds(90, 262, 64, 23);
		
		JLabel lblNom_4 = new JLabel("nom");
		lblNom_4.setBounds(200, 262, 64, 23);
		
		JLabel lblPrenom_4 = new JLabel("prenom");
		lblPrenom_4.setBounds(352, 262, 64, 23);
		
		JLabel lblClasse_4 = new JLabel("classe");
		lblClasse_4.setBounds(514, 262, 64, 23);
		
		JLabel lblCategorie_4 = new JLabel("categorie");
		lblCategorie_4.setBounds(652, 262, 64, 23);
		
		JLabel lblPrix_4 = new JLabel("prix");
		lblPrix_4.setBounds(825, 262, 64, 23);
		
		JLabel lblId_5 = new JLabel("id");
		lblId_5.setBounds(90, 227, 64, 23);
				
		JLabel lblNom_5 = new JLabel("nom");
		lblNom_5.setBounds(200, 227, 64, 23);
		
		JLabel lblPrenom_5 = new JLabel("prenom");
		lblPrenom_5.setBounds(352, 227, 64, 23);		
		
		JLabel lblClasse_5 = new JLabel("classe");
		lblClasse_5.setBounds(514, 227, 64, 23);		
		
		JLabel lblCategorie_5 = new JLabel("categorie");
		lblCategorie_5.setBounds(652, 227, 64, 23);		
		
		JLabel lblPrix_5 = new JLabel("prix");
		lblPrix_5.setBounds(825, 227, 64, 23);
		
		
		btnNewButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				String textNum = numReservationField.getText();
				int numReservation = Integer.parseInt(textNum);
				try {
					int i=1;
					PreparedStatement ps1 = conn.prepareStatement("select passager.id_passager,nom_passager,prenom_passager,"
							+ "nom_classe,nom_categorie,prix_reservation "
							+ "from reservation,classe,categorie,passager where num_reservation=? "
							+ "and reservation.id_classe=classe.id_classe "
							+ "and categorie.id_categorie=reservation.id_categorie "
							+ "and passager.id_passager=reservation.id_passager");
					ps1.setInt(1,numReservation);
					ResultSet rs1 = ps1.executeQuery();
					while(rs1.next()) {
						if(i==1) {
						lblId.setText(String.valueOf(rs1.getInt(1)) );
						panel_8.add(lblId);
						lblNom.setText(rs1.getString(2));
						panel_8.add(lblNom);
						lblPrenom.setText(rs1.getString(3));
						panel_8.add(lblPrenom);
						lblClasse.setText(rs1.getString(4));
						panel_8.add(lblClasse);
						lblCategorie.setText(rs1.getString(5));
						panel_8.add(lblCategorie);
						lblPrix.setText(String.valueOf(rs1.getDouble(6)));
						panel_8.add(lblPrix);
						}
						if(i==2) {
						lblId_1.setText(String.valueOf(rs1.getInt(1)) );
						panel_8.add(lblId_1);
						lblNom_1.setText(rs1.getString(2));
						panel_8.add(lblNom_1);
						lblPrenom_1.setText(rs1.getString(3));
						panel_8.add(lblPrenom_1);
						lblClasse_1.setText(rs1.getString(4));
						panel_8.add(lblClasse_1);
						lblCategorie_1.setText(rs1.getString(5));
						panel_8.add(lblCategorie_1);
						lblPrix_1.setText(String.valueOf(rs1.getDouble(6)));
						panel_8.add(lblPrix_1);
						}
						if(i==3) {
						lblId_2.setText(String.valueOf(rs1.getInt(1)) );
						panel_8.add(lblId_2);
						lblNom_2.setText(rs1.getString(2));
						panel_8.add(lblNom_2);
						lblPrenom_2.setText(rs1.getString(3));
						panel_8.add(lblPrenom_2);
						lblClasse_2.setText(rs1.getString(4));
						panel_8.add(lblClasse_2);
						lblCat_2.setText(rs1.getString(5));
						panel_8.add(lblCat_2);
						lblPrix_2.setText(String.valueOf(rs1.getDouble(6)));
						panel_8.add(lblPrix_2);
						}
						if(i==4) {
						lblId_3.setText(String.valueOf(rs1.getInt(1)) );
						panel_8.add(lblId_3);
						lblNom_3.setText(rs1.getString(2));
						panel_8.add(lblNom_3);
						lblPrenom_3.setText(rs1.getString(3));
						panel_8.add(lblPrenom_3);
						lblClasse_3.setText(rs1.getString(4));
						panel_8.add(lblClasse_3);
						lblCategorie_3.setText(rs1.getString(5));
						panel_8.add(lblCategorie_3);
						lblPrix_3.setText(String.valueOf(rs1.getDouble(6)));
						panel_8.add(lblPrix_3);
						}
						if(i==5) {
						lblId_4.setText(String.valueOf(rs1.getInt(1)) );
						panel_8.add(lblId_4);
						lblNom_4.setText(rs1.getString(2));
						panel_8.add(lblNom_4);
						lblPrenom_4.setText(rs1.getString(3));
						panel_8.add(lblPrenom_4);
						lblClasse_4.setText(rs1.getString(4));
						panel_8.add(lblClasse_4);
						lblCategorie_4.setText(rs1.getString(5));
						panel_8.add(lblCategorie_4);
						lblPrix_4.setText(String.valueOf(rs1.getDouble(6)));
						panel_8.add(lblPrix_4);
						}
						if(i==6) {
						lblId_5.setText(String.valueOf(rs1.getInt(1)) );
						panel_8.add(lblId_5);
						lblNom_5.setText(rs1.getString(2));
						panel_8.add(lblNom_5);
						lblPrenom_5.setText(rs1.getString(3));
						panel_8.add(lblPrenom_5);
						lblClasse_5.setText(rs1.getString(4));
						panel_8.add(lblClasse_5);
						lblCategorie_5.setText(rs1.getString(5));
						panel_8.add(lblCategorie_5);
						lblPrix_5.setText(String.valueOf(rs1.getDouble(6)));
						panel_8.add(lblPrix_5);
						}			
						i++;
					}
					
					panel_3.add(panel_8);
					panel_3.remove(btnNewButton);
					Form.this.validate();
					Form.this.repaint();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Form();
	}
}
