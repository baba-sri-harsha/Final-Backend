package com.payingguest.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(generator = "customer_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_sequence", initialValue = 1, allocationSize = 1)
    private Integer customerId;

    @Column(length = 30)
    private String customerName;

    private String mobileNumber;

    private String idProof;

    private String idNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "paying_guest_id")
    private List<Booking> bookings;


}
