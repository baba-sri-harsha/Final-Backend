package com.payingguest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayingGuest {

    @Id
    @GeneratedValue(generator = "pg_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "pg_generator", sequenceName = "pg_sequence", initialValue = 1, allocationSize = 1)
    private Integer payingGuestId;

    @Column(length = 40)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private PgGender pgGender;

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Category category;

    private int rating;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "payingGuest")
    private Set<Booking> bookings;

    @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "payingGuest")
    private Set<Room> rooms;




}
