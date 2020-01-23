package sj.project.eatgo.interfaces;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sj.project.eatgo.application.ReservationService;
import sj.project.eatgo.domain.Reservation;
import sj.project.eatgo.utils.JwtUtil;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/restaurants/{restaurantId}/reservations")
    public ResponseEntity<?> create(Authentication authentication,
                                    @PathVariable Long restaurantId,
                                    @Valid @RequestBody Reservation resource) throws URISyntaxException {
        Claims claims = (Claims) authentication.getPrincipal();

        Long userId = claims.get("userId", Long.class);
        String name = claims.get("name", String.class);

        Reservation reservation =
                reservationService.addReservation(restaurantId, userId, name, resource.getDate(), resource.getTime(), resource.getPartySize());

        String url = "/restaurants/" + restaurantId + "/reservations/" + reservation.getId();

        return ResponseEntity.created(new URI(url)).body("{}");
    }

}
