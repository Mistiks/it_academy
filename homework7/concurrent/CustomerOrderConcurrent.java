package homeworks.homework7.concurrent;

public class CustomerOrderConcurrent implements Comparable<CustomerOrderConcurrent> {
    private int orderId;
    private double orderAmount;
    private String customerName;
    private double price;

    public CustomerOrderConcurrent(int orderId, double orderAmount, String customerName) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.customerName = customerName;
    }

    @Override
    public int compareTo(CustomerOrderConcurrent order) {
        return order.orderId > this.orderId ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Customer name: " + this.customerName + ", order amount: " + this.orderAmount
                + ", order id: " + this.orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}