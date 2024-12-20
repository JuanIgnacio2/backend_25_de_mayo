package com._deMayo.API25DeMayo.service.impl;

import com._deMayo.API25DeMayo.service.DepositoService;
import com._deMayo.API25DeMayo.repository.DepositoRepository;
import com._deMayo.API25DeMayo.entity.Depositos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositosServiceImpl implements DepositoService {
    @Autowired
    private DepositoRepository depositoRepository;

    @Override
    public List<Depositos> getAllDepositos(){
        return depositoRepository.findAll();
    }

    @Override
    public Optional<Depositos> getDepositoById(Integer codigoDeposito){
        return depositoRepository.findById(codigoDeposito);
    }

    @Override
    public Depositos createDeposito(Depositos deposito){
        return depositoRepository.save(deposito);
    }

    @Override
    public Depositos updateDeposito(Integer codigoDeposito, Depositos deposito){
        return depositoRepository.findById(codigoDeposito).map(depositos ->{
            depositos.setNombre(deposito.getNombre());
            depositos.setDireccion(deposito.getDireccion());
            return depositoRepository.save(depositos);
        }).orElse(null);
    }

    @Override
    public boolean deleteDeposito(Integer codigoDeposito){
        return depositoRepository.findById(codigoDeposito).map(depositos -> {
            depositoRepository.delete(depositos);
            return true;
        }).orElse(false);
    }
}