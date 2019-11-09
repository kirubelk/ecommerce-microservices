package edu.mum.ea.order_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.ea.order_service.model.Order;
import edu.mum.ea.order_service.repository.OrderRepository;

@Service
public class OrderService implements IorderService {

    @Autowired
    private OrderRepository repo;

    @Override
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        return repo.save(order);
    }
    
}