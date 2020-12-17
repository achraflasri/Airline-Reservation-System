package reservation_billets;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Trajet {
	private int idTrajet;
	private int idVilleDepart;
	private int idVilleArrivee;
	private static Connection conn=Connexion.getConnection();
	public Trajet(int idTrajet, int idVilleDepart, int idVilleArrivee) {
		super();
		this.idTrajet = idTrajet;
		this.idVilleDepart = idVilleDepart;
		this.idVilleArrivee = idVilleArrivee;
	}
	public int getIdTrajet() {
		return idTrajet;
	}
	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}
	public int getIdVilleDepart() {
		return idVilleDepart;
	}
	public void setIdVilleDepart(int idVilleDepart) {
		this.idVilleDepart = idVilleDepart;
	}
	public int getIdVilleArrivee() {
		return idVilleArrivee;
	}
	public void setIdVilleArrivee(int idVilleArrivee) {
		this.idVilleArrivee = idVilleArrivee;
	}
	
	public static double  calculerDistanceKM(double alt1,double alt2,double lan1,double lan2)
	{
		double R=6367.445;
		double dist=R*Math.acos( ( Math.sin(Math.toRadians(alt1)) *Math.sin(Math.toRadians(alt2)) )+
				( Math.cos(Math.toRadians(alt1))*Math.cos(Math.toRadians(alt2))*
						Math.cos(Math.toRadians(lan1-lan2)) ) );
		//System.out.println("la distance ="+dist);
		return dist;
		
	}
	
	
	
	public static void ajouterTrajet(String ville_dep , String ville_arr) {
	
		try {
			// Collect id ville depart
			
			int id_ville_dep = Ville.getIdVille(ville_dep);
			
			// Collect id ville arrivee

			int id_ville_arr = Ville.getIdVille(ville_arr);
			
			// Insert into trajet
			java.sql.PreparedStatement ps3 = conn.prepareStatement("insert into trajet(id_ville_depart,id_ville_arrivee,disponible)"
					+ "values(?,?,?)");
			ps3.setInt(1, id_ville_dep);
			ps3.setInt(2, id_ville_arr);
			ps3.setBoolean(3,true);
			ps3.executeUpdate();
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	public static void supprimerTrajet(int id_trajet) {
		
		try {
			// Change the disponibility
			java.sql.PreparedStatement ps = conn.prepareStatement("update trajet set disponible=? where id_trajet=?");
			ps.setBoolean(1, false);
			ps.setInt(2, id_trajet);
			ps.executeUpdate();
			
			PreparedStatement ps1 = conn.prepareStatement("delete from trajet where id_trajet = ? ");
			ps1.setInt(1, id_trajet);
			ps1.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	public static Vector<Integer> listeTrajet() {
		Vector<Integer> vc = new Vector<Integer>(); 
		try {
			// Get all categories disponible 
			PreparedStatement ps = conn.prepareStatement("select id_trajet from trajet where disponible=? ");
			ps.setBoolean(1,true);
			ResultSet rs = ps.executeQuery();		
	        
	        //  Get row data
            while (rs.next())
            {
             vc.add(rs.getInt(1)) ; 
            }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return vc ;
	}
	public static Vector<Vector<String>> listeTrajetData()
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from trajet");
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
	
	public static Vector<String> listeTrajetColumnName()
	{
		Vector<String> cols= new Vector<String>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from trajet");
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

	public static Vector<Vector<String>> listeTrajetData(int id_trajet)
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from trajet where id_trajet=?");
			ps.setInt(1, id_trajet);
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
