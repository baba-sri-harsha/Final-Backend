package com.payingguest.service;


import com.payingguest.model.Booking;

public interface IBookingService {

    /**
     * @param booking
     * @param payingGuestId
     * @param customerId
     */
    void addBooking(Booking booking,int payingGuestId,int customerId);

    /**
     * @param booking
     */
    void updateBooking(Booking booking);

    /**
     *
     * @param id
     * @return Booking
     */
    Booking getById(int id);

//    void addPayingGuest(PayingGuest payingGuest);
//    void deletePayingGuest(int payingGuestId);
//    void updatePayingGuest(PayingGuest payingGuest);
//
//    List<PayingGuest> findByCity(String city);
//    List<PayingGuest>findByPayingGuestId(int payingGuestId);
//    List<PayingGuest>findBYPayingGuestName(String name);
//    List<PayingGuest>findByPayingGuestType(String type);
//
//    List<PayingGuest>findPayingGuestByRoomShareAndCity(Share share,String city);


}
