package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Compras")
@Data
@NoArgsConstructor
public class Compras {
    @Id
    private Long codigoCompra;
    private String cuitProveedor;
    private LocalDate fechaCompra;
    private String codigoDeposito;
}
