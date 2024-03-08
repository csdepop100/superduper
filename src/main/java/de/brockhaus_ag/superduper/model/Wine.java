package de.brockhaus_ag.superduper.model;

import de.brockhaus_ag.superduper.wrapper.Euro;

import java.time.LocalDateTime;

public class Wine extends Product {
    private int qualityCounter;

    protected Wine(String description,
                   Euro basisPrice,
                   Integer quality,
                   LocalDateTime expirationDate) {
        super(description, basisPrice, quality, expirationDate);
    }

    @Override
    boolean isQuality() {
        return this.quality >= 0;
    }

    @Override
    void dailyRoutine() {
        if (this.quality > 50)
            return;

        qualityCounter++;
        if (qualityCounter >= 10) {
            this.quality++;
            qualityCounter = 0;
        }
    }

    @Override
    public void updatePrice() {
        // safety override - wine is exception
    }
}
