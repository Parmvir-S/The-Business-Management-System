package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerCartTest {
    private CustomerCart cart;

    @BeforeEach
    public void setup() {
        ItemList storeItems = new ItemList();
        for (int i = 1; i <= 5; i++) {
            storeItems.addItem(new Item("item#" + i, 3.00, "toy"));
        }
        cart = new CustomerCart();
    }

    @Test
    public void addToCartTest() {
        assertEquals(0, cart.numberOfItemsInCart());
        Item item1 = new Item("item#1", 3.00, "toy");
        cart.addToCart(item1);
        assertEquals(1, cart.numberOfItemsInCart());

        Item item2 = new Item("item#2", 3.00, "toy");
        cart.addToCart(item2);
        assertEquals(2, cart.numberOfItemsInCart());

        Item itemCar = new Item("car", 63.00, "toy");
        cart.addToCart(itemCar);
        assertEquals(3, cart.numberOfItemsInCart());
    }

    @Test
    public void removeFromCartTest() {
        for (int i = 1; i <= 5; i++) {
            cart.addToCart(new Item("item#" + i, i, ""));
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
            cart.addToCart(new Item("item#" + i, 0, ""));
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
            cart.addToCart(new Item("item#" + i, i, ""));
        }
        assertEquals(15.00, cart.totalPrice());

        cart.addToCart(new Item("item#3", 3, ""));
        assertEquals(18.00, cart.totalPrice());
    }

    @Test
    public void getItemsTest() {
        assertEquals(0, cart.getItems().size());
        for (int i = 1; i <= 5; i++) {
            cart.addToCart(new Item("item#" + i, i, ""));
        }
        assertEquals(5, cart.getItems().size());
        assertEquals("item#1", cart.getItems().get(0).getName());
        assertEquals(3, cart.getItems().get(2).getPrice());
    }
}
