package com.funcionarios.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funcionarios.apirest.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	Funcionario findById(long id);

}
