package homeworks.homework7.examples;

public class CustomerOrder implements Comparable<CustomerOrder> {
    private int orderId;
    private double orderAmount;
    private String customerName;

    public CustomerOrder(int orderId, double orderAmount, String customerName) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.customerName = customerName;
    }

    @Override
    public int compareTo(CustomerOrder order) {
        return order.orderId > this.orderId ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Customer name: " + this.customerName + ", order amount: " + this.orderAmount
                + ", order id: " + this.orderId;
    }
}