package sj.project.eatgo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sj.project.eatgo.domain.MenuItem;
import sj.project.eatgo.domain.MenuItemRepository;

import java.util.List;

@Service
public class MenuItemService {

    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public void bulkUpdate(Long restaurandtId, List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            update(restaurandtId, menuItem);
        }
    }

    private void update(Long restaurandtId, MenuItem menuItem) {
        if (menuItem.isDestroy()){
            menuItemRepository.deleteById(menuItem.getId());
            return;
        }

        menuItem.setRestaurantId(restaurandtId);
        menuItemRepository.save(menuItem);
    }

}
