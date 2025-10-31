public class SeniorCustomer implements Customer {
    private static final double DISCOUNT_RATE = 0.15; // 15%

    @Override
    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }

    @Override
    public String getType() {
        return "Senior";
    }
}
