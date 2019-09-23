package cput.ac.za.service.system;

import cput.ac.za.domain.system.Order;
import cput.ac.za.service.IService;

import java.util.Set;

public interface OrderService extends IService<Order, String> {
    Set<Order> getAll();
}
