package cput.ac.za.service.system.impl;

import cput.ac.za.domain.system.Order;
import cput.ac.za.repository.system.OrderRepository;
import cput.ac.za.repository.system.impl.OrderRepositoryImpl;
import cput.ac.za.service.system.OrderService;

import java.util.Set;

public class OrderServiceImpl implements OrderService {
    private OrderRepository repository;
    private static OrderService userService = null;

    private OrderServiceImpl() {
        this.repository = OrderRepositoryImpl.getRepository();
    }

    public static OrderService getService() {
        if (userService == null) userService = new OrderServiceImpl();
        return userService;
    }

    @Override
    public Order create(Order d) {
        return this.repository.create(d);
    }

    @Override
    public Order read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Order update(Order d) {
        return this.repository.update(d);
    }

    @Override
    public void delete(String d) {
        this.repository.delete(d);
    }

    @Override
    public Set<Order> getAll() {
        return this.repository.getAll();
    }
}
