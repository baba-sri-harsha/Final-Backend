package com.payingguest.repository;

import com.payingguest.Exceptions.PayingGuestNotFoundException;
import com.payingguest.model.PayingGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPayingGuestRepository extends JpaRepository<PayingGuest,Integer> {
    
    List<PayingGuest> findAll();

    PayingGuest findByPayingGuestId(int id);

    List<PayingGuest>findByName(String name)  ;

    List<PayingGuest>findByPgGender(String pgGender) ;

    @Query("from PayingGuest p where p.category= ?1")
    List<PayingGuest>findByCategory(String category) ;

    List<PayingGuest>findByRatingGreaterThan(int rating);

    @Query("from PayingGuest p inner join p.address a where a.city = ?1")
    List<PayingGuest>findByCity(String city);

    @Query("from PayingGuest p inner join p.address a where a.city like ?1")
    List<PayingGuest> findByCityStartingWith(String city);

    @Query("from PayingGuest p inner join p.address a where a.city=?1 and p.name=?2")
    List<PayingGuest> findByCityAndName(String city, String name);

    @Query("from PayingGuest p inner join p.address a where a.city=?1 and p.rating>=?2")
    List<PayingGuest> findByCityAndRating(String city, int rating);

    @Query("from PayingGuest p inner join p.address a where a.addressId=?1")
    List<PayingGuest>findByAddressId(int addressId);

    @Query("from PayingGuest p inner join p.address a where a.landMark=?1 and a.city=?2")
    List<PayingGuest>findByCityAndLandMark(String city,String landMark);


}
