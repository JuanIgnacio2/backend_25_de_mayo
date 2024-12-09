package com._deMayo.API25DeMayo.repository;

import com._deMayo.API25DeMayo.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByNombre(String nombre);

    @Query("SELECT s FROM Stock s ORDER BY (s.cantidad * s.precio) DESC")
    List<Stock> findTop5ByTotalPrice(Pageable pageable);

    @Query("SELECT DISTINCT s.tipo from Stock s where s.tipo IS NOT NULL AND s.tipo <> ''")
    List<String> findDistinctTipo();
}