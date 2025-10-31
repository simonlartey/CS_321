public class MemberCustomer implements Customer {
    private static final double DISCOUNT_RATE = 0.10; // 10%

    @Override
    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }

    @Override
    public String getType() {
        return "Member";
    }
}
