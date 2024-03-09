package de.brockhaus_ag.superduper.repository;

import de.brockhaus_ag.superduper.model.Product;

import java.util.List;

public interface ProductRepository {
    /*
    This is a simple interface for dependency inversion. I think the way Spring handles the
    repository design is quite elegant and I like to use it even when I don't use Spring.
    It is very easy to replace the actual implementation of data sources this way.

    For the demo I decided to have the implementation to be hard coded. If I had more time
    to spare I would have implemented a csv reader implementing this interface using OpenCSV
    which I have used in the past to mass import data from our predictive data team into our
    lead management data pipeline.

    I was also thinking about using Spring with MySQL and docker-compose to give a database
    demo but in the end I decided to keep it simple for now.
     */
    List<Product> getAllProducts();
}
