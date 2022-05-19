package com.payingguest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @ManyToOne
    @JoinColumn(name = "paying_guest_id")
    @JsonIgnore
    private PayingGuest payingGuest;


}
