package com.elsevier.carParking.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elsevier.carParking.exception.CarParkingException;
import com.elsevier.carParking.model.Reservation;

import lombok.NonNull;

@Component
public class CarParkingUtils {

	private Reservation reservation;
	
	private final Map<Integer, Reservation> mapUsedSpaces = new HashMap<>();
	
	@NonNull private Integer capacity;
	
	private static final int PARKING_LOT_FULL_CODE = -1;
	
	public CarParkingUtils() {
		this.capacity = 0;
	}

	public CarParkingUtils(int capacity) {
		this.capacity = capacity;
	}
	
		/**
		 * Prints current status of the car parking
		 * 
		 * @return String
		 */
		public String printStatus() {
			StringBuilder sb = new StringBuilder();
			
			sb.append("Slot No.  Registration No.\n");
			mapUsedSpaces.forEach( 
					(slotId, reservations) -> sb.append(slotId)
												.append("\t")
												.append(reservations.getRegistrationNumber())
												.append("\n")
												);
			System.out.println(sb);

			return sb.toString();

		}
		
		/**
		 * Gets the total used capacity
		 * 
		 * @return used capacity
		 */
		private int getUsedCapacity() {
			return mapUsedSpaces.size();
		}
		
		/**
		 * Gets first free slot
		 * 
		 * @return slot-id
		 */
		private int getFirstFreeSlot() {
			for (int slotId = 1; slotId <= capacity; slotId++) {
				if ( !mapUsedSpaces.containsKey(slotId) )
					return slotId;
			}
			return PARKING_LOT_FULL_CODE;
		}
		
		/**
		 * Allocates slotId to the car
		 * 
		 * @param registrationNumber
		 * @return allocated slotId
		 */
		public int addCar(String registrationNumber) {
			if (getUsedCapacity() >= capacity) {
				return PARKING_LOT_FULL_CODE;
			}
			
			int slotId = getFirstFreeSlot();
			
			Reservation reserve = new Reservation(slotId, registrationNumber);
			mapUsedSpaces.put(slotId, reserve);
			
			return slotId;
		}
		
		/**
		 * Releases slotId reserved by the car
		 * 
		 * @param registrationNumber
		 * @param numHours
		 * @return totalParkedHours
		 * @throws CarParkingException
		 */
		public Reservation removeCar(String registrationNumber, float numHours) throws CarParkingException {
			reservation =  
						mapUsedSpaces.values()
						.stream()
						.filter(ticket -> ticket.getRegistrationNumber().equals(registrationNumber))
						.findFirst()
						.orElseThrow( ()->new CarParkingException("Registration number not found: " + registrationNumber));
			
			reservation.setParkingTime_Hours(numHours);
			
			int slotId = reservation.getSlotId();
			mapUsedSpaces.remove(slotId);
			
			return reservation;
		}

}
