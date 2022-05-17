package com.payingguest.service;

import java.util.*;
import com.payingguest.Exceptions.PayingGuestNotFoundException;
import com.payingguest.model.PayingGuest;
import org.springframework.data.jpa.repository.Query;

public interface IPayingGuestService  {

    PayingGuest addPayingGuest(PayingGuest payingGuest);

    void deletePayingGuest(int payingGuestId);

    void updatePayingGuest(PayingGuest payingGuest);

    List<PayingGuest> getAll();

    PayingGuest getByPayingGuestId(int id) throws PayingGuestNotFoundException;

    List<PayingGuest>getByName(String name) throws PayingGuestNotFoundException ;

    List<PayingGuest>getByPgGender(String pgGender) throws PayingGuestNotFoundException;

    List<PayingGuest>getByCategory(String category) throws PayingGuestNotFoundException;

    List<PayingGuest>getByRating(int rating) throws PayingGuestNotFoundException;

    List<PayingGuest> getByCityStartingWith(String city) throws PayingGuestNotFoundException;

    List<PayingGuest> getByCityAndName(String city, String name) throws PayingGuestNotFoundException;

    List<PayingGuest> getByCityAndRating(String city, int rating) throws PayingGuestNotFoundException;

    //admin
    List<PayingGuest>getByAddressId(int addressId) throws PayingGuestNotFoundException;

    List<PayingGuest>getByCityAndLandMark(String city,String landMark) throws PayingGuestNotFoundException;

}
