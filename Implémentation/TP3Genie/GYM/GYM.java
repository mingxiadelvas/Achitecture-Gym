package GYM;
/**
 * Cette classe agit comme une interface pour le logiciel en version Desktop avec beaucoup plus de fonctions
 * la fonction start() permet de démarrer l'interface qui ira appeler les méthodes correspondantes à la tâche qui va interagir avec les databases.
 * les commandes se donnent en rentrant un chiffre correspondant.
 * @author Simo Hakim et Ming Xia Delvas
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;    

public class GYM {
	
	public static DatabaseP dbp = new DatabaseP();
	public static DatabaseS dbs = new DatabaseS();
	private static Scanner sc = new Scanner(System.in);
	public static void start() {
		String inputAgent;
		@SuppressWarnings("unused")
		boolean running = true;
		System.out.println("Bienvenue dans le programme de management GYM");
		System.out.println("Pour une liste des commandes, veuillez écrire 'aide', sinon écrivez un chiffre correspondant à une commande.");
		while (running = true) {
			inputAgent = sc.nextLine();
			System.out.println(inputAgent);
			switch(inputAgent) {
			case "1":
				System.out.println("Adhesion Membre");
				ajoutMembre();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "2": 
				System.out.println("Modification Membre");
				modificationMembre();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "3":
				System.out.println("Suppression Membre");
				suppressionMembre();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "4":
				System.out.println("Retrouver Numero Membre");
				retrouverMembre();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "5":
				System.out.println("Verification Membre");
				verificationMembre();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "6":
				System.out.println("Adhesion Pro");
				ajoutPro();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "7":
				System.out.println("Retrouver Numero Pro");
				retrouverPro();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "8":
				System.out.println("Consultation Seances");
				consultationSeances();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "9":
				System.out.println("Inscription Seance");
				inscriptionSeance();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "10":
				System.out.println("Confirmer Seance");
				confirmationSeance();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "11":
				System.out.println("Ajouter Service");
				ajoutService();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "12":
				System.out.println("Mise a jour Service");
				modificationService();
				System.out.println("Tâche terminée, en attente de commande :");
			break;
			case "13":
				System.out.println("Supprimer service");
				suppressionService();
				System.out.println("Tâche terminée, en attente de commande :");
				break;
			case "Never Gonna Give You Up": // Commande secrète qui déclenche la procédure comptable, connue uniquement du manager"
				procedureSecrete();
				break;
			case "aide":
				System.out.println("Les commandes sont :");
				System.out.println("Tapez 1 pour Adhésion Membre");
				System.out.println("Tapez 2 pour Modification Membre");
				System.out.println("Tapez 3 pour Suppression Membre");
				System.out.println("Tapez 4 pour Retrouver Numero Membre");
				System.out.println("Tapez 5 pour Verification Membre");
				System.out.println("Tapez 6 pour Adhesion Pro");
				System.out.println("Tapez 7 pour Retrouver Numero Pro");
				System.out.println("Tapez 8 pour Consultation Seances");
				System.out.println("Tapez 9 pour Inscription Seance");
				System.out.println("Tapez 10 pour Confirmer Seance");				
				System.out.println("Tapez 11 pour Ajouter service");
				System.out.println("Tapez 12 pour Mise a jour service");
				System.out.println("Tapez 13 pour Supprimer service");
				System.out.println("Pour démarrer la procédure comptable, le manager doit taper le mot de passe");
				break;
			case "exit":
				System.out.println("exit");
				running = false;
				break;
			default:
				System.out.println("Entrée invalide, vous pouvez entrer la commande 'aide' afin d'avoir la liste des commandes possibles.");
				break;
			}
		}
		
	}
/**
 * 
 * @param numeroTel l'imput a vérifier est un integer
 * @return ici un boolean validant la condition
 */
	public static boolean isInteger(String numeroTel) {
	    try { 
	        Integer.parseInt(numeroTel); 
	    } catch(NumberFormatException e) { 
	    	System.out.println("Input error, veuillez réessayer");
	        return false; 
	    } catch(NullPointerException e) {
	    	System.out.print("Input error, veuillez réessayer");
	        return false;
	    }
	    return true;
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant memberDBajout dans la database des personnes ainsi que dbp.generateMemberID pour créer un ID. 
	 */
	public static void ajoutMembre() {
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer le nom du nouveau membre");
		String input1 = sc.nextLine();
		System.out.println("Veuillez rentrer le prénom du nouveau membre");
		String input2 = sc.nextLine();
		System.out.println("Veuillez rentrer le numéro de téléphone du nouveau membre");
		String input3 = sc.nextLine();
		isInteger(input3);
		System.out.println("Veuillez rentrer l'email du nouveau membre");
		String input4 = sc.nextLine();
		System.out.println("Veuillez rentrer les frais mensuels du nouveau membre");
		String input5 = sc.nextLine();
		isInteger(input5);
		Member newMember = new Member(input1,input2,Integer.parseInt(input3),input4,Integer.parseInt(input5),000);
		System.out.println("Est-ce que le client a payé les frais d'inscriptions ? (Répondre Y ou N)");
		String input6 = sc.nextLine();
		newMember.setIdMembre(dbp.generateMemberID());
		
		if(input6.equals("y") || input6.equals("Y")) {
			newMember.setStatus(true);
			if(dbp.memberDBajout(newMember)) {
				System.out.println("Compte Membre créé. L'identifiant de membre est : " + newMember.getIdMembre());
			} else {
				System.out.println("Un compte existe déjà");
			}
		} else if(input6.equals("n") || input6.equals("N")) {
			System.out.println("Membre non sauvegardé.");
		} else {
			System.out.println("Entrée invalide, opération avortée");
		}
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant memberModification dans la database des personnes pour modifier une entrée de membre. 
	 */
	public static void modificationMembre() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'identifiant du membre à retrouver ");
		String input1 = sc.nextLine();
		System.out.println("Veuillez rentrer le numéro de téléphone du membre");
		String input2 = sc.nextLine();
		isInteger(input2);
		System.out.println("Veuillez rentrer l'email du membre");
		String input3 = sc.nextLine();
		System.out.println("Veuillez rentrer les frais mensuels du membre");
		String input4 = sc.nextLine();
		isInteger(input4);
		if(dbp.memberModification(input1, input2, input3, input4)) {
			System.out.println("Modification effectuée");
		} else {
			System.out.println("Modification échouée");

		}
	}	
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant memberSuppression dans la database des personnes pour supprimer une entrée de membre. 
	 */
	public static void suppressionMembre() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer numéro d'identifiant du membre à supprimer : ");
		String input1 = sc.nextLine();
		if(dbp.memberSuppression(input1)) {
			System.out.println("Membre : " + input1 + " Supprimé ");
		} else {
			System.out.println("Membre "+ input1 +" non trouvé, Suppression non effectuée.");
		}
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant retrieveID dans la database des personnes pour retrouver une entrée de membre. 
	 */
	public static void retrouverMembre() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'email du membre à retrouver : ");
		String input1 = sc.nextLine();
		String answer = dbp.retrieveID(input1,1);
		if(answer == null) {
			System.out.println("Email ne correspondant a aucun membre ");
		} else {
			System.out.println("Email correspondant au membre " + answer);
		}
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant memberVerification dans la database des personnes pour vérifier une entrée de membre. 
	 */
	public static void verificationMembre() {
		System.out.println("Veuillez rentrer numéro d'identifiant du membre à vérifier : ");
		String inputIDmembre = sc.nextLine();
		dbp.memberVerification(inputIDmembre);
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant proDBajout dans la database des personnes ainsi que generateProID pour créer un ID. 
	 */
	public static void ajoutPro() {
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer le nom du nouveau professionel");
		String input1 = sc.nextLine();
		System.out.println("Veuillez rentrer le prénom du nouveau professionel");
		String input2 = sc.nextLine();
		System.out.println("Veuillez rentrer le numéro de téléphone du nouveau professionel");
		String input3 = sc.nextLine();
		isInteger(input3);
		System.out.println("Veuillez rentrer l'email du nouveau professionel");
		String input4 = sc.nextLine();
		System.out.println("Veuillez rentrer la discipline du nouveau membre");
		String input5 = sc.nextLine();
		int idP = dbp.generateProID();
		Professionnel newPro = new Professionnel(input1,input2,Integer.parseInt(input3),input4,input5,idP);
		if(dbp.proDBajout(newPro)) {
			System.out.println("Compte Pro créé. L'identifiant de pro est : " + idP);
		} else {
			System.out.println("Un compte existe déjà");
		}
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant retrieveID dans la database des personnes afin de retrouver un ID. 
	 */
	public static void retrouverPro() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'email du professionel à retrouver : ");
		String input1 = sc.nextLine();
		String answer = dbp.retrieveID(input1,2);
		if(answer == null) {
			System.out.println("Email ne correspondant a aucun professionel ");
		} else {
			System.out.println("Email correspondant au professionel " + answer);
		}
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant serviceDBajout dans la database des Services et Séances afin de créer et enregistrer un service. 
	 */
	public static void ajoutService() {
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate startTime = null;
		LocalDate lastTime = null;
		LocalTime serviceHour = null;
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'ID du professionel qui souhaite effectuer un ajout de service :");
		int inputIDPro = Integer.parseInt(sc.nextLine());
		//proVerification(inputIDPro);
		System.out.println("Veuillez rentrer la date de début du service au format DD/MM/YYYY :");
		sc = new Scanner(System.in);
		sc.findInLine("(\\d\\d)\\/(\\d\\d)\\/(\\d\\d\\d\\d)");
		try {
		    MatchResult mr0 = sc.match();
		    int day = Integer.parseInt(mr0.group(1));
		    int month = Integer.parseInt(mr0.group(2));
		    int year = Integer.parseInt(mr0.group(3));
		    startTime = LocalDate.of(year, month,day);
		} catch (IllegalStateException e) {
		    System.err.println("Invalid input!");
		}
		System.out.println("Veuillez rentrer la date de fin du service au format DD/MM/YYYY :");
		sc = new Scanner(System.in);
		sc.findInLine("(\\d\\d)\\/(\\d\\d)\\/(\\d\\d\\d\\d)");
		try {
		    MatchResult mr1 = sc.match();
		    int day = Integer.parseInt(mr1.group(1));
		    int month = Integer.parseInt(mr1.group(2));
		    int year = Integer.parseInt(mr1.group(3));
		    lastTime = LocalDate.of(year, month,day);
		} catch (IllegalStateException e) {
		    System.err.println("Invalid input!");
		}
		System.out.println("Veuillez rentrer l'heure du service au format HH:MM :");
		sc = new Scanner(System.in);
		sc.findInLine("(\\d\\d)\\:(\\d\\d)");
		try {
		    MatchResult mr2 = sc.match();
		    int hour = Integer.parseInt(mr2.group(1));
		    int minute = Integer.parseInt(mr2.group(2));
		    serviceHour = LocalTime.of(hour, minute);
		} catch (IllegalStateException e) {
		    System.err.println("Invalid input!");
		}
		System.out.println("Veuillez rentrer, séparé par une virgule, les chiffres correspondants aux jours de la semaine a laquelle l'activité sera récurrente :");
		System.out.println("Exemple : Pour Lundi, Vendredi et Dimanche : 1,5,7");
		sc = new Scanner(System.in);
		String inputAgent = sc.nextLine();
		Integer[] recurrence = Arrays.stream(Arrays.stream(inputAgent.split(",")).mapToInt(Integer::parseInt).toArray() ).boxed().toArray( Integer[]::new );
	
		System.out.println("Veuillez rentrer la capacité maximale : ");
		int maxCapacity = sc.nextInt();
		System.out.println("Veuillez rentrer les frais de service : ");
		int serviceFee = sc.nextInt();
		Service newService = new Service(currentTime,startTime,lastTime,serviceHour,recurrence,maxCapacity,serviceFee,inputIDPro,000);
		if(dbs.serviceDBajout(newService,dbp.listePros)) {
			newService.setServiceCode(dbs.generateServiceCode());
			System.out.println("Service créé. Le code de service est : " + newService.getServiceCode());
		} else {
			System.out.println("Un service existe déjà");
		}
		
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant serviceModification dans la database des Services et Séances afin de modifier un service. 
	 */
	public static void modificationService() {
		LocalDate lastTime = null;
		LocalTime serviceHour = null;
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'ID du professionel qui souhaite effectuer une modification de service :");
		int inputIDPro = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez rentrer le code du service à modifier :");
		int serviceCode = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez rentrer la date de fin du service au format DD/MM/YYYY :");
		sc = new Scanner(System.in);
		sc.findInLine("(\\d\\d)\\/(\\d\\d)\\/(\\d\\d\\d\\d)");
		try {
		    MatchResult mr1 = sc.match();
		    int day = Integer.parseInt(mr1.group(1));
		    int month = Integer.parseInt(mr1.group(2));
		    int year = Integer.parseInt(mr1.group(3));
		    lastTime = LocalDate.of(year, month,day);
		} catch (IllegalStateException e) {
		    System.err.println("Invalid input!");
		}
		System.out.println("Veuillez rentrer l'heure du service au format HH:MM :");
		sc = new Scanner(System.in);
		sc.findInLine("(\\d\\d)\\:(\\d\\d)");
		try {
		    MatchResult mr2 = sc.match();
		    int hour = Integer.parseInt(mr2.group(1));
		    int minute = Integer.parseInt(mr2.group(2));
		    serviceHour = LocalTime.of(hour, minute);
		} catch (IllegalStateException e) {
		    System.err.println("Invalid input!");
		}
		System.out.println("Veuillez rentrer, séparé par une virgule, les chiffres correspondants aux jours de la semaine a laquelle l'activité sera récurrente :");
		System.out.println("Exemple : Pour Lundi, Vendredi et Dimanche : 1,5,7");
		sc = new Scanner(System.in);
		String inputAgent = sc.nextLine();
		Integer[] recurrence = Arrays.stream(Arrays.stream(inputAgent.split(",")).mapToInt(Integer::parseInt).toArray() ).boxed().toArray( Integer[]::new );
		System.out.println("Veuillez rentrer la capacité maximale : ");
		int maxCapacity = sc.nextInt();
		System.out.println("Veuillez rentrer les frais de service : ");
		int serviceFee = sc.nextInt();
		
		if(dbs.serviceModification(inputIDPro, serviceCode, lastTime, serviceHour, recurrence,maxCapacity,serviceFee)) {
			System.out.println("Modification effectuée");
		} else {
			System.out.println("Modification échouée");
		}
	}	
	
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant serviceSuppression dans la database des Services et Séances afin de supprimer un service. 
	 */
	public static void suppressionService() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer le code du service à supprimer : ");
		int input1 = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez rentrer l'identifiant de pro correspondant : ");
		int input2 = Integer.parseInt(sc.nextLine());
		
		if(dbs.serviceSuppression(input1, input2)) {
			System.out.println("Service : " + input1 + " Supprimé ");
		} else {
			System.out.println("Service "+ input1 +" non supprimé, veuillez vérifier le code de service et l'identifiant de pro.");
		}
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant seancesToday dans la database des Services et Séances afin d'afficher la liste des séances du jour. 
	 */
	public static void consultationSeances() {
		ArrayList<String> repertoire = dbs.seancesToday();
		if(repertoire.size() > 0) {
			System.out.println("Répertoire des Services offerts aujourd'hui :");
			for(int i = 0; i<repertoire.size(); i++) {
				System.out.println(repertoire.get(i));
			}
		}
	}
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant memberVerification dans la database des personnes et registerSeance dans la database des Services et Séances afin d'inscrire un membre à une séance. 
	 */
	public static void inscriptionSeance() {
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'identifiant de membre");
		int input1 = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez rentrer le code de service");
		int input2 = Integer.parseInt(sc.nextLine());
		
		if(dbp.memberVerification(Integer.toString(input1))){
			if(dbs.registerSeance(input2,input1)) {
				System.out.println("Membre inscrit à la séance, veuillez confirmer avant d'entrer");
			} else {
				System.out.println("Echec, Aucune séance de disponible correspondante trouvée");
			}
		} else {
			System.out.println("Abort : Membre invérifiable");
		}
		
	}
	
	/**
	 * Méthode prenant les inputs de l'utilisateur et appelant memberVerification dans la database des personnes et confirmSeance dans la database des Services et Séances afin de confirmer l'inscription d'un membre à une séance. 
	 */
	public static void confirmationSeance() {
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'identifiant de membre");
		int input1 = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez rentrer le code de service");
		int input2 = Integer.parseInt(sc.nextLine());
		if(dbp.memberVerification(Integer.toString(input1))){
			if(dbs.confirmSeance(input2,input1)) {
				System.out.println("Inscription confirmée du membre à la séance.");
			} else {
				System.out.println("Echec, Aucune inscription correspondante trouvée");
			}
		} else {
			System.out.println("Abort : Membre invérifiable");
		}
		
	}
	
	/**
	 * Méthode censée lancer la procédure comptable : Pas faite, manque de temps, sorry !
	 */
	public static void procedureSecrete() {
		System.out.println("Bienvenue, Manager Rick Astley.");
		System.out.println("Procédure comptable enclenchée");
		//dbs.procedureComptable();
	}

}