package utilities;
import interfaces.IChristmasDiscount;

public class ChristmasDiscount extends Discount implements IChristmasDiscount {
    public ChristmasDiscount(int discountPercentage) {
        super(discountPercentage);
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - (this.discountPercentage / 100.0));
    }
}