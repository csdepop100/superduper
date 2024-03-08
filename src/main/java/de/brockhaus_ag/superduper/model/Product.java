package de.brockhaus_ag.superduper.model;

import de.brockhaus_ag.superduper.wrapper.Euro;

import java.time.LocalDateTime;

import static org.apache.commons.lang3.BooleanUtils.isFalse;

public abstract class Product {

    protected final Euro basisPrice;
    protected String description;
    protected Euro price;
    protected int quality;
    protected LocalDateTime expirationDate;

    protected Product(String description,
                      Euro basisPrice,
                      Integer quality,
                      LocalDateTime expirationDate) {
        this.description = description;
        this.basisPrice = basisPrice;
        this.quality = quality;
        this.expirationDate = expirationDate;
        if (isFalse(isQuality()))
            throw new IllegalArgumentException("This product does not meet our standards.");
    }

    abstract boolean isQuality();
    abstract void dailyRoutine();

    public void updatePrice() {
        this.price = this.basisPrice.plus(Euro.valueOf(0.1 * quality));
    }
}
