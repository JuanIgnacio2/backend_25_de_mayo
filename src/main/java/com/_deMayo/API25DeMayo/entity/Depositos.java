package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Depositos")
@Data
@NoArgsConstructor
public class Depositos {
    @Id
    private String codigoDeposito;
    private String nombre;
    private String direccion;
}
