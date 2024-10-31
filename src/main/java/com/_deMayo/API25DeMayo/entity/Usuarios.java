package com._deMayo.API25DeMayo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuarios")
@Data
@NoArgsConstructor
public class Usuarios {
    @Id
    private String legajo;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private String dni;
    private String cargo;
}
