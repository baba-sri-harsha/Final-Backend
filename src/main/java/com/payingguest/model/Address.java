package com.payingguest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    private String state;

    @Column(length = 20)
    private String country;



}
