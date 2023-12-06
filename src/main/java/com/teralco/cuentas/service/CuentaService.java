package com.teralco.cuentas.service;

import com.teralco.cuentas.model.Cuenta;
import com.teralco.cuentas.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService implements ICuentaService{

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> listasCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta buscarCuentaPorId(Integer idCuenta) {
        return cuentaRepository.findById(idCuenta).orElse(null);
    }

    @Override
    public void saveCuenta(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteCuenta(Cuenta cuenta) {
        cuentaRepository.delete(cuenta);
    }
}
