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
public class Room {

    @Id
    @GeneratedValue(generator = "room_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "room_generator", sequenceName = "room_sequence", initialValue = 1, allocationSize = 1)
    private Integer roomId;

    @Enumerated(EnumType.STRING)
    private RoomShare roomShare;

    private int availableBeds;

    private double price;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "paying_guest_id")
    private PayingGuest payingGuest;

    @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "room")
    private Set<Booking> bookings;

}
