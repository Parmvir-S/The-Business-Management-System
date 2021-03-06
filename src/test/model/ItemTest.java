package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Item item;

    @BeforeEach
    public void setup() {
        item = new Item("toy car", 5.50, "A Hot Wheels Car");
    }

    @Test
    public void getNameAndSetNameTest() {
        assertEquals("toy car", item.getName());
        item.setName("lego");
        assertEquals("lego", item.getName());
    }

    @Test
    public void getPriceAndSetPriceTest() {
        assertEquals(5.50, item.getPrice());
        item.setPrice(11.99);
        assertEquals(11.99, item.getPrice());
    }

    @Test
    public void getDescriptionAndSetDescriptionTest() {
        assertEquals("A Hot Wheels Car", item.getDescription());
        item.setDescription("Lego Car");
        assertEquals("Lego Car", item.getDescription());
    }

}