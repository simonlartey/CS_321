public class GuestCustomer implements Customer {
    private static final double DISCOUNT_RATE = 0.0; 

    @Override
    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }

    @Override
    public String getType() {
        return "Guest";
    }
}
