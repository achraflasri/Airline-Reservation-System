package reservation_billets;
import java.sql.*;
public class Passager extends Personne {
	private int idPassager;
	private String cin;
	private static Connection conn=Connexion.getConnection();
	public Passager(String nomPersonne, String prenomPersonne, String tel, int idPassager,String cin) {
		super(nomPersonne, prenomPersonne, tel);
		this.idPassager=idPassager;
		this.cin=cin;
		
	}
	public int getIdPassager() {
		return idPassager;
	}
	public void setIdPassager(int idPassager) {
		this.idPassager = idPassager;
	}
	
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	

	
	public static void modifierDonneesPersonnelles(int id_passager,String nom_passager,
			String prenom_passager,String tel_passager, String cin)
	{
		try {
			PreparedStatement ps=conn.prepareStatement("update passager set nom_passager = ?, prenom_passager = ?,"
					+ "tel_passager = ?, cin = ? where id_passager = ?");
			ps.setString(1, nom_passager);
			ps.setString(2, prenom_passager);
			ps.setString(3, tel_passager);
			ps.setString(4, cin);
			ps.setInt(5,id_passager);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	

}
