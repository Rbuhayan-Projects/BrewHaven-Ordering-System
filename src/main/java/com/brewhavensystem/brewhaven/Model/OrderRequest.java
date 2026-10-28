package com.brewhavensystem.brewhaven.Model;

import java.util.List;

// The data the checkout page sends to the server (as JSON).
public class OrderRequest {

    private String orderType;      // "Dine In" or "Take Out"
    private String customerName;
    private List<Line> items;

    public String getOrderType() { return orderType; }
    public void setOrderType(String orderType) { this.orderType = orderType; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public List<Line> getItems() { return items; }
    public void setItems(List<Line> items) { this.items = items; }

    // One ordered item: only the id and quantity are sent. Prices come from the server.
    public static class Line {
        private int id;
        private int qty;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public int getQty() { return qty; }
        public void setQty(int qty) { this.qty = qty; }
    }
}