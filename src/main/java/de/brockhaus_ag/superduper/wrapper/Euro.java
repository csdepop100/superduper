package de.brockhaus_ag.superduper.wrapper;

public class Euro {
    private double value;

    private Euro(double value) {
        this.value = value;
    }

    public static Euro valueOf(double value) {
        return new Euro(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Euro plus(Euro add) {
        return new Euro(this.value + add.value);
    }

    public Euro times(double factor) {
        return new Euro(this.value * factor);
    }
}
