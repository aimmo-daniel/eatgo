package sj.project.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RestaurantTest {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "");
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(), is(""));
    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }

}