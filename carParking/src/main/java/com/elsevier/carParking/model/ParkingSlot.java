package com.elsevier.carParking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParkingSlot {
	@Id
	@GeneratedValue
	private int slotId;
	private boolean isAvailable;
	
	public int getSlotId() {
		return slotId;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
