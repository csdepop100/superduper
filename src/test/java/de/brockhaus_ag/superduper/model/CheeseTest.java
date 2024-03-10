package de.brockhaus_ag.superduper.model;

import de.brockhaus_ag.superduper.wrapper.Euro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CheeseTest {
    /*
    As tests are optional, I will write a test suit for the class that has the most business logic.
    I'm not aiming for high code coverage or to cover every edge case. These tests are just here to
    demonstrate that I have written some unit tests in my life.
    I try to follow the AAA method (Assemble Act Assert) as much as possible, though I think it is
    not necessary for small tests.
    I'm not dealing with the side effects of LocalDateTime.now() in this demo. Neither in code
    nor in testing because I think simply out of scope for a small demo like this.
     */
    @Test
    @DisplayName("Cheese can be created")
    public void cheeseCreationTest() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.of(2024, 4, 1, 0, 0));
        assertInstanceOf(Cheese.class, cheese);
        assertInstanceOf(Product.class, cheese);
    }

    @Test
    @DisplayName("Cheese prices are calculated correctly")
    public void cheesePricingTest() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.of(2024, 4, 1, 0, 0));
        assertEquals(Euro.valueOf(7.5f), cheese.getPrice());
    }

    @Test
    @DisplayName("Cheese ages correctly")
    public void cheeseAgingTest() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.of(2024, 4, 1, 0, 0));
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
                LocalDateTime.of(2024, 4, 1, 0, 0));
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

    @Test
    @DisplayName("Cheese expriation is displayed")
    public void cheeseExpirationTest() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.of(1990, 1, 1, 0, 0));
        assertEquals("stinky\t7,50 €\tquality: 50\texpires 01.01.1990\t**REMOVE FROM STORAGE**", cheese.toString());
    }

    @Test
    @DisplayName("Cheese quality is too bad")
    public void cheeseQualityTest() {
        var cheese = new Cheese("stinky",
                Euro.valueOf(2.5),
                0,
                LocalDateTime.of(2024, 4, 1, 0, 0));
        assertEquals("stinky\t2,50 €\tquality: 0\texpires 01.04.2024\t**REMOVE FROM STORAGE**", cheese.toString());
    }
}
