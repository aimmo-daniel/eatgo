package sj.project.eatgo.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sj.project.eatgo.application.RestaurantService;
import sj.project.eatgo.domain.MenuItemRepository;
import sj.project.eatgo.domain.Restaurant;
import sj.project.eatgo.domain.RestaurantRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") long id){
        // 레스토랑 기본 정보 + 메뉴 정보
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {
        String name = resource.getName();
        String address = resource.getAddress();

        Restaurant restaurant = new Restaurant(1234L, name, address);
        restaurantService.addRestaurant(restaurant);

        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    }


}
