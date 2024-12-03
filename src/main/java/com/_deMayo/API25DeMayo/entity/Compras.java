package com._deMayo.API25DeMayo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

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

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DetalleCompra> detalleCompras = new ArrayList<>();

    public void addDetalle(DetalleCompra detalle) {
        detalleCompras.add(detalle);
        detalle.setCompra(this);
    }

    public void removeDetalle(DetalleCompra detalle) {
        detalleCompras.remove(detalle);
        detalle.setCompra(null);
    }
}