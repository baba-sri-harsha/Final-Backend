package com.payingguest.service;


import com.payingguest.model.Customer;

public interface ICustomerService {


    Customer addCustomer(Customer customer);
    void updateCustomer(int id);
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
