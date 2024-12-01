package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.Depositos;

import java.util.Optional;
import java.util.List;

public interface DepositoService {
    List<Depositos> getAllDepositos();
    Optional<Depositos> getDepositoById(Integer codigoDeposito);
    Depositos createDeposito(Depositos depositos);
    Depositos updateDeposito(Integer codigoDeposito, Depositos depositos);
    boolean deleteDeposito(Integer codigoDeposito);
}
