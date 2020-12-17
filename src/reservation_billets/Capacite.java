package reservation_billets;


import java.sql.*;


public class Capacite {
	private int idAvion;
	private int idClase;
	private int capacite;
	private static Connection conn=Connexion.getConnection();
	public Capacite(int idAvion, int idClase, int capacite) {
		super();
		this.idAvion = idAvion;
		this.idClase = idClase;
		this.capacite = capacite;
	}
	public int getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}
	public int getIdClase() {
		return idClase;
	}
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public static void ajouterCapacite(int id_classe,int id_avion,int capacite){
		try {
			PreparedStatement ps =  conn.prepareStatement("insert into capacite values(?,?,?)");
			ps.setInt(1, id_classe);
			ps.setInt(2, id_avion);
			ps.setInt(3, capacite);
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//---------------------------------------------------------------------
	
	public static void modifierCapacite(int id_avion,String nom_classe, int nouvelle_capacite){
		try {
			int id_classe= Classe.getIdClasse(nom_classe);
			PreparedStatement ps1 = conn.prepareStatement("update capacite set capacite = ? where id_avion = ? and id_classe = ?");
			ps1.setInt(1, nouvelle_capacite);
			ps1.setInt(2, id_avion);
			ps1.setInt(3, id_classe);
			ps1.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	// hadi zedtha bacche nkhdem biha f supp classe jdida likatmseh wahed classe mn avion machi ga3 les avions
	public static void supprimerCapacite(int id_classe,int id_avion)
	{
		try {
			PreparedStatement ps=conn.prepareStatement("delete from  capacite where id_avion=? and id_classe=?");
			ps.setInt(1,id_avion);
			ps.setInt(2,id_classe);
			ps.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
