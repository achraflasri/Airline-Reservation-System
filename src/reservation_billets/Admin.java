package reservation_billets;
import java.sql.*;
import java.util.Vector;

public class Admin extends Personne{
	private String login;
	private String password;
	private static Connection conn=Connexion.getConnection();
	public Admin(String nomPersonne, String prenomPersonne, String tel, String login, String password) {
		super(nomPersonne, prenomPersonne, tel);
		this.login = login;
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public static void statistiquesParMois()
	{
		try {
			PreparedStatement ps = conn.prepareStatement("select substring(date_reservation,4,2) as mois, count(id_reservation) as nbr_reservation, sum(prix_reservation) as Chiffre_affaire from reservation group by mois");
			ResultSet rs = ps.executeQuery();
			System.out.println("Mois \t Nombre de reservations \t CA \t ");
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getInt(2)+"\t" + rs.getDouble(3));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static Vector<Double> statistiquesParClient(){
		Vector<Double> pourcentages = new Vector<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select id_passager,sum(prix_reservation) as Chiffre_affaire, count(id_reservation) as Nombre_reservation  from reservation group by id_passager");
			ResultSet rs = ps.executeQuery();
			/*System.out.println("Numero de passager \t Chiffre_affaire \t Nombre de reservations \t ");
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t\t\t\t"+rs.getDouble(2)+"\t\t\t\t"+rs.getInt(3));
			}*/
			PreparedStatement ps1 = conn.prepareStatement("select count(id_passager) as nbr_hommes from passager where sexe = 0");
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int nbr_hommes = rs1.getInt(1);

			
			PreparedStatement ps2 = conn.prepareStatement("select count(id_passager) as nbr_femmes from passager where sexe = 1");
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			int nbr_femmes = rs2.getInt(1);

			PreparedStatement ps3 = conn.prepareStatement("select count(id_passager) as nbr_passagers_total from passager ");
			ResultSet rs3 = ps3.executeQuery();
			rs3.next();
			int nbr_total = rs3.getInt(1);
			
			double pourcentage_homme = (nbr_hommes*1.0/nbr_total)*100;
			double pourcentage_femme = (nbr_femmes*1.0/nbr_total)*100;

			int id_cat1 =Categorie.getIdCategorie("senior");
			int id_cat2 =Categorie.getIdCategorie("junior");

			PreparedStatement ps4 = conn.prepareStatement("select count(id_passager) as nbr_passagers_senior from reservation where id_categorie = ? ");
			ps4.setInt(1,id_cat1);
			ResultSet rs4 = ps4.executeQuery();
			rs4.next();
			int nbr_passager_senior = rs4.getInt(1);
			
			
			PreparedStatement ps5 = conn.prepareStatement("select count(id_passager) as nbr_passagers_junior from reservation where id_categorie = ? ");
			ps5.setInt(1,id_cat2);
			ResultSet rs5 = ps5.executeQuery();
			rs5.next();
			int nbr_passager_junior = rs5.getInt(1);
		
			
			double pourcentage_senior = (nbr_passager_senior*1.0/nbr_total)*100;
			double pourcentage_junior = (nbr_passager_junior*1.0/nbr_total)*100;
			pourcentages.add(pourcentage_homme);
			pourcentages.add(pourcentage_femme);
			pourcentages.add(pourcentage_senior);
			pourcentages.add(pourcentage_junior);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pourcentages;
	}
	
	public static Vector<Vector<String>> statistiquesParClientData()
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select passager.id_passager,nom_passager,prenom_passager, "
					+ "count(id_reservation) as Nombre_reservation,sum(prix_reservation) as Chiffre_affaire "
					+ " from passager,reservation where passager.id_passager=reservation.id_passager group by reservation.id_passager");
			ResultSet rs = ps.executeQuery();

	         // get column names
	            int len = rs.getMetaData().getColumnCount();
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
	
	public static Vector<String> statistiquesParClientColumnName()
	{
		Vector<String> cols= new Vector<String>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select passager.id_passager,nom_passager,prenom_passager, "
					+ "count(id_reservation) as Nombre_reservation,sum(prix_reservation) as Chiffre_affaire "
					+ " from passager,reservation where passager.id_passager=reservation.id_passager group by reservation.id_passager");
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
	

}
