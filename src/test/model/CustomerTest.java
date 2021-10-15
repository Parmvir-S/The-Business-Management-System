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
        customer = new Customer(1, "OG", "raptors@gmail.com",
                123, new CustomerCart(storeItems));
    }

}