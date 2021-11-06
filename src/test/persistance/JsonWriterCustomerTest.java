package persistance;

import model.AllCustomers;
import model.Customer;
import model.CustomerCart;
import model.Item;
import org.junit.jupiter.api.Test;
import persistence.JsonReaderCustomer;
import persistence.JsonWriterCustomer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterCustomerTest {

    @Test
    public void testWriterCustomerInvalidFile() {
        try {
            AllCustomers customers = new AllCustomers();
            JsonWriterCustomer writer = new JsonWriterCustomer("./data/my\0illegal:fileName.json");
            writer.open();
            fail("Exception was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterCustomerEmptyCustomerList() {
        try {
            AllCustomers customers = new AllCustomers();
            JsonWriterCustomer writer = new JsonWriterCustomer("./data/testWriterCustomerEmptyCustomerList.json");
            writer.open();
            writer.write(customers);
            writer.close();

            JsonReaderCustomer reader = new JsonReaderCustomer("./data/testWriterCustomerEmptyCustomerList.json");
            customers = reader.read();
            assertEquals(0, customers.getTotalNumberOfCustomers());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterCustomerGeneralCustomerList() {
        try {
            AllCustomers customers = new AllCustomers();
            customers.addCustomer(new Customer(1, "ps", "", 123, new CustomerCart()));
            CustomerCart cart = new CustomerCart();
            Item newItem = new Item("lego", 3.00, "building blocks");
            cart.addToCart(newItem);
            customers.addCustomer(new Customer(2, "ls", "", 321, cart));
            customers.getCustomer("ls").getCart().getItems().add(newItem);
            customers.addCustomer(new Customer(3,"GS", "", 0, new CustomerCart()));
            customers.getCustomer("GS").getCart().addToCart(newItem);
            customers.getCustomer("GS").getCart().addToCart(new Item("car", 4.00, ""));

            JsonWriterCustomer writer = new JsonWriterCustomer("./data/testWriterCustomerGeneralCustomerList.json");
            writer.open();
            writer.write(customers);
            writer.close();

            JsonReaderCustomer reader = new JsonReaderCustomer("./data/testWriterCustomerGeneralCustomerList.json");
            customers = reader.read();
            assertEquals(3, customers.getTotalNumberOfCustomers());
            assertEquals("ps", customers.getAllCustomers().get(0).getName());
            assertEquals(321, customers.getAllCustomers().get(1).getPhoneNumber());
            assertEquals("", customers.getAllCustomers().get(0).getEmail());
            assertEquals(2, customers.getAllCustomers().get(1).getCustomerID());
            assertEquals("lego, lego, ", customers.getAllCustomers().get(1).getCart().viewCart());
            assertEquals(2, customers.getAllCustomers().get(1).getCart().numberOfItemsInCart());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
