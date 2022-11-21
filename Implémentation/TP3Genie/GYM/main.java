package GYM;
/**
 * Méthode servant à choisir l'interface utilisateur
 * @author Simo Hakim et Ming Xia Delvas
 */
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("Press M for the Mobile interface or D for the desktop one");
				String choice = sc.nextLine();
				if(choice.equals("m") || choice.equals("M")) {
					Mobile.start();
				} else if(choice.equals("d") || choice.equals("D")) {
					GYM.start();
				} else {
					System.out.println("Invalid Choice. Please Retry");
				}		
			}
		}
}