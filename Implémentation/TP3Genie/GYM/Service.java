package GYM;
/**
 * Classe représentant un service
 * @author Simo Hakim et Ming Xia Delvas
 */
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class Service {
	
	protected LocalDateTime currentTime; LocalDate startTime; LocalDate lastTime; LocalTime serviceHour; Integer[] recurrence; int maxCapacity; int serviceFee; int idPro; int serviceCode;

	public Service(LocalDateTime currentTime, LocalDate startTime, LocalDate lastTime, LocalTime serviceHour, Integer[] recurrence, int maxCapacity, int serviceFee, int idPro, int serviceCode) {
		this.currentTime = currentTime;
		this.startTime = startTime;
		this.lastTime = lastTime;
		this.serviceHour = serviceHour;
		this.recurrence = recurrence;
		this.maxCapacity = maxCapacity;
		this.idPro = idPro;
		this.serviceCode = serviceCode;
	}
	
	public void setCurrentTime(LocalDateTime currentTime) {
		this.currentTime = currentTime;
	}
	public LocalDateTime getCurrentTime() {
		return currentTime;
	}
	
	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getStartTime() {
		return startTime;
	}	

	public void setLastTime(LocalDate lastTime) {
		this.lastTime = lastTime;
	}
	
	public LocalDate getLastTime() {
		return lastTime;
	}	

	public void setServiceHour(LocalTime serviceHour) {
		this.serviceHour = serviceHour;
	}

	public LocalTime getServiceHour() {
		return serviceHour;
	}
	
	public void setRecurrence(Integer[] recurrence) {
		this.recurrence = recurrence;
	}

	public Integer[] getRecurrence() {
		return recurrence;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public int getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(int serviceFee) {
		this.serviceFee = serviceFee;
	}
	
	public int getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(int serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	public int getIdPro() {
		return idPro;
	}
	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

}
