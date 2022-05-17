package com.payingguest.Controller;

import java.util.*;

import com.payingguest.model.Address;
import com.payingguest.model.Booking;
import com.payingguest.model.Customer;
import com.payingguest.model.PayingGuest;
import com.payingguest.service.IPayingGuestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("paying-guest-api")
public class PayingGuestController {

    private IPayingGuestService iPayingGuestService;

    public PayingGuestController(IPayingGuestService iPayingGuestService) {
        this.iPayingGuestService = iPayingGuestService;
    }

    @PostMapping("/paying-guests")
    public PayingGuest addPayingGuest(@RequestBody PayingGuest pg) {
        Set<Booking> bookings = pg.getBookings();
        List<Booking> bookingList = new ArrayList<>(bookings);
        bookings.forEach(b -> b.getCustomer().setBookings(bookingList));
        return iPayingGuestService.addPayingGuest(pg);
    }

    @GetMapping("/paying-guests")
    public List<PayingGuest> getAll() {
        return iPayingGuestService.getAll();
    }

}
