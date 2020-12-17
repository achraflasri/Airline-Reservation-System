package reservation_billets;

import java.sql.*;
import java.util.Calendar;
import java.util.Locale;




public class Reservation {
	private int idReservation;
	private int idVol;
	private int idPassager;
	private int idCategorie;
	private static Connection conn=Connexion.getConnection();
	Reservation(int idReservation, int idVol, int idPassager, int idCategorie, int p_D_economie,int p_D_affaire)
	{
		this.idReservation = idReservation;
		this.idVol = idVol;
		this.idPassager = idPassager;
		this.idCategorie = idCategorie;
	/*	P_D_economie = p_D_economie;
		P_D_affaire = p_D_affaire;*/
	}
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public int getIdVol() {
		return idVol;
	}
	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}
	public int getIdPassager() {
		return idPassager;
	}
	public void setIdPassager(int idPassager) {
		this.idPassager = idPassager;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	public static void reserverBillet(String nom_passager,String prenom_passager,String tel,String cin,boolean sexe,int id_vol,
			String nom_categorie,String nom_classe,String date_reservation,int num_reservation)
	{
		try { //hadshi blassto mashi hna khass ykon associé l button li katreserver
			/*PreparedStatement ps5=conn.prepareStatement("select num_reservation from reservation where num_reservation = max(num_reservation)");
			 ResultSet rs = ps5.executeQuery();
			 rs.next();
			 int num_reservation = rs.getInt(1)+1;*/
			
	
			PreparedStatement ps1=conn.prepareStatement("insert into passager(nom_passager,prenom_passager,"
					+ "tel_passager,cin,sexe) values(?,?,?,?,?)");
			ps1.setString(1,nom_passager);
			 ps1.setString(2,prenom_passager);
			 ps1.setString(3,tel);
			 ps1.setString(4,cin);
			 ps1.setBoolean(5,sexe);
			 ps1.executeUpdate();
			 
			 int id_passager;
			 PreparedStatement ps2=conn.prepareStatement("select id_passager from passager where cin = ?");
			 ps2.setString(1,cin);
			 ResultSet rs2 = ps2.executeQuery();
			 rs2.next();
			 id_passager = rs2.getInt(1);
			 
			 PreparedStatement ps5=conn.prepareStatement("select id_trajet from vol  where id_vol = ?");
			 ps5.setInt(1,id_vol);
			 ResultSet rs5 = ps5.executeQuery();
			 rs5.next();
			 int id_trajet = rs5.getInt(1);
			 System.out.println("id_trajet = "+id_trajet);
			 
			 PreparedStatement ps6=conn.prepareStatement("select id_ville_depart,id_ville_arrivee from trajet  where id_trajet = ?");
			 ps6.setInt(1,id_trajet);
			 ResultSet rs6 = ps6.executeQuery();
			 rs6.next();
			 int id_ville_depart = rs6.getInt(1);
			 System.out.println("id_ville_depart = "+id_ville_depart);
			 int id_ville_arrivee = rs6.getInt(2);
			 System.out.println("id_ville_arrivee = "+id_ville_arrivee);
			 
			 PreparedStatement ps7=conn.prepareStatement("select nom_ville from ville  where id_ville = ?");
			 ps7.setInt(1,id_ville_depart);
			 ResultSet rs7 = ps7.executeQuery();
			 rs7.next();
			 String nom_ville_depart = rs7.getString(1);
			 System.out.println("nom_ville_depart = "+ nom_ville_depart);
			 
			 PreparedStatement ps8=conn.prepareStatement("select nom_ville from ville  where id_ville = ?");
			 ps8.setInt(1,id_ville_arrivee);
			 ResultSet rs8 = ps8.executeQuery();
			 rs8.next();
			 String nom_ville_arrivee = rs8.getString(1);
			 System.out.println("nom_ville_arrivee = "+ nom_ville_arrivee);
			 
			 int id_classe = Classe.getIdClasse(nom_classe);
			 int id_categorie = Categorie.getIdCategorie(nom_categorie);
			 
			 int prix_reservation =(int)Reservation.calculerPrix(id_categorie, id_classe, nom_ville_depart, nom_ville_arrivee);
			 System.out.println("prix = "+prix_reservation);
			
			PreparedStatement ps=conn.prepareStatement("insert into reservation(num_reservation,id_vol,id_passager,id_categorie,id_classe,date_reservation,prix_reservation) values(?,?,?,?,?,?,?)");
			 ps.setInt(1,num_reservation); 
			 ps.setInt(2,id_vol);
			 ps.setInt(3,id_passager);
			 ps.setInt(4,id_categorie);
			 ps.setInt(5,id_classe);
			 ps.setString(6,date_reservation);
			 ps.setDouble(7,prix_reservation);
			 ps.executeUpdate();
			 
			 
			 if(nom_classe.equals("affaire"))
			 {

					PreparedStatement ps4=conn.prepareStatement("update vol set P_D_affaire = P_D_affaire-1 where "
							+ "id_vol=?");
					ps4.setInt(1,id_vol);
					ps4.executeUpdate();
				
			 }
			 
			 else if(nom_classe.equals("economique"))
			 {

				 PreparedStatement ps4=conn.prepareStatement("update vol set P_D_economique = P_D_economique-1 where "
							+ "id_vol=?");
					ps4.setInt(1,id_vol);
					ps4.executeUpdate();
				
			 }
			
			
			
			
		} catch (Exception e) {
			
		}
	
		
	}
	public static void annulerReservation(int id_passager,String nomClasse)
	{	
		
		try {
			int id_vol;
			 PreparedStatement ps1=conn.prepareStatement("select id_vol from reservation where id_passager= ?");
			 ps1.setInt(1,id_passager);
			 ResultSet rs1;
			 rs1 = ps1.executeQuery();
			 rs1.next();
			 id_vol = rs1.getInt(1);
			 
			 
			 if(nomClasse.equals("affaire"))
			 {

				 PreparedStatement ps4=conn.prepareStatement("update vol set P_D_affaire = P_D_affaire+1 where "
							+ "id_vol=?");
					ps4.setInt(1,id_vol);
					ps4.executeUpdate();
				
			 }
			 
			 else if(nomClasse.equals("economique"))
			 {

				 PreparedStatement ps4=conn.prepareStatement("update vol set P_D_economique = P_D_economique+1 where "
							+ "id_vol=?");
					ps4.setInt(1,id_vol);
					ps4.executeUpdate();
				
				
			 }
			 PreparedStatement ps5=conn.prepareStatement("delete from reservation where id_passager= ?");
				ps5.setInt(1,id_passager);
				ps5.executeUpdate();
			 
			 
			 
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void modifierReservation(int id_reservation,String nom_passager,
			String prenom_passager,String tel_passager, String cin,int id_vol,String nom_categorie,String nom_classe ){
		
		
		
	
		try {	
				int id_classe = Classe.getIdClasse(nom_classe);
				int id_categorie = Categorie.getIdCategorie(nom_categorie);
				//recuperation de l'id passager
				PreparedStatement ps =conn.prepareStatement("select id_passager from reservation where id_reservation = ? ");
				ps.setInt(1, id_reservation);
				ResultSet rs= ps.executeQuery();
				rs.next();
				int id_passager = rs.getInt(1);
				//modifier les donnees personnelles
				Passager.modifierDonneesPersonnelles(id_passager, nom_passager, prenom_passager, tel_passager, cin);
				//modifier les donnees de reservation
				PreparedStatement ps1 = conn.prepareStatement("update reservation set id_vol = ?, id_categorie = ?, id_classe = ? where id_reservation = ?");
				ps1.setInt(1, id_vol);
				ps1.setInt(2, id_categorie);
				ps1.setInt(3, id_classe);
				ps1.setInt(4, id_reservation);
				ps1.executeUpdate();
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public static double calculerPrix(int id_categorie,int id_classe, String nom_ville_depart,String nom_ville_arrivee)
	{	double prix=0;
		try {
			//recuperation du prix par km de la classe
			PreparedStatement  ps1=conn.prepareStatement("select prix_par_km from classe where id_classe=?");
			ps1.setInt(1,id_classe);
			ResultSet rs1 =ps1.executeQuery();
			rs1.next();
			double prix_par_km=rs1.getDouble(1);
			System.out.println(" prix_par_km="+prix_par_km);
			//recuperation du % de reduction de la categorie
			PreparedStatement  ps2=conn.prepareStatement("select reduction from categorie where id_categorie=?");
			ps2.setInt(1,id_categorie);
			ResultSet rs2 =ps2.executeQuery();
			rs2.next();
			double reduction=rs2.getDouble(1);
			System.out.println(" reduction="+reduction);
			/*
			//select id_ville_depart
			PreparedStatement ps3 =  conn.prepareStatement("select id_ville from ville where nom_ville = ? ");
			ps3.setString(1, nom_ville_depart);
			ResultSet rs3 = ps3.executeQuery();
			rs3.next();
			int id_ville_depart= rs3.getInt(1);
			*/
			//select id_ville_arrivee
			PreparedStatement ps4 =  conn.prepareStatement("select altitude,longitude from ville where nom_ville = ? ");
			ps4.setString(1, nom_ville_depart);
			ResultSet rs4 = ps4.executeQuery();
			rs4.next();
			double alt1= rs4.getDouble(1);
			System.out.println(" alt1="+alt1);
			double lan1= rs4.getDouble(2);
			System.out.println(" lan1="+lan1);
	
			// select alt land ville depart
			PreparedStatement ps5 =  conn.prepareStatement("select altitude,longitude from ville where nom_ville = ? ");
			ps5.setString(1, nom_ville_arrivee);
			ResultSet rs5 = ps5.executeQuery();
			rs5.next();
			double alt2= rs5.getDouble(1);
			System.out.println(" alt2="+alt2);
			double lan2= rs5.getDouble(2);
			System.out.println(" lan2="+lan2);
					
			
			
			prix=Trajet.calculerDistanceKM(alt1,alt2,lan1,lan2)*prix_par_km*(1-reduction);
		
		
		
		
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return prix;
	}
	
	public static String getDay(int day, int month, int year){
		Calendar cal = Calendar.getInstance();
		cal.set(year,month-1,day);
		return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
	}

}
