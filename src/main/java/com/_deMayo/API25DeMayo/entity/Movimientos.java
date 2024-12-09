package com._deMayo.API25DeMayo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false)
    private Integer legajo;

    private Integer desde;
    private Integer hasta;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    private String tipoMovimiento;

    @OneToMany(mappedBy = "movimiento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DetalleMovimiento> detalleMovimientos = new ArrayList<>();
}
