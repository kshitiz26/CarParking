package com.elsevier.carParking.repository;

import org.springframework.stereotype.Repository;
import com.elsevier.carParking.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {

}
