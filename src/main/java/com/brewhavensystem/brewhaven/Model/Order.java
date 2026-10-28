package com.brewhavensystem.brewhaven.Model;

import java.util.List;

// A saved order.
public class Order {

    private final String orderNumber;
    private final String orderType;
    private final String customerName;
    private final List<Line> lines;

    public Order(String orderNumber, String orderType, String customerName, List<Line> lines) {
        this.orderNumber = orderNumber;
        this.orderType = orderType;
        this.customerName = customerName;
        this.lines = lines;
    }

    public String getOrderNumber() { return orderNumber; }
    public String getOrderType() { return orderType; }
    public String getCustomerName() { return customerName; }
    public List<Line> getLines() { return lines; }

    public double getTotal() {
        double total = 0;
        for (Line line : lines) {
            total += line.getSubtotal();
        }
        return total;
    }

    // One line of the order, e.g. "2 x Cappuccino".
    public static class Line {
        private final String name;
        private final double price;
        private final int qty;

        public Line(String name, double price, int qty) {
            this.name = name;
            this.price = price;
            this.qty = qty;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public int getQty() { return qty; }
        public double getSubtotal() { return price * qty; }
    }
}