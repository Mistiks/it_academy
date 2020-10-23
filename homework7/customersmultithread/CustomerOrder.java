package homeworks.homework7.customersmultithread;

public class CustomerOrder implements Comparable<CustomerOrder> {
    private int orderId;
    private double orderAmount;
    private String customerName;
    private double price;

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