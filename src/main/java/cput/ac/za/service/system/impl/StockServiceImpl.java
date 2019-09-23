package cput.ac.za.service.system.impl;

import cput.ac.za.domain.system.Stock;
import cput.ac.za.repository.system.StockRepository;
import cput.ac.za.repository.system.impl.StockRepositoryImpl;
import cput.ac.za.service.system.StockService;

import java.util.Set;

public class StockServiceImpl implements StockService{
    private StockRepository repository;
    private static StockService userService = null;

    private StockServiceImpl() {
        this.repository = StockRepositoryImpl.getRepository();
    }

    public static StockService getService() {
        if (userService == null) userService = new StockServiceImpl();
        return userService;
    }

    @Override
    public Stock create(Stock d) {
        return this.repository.create(d);
    }

    @Override
    public Stock read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Stock update(Stock d) {
        return this.repository.update(d);
    }

    @Override
    public void delete(String d) {
        this.repository.delete(d);
    }

    @Override
    public Set<Stock> getAll() {
        return this.repository.getAll();
    }
}
