package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(DetalleMovimientoId.class)
@Table(name = "Detalle_Movimientos")
@Data
@NoArgsConstructor
public class DetalleMovimiento {
    @Id
    private Long codigoMovimiento;
    @Id
    private Long idProducto;
    private Integer cantidad;
    private Double precio;
}
