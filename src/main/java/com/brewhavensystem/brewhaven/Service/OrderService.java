package com.brewhavensystem.brewhaven.Service;

import com.brewhavensystem.brewhaven.Model.MenuItem;
import com.brewhavensystem.brewhaven.Model.Order;
import com.brewhavensystem.brewhaven.Model.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderService {

    private final MenuService menuService;

    private final Map<String, Order> orders = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public OrderService(MenuService menuService){
        this.menuService = menuService;
    }

    public Order placeOrder(OrderRequest request){
        if (request.getItems() == null || request.getItems().isEmpty()){
            throw new IllegalArgumentException("Your order is Empty");
        }
        String name = request.getCustomerName()  == null ? "" : request.getCustomerName().trim();
        if (name.isEmpty()){
            throw new IllegalArgumentException("Please enter your name,");
        }
        if (name.length()>40){
            name = name.substring(0,40);
        }
        String type = "Take Out".equals(request.getOrderType()) ? "Take Out " : "Dine In";

        List<Order.Line> lines = new ArrayList<>();
        for(OrderRequest.Line requested : request.getItems()){
            MenuItem item = menuService.findById(requested.getId());
            if (item == null || requested.getQty()< 1 ||  requested.getQty() > 500){
                throw new IllegalArgumentException("Something in your order is not valid.");
            }
            lines.add(new Order.Line(item.getName(), item.getPrice(), requested.getQty()));
        }

        String orderNumber = String.format("A-%03d", counter.incrementAndGet());
        Order order = new Order(orderNumber,type, name, lines);
        orders.put(orderNumber, order);
        return order;
    }
    public Order findByNumber(String orderNumber){
        return orders.get(orderNumber);
    }
}
