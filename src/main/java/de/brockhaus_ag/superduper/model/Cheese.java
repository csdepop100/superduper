package de.brockhaus_ag.superduper.model;

import de.brockhaus_ag.superduper.wrapper.Euro;

import java.time.LocalDateTime;

import static org.apache.commons.lang3.BooleanUtils.isFalse;

public class Cheese extends Product {
    protected Cheese(String description,
                     Euro basisPrice,
                     Integer quality,
                     LocalDateTime expirationDate) {
        super(description, basisPrice, quality, expirationDate);
    }

    @Override
    boolean isQuality() {
        return this.quality >= 30 || LocalDateTime.now().isBefore(expirationDate);
    }

    @Override
    void dailyRoutine() {
        this.quality--;
        this.updatePrice();
        if(isFalse(isQuality())) {
            // todo: think about how to handle this
            System.out.println("stinky cheese! :C");
        }
    }
}
