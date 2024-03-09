package de.brockhaus_ag.superduper.model;

import de.brockhaus_ag.superduper.wrapper.Euro;

import java.time.LocalDateTime;

public class Cheese extends Product {
    public Cheese(String description,
                  Euro basisPrice,
                  Integer quality,
                  LocalDateTime expirationDate) {
        super(description, basisPrice, quality, expirationDate);
    }

    @Override
    boolean isQuality() {
        return this.quality >= 30 && LocalDateTime.now().isBefore(expirationDate);
    }

    @Override
    public void dailyRoutine() {
        this.quality--;
        this.updatePrice();
        // Maybe some event here to be fired as the cheese is expiring
    }
}
