package model;

public class Order implements Payable {

    private int orderId;
    private Customer customer;

    private MenuItem[] items;

    private int itemCount;
    private OrderStatus status;

    private static final double GST_RATE = 0.05;
    private static final double DISCOUNT_RATE = 0.10;

    public Order() {

        this(
                0,
                null,
                10
        );
    }

    public Order(
            int orderId,
            Customer customer,
            int capacity) {

        this.orderId = orderId;
        this.customer = customer;

        this.items = new MenuItem[capacity];

        this.itemCount = 0;
        this.status = OrderStatus.PLACED;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MenuItem[] getItems() {
        return items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(MenuItem item) {

        if (item == null) {
            return;
        }

        if (!item.isAvailable()) {

            System.out.println(
                    "Item is unavailable."
            );

            return;
        }

        if (itemCount >= items.length) {

            System.out.println(
                    "Order is full."
            );

            return;
        }

        items[itemCount] = item;
        itemCount++;

        System.out.println(
                item.getItemName()
                        + " added to order."
        );
    }

    @Override
    public double calculateTotal() {

        double subtotal = 0.0;

        for (int i = 0; i < itemCount; i++) {

            subtotal += items[i].getPrice();
        }

        double gst = subtotal * GST_RATE;

        double discount = 0.0;

        if (customer != null
                && customer.getLoyaltyPoints() >= 100) {

            discount = subtotal * DISCOUNT_RATE;
        }

        return subtotal + gst - discount;
    }

    public double calculateTotal(int serviceCharge) {

        return calculateTotal() + serviceCharge;
    }

    public int getRoundedBill() {

        return (int) calculateTotal();
    }

    @Override
    public String toString() {

        String customerName;

        if (customer != null) {
            customerName = customer.getName();
        } else {
            customerName = "Unknown";
        }

        return String.format(
                "Order ID: %d | Customer: %s | Items: %d | "
                        + "Status: %s | Total: Rs. %.2f",
                orderId,
                customerName,
                itemCount,
                status,
                calculateTotal()
        );
    }
}