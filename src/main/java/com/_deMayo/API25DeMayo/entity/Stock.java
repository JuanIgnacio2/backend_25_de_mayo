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

    private Integer codigo_deposito;
    private String nombre;
    private Integer cantidad;
    private Integer stock_minimo;
    private Integer stock_maximo;
    private Double precio;
}