package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemListTest {
    ItemList items;

    @BeforeEach
    public void setup() {
        items = new ItemList();
    }

    @Test
    public void addItemTest() {
        assertEquals(0, items.numberOfItemsInList());
        Item item1 = new Item("car", 3.29, "hot wheels");
        items.addItem(item1);
        assertEquals(1, items.numberOfItemsInList());

        Item item2 = new Item("truck", 6.29, "hot wheels");
        items.addItem(item2);
        assertEquals(2, items.numberOfItemsInList());
    }

    @Test
    public void removeItemTest() {
        for (int i = 1; i <= 5; i++) {
            items.addItem(new Item("toy#" + i, i, ""));
        }

        assertEquals(5, items.numberOfItemsInList());
        items.removeItem("toy#1");
        assertEquals(4, items.numberOfItemsInList());

        items.removeItem("toy#3");
        assertEquals(3, items.numberOfItemsInList());

        items.removeItem("lego truck");
        assertEquals(3, items.numberOfItemsInList());


    }

    @Test
    public void updateItem() {
        for (int i = 1; i <= 5; i++) {
            items.addItem(new Item("toy#" + i, i, ""));
        }

        items.updateItem("toy#3", "marbles", 5.00,"a glass ball");
        assertFalse(items.isItInItems("toy#3"));
        assertTrue(items.isItInItems("marbles"));

        items.updateItem("marbles", "lego", 15.00,"building blocks");
        assertFalse(items.isItInItems("marbles"));
        assertTrue(items.isItInItems("lego"));

        items.updateItem("trucks", "dinosaur", 15.00,"extinct");
        assertFalse(items.isItInItems("trucks"));
    }

    @Test
    public void isItInItemsTest() {
        for (int i = 1; i <= 5; i++) {
            items.addItem(new Item("toy#" + i, i, ""));
        }
        assertTrue(items.isItInItems("toy#4"));
        assertFalse(items.isItInItems("toy#10"));

        items.addItem(new Item("truck", 3.89, "kids toy"));
        assertTrue(items.isItInItems("truck"));

        items.removeItem("toy#4");
        assertFalse(items.isItInItems("toy#4"));
    }

    @Test
    public void numberOfItemsInListTest() {
        for (int i = 1; i <= 5; i++) {
            items.addItem(new Item("toy#" + i, i, ""));
        }
        assertEquals(5, items.numberOfItemsInList());
        items.addItem(new Item("truck", 3.89, "kids toy"));
        assertEquals(6, items.numberOfItemsInList());

    }

    @Test
    public void getItemsTest() {
        for (int i = 1; i <= 3; i++) {
            items.addItem(new Item("toy#" + i, i, ""));
        }
        assertEquals("toy#1", items.getItems().get(0).getName());
        assertEquals("toy#2", items.getItems().get(1).getName());
        assertEquals("toy#3", items.getItems().get(2).getName());
        assertEquals(3, items.numberOfItemsInList());
    }

}
