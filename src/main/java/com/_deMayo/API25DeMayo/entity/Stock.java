package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stock")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    @Column(name = "codigo_deposito", nullable = false)
    private Integer codigo_deposito;
    private String nombre;
    private Integer cantidad;
    private String unidad;
    private Integer stock_minimo;
    private Double precio;
    private String tipo;
}