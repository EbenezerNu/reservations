package com.catalyst.reservations.web.application;
import com.catalyst.reservations.landon.business.domain.RoomReservation;
import com.catalyst.reservations.landon.business.service.ReservationService;
import com.catalyst.reservations.landon.web.application.ReservationController;
import org.junit.Test;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @MockBean
    private ReservationService reservationService;
    @Autowired
    private MockMvc mockMvc;

    private static final DateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd");
    @Test
    public void getReservations() throws Exception{
        Date date = DATE_FORMAT.parse("2022-02-07");
        List<RoomReservation> mockReservationList = new ArrayList<>();
        RoomReservation mockReservation = new RoomReservation();
        mockReservation.setGuestId(1);
        mockReservation.setLastName("Test");
        mockReservation.setFirstName("JUnit");
        mockReservation.setDate(date);
        mockReservation.setRoomNumber("A83");
        mockReservation.setRoomId(100);
        mockReservation.setRoomName("JUnit Room");
        mockReservationList.add(mockReservation);

        given(reservationService.getRoomReservationsForDate(date))
                .willReturn(mockReservationList);
        this.mockMvc.perform(get("/reservations?date=2022-02-07")).andExpect
                (status().isOk()).andExpect(content().
                string(containsString("Test, JUnit")));

    }



}
