package com._deMayo.API25DeMayo.service;

import com._deMayo.API25DeMayo.entity.Depositos;

import java.util.Optional;
import java.util.List;

public interface DepositoService {
    List<Depositos> getAllDepositos();
    Optional<Depositos> getDepositoById(String codigo);
    Depositos createDeposito(Depositos depositos);
    Depositos updateDeposito(String codigo, Depositos depositos);
    boolean deleteDeposito(String codigo);
}
