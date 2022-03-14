package com.catalyst.reservations.landon.business.service;

import com.catalyst.reservations.landon.business.domain.RoomReservation;
import com.catalyst.reservations.landon.data.entity.Guest;
import com.catalyst.reservations.landon.data.entity.Reservation;
import com.catalyst.reservations.landon.data.entity.Room;
import com.catalyst.reservations.landon.data.repository.GuestRepository;
import com.catalyst.reservations.landon.data.repository.ReservationRepository;
import com.catalyst.reservations.landon.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.*;

@Service
public class ReservationService {
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;
    private RoomRepository roomRepository;

    @Autowired
    public ReservationService(
            GuestRepository guestRepository,
            ReservationRepository reservationRepository,
            RoomRepository roomRepository) {
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public List<RoomReservation>
            getRoomReservationsForDate(Date date){
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap =
                new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getNumber());
            roomReservationMap.put(room.getId(), roomReservation);
            System.out.println("############\nThis is the for the ReservationService file - List rooms\n" +
                    room.getId() + " -> "+room.getName());
        });

        Iterable<Reservation> reservations = this.reservationRepository
                .findByDate(new java.sql.Date(date.getTime()));
        if (reservations != null){
            reservations.forEach(reservation -> {
                Optional<Guest> guest = this.guestRepository.findById(reservation.getGuestId());
                if (guest !=null){
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
                    roomReservation.setDate(date);
                    roomReservation.setFirstName(guest.get().getFirstName());
                    roomReservation.setLastName(guest.get().getLastName());
                    roomReservation.setGuestId(guest.get().getId());
                }
            });
        }
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long roomId: roomReservationMap.keySet()){
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;
    }
}
