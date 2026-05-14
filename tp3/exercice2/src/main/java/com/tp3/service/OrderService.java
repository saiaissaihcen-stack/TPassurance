package com.tp3.service;

import com.tp3.model.Order;
import com.tp3.repository.OrderDao;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(Order order) {
        orderDao.save(order);
    }
}