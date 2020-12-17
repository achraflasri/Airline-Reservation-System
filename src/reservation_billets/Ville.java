package reservation_billets;

import java.sql.*;
import java.util.Vector;

public class Ville {
	private int idVille;
	private String nomVille;
	private double altitude;
	private double longitude;
	private static Connection conn=Connexion.getConnection();
	public Ville(int idVille, String nomVille, double altitude, double longitude) {
		super();
		this.idVille = idVille;
		this.nomVille = nomVille;
		this.altitude = altitude;
		this.longitude = longitude;
	}
	public int getIdVille() {
		return idVille;
	}
	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public double getlongitude() {
		return longitude;
	}
	public void setLangitude(double longitude) {
		this.longitude = longitude;
	}
	
	public static int getIdVille(String nom_ville) {
		int id_ville=0;
		try {
			PreparedStatement ps =  conn.prepareStatement("select id_ville from ville where nom_ville = ? ");
			ps.setString(1, nom_ville);
			ResultSet rs = ps.executeQuery();
			rs.next();
			id_ville= rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id_ville;
	}
	
	public static void ajouterVille(String nom_ville,double altitude, double longitude){
		try {
			PreparedStatement ps =  conn.prepareStatement("insert into ville(nom_ville,altitude,longitude)"
					+ "values(?,?,?) ");
			ps.setString(1, nom_ville);
			ps.setDouble(2, altitude);
			ps.setDouble(3, longitude);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void supprimerVille(String nom_ville){
		
		try {//recupération de l'id ville
			int id_ville= Ville.getIdVille(nom_ville);

			//recupération de l'id trajet correspondant à la ville
			PreparedStatement ps1 =  conn.prepareStatement("select id_trajet from trajet where id_ville_depart = ? "
					+ "or id_ville_arrivee = ? ");
			ps1.setInt(1, id_ville);
			ps1.setInt(2, id_ville);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int id_trajet= rs1.getInt(1);
			System.out.println("id_trajet = "+id_trajet);
			
			
			
			//suppression du vol correspondant au trajet 
			PreparedStatement ps3 =  conn.prepareStatement("delete from vol where id_trajet = ? ");
			ps3.setInt(1, id_trajet);
			ps3.executeUpdate();
			
			//suppression du trajet correspondant
			PreparedStatement ps2 =  conn.prepareStatement("delete from trajet where id_ville_depart = ? or id_ville_arrivee = ?  ");
			ps2.setInt(1, id_ville);
			ps2.setInt(2, id_ville);
			ps2.executeUpdate();
			
			//suppression de la ville en qst
			PreparedStatement ps4 =  conn.prepareStatement("delete from ville where id_ville = ? ");
			ps4.setInt(1, id_ville);
			ps4.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static Vector<String> listeVilles(){
		 Vector<String> villes = new Vector<>();
		try {	
				PreparedStatement ps = conn.prepareStatement("select nom_ville from ville");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					villes.add(rs.getString(1));
			}
				
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return villes;
	}
	
	public static Vector<Vector<String>> listeVillesData()
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from ville");
			ResultSet rs = ps.executeQuery();

	         // get column names
	            int len = rs.getMetaData().getColumnCount();
	            Vector<String> cols= new Vector<String>(len);
	            for(int i=1; i<=len; i++) // Note starting at 1
	            cols.add(rs.getMetaData().getColumnName(i));

	            // Add Data
	           
	            while(rs.next())
	            {
	                Vector<String> row = new Vector<String>(len);
	                for(int i=1; i<=len; i++)
	                {
	                    row.add(rs.getString(i));
	                }
	                data.add(row);
	            }
	            
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	public static Vector<String> listeVillesColumnName()
	{
		Vector<String> cols= new Vector<String>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from ville");
			ResultSet rs = ps.executeQuery();

	         // get column names
	            int len = rs.getMetaData().getColumnCount();
	            for(int i=1; i<=len; i++) // Note starting at 1
	            cols.add(rs.getMetaData().getColumnName(i));

	            
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cols;
	}

	public static Vector<Vector<String>> listeVillesData(int id_ville)
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from ville where id_ville=?");
			ps.setInt(1, id_ville);
			ResultSet rs = ps.executeQuery();

	         // get column names
	            int len = rs.getMetaData().getColumnCount();
	            Vector<String> cols= new Vector<String>(len);
	            for(int i=1; i<=len; i++) // Note starting at 1
	            cols.add(rs.getMetaData().getColumnName(i));

	            // Add Data
	           
	            while(rs.next())
	            {
	                Vector<String> row = new Vector<String>(len);
	                for(int i=1; i<=len; i++)
	                {
	                    row.add(rs.getString(i));
	                }
	                data.add(row);
	            }
	            
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	

	

	
	

}
