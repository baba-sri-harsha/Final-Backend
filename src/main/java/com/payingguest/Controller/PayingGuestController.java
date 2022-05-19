package com.payingguest.Controller;

import java.util.*;

import com.payingguest.model.PayingGuest;
import com.payingguest.service.IPayingGuestService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("paying-guest-api")
public class PayingGuestController {

    private IPayingGuestService iPayingGuestService;

    public PayingGuestController(IPayingGuestService iPayingGuestService) {
        this.iPayingGuestService = iPayingGuestService;
    }

//    @PostMapping("/paying-guests")
//    public PayingGuest addPayingGuest(@RequestBody PayingGuest pg) {
//        Set<Booking> bookings = pg.getBookings();
//        List<Booking> bookingList = new ArrayList<>(bookings);
//        bookings.forEach(b -> b.getCustomer().setBookings(bookingList));
//        return iPayingGuestService.addPayingGuest(pg);
//    }

    @DeleteMapping("/paying-guests/payingGuestId/{payingGuestId}")
    ResponseEntity<Void> deletePayingGuestId(@PathVariable("payingGuestId") int payingGuestId) {
        iPayingGuestService.deletePayingGuest(payingGuestId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by payingGuestId");
        return ResponseEntity.ok().headers(headers).build();
    }

    @GetMapping("/paying-guests")
    public List<PayingGuest> getAll() {
        return iPayingGuestService.getAll();
    }


    @GetMapping("/paying-guests/payingGuestId/{payingGuestId}")
    ResponseEntity<PayingGuest> showByPayingGuestId(@PathVariable("payingGuestId") int payingGuestId) {
        PayingGuest payingGuest = iPayingGuestService.getByPayingGuestId(payingGuestId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by payingGuestId");
        return ResponseEntity.ok().headers(headers).body(payingGuest);
    }

    @GetMapping("/paying-guests/name/{name}")
    ResponseEntity<List<PayingGuest>> showByName(@PathVariable("name") String name) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByName(name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by payingGuest name");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }

    @GetMapping("/paying-guests/category/{category}")
    ResponseEntity<List<PayingGuest>> showByCategory(@PathVariable("category") String category) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by pgGender");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }

    @GetMapping("/paying-guests/pgGender/{pgGender}")
    ResponseEntity<List<PayingGuest>> showByPgGender(@PathVariable("pgGender") String pgGender) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByPgGender(pgGender);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by pgGender");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }

    @GetMapping("/paying-guests/rating/{rating}")
    ResponseEntity<List<PayingGuest>> showByRating(@PathVariable("rating") int rating) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByRating(rating);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by rating");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }

    @GetMapping("/paying-guests/city/{city}")
    ResponseEntity<List<PayingGuest>> showByCity(@PathVariable("city") String city) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByCity(city);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by city starting with");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }


    @GetMapping("/paying-guests/cityLike/{city}")
    ResponseEntity<List<PayingGuest>> showByCityStartingWith(@PathVariable("city") String city) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByCityStartingWith(city);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by city starting with");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }

    @GetMapping("/paying-guests/city/{city}/name/{name}")
    ResponseEntity<List<PayingGuest>> showByCityAndName(@PathVariable("city") String city, @PathVariable("name") String name) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByCityAndName(city, name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by city and name");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }

    @GetMapping("/paying-guests/city/{city}/rating/{rating}")
    ResponseEntity<List<PayingGuest>> showByCityAndRating(@PathVariable("city") String city, @PathVariable("rating") int rating) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByCityAndRating(city, rating);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by city and rating");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }

    @GetMapping("/paying-guests/addressId/{addressId}")
    ResponseEntity<List<PayingGuest>> showByCityAndRating(@PathVariable("addressId") int addressId) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByAddressId(addressId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by city and name");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }

    @GetMapping("/paying-guests/city/{city}/landMark/{landMark}")
    ResponseEntity<List<PayingGuest>> showByCityAndLandMark(@PathVariable("city") String city, @PathVariable("landMark") String landMark) {
        List<PayingGuest> payingGuests = iPayingGuestService.getByCityAndLandMark(city, landMark);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "get by city and landmark");
        return ResponseEntity.ok().headers(headers).body(payingGuests);
    }


}
