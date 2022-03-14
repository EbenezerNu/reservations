package com.catalyst.reservations.landon.data.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ROOM_ID")
    private Long roomId;
    @Column(name = "GUEST_ID")
    private Long guestId;
    @Column(name = "RES_DATE")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Date getResDate() {
        return date;
    }

    public void setResDate(Date resDate) {
        this.date = resDate;
    }
}
