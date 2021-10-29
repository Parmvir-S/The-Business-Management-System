package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllCustomersTest {

    private AllCustomers allCustomers;

    @BeforeEach
    public void setup() {
        allCustomers = new AllCustomers();
    }

    @Test
    public void getCustomerTest() {
        for (int i = 1; i <= 5; i++) {
            allCustomers.addCustomer(new Customer(i,
                    "#" + i,
                    "",
                    0,
                    new CustomerCart()));
        }

        assertEquals(allCustomers.getAllCustomers().get(1), allCustomers.getCustomer("#2"));
        assertEquals(allCustomers.getAllCustomers().get(0), allCustomers.getCustomer("#23"));
    }

    @Test
    public void addCustomerTest() {
        assertEquals(0, allCustomers.getTotalNumberOfCustomers());
        Customer cust1 = new Customer(6, "LeBron", "gmail", 360, new CustomerCart());
        allCustomers.addCustomer(cust1);
        assertEquals(1, allCustomers.getTotalNumberOfCustomers());

        Customer cust2 = new Customer(30, "Curry", "gmail", 11, new CustomerCart());
        allCustomers.addCustomer(cust2);
        assertEquals(2, allCustomers.getTotalNumberOfCustomers());
    }

    @Test
    public void removeCustomerTest() {
        for (int i = 1; i <= 5; i++) {
            allCustomers.addCustomer(new Customer(i,
                    "#" + i,
                    "",
                    0,
                    new CustomerCart()));
        }
        assertEquals(5, allCustomers.getTotalNumberOfCustomers());
        allCustomers.removeCustomer("#1");
        assertEquals(4, allCustomers.getTotalNumberOfCustomers());
        allCustomers.removeCustomer("#4");
        assertEquals(3, allCustomers.getTotalNumberOfCustomers());
        allCustomers.removeCustomer("#33");
        assertEquals(3, allCustomers.getTotalNumberOfCustomers());
    }

    @Test
    public void getTotalSalesTest() {
        ItemList storeItems = new ItemList();
        for (int i = 1; i <= 5; i++) {
            storeItems.addItem(new Item("toy#" + i, i, ""));
        }
        CustomerCart cart = new CustomerCart();

        for (int i = 1; i <= 5; i++) {
            cart.addToCart(new Item("toy#2", i, ""));
        }

        for (int i = 1; i <= 5; i++) {
            allCustomers.addCustomer(new Customer(i,
                    "#" + i,
                    "",
                    0,
                    cart));
        }

        assertEquals(75.0, allCustomers.getTotalSales());
    }

    @Test
    public void allCustomerNamesTest() {
        for (int i = 1; i <= 3; i++) {
            allCustomers.addCustomer(new Customer(i,
                    "#" + i,
                    "",
                    0,
                    new CustomerCart()));
        }
        assertEquals("#1 - #2 - #3 - ", allCustomers.allCustomerNames());
    }
}
