package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Movimientos")
@Data
@NoArgsConstructor
public class Movimientos {
    @Id
    private Long codigoMovimiento;
    private String legajo;
    private String detalle;
    private String desde;
    private String hasta;
    private LocalDate fecha;
    private String tipoMovimiento;
}
