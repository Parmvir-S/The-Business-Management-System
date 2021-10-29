package persistance;

import model.AllCustomers;
import model.ItemList;
import org.junit.jupiter.api.Test;
import persistence.JsonReaderCustomer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderCustomerTest {

    @Test
    public void testReaderCustomerNonExistentFile() {
        JsonReaderCustomer reader = new JsonReaderCustomer("./data/noSuchFile.json");
        try {
            AllCustomers customers = reader.read();
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderCustomerEmptyCustomersTest() {
        JsonReaderCustomer reader = new JsonReaderCustomer("./data/testReaderCustomerEmptyCustomersTest.json");
        try {
            AllCustomers customers = reader.read();
            assertEquals(0, customers.getTotalNumberOfCustomers());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderCustomerNormalCustomersTest() {
        JsonReaderCustomer reader = new JsonReaderCustomer("./data/testReaderCustomerNormalCustomersTest.json");
        try {
            AllCustomers customers = reader.read();
            assertEquals(3, customers.getTotalNumberOfCustomers());

            assertEquals("parm", customers.getAllCustomers().get(0).getName());
            assertEquals(123, customers.getAllCustomers().get(0).getPhoneNumber());

            assertEquals("lebron", customers.getAllCustomers().get(2).getName());
            assertEquals(1, customers.getAllCustomers().get(2).getCart().numberOfItemsInCart());
            assertEquals("lakers", customers.getAllCustomers().get(2).getEmail());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
