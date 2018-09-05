package com.cest.Dao;

import org.springframework.data.repository.CrudRepository;
import com.cest.Models.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, String>{
	
}
