package com.elsevier.carParking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsevier.carParking.exception.CarParkingException;
import com.elsevier.carParking.model.Reservation;
import com.elsevier.carParking.service.CarParkingService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class CarParkingController {
	
	@Autowired
	CarParkingService carParkingService;
	
	/**
	 * Gets Parking Status
	 * 
	 * @return String
	 */
	@GetMapping("status")
	public String getStatus() {
		return carParkingService.getStatus();
	}
	
	/**
	 * creates car parking of specified capacity
	 *  
	 * @param size
	 */
	@GetMapping("create/{size}")
	public void createParkingLot(@PathVariable("size") int size) {
		carParkingService.createParkingLot(size);
	}
	
	/**
	 * Allocates slotId to car
	 * 
	 * @param registrationNumber
	 * @return slotId
	 */
	@GetMapping(path = "parkCar/{registrationNumber}")
	public int parkCar(@PathVariable("registrationNumber") String registrationNumber ) {
		return carParkingService .parkCar(registrationNumber);
	}
	
	/**
	 * Extends allocated time
	 * @param registrationNumber
	 * @param time
	 * @return totalParkingTime
	 */
	@GetMapping(path = "extend/{registrationNumber}/{hours}")
	public Reservation extendParkTime(@PathVariable("registrationNumber") String registrationNumber,
								@PathVariable("hours") float time) throws CarParkingException {
		return carParkingService.extendParkTime(registrationNumber, time);
	}
	
	/**
	 * Releases slotId reserved by the car
	 * 
	 * @param registrationNumber
	 * @param hoursParked
	 * @return totalParkingHours
	 * @throws CarParkingException
	 */
	@GetMapping(path = "leave/{registrationNumber}/{hours}")
	public Reservation removeCar(@PathVariable("registrationNumber") String registrationNumber,
								@PathVariable("hours") float time) throws CarParkingException {
		return carParkingService.removeCar(registrationNumber, time);
	}

	@RequestMapping(value = { "/", " ", "index" })
	public String index() {
		return " Welcome to the Parking Lot ";
	}

	@GetMapping("hello")
	public String sayHello() {
		return "HELLO! ";
	}
}
