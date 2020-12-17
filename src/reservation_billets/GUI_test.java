package reservation_billets;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

public class GUI_test extends JFrame {



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					GUI_test window = new GUI_test();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the application.
	 */
	public GUI_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(1350,720);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 275, 1055, 365);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 238, 49);
		panel_1.add(btnNewButton);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(234, 0, 250, 49);
		panel_1.add(button_1);
		
		JButton button = new JButton("New button");
		button.setBounds(482, 0, 250, 49);
		panel_1.add(button);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(731, 0, 250, 49);
		panel_1.add(button_2);
	}
}
