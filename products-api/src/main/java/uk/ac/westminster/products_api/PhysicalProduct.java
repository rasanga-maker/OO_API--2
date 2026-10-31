package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it is a specific type of product
// A ShoppingCart is not a Product because it contains products (HAS-A)
public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName()
                + " | Weight: " + getWeightKg() + " kg";
    }

    private double discountedPrice;

    @Override
    public void applyDiscount(double rate) {
        double validRate = Math.min(rate, 0.20);
        discountedPrice = getPrice() * (1 - validRate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
