package GYM;
/**
 * Database chargée des personnes (membres et pros)
 * Agit aussi comme contrôleur pour les fonctions relatives a ceux ci.
 * @author Simo Hakim et Ming Xia Delvas
 */
import java.util.ArrayList;

public class DatabaseP {
	
	public ArrayList<ArrayList<String>> listeMembres = new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> listePros = new ArrayList<ArrayList<String>>();
	/**
	 * Méthode chargée de la suppression d'un membre de ListeMembres
	 * @param Membre Prend un membre en entrée et le rajoute à la liste des membres
	 * @return Le succès ou l'échec de l'opération
	 */
	public boolean memberDBajout(Member Membre) {
		boolean added = false;
		ArrayList<String> emailList = new ArrayList<String>();
		for(int i = 0; i < listeMembres.size(); i++) {
			emailList.add(listeMembres.get(i).get(3));
		}
		if(!(emailList.contains(Membre.getEmail()))) {
			ArrayList<String> membreListe = new ArrayList<String>();
			membreListe.add(Membre.getNom());
			membreListe.add(Membre.getPrenom());
			membreListe.add(Integer.toString(Membre.getTel()));
			membreListe.add(Membre.getEmail());
			membreListe.add(Integer.toString(Membre.getFraisMensuel()));
			membreListe.add(Integer.toString(Membre.getIdMembre()));
			membreListe.add(Integer.toString(Membre.getFraisDus()));
			membreListe.add(String.valueOf(Membre.getStatus()));
			listeMembres.add(membreListe); // Rajoute le membre à l'array
			added = true;
		}
		return added;		
	}
	/**
	 * Méthode chargée de la modification d'un membre de ListeMembres
	 * Prend en entrée : 
	 * @param idMembre l'identifiant du membre à modifier
	 * @param numero Numéro de téléphone mis a jour
	 * @param email Email mis a jour
	 * @param frais frais mensuels mis a jour
	 * @return Le succès ou l'échec de l'opération
	 */
	public boolean memberModification(String idMembre, String numero, String email, String frais) {
		boolean modified = false;
		for(int i = 0; i < listeMembres.size(); i++) {
			if(listeMembres.get(i).get(5).equals(idMembre)) {
				// todo : if all the parsing is correct, do this : else return modified false and don't modify
				listeMembres.get(i).set(2, numero);
				listeMembres.get(i).set(3, email);
				listeMembres.get(i).set(4, frais);
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * Méthode chargée de la suppression d'un membre de ListeMembres
	 * @param memberID l'identifiant du membre à supprimer
	 * @return Le succès ou l'échec de l'opération
	 */
	public boolean memberSuppression(String memberID) {	
		boolean deleted = false;
		for(int i = 0; i < listeMembres.size(); i++) {
			if(listeMembres.get(i).get(5).equals(memberID)) {
				listeMembres.remove(i);
				deleted = true;	
			}
		}
		return deleted;
	}
	/**
	 * Prend un email et essaie de trouver un membre correspondant
	 * @param email email appartenant a l'individu ayant perdu son ID
	 * @param listType type de liste dans lequel effectuer la recherche, 1 pour membres, 2 pour pros
	 * @return identifiant retrouvé, si retrouvé.
	 */
	public String retrieveID(String email, int listType) {
		String retrievedID = null;
		if(listType == 1) {
			for(int i = 0; i < listeMembres.size(); i++) {
				if(listeMembres.get(i).get(3).equals(email)) {
					retrievedID = listeMembres.get(i).get(5);	
				}
			}
		} else if (listType == 2) {
			for(int i = 0; i < listePros.size(); i++) {
				if(listePros.get(i).get(3).equals(email)) {
					retrievedID = listePros.get(i).get(5);	
				}
			}
		} else {
			System.out.println("Unexpected Error");
		}
		return retrievedID;
	};
	/**
	 * Permet de vérifier la validité d'un membre
	 * @param memberID membre dont l'état doit être vérifié
	 * @return l'état du membre.
	 */
	public boolean memberVerification(String memberID) {
		boolean found = false;
		String status;
		for(int i = 0; i < listeMembres.size(); i++) {
			if(listeMembres.get(i).get(5).equals(memberID)) {
				status = listeMembres.get(i).get(7);
				System.out.println("Membre " + memberID + " trouvé, Status : " + status);
				System.out.println("Nom Complet : " + listeMembres.get(i).get(0) + " " + listeMembres.get(i).get(1));
				System.out.println(listeMembres.get(i));
				found = true;
			}
		}
		if(found == false) {
			System.out.println("Membre "+ memberID +" non trouvé");
		}
		return found;
	}
	/**
	 * 
	 * @param Pro Prend un Pro en entrée et le rajoute à la liste des membres
	 * @return Le succès ou l'échec de l'opération
	 */
	public boolean proDBajout(Professionnel Pro) {
		boolean added = false;
		ArrayList<String> emailList = new ArrayList<String>();
		
		for(int i = 0; i < listePros.size(); i++) {
			emailList.add(listePros.get(i).get(3));
		}
		
		if(!(emailList.contains(Pro.getEmail()))) {
			ArrayList<String> proListe = new ArrayList<String>();
			proListe.add(Pro.getNom());
			proListe.add(Pro.getPrenom());
			proListe.add(Integer.toString(Pro.getTel()));
			proListe.add(Pro.getEmail());
			proListe.add(Pro.getDiscipline());
			proListe.add(Integer.toString(Pro.getIdPro()));
			proListe.add(Integer.toString(Pro.getMontantAVerser()));
			listePros.add(proListe); // Rajoute le membre à l'array
			added = true;
		}
		return added;
	}
	/**
	 * Méthode permettant la vérification d'un comtpe de pro
	 * @param proID ID du pro a vérifier
	 * @return L'état du Pro
	 */
	public boolean proVerification(String proID) {
		boolean found = false;
		for(int i = 0; i < listePros.size(); i++) {
			if(listePros.get(i).get(5) == proID) {
				System.out.println("Professionel " + proID + " trouvé");
				System.out.println("Nom Complet : " + listePros.get(i).get(0) + " " + listePros.get(i).get(1));
				System.out.println(listePros.get(i));
				found = true;
			}
		}
		if(found == false) {
			System.out.println("Professionel "+ proID +" non trouvé");
		}
		return found;
	}
	/**
	 * Méthode qui génère un ID pour membres
	 * @return un ID pour membre
	 */
	public int generateMemberID() {
		int id;
		if(listeMembres.size()>0) {
			id = 1 + (int)(Math.random() * ((999999999 - 1) + 1));
			for(int i = 0; i < listeMembres.size(); i++) {
				if(id == Integer.parseInt(listeMembres.get(i).get(5)) ) {
					id = generateMemberID();
				}
			}
		} else { 
			id = 1 + (int)(Math.random() * ((999999999 - 1) + 1));
		}
		return id;
	}
	/**
	 * Méthode qui génère un ID pour Pro
	 * @return un ID pour Pro
	 */
	public int generateProID() {
		int id;
		if(listePros.size()>0) {
			id = 1 + (int)(Math.random() * ((999999999 - 1) + 1));
			for(int i = 0; i < listePros.size(); i++) {
				if(id == Integer.parseInt(listePros.get(i).get(5)) ) {
					id = generateMemberID();
				}
			}
		} else { 
			id = 1 + (int)(Math.random() * ((999999999 - 1) + 1));
		}
		return id;
	}
		
}
	

