package com.payingguest.Controller;

import com.payingguest.model.Booking;
import com.payingguest.model.Customer;
import com.payingguest.service.IBookingService;

import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.*;
import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("booking-api")
public class BookingController {

    private IBookingService bookingService;

    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PutMapping("/update-booking")
    ResponseEntity<Void>updateBooking(@RequestBody Booking booking){
        Customer customer = booking.getCustomer();
        List<Booking> bookingSet = new ArrayList<Booking>();
        bookingSet.add(booking);
        customer.setBookings(bookingSet);
        bookingService.updateBooking(booking);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","updating booking ");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/bookingId/{bookingId}")
    ResponseEntity<Booking>getBookingById(@PathVariable("bookingId")int bookingId ){
        Booking booking= bookingService.getById(bookingId);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get  booking by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(booking);
    }
}
