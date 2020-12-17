package interfaces_projet;


import reservation_billets.*;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

import java.awt.Component;

import javax.swing.Box;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;




import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

import java.sql.*;
import java.util.Vector;

public class modsu extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField texto;
	private JTextField textya;
	private JTextField texto1;
	private JTextField texto2;
	private JTextField texto3;
	private static Connection conn=Connexion.getConnection();
	private Vector<String> NORMAL_OPTION_CLASSE = Classe.listeClasses();
	private Vector<String> NORMAL_OPTION_CATEGORIE = Categorie.listeCategorie();
	private JTextField texto4;
	public modsu() {
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
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\lg.png"));
		lblNewLabel_8.setBounds(31, 4, 86, 86);
		panel.add(lblNewLabel_8);
		
		JButton btnSeConnecter = new JButton("Se Connecter ");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new interfaces_authentification();
			}
		});
		btnSeConnecter.setForeground(Color.BLACK);
		btnSeConnecter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSeConnecter.setBackground(new Color(0, 0, 205));
		btnSeConnecter.setBounds(1131, 27, 177, 37);
		panel.add(btnSeConnecter);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		//panel_2.setBackground(Color.WHITE);
		//panel_2.setBackground(new Color(0,0,0,20));
		panel_2.setBounds(117, 218, 1121, 427);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panini = new JPanel();
		panini.setBackground(new Color(0,0,0,20));
		panini.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panini.setBounds(0, 0, 1121, 62);
		panel_2.add(panini);
		panini.setLayout(new GridLayout(1,4, 0, 0));
		
		JPanel panel_4 = new JPanel();
		//panel_4.setBackground(new Color(0,0,0,20));
		panini.add(panel_4);
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
		panini.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel labellevie = new JLabel("New label");
		labellevie.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\reserver.png"));
		labellevie.setBounds(36, 11, 42, 42);
		panel_5.add(labellevie);
		
		JLabel lblNewLabel_1 = new JLabel("Reserver Billets ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(91, 13, 148, 34);
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panini.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel labino = new JLabel("New label");
		labino.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\lis.png"));
		labino.setBounds(41, 11, 42, 42);
		panel_6.add(labino);
		
		JLabel lblMesReservations = new JLabel("Mes Reservations");
		lblMesReservations.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMesReservations.setBounds(98, 11, 152, 34);
		panel_6.add(lblMesReservations);
		
		JPanel panino = new JPanel();
		panini.add(panino);
		panino.setLayout(null);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\ge.png"));
		label_2.setBounds(28, 11, 42, 42);
		panino.add(label_2);
		
		JLabel lblModifiersupprimer = new JLabel("Modifier/Supprimer");
		lblModifiersupprimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModifiersupprimer.setBounds(93, 11, 176, 34);
		panino.add(lblModifiersupprimer);
		
		JPanel modifierSupprimerPanel = new JPanel();
		modifierSupprimerPanel.setBackground(SystemColor.controlHighlight);
		modifierSupprimerPanel.setBounds(0, 62, 1121, 365);
		panel_2.add(modifierSupprimerPanel);
		modifierSupprimerPanel.setLayout(null);
		
		JLabel labani = new JLabel("Num\u00E9ro Passager :");
		labani.setHorizontalAlignment(SwingConstants.CENTER);
		labani.setBounds(155, 19, 181, 29);
		labani.setFont(new Font("Tahoma", Font.BOLD, 14));
		modifierSupprimerPanel.add(labani);
		
		JPanel fofopanel = new JPanel();
		fofopanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 205), null));
		fofopanel.setBackground(SystemColor.controlHighlight);
		fofopanel.setBounds(57, 70, 1016, 272);
		fofopanel.setLayout(null);
		
		
		JComboBox combowa = new JComboBox();
		combowa.setBackground(SystemColor.menu);
		combowa.setBounds(629, 43, 305, 31);
	
		fofopanel.add(combowa);
		
		JLabel lblNomhamid = new JLabel("Nom :");
		lblNomhamid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomhamid.setBounds(59, 46, 82, 23);
		fofopanel.add(lblNomhamid);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrnom.setBounds(59, 88, 82, 23);
		fofopanel.add(lblPrnom);
		
		JLabel lblCinhamid = new JLabel("TEL :");
		lblCinhamid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCinhamid.setBounds(59, 133, 82, 23);
		fofopanel.add(lblCinhamid);
		
		JLabel tel = new JLabel("CIN :");
		tel.setFont(new Font("Tahoma", Font.BOLD, 13));
		tel.setBounds(59, 176, 82, 23);
		fofopanel.add(tel);
		
		JLabel lblClassehamid = new JLabel("Classe :");
		lblClassehamid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClassehamid.setBounds(532, 107, 82, 23);
		fofopanel.add(lblClassehamid);
		
		JLabel lblCatgoriehamid = new JLabel("Cat\u00E9gorie :");
		lblCatgoriehamid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCatgoriehamid.setBounds(532, 46, 82, 23);
		fofopanel.add(lblCatgoriehamid);
		
		texto = new JTextField();
		texto.setBackground(SystemColor.menu);
		texto.setColumns(10);
		texto.setBounds(183, 43, 305, 31);
		fofopanel.add(texto);
		
		texto1 = new JTextField();
		texto1.setBackground(SystemColor.menu);
		texto1.setColumns(10);
		texto1.setBounds(183, 85, 305, 31);
		fofopanel.add(texto1);
		
		texto2 = new JTextField();
		texto2.setBackground(SystemColor.menu);
		texto2.setColumns(10);
		texto2.setBounds(183, 130, 305, 31);
		fofopanel.add(texto2);
		
		texto3 = new JTextField();
		texto3.setBackground(SystemColor.menu);
		texto3.setColumns(10);
		texto3.setBounds(183, 173, 305, 31);
		fofopanel.add(texto3);
		
		JComboBox combowa2 = new JComboBox();
		combowa2.setBackground(SystemColor.menu);
		combowa2.setBounds(629, 104, 305, 31);
		fofopanel.add(combowa2);
		
		
		
		JLabel lblNumeroVol = new JLabel("Numero vol :");
		lblNumeroVol.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumeroVol.setBounds(59, 221, 100, 23);
		fofopanel.add(lblNumeroVol);
		
		texto4 = new JTextField();
		texto4.setColumns(10);
		texto4.setBackground(SystemColor.menu);
		texto4.setBounds(183, 223, 305, 31);
		fofopanel.add(texto4);
		
		textya = new JTextField();
		textya.setBackground(SystemColor.menu);
		textya.setColumns(10);
		textya.setBounds(353, 20, 344, 31);
		modifierSupprimerPanel.add(textya);
		
		JPanel hamidapanel = new JPanel();
		hamidapanel.setBackground(new Color(240,240,240));
		hamidapanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		hamidapanel.setBounds(629, 161, 141, 83);
		fofopanel.add(hamidapanel);
		hamidapanel.setLayout(null);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl3.setForeground(Color.BLACK);
		lbl3.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\del.png"));
		lbl3.setBounds(10, 24, 42, 42);
		hamidapanel.add(lbl3);
		
		JLabel lblNewLabel_4 = new JLabel("Supprimer ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(52, 30, 79, 28);
		hamidapanel.add(lblNewLabel_4);
		
		hamidapanel.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int id_reservation = Integer.parseInt(textya.getText());
				String nom_classe =(String) combowa2.getSelectedItem();
				Reservation.annulerReservation(id_reservation, nom_classe);	
				JOptionPane.showMessageDialog(null, "Suppression effetuée avec succès");
			}
			@Override
			public void mouseEntered(MouseEvent e){
				hamidapanel.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e){
				hamidapanel.setBackground(new Color(240,240,240));
			}
			@Override
			public void mousePressed(MouseEvent e){
				hamidapanel.setBorder(new LineBorder(new Color(0, 0, 205), 4));
			}
			@Override
			public void mouseReleased(MouseEvent e){
				hamidapanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
			}
			 
	});
		
		
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		panel_10.setLayout(null);
		panel_10.setBounds(794, 161, 141, 83);
		fofopanel.add(panel_10);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\edit.png"));
		label_4.setBounds(10, 24, 42, 42);
		panel_10.add(label_4);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModifier.setBounds(62, 30, 63, 28);
		panel_10.add(lblModifier);
		
		panel_10.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int id_reservation = Integer.parseInt(textya.getText());
				String nom = texto.getText();
				String prenom = texto1.getText();
				String tel = texto2.getText();
				String cin = texto3.getText();
				int id_vol = Integer.parseInt(texto4.getText());
				String nom_classe =(String) combowa2.getSelectedItem();
				String nom_categorie =(String) combowa.getSelectedItem();
				Reservation.modifierReservation(id_reservation, nom, prenom, tel, cin, id_vol, nom_categorie, nom_classe);
				JOptionPane.showMessageDialog(null, "Modification effetuée avec succès");
			
			}
			@Override
			public void mouseEntered(MouseEvent e){
				panel_10.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e){
				panel_10.setBackground(new Color(240,240,240));
			}
			@Override
			public void mousePressed(MouseEvent e){
				panel_10.setBorder(new LineBorder(new Color(0, 0, 205), 4));
			}
			@Override
			public void mouseReleased(MouseEvent e){
				panel_10.setBorder(new LineBorder(new Color(0, 0, 205), 2));
			}
			 
	});
		modifierSupprimerPanel.add(fofopanel);
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		panel_11.setBounds(762, 19, 195, 35);
		panel_11.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent arg0) {
					modifierSupprimerPanel.add(fofopanel);
					int id_reservation = Integer.parseInt(textya.getText());
					try {
						PreparedStatement ps =conn.prepareStatement("select id_passager,id_vol from reservation where id_reservation = ?");
						ps.setInt(1,id_reservation);
						ResultSet rs = ps.executeQuery();
						rs.next();
						int id_passager = rs.getInt(1);
						PreparedStatement ps1 =conn.prepareStatement("select nom_passager,prenom_passager,tel_passager,cin from passager where id_passager = ?");
						ps1.setInt(1,id_passager);
						ResultSet rs1 = ps1.executeQuery();
						rs1.next();
						texto.setText(rs1.getString(1));
						texto1.setText(rs1.getString(2));
						texto2.setText(rs1.getString(3));
						texto3.setText(rs1.getString(4));
						texto4.setText(rs.getString(2));
						
						for(int i = 0 ; i<NORMAL_OPTION_CATEGORIE.size();i++) {
							combowa.addItem(NORMAL_OPTION_CATEGORIE.get(i));
							}
						for(int i = 0 ; i<NORMAL_OPTION_CLASSE.size();i++) {
							combowa2.addItem(NORMAL_OPTION_CLASSE.get(i));
							}
						validate(); repaint();
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				 
		});
		modifierSupprimerPanel.add(panel_11);
		
		JLabel lanib = new JLabel("Rechercher ");
		lanib.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_11.add(lanib);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\mlkj.PNG"));
		lblNewLabel_3.setBounds(0, 45, 1344, 332);
		getContentPane().add(lblNewLabel_3);
		setVisible(true);
	}
	public static void main(String[] args) {
		new modsu();
	}
}
