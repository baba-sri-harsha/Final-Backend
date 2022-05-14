package com.payingguest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(generator = "address_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_generator",sequenceName = "address_sequence",initialValue = 1,allocationSize = 1)
    private Integer addressId;

    private String address;

    private String location;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "paying_guest_id")
    private PayingGuest payingGuest;





}
