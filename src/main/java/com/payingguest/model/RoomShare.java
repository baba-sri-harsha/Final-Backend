package com.payingguest.model;

public enum RoomShare {

    ONE("One share"),
    TWO("Two share"),
    THREE("Three share"),
    FOUR("Four Share");

    private String shareType;

    RoomShare(String shareType) {
        this.shareType = shareType;
    }
}
