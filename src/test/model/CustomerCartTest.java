package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerCartTest {
    private CustomerCart cart;

    @BeforeEach
    public void setup() {
        cart = new CustomerCart();
    }

    @Test
    public void addToCartTest() {
        assertEquals(0, cart.numberOfItemsInCart());
        cart.addToCart(new Item("lego", 4.50, "building block"));
        assertEquals(1, cart.numberOfItemsInCart());

        cart.addToCart(new Item("car", 7.99, "toy car"));
        assertEquals(2, cart.numberOfItemsInCart());
    }

    @Test
    public void removeFromCartTest() {
        for (int i = 1; i <= 5; i++) {
            cart.addToCart(new Item("item#" + i, 3.00, "ABC"));
        }
        assertEquals(5, cart.numberOfItemsInCart());

        cart.removeFromCart("item#1");
        assertEquals(4, cart.numberOfItemsInCart());

        cart.removeFromCart("item#4");
        assertEquals(3, cart.numberOfItemsInCart());

        cart.removeFromCart("item#8");
        assertEquals(3, cart.numberOfItemsInCart());
    }

    @Test
    public void viewCartTest() {

    }
}
