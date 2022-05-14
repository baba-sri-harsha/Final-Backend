package com.payingguest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(generator = "booking_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "booking_generator",sequenceName = "booking_sequence",initialValue = 1,allocationSize = 1)
    private Integer bookingId;

    private LocalDateTime bookingTime;

    private Date fromDate;

    private Date toDate;

    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "paying_guest_id")
    private PayingGuest payingGuest;

    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
