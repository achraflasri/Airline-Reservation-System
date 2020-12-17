package reservation_billets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Vector;

public class Avion {
	private int idAvion;
	private double autonomie;
	private String matricule;

	private static Connection conn=Connexion.getConnection();
	public Avion(int idAvion, double autonomie, String matricule) {
		super();
		this.idAvion = idAvion;
		this.autonomie = autonomie;
		this.matricule = matricule;
	
	}
	public int getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}
	public double getAutonomie() {
		return autonomie;
	}
	public void setAutonomie(double autonomie) {
		this.autonomie = autonomie;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public static void ajouterAvion(double autonomie, String matricule,int idTrajet,String jour_vol,Time heureDepart
			,Time heureArrive,int p_d_affaire,int p_d_economique){
		try {
			PreparedStatement ps =  conn.prepareStatement("insert into avion(autonomie,matricule,disponible)"
					+ "values(?,?,?) ");
			ps.setDouble(1, autonomie);
			ps.setString(2, matricule);
			ps.setBoolean(3, true);
			ps.executeUpdate();
			PreparedStatement ps1 =  conn.prepareStatement("select id_avion from avion where matricule = ?");
			ps1.setString(1, matricule);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int id_avion = rs1.getInt(1);
			Capacite.ajouterCapacite(1, id_avion, p_d_affaire);
			Capacite.ajouterCapacite(2, id_avion, p_d_economique);
			
			Vol.ajouterVol(idTrajet,jour_vol,heureDepart,heureArrive,id_avion,p_d_affaire,p_d_economique);
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void SupprimerAvion(int id_avion){
		try {
			PreparedStatement ps = conn.prepareStatement("update avion set disponible = ? where id_avion = ?");
			ps.setBoolean(1, false);
			ps.setInt(2, id_avion);
			ps.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement("update vol set id_avion = null where id_avion = ?");
			//ps2.setInt(1, );
			ps2.setInt(1, id_avion);
			ps2.executeUpdate();
			
			PreparedStatement ps1 = conn.prepareStatement("delete from capacite where id_avion = ? ");
			ps1.setInt(1, id_avion);
			ps1.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static Vector<Integer> listeAvions()
	{
		Vector<Integer> list=new Vector<Integer>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select id_avion from avion ");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				list.add(rs.getInt(1));
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return list;
	}
	
	public static Vector<Vector<String>> listeAvionsData()
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from avion where disponible = 1");
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
	
	public static Vector<String> listeAvionsColumnName()
	{
		Vector<String> cols= new Vector<String>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from avion where disponible = 1");
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
	public static Vector<Vector<String>> listeAvionsData(int id_avion)
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from avion where id_avion=?");
			ps.setInt(1, id_avion);
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
