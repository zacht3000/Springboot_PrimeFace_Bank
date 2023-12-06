package com.teralco.cuentas.service;

import com.teralco.cuentas.model.Cuenta;

import java.util.List;

public interface ICuentaService {
    public List<Cuenta> listasCuentas();

    public Cuenta buscarCuentaPorId(Integer idCuenta);

    public void saveCuenta(Cuenta cuenta);

    public void deleteCuenta(Cuenta cuenta);
}
