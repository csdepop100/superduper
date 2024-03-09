package de.brockhaus_ag.superduper.model;

import de.brockhaus_ag.superduper.wrapper.Euro;

public class Wine extends Product {
    private int qualityCounter;

    public Wine(String description,
                Euro basisPrice,
                Integer quality) {
        super(description, basisPrice, quality, null);
        this.price = this.basisPrice.plus(Euro.valueOf(0.1 * quality));
    }

    @Override
    boolean isQuality() {
        return this.quality >= 0;
    }

    @Override
    public void dailyRoutine() {
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
