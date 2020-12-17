package interfaces_projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import reservation_billets.Ville;
import reservation_billets.Vol;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class RechercherVol extends JFrame {

	private static final long serialVersionUID = 1L;
	private String NOT_SELECTABLE_OPTION = " - Flying From - ";
	private String NOT_SELECTABLE_OPTION1 = " - Flying To - ";
	private Vector<String> NORMAL_OPTION = Ville.listeVilles();
	private Connection connection;
	private JTextField txtJjmmaaaa;
	public RechercherVol() {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.setBounds(54, 82, 126, 36);
	    comboBox.setModel(new DefaultComboBoxModel<String>() {
	      private static final long serialVersionUID = 1L;
	      boolean selectionAllowed = true;
	      @Override
	      public void setSelectedItem(Object anObject) {
	        if (!NOT_SELECTABLE_OPTION.equals(anObject)) {
	          super.setSelectedItem(anObject);
	        } else if (selectionAllowed) {
	          // Allow this just once
	          selectionAllowed = false;
	          super.setSelectedItem(anObject);
	        }
	      }
	    });
	    comboBox.addItem(NOT_SELECTABLE_OPTION);
	    comboBox.addItem(NORMAL_OPTION.get(0));
	    comboBox.addItem(NORMAL_OPTION.get(1));
		panel.add(comboBox);
		
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(270, 82, 126, 36);
	    comboBox_1.setModel(new DefaultComboBoxModel<String>() {
	      private static final long serialVersionUID = 1L;
	      boolean selectionAllowed = true;
	      @Override
	      public void setSelectedItem(Object anObject) {
	        if (!NOT_SELECTABLE_OPTION1.equals(anObject)) {
	          super.setSelectedItem(anObject);
	        } else if (selectionAllowed) {
	          // Allow this just once
	          selectionAllowed = false;
	          super.setSelectedItem(anObject);
	        }
	      }
	    });
	    comboBox_1.addItem(NOT_SELECTABLE_OPTION1);
	    comboBox_1.addItem(NORMAL_OPTION.get(0));
	    comboBox_1.addItem(NORMAL_OPTION.elementAt(1));
		panel.add(comboBox_1);
		
		JButton btnConfirmer = new JButton("Rechercher Vol");
		btnConfirmer.setBackground(Color.blue);
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String villeDepart = (String) comboBox.getSelectedItem();
				String villeArivee = (String) comboBox_1.getSelectedItem();
				String dateDepart = txtJjmmaaaa.getText();
				Vol.afficherVols(villeDepart, villeArivee, dateDepart);
				

				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnConfirmer.setBounds(599, 82, 145, 36);
		panel.add(btnConfirmer);
		
		txtJjmmaaaa = new JTextField("jj/mm/aaaa");
		txtJjmmaaaa.setForeground(Color.GRAY);
		txtJjmmaaaa.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
				
			}
			public void focusGained(FocusEvent arg0) {
				txtJjmmaaaa.setText("");
			}
			
		});
		txtJjmmaaaa.setBounds(436, 82, 122, 36);
		panel.add(txtJjmmaaaa);
		txtJjmmaaaa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\icons8_airplane_take_off_26px.png"));
		lblNewLabel.setBounds(23, 82, 47, 46);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\icons8_airplane_landing_26px.png"));
		lblNewLabel_1.setBounds(239, 93, 51, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblVilleDepart = new JLabel("Ville Depart");
		lblVilleDepart.setFont(new Font("Tekton Pro", Font.BOLD, 16));
		lblVilleDepart.setBounds(80, 51, 100, 36);
		panel.add(lblVilleDepart);
		
		JLabel lblVilleArrivee = new JLabel("Ville Arrivee");
		lblVilleArrivee.setFont(new Font("Tekton Pro", Font.BOLD, 16));
		lblVilleArrivee.setBounds(296, 51, 100, 36);
		panel.add(lblVilleArrivee);
		
		JLabel lblDateDepart = new JLabel("Date Depart");
		lblDateDepart.setFont(new Font("Tekton Pro", Font.BOLD, 16));
		lblDateDepart.setBounds(458, 51, 100, 36);
		panel.add(lblDateDepart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(54, 234, 677, 249);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPhoto = new JLabel("photo");
		lblPhoto.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Agadir.jpg"));
		lblPhoto.setBounds(52, 29, 142, 114);
		panel_1.add(lblPhoto);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\icons8_horizontal_line_40px.png"));
		label.setBounds(232, 75, 46, 24);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\icons8_airplane_mode_on_24px.png"));
		label_1.setBounds(288, 75, 33, 24);
		panel_1.add(label_1);
		
		JLabel lblPhoto_1 = new JLabel("photo");
		lblPhoto_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Tanger.jpg"));
		lblPhoto_1.setBounds(347, 29, 142, 107);
		panel_1.add(lblPhoto_1);
		
		JLabel lblDuree = new JLabel("Duree");
		lblDuree.setBounds(232, 50, 46, 14);
		panel_1.add(lblDuree);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(62, 159, 46, 14);
		panel_1.add(lblVille);
		
		JLabel label_2 = new JLabel("Ville");
		label_2.setBounds(337, 159, 46, 14);
		panel_1.add(label_2);
		setSize(800, 600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new RechercherVol();
	}
}
