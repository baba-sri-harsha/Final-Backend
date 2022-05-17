package com.payingguest.service;

import com.payingguest.Exceptions.PayingGuestNotFoundException;
import com.payingguest.model.PayingGuest;
import com.payingguest.repository.IPayingGuestRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayingGuestServiceImpl implements IPayingGuestService {

    IPayingGuestRepository payingGuestRepository;

    public PayingGuestServiceImpl(IPayingGuestRepository payingGuestRepository) {
        this.payingGuestRepository = payingGuestRepository;
    }

    @Override
    public PayingGuest addPayingGuest(PayingGuest payingGuest) {
        return payingGuestRepository.save(payingGuest);
    }

    @Override
    public void deletePayingGuest(int payingGuestId) {
        payingGuestRepository.deleteById(payingGuestId);
    }

    @Override
    public void updatePayingGuest(PayingGuest payingGuest) {
        payingGuestRepository.save(payingGuest);
    }

    @Override
    public List<PayingGuest> getAll() {
        return payingGuestRepository.findAll();
    }

    @Override
    public PayingGuest getByPayingGuestId(int id) throws PayingGuestNotFoundException {
        return payingGuestRepository.findByPayingGuestId(id);
    }

    @Override
    public List<PayingGuest> getByName(String name) throws PayingGuestNotFoundException {
        List<PayingGuest> payingGuestList = payingGuestRepository.findByName(name)
                .stream()
                .sorted(Comparator.comparing(PayingGuest::getName))
                .collect(Collectors.toList());
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        else
            return payingGuestList;
    }

    @Override
    public List<PayingGuest> getByPgGender(String pgGender) throws PayingGuestNotFoundException {

        List<PayingGuest> payingGuestList = payingGuestRepository.findByPgGender(pgGender);

        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        else
             return payingGuestList.stream().sorted(Comparator.comparing(PayingGuest::getPayingGuestId)).collect(Collectors.toList());

    }

    @Override
    public List<PayingGuest> getByCategory(String category) throws PayingGuestNotFoundException {

        List<PayingGuest> payingGuestList = payingGuestRepository.findByCategory(category)
                .stream()
                .sorted(Comparator.comparing(PayingGuest::getPayingGuestId))
                .collect(Collectors.toList());
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        else
            return payingGuestList;
    }

    @Override
    public List<PayingGuest> getByRating(int rating) throws PayingGuestNotFoundException {
        List<PayingGuest> payingGuestList = payingGuestRepository.findByRating(rating)
                .stream()
                .sorted(Comparator.comparing(PayingGuest::getPayingGuestId))
                .collect(Collectors.toList());
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        else
            return payingGuestList;
    }

    @Override
    public List<PayingGuest> getByCityStartingWith(String city) throws PayingGuestNotFoundException {
        List<PayingGuest> payingGuestList = payingGuestRepository.findByCityStartingWith(city+"%")
                .stream()
                .sorted(Comparator.comparing(PayingGuest::getPayingGuestId))
                .collect(Collectors.toList());
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        else
            return payingGuestList;
    }

    @Override
    public List<PayingGuest> getByCityAndName(String city, String name) throws PayingGuestNotFoundException {
        List<PayingGuest> payingGuestList = payingGuestRepository.findByCityAndName(city,name)
                .stream()
                .sorted(Comparator.comparing(PayingGuest::getPayingGuestId))
                .collect(Collectors.toList());
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        else
            return payingGuestList;
    }

    @Override
    public List<PayingGuest> getByCityAndRating(String city, int rating) throws PayingGuestNotFoundException {
        List<PayingGuest> payingGuestList = payingGuestRepository.findByCityAndRating(city,rating)
                .stream()
                .sorted(Comparator.comparing(PayingGuest::getPayingGuestId))
                .collect(Collectors.toList());
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        else
            return payingGuestList;
    }

    @Override
    public List<PayingGuest> getByAddressId(int addressId) throws PayingGuestNotFoundException {
        List<PayingGuest> payingGuestList = payingGuestRepository.findByAddressId(addressId)
                .stream()
                .sorted(Comparator.comparing(PayingGuest::getPayingGuestId))
                .collect(Collectors.toList());
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        else
            return payingGuestList;
    }


    @Override
    public List<PayingGuest> getByCityAndLandMark(String city, String landMark) throws PayingGuestNotFoundException {
        List<PayingGuest> payingGuestList = payingGuestRepository.findByCityAndLandMark( city,landMark)
                .stream()
                .sorted(Comparator.comparing(PayingGuest::getPayingGuestId))
                .collect(Collectors.toList());
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        else
            return payingGuestList;
    }

    

}
