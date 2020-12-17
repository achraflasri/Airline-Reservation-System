package reservation_billets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Categorie {
	private int idCategorie;
	private String nomCategorie;
	private double reduction;
	private static Connection conn=Connexion.getConnection();
	public Categorie(int idCategorie, String nomCategorie, double reduction) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.reduction = reduction;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public double getReduction() {
		return reduction;
	}
	public void setReduction(double reduction) {
		this.reduction = reduction;
	}
	public static int getIdCategorie(String nom_categorie){
		int id_categorie = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select id_categorie from categorie where nom_categorie = ? ");
			ps.setString(1, nom_categorie);
			ResultSet rs = ps.executeQuery();
			rs.next();
			id_categorie= rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return id_categorie;
	}
	
	public static void ajouterCategorie(String nom_categorie,double reduction)
	{
		
		try {
				PreparedStatement ps2=conn.prepareStatement("insert into categorie(nom_categorie,reduction,disponible) values(?,?,?)");
				ps2.setString(1,nom_categorie);
				ps2.setDouble(2,reduction);
				ps2.setBoolean(3,true);
				ps2.executeUpdate();
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void supprimerCategorie(String nom_categorie)
	{
		try {
			
			PreparedStatement ps = conn.prepareStatement("update categorie set disponible = ? where nom_categorie = ?");
			ps.setBoolean(1, false);
			ps.setString(2, nom_categorie);
			ps.executeUpdate();
			
			PreparedStatement ps1 = conn.prepareStatement("delete from categorie where nom_categorie = ? ");
			ps1.setString(1, nom_categorie);
			ps1.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	public static void modifierCategorie(String nom_categorie, double reduction){
		try{
			int id_categorie= Categorie.getIdCategorie(nom_categorie);
			
			PreparedStatement ps1 = conn.prepareStatement("update categorie set reduction = ? where id_categorie=?");
			ps1.setDouble(1, reduction);
			ps1.setInt(2, id_categorie);
			ps1.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
		
		public static Vector<String> listeCategorie() {
			Vector<String> vc = new Vector<String>(); 
			try {
				// Get all categories disponible 
				PreparedStatement ps = conn.prepareStatement("select nom_categorie from categorie where disponible=? ");
				ps.setBoolean(1,true);
				ResultSet rs = ps.executeQuery();		
		        
		        //  Get row data
	            while (rs.next())
	            {
	             vc.add(rs.getString(1)) ; 
	            }
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return vc ;
		}
		
		public static Vector<Vector<String>> listeCategoriesData()
		{
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			try {
				 //  Read data from a table
				PreparedStatement ps = conn.prepareStatement("select * from categorie");
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
		
		public static Vector<String> listeCategoriesColumnName()
		{
			Vector<String> cols= new Vector<String>();
			try {
				 //  Read data from a table
				PreparedStatement ps = conn.prepareStatement("select * from categorie");
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

		public static Vector<Vector<String>> listeCategoriesData(int id_avion)
		{
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			try {
				 //  Read data from a table
				PreparedStatement ps = conn.prepareStatement("select * from categorie where id_categorie=?");
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



