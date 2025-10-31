public class DiscountApp {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();

        Customer[] customers = {
            new RegularCustomer(),
            new MemberCustomer(),
            new VIPCustomer(),
            new GuestCustomer(),
            new SeniorCustomer()
        };

        double[] amounts = { 100.0, 200.0, 300.0, 150.0, 150.0 };

        for (int i = 0; i < customers.length; i++) {
            double discount = calculator.calculateDiscount(customers[i], amounts[i]);
            System.out.println(customers[i].getType() + " customer, amount $" 
                               + amounts[i] + " : discount: $" + discount);
        }
    }
}
