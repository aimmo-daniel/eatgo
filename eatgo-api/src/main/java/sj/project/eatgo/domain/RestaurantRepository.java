package sj.project.eatgo.domain;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> findAll();

    Restaurant findById(Long id);

    void save(Restaurant restaurant);
}
