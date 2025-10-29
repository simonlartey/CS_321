public class DiscountCalculator {
        public double calculateDiscount(Customer customer, double amount) {
            return amount * customer.getDiscountRate();
        }
    }
    