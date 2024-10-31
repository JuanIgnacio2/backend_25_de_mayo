package com._deMayo.API25DeMayo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetalleCompraId {
    private Long idProducto;
    private Long codigoCompra;
}
