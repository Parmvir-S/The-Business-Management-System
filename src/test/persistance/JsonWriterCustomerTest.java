package persistance;

import model.AllCustomers;
import model.Customer;
import model.CustomerCart;
import org.junit.jupiter.api.Test;
import persistence.JsonReaderCustomer;
import persistence.JsonWriterCustomer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
            customers.addCustomer(new Customer(2, "ls", "", 321, new CustomerCart()));
            JsonWriterCustomer writer = new JsonWriterCustomer("./data/testWriterCustomerGeneralCustomerList.json");
            writer.open();
            writer.write(customers);
            writer.close();

            JsonReaderCustomer reader = new JsonReaderCustomer("./data/testWriterCustomerGeneralCustomerList.json");
            customers = reader.read();
            assertEquals(2, customers.getTotalNumberOfCustomers());
            assertEquals("ps", customers.getAllCustomers().get(0).getName());
            assertEquals(321, customers.getAllCustomers().get(1).getPhoneNumber());
            assertEquals("", customers.getAllCustomers().get(0).getEmail());
            assertEquals(2, customers.getAllCustomers().get(1).getCustomerID());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
