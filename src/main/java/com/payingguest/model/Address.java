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

    @Column(length = 30)
    private String doorNumber;

    @Column(length = 30)
    private String streetName;

    @Column(length = 30)
    private  String landMark;

    @Column(length = 25)
    private String city;

    @Column(length = 20)
    private String sate;

    @Column(length = 20)
    private String country;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "paying_guest_id")
    private PayingGuest payingGuest;





}
