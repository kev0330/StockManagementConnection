package cput.ac.za.repository.system.impl;

import cput.ac.za.domain.system.Order;
import cput.ac.za.repository.system.OrderRepository;

import java.util.HashSet;
import java.util.Set;

public class OrderRepositoryImpl implements OrderRepository {

    private Set<Order> db;
    private static OrderRepository repository = null;

    private OrderRepositoryImpl() {
        this.db = new HashSet<>();
    }

    private Order find(String order) {
        return this.db.stream()
                .filter(id -> id.getId().equals(order))
                .findAny()
                .orElse(null);
    }

    public static OrderRepository getRepository(){
        if(repository == null) repository = new OrderRepositoryImpl();
        return repository;
    }

    public Order create(Order order){
        this.db.add(order);
        return order;
    }

    public Order read(final String id){
        Order find = find(id);
        return find;
    }

    public void delete(String id) {
        Order find = find(id);
        if(find != null) this.db.remove(find);
    }

    public Order update(Order order) {
        Order delete = find(order.getId());
        if(delete != null){
            this.db.remove(delete);
            return create(order);
        }
        return order;
    }

    public Set<Order> getAll(){
        return this.db;
    }
}
