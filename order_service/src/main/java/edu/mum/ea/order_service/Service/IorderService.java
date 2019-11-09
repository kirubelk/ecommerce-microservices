package edu.mum.ea.order_service.Service;

import java.util.List;

import edu.mum.ea.order_service.model.Order;

public interface IorderService {
    List<Order> getAllOrders();
    Order createOrder(Order order);
}