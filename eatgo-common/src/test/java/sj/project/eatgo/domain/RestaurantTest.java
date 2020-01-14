package sj.project.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RestaurantTest {

    @Test
    public void creation() {
        //Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(), is("Seoul"));
    }

    @Test
    public void information() {
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        restaurant.setName("Sul zip");

        assertThat(restaurant.getInformation(), is("Sul zip in Seoul"));
    }

}