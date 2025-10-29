public class RegularCustomer implements Customer {
    private static final double DISCOUNT_RATE = 0.05; // 5%

    @Override
    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }

    @Override
    public String getType() {
        return "Regular";
    }
}
