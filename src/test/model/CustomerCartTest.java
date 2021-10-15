package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerCartTest {
    private CustomerCart cart;

    @BeforeEach
    public void setup() {
        ItemList storeItems = new ItemList();
        for (int i = 1; i <= 5; i++) {
            storeItems.addItem(new Item("item#" + i, 3.00, "toy"));
        }
        cart = new CustomerCart(storeItems);
    }

    @Test
    public void addToCartTest() {
        assertEquals(0, cart.numberOfItemsInCart());
        cart.addToCart(new Item("item#1", 3.00, "toy"));
        assertEquals(1, cart.numberOfItemsInCart());

        cart.addToCart(new Item("item#2", 3.00, "toy"));
        assertEquals(2, cart.numberOfItemsInCart());

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
        for (int i = 1; i <= 5; i++) {
            cart.addToCart(new Item("item#" + i, 3.00, "ABC"));
        }

        assertEquals("item#1, "
                    + "item#2, "
                    + "item#3, "
                    + "item#4, "
                    + "item#5, ", cart.viewCart());
    }

    @Test
    public void totalPriceTest() {
        for (int i = 1; i <= 5; i++) {
            cart.addToCart(new Item("item#" + i, 3.00, "toy"));
        }
        assertEquals(15.00, cart.totalPrice());

        cart.addToCart(new Item("lego", 4.00, "building blocks"));
        assertEquals(15.00, cart.totalPrice());
    }
}
