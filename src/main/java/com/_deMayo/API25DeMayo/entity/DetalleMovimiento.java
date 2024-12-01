package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(DetalleMovimientoId.class)
@Table(name = "detalle_movimientos")
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
