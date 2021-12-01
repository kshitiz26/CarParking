package com.elsevier.carParking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.elsevier.carParking.exception.CarParkingException;
import com.elsevier.carParking.model.Reservation;
import com.elsevier.carParking.util.CarParkingUtils;

@Service
public class CarParkingServiceImpl implements CarParkingService{

	@Lazy
	private CarParkingUtils parkingLot; 
	
	@Autowired
	public CarParkingServiceImpl(CarParkingUtils parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	/**
	 * creates car parking of specified capacity
	 *  
	 * @param size
	 */
	@Override
	public void createParkingLot(int size) {
		parkingLot = new CarParkingUtils(size);  	// parkingLot should be injected?    also need a DAO layer?
	}
	
	/**
	 * Allocates slotId to car
	 * 
	 * @param registrationNumber
	 * @return slotId
	 */
	@Override
	public int parkCar(String registrationNumber) {
		return parkingLot.addCar(registrationNumber);
	}
	
	/**
	 * Releases slotId reserved by the car
	 * 
	 * @param registrationNumber
	 * @param hoursParked
	 * @return totalParkingHours
	 * @throws CarParkingException
	 */
	@Override
	public Reservation removeCar(String registrationNumber, float hoursParked) 
			throws CarParkingException {
			return parkingLot.removeCar(registrationNumber, hoursParked);
	}
	
	/**
	 * Gets Parking Status
	 * @return String
	 */
	@Override
	public String getStatus() {
		return parkingLot.printStatus();
	}
	
	/**
	 * Extends allocated time
	 * @param registrationNumber
	 * @param time
	 * @return totalParkingTime
	 */
	@Override
	public Reservation extendParkTime(String registrationNumber, float time) {
		
		return null;
	}
}
