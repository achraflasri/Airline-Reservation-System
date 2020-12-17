package interfaces_projet;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

import org.jfree.ui.Spinner;

import reservation_billets.Avion;
import reservation_billets.Categorie;
import reservation_billets.Classe;
import reservation_billets.Connexion;
import reservation_billets.Reservation;
import reservation_billets.Ville;
import reservation_billets.Vol;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JSpinner;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.UIManager;

public class Formulaire extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	JPanel menuPanel = new JPanel();
	JPanel panel_2 = new JPanel();
	JPanel choicePanel = new JPanel();
	JPanel chercherVolButtonPanel = new JPanel();
	JPanel reserverBilletButtonPanel = new JPanel();
	JPanel mesReservationButtonPanel = new JPanel();
	JPanel modifierSupprimerButtonPanel = new JPanel();
	JPanel chercherVolPanel = new JPanel();
	JPanel mesReservationPanel = new JPanel();
	JPanel modifierSupprimerPanel = new JPanel();
	JPanel reserverBilletPanel = new JPanel();
	JLabel affich = new JLabel("Pas de vol trouvee ");
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField telField;
	private JTextField cinField;
	private JTextField idvolField;
	private Vector<String> CATEGORIE_NORMAL_OPTION = Categorie.listeCategorie();
	private Vector<String> CLASSE_NORMAL_OPTION = Classe.listeClasses();
	SpinnerModel sm = new SpinnerNumberModel(0,0,15,1);
	JSpinner spinner = new JSpinner(sm);
	private static int nb ;
	private static int nbPassager = 1 ;
	private static int clic=0 ;
	JPanel pan = new JPanel();
	JComboBox<String> sexeComboBoxe = new JComboBox<String>();	
	JComboBox<String> comboBoxClass = new JComboBox<String>();
	JComboBox<String> comboBoxCatego = new JComboBox<String>();
	private String NOT_SELECTABLE_OPTION = " - Flying From - ";
	private String NOT_SELECTABLE_OPTION1 = " - Flying To - ";
	private Vector<String> NORMAL_OPTION = Ville.listeVilles();
	private JTextField dateField;
	private JTextField texto;
	private JTextField textya;
	private JTextField texto1;
	private JTextField texto2;
	private JTextField texto3;
	private JTextField texto4;
	private static Connection conn=Connexion.getConnection();
	private Vector<String> NORMAL_OPTION_CLASSE = Classe.listeClasses();
	private Vector<String> NORMAL_OPTION_CATEGORIE = Categorie.listeCategorie();
	int num_reservation;
	static int k =0;
	public Formulaire() {
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("Form");
		setSize(1350, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		

		getContentPane().add(menuPanel);
		menuPanel.setBackground(SystemColor.menu);
		menuPanel.setBounds(0, 0, 1344, 95);
		menuPanel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(this.getClass().getResource("/lg.png")));
		lblNewLabel_8.setBounds(31, 4, 86, 86);
		menuPanel.add(lblNewLabel_8);
		
		JButton btnSeConnecter = new JButton("Se Connecter ");
		btnSeConnecter.setForeground(Color.white);
		btnSeConnecter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSeConnecter.setBackground(new Color(0, 0, 205));
		btnSeConnecter.setBounds(1131, 27, 177, 37);
		btnSeConnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new interfaces_authentification();
				
				Formulaire.this.validate();
				Formulaire.this.repaint();
			}
		});
		menuPanel.add(btnSeConnecter);
		
		
		panel_2.setBounds(117, 218, 1121, 427);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		
		choicePanel.setBackground(new Color(0,0,0,20));
		choicePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		choicePanel.setBounds(0, 0, 1121, 62);
		panel_2.add(choicePanel);
		choicePanel.setLayout(new GridLayout(1,4, 0, 0));
		
		
		choicePanel.add(chercherVolButtonPanel);
		chercherVolButtonPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/rechercher.png")));
		lblNewLabel.setBounds(41, 11, 42, 42);
		chercherVolButtonPanel.add(lblNewLabel);
		
		JLabel lblRechercherVols = new JLabel("Rechercher Vols");
		lblRechercherVols.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechercherVols.setBounds(94, 13, 145, 34);
		chercherVolButtonPanel.add(lblRechercherVols);
		
		
		choicePanel.add(reserverBilletButtonPanel);
		reserverBilletButtonPanel.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(this.getClass().getResource("/reserver.png")));
		label.setBounds(36, 11, 42, 42);
		reserverBilletButtonPanel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Reserver Billets ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(91, 13, 148, 34);
		reserverBilletButtonPanel.add(lblNewLabel_1);
		
		
		choicePanel.add(mesReservationButtonPanel);
		mesReservationButtonPanel.setLayout(null);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/lis.png")));
		label_1.setBounds(41, 11, 42, 42);
		mesReservationButtonPanel.add(label_1);
		
		JLabel lblMesReservations = new JLabel("Mes Reservations");
		lblMesReservations.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMesReservations.setBounds(98, 11, 152, 34);
		mesReservationButtonPanel.add(lblMesReservations);
		
		
		choicePanel.add(modifierSupprimerButtonPanel);
		modifierSupprimerButtonPanel.setLayout(null);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon(this.getClass().getResource("/ge.png")));
		label_2.setBounds(28, 11, 42, 42);
		modifierSupprimerButtonPanel.add(label_2);
		
		JLabel lblModifiersupprimer = new JLabel("Modifier/Supprimer");
		lblModifiersupprimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModifiersupprimer.setBounds(93, 11, 176, 34);
		modifierSupprimerButtonPanel.add(lblModifiersupprimer);
		
		// Panel for looking 
		
		mesReservationPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mesReservationPanel.setBounds(0, 62, 1121, 365);
		mesReservationPanel.setLayout(null);
		
		JLabel lblNumReservation = new JLabel("Num Reservation : ");
		lblNumReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumReservation.setBounds(224, 29, 147, 32);
		mesReservationPanel.add(lblNumReservation);
		
		
		JTextField numReservationField = new JTextField();
		numReservationField.setBounds(357, 29, 303, 32);
		mesReservationPanel.add(numReservationField);
		numReservationField.setColumns(10);
		
		JButton btnNewButton = new JButton("Chercher");
		btnNewButton.setBackground(new Color(0, 0, 205));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(701, 24, 178, 41);
		mesReservationPanel.add(btnNewButton);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		panel_8.setBounds(10, 74, 1091, 280);
		panel_8.setBackground(Color.white);

		panel_8.setLayout(null);
		
		JLabel lblIdLock = new JLabel("Id Reservation ");
		lblIdLock.setForeground(new Color(0, 0, 205));
		lblIdLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdLock.setBounds(35, 11, 112, 23);
		panel_8.add(lblIdLock);
		
		JLabel lblId = new JLabel("1");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(35, 65, 88, 23);
		
		JLabel lblNomLock = new JLabel("Nom");
		lblNomLock.setForeground(new Color(0, 0, 205));
		lblNomLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomLock.setBounds(237, 11, 64, 23);
		panel_8.add(lblNomLock);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom.setBounds(213, 65, 97, 23);
		
		JLabel lblPrenomLock = new JLabel("Prenom ");
		lblPrenomLock.setForeground(new Color(0, 0, 205));
		lblPrenomLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrenomLock.setBounds(416, 11, 64, 23);
		panel_8.add(lblPrenomLock);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom.setBounds(416, 65, 97, 23);
		
		JLabel lblClasseLock = new JLabel("Classe ");
		lblClasseLock.setForeground(new Color(0, 0, 205));
		lblClasseLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClasseLock.setBounds(606, 11, 64, 23);
		panel_8.add(lblClasseLock);
		
		JLabel lblClasse = new JLabel("classe");
		lblClasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse.setBounds(600, 65, 70, 23);
		
		JLabel lblCategorieLock = new JLabel("Categorie ");
		lblCategorieLock.setForeground(new Color(0, 0, 205));
		lblCategorieLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategorieLock.setBounds(781, 11, 88, 23);
		panel_8.add(lblCategorieLock);
		
		JLabel lblCategorie = new JLabel("categorie");
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie.setBounds(781, 65, 99, 23);
		
		JLabel lblPrixLock = new JLabel("Prix ");
		lblPrixLock.setForeground(new Color(0, 0, 205));
		lblPrixLock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrixLock.setBounds(961, 11, 64, 23);
		panel_8.add(lblPrixLock);
		
		JLabel lblPrix = new JLabel("prix");
		lblPrix.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix.setBounds(942, 65, 139, 23);
		
		JLabel lblId_1 = new JLabel("id");
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_1.setBounds(35, 99, 88, 23);
		
		JLabel lblNom_1 = new JLabel("nom");
		lblNom_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_1.setBounds(213, 99, 97, 23);
		
		JLabel lblPrenom_1 = new JLabel("prenom");
		lblPrenom_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_1.setBounds(416, 99, 97, 23);
		
		JLabel lblClasse_1 = new JLabel("classe");
		lblClasse_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_1.setBounds(600, 99, 70, 23);
		
		JLabel lblCategorie_1 = new JLabel("categorie");
		lblCategorie_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie_1.setBounds(781, 99, 99, 23);
		
		JLabel lblPrix_1 = new JLabel("prix");
		lblPrix_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_1.setBounds(942, 99, 139, 23);
		
		JLabel lblId_2 = new JLabel("id");
		lblId_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_2.setBounds(35, 133, 88, 23);
		
		JLabel lblNom_2 = new JLabel("nom");
		lblNom_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_2.setBounds(213, 133, 82, 23);
		
		JLabel lblPrenom_2 = new JLabel("prenom");
		lblPrenom_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_2.setBounds(416, 133, 97, 23);
		
		JLabel lblClasse_2 = new JLabel("classe");
		lblClasse_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_2.setBounds(600, 133, 70, 23);
		
		JLabel lblCat_2 = new JLabel("categorie");
		lblCat_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCat_2.setBounds(781, 133, 99, 23);
		
		JLabel lblPrix_2 = new JLabel("prix");
		lblPrix_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_2.setBounds(942, 133, 139, 23);
		
		JLabel lblId_3 = new JLabel("id");
		lblId_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_3.setBounds(35, 167, 88, 23);
		
		JLabel lblNom_3 = new JLabel("nom");
		lblNom_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_3.setBounds(213, 167, 82, 23);
		
		JLabel lblPrenom_3 = new JLabel("prenom");
		lblPrenom_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_3.setBounds(416, 167, 97, 23);
		
		JLabel lblClasse_3 = new JLabel("classe");
		lblClasse_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_3.setBounds(600, 172, 70, 23);
		
		JLabel lblCategorie_3 = new JLabel("categorie");
		lblCategorie_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie_3.setBounds(781, 172, 99, 23);
		
		JLabel lblPrix_3 = new JLabel("prix");
		lblPrix_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_3.setBounds(942, 172, 139, 23);
		
		JLabel lblId_4 = new JLabel("id");
		lblId_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_4.setBounds(35, 240, 88, 23);
		
		JLabel lblNom_4 = new JLabel("nom");
		lblNom_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_4.setBounds(213, 240, 97, 23);
		
		JLabel lblPrenom_4 = new JLabel("prenom");
		lblPrenom_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_4.setBounds(416, 240, 97, 23);
		
		JLabel lblClasse_4 = new JLabel("classe");
		lblClasse_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_4.setBounds(600, 240, 70, 23);
		
		JLabel lblCategorie_4 = new JLabel("categorie");
		lblCategorie_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie_4.setBounds(781, 240, 99, 23);
		
		JLabel lblPrix_4 = new JLabel("prix");
		lblPrix_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_4.setBounds(942, 240, 139, 23);
		
		JLabel lblId_5 = new JLabel("id");
		lblId_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_5.setBounds(35, 206, 88, 23);
				
		JLabel lblNom_5 = new JLabel("nom");
		lblNom_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom_5.setBounds(213, 206, 82, 23);
		
		JLabel lblPrenom_5 = new JLabel("prenom");
		lblPrenom_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom_5.setBounds(416, 206, 97, 23);		
		
		JLabel lblClasse_5 = new JLabel("classe");
		lblClasse_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasse_5.setBounds(600, 206, 70, 23);		
		
		JLabel lblCategorie_5 = new JLabel("categorie");
		lblCategorie_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie_5.setBounds(781, 206, 85, 23);		
		
		JLabel lblPrix_5 = new JLabel("prix");
		lblPrix_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrix_5.setBounds(942, 206, 139, 23);
		
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(167, 110, 2, 221);
		panel_8.add(label_3);
		label_3.setIcon(new ImageIcon(this.getClass().getResource("/Sans titre - 1.png")));
		JLabel label_31 = new JLabel("");
		label_31.setBounds(347, 110, 2, 221);
		panel_8.add(label_31);
		label_31.setIcon(new ImageIcon(this.getClass().getResource("/Sans titre - 1.png")));
		JLabel label_32 = new JLabel("");
		label_32.setBounds(537, 110, 2, 221);
		panel_8.add(label_32);
		label_32.setIcon(new ImageIcon(this.getClass().getResource("/Sans titre - 1.png")));
		JLabel label_34 = new JLabel("");
		label_34.setBounds(906, 110, 2, 221);
		panel_8.add(label_34);
		label_34.setIcon(new ImageIcon(this.getClass().getResource("/Sans titre - 1.png")));
		JLabel label_33 = new JLabel("");
		label_33.setBounds(722, 110, 2, 221);
		panel_8.add(label_33);
		label_33.setIcon(new ImageIcon(this.getClass().getResource("/Sans titre - 1.png")));
		btnNewButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				String textNum = numReservationField.getText();
				int numReservation = Integer.parseInt(textNum);
				panel_8.remove(lblId_1);
				panel_8.remove(lblNom_1);
				panel_8.remove(lblPrenom_1);
				panel_8.remove(lblClasse_1);
				panel_8.remove(lblCategorie_1);
				panel_8.remove(lblPrix_1);
				panel_8.remove(lblId);
				panel_8.remove(lblNom);
				panel_8.remove(lblPrenom);
				panel_8.remove(lblClasse);
				panel_8.remove(lblCategorie);
				panel_8.remove(lblPrix);
				panel_8.remove(lblId_3);
				panel_8.remove(lblNom_3);
				panel_8.remove(lblPrenom_3);
				panel_8.remove(lblClasse_3);
				panel_8.remove(lblCategorie_3);
				panel_8.remove(lblPrix_3);
				panel_8.remove(lblId_2);
				panel_8.remove(lblNom_2);
				panel_8.remove(lblPrenom_2);
				panel_8.remove(lblClasse_2);
				panel_8.remove(lblCat_2);
				panel_8.remove(lblPrix_2);
				panel_8.remove(lblId_5);
				panel_8.remove(lblNom_5);
				panel_8.remove(lblPrenom_5);
				panel_8.remove(lblClasse_5);
				panel_8.remove(lblCategorie_5);
				panel_8.remove(lblPrix_5);
				panel_8.remove(lblId_4);
				panel_8.remove(lblNom_4);
				panel_8.remove(lblPrenom_4);
				panel_8.remove(lblClasse_4);
				panel_8.remove(lblCategorie_4);
				panel_8.remove(lblPrix_4);
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
					mesReservationPanel.add(label_3);
					mesReservationPanel.add(label_31);
					mesReservationPanel.add(label_32);
					mesReservationPanel.add(label_33);
					mesReservationPanel.add(label_34);
					mesReservationPanel.add(panel_8);
					Formulaire.this.validate();
					Formulaire.this.repaint();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		
		// Panel for modify and delete 
		
		modifierSupprimerPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		modifierSupprimerPanel.setBounds(0, 62, 1121, 365);
		modifierSupprimerPanel.setLayout(null);
		
		JLabel labani = new JLabel("Num\u00E9ro Passager :");
		labani.setHorizontalAlignment(SwingConstants.CENTER);
		labani.setBounds(216, 29, 147, 32);
		labani.setFont(new Font("Tahoma", Font.BOLD, 14));
		modifierSupprimerPanel.add(labani);
		
		textya = new JTextField();
		textya.setBackground(SystemColor.white);
		textya.setColumns(10);
		textya.setBounds(357, 29, 303, 32);
		modifierSupprimerPanel.add(textya);
		
		JButton btnChercherr = new JButton("Chercher");
		btnChercherr.setBounds(701, 24, 178, 41);
		btnChercherr.setBackground(new Color(0, 0, 205));
		btnChercherr.setForeground(Color.white);
		btnChercherr.setFont(new Font("Tahoma", Font.BOLD, 14));
		reserverBilletPanel.add(btnChercherr);
		
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
		

		
		JPanel hamidapanel = new JPanel();
		hamidapanel.setBackground(new Color(240,240,240));
		hamidapanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		hamidapanel.setBounds(629, 161, 141, 83);
		fofopanel.add(hamidapanel);
		hamidapanel.setLayout(null);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl3.setForeground(Color.BLACK);
		lbl3.setIcon(new ImageIcon(this.getClass().getResource("/del.png")));
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
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(this.getClass().getResource("/edit.png")));
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

		btnChercherr.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					int id_reservation = Integer.parseInt(textya.getText());
					try {
						int o =0;
						PreparedStatement ps =conn.prepareStatement("select id_passager,id_vol from reservation where id_reservation = ?");
						ps.setInt(1,id_reservation);
						ResultSet rs = ps.executeQuery();
						if(rs.next()) {
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
						o = 1;
						}
						if(o==0) {
							JOptionPane.showMessageDialog(null, "Id_passager intouvable !! Saisissez un autre id");
							o=0;
						}
						validate();
						repaint();
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
					

					
				
				 
		});
		modifierSupprimerPanel.add(btnChercherr);
		
		// Panel for booking 
		
		reserverBilletPanel.setBounds(0, 56, 1121, 365);
		reserverBilletPanel.setLayout(null);
		
		
		
		JLabel numReserAffiche = new JLabel();
		
		numReserAffiche.setBounds(220, 30, 400, 50);
		numReserAffiche.setFont(new Font("Tahoma", Font.BOLD, 14));
		JButton btnSuivant = new JButton("Suivant");
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(701, 30, 178, 41);
		btnConfirmer.setBackground(new Color(0, 0, 205));
		btnConfirmer.setForeground(Color.white);
		btnConfirmer.setFont(new Font("Tahoma", Font.BOLD, 14));
		reserverBilletPanel.add(btnConfirmer);
		spinner.setBounds(357, 35, 303, 32);
		reserverBilletPanel.add(spinner);
		
		JLabel lblNombreDePlace = new JLabel("Nombre de place : ");
		lblNombreDePlace.setBounds(224, 35, 147, 32);
		reserverBilletPanel.add(lblNombreDePlace);
		lblNombreDePlace.setFont(new Font("Tahoma", Font.BOLD, 14));
			
				
				JPanel panilo = new JPanel();
				panilo.setBounds(41, 72, 1033, 274);
				panilo.setBorder(new LineBorder(Color.CYAN, 3));
				panilo.setLayout(null);
				panilo.add(numReserAffiche);
				
						
				JPanel reserverBilletPanel1 = new JPanel();
				reserverBilletPanel1.setBorder(new LineBorder(new Color(0, 0, 205), 2));
				reserverBilletPanel1.setBounds(0, 0, 1033, 274);
				panilo.add(reserverBilletPanel1);
				reserverBilletPanel1.setBackground(SystemColor.menu);
				reserverBilletPanel1.setLayout(null);
				
				JPanel panfu = new JPanel();
				panfu.setBounds(0, 0, 202, 47);
				reserverBilletPanel1.add(panfu);
				panfu.setBorder(new LineBorder(new Color(0, 0, 205), 2));
				panfu.setBackground(Color.WHITE);
				panfu.setLayout(null);
				
				JLabel lblPassager = new JLabel("Passager 1");
				lblPassager.setFont(new Font("Tekton Pro", Font.BOLD, 15));
				lblPassager.setBounds(65, 6, 112, 28);
				panfu.add(lblPassager);
				
				JLabel lblNewLabel1 = new JLabel("");
				lblNewLabel1.setIcon(new ImageIcon(this.getClass().getResource("/yt.png")));
				lblNewLabel1.setBounds(17, 3, 36, 36);
				panfu.add(lblNewLabel1);
				
				nomField = new JTextField();
				nomField.setBounds(99, 85, 252, 34);
				reserverBilletPanel1.add(nomField);
				nomField.setColumns(10);
				
				prenomField = new JTextField();
				prenomField.setBounds(99, 139, 252, 34);
				reserverBilletPanel1.add(prenomField);
				prenomField.setColumns(10);
				
				telField = new JTextField();
				telField.setBounds(425, 139, 252, 34);
				reserverBilletPanel1.add(telField);
				telField.setColumns(10);
				
				cinField = new JTextField();
				cinField.setBounds(100, 195, 251, 34);
				reserverBilletPanel1.add(cinField);
				cinField.setColumns(10);
				
				idvolField = new JTextField();
				idvolField.setBounds(425, 194, 252, 34);
				reserverBilletPanel1.add(idvolField);
				idvolField.setColumns(10);
				
				dateField = new JTextField("jj/mm/aaaa");
				dateField.setBounds(426, 85, 252, 33);
				reserverBilletPanel1.add(dateField);
				dateField.setForeground(Color.GRAY);
				dateField.setColumns(10);
				comboBoxClass.setBounds(761, 85, 252, 34);
				reserverBilletPanel1.add(comboBoxClass);
				
				JLabel lblCategorie1 = new JLabel("Categorie :");
				lblCategorie1.setBounds(683, 145, 80, 22);
				reserverBilletPanel1.add(lblCategorie1);
				lblCategorie1.setFont(new Font("Tahoma", Font.BOLD, 13));
				comboBoxCatego.setBounds(761, 140, 249, 33);
				reserverBilletPanel1.add(comboBoxCatego);
				sexeComboBoxe.setBounds(761, 195, 249, 34);
				reserverBilletPanel1.add(sexeComboBoxe);
				
				JLabel lblTel = new JLabel("Tel      :");
				lblTel.setBounds(363, 145, 75, 22);
				reserverBilletPanel1.add(lblTel);
				lblTel.setFont(new Font("Tahoma", Font.BOLD, 13));
				
				JLabel lblIdvol = new JLabel("IdVol   :");
				lblIdvol.setBounds(360, 201, 75, 22);
				reserverBilletPanel1.add(lblIdvol);
				lblIdvol.setFont(new Font("Tahoma", Font.BOLD, 13));
				
				JLabel lblDate = new JLabel("Date   :");
				lblDate.setBounds(363, 91, 65, 22);
				reserverBilletPanel1.add(lblDate);
				lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
				
				JLabel lblSexe = new JLabel("Sexe        :");
				lblSexe.setBounds(689, 201, 74, 22);
				reserverBilletPanel1.add(lblSexe);
				lblSexe.setFont(new Font("Tahoma", Font.BOLD, 13));
				
				JLabel lblNom1 = new JLabel("Nom       :");
				lblNom1.setBounds(24, 91, 75, 22);
				reserverBilletPanel1.add(lblNom1);
				lblNom1.setFont(new Font("Tahoma", Font.BOLD, 13));
				

				JLabel lblClasse1 = new JLabel("Classe      :");
				lblClasse1.setBounds(688, 91, 75, 22);
				reserverBilletPanel1.add(lblClasse1);
				lblClasse1.setFont(new Font("Tahoma", Font.BOLD, 13));
				
				JLabel lblPrenom1 = new JLabel("Pr\u00E9nom  :");
				lblPrenom1.setBounds(24, 145, 75, 22);
				reserverBilletPanel1.add(lblPrenom1);
				lblPrenom1.setFont(new Font("Tahoma", Font.BOLD, 13));
				
				JLabel lblCin = new JLabel("CIN         :");
				lblCin.setBounds(24, 201, 65, 22);
				reserverBilletPanel1.add(lblCin);
				lblCin.setFont(new Font("Tahoma", Font.BOLD, 13));
				sexeComboBoxe.addItem("Homme");
				sexeComboBoxe.addItem("Femme");
				dateField.addFocusListener(new FocusListener() {
					public void focusLost(FocusEvent arg0) {
						
					}
					public void focusGained(FocusEvent arg0) {
						dateField.setText("");
					}
					
				});
btnConfirmer.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		try {
			try {
			PreparedStatement ps5=conn.prepareStatement("select max(num_reservation) from reservation ");
			ResultSet rs = ps5.executeQuery();
			rs.next();
			num_reservation = rs.getInt(1)+1;	
			} catch (Exception e) {
				
			}		
			btnSuivant.setText("Suivant");	
			numReserAffiche.setText("Votre numero de reservation est : "+num_reservation);
			nb = (Integer) spinner.getValue();
			reserverBilletPanel1.add(btnSuivant);
			reserverBilletPanel.remove(btnConfirmer);
			reserverBilletPanel.add(panilo);
			if(nb==1) {
				btnSuivant.setText("Confirmer");			
			}
			Formulaire.this.validate();
			Formulaire.this.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});

for(int i = 0 ; i<CLASSE_NORMAL_OPTION.size();i++) {
	comboBoxClass.addItem(CLASSE_NORMAL_OPTION.get(i));
	}
for(int i = 0 ; i<CATEGORIE_NORMAL_OPTION.size();i++) {
	comboBoxCatego.addItem(CATEGORIE_NORMAL_OPTION.get(i));
	}


btnSuivant.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent arg0) {
		lblNewLabel1.setBounds(17, 3, 36, 36);
		System.out.println(clic);
		for(int i=0 ; i<nb;i++) {
			if(clic==i) {
				JOptionPane.showMessageDialog(null, "Operation effectue ...");
			}
		}
		if(clic==nb-1) {
			btnSuivant.setVisible(false);
		}
		if(clic==nb-2 ) {
			btnSuivant.setText("Confirmer");
			
		}
		clic ++ ;
	}
});

btnSuivant.setBounds(550, 11, 119, 32);

btnSuivant.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	try {
		String nomPassager = nomField.getText();
		String prenomPassager = prenomField.getText();
		String cinPassager = telField.getText();
		String telPassager = cinField.getText();
		String nomCategorie = (String) comboBoxCatego.getSelectedItem(); 
		String nomClasse = (String) comboBoxClass.getSelectedItem(); 
		String dateDepart = dateField.getText();
		boolean sexe =true ;
		if(sexeComboBoxe.getSelectedItem()=="Femme") {
			 sexe = true;
		}
		if(sexeComboBoxe.getSelectedItem()=="Homme") {
			 sexe = false;
		}
		String idVolText = idvolField.getText();
		int idVol = Integer.parseInt(idVolText);
		
		
		Reservation.reserverBillet(nomPassager, prenomPassager, telPassager, cinPassager, sexe, idVol, nomCategorie, nomClasse, dateDepart, num_reservation);

		if(clic<nb-1) {
			nbPassager ++ ;
		}
		lblPassager.setText("Passager "+nbPassager);
		nomField.setText("");
		prenomField.setText("");
		telField.setText("");
		cinField.setText("");
		idvolField.setText("");
		dateField.setText("");
		Formulaire.this.validate();
		Formulaire.this.repaint();
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	});
		
		
		
		// Panel for searching 
		
		chercherVolPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		chercherVolPanel.setBounds(0, 56, 1131, 371);
		panel_2.add(chercherVolPanel);
		chercherVolPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/f.png")));
		lblNewLabel_2.setBackground(Color.ORANGE);
		lblNewLabel_2.setBounds(30, 35, 46, 41);
		chercherVolPanel.add(lblNewLabel_2);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(this.getClass().getResource("/m.png")));
		label_6.setBounds(328, 35, 46, 41);
		chercherVolPanel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(this.getClass().getResource("/c.png")));
		label_7.setBounds(615, 35, 46, 41);
		chercherVolPanel.add(label_7);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBackground(SystemColor.menu);
		comboBox_1.setBounds(384, 36, 221, 38);
	    comboBox_1.setModel(new DefaultComboBoxModel<String>() {
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
	    comboBox_1.addItem(NOT_SELECTABLE_OPTION1);
	    for(int i =0 ; i<NORMAL_OPTION.size();i++) {
	    comboBox_1.addItem(NORMAL_OPTION.get(i));
	    }
		chercherVolPanel.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField = new JTextField("jj/mm/aaaa");
		textField.setForeground(Color.GRAY);
		textField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
				
			}
			public void focusGained(FocusEvent arg0) {
				textField.setText("");
			}
			
		});
		textField.setBounds(671, 37, 221, 36);
		chercherVolPanel.add(textField);
		textField.setColumns(10);
		
		JButton cherchBtn = new JButton("Chercher");
		cherchBtn.setBounds(919, 39, 177, 37);
		cherchBtn.setBackground(new Color(0, 0, 205));
		cherchBtn.setForeground(Color.white);
		cherchBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		chercherVolPanel.add(cherchBtn);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(SystemColor.menu);
		comboBox.setBounds(84, 36, 221, 38);
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
		    for(int i =0 ; i<NORMAL_OPTION.size();i++) {
		    comboBox.addItem(NORMAL_OPTION.get(i));
		    }
		chercherVolPanel.add(comboBox);
		
		
		JLabel photoVilleArr = new JLabel("");
		photoVilleArr.setBounds(824, 138, 262, 148);
		
		JLabel photoVilleDep = new JLabel("");
		photoVilleDep.setBounds(30, 138, 262, 148);
		
		
		JPanel detailPanel = new JPanel();
		detailPanel.setBounds(302, 87, 512, 116);
		detailPanel.setBackground(SystemColor.menu);
		
		detailPanel.setLayout(null);
		
		JLabel lblNumVol = new JLabel("Num\u00E9ro du Vol : ");
		lblNumVol.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumVol.setBounds(193, 11, 150, 22);
		detailPanel.add(lblNumVol);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setIcon(new ImageIcon(this.getClass().getResource("/226.png")));
		label_11.setBounds(11, 51, 26, 26);
		detailPanel.add(label_11);
		
		JLabel label_10 = new JLabel("New label");
		label_10.setIcon(new ImageIcon(this.getClass().getResource("/226.png")));
		label_10.setBounds(476, 51, 26, 26);
		detailPanel.add(label_10);
		
		JLabel lblArrive = new JLabel("Arrive:");
		lblArrive.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblArrive.setBounds(363, 56, 113, 14);
		detailPanel.add(lblArrive);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(224, 67, 1, 2);
		detailPanel.add(separator);
		
		JLabel lblPri = new JLabel("Appartir de  MAD ");
		lblPri.setForeground(Color.RED);
		lblPri.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPri.setBounds(183, 69, 189, 25);
		detailPanel.add(lblPri);
		
		JLabel lblDpart = new JLabel("Depart:");
		lblDpart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDpart.setBounds(47, 56, 113, 14);
		detailPanel.add(lblDpart);
		
		JLabel lblDure = new JLabel("Dur\u00E9e : ");
		lblDure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDure.setBounds(207, 44, 113, 14);
		detailPanel.add(lblDure);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBackground(Color.GREEN);
		lblNewLabel_5.setForeground(Color.GREEN);
		lblNewLabel_5.setIcon(new ImageIcon(this.getClass().getResource("/ddddd.png")));
		lblNewLabel_5.setBounds(158, 63, 195, 2);
		detailPanel.add(lblNewLabel_5);
		
		JPanel detailPanel1 = new JPanel();
		detailPanel1.setLayout(null);
		detailPanel1.setBackground(SystemColor.menu);
		detailPanel1.setBounds(302, 214, 512, 116);
		
		JLabel lblNumVol1 = new JLabel("Num\u00E9ro du Vol : ");
		lblNumVol1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumVol1.setBounds(193, 11, 150, 22);
		detailPanel1.add(lblNumVol1);
		
		JLabel label_13 = new JLabel("New label");
		label_13.setIcon(new ImageIcon(this.getClass().getResource("/226.png")));
		label_13.setBounds(11, 51, 26, 26);
		detailPanel1.add(label_13);
		
		JLabel label_15 = new JLabel("New label");
		label_15.setIcon(new ImageIcon(this.getClass().getResource("/226.png")));
		label_15.setBounds(476, 51, 26, 26);
		detailPanel1.add(label_15);
		
		JLabel lblArriv1 = new JLabel("Arriv\u00E9e :02:12:15");
		lblArriv1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblArriv1.setBounds(363, 56, 113, 14);
		detailPanel1.add(lblArriv1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(224, 67, 1, 2);
		detailPanel1.add(separator_1);
		
		JLabel lblPrix1 = new JLabel("Appartir de  MAD ");
		lblPrix1.setForeground(Color.RED);
		lblPrix1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrix1.setBounds(183, 69, 189, 25);
		detailPanel1.add(lblPrix1);
		
		JLabel lblDep1 = new JLabel("D\u00E9part  :02:12:15");
		lblDep1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDep1.setBounds(47, 56, 113, 14);
		detailPanel1.add(lblDep1);
		
		JLabel lblDur1 = new JLabel("Dur\u00E9e  :02:12:15");
		lblDur1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDur1.setBounds(207, 44, 113, 14);
		detailPanel1.add(lblDur1);
		
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(this.getClass().getResource("/ddddd.png")));
		label_20.setForeground(Color.BLACK);
		label_20.setBackground(Color.GREEN);
		label_20.setBounds(158, 63, 195, 2);
		detailPanel1.add(label_20);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(this.getClass().getResource("/mlkj.PNG")));
		lblNewLabel_3.setBounds(0, 45, 1344, 332);
		getContentPane().add(lblNewLabel_3);
		cherchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String villeDepart = (String) comboBox.getSelectedItem();
				String villeArivee = (String) comboBox_1.getSelectedItem();
				String dateDepart = textField.getText();
				Vol.afficherVols(villeDepart, villeArivee, dateDepart);
				int id_ville_depart = Ville.getIdVille(villeDepart);
				int id_ville_arrivee = Ville.getIdVille(villeArivee);
				int jour = Integer.parseInt( dateDepart.substring(0, 2));
				int mois = Integer.parseInt(dateDepart.substring(3, 5));
				int annee = Integer.parseInt( dateDepart.substring(6));
				String jour_vol = Reservation.getDay(jour, mois, annee);
				System.out.println(jour_vol);
				System.out.println(id_ville_depart);
				System.out.println(id_ville_arrivee);
				photoVilleArr.setIcon(new ImageIcon(this.getClass().getResource("/"+villeArivee+".jpg")));
				chercherVolPanel.add(photoVilleArr);
				photoVilleDep.setIcon(new ImageIcon(this.getClass().getResource("/"+villeDepart+".jpg")));
				chercherVolPanel.add(photoVilleDep);
				try {
					PreparedStatement ps=conn.prepareStatement("select id_vol,jour_vol,heure_depart,heure_arrivee from vol,trajet where vol.id_trajet=trajet.id_trajet and id_ville_depart = ? and id_ville_arrivee = ? and jour_vol = ?");
					ps.setInt(1,id_ville_depart);
					ps.setInt(2,id_ville_arrivee);
					ps.setString(3,jour_vol);
					ResultSet rs = ps.executeQuery(); 
					k=0;
					while(rs.next())
					{
						if(k==0) {
						lblNumVol.setText("Num\u00E9ro du Vol : "+rs.getInt(1));
						lblDpart.setText("Depart:"+rs.getTime("heure_depart"));
						lblArrive.setText("Arrive:"+rs.getTime("heure_arrivee"));
						lblDure.setText("Dur\u00E9e :"+Vol.calculerDuree(rs.getInt(1)));
						lblPri.setText("Appartir de "+Reservation.calculerPrix(2, 2, villeDepart, villeArivee)+" MAD ");
						chercherVolPanel.add(detailPanel);
						}
						if(k==1) {
						lblNumVol1.setText("Num\u00E9ro du Vol : "+rs.getInt(1));
						lblDep1.setText("Depart:"+rs.getTime("heure_depart"));
						lblArriv1.setText("Arrive:"+rs.getTime("heure_arrivee"));
						lblDur1.setText("Dur\u00E9e :"+Vol.calculerDuree(rs.getInt(1)));
						lblPrix1.setText("Appartir de "+Reservation.calculerPrix(2, 2, villeDepart, villeArivee)+" MAD ");
						chercherVolPanel.add(detailPanel1);
						}
						k++;
						Formulaire.this.validate();
						Formulaire.this.repaint();
					}
					if(k==0) {
						
						affich.setBounds(460, 180, 250, 60);
						affich.setFont(new Font("Tahoma", Font.BOLD, 18));
						affich.setForeground(Color.red);
						chercherVolPanel.add(affich);
						chercherVolPanel.remove(detailPanel1);
						chercherVolPanel.remove(detailPanel);
					}
					if(k!=0) {
						chercherVolPanel.remove(affich);
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}

				Formulaire.this.validate();
				Formulaire.this.repaint();
			}
		});
		
		chercherVolButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
		reserverBilletButtonPanel.setBackground(Color.WHITE);
		mesReservationButtonPanel.setBackground(Color.WHITE);
		modifierSupprimerButtonPanel.setBackground(Color.WHITE);
		
		
		chercherVolButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chercherVolButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				reserverBilletButtonPanel.setBackground(Color.WHITE);
				mesReservationButtonPanel.setBackground(Color.WHITE);
				modifierSupprimerButtonPanel.setBackground(Color.WHITE);
				reserverBilletPanel.setVisible(false);
				mesReservationPanel.setVisible(false);
				modifierSupprimerPanel.setVisible(false);
				panel_2.add(chercherVolPanel);
				chercherVolPanel.setVisible(true);
				chercherVolPanel.remove(photoVilleDep);
				chercherVolPanel.remove(photoVilleArr);
				chercherVolPanel.remove(affich);
				chercherVolPanel.remove(detailPanel1);
				chercherVolPanel.remove(detailPanel);
				Formulaire.this.validate();
				Formulaire.this.repaint();
			}
		});
		reserverBilletButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				reserverBilletButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				chercherVolButtonPanel.setBackground(Color.WHITE);
				mesReservationButtonPanel.setBackground(Color.WHITE);
				modifierSupprimerButtonPanel.setBackground(Color.WHITE);
				chercherVolPanel.setVisible(false);
				mesReservationPanel.setVisible(false);
				modifierSupprimerPanel.setVisible(false);
				panel_2.add(reserverBilletPanel);
				reserverBilletPanel.setVisible(true);
				spinner.setValue(0);
				reserverBilletPanel.remove(panilo);
				reserverBilletPanel.add(btnConfirmer);
				nbPassager = 1;
				clic=0;
				Formulaire.this.validate();
				Formulaire.this.repaint();	
			}
		});
		modifierSupprimerButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modifierSupprimerButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				chercherVolButtonPanel.setBackground(Color.WHITE);
				mesReservationButtonPanel.setBackground(Color.WHITE);
				reserverBilletButtonPanel.setBackground(Color.WHITE);
				reserverBilletPanel.setVisible(false);
				mesReservationPanel.setVisible(false);
				chercherVolPanel.setVisible(false);
				panel_2.add(modifierSupprimerPanel);
				modifierSupprimerPanel.setVisible(true);
				Formulaire.this.validate();
				Formulaire.this.repaint();
			}
		});
		mesReservationButtonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mesReservationButtonPanel.setBackground(SystemColor.inactiveCaptionBorder);
				chercherVolButtonPanel.setBackground(Color.WHITE);
				reserverBilletButtonPanel.setBackground(Color.WHITE);
				modifierSupprimerButtonPanel.setBackground(Color.WHITE);
				reserverBilletPanel.setVisible(false);
				chercherVolPanel.setVisible(false);
				modifierSupprimerPanel.setVisible(false);
				panel_2.add(mesReservationPanel);
				mesReservationPanel.setVisible(true);
				mesReservationPanel.remove(label_3);
				mesReservationPanel.remove(label_31);
				mesReservationPanel.remove(label_32);
				mesReservationPanel.remove(label_33);
				mesReservationPanel.remove(label_34);
				mesReservationPanel.remove(panel_8);
				numReservationField.setText("");
				Formulaire.this.validate();
				Formulaire.this.repaint();
			}
		});
		
		setVisible(true);
	}
	public static void main(String[] args) throws Exception {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Formulaire();
	}
}
