package com.teralco.cuentas.repository;

import com.teralco.cuentas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByMail(String mail);
}
