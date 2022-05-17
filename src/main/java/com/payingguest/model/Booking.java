package com.payingguest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {

    @Id
    @GeneratedValue(generator = "booking_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "booking_generator",sequenceName = "booking_sequence",initialValue = 1,allocationSize = 1)
    private Integer bookingId;

    private LocalDateTime bookingTime;

    private LocalDate fromDate;

    private LocalDate toDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade =CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "paying_guest_id")
    private PayingGuest payingGuest;

    @ManyToOne(cascade =CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Booking(Integer bookingId, LocalDateTime bookingTime, LocalDate fromDate, LocalDate toDate, Status status, Customer customer) {
        this.bookingId = bookingId;
        this.bookingTime = bookingTime;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = status;
        this.customer = customer;
    }

//    public String toString(){
//        return "hello";
//    }
}
