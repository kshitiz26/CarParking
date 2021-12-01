package com.elsevier.carParking.service;

import com.elsevier.carParking.exception.CarParkingException;
import com.elsevier.carParking.model.Reservation;

public interface CarParkingService {

	/**
	 * creates car parking of specified capacity
	 *  
	 * @param size
	 */
	void createParkingLot(int size);
	
	/**
	 * Allocates slotId to car
	 * 
	 * @param registrationNumber
	 * @return slotId
	 */
	int parkCar(String registrationNumber);
	
	/**
	 * Releases slotId reserved by the car
	 * 
	 * @param registrationNumber
	 * @param hoursParked
	 * @return totalParkingHours
	 * @throws CarParkingException
	 */
	Reservation removeCar(String registrationNumber, float hoursParked) throws CarParkingException;
	
	/**
	 * Gets Parking Status
	 * @return String
	 */
	String getStatus();
	
	/**
	 * Extends allocated time
	 * @param registrationNumber
	 * @param time
	 * @return totalParkingTime
	 */
	Reservation extendParkTime(String registrationNumber, float time);
}
