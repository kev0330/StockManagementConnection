package cput.ac.za.repository.system;

import cput.ac.za.domain.system.Stock;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface StockRepository extends IRepository<Stock, String> {
    Set<Stock> getAll();
}
