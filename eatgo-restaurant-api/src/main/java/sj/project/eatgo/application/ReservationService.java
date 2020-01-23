package sj.project.eatgo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sj.project.eatgo.domain.Reservation;
import sj.project.eatgo.domain.ReservationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations(Long restaurantId) {
        return reservationRepository.findAllByRestaurantId(restaurantId);
    }
}
