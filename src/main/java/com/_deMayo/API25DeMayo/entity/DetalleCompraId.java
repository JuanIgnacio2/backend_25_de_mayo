package com._deMayo.API25DeMayo.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DetalleCompraId implements Serializable {
    private Long idProducto;
    private Long codigo_compra;

    public DetalleCompraId() {}

    public DetalleCompraId(Long idProducto, Long codigo_compra) {
        this.idProducto = idProducto;
        this.codigo_compra = codigo_compra;
    }
}
