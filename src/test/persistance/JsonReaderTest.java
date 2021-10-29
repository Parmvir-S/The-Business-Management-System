package persistance;

import model.ItemList;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
           ItemList items =  reader.read();
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyItemList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyItemList.json");
        try {
            ItemList items = reader.read();
            assertEquals(0, items.numberOfItemsInList());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderNormalItemList() {
        JsonReader reader = new JsonReader("./data/testReaderNormalItemList.json");
        try {
            ItemList items = reader.read();
            assertEquals(5, items.numberOfItemsInList());
            assertEquals("apple", items.getItems().get(0).getName());
            assertEquals(3, items.getItems().get(0).getPrice());

            assertEquals("mango", items.getItems().get(4).getName());
            assertEquals("fruit", items.getItems().get(4).getDescription());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
