package com.payingguest.repository;

import com.payingguest.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

    @Query("from Booking b inner join b.customer c where c.customerId= ?1")
    List<Booking> findBookings(int customerId);

}
