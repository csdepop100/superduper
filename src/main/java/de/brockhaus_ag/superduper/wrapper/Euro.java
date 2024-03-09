package de.brockhaus_ag.superduper.wrapper;

public class Euro {
    /*
    I decided to use a wrapper class for the money in my application as I am not familiar
    with the details of how the financial world represents it in practice. I think using
    a wrapper like this allows me to adapt to different ways of handling money in code
    more easily.

    I was torn between using floating point numbers or integers, as integers are not as
    prone to have disgusting rounding errors (0.1 + 0.2 != 0.3). I was thinking about using integers to count
    the "cents" and then just shift the comma in the representation.
    In the end I decided to use floating point numbers to keep it simple for now, should
    the need for more safety arise this is the place to adjust it.
     */
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

    @Override
    public String toString() {
        return String.format("%.2f €", this.value);
    }
}
