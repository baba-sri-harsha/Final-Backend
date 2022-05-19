package com.payingguest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class PgDetails {

    @Id
    private Integer bookingId;
    private String name;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDateTime bookingTime;
    private String pgGender;
    private String customerId;
    private int paying_guest_id;


}
