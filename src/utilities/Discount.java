package utilities;

import interfaces.IDiscount;

public abstract class Discount implements IDiscount {
    public int discountPercentage;

    public Discount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public abstract double applyDiscount(double price);
}
