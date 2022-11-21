package GYM;
/**
 * Classe représentant un membre
 * @author Simo Hakim et Ming Xia Delvas
 */
public class Member extends Person {

	private int fraisMensuel; int montantDu = 0; int idMembre; int fraisDus; boolean status; 
	
	public Member(String nom, String prenom, int tel, String email, int fraisMensuel, int idMembre) {
		super(nom,prenom,tel,email);
		this.fraisMensuel = fraisMensuel;
		this.idMembre = idMembre;
	}
	

	public int getIdMembre() {
		return idMembre;
	}
	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}
	public int getMontantDu() {
		return montantDu;
	}
	public void setMontantDu(int montantDu) {
		this.montantDu = montantDu;
	}
	public int getFraisMensuel() {
		return fraisMensuel;
	}
	public void setFraisMensuel(int fraisMensuel) {
		this.fraisMensuel = fraisMensuel;
	}
	public int getFraisDus() {
		return fraisDus;
	}
	public void setFraisDus(int fraisDus) {
		this.fraisDus = fraisDus;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status; // True = suspendu , false is not
	}
}