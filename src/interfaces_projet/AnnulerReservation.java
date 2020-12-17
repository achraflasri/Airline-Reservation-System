package interfaces_projet;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnnulerReservation extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	
	public AnnulerReservation() {
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblIdentifiantDeReservation = new JLabel("Identifiant de Reservation : ");
		lblIdentifiantDeReservation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIdentifiantDeReservation.setBounds(170, 98, 310, 67);
		panel.add(lblIdentifiantDeReservation);
		
		textField = new JTextField();
		textField.setBounds(490, 98, 232, 67);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblConfirmer = new JLabel("Confirmer");
		lblConfirmer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel lblRebbiRebbiii = new JLabel("Rebbi Rebbiii ");
				lblRebbiRebbiii.setFont(new Font("Tekton Pro Ext", Font.BOLD, 57));
				lblRebbiRebbiii.setBounds(284, 220, 626, 114);
				panel.add(lblRebbiRebbiii);
				AnnulerReservation.this.validate();
				AnnulerReservation.this.repaint();
			}
		});
		lblConfirmer.setFont(new Font("Tekton Pro Ext", Font.BOLD, 18));
		lblConfirmer.setBounds(778, 98, 108, 67);
		panel.add(lblConfirmer);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\icons8_checked_30px.png"));
		label.setBounds(809, 140, 47, 25);
		panel.add(label);
		
		setSize(1000, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AnnulerReservation();
	}
}
