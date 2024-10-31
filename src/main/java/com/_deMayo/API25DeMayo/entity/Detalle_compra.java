package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(Detalle_compra.class)
@Table(name = "Detalle_compra")
@Data
@NoArgsConstructor
public class Detalle_compra {
    @Id
    private Long idProducto;
    @Id
    private Long codigoCompra;
    private String nombre;
    private Integer cantidad;
    private Double precio;
}
