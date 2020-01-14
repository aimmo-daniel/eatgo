package sj.project.eatgo.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sj.project.eatgo.application.MenuItemService;
import sj.project.eatgo.domain.MenuItem;

import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(@PathVariable("restaurantId") Long restaurandtId, @RequestBody List<MenuItem> menuItems) {
        menuItemService.bulkUpdate(restaurandtId, menuItems);

        return "";
    }

}
