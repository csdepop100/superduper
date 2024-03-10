package de.brockhaus_ag.superduper.model;

import de.brockhaus_ag.superduper.wrapper.Euro;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Product {
    /*
    Usually polymorphism might be seen as overused, but I think it fits perfectly here
    as this is very much the text book example of how and when to use it. Main reason for
    this is for me that this fits perfectly the "is a"-relationship.
    Cheese is a Product
    Wine is a Product
    I can think about Products without knowing the details of each individual type.

    I decided that Product should be an abstract class, because I want Products to have
    some shared behaviour while leaving some implementation details to the subclasses.

    In this example we have only wine and cheese so the decision to have updatePrice to
    be implemented by default or to be abstract was a little tricky, but I ultimately decided
    to have it implemented by default and override it for the wine, because I think more
    products would use the default implementation in the future. Luckily this is not a decision
    that's hard to change should my assumption be wrong.

    The strongly shared behaviour is the toString method which I use to print the products
    to the console for the demo.

    There is no valid-argument-check for Product. Usually I would check for expired cheese
    or negative quality wine via the isQuality() method, before adding the Object to the warehouse
    in the service layer to just have the necessary logic in my domain objects. If there was
    some change in the way of handling low quality products, it would be much easier to adjust the
    service layer than adjusting how domain objects work.
     */
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    protected final Euro basisPrice;
    protected String description;
    protected Euro price;
    // there are some weird edge cases where passing by value and reference can be weird in
    // java using primitives. That's why I use Objects wrappers where I can.
    protected Integer quality;
    protected LocalDateTime expirationDate;

    protected Product(String description,
                      Euro basisPrice,
                      Integer quality,
                      LocalDateTime expirationDate) {
        this.description = description;
        this.basisPrice = basisPrice;
        this.quality = quality;
        this.expirationDate = expirationDate;
        updatePrice();
    }

    public Euro getBasisPrice() {
        return basisPrice;
    }

    public String getDescription() {
        return description;
    }

    public Euro getPrice() {
        return price;
    }

    public Integer getQuality() {
        return quality;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    abstract boolean isQuality();

    public abstract void dailyRoutine();

    public void updatePrice() {
        this.price = this.basisPrice.plus(Euro.valueOf(0.1 * quality));
    }

    @Override
    public String toString() {
        return description
                + "\t" + price.toString()
                + "\t" + "quality: " + quality
                + (Objects.isNull(expirationDate) ? "" : "\texpires " + formatter.format(expirationDate))
                + (isQuality() ? "" : "\t**REMOVE FROM STORAGE**");
    }

}
