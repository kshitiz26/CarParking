package com.elsevier.carParking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarParking {
	@Id
	@GeneratedValue
	private int id;
	
	private int capacity;
	
	public int getId() {
		return id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
