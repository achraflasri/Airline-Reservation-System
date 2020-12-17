package reservation_billets;
import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.time.*;
import java.util.*;

public class test_methodes {
	public static void main(String[] args) {

//	Passager p=new Passager("ichrak","eloili","0632326598",1,"wa250435");
		//p.reserverBillet(2, 2, "affaire");
		//p.reserverBillet(3, 2, "affaire");
		//p.annulerReservation(1, "affaire");
		//p.afficherVols("tanger","agadir",new Date(05, 05, 2019));
	//Admin admin=new Admin("reda", "radi", "0623568989", "admin", "admin");
		//admin.modifierPrixClasse("affaire",1200);
		//admin.ajouterCategorie("mseti",0.8);
		//admin.supprimerCategorie("senior");
		//Vol.ajouterVol(1,"vendredi",new Time(10,00,00),new Time(10,00,00),2,40,90);
		/*Avion.ajouterAvion(7400, "hd14781",1,"samedi",new Time(23,14,00)
				,new Time(07,30,00),40,100);*/
		//Avion.SupprimerAvion(3);
		
//		Trajet.ajouterTrajet("Agadir", "Tanger");
		//Trajet.supprimerTrajet(1);
		//Classe.ajouterClasse("Etudiant",5);
		//Classe.supprimerClasse("Etudiant");
		//Capacite.modifierCapacite(1,1,30);
	//	Capacite.supprimerCapacite(1,1);
		//Classe.SupprimerClasse("affaire","azbdd5ad");
		//Vol.calculerDistanceKM(33.5731104,33.26553, -7.5898434,-7.58754);
		/*Vector<String> list=Classe.listeClasses();
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		*/
		
    /* Vector<Integer> list=Vol.listeIdVols();
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}*/
		
		
		/*int id_classe=Classe.getIdClasse("economique");
		System.out.println("  id de la classe economique :"+id_classe);*/
		
		//Vol.modifierVol(1,"Mercredi",new Time(04,15,00),new Time(10,00,00),2);
	
		/*double prix = Vol.calculerPrix(2, 1, "agadir", "tanger");
		System.out.println("prix = "+prix);*/
		
		/*Time duree = Vol.calculerDuree(1);
		System.out.println(duree);*/
		
		/*@SuppressWarnings("deprecation")
		Date d = new Date(30,05,2019);
		 DayOfWeek dayOfWeek = DayOfWeek.of(d.getDay());
		    System.out.println(dayOfWeek.name());
		System.out.println(d.getDay());*/
		
		//Vol.initialiserNbrPlaces(1);
		
		//tache planifiée pour mettre a jour le nbr de places dispo
		/*Timer t= new Timer();
		maj_places_tache tache = new maj_places_tache();
		t.schedule(tache, 0, 60000);*/
		
		//Vol.afficherVols("agadir", "tanger", "15/05/2019");
		//Admin.reservationsParMois();
		//Admin.reservationsParPassager(3);
		//Reservation.reserverBillet("kasbaoui", "adil", "0612345678", "hj785455", 7, "etudiant", "affaire", "10/10/2020",3);
		Vol.ajouterVolSeul(2, "l7ad", new Time(14,20,00),  new Time(23,45,00), 2);
		
		
	}
	
	
	
	
	

}
