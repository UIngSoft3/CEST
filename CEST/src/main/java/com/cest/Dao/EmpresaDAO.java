package com.cest.Dao;
import org.springframework.data.repository.CrudRepository;

import com.cest.Models.Empresa;

public interface EmpresaDAO extends CrudRepository<Empresa, Integer> {

}
