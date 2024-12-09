package com._deMayo.API25DeMayo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_compra")
@Data
@NoArgsConstructor
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "codigo_compra", nullable = false)
    @JsonBackReference
    private Compras compra;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private String unidad;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Double precio;

    // Método toString sin el objeto compra para evitar recursión infinita
    @Override
    public String toString() {
        return "DetalleCompra{" +
                "idDetalle=" + idDetalle +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}