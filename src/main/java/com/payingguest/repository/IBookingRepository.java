package com.payingguest.repository;

import com.payingguest.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepository  extends JpaRepository<Booking , Integer> {

}
