package com.payingguest.service;

import com.payingguest.Exceptions.PayingGuestNotFoundException;
import com.payingguest.model.Booking;
import com.payingguest.model.Customer;
import com.payingguest.model.PayingGuest;
import com.payingguest.repository.IBookingRepository;
import com.payingguest.repository.ICustomerRepository;
import com.payingguest.repository.IPayingGuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements IBookingService {

    IBookingRepository bookingRepository;
    @Autowired
    public void setBookingRepository(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    ICustomerRepository customerRepository;
    @Autowired
    public void setCustomerRepository(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    IPayingGuestRepository payingGuestRepository;
    @Autowired
    public void setPayingGuestRepository(IPayingGuestRepository payingGuestRepository) {
        this.payingGuestRepository = payingGuestRepository;
    }

    @Override
    public void addBooking(Booking booking, int payingGuestId, int customerId) {
        PayingGuest payingGuest = payingGuestRepository.getById(payingGuestId);
        booking.setPayingGuest(payingGuest);
        Customer customer = customerRepository.getById(customerId);
        booking.setCustomer(customer);
        booking.setBookingTime(LocalDateTime.now());
        bookingRepository.save(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        booking.setBookingTime(LocalDateTime.now());
        bookingRepository.save(booking);
    }

    @Override
    public Booking getById(int id) throws PayingGuestNotFoundException {
        return bookingRepository.findById(id).get();
    }


}
