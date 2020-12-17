package interfaces_projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class espace_Statistique extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public espace_Statistique() {
	getContentPane().setLayout(new BorderLayout(0, 0));
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.white);
	getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
    JLabel label1 = new JLabel("");
	label1.setIcon(new ImageIcon(this.getClass().getResource("/icons8_left_30px_1.png")));
	label1.setBounds(0, 0, 37, 32);
	JPanel returnPanel = new JPanel(new BorderLayout());
	returnPanel.add(BorderLayout.CENTER,label1);
	returnPanel.setBackground(Color.white);
	getContentPane().add(returnPanel, BorderLayout.NORTH);
	label1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			new acceuil_admin();
			dispose();
		}
	});
	
	JLabel lblBienvenuDansLespace = new JLabel("Bienvenue Dans  l'Espace Statistique");
	lblBienvenuDansLespace.setForeground( Color.DARK_GRAY);
	lblBienvenuDansLespace.setHorizontalAlignment(SwingConstants.CENTER);
	lblBienvenuDansLespace.setBounds(104, 26, 689, 31);
	lblBienvenuDansLespace.setFont(new Font("Tahoma", Font.BOLD, 15));
	panel.add(lblBienvenuDansLespace);
	
	JLabel lblNewLabel = new JLabel("Statistiques Par Client");
	JLabel lblNewLabel_1 = new JLabel("");
	
	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.inactiveCaptionBorder, SystemColor.inactiveCaptionBorder));
	panel_1.setBackground(Color.WHITE);
	panel_1.setBounds(163, 124, 235, 289);
	panel.add(panel_1);
	panel_1.setLayout(null);
	panel_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel_1.setBackground(Color.WHITE);
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new statistique_par_client();
			dispose();
		}
	});
	
	
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblNewLabel.setForeground(new Color(46,102,139));
	lblNewLabel.setBounds(41, 209, 149, 33);
	panel_1.add(lblNewLabel);
	
	
	lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/sttat.PNG")));
	lblNewLabel_1.setBounds(41, 39, 149, 134);
	panel_1.add(lblNewLabel_1);
	
	JPanel panel_2 = new JPanel();
	JLabel lblGestionDeDonnes = new JLabel("Statistiques Par Mois");
	JLabel label = new JLabel("New label");
	panel_2.setBackground(Color.WHITE);
	panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.inactiveCaptionBorder, SystemColor.inactiveCaptionBorder));
	panel_2.setBounds(481, 124, 235, 289);
	panel.add(panel_2);
	panel_2.setLayout(null);
	panel_2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel_2.setBackground(Color.WHITE);
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new statistique_par_mois_menu();
			dispose();
			
		}
	});
	
	

	lblGestionDeDonnes.setForeground(new Color(46,102,139));
	lblGestionDeDonnes.setHorizontalAlignment(SwingConstants.CENTER);
	lblGestionDeDonnes.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblGestionDeDonnes.setBounds(27, 210, 186, 33);
	panel_2.add(lblGestionDeDonnes);
	
	
	label.setIcon(new ImageIcon(this.getClass().getResource("/o.PNG")));
	label.setBounds(24, 26, 188, 188);
	panel_2.add(label);
	
	JLabel lblChoisissezUneOption = new JLabel("Choisissez une option");
	lblChoisissezUneOption.setForeground(SystemColor.windowBorder);
	lblChoisissezUneOption.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblChoisissezUneOption.setBounds(362, 56, 185, 37);
	panel.add(lblChoisissezUneOption);
	setSize(900,500);
	setLocationRelativeTo(null);
	setVisible(true);
	setResizable(false);
}
public static void main(String[] args) {
	new espace_Statistique();
}
	
}
