
package interfaces_projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import reservation_billets.Connexion;
import reservation_billets.Reservation;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifierReservation2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField idReservationField;
	private JTextField nomField_1;
	private JTextField prenomField_2;
	private JTextField cinField_3;
	private JTextField telField_4;
	private JTextField classeField_5;
	private JTextField categorieField_6;
	private JTextField volField_7;
	private Connection conn= Connexion.getConnection() ;
	private JPanel panel_1 = new JPanel();

	public ModifierReservation2() {
	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	JLabel lblIdentifiantReservation = new JLabel("Identifiant Reservation : ");
	lblIdentifiantReservation.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblIdentifiantReservation.setBounds(168, 41, 264, 30);
	panel.add(lblIdentifiantReservation);
	
	idReservationField = new JTextField();
	idReservationField.setBounds(442, 41, 96, 30);
	panel.add(idReservationField);
	idReservationField.setColumns(10);
	
	
	
	
	JLabel lblNom = new JLabel("Nom :");
	lblNom.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 17));
	lblNom.setBounds(37, 41, 77, 32);
	
	
	JLabel lblPrenom = new JLabel("Prenom :");
	lblPrenom.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 17));
	lblPrenom.setBounds(37, 84, 77, 32);
	
	
	JLabel lblCin = new JLabel("CIN :");
	lblCin.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 17));
	lblCin.setBounds(37, 127, 77, 32);
	
	
	JLabel lblTel = new JLabel("Tel :");
	lblTel.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 17));
	lblTel.setBounds(37, 170, 77, 32);
	
	
	JLabel lblClasse = new JLabel("Classe :");
	lblClasse.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 17));
	lblClasse.setBounds(364, 41, 77, 32);
	
	
	JLabel lblCategorie = new JLabel("Categorie :");
	lblCategorie.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 17));
	lblCategorie.setBounds(364, 84, 77, 32);
	
	
	JLabel lblVol = new JLabel("Vol :");
	lblVol.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 17));
	lblVol.setBounds(364, 127, 77, 32);
	
	
	nomField_1 = new JTextField();
	nomField_1.setBounds(159, 41, 150, 32);
	
	nomField_1.setColumns(10);
	
	prenomField_2 = new JTextField();
	prenomField_2.setColumns(10);
	prenomField_2.setBounds(159, 84, 150, 32);
	
	
	cinField_3 = new JTextField();
	cinField_3.setColumns(10);
	cinField_3.setBounds(159, 127, 150, 32);
	
	
	telField_4 = new JTextField();
	telField_4.setColumns(10);
	telField_4.setBounds(159, 170, 150, 32);
	
	
	classeField_5 = new JTextField();
	classeField_5.setColumns(10);
	classeField_5.setBounds(487, 41, 150, 32);
	
	
	categorieField_6 = new JTextField();
	categorieField_6.setColumns(10);
	categorieField_6.setBounds(487, 84, 150, 32);
	
	
	volField_7 = new JTextField();
	volField_7.setColumns(10);
	volField_7.setBounds(487, 133, 150, 32);
	
	
	JLabel lblPressToEdit = new JLabel("Press to Edit");
	lblPressToEdit.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			// get idPassager
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(" SELECT id_passager FROM reservation"
						+ " where id_reservation=?");
				String idText = idReservationField.getText();
				int id = Integer.parseInt(idText);
				
		        ps.setInt(1, id);
				ResultSet rs= ps.executeQuery();
				rs.next();
				int idPassager = rs.getInt(1);
				// Getting fields from the user
		        String idReservationText = idReservationField.getText();
				int idReservation = Integer.parseInt(idReservationText);
				String nomPassager = nomField_1.getText();
				String prenomPassager = prenomField_2.getText();
				String telPassager = telField_4.getText();
				String cinPassager = cinField_3.getText();
				String nomClasse = classeField_5.getText();
				String nomCategorie = categorieField_6.getText();
				String idVolText = volField_7.getText();
				int idVol = Integer.parseInt(idVolText);
				Reservation.modifierReservation(idReservation, nomPassager, prenomPassager, telPassager, cinPassager, idVol, nomCategorie, nomClasse);
				JOptionPane.showMessageDialog(null, "Operation effectue ...");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ModifierReservation2.this.validate();
			ModifierReservation2.this.repaint();
		}
	});
	lblPressToEdit.setFont(new Font("Tekton Pro", Font.BOLD, 16));
	lblPressToEdit.setBounds(500, 243, 126, 38);
	panel_1.add(lblPressToEdit);
	
	JLabel label_1 = new JLabel("");
	label_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\icons8_multi_edit_24px.png"));
	label_1.setBounds(589, 243, 35, 32);
	panel_1.add(label_1);
	
	
	JLabel lblGo = new JLabel("Press to Go");
	lblGo.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(133, 148, 727, 303);
			panel_1.setLayout(null);
			panel_1.add(lblNom);
			panel_1.add(lblPrenom);
			panel_1.add(lblCin);
			panel_1.add(lblTel);
			panel_1.add(lblClasse);
			panel_1.add(lblCategorie);
			panel_1.add(lblVol);
			panel_1.add(nomField_1);
			panel_1.add(prenomField_2);
			panel_1.add(cinField_3);
			panel_1.add(telField_4);
			panel_1.add(classeField_5);
			panel_1.add(categorieField_6);
			panel_1.add(volField_7);
			
			// Import data to textField
			

	        PreparedStatement ps,ps1,ps2;
	        // Getting idReservation from the user
	        String idText = idReservationField.getText();
			int id = Integer.parseInt(idText);
			try {
				ps = conn.prepareStatement(" SELECT nom_passager,prenom_passager,tel_passager,id_vol,cin FROM passager,reservation"
						+ " where passager.id_passager=reservation.id_passager and id_reservation=?");
				ps1 = conn.prepareStatement(" SELECT nom_categorie FROM categorie,reservation"
						+ " where categorie.id_categorie=reservation.id_categorie and id_reservation=?");
				ps2 = conn.prepareStatement(" SELECT nom_classe FROM classe,reservation"
						+ " where classe.id_classe=reservation.id_classe and id_reservation=?");
				
		        ps.setInt(1, id);
				ResultSet rs= ps.executeQuery();
				rs.next();
				ps1.setInt(1, id);
				ResultSet rs1= ps1.executeQuery();
				rs1.next();
				ps2.setInt(1, id);
				ResultSet rs2= ps2.executeQuery();
				rs2.next();
				nomField_1.setText(rs.getString(1));
				prenomField_2.setText(rs.getString(2));
				cinField_3.setText(rs.getString(5));
				telField_4.setText(rs.getString(3));
				classeField_5.setText(rs2.getString(1));
				categorieField_6.setText(rs1.getString(1));
				volField_7.setText(rs.getString(4));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			panel.add(panel_1);
			ModifierReservation2.this.validate();
			ModifierReservation2.this.repaint();
		}
	});
	lblGo.setFont(new Font("Tekton Pro", Font.BOLD, 16));
	lblGo.setBounds(580, 29, 138, 61);
	panel.add(lblGo);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\icons8_google_web_search_50px.png"));
	label.setBounds(668, 29, 50, 50);
	panel.add(label);
	
	
	
//	JWebBrowser browser = new JWebBrowser();
//    browser.setBarsVisible(false);
//    browser.setStatusBarVisible(false);
//    browser.setPreferredSize(new Dimension(800,600));
//    panel.add(browser);
//    browser.navigate("http://www.cran.r-project.org/doc/manuals/R-intro.pdf");
	
	setSize(1000, 500);
	setVisible(true);
}

public static void main(String[] args) {
	new ModifierReservation2();
}	

}


