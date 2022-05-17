package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.entity.Stock;
import com.folcamp.bancoDeAlimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StockService {

    @Autowired
    StockRepository stockRepository;


    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    public Optional<Stock> getById(Integer id) {
        return stockRepository.findById(id);
    }

    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    public void delete(Integer id) {
        stockRepository.deleteById(id);
    }


    public boolean existsById(Integer id) {
        return stockRepository.existsById(id);
    }
}
