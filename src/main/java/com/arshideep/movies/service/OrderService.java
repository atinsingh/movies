package com.arshideep.movies.service;


import com.arshideep.movies.domain.Order;
import com.arshideep.movies.exception.OrderNotFoundException;
import com.arshideep.movies.repo.OrderRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }
    public Order getOrderById(Long id){
        Optional<Order> byId = this.orderRepo.findById(id);
        if(!byId.isPresent()){
            throw new OrderNotFoundException("Request Order"+id+"Not Avaliable");
        }else {
            return byId.get();
        }

    }
    public Order addOrder(@RequestBody Order order){
        return orderRepo.save(order);
    }
    public Order updateOrder(@RequestBody Order order){
        return orderRepo.save(order);
    }
    public void deleteOrder(@RequestBody Order order){
        orderRepo.delete(order);
    }
}
