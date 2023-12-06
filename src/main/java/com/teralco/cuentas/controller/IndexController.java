package com.teralco.cuentas.controller;

import com.teralco.cuentas.model.Cuenta;
import com.teralco.cuentas.service.CuentaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    CuentaService cuentaService;
    private List<Cuenta> cuentas;
    private Cuenta cuentaSelection;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init(){
        loadData();
    }

    public void loadData(){
        this.cuentas = cuentaService.listasCuentas();
        cuentas.forEach((cuenta) -> logger.info(cuenta.toString()));
    }

    public void addCuenta(){
        logger.info("Se crea objeto cuentaSelection para caso de addCuenta" + this.cuentaSelection);
        this.cuentaSelection = new Cuenta();
    }

    public void saveCuenta(){
        logger.info("Cuenta a save:" + this.cuentaSelection);
        //Agregar
        if(this.cuentaSelection.getIdCuenta() == null){
            this.cuentaService.saveCuenta(this.cuentaSelection);
            this.cuentas.add(this.cuentaSelection);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cuenta agregada"));
        } else { //Actualizar
            this.cuentaService.saveCuenta(this.cuentaSelection);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cuenta actualizada"));
        }

        //Ocultamos ventana
        PrimeFaces.current().executeScript("PF('ventanaModalCuenta').hide()");
        //Actualizar tabla
        PrimeFaces.current().ajax().update("form-cuentas:mensajes",
                "form-cuentas:cuentas-tabla");
        //Reset
        this.cuentaSelection = null;
    }

    public void deleteCuenta(){
        logger.info("Cuenta a delete:" + this.cuentaSelection);
        this.cuentaService.deleteCuenta(this.cuentaSelection);

        this.cuentas.remove(this.cuentaSelection);
        //Reset
        this.cuentaSelection = null;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cuenta eliminada"));
        PrimeFaces.current().ajax().update("form-cuentas:mensajes",
                "form-cuentas:cuentas-tabla");
    }
}
