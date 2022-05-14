package com.payingguest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "customer_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_sequence", initialValue = 1, allocationSize = 1)
    private Integer customerId;

    private String customerName;

    private String mobileNumber;

    private String idProof;

    private String idNumber;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "customer")
    private Set<Booking> bookings;




}
