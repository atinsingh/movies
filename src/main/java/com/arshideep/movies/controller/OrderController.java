package com.arshideep.movies.controller;


import com.arshideep.movies.domain.Order;
import com.arshideep.movies.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public List<Order> getAllOrders(){
        return  orderService.getAllOrders();
    }

    @GetMapping("/id")
    public Order getOrderById(@PathVariable Long id){ return orderService.getOrderById(id);}

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) { return orderService.updateOrder(order);}

    @DeleteMapping
    public void deleteOrder(@RequestBody Order order) { orderService.deleteOrder(order); }

}
