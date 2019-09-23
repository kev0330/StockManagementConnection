package cput.ac.za.factory.system;

import cput.ac.za.domain.system.Stock;

public class StockFactory {
    public static Stock getStock(String id, String description, String price){
        return new Stock.Builder().id(id).description(description).price(price).build();
    }
}
