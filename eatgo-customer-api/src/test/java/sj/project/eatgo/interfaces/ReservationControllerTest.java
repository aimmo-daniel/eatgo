package sj.project.eatgo.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sj.project.eatgo.application.ReservationService;
import sj.project.eatgo.domain.Reservation;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    public void create() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjY4LCJuYW1lIjoiVGVzdGVyIn0.lhPC6Pktxb9kUHgteB-9i2ywBokFgWXkctnQ5KIUvVo";

        Reservation mockReservation = Reservation.builder().id(12L).build();

        given(reservationService.addReservation(any(), any(), any(), any(), any(), any()))
                .willReturn(mockReservation);

        mvc.perform(post("/restaurants/369/reservations")
                .header("Authorization" ,"Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"date\":\"2019-12-24\",\"time\":\"20:00\",\"partySize\":20}"))
                .andExpect(status().isCreated());

        Long restaurantId = 369L;
        Long userId = 68L;
        String name = "Tester";
        String date = "2019-12-24";
        String time = "20:00";
        Integer partySize = 20;

        verify(reservationService).addReservation(eq(restaurantId), eq(userId), eq(name), eq(date), eq(time), eq(partySize));
    }


}