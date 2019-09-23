package cput.ac.za.factory.system;

import cput.ac.za.domain.system.Order;

public class OrderFactory {
    public static Order getOrder(String id, String description, String price){
        return new Order.Builder().id(id).description(description).price(price).build();
    }
}
