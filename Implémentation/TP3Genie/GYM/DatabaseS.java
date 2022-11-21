package GYM;
/**
 * Database charg�e des services et s�ances
 * Agit aussi comme contr�leur pour les fonctions relatives a ceux ci.
 * @author Simo Hakim et Ming Xia Delvas
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseS {
	
	public ArrayList<Service> listeServices = new ArrayList<Service>();
	public ArrayList<Service> listeServicesJour = new ArrayList<Service>();
	public ArrayList<Seance> listeSeances = new ArrayList<Seance>();
	public ArrayList<Seance> listeSeancesJour = new ArrayList<Seance>();
	
	/**
	 * M�thode servant � rajouter un service � la listeServices
	 * @param newService Prend un service en entr�e a rajouter � la liste des services
	 * @param listePros liste des professionnels pour s'assurer que le pro qui a cr�� ce service existe vraiment
	 * @return Le succ�s ou l'�chec de l'op�ration
	 */
	public boolean serviceDBajout(Service newService, ArrayList<ArrayList<String>> listePros) {
		boolean added = false;
		ArrayList<String> proList = new ArrayList<String>();
		for(int i = 0; i < listePros.size(); i++) {
			proList.add(listePros.get(i).get(5));
		}
		if(proList.contains(Integer.toString(newService.getIdPro()))) {
			listeServices.add(newService); // Rajoute le service � l'arraylist
			added = true;
		}

		return added;	
		}
	/**
	 * M�thode servant � modifier les informations relatives � un service dans ListeServices
	 * @param proID ID du pro qui veut appliquer une modification � son service
	 * @param serviceCode Code de service qui va subir la modification
	 * @param lastTime	Nouvelle date finale du service
	 * @param serviceHour Nouvelle heure du service
	 * @param recurrence Nouvelle r�currence du service
	 * @param maxCapacity Nouvelle capacit� maximale du service
	 * @param serviceFee Nouveau tarif du service
	 * @return Le succ�s ou l'�chec de l'op�ration
	 */
	public boolean serviceModification(int proID, int serviceCode, LocalDate lastTime, LocalTime serviceHour, Integer[] recurrence, int maxCapacity, int serviceFee) {
		boolean modified = false;
		for(int i = 0; i < listeServices.size(); i++) {
			if(listeServices.get(i).getServiceCode() == serviceCode) {
				if(listeServices.get(i).getIdPro() == proID) {
					listeServices.get(i).setLastTime(lastTime);
					listeServices.get(i).setServiceHour(serviceHour);
					listeServices.get(i).setRecurrence(recurrence);
					listeServices.get(i).setMaxCapacity(maxCapacity);
					listeServices.get(i).setServiceFee(serviceFee);
					modified = true;
				}
			}
		}
		return modified;
	}
	/**
	 * M�thode servant � supprimer un service de ListeServices
	 * @param serviceCode code du service � supprimer
	 * @param proID	identifiant du Pro qui en fait la requ�te
	 * @return Le succ�s ou l'�chec de l'op�ration
	 */
	public boolean serviceSuppression(int serviceCode, int proID) {	
		boolean deleted = false;
		for(int i = 0; i < listeServices.size(); i++) {
			if(listeServices.get(i).getServiceCode() == serviceCode) {
				if(listeServices.get(i).getIdPro() == proID) {
					listeServices.remove(i);
					deleted = true;
				}
			}
		}
		return deleted;
	}
	/**
	 * M�thode servant � g�n�rer un code de service
	 * @return code de service
	 */
	public int generateServiceCode() {
		int id = 1 + (int)(Math.random() * ((999999999 - 1) + 1));
		return id;
	}
	/**
	 * M�thode servant � afficher la liste des services du jour
	 * @return Liste des services du jour
	 */
	public ArrayList<String> seancesToday() {
		ArrayList<String> repertoireJour = new ArrayList<String>();
		int currentDayOfWeek = LocalDate.now().getDayOfWeek().getValue();
		listeServicesJour = new ArrayList<Service>();
		if(listeServices.size() > 0) {
			for(int i = 0; i < listeServices.size(); i++) {
				if(LocalDate.now().isBefore(listeServices.get(i).getLastTime()) && LocalDate.now().isAfter(listeServices.get(i).getStartTime()) 
						&& Arrays.asList(listeServices.get(i).getRecurrence()).contains(currentDayOfWeek)) {
					String toPrint = ("S�ance trouv�e pour aujourd'hui"+"\r\n"+
					"Code de la s�ance : " + listeServices.get(i).getServiceCode() +"\r\n"+
					"Code du professionel affili� : " + listeServices.get(i).getIdPro()+"\r\n"+
					"Heure de la s�ance : " + listeServices.get(i).getServiceHour()+"\r\n"+
					"Frais de la s�ance : " + listeServices.get(i).getServiceFee()+"\r\n"+
					"Capacit� maximale : " + listeServices.get(i).getMaxCapacity()+"\r\n");
					repertoireJour.add(toPrint);
					listeServicesJour.add(listeServices.get(i));
				}
			}
		}
		return repertoireJour;
	}
	/**
	 * M�thode servant � inscrire un client � un service
	 * @param serviceCode code du service dans lequel le client veut s'inscrire
	 * @param memberID code du membre souhaitant s'inscrire au service
	 * @return Le succ�s ou l'�chec de l'op�ration
	 */
	public boolean registerSeance(int serviceCode, int memberID) {
		boolean registered = false;
		seancesToday();
		if(listeServicesJour.size() > 0) {
			for(int i = 0; i < listeServicesJour.size(); i++) {
					registered = true;
					Seance nouvelleSeance = new Seance(LocalDate.now(), listeServicesJour.get(i).getIdPro(), memberID, serviceCode);
					listeSeancesJour.add(nouvelleSeance);
					if(listeServicesJour.get(i).getServiceCode() == serviceCode) {
				}
			}
		}
		return registered;
	}
	/**
	 * M�thode servant � confirmer l'inscription un client � un service
	 * @param serviceCode code du service dans lequel le client veut confirmer son inscription
	 * @param memberID code du membre souhaitant confirmer son inscription
	 * @return Le succ�s ou l'�chec de l'op�ration
	 */
	public boolean confirmSeance(int serviceCode, int memberID) {
		boolean confirmed = false;
		seancesToday();
		if(listeSeancesJour.size() > 0) {
			for(int i = 0; i < listeSeancesJour.size(); i++) {
				if(listeSeancesJour.get(i).getServiceCode() == serviceCode && listeSeancesJour.get(i).getMemberID() == memberID) {
					listeSeancesJour.get(i).setConfirmation(true);
					listeSeances.add(listeSeancesJour.get(i));
					confirmed = true;
				}
			}
		}
		return confirmed;
	}
	/**
	 * Affiche la liste des inscriptions aux services qu'un pro devra traiter aujourd'hui
	 * @param idPro Identifiant du Pro souhaitant savoir quel services il devra effectuer aujourd'hui
	 * @return Liste des inscriptions � ses services
	 */
	public ArrayList<String> seancesProJour(int idPro) {
		seancesToday();
		ArrayList<String> inscriptions = new ArrayList<String>();
		for(int i = 0; i < listeSeancesJour.size(); i++) {
			if(listeSeancesJour.get(i).getIdPro() == idPro) {
				String registration = ("S�ance " + listeSeancesJour.get(i).getServiceCode() + "\r\n" + "Membre inscrit : " + listeSeancesJour.get(i).getMemberID());
				inscriptions.add(registration);
			}
		}
		return inscriptions;
	}
	

}
	

