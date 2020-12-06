package com.arshideep.movies.controller;

import com.arshideep.movies.OrderService;
import com.arshideep.movies.UserService;
import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.domain.Order;
import com.arshideep.movies.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Orders", description = "Orders API")
@RequestMapping("/api/")

public class OrderController {
    @Autowired
    private OrderService service;



    @ApiOperation(value = "Create Order resource", response = Order.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = Order.class)})
    @PostMapping(value = "/order" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order createOrder(@RequestBody Order order) {
        return this.service.createOrder(order);
    }


    @ApiOperation(value = "Get all Order resources", response = Order.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = Order.class)})
    @GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getAllOrders() {
        return this.service.getAllOrders();
    }


    @ApiOperation(value = "Finds Order by id", response = Order.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = Order.class), @ApiResponse(code = 404, message = "Order respurce does not exists") })
    @GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrderById(@PathVariable("id") Long id) {
        return this.service.getOrderById(id);
    }



    @ApiOperation(value = "Delete Order ", response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 404, message = "Order resource does not exists") })
    @DeleteMapping(value = "/order")
    public void deleteOrder(@RequestBody Order order) {
        this.service.deleteOrder(order);
    }



    @ApiOperation(value = "Update Order resource", response = Order.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = Order.class)})
    @PutMapping(value = "/order" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody Order order) {
        return this.service.createOrder(order);
    }

}
