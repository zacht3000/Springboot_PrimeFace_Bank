package com.teralco.cuentas.controller;

import com.teralco.cuentas.model.Cuenta;
import com.teralco.cuentas.model.Usuario;
import com.teralco.cuentas.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@ViewScoped
public class UsuarioController {

    private Usuario usuario;

    private Usuario usuarioEncontrado;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostConstruct
    public void init(){
        loadData();
    }

    public void loadData(){
        this.usuario = new Usuario();
    }

    public void auth(){
        usuarioEncontrado = usuarioRepository.findByMail(usuario.getMail());
        if(usuario.getPassword().equals(usuarioEncontrado.getPassword())){
            System.out.println("Ejecutando buscarCliente" + usuarioEncontrado.getNombre());
        } else {
            System.out.println("FFFFFFFFFFFFFFFFF");
        }

    }
    
}
