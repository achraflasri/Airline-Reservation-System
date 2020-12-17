package reservation_billets;

import java.util.Date;
import java.util.TimerTask;

public class maj_places_tache extends TimerTask {
	public void run(){
		if(Vol.comparerTemps(4))
			Vol.initialiserNbrPlaces(4);
	
		
	}
}
