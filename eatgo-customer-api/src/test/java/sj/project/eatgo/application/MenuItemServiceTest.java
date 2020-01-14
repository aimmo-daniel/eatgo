package sj.project.eatgo.application;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sj.project.eatgo.application.MenuItemService;
import sj.project.eatgo.domain.MenuItem;
import sj.project.eatgo.domain.MenuItemRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MenuItemServiceTest {

    private MenuItemService menuItemService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        menuItemService = new MenuItemService(menuItemRepository);
    }

    @Mock
    private MenuItemRepository menuItemRepository;

    @Test
    public void bulkUpdate() {
        List<MenuItem> menuItems = new ArrayList<MenuItem>();

        menuItems.add(MenuItem.builder().name("Kimchi").build());
        menuItems.add(MenuItem.builder().id(12L).name("Bulgogi").build());
        menuItems.add(MenuItem.builder().id(1004L).destroy(true).build());

        menuItemService.bulkUpdate(1L, menuItems);

        verify(menuItemRepository, times(2)).save(any());
        verify(menuItemRepository, times(1)).deleteById(eq(1004L));
    }

}