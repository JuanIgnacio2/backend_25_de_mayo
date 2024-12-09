package com._deMayo.API25DeMayo.repository;

import com._deMayo.API25DeMayo.entity.DetalleMovimiento;
import com._deMayo.API25DeMayo.entity.DetalleMovimientoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DetalleMovimientoRepository extends JpaRepository<DetalleMovimiento, Long> {
}
