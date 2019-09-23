package cput.ac.za.repository.system.impl;

import cput.ac.za.domain.system.Stock;
import cput.ac.za.repository.system.StockRepository;

import java.util.HashSet;
import java.util.Set;

public class StockRepositoryImpl implements StockRepository {

    private Set<Stock> db;
    private static StockRepository repository = null;

    private StockRepositoryImpl() {
        this.db = new HashSet<>();
    }

    private Stock find(String stock) {
        return this.db.stream()
                .filter(id -> id.getId().equals(stock))
                .findAny()
                .orElse(null);
    }

    public static StockRepository getRepository(){
        if(repository == null) repository = new StockRepositoryImpl();
        return repository;
    }

    public Stock create(Stock stock){
        this.db.add(stock);
        return stock;
    }

    public Stock read(final String id){
        Stock find = find(id);
        return find;
    }

    public void delete(String id) {
        Stock find = find(id);
        if(find != null) this.db.remove(find);
    }

    public Stock update(Stock stock) {
        Stock delete = find(stock.getId());
        if(delete != null){
            this.db.remove(delete);
            return create(stock);
        }
        return stock;
    }

    public Set<Stock> getAll(){
        return this.db;
    }
}
