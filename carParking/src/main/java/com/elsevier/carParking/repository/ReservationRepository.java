package com.elsevier.carParking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elsevier.carParking.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
