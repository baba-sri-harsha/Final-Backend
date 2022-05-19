package com.payingguest.repository;

import com.payingguest.model.Booking;
import com.payingguest.model.PgDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPgDetailsRepository extends JpaRepository<PgDetails, Integer> {

    @Query("from PgDetails p where p.bookingTime>=?1")
    List<PgDetails> findByDateGreaterThan(LocalDateTime bookingDateTime);

    @Query("from PgDetails p where p.bookingTime<=?1")
    List<PgDetails>findByDateLessThan(LocalDateTime bookingDateTime);

    @Query("from PgDetails p where p.bookingTime between ?1 and ?2")
    List<PgDetails>findBookingsBetween(LocalDateTime fromDate ,LocalDateTime toDate);






}
