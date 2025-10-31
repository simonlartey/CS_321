public class VIPCustomer implements Customer {
    private static final double DISCOUNT_RATE = 0.20; // 20%

    @Override
    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }

    @Override
    public String getType() {
        return "VIP";
    }
}
