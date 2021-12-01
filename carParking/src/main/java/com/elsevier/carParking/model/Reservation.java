package com.elsevier.carParking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private int reservationId;
	private int slotId;
	private String registrationNumber;
	private float parkingTime_Hours;
	
	public Reservation(int slotId, String registrationNumber) {
		this.slotId = slotId;
		this.registrationNumber = registrationNumber;
	}
	
	public int getReservationId() {
		return reservationId;
	}
	public int getSlotId() {
		return slotId;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public float getParkingTime_Hours() {
		return parkingTime_Hours;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public void setParkingTime_Hours(float parkingTime_Hours) {
		this.parkingTime_Hours = parkingTime_Hours;
	}

}
