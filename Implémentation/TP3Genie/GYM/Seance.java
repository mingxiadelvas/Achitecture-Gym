package GYM;
/**
 * Classe représentant une séance
 * @author Simo Hakim et Ming Xia Delvas
 */
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Seance {

	protected LocalDateTime creationDate; LocalDate serviceDay; int idPro; int memberID; int serviceCode; boolean confirmation = false;

	public Seance(LocalDate serviceDay, int idPro, int memberID, int serviceCode) {
		this.creationDate = LocalDateTime.now();
		this.serviceDay = serviceDay;
		this.memberID = memberID;
		this.idPro = idPro;
		this.serviceCode = serviceCode;
	}
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	public void setServiceDay(LocalDate serviceDay) {
		this.serviceDay = serviceDay;
	}

	public LocalDate getServiceDay() {
		return serviceDay;
	}

	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	public int getIdPro() {
		return idPro;
	}
	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}
	
	public int getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(int serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	public boolean getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}


}
