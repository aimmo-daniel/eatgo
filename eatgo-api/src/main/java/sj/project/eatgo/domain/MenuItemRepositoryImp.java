package sj.project.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryImp implements MenuItemRepository {

    List<MenuItem> menuItems = new ArrayList<MenuItem>();


    public MenuItemRepositoryImp() {
        menuItems.add(new MenuItem("Kimchi"));
    }

    @Override
    public List<MenuItem> findAllByRestaurantId(Long restaurantId) {
        return menuItems;
    }

}
