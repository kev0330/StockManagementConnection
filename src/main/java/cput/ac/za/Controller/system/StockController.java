package cput.ac.za.Controller.system;


import cput.ac.za.domain.system.Stock;
import cput.ac.za.service.system.impl.StockServiceImpl;
import exceptions.RecordNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class StockController {
    @Autowired
    StockServiceImpl service;

    @RequestMapping
    public String getAllStock(Model model)
    {
        List<Stock> list = service.getAllStock();

        model.addAttribute("stock", list);
        return "list-stock";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editStock(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotExist
    {
        if (id.isPresent()) {
            Stock entity = service.getStock(id.get());
            model.addAttribute("stock", entity);
        } else {
            model.addAttribute("stock", new Stock());
        }
        return "edit-stock";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteStock(Model model, @PathVariable("id") Long id)
            throws RecordNotExist
    {
        service.deleteStock(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createStock", method = RequestMethod.POST)
    public String createOrUpdateStock(Stock stock)
    {
        service.createOrUpdateStock(stock);
        return "redirect:/";
    }
}
