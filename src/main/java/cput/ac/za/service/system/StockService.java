package cput.ac.za.service.system;

import cput.ac.za.domain.system.Stock;
import cput.ac.za.service.IService;

import java.util.Set;

public interface StockService extends IService<Stock, String> {
    Set<Stock> getAll();
}
