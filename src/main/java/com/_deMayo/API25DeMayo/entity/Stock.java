package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String codigoDeposito;
    private String nombre;
    private Integer cantidad;
    private Integer stockMinimo;
    private Integer stockMaximo;
    private Double precio;
}