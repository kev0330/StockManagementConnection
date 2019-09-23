package cput.ac.za.repository.system;

import cput.ac.za.domain.system.Order;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface OrderRepository extends IRepository<Order, String> {
    Set<Order> getAll();
}

