package de.brockhaus_ag.superduper.model;

import de.brockhaus_ag.superduper.wrapper.Euro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CheeseTest {
    @Test
    @DisplayName("Cheese can be created")
    public void cheeseCreationTest() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.now().plusDays(75));
        assertInstanceOf(Cheese.class, cheese);
        assertInstanceOf(Product.class, cheese);
    }

    @Test
    @DisplayName("Cheese prices are calculated correctly")
    public void cheesePricingTest() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.now().plusDays(75));
        assertEquals(Euro.valueOf(7.5f), cheese.getPrice());
    }

    @Test
    @DisplayName("Cheese ages correctly")
    public void cheeseAgingTest() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.now().plusDays(75));
        cheese.dailyRoutine();
        assertEquals(49, cheese.getQuality());
        assertEquals(Euro.valueOf(7.4f), cheese.getPrice());
    }

    @Test
    @DisplayName("Cheese ages correctly for multiple days")
    public void cheeseAgingTestOverTenDays() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.now().plusDays(75));
        for (int i = 0; i < 10; i++) {
            cheese.dailyRoutine();
        }
        assertEquals(40, cheese.getQuality());
        assertEquals(Euro.valueOf(6.5f), cheese.getPrice());
    }

    @Test
    @DisplayName("Good Cheese is displayed correctly")
    public void cheeseDisplayTest() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.of(2024, 4, 1, 0, 0));
        assertEquals("stinky\t7,50 €\tquality: 50\texpires 01.04.2024", cheese.toString());
    }
}
