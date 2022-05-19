package com.payingguest.service;

import com.payingguest.Exceptions.BookingNotFoundException;
import com.payingguest.model.Booking;
import com.payingguest.model.PgDetails;
import com.payingguest.repository.IPgDetailsRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class PgDetailsServiceImpl implements  IPgDetailsService{

    private IPgDetailsRepository pgDetailsRepository;
    @Autowired
    public void setPgDetailsRepository(IPgDetailsRepository pgDetailsRepository) {
        this.pgDetailsRepository = pgDetailsRepository;
    }

    @Override
    public List<PgDetails> getByDateGreaterThan(LocalDateTime bookingDateTime) throws BookingNotFoundException {

        List<PgDetails> pgDetails= pgDetailsRepository.findByDateGreaterThan(bookingDateTime);
        if (pgDetails.isEmpty())
            throw  new BookingNotFoundException();
        return pgDetails;
    }

    @Override
    public List<PgDetails> getByDateLessThan(LocalDateTime bookingDateTime) {
        List<PgDetails> pgDetails = pgDetailsRepository.findByDateLessThan(bookingDateTime);
        if (pgDetails.isEmpty())
            throw  new BookingNotFoundException();
        return pgDetails;
    }

    @Override
    public List<PgDetails> getBookingsBetween(LocalDateTime fromDate, LocalDateTime toDate) {
        List<PgDetails> pgDetails= pgDetailsRepository.findBookingsBetween(fromDate,toDate);
        if (pgDetails.isEmpty())
            throw  new BookingNotFoundException();
        return pgDetails;
    }
}
