package GYM;
/**
 * Classe représentant un professionel
 * @author Simo Hakim et Ming Xia Delvas
 */
public class Professionnel extends Person {

	private String discipline; int montantAVerser = 0; int idPro;
	
	public Professionnel(String nom, String prenom, int tel, String email, String discipline, int idPro) {
		super(nom,prenom,tel,email);
		this.discipline = discipline;
		this.idPro = idPro;
	}
	
	public int getIdPro() {
		return idPro;
	}
	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}
	public int getMontantAVerser() {
		return montantAVerser;
	}
	public void setMontantAVerser(int montantAVerser) {
		this.montantAVerser = montantAVerser;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
}