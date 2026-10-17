package week_8.class_problems;

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        ShoppingCustomer customerX = new ShoppingCustomer("Customer X");
        ShoppingOrder orderX = customerX.createOrder("Order X");
        orderX.addProduct(new ShoppingProduct("Product A", 10.00), 2);
        orderX.addProduct(new ShoppingProduct("Product B", 25.00), 1);
        orderX.payWith(new CreditCardPayment());

        ShoppingCustomer customerY = new ShoppingCustomer("Customer Y");
        ShoppingOrder orderY = customerY.createOrder("Order Y");
        orderY.payWith(new CreditCardPayment());

        ShoppingCustomer customerZ = new ShoppingCustomer("Customer Z");
        ShoppingOrder orderZ = customerZ.createOrder("Order Z");
        orderZ.addProduct(new ShoppingProduct("Product C", 15.00), 1);
        orderZ.payWith(new PayPalPayment(false));
    }
}