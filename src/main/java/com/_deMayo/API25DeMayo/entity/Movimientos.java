package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movimientos")
@Data
@NoArgsConstructor
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoMovimiento;
    private Integer legajo;
    private String detalle;
    private Integer desde;
    private String hasta;
    private LocalDate fecha;
    private String tipoMovimiento;
}
