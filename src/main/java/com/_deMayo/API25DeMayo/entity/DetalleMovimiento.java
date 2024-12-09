package com._deMayo.API25DeMayo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_movimientos")
@Data
@NoArgsConstructor
public class DetalleMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleMovimiento;

    @ManyToOne
    @JoinColumn(name = "codigo_movimiento", nullable = false)
    @JsonBackReference
    private Movimientos movimiento;

    private Integer idProducto;
    private Integer cantidad;

    @Column(name = "precio_total", nullable = false)
    private BigDecimal precioTotal;

    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;
}
