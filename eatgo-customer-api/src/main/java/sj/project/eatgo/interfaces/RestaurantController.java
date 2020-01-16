package sj.project.eatgo.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sj.project.eatgo.application.RestaurantService;
import sj.project.eatgo.domain.Restaurant;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") long id) {
        // 레스토랑 기본 정보 + 메뉴 정보
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return restaurant;
    }

}
