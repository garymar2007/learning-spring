package com.gary.springboot.learningspring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Iterator;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
