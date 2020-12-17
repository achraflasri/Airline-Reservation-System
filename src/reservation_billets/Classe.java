package reservation_billets;
import java.util.Vector;
//fiha inna f import
import java.sql.*;


public class Classe {
	private int idClasse;
	private String nomClasse;
	private double prixParKm;
	private static Connection conn=(Connection) Connexion.getConnection();
	public Classe(int idClasse, String nomClasse, double prixParKm) {
		super();
		this.idClasse = idClasse;
		this.nomClasse = nomClasse;
		this.prixParKm = prixParKm;
	}
	public  int getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	public String getNomClasse() {
		return nomClasse;
	}
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	public double getPrixParKm() {
		return prixParKm;
	}
	public void setPrixParKm(double prixParKm) {
		this.prixParKm = prixParKm;
	}
	
	public static int getIdClasse(String nom_classe)
	{
		int id_classe=-1;
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("select id_classe from classe where nom_classe = ? ");
			ps.setString(1, nom_classe);
			ResultSet rs = ps.executeQuery();
			rs.next();
			id_classe= rs.getInt(1);
			
		} catch (Exception e) {
			
		}
		return id_classe;
	}
	
	public static void ajouterClasse(String nom_classe,double prix_par_km) {
		try {
			PreparedStatement ps=conn.prepareStatement("insert into classe(nom_classe,prix_par_km) values(?,?)");
			ps.setString(1,nom_classe);
			ps.setDouble(2,prix_par_km);
			ps.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void supprimerClasse(String nom_classe)
	{
		try {
			int id_classe=Classe.getIdClasse(nom_classe);
			
			PreparedStatement ps2=conn.prepareStatement(" delete from capacite where id_classe=?");
			ps2.setInt(1,id_classe);
			ps2.executeUpdate();
			
			
			PreparedStatement ps3=conn.prepareStatement(" delete from classe where id_classe=?");
			ps3.setInt(1,id_classe);
			ps3.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// hadi katmseh classe mn avion mohadada machi ga3 les avions
	public static void supprimerClasseAvion(String nom_classe,int id_avion)
	{
		try {
			
			int id_classe=Classe.getIdClasse(nom_classe);
			
			Capacite.supprimerCapacite(id_classe, id_avion);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void modifierClassee(String nom_classe, double prix){
		try{
			int id_classe=Classe.getIdClasse(nom_classe);
				
				PreparedStatement ps1 = conn.prepareStatement("update classe set prix_par_km = ? where id_classe=?");
				ps1.setDouble(1, prix);
				ps1.setInt(2, id_classe);
				ps1.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
	}
	public static Vector<String> listeClasses()
	{
		Vector<String> list=new Vector<String>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select nom_classe from classe ");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				list.add(rs.getString(1));
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return list;
	}

	public static Vector<Vector<String>> listeClassesData()
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from classe");
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
	
	public static Vector<String> listeClassesColumnName()
	{
		Vector<String> cols= new Vector<String>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from classe");
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

	public static Vector<Vector<String>> listeClassesData(int id_classe)
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from classe where id_classe=?");
			ps.setInt(1, id_classe);
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
