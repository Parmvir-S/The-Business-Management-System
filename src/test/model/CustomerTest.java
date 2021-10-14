package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer(1, "OG", "raptors@gmail.com",
                123, new CustomerCart());
    }

    @Test
    public void printReceiptTest() {
        assertEquals("---Receipt---"
                    + 1
                    + "OG"
                    + "raptors@gmail.com"
                    + 123
                    + "", customer.printReceipt());
    }
}