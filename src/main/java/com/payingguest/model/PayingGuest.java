package com.payingguest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PayingGuest {

    @Id
    @GeneratedValue(generator = "pg_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "pg_generator", sequenceName = "pg_sequence", initialValue = 1, allocationSize = 1)
    private Integer payingGuestId;

    @Column(length = 40)
    private String name;

    @Enumerated(EnumType.STRING)
    private PgGender pgGender;

    @Column(length = 25)
    private String category;

    private int rating;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "paying_guest_id")
    private Set<Room> rooms;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "paying_guest_id")
    @JsonIgnore
    private Set<Booking> bookings;

    public PayingGuest(String name, PgGender pgGender, String category, int rating, Address address, Set<Room> rooms) {
        this.name = name;
        this.pgGender = pgGender;
        this.category = category;
        this.rating = rating;
        this.address = address;
        this.rooms = rooms;
    }

}
