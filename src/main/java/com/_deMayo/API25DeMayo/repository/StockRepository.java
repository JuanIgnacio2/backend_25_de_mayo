package com._deMayo.API25DeMayo.repository;

import com._deMayo.API25DeMayo.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByNombre(String nombre);
}