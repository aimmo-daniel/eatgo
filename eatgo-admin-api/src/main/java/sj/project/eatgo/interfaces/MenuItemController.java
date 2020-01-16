package sj.project.eatgo.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sj.project.eatgo.application.MenuItemService;
import sj.project.eatgo.domain.MenuItem;

import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;

    @GetMapping("/restaurants/{restaurantId}/menuitems")
    public List<MenuItem> list(@PathVariable("restaurantId") Long restaurandtId) {
        List<MenuItem> menuItems = menuItemService.getMenuItems(restaurandtId);

        return menuItems;
    }

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(@PathVariable("restaurantId") Long restaurandtId, @RequestBody List<MenuItem> menuItems) {
        menuItemService.bulkUpdate(restaurandtId, menuItems);

        return "";
    }

}
