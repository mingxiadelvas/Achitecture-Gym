package GYM;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Cette classe agit comme une interface pour le logiciel en version Mobile avec des fonctions r�duites
 * la fonction start() permet de d�marrer l'interface qui ira appeler les m�thodes correspondantes � la t�che qui va interagir avec les databases.
 * Au d�but, l'interface s'assure du type d'utilisateur et de son email avant de donner l'acc�s au programme.
 * les commandes se donnent en rentrant un chiffre correspondant.
 * @author Simo Hakim et Ming Xia Delvas
 */
public class Mobile {
	public static DatabaseP dbp = new DatabaseP();
	public static DatabaseS dbs = new DatabaseS();
	private static Scanner sc = new Scanner(System.in);
	private static boolean typeOfUser = false;
	public String email;
	public static String id = null;
	public static void start() {
		boolean typeSelected = true;
		while(typeSelected) {
			typeSelected = !userType();
		}
		boolean compteSelected = true;
		while(compteSelected) {
			compteSelected = !facebookAPI(typeOfUser);
		}
		if(typeSelected) {
			statusMembre();
			memberInterface();
		} else {
			proInterface();
		}
	}
	/**
	 * M�thode qui prend en entr�e le type d'utilisateur
	 * @return type d'utilisateur rentr� dans le syst�me de l'interface.
	 */
	public static boolean userType() {
		boolean operationComplete = false;
		sc = new Scanner(System.in); 
		System.out.println("�tes vous un professionel ou un membre ?");
		System.out.println("Tapez M pour membre ou P pour Pro");
		String choice = sc.nextLine();
		boolean notSelected = true;
		while(notSelected) {
			if(choice.equals("m") || choice.equals("M")) {
				typeOfUser = true;
				notSelected = false;
				operationComplete = true;
			} else if(choice.equals("p") || choice.equals("P")) {
				typeOfUser = false;
				notSelected = false;
				operationComplete = true;
			} else {
				System.out.println("Invalid Choice. Please Retry");
			}
		}
		return operationComplete;
		
	}
	/**
	 * M�thode qui prend en entr�e l'email de l'utilisateur
	 * @param typeOfUser type d'utilisateur, influe la mani�re dont l'email sera v�rifi� 
	 * @return preuve d'existence dans la database de l'email d'utilisateur rentr� dans le syst�me de l'interface.
	 */
	public static boolean facebookAPI(boolean typeOfUser) {
		//API non mise en place
		boolean accountFound = true;
		System.out.println("Veuillez rentrer votre email");
		String emailProbably = sc.nextLine();
		if(typeOfUser) {
			id = dbp.retrieveID(emailProbably, 1);
		} else {
			id = dbp.retrieveID(emailProbably, 2);
		}
		if(id == null) {
			System.out.println("Aucun compte retrouv�");
			accountFound = false;
		}
		return accountFound;
	}
	
	/**
	 * Interface mobile a fonctions r�duites, fonctions diff�rentes pour les Pros ou Membres
	 * Version Membres.
	 */
	public static void memberInterface() {
		String inputAgent;
		@SuppressWarnings("unused")
		boolean running = true;
		System.out.println("Bienvenue dans l'application mobile, cher membre !");
		System.out.println("Ceci est une application console a des fins de prototypage.");
		System.out.println("Pour une liste des commandes, veuillez �crire 'aide', sinon �crivez un chiffre correspondant � une commande.");
		while (running = true) {
			inputAgent = sc.nextLine();
			System.out.println(inputAgent);
			switch(inputAgent) {
			case "1":
				System.out.println("Repertoire des services du jour :");
				consultationSeances();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "2": 
				System.out.println("Inscription s�ances :");
				inscriptionSeance();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "aide": 
				System.out.println("Pour le r�pertoire des services, tapez 1");
				System.out.println("Pour l'inscription � une s�ance, tapez 2");
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			default:
				System.out.println("Entr�e invalide, vous pouvez entrer la commande 'aide' afin d'avoir la liste des commandes possibles.");
				break;
			}
		}
	}
	/**
	 * Interface mobile a fonctions r�duites, fonctions diff�rentes pour les Pros ou Membres
	 * Version Pros.
	 */
	public static void proInterface() {
		String inputAgent;
		@SuppressWarnings("unused")
		boolean running = true;
		System.out.println("Bienvenue dans l'application mobile, cher professionel !");
		System.out.println("Ceci est une application console a des fins de prototypage.");
		System.out.println("Pour une liste des commandes, veuillez �crire 'aide', sinon �crivez un chiffre correspondant � une commande.");
		while (running = true) {
			inputAgent = sc.nextLine();
			System.out.println(inputAgent);
			switch(inputAgent) {
			case "1":
				System.out.println("Inscriptions du jour :");
				inscriptionsDuJour();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "2": 
				System.out.println("Confirmer l'inscription d'un membre :");
				confirmationInscription();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "aide": 
				System.out.println("Pour consulter les inscriptions a vos s�ances d'aujourd'hui, tapez 1");
				System.out.println("Pour confirmer l'inscription d'un membre � une de vos s�ances, tapez 2");
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			default:
				System.out.println("Entr�e invalide, vous pouvez entrer la commande 'aide' afin d'avoir la liste des commandes possibles.");
				break;
			}
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant memberVerification dans la database des personnes pour v�rifier une entr�e de membre. 
	 * Cens� afficher un QRcode, affiche l'id du membre � la place dans la console 
	 */
	public static void statusMembre() {
		if(dbp.memberVerification(id)) {
			System.out.println("QR Code : " + "Simulation du QR code " + id);
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant seancesToday dans la database des Services et S�ances afin d'afficher la liste des s�ances du jour. 
	 */
	public static void consultationSeances() {
		ArrayList<String> repertoire = dbs.seancesToday();
		if(repertoire.size() > 0) {
			System.out.println("R�pertoire des Services offerts aujourd'hui :");
			for(int i = 0; i<repertoire.size(); i++) {
				System.out.println(repertoire.get(i));
			}
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant memberVerification dans la database des personnes et registerSeance dans la database des Services et S�ances afin d'inscrire un membre � une s�ance. 
	 */
	public static void inscriptionSeance() {
		sc  = new Scanner(System.in); 
		int input1 = Integer.parseInt(id);
		System.out.println("Veuillez rentrer le code de service");
		int input2 = Integer.parseInt(sc.nextLine());
		
		if(dbp.memberVerification(Integer.toString(input1))){
			if(dbs.registerSeance(input2,input1)) {
				System.out.println("Membre inscrit � la s�ance, veuillez confirmer avant d'entrer");
			} else {
				System.out.println("Echec, Aucune s�ance de disponible correspondante trouv�e");
			}
		} else {
			System.out.println("Abort : Membre inv�rifiable");
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant seancesProJour dans la database des Services et S�ances afin d'afficher les inscriptions du jour � un service. 
	 */
	public static void inscriptionsDuJour() {
		ArrayList<String> inscriptions = dbs.seancesProJour(Integer.parseInt(id));
		if(inscriptions.size() > 0){
			for(int i = 0; i < inscriptions.size(); i++) {
				System.out.println(inscriptions.get(i));
			}
		} else {
			System.out.println("Aucune inscription � une s�ance aujourd'hui");
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant memberVerification dans la database des personnes et confirmSeance dans la database des Services et S�ances afin de confirmer l'inscription d'un membre � une s�ance. 
	 */
	public static void confirmationInscription() {
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'identifiant de membre");
		int input1 = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez rentrer le code de service");
		int input2 = Integer.parseInt(sc.nextLine());
		if(dbp.memberVerification(Integer.toString(input1))){
			if(dbs.confirmSeance(input2,input1)) {
				System.out.println("Inscription confirm�e du membre � la s�ance.");
			} else {
				System.out.println("Echec, Aucune inscription correspondante trouv�e");
			}
		} else {
			System.out.println("Abort : Membre inv�rifiable");
		}
	}
}
