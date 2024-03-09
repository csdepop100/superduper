package de.brockhaus_ag.superduper;

import de.brockhaus_ag.superduper.model.Product;
import de.brockhaus_ag.superduper.repository.ProductRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DemoRunner {
    /*
    This class has all the "logic" necessary to run the demo, i.e. listing items and invoking daily
    routines. Usually I would have service classes doing that kind of work in the service layer of
    my application. I used to work a lot with the Spring MVC architecture, and it became my
    favourite and comfort architecture.
     */
    private final List<Product> products;

    public DemoRunner(ProductRepository repo) {
        this.products = repo.getAllProducts();
    }

    public void listProducts() {
        products.forEach(System.out::println);
    }

    private void dailyRoutines() {
        products.forEach(Product::dailyRoutine);
    }

    public void nextTenDays() {
        var date = LocalDateTime.now();
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (int i = 1; i < 11; i++) {
            System.out.println("-----" + formatter.format(date.plusDays(i)) + "-----");
            dailyRoutines();
            listProducts();
        }
    }
}
