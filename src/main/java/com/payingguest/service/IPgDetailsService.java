package com.payingguest.service;

import com.payingguest.Exceptions.BookingNotFoundException;
import com.payingguest.model.Booking;
import com.payingguest.model.PgDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IPgDetailsService   {


    List<PgDetails> getByDateGreaterThan(LocalDateTime bookingDateTime) throws BookingNotFoundException;

    List<PgDetails>getByDateLessThan(LocalDateTime bookingDateTime) throws  BookingNotFoundException;

    List<PgDetails>getBookingsBetween(LocalDateTime fromDate ,LocalDateTime toDate) throws BookingNotFoundException;






}
