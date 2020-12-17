package reservation_billets;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Vector;

public class Vol {
	private int idVol;
	private int idTrajet;
	private String jourVol;
	private Time heureDepart;
	private  Time heureArrivee;
	private int idAvion;
	public  static int P_D_economie;
	public static int P_D_affaire;
	private static Connection conn=Connexion.getConnection();
	public Vol(int idVol, int idTrajet, String jourVol, Time heureDepart, Time heureArrivee, int idAvion) {
		super();
		this.idVol = idVol;
		this.idTrajet = idTrajet;
		this.jourVol = jourVol;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.idAvion = idAvion;
	}
	public int getIdVol() {
		return idVol;
	}
	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}
	public int getIdTrajet() {
		return idTrajet;
	}
	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}
	public String getDateDepart() {
		return jourVol;
	}
	public void setJourVol(String jourVol) {
		this.jourVol = jourVol;
	}
	public Time getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Time getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public int getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}
	public static void ajouterVol(int idTrajet,String jour_vol,Time heureDepart,Time heureArrive,int idAvion,int p_d_affaire,int p_d_economique)
	{
		try
		{
			PreparedStatement ps =  conn.prepareStatement("insert into vol(id_trajet,jour_vol,heure_depart"
					+ ",heure_arrivee,id_avion,P_D_affaire,P_D_economique,disponible)"
					+ "values(?,?,?,?,?,?,?,?) ");
			ps.setInt(1, idTrajet);
			ps.setString(2, jour_vol);
			ps.setTime(3, heureDepart);
			ps.setTime(4, heureArrive);
			ps.setInt(5, idAvion);
			ps.setInt(6, p_d_affaire);
			ps.setInt(7, p_d_economique);
			ps.setBoolean(8, true);
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	
	public static void ajouterVolSeul(int idTrajet,String jour_vol,Time heureDepart,Time heureArrive,int id_avion)
	{
		try
		{	PreparedStatement ps1 = conn.prepareStatement("select capacite from capacite where id_avion = ? and id_classe = ?");
			ps1.setInt(1,id_avion);
			ps1.setInt(2,Classe.getIdClasse("affaire"));
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int p_d_affaire = rs1.getInt(1);
			System.out.println("p affaire = "+p_d_affaire);
			
			
			PreparedStatement ps2 = conn.prepareStatement("select capacite from capacite where id_avion = ? and id_classe = ?");
			ps2.setInt(1,id_avion);
			ps2.setInt(2,Classe.getIdClasse("economique"));
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			int p_d_economique = rs2.getInt(1);
			System.out.println("p economique = "+p_d_economique);
			
			PreparedStatement ps =  conn.prepareStatement("insert into vol(id_trajet,jour_vol,heure_depart"
					+ ",heure_arrivee,id_avion,P_D_affaire,P_D_economique,disponible)"
					+ "values(?,?,?,?,?,?,?,?) ");
			ps.setInt(1, idTrajet);
			ps.setString(2, jour_vol);
			ps.setTime(3, heureDepart);
			ps.setTime(4, heureArrive);
			ps.setInt(5, id_avion);
			ps.setInt(6, p_d_affaire);
			ps.setInt(7, p_d_economique);
			ps.setBoolean(8, true);
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	public static void supprimerVol(int id_vol){
		try {
			
			PreparedStatement ps = conn.prepareStatement("update vol set disponible = ? where id_vol = ?");
			ps.setBoolean(1, false);
			ps.setInt(2, id_vol);
			ps.executeUpdate();
			
			PreparedStatement ps1 = conn.prepareStatement("delete from vol where id_vol = ? ");
			ps1.setInt(1, id_vol);
			ps1.executeUpdate();
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void modifierVol(int id_vol,String jour_vol,Time heure_depart,Time heure_arrivee,int id_avion)
	{
		try {
			PreparedStatement ps=  conn.prepareStatement("update vol set jour_vol=?,heure_depart=?,heure_arrivee=?,id_avion=? where id_vol=?");
			
			ps.setString(1,jour_vol);
			ps.setTime(2,heure_depart);
			ps.setTime(3,heure_arrivee);
			ps.setInt(4,id_avion);
			ps.setInt(5,id_vol);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void afficherVols()
	{
		try {
			
			PreparedStatement ps=conn.prepareStatement("select id_vol,trajet.id_trajet,jour_vol,heure_depart,"
					+ "heure_arrivee,id_ville_depart,id_ville_arrivee from vol,trajet where vol.id_trajet=trajet.id_trajet ");
			ResultSet rs=ps.executeQuery();
			System.out.println(" id_vol  |  trajet     | jour_depart |  heure_depart | heure_arrive  ");
			while(rs.next())
			{
				int id_depart=rs.getInt(6);
				
				int id_arrivee=rs.getInt(7);
				
				
				PreparedStatement ps1=conn.prepareStatement("select nom_ville from ville where id_ville=? ");
				ps1.setInt(1,id_depart);
				ResultSet rs1=ps1.executeQuery();
				rs1.next();
				String ville_depart=rs1.getString("nom_ville");
				
				
				
				PreparedStatement ps2=conn.prepareStatement("select nom_ville from ville where id_ville=? ");
				ps2.setInt(1,id_arrivee);
				ResultSet rs2=ps2.executeQuery();
				rs2.next();
				String ville_arrivee=rs2.getString(1);
				
				
				
				//test affichage
				
				System.out.println("    "+rs.getInt(1)+"\t  "+ville_depart+"-"+ville_arrivee+"  "+rs.getString(3)+
						"      "+rs.getTime(4)+"       "+rs.getTime(5)+"  ");
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void afficherVols(String ville_depart,String ville_arrivee,String date_depart)
	{
		try {
	
			int id_ville_depart = Ville.getIdVille(ville_depart);
			int id_ville_arrivee = Ville.getIdVille(ville_arrivee);
			int jour = Integer.parseInt( date_depart.substring(0, 2));
			int mois = Integer.parseInt(date_depart.substring(3, 5));
			int annee = Integer.parseInt( date_depart.substring(6));
			String jour_vol = Reservation.getDay(jour, mois, annee);
			System.out.println(jour_vol);
			System.out.println(id_ville_depart);
			System.out.println(id_ville_arrivee);
			
			PreparedStatement ps=conn.prepareStatement("select id_vol,jour_vol,heure_depart,heure_arrivee from vol,trajet where vol.id_trajet=trajet.id_trajet and id_ville_depart = ? and id_ville_arrivee = ? and jour_vol = ?");
			ps.setInt(1,id_ville_depart);
			ps.setInt(2,id_ville_arrivee);
			ps.setString(3,jour_vol);
			ResultSet rs = ps.executeQuery(); 
			
			
			System.out.println(" id_vol  |  trajet     | jour_vol |  heure_depart | heure_arrive  ");
			while(rs.next())
			{
				//test affichage
				
				System.out.println("    "+rs.getInt("id_vol")+"\t  "+ville_depart+"-"+ville_arrivee+"  "+
				rs.getString("jour_vol")+"      "+rs.getTime("heure_depart")+"       "+rs.getTime("heure_arrivee")+"  ");
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static Time calculerDuree(int id_vol)
	{
		Time duree= new Time(00);
		try {
			
			PreparedStatement ps = conn.prepareStatement("select heure_depart, heure_arrivee from vol where id_vol = ?");
			ps.setInt(1,id_vol);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Time heure_depart = rs.getTime(1);
			Time heure_arrivee = rs.getTime(2);
			
			String heured= heure_depart.toString();
			String heurea= heure_arrivee.toString();
			SimpleDateFormat formatter = new SimpleDateFormat("h:mm:ss");
			Date d1 = formatter.parse(heured);
			Date d2 = formatter.parse(heurea);
			long timeDiff = d2.getTime() - d1.getTime();
			int h = (int)timeDiff/3600000; 
			int m = (int)(timeDiff%3600000)/60000;
			int s = (int)(timeDiff%3600000)%60000;
	
			duree = new Time(h,m,s);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return duree;
	}
	
	public static void initialiserNbrPlaces(int id_vol){
		try {
			PreparedStatement ps= conn.prepareStatement("select capacite,id_classe from vol,avion,capacite where "
					+ "vol.id_avion = avion.id_avion and avion.id_avion = capacite.id_avion and id_vol = ? ");
			ps.setInt(1, id_vol);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(2) == 1){
					PreparedStatement ps4=conn.prepareStatement("update vol set P_D_affaire = ? where id_vol=?");
					ps4.setInt(1,rs.getInt(1));
					ps4.setInt(2,id_vol);
					ps4.executeUpdate();
				}
				else if(rs.getInt(2) ==2){
					PreparedStatement ps4=conn.prepareStatement("update vol set P_D_economique = ? where id_vol=?");
					ps4.setInt(1,rs.getInt(1));
					ps4.setInt(2,id_vol);
					ps4.executeUpdate();
				}
					
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static boolean comparerTemps(int id_vol){
		boolean res = true;
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm:ss");
		try {PreparedStatement ps = conn.prepareStatement("select heure_depart from vol where id_vol = ?");
			ps.setInt(1,id_vol);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Time t = rs.getTime(1);
			Date d =  parser.parse(t.toString());
			Date now = parser.parse(LocalTime.now().toString());
			res = now.after(d);


			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public static Vector<Integer> listeIdVols(){
		Vector<Integer> id = new Vector<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select id_vol from vol where disponible = ? ");
			ps.setBoolean(1,true);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				id.add(rs.getInt(1));
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
	
	public static Vector<Vector<String>> listeVolsData()
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from vol");
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
	
	public static Vector<String> listeVolsColumnName()
	{
		Vector<String> cols= new Vector<String>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from vol");
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

	public static Vector<Vector<String>> listeVolsData(int id_vol)
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			 //  Read data from a table
			PreparedStatement ps = conn.prepareStatement("select * from vol where id_vol=?");
			ps.setInt(1, id_vol);
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
