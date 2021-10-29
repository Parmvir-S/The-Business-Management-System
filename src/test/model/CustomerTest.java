package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setup() {
        ItemList storeItems = new ItemList();
        for (int i = 1; i <= 5; i++) {
            storeItems.addItem(new Item("item#" + i, 3.00, "toy"));
        }
        CustomerCart cart = new CustomerCart();
        customer = new Customer(1, "OG", "raptors@gmail.com",
                123, cart);
    }

    @Test
    public void getCustomerIDTest() {
        assertEquals(1, customer.getCustomerID());
    }

    @Test
    public void getNameTest() {
        assertEquals("OG", customer.getName());
    }

    @Test
    public void setNameTest() {
        assertEquals("OG", customer.getName());
        customer.setName("Pascal");
        assertEquals("Pascal", customer.getName());
    }

    @Test
    public void getEmailTest() {
        assertEquals("raptors@gmail.com", customer.getEmail());
    }

    @Test
    public void getPhoneNumberTest() {
        assertEquals(123, customer.getPhoneNumber());
    }

    @Test
    public void getCartTest() {
        ItemList items = new ItemList();
        for (int i = 1; i <= 5; i++) {
            items.addItem(new Item("item#" + i, 3.00, "toy"));
        }
        CustomerCart cartItems = new CustomerCart();
        assertEquals(cartItems.numberOfItemsInCart(), customer.getCart().numberOfItemsInCart());
        assertEquals(cartItems.totalPrice(), customer.getCart().totalPrice());
    }

    @Test
    public void getReceiptTest() {
        assertEquals(7, customer.getReceipt().size());
        customer.getCart().addToCart(new Item("item#3", 3.00, "toy"));
        assertEquals(7, customer.getReceipt().size());
    }
}
