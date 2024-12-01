package com._deMayo.API25DeMayo.controller;

import com._deMayo.API25DeMayo.entity.Stock;
import com._deMayo.API25DeMayo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStock() {
        return stockService.getAllStock();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Optional<Stock> stock = stockService.getStockById(id);
        return stock.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        Stock stockUpdated = stockService.updateStock(id, stock);
        return stockUpdated != null ? ResponseEntity.ok(stockUpdated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Stock> deleteStock(@PathVariable Long id) {
        if(stockService.existsById(id)) {
            stockService.deleteStock(id);
            return ResponseEntity.ok().build();
        }
        return stockService.deleteStock(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}