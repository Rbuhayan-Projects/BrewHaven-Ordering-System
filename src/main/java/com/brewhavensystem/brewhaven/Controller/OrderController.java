package com.brewhavensystem.brewhaven.Controller;

import com.brewhavensystem.brewhaven.Model.Order;
import com.brewhavensystem.brewhaven.Model.OrderRequest;
import com.brewhavensystem.brewhaven.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Checkout page (reads the cart from the browser).
    @GetMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }

    // Called by the checkout page when "Place Order" is pressed.
    @PostMapping("/orders")
    @ResponseBody
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody OrderRequest request) {
        try {
            Order order = orderService.placeOrder(request);
            return ResponseEntity.ok(Map.of("orderNumber", order.getOrderNumber()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Confirmation page, e.g. /order/A-001
    @GetMapping("/order/{number}")
    public String confirmationPage(@PathVariable("number") String number, Model model) {
        Order order = orderService.findByNumber(number);
        if (order == null) {
            return "redirect:/menu";
        }
        model.addAttribute("order", order);
        return "confirmation";
    }
}