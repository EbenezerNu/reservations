package com.catalyst.reservations.landon.data.repository;

import com.catalyst.reservations.landon.data.entity.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuestRepository
        extends PagingAndSortingRepository<Guest, Long> {
    //Guest findOne(Long guestId);
    //List<Guest> findById(Guest guest);
}
