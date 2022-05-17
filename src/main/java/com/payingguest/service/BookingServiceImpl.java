package com.payingguest.service;

import com.payingguest.Exceptions.PayingGuestNotFoundException;
import com.payingguest.model.Booking;
import com.payingguest.repository.IBookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements IBookingService{

    IBookingRepository bookingRepository;

    public BookingServiceImpl(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public Booking getById(int id) throws PayingGuestNotFoundException {
        return bookingRepository.findById(id).get();
    }



}
