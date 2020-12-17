package interfaces_projet;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
public class menu_admin extends JFrame {
	private static final long serialVersionUID = 1L;
	public menu_admin() {
		setSize(900,500);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.inactiveCaptionBorder, SystemColor.inactiveCaptionBorder));
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
				new gestion_avion();
				menu_admin.this.setVisible(false);;
			}
		});
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(91, 27, 164, 191);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/avion_chibi.png")));
		lblNewLabel.setBounds(28, 24, 107, 102);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Avion");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(38, 144, 86, 22);
		
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(244, 247, 252), SystemColor.inactiveCaptionBorder));
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
			public void mouseClicked(MouseEvent e) {
				new Gestion_categorie();
				menu_admin.this.setVisible(false);;
			}
		});
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(351, 27, 164, 191);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(this.getClass().getResource("/cat_chibi.png")));
		label.setBounds(29, 31, 107, 107);
		panel_2.add(label);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCategorie.setBounds(29, 141, 107, 22);
		panel_2.add(lblCategorie);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.inactiveCaptionBorder, SystemColor.inactiveCaptionBorder));
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_3.setBackground(SystemColor.inactiveCaptionBorder);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Gestion_trajet();
				menu_admin.this.setVisible(false);;
			}
		});
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(607, 27, 164, 191);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/trajett_chibi.png")));
		label_1.setBounds(28, 33, 107, 109);
		panel_3.add(label_1);
		
		JLabel lblTrajet = new JLabel("Trajet");
		lblTrajet.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrajet.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTrajet.setBounds(38, 146, 86, 22);
		panel_3.add(lblTrajet);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.inactiveCaptionBorder, SystemColor.inactiveCaptionBorder));
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_4.setBackground(SystemColor.inactiveCaptionBorder);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Gestion_classe();
				menu_admin.this.setVisible(false);;
			}
		});
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(91, 241, 164, 191);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon(this.getClass().getResource("/classe_chibi.png")));
		label_2.setBounds(26, 27, 107, 102);
		panel_4.add(label_2);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasse.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClasse.setBounds(36, 140, 86, 22);
		panel_4.add(lblClasse);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.inactiveCaptionBorder, SystemColor.inactiveCaptionBorder));
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_5.setBackground(SystemColor.inactiveCaptionBorder);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Gestion_ville();
				menu_admin.this.setVisible(false);;
			}
		});
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(351, 241, 164, 191);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setIcon(new ImageIcon(this.getClass().getResource("/ville_chibi.png")));
		label_3.setBounds(28, 24, 107, 102);
		panel_5.add(label_3);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBackground(Color.WHITE);
		lblVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVille.setBounds(38, 137, 86, 22);
		panel_5.add(lblVille);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.inactiveCaptionBorder, SystemColor.inactiveCaptionBorder));
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_6.setBackground(SystemColor.inactiveCaptionBorder);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Gestion_vol();
				menu_admin.this.setVisible(false);;
			}
		});
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(607, 241, 164, 191);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setIcon(new ImageIcon(this.getClass().getResource("/vol_chibi.png")));
		label_4.setBounds(29, 22, 110, 107);
		panel_6.add(label_4);
		
		JLabel lblVol = new JLabel("Vol");
		lblVol.setHorizontalAlignment(SwingConstants.CENTER);
		lblVol.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVol.setBounds(39, 135, 86, 22);
		panel_6.add(lblVol);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new acceuil_admin();
				dispose();
			}
		});
	lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/icons8_left_30px_1.png")));
		lblNewLabel_2.setBounds(0, 0, 38, 44);
		panel.add(lblNewLabel_2);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
	}
	public static void main(String[] args) {
		new menu_admin();
	}
}
