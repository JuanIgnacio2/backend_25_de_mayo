package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(Detalle_compra.class)
@Table(name = "detalle_compra")
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
