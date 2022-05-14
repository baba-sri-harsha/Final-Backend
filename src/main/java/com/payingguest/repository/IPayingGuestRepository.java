package com.payingguest.repository;

import com.payingguest.model.PayingGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayingGuestRepository extends JpaRepository<PayingGuest,Integer> {

}
