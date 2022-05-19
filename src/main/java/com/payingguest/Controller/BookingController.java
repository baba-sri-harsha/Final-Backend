package com.payingguest.Controller;

import com.payingguest.model.Booking;
import com.payingguest.model.Customer;
import com.payingguest.model.PgDetails;
import com.payingguest.service.IBookingService;


import com.payingguest.service.IPgDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;



@RestController
@RequestMapping("booking-api")
public class BookingController {

    private IBookingService bookingService;
    @Autowired
    public void setBookingService(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    private IPgDetailsService pgDetailsService;
    @Autowired
    public void setPgDetailsService(IPgDetailsService pgDetailsService) {
        this.pgDetailsService = pgDetailsService;
    }



//        @PutMapping("/update-booking/")
//    ResponseEntity<Void>updateBooking(@RequestBody Booking booking){
//        Customer customer = booking.getCustomer();
//        List<Booking> bookingSet = new ArrayList<Booking>();
//        bookingSet.add(booking);
//        customer.setBookings(bookingSet);
//        bookingService.updateBooking(booking);
//        HttpHeaders headers= new HttpHeaders();
//        headers.add("desc","updating booking ");
//        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
//    }


    @PostMapping("/add-booking/payingGuestId/{payingGuestId}/customerId/{customerId}")
    ResponseEntity<Void> addBooking(@RequestBody Booking booking,@PathVariable("payingGuestId") int payingGuestId,@PathVariable("customerId") int customerId) {
        bookingService.addBooking(booking,payingGuestId,customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating booking ");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }



//    @PutMapping("/update-booking/")
//    ResponseEntity<Void> updateBooking(@RequestBody Booking booking) {
//        Customer customer = booking.getCustomer();
//        List<Booking> bookingSet = new ArrayList<Booking>();
//        bookingSet.add(booking);
//        customer.setBookings(bookingSet);
//        bookingService.updateBooking(booking);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("desc", "updating booking ");
//        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
//    }

    @GetMapping("/bookingId/{bookingId}")
    ResponseEntity<Booking> getBookingById(@PathVariable("bookingId") int bookingId) {
        Booking booking = bookingService.getById(bookingId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get  booking by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(booking);
    }

    @GetMapping("/pgDetails/bookings-after/date/{date}")
    ResponseEntity<List<PgDetails>>BookingsAfterDate(@PathVariable("date")String date){
        String dateTime2=date+"T00:00:00.000";
        LocalDateTime dateTime1= LocalDateTime.parse(dateTime2);
        List<PgDetails>  pgDetails= pgDetailsService.getByDateGreaterThan(dateTime1);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get  booking by dates after");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(pgDetails);
    }

    @GetMapping("/pgDetails/bookings-before/date/{date}")
    ResponseEntity<List<PgDetails>>Bookings(@PathVariable("date")String date){
        String dateTime2=date+"T00:00:00.000";
        LocalDateTime dateTime1= LocalDateTime.parse(dateTime2);
        List<PgDetails>  pgDetails= pgDetailsService.getByDateLessThan(dateTime1);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get  booking by dates before");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(pgDetails);
    }

}
