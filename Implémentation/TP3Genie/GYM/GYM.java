package GYM;
/**
 * Cette classe agit comme une interface pour le logiciel en version Desktop avec beaucoup plus de fonctions
 * la fonction start() permet de d�marrer l'interface qui ira appeler les m�thodes correspondantes � la t�che qui va interagir avec les databases.
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
		System.out.println("Pour une liste des commandes, veuillez �crire 'aide', sinon �crivez un chiffre correspondant � une commande.");
		while (running = true) {
			inputAgent = sc.nextLine();
			System.out.println(inputAgent);
			switch(inputAgent) {
			case "1":
				System.out.println("Adhesion Membre");
				ajoutMembre();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "2": 
				System.out.println("Modification Membre");
				modificationMembre();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "3":
				System.out.println("Suppression Membre");
				suppressionMembre();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "4":
				System.out.println("Retrouver Numero Membre");
				retrouverMembre();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "5":
				System.out.println("Verification Membre");
				verificationMembre();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "6":
				System.out.println("Adhesion Pro");
				ajoutPro();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "7":
				System.out.println("Retrouver Numero Pro");
				retrouverPro();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "8":
				System.out.println("Consultation Seances");
				consultationSeances();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "9":
				System.out.println("Inscription Seance");
				inscriptionSeance();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "10":
				System.out.println("Confirmer Seance");
				confirmationSeance();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "11":
				System.out.println("Ajouter Service");
				ajoutService();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "12":
				System.out.println("Mise a jour Service");
				modificationService();
				System.out.println("T�che termin�e, en attente de commande :");
			break;
			case "13":
				System.out.println("Supprimer service");
				suppressionService();
				System.out.println("T�che termin�e, en attente de commande :");
				break;
			case "Never Gonna Give You Up": // Commande secr�te qui d�clenche la proc�dure comptable, connue uniquement du manager"
				procedureSecrete();
				break;
			case "aide":
				System.out.println("Les commandes sont :");
				System.out.println("Tapez 1 pour Adh�sion Membre");
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
				System.out.println("Pour d�marrer la proc�dure comptable, le manager doit taper le mot de passe");
				break;
			case "exit":
				System.out.println("exit");
				running = false;
				break;
			default:
				System.out.println("Entr�e invalide, vous pouvez entrer la commande 'aide' afin d'avoir la liste des commandes possibles.");
				break;
			}
		}
		
	}
/**
 * 
 * @param numeroTel l'imput a v�rifier est un integer
 * @return ici un boolean validant la condition
 */
	public static boolean isInteger(String numeroTel) {
	    try { 
	        Integer.parseInt(numeroTel); 
	    } catch(NumberFormatException e) { 
	    	System.out.println("Input error, veuillez r�essayer");
	        return false; 
	    } catch(NullPointerException e) {
	    	System.out.print("Input error, veuillez r�essayer");
	        return false;
	    }
	    return true;
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant memberDBajout dans la database des personnes ainsi que dbp.generateMemberID pour cr�er un ID. 
	 */
	public static void ajoutMembre() {
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer le nom du nouveau membre");
		String input1 = sc.nextLine();
		System.out.println("Veuillez rentrer le pr�nom du nouveau membre");
		String input2 = sc.nextLine();
		System.out.println("Veuillez rentrer le num�ro de t�l�phone du nouveau membre");
		String input3 = sc.nextLine();
		isInteger(input3);
		System.out.println("Veuillez rentrer l'email du nouveau membre");
		String input4 = sc.nextLine();
		System.out.println("Veuillez rentrer les frais mensuels du nouveau membre");
		String input5 = sc.nextLine();
		isInteger(input5);
		Member newMember = new Member(input1,input2,Integer.parseInt(input3),input4,Integer.parseInt(input5),000);
		System.out.println("Est-ce que le client a pay� les frais d'inscriptions ? (R�pondre Y ou N)");
		String input6 = sc.nextLine();
		newMember.setIdMembre(dbp.generateMemberID());
		
		if(input6.equals("y") || input6.equals("Y")) {
			newMember.setStatus(true);
			if(dbp.memberDBajout(newMember)) {
				System.out.println("Compte Membre cr��. L'identifiant de membre est : " + newMember.getIdMembre());
			} else {
				System.out.println("Un compte existe d�j�");
			}
		} else if(input6.equals("n") || input6.equals("N")) {
			System.out.println("Membre non sauvegard�.");
		} else {
			System.out.println("Entr�e invalide, op�ration avort�e");
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant memberModification dans la database des personnes pour modifier une entr�e de membre. 
	 */
	public static void modificationMembre() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'identifiant du membre � retrouver ");
		String input1 = sc.nextLine();
		System.out.println("Veuillez rentrer le num�ro de t�l�phone du membre");
		String input2 = sc.nextLine();
		isInteger(input2);
		System.out.println("Veuillez rentrer l'email du membre");
		String input3 = sc.nextLine();
		System.out.println("Veuillez rentrer les frais mensuels du membre");
		String input4 = sc.nextLine();
		isInteger(input4);
		if(dbp.memberModification(input1, input2, input3, input4)) {
			System.out.println("Modification effectu�e");
		} else {
			System.out.println("Modification �chou�e");

		}
	}	
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant memberSuppression dans la database des personnes pour supprimer une entr�e de membre. 
	 */
	public static void suppressionMembre() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer num�ro d'identifiant du membre � supprimer : ");
		String input1 = sc.nextLine();
		if(dbp.memberSuppression(input1)) {
			System.out.println("Membre : " + input1 + " Supprim� ");
		} else {
			System.out.println("Membre "+ input1 +" non trouv�, Suppression non effectu�e.");
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant retrieveID dans la database des personnes pour retrouver une entr�e de membre. 
	 */
	public static void retrouverMembre() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'email du membre � retrouver : ");
		String input1 = sc.nextLine();
		String answer = dbp.retrieveID(input1,1);
		if(answer == null) {
			System.out.println("Email ne correspondant a aucun membre ");
		} else {
			System.out.println("Email correspondant au membre " + answer);
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant memberVerification dans la database des personnes pour v�rifier une entr�e de membre. 
	 */
	public static void verificationMembre() {
		System.out.println("Veuillez rentrer num�ro d'identifiant du membre � v�rifier : ");
		String inputIDmembre = sc.nextLine();
		dbp.memberVerification(inputIDmembre);
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant proDBajout dans la database des personnes ainsi que generateProID pour cr�er un ID. 
	 */
	public static void ajoutPro() {
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer le nom du nouveau professionel");
		String input1 = sc.nextLine();
		System.out.println("Veuillez rentrer le pr�nom du nouveau professionel");
		String input2 = sc.nextLine();
		System.out.println("Veuillez rentrer le num�ro de t�l�phone du nouveau professionel");
		String input3 = sc.nextLine();
		isInteger(input3);
		System.out.println("Veuillez rentrer l'email du nouveau professionel");
		String input4 = sc.nextLine();
		System.out.println("Veuillez rentrer la discipline du nouveau membre");
		String input5 = sc.nextLine();
		int idP = dbp.generateProID();
		Professionnel newPro = new Professionnel(input1,input2,Integer.parseInt(input3),input4,input5,idP);
		if(dbp.proDBajout(newPro)) {
			System.out.println("Compte Pro cr��. L'identifiant de pro est : " + idP);
		} else {
			System.out.println("Un compte existe d�j�");
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant retrieveID dans la database des personnes afin de retrouver un ID. 
	 */
	public static void retrouverPro() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'email du professionel � retrouver : ");
		String input1 = sc.nextLine();
		String answer = dbp.retrieveID(input1,2);
		if(answer == null) {
			System.out.println("Email ne correspondant a aucun professionel ");
		} else {
			System.out.println("Email correspondant au professionel " + answer);
		}
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant serviceDBajout dans la database des Services et S�ances afin de cr�er et enregistrer un service. 
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
		System.out.println("Veuillez rentrer la date de d�but du service au format DD/MM/YYYY :");
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
		System.out.println("Veuillez rentrer, s�par� par une virgule, les chiffres correspondants aux jours de la semaine a laquelle l'activit� sera r�currente :");
		System.out.println("Exemple : Pour Lundi, Vendredi et Dimanche : 1,5,7");
		sc = new Scanner(System.in);
		String inputAgent = sc.nextLine();
		Integer[] recurrence = Arrays.stream(Arrays.stream(inputAgent.split(",")).mapToInt(Integer::parseInt).toArray() ).boxed().toArray( Integer[]::new );
	
		System.out.println("Veuillez rentrer la capacit� maximale : ");
		int maxCapacity = sc.nextInt();
		System.out.println("Veuillez rentrer les frais de service : ");
		int serviceFee = sc.nextInt();
		Service newService = new Service(currentTime,startTime,lastTime,serviceHour,recurrence,maxCapacity,serviceFee,inputIDPro,000);
		if(dbs.serviceDBajout(newService,dbp.listePros)) {
			newService.setServiceCode(dbs.generateServiceCode());
			System.out.println("Service cr��. Le code de service est : " + newService.getServiceCode());
		} else {
			System.out.println("Un service existe d�j�");
		}
		
	}
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant serviceModification dans la database des Services et S�ances afin de modifier un service. 
	 */
	public static void modificationService() {
		LocalDate lastTime = null;
		LocalTime serviceHour = null;
		sc  = new Scanner(System.in); 
		System.out.println("Veuillez rentrer l'ID du professionel qui souhaite effectuer une modification de service :");
		int inputIDPro = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez rentrer le code du service � modifier :");
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
		System.out.println("Veuillez rentrer, s�par� par une virgule, les chiffres correspondants aux jours de la semaine a laquelle l'activit� sera r�currente :");
		System.out.println("Exemple : Pour Lundi, Vendredi et Dimanche : 1,5,7");
		sc = new Scanner(System.in);
		String inputAgent = sc.nextLine();
		Integer[] recurrence = Arrays.stream(Arrays.stream(inputAgent.split(",")).mapToInt(Integer::parseInt).toArray() ).boxed().toArray( Integer[]::new );
		System.out.println("Veuillez rentrer la capacit� maximale : ");
		int maxCapacity = sc.nextInt();
		System.out.println("Veuillez rentrer les frais de service : ");
		int serviceFee = sc.nextInt();
		
		if(dbs.serviceModification(inputIDPro, serviceCode, lastTime, serviceHour, recurrence,maxCapacity,serviceFee)) {
			System.out.println("Modification effectu�e");
		} else {
			System.out.println("Modification �chou�e");
		}
	}	
	
	/**
	 * M�thode prenant les inputs de l'utilisateur et appelant serviceSuppression dans la database des Services et S�ances afin de supprimer un service. 
	 */
	public static void suppressionService() {
		sc = new Scanner(System.in); 
		System.out.println("Veuillez rentrer le code du service � supprimer : ");
		int input1 = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez rentrer l'identifiant de pro correspondant : ");
		int input2 = Integer.parseInt(sc.nextLine());
		
		if(dbs.serviceSuppression(input1, input2)) {
			System.out.println("Service : " + input1 + " Supprim� ");
		} else {
			System.out.println("Service "+ input1 +" non supprim�, veuillez v�rifier le code de service et l'identifiant de pro.");
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
		System.out.println("Veuillez rentrer l'identifiant de membre");
		int input1 = Integer.parseInt(sc.nextLine());
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
	 * M�thode prenant les inputs de l'utilisateur et appelant memberVerification dans la database des personnes et confirmSeance dans la database des Services et S�ances afin de confirmer l'inscription d'un membre � une s�ance. 
	 */
	public static void confirmationSeance() {
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
	
	/**
	 * M�thode cens�e lancer la proc�dure comptable : Pas faite, manque de temps, sorry !
	 */
	public static void procedureSecrete() {
		System.out.println("Bienvenue, Manager Rick Astley.");
		System.out.println("Proc�dure comptable enclench�e");
		//dbs.procedureComptable();
	}

}