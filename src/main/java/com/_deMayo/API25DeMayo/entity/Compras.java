package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compras")
@Data
@NoArgsConstructor
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoCompra;
    private String cuitProveedor;
    private LocalDate fechaCompra;
    private Integer codigoDeposito;
}
