package cput.ac.za.service.system.impl;

import cput.ac.za.domain.system.Stock;
import cput.ac.za.repository.system.StockRepository;
import cput.ac.za.service.IService;
import exceptions.RecordNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl{

    @Autowired
    StockRepository repository;

    public List<Stock> getAllStock()
    {
        List<Stock> result = (List<Stock>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Stock>();
        }
    }

    public Stock getStock(Long id) throws RecordNotExist
    {
        Optional<Stock> stock = repository.findById(id);

        if(stock.isPresent()) {
            return stock.get();
        } else {
            throw new RecordNotExist("Does Not Exist");
        }
    }

    public Stock createOrUpdateStock(Stock stocks)
    {
        if(stocks.getId()  == null)
        {
            stocks = repository.save(stocks);

            return stocks;
        }
        else
        {
            Optional<Stock> stock = repository.findById(stocks.getId());

            if(stock.isPresent())
            {
                Stock newStock = stock.get();
                newStock.setQty(stocks.getQty());
                newStock.setDescription(stocks.getDescription());
                newStock.setPrice(stocks.getPrice());


                newStock = repository.save(newStock);

                return newStock;
            } else {
                stocks = repository.save(stocks);

                return stocks;
            }
        }
    }

    public void deleteStock(Long id) throws RecordNotExist
    {
        Optional<Stock> stock = repository.findById(id);

        if(stock.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotExist("Does Not Exist");
        }
    }

}
