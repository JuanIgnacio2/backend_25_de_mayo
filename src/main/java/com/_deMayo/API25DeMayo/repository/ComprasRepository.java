package com._deMayo.API25DeMayo.repository;

import com._deMayo.API25DeMayo.entity.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long> {
}
