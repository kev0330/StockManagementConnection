package cput.ac.za.repository.system;

import cput.ac.za.domain.system.Stock;
import cput.ac.za.repository.IRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StockRepository extends CrudRepository<Stock, Long> {

}
