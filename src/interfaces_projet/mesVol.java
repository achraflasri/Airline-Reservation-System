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
import java.awt.SystemColor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;

public class mesVol extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField numReservationField;
	private static Connection conn=Connexion.getConnection();
	public mesVol() {
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("Form");
		setSize(1350, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 1344, 95);
		getContentPane().add(panel);
		panel.setLayout(null);
		
	/*JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\mlkj.PNG"));
		lblNewLabel_3.setBounds(0, 45, 1344, 332);
		getContentPane().add(lblNewLabel_3);
	*/
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\lg.png"));
		lblNewLabel_8.setBounds(31, 4, 86, 86);
		panel.add(lblNewLabel_8);
		
		
		
		JButton btnSeConnecter = new JButton("Se Connecter ");
		btnSeConnecter.setForeground(Color.BLACK);
		btnSeConnecter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSeConnecter.setBackground(new Color(0, 0, 205));
		btnSeConnecter.setBounds(1131, 27, 177, 37);
		panel.add(btnSeConnecter);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(117, 218, 1121, 427);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,0,20));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 0, 1121, 62);
		panel_2.add(panel_1);
		panel_1.setLayout(new GridLayout(1,4, 0, 0));
		
		JPanel panel_4 = new JPanel();
		//panel_4.setBackground(new Color(0,0,0,20));
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\rechercher.png"));
		lblNewLabel.setBounds(41, 11, 42, 42);
		panel_4.add(lblNewLabel);
		
		JLabel lblRechercherVols = new JLabel("Rechercher Vols");
		lblRechercherVols.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechercherVols.setBounds(94, 13, 145, 34);
		panel_4.add(lblRechercherVols);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\reserver.png"));
		label.setBounds(36, 11, 42, 42);
		panel_5.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Reserver Billets ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(91, 13, 148, 34);
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\lis.png"));
		label_1.setBounds(41, 11, 42, 42);
		panel_6.add(label_1);
		
		JLabel lblMesReservations = new JLabel("Mes Reservations");
		lblMesReservations.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMesReservations.setBounds(98, 11, 152, 34);
		panel_6.add(lblMesReservations);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\ge.png"));
		label_2.setBounds(28, 11, 42, 42);
		panel_7.add(label_2);
		
		JLabel lblModifiersupprimer = new JLabel("Modifier/Supprimer");
		lblModifiersupprimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModifiersupprimer.setBounds(93, 11, 176, 34);
		panel_7.add(lblModifiersupprimer);
		
		JPanel mesReservationPanel = new JPanel();
		mesReservationPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mesReservationPanel.setBackground(Color.WHITE);
		mesReservationPanel.setBounds(0, 62, 1121, 365);
		panel_2.add(mesReservationPanel);
		mesReservationPanel.setLayout(null);
		
		JLabel lblNumReservation = new JLabel("Num Reservation");
		lblNumReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumReservation.setBounds(179, 22, 164, 41);
		mesReservationPanel.add(lblNumReservation);
		
		numReservationField = new JTextField();
		numReservationField.setBounds(395, 30, 310, 29);
		mesReservationPanel.add(numReservationField);
		numReservationField.setColumns(10);
		
		JButton btnNewButton = new JButton("Chercher");
		btnNewButton.setBackground(new Color(0, 0, 205));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(766, 24, 177, 37);
		mesReservationPanel.add(btnNewButton);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Sans titre - 1.png"));
		label_3.setBounds(254, 117, 2, 221);
		mesReservationPanel.add(label_3);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		panel_8.setBounds(10, 74, 1091, 280);
		panel_8.setBackground(Color.white);
//		panel_3.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblIdLock = new JLabel("Id Reservation ");
		lblIdLock.setForeground(new Color(0, 0, 205));
		lblIdLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdLock.setBounds(139, 11, 112, 23);
		panel_8.add(lblIdLock);
		
		JLabel lblId = new JLabel("1");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(139, 65, 88, 23);
		
		JLabel lblNomLock = new JLabel("Nom");
		lblNomLock.setForeground(new Color(0, 0, 205));
		lblNomLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomLock.setBounds(307, 11, 64, 23);
		panel_8.add(lblNomLock);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom.setBounds(307, 65, 97, 23);
		
		JLabel lblPrenomLock = new JLabel("Prenom ");
		lblPrenomLock.setForeground(new Color(0, 0, 205));
		lblPrenomLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrenomLock.setBounds(444, 11, 64, 23);
		panel_8.add(lblPrenomLock);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom.setBounds(458, 65, 97, 23);
		
		JLabel lblClasseLock = new JLabel("Classe ");
		lblClasseLock.setForeground(new Color(0, 0, 205));
		lblClasseLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClasseLock.setBounds(618, 11, 64, 23);
		panel_8.add(lblClasseLock);
		
		JLabel lblClasse = new JLabel("classe");
		lblClasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse.setBounds(618, 65, 64, 23);
		
		JLabel lblCategorieLock = new JLabel("Categorie ");
		lblCategorieLock.setForeground(new Color(0, 0, 205));
		lblCategorieLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategorieLock.setBounds(770, 11, 88, 23);
		panel_8.add(lblCategorieLock);
		
		JLabel lblCategorie = new JLabel("categorie");
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie.setBounds(770, 65, 88, 23);
		
		JLabel lblPrixLock = new JLabel("Prix ");
		lblPrixLock.setForeground(new Color(0, 0, 205));
		lblPrixLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrixLock.setBounds(939, 11, 64, 23);
		panel_8.add(lblPrixLock);
		
		JLabel lblPrix = new JLabel("prix");
		lblPrix.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix.setBounds(939, 65, 139, 23);
		
		JLabel lblId_1 = new JLabel("id");
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_1.setBounds(139, 99, 88, 23);
		
		JLabel lblNom_1 = new JLabel("nom");
		lblNom_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_1.setBounds(307, 99, 97, 23);
		
		JLabel lblPrenom_1 = new JLabel("prenom");
		lblPrenom_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_1.setBounds(458, 99, 97, 23);
		
		JLabel lblClasse_1 = new JLabel("classe");
		lblClasse_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_1.setBounds(618, 99, 64, 23);
		
		JLabel lblCategorie_1 = new JLabel("categorie");
		lblCategorie_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie_1.setBounds(770, 99, 64, 23);
		
		JLabel lblPrix_1 = new JLabel("prix");
		lblPrix_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_1.setBounds(939, 99, 139, 23);
		
		JLabel lblId_2 = new JLabel("id");
		lblId_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_2.setBounds(139, 133, 88, 23);
		
		JLabel lblNom_2 = new JLabel("nom");
		lblNom_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_2.setBounds(307, 133, 82, 23);
		
		JLabel lblPrenom_2 = new JLabel("prenom");
		lblPrenom_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_2.setBounds(458, 133, 97, 23);
		
		JLabel lblClasse_2 = new JLabel("classe");
		lblClasse_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_2.setBounds(618, 133, 64, 23);
		
		JLabel lblCat_2 = new JLabel("categorie");
		lblCat_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCat_2.setBounds(770, 133, 64, 23);
		
		JLabel lblPrix_2 = new JLabel("prix");
		lblPrix_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_2.setBounds(939, 133, 139, 23);
		
		JLabel lblId_3 = new JLabel("id");
		lblId_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_3.setBounds(139, 167, 88, 23);
		
		JLabel lblNom_3 = new JLabel("nom");
		lblNom_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_3.setBounds(307, 167, 82, 23);
		
		JLabel lblPrenom_3 = new JLabel("prenom");
		lblPrenom_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_3.setBounds(458, 167, 97, 23);
		
		JLabel lblClasse_3 = new JLabel("classe");
		lblClasse_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_3.setBounds(618, 172, 64, 23);
		
		JLabel lblCategorie_3 = new JLabel("categorie");
		lblCategorie_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie_3.setBounds(770, 172, 64, 23);
		
		JLabel lblPrix_3 = new JLabel("prix");
		lblPrix_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_3.setBounds(939, 172, 139, 23);
		
		JLabel lblId_4 = new JLabel("id");
		lblId_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_4.setBounds(139, 240, 88, 23);
		
		JLabel lblNom_4 = new JLabel("nom");
		lblNom_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_4.setBounds(307, 240, 97, 23);
		
		JLabel lblPrenom_4 = new JLabel("prenom");
		lblPrenom_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_4.setBounds(458, 240, 97, 23);
		
		JLabel lblClasse_4 = new JLabel("classe");
		lblClasse_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_4.setBounds(618, 240, 64, 23);
		
		JLabel lblCategorie_4 = new JLabel("categorie");
		lblCategorie_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie_4.setBounds(770, 240, 64, 23);
		
		JLabel lblPrix_4 = new JLabel("prix");
		lblPrix_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_4.setBounds(939, 240, 139, 23);
		
		JLabel lblId_5 = new JLabel("id");
		lblId_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_5.setBounds(139, 206, 88, 23);
				
		JLabel lblNom_5 = new JLabel("nom");
		lblNom_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_5.setBounds(307, 206, 82, 23);
		
		JLabel lblPrenom_5 = new JLabel("prenom");
		lblPrenom_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_5.setBounds(458, 206, 97, 23);		
		
		JLabel lblClasse_5 = new JLabel("classe");
		lblClasse_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_5.setBounds(618, 206, 64, 23);		
		
		JLabel lblCategorie_5 = new JLabel("categorie");
		lblCategorie_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie_5.setBounds(770, 206, 64, 23);		
		
		JLabel lblPrix_5 = new JLabel("prix");
		lblPrix_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_5.setBounds(939, 206, 139, 23);
	/*	panel_3.add(panel_8);
		panel_8.add(lblId);
		panel_8.add(lblNom);
		panel_8.add(lblPrenom);
		panel_8.add(lblClasse);
		panel_8.add(lblCategorie);
		panel_8.add(lblPrix);
		panel_8.add(lblId_1);
		panel_8.add(lblNom_1);
		panel_8.add(lblPrenom_1);
		panel_8.add(lblClasse_1);
		panel_8.add(lblCategorie_1);
		panel_8.add(lblPrix_1);
		panel_8.add(lblId_2);
		panel_8.add(lblNom_2);
		panel_8.add(lblPrenom_2);
		panel_8.add(lblClasse_2);
		panel_8.add(lblCat_2);
		panel_8.add(lblPrix_2);
		panel_8.add(lblId_3);
		panel_8.add(lblNom_3);
		panel_8.add(lblPrenom_3);
		panel_8.add(lblClasse_3);
		panel_8.add(lblCategorie_3);
		panel_8.add(lblPrix_3);
		panel_8.add(lblId_4);
		panel_8.add(lblNom_4);
		panel_8.add(lblPrenom_4);
		panel_8.add(lblClasse_4);
		panel_8.add(lblCategorie_4);
		panel_8.add(lblPrix_4);
		panel_8.add(lblId_5);
		panel_8.add(lblNom_5);
		panel_8.add(lblPrenom_5);
		panel_8.add(lblClasse_5);
		panel_8.add(lblCategorie_5);
		panel_8.add(lblPrix_5);*/
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
					
					mesReservationPanel.add(panel_8);
					mesReservationPanel.remove(btnNewButton);
					mesVol.this.validate();
					mesVol.this.repaint();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new mesVol();
	}
}
