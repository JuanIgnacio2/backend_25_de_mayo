package com._deMayo.API25DeMayo.repository;

import com._deMayo.API25DeMayo.entity.DetalleCompraId;
import com._deMayo.API25DeMayo.entity.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, DetalleCompraId> {
}
