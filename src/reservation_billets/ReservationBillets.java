package reservation_billets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.sql.*;
import java.util.*;

import javax.swing.JComboBox;

public class ReservationBillets extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Connection conn=Connexion.getConnection();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static int x =114;
	private JTextField textField_3;
	private JTextField textField_4;
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox_2 = new JComboBox();
	public ReservationBillets() {

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setSize(1200, 600);
		JLabel lblNombreDePlace = new JLabel("Nombre de place : ");
		lblNombreDePlace.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreDePlace.setBounds(84, 35, 147, 32);
		panel.add(lblNombreDePlace);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(233, 43, 40, 20);
		panel.add(spinner);
		
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int nb = (Integer) spinner.getValue();
					for(int i = 1 ; i<nb+1 ; i++) {
						panel.add(ajr());
					}
					panel.remove(btnConfirmer);
					
				}	
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		});
		btnConfirmer.setBounds(305, 42, 89, 23);
		panel.add(btnConfirmer);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(x, 126, 555, 291);
		//panel_1.setBounds(x, 126, 150, 150);
		panel_1.setLayout(null);
		panel.add(panel_1);
		x=x+224;
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNom.setBounds(10, 39, 56, 22);
		panel_1.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrenom.setBounds(10, 72, 56, 22);
		panel_1.add(lblPrenom);
		
		JLabel lblCin = new JLabel("CIN");
		lblCin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCin.setBounds(10, 101, 56, 22);
		panel_1.add(lblCin);
		
		textField = new JTextField();
		textField.setBounds(85, 41, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 74, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(85, 103, 86, 20);
		panel_1.add(textField_2);
		JLabel lblTel = new JLabel("TEL");
		lblTel.setBounds(20, 147, 46, 14);
		panel_1.add(lblTel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(85, 144, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDateReservation = new JLabel("Date reservation");
		lblDateReservation.setBounds(10, 185, 105, 14);
		panel_1.add(lblDateReservation);
		
		textField_4 = new JTextField();
		textField_4.setBounds(95, 182, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(305, 44, 62, 17);
		panel_1.add(lblCategorie);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setBounds(305, 77, 46, 14);
		panel_1.add(lblClasse);
		
		JLabel lblNumeroDeVol = new JLabel("Numero de vol");
		lblNumeroDeVol.setBounds(293, 114, 86, 22);
		panel_1.add(lblNumeroDeVol);
		
		
		comboBox.setBounds(398, 41, 79, 20);
		panel_1.add(comboBox);
		
		
		comboBox_1.setBounds(398, 74, 79, 20);
		panel_1.add(comboBox_1);
		
	
		comboBox_2.setBounds(398, 115, 79, 20);
		panel_1.add(comboBox_2);
		

		Vector<String> cat = Categorie.listeCategorie();
		Vector<String> classes = Classe.listeClasses();
		Vector<Integer> ids_vol = Vol.listeIdVols();
		Iterator it = cat.iterator();
		while(it.hasNext()){
			comboBox.addItem((String)it.next());
		}
		
		Iterator it1 = classes.iterator();
		while(it1.hasNext()){
			comboBox_1.addItem((String)it1.next());
		}
		Iterator it2 = ids_vol.iterator();
		while(it2.hasNext()){
			comboBox_2.addItem((Integer)it2.next());
		}
		
		JButton btnNewButton_1 = new JButton("Ajouter reservation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					ReservationBillets.this.validate();
					ReservationBillets.this.repaint();
					PreparedStatement ps5=conn.prepareStatement("select num_reservation from reservation where num_reservation = max(num_reservation)");
					 ResultSet rs = ps5.executeQuery();
					 rs.next();
					 int num_reservation = rs.getInt(1)+1;
					 String nom_passager = textField.getText();
					 String prenom_passager = textField_1.getText();
					 String cin = textField_2.getText();
					 String tel = textField_3.getText();
					 String date_reservation = textField_4.getText();
					 String nom_classe = (String) comboBox.getSelectedItem();
					 String nom_categorie = (String) comboBox_1.getSelectedItem();
					 int id_vol = (Integer) comboBox_2.getSelectedItem();
					// Reservation.reserverBillet(nom_passager, prenom_passager, tel,
							 //cin, id_vol, nom_categorie, nom_classe, date_reservation, 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(386, 235, 133, 45);
		panel_1.add(btnNewButton_1);
		
		setVisible(true);
	
		
		
		
	

		
		
		
		
		
		
		
		
		
		
		
	}
	public JPanel ajr() {
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(x, 126, 555, 291);
		//panel_1.setBounds(x, 126, 150, 150);
		panel_1.setLayout(null);
		x=x+224;
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNom.setBounds(10, 39, 56, 22);
		panel_1.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrenom.setBounds(10, 72, 56, 22);
		panel_1.add(lblPrenom);
		
		JLabel lblCin = new JLabel("CIN");
		lblCin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCin.setBounds(10, 101, 56, 22);
		panel_1.add(lblCin);
		
		textField = new JTextField();
		textField.setBounds(85, 41, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 74, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(85, 103, 86, 20);
		panel_1.add(textField_2);
		JLabel lblTel = new JLabel("TEL");
		lblTel.setBounds(20, 147, 46, 14);
		panel_1.add(lblTel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(85, 144, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDateReservation = new JLabel("Date reservation");
		lblDateReservation.setBounds(10, 185, 105, 14);
		panel_1.add(lblDateReservation);
		
		textField_4 = new JTextField();
		textField_4.setBounds(95, 182, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(305, 44, 62, 17);
		panel_1.add(lblCategorie);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setBounds(305, 77, 46, 14);
		panel_1.add(lblClasse);
		
		JLabel lblNumeroDeVol = new JLabel("Numero de vol");
		lblNumeroDeVol.setBounds(293, 114, 86, 22);
		panel_1.add(lblNumeroDeVol);
		
		
		comboBox.setBounds(398, 41, 79, 20);
		panel_1.add(comboBox);
		
		
		comboBox_1.setBounds(398, 74, 79, 20);
		panel_1.add(comboBox_1);
		
	
		comboBox_2.setBounds(398, 115, 79, 20);
		panel_1.add(comboBox_2);
		

		Vector<String> cat = Categorie.listeCategorie();
		Vector<String> classes = Classe.listeClasses();
		Vector<Integer> ids_vol = Vol.listeIdVols();
		Iterator it = cat.iterator();
		while(it.hasNext()){
			comboBox.addItem((String)it.next());
		}
		
		Iterator it1 = classes.iterator();
		while(it1.hasNext()){
			comboBox_1.addItem((String)it1.next());
		}
		Iterator it2 = ids_vol.iterator();
		while(it2.hasNext()){
			comboBox_2.addItem((Integer)it2.next());
		}
		
		JButton btnNewButton_1 = new JButton("Ajouter reservation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					ReservationBillets.this.validate();
					ReservationBillets.this.repaint();
					PreparedStatement ps5=conn.prepareStatement("select num_reservation from reservation where num_reservation = max(num_reservation)");
					 ResultSet rs = ps5.executeQuery();
					 rs.next();
					 int num_reservation = rs.getInt(1)+1;
					 String nom_passager = textField.getText();
					 String prenom_passager = textField_1.getText();
					 String cin = textField_2.getText();
					 String tel = textField_3.getText();
					 String date_reservation = textField_4.getText();
					 String nom_classe = (String) comboBox.getSelectedItem();
					 String nom_categorie = (String) comboBox_1.getSelectedItem();
					 int id_vol = (Integer) comboBox_2.getSelectedItem();
					// Reservation.reserverBillet(nom_passager, prenom_passager, tel,
						//	 cin, id_vol, nom_categorie, nom_classe, date_reservation, num_reservation);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(386, 235, 133, 45);
		panel_1.add(btnNewButton_1);
		
		
		return panel_1;
		
		
	}
	public static void main(String[] args) {
		new ReservationBillets();
	}
}
