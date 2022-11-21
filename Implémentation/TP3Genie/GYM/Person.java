package GYM;

/**
 * Classe abstraite d'une personne
 * @author Simo Hakim et Ming Xia Delvas
 *
 */
public abstract class Person {

	protected String nom; String prenom; int tel; String email;

	public Person(String nom, String prenom, int tel, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
}