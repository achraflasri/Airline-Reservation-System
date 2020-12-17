package interfaces_projet;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import reservation_billets.Connexion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
public class interfaces_authentification extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private static Connection conn=Connexion.getConnection();
	public interfaces_authentification() {
		setUndecorated(true);
		setSize(700,300);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, SystemColor.activeCaption));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/logiin.png")));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(54, 103, 33, 29);
		panel.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login         :");
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLogin.setBounds(97, 101, 100, 26);
		panel.add(lblLogin);
		
		JLabel lblConnectezVos = new JLabel("Connectez Vous Pour Acceder a Votre Espace");
		lblConnectezVos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectezVos.setForeground(new Color(50, 205, 50));
		lblConnectezVos.setBackground(Color.RED);
		lblConnectezVos.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		lblConnectezVos.setBounds(193, 42, 321, 26);
		panel.add(lblConnectezVos);
		
		JLabel lblPassword = new JLabel("Password   :");
		lblPassword.setBackground(Color.MAGENTA);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(86, 166, 111, 26);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(207, 101, 289, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(207, 165, 289, 32);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/wanari.PNG")));
		lblNewLabel_1.setBounds(512, 80, 157, 160);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Se Connecter");
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(207, 223, 289, 32);
		btnNewButton.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent arg0) {
				try {
					String admin = textField.getText();
					String passwd = new String(passwordField.getPassword());
					PreparedStatement ps1 = conn.prepareStatement("select login,password from admin where Exists (select * from admin where login=? and password =?)");
					ps1.setString(1, admin);
					ps1.setString(2, passwd);
					ResultSet rs1 = ps1.executeQuery();
					boolean p = rs1.next();
					if(p==true)
					{
						 
							new acceuil_admin();
							dispose();
						
					}
					else
					{
						lblConnectezVos.setText("Login ou mot de passe incorrect");
						lblConnectezVos.setForeground(Color.RED);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(this.getClass().getResource("/passwoord.png")));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(54, 167, 33, 29);
		panel.add(label);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setBounds(645, 11, 24, 14);
		panel.add(lblX);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new interfaces_authentification();
	}
}
