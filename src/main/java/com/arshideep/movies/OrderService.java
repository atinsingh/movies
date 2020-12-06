package com.arshideep.movies;

import com.arshideep.movies.domain.Order;
import com.arshideep.movies.domain.User;
import com.arshideep.movies.repo.OrderRepo;
import com.arshideep.movies.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo repo;


    public Order createOrder(Order order) {
        return this.repo.save(order);
    }

    public List<Order> getAllOrders() {
        return this.repo.findAll();
    }

    public Order getOrderById(Long id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("Order Not Found"));

    }

    public void deleteOrder(Order order){
        repo.delete(order);
    }
}
