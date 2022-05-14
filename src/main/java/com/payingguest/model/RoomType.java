package com.payingguest.model;

public enum RoomType {
    AC("A/C"),
    NONAC("NON-A/C");

    private String roomType;

    RoomType(String roomType) {
        this.roomType = roomType;
    }
}
