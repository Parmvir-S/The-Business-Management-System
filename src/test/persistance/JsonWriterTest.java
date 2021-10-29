package persistance;

import model.Item;
import model.ItemList;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            ItemList items = new ItemList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("Exception was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyItemList() {
        try {
            ItemList items = new ItemList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyItemList.json");
            writer.open();
            writer.write(items);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyItemList.json");
            items = reader.read();
            assertEquals(0, items.numberOfItemsInList());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralItemList() {
        try {
            ItemList items = new ItemList();
            items.addItem(new Item("lego", 9.99, "building blocks"));
            items.addItem(new Item("car", 5.77, "hot wheels"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralItemList.json");
            writer.open();
            writer.write(items);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralItemList.json");
            items = reader.read();
            assertEquals(2, items.numberOfItemsInList());
            assertEquals("lego", items.getItems().get(0).getName());
            assertEquals(9.99, items.getItems().get(0).getPrice());
            assertEquals("hot wheels", items.getItems().get(1).getDescription());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
