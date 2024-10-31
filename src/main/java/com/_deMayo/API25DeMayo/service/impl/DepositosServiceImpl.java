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
    public Optional<Depositos> getDepositoById(String codigo){
        return depositoRepository.findById(codigo);
    }

    @Override
    public Depositos createDeposito(Depositos deposito){
        return depositoRepository.save(deposito);
    }

    @Override
    public Depositos updateDeposito(String codigo, Depositos deposito){
        return depositoRepository.findById(codigo).map(depositos ->{
            depositos.setNombre(depositos.getNombre());
            depositos.setDireccion(depositos.getDireccion());
            return depositoRepository.save(depositos);
        }).orElse(null);
    }

    @Override
    public boolean deleteDeposito(String codigo){
        return depositoRepository.findById(codigo).map(depositos -> {
            depositoRepository.delete(depositos);
            return true;
        }).orElse(false);
    }
}