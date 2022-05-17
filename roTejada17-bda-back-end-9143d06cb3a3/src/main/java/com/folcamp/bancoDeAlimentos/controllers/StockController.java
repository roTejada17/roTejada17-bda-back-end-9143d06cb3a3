package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.entity.Stock;
import com.folcamp.bancoDeAlimentos.repository.StockRepository;
import com.folcamp.bancoDeAlimentos.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockService stockService;

    @GetMapping("")
    public ResponseEntity<List<Stock>> getList() {
        List<Stock> list = stockService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }




}
