package de.brockhaus_ag.superduper.repository;

import de.brockhaus_ag.superduper.model.Cheese;
import de.brockhaus_ag.superduper.model.Product;
import de.brockhaus_ag.superduper.model.Wine;
import de.brockhaus_ag.superduper.wrapper.Euro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryDemoImpl implements ProductRepository{
    @Override
    public List<Product> getAllProducts() {
        var list = new ArrayList<Product>();
        list.add(new Cheese("stinky",
                Euro.valueOf(2.5),
                50,
                LocalDateTime.now().plusDays(75)));
        list.add(new Wine("Erben Spätlese", Euro.valueOf(50), 4));
        return list;
    }
}
