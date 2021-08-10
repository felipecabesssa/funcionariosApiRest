package com.funcionarios.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funcionarios.apirest.models.Funcionario;
import com.funcionarios.apirest.repository.FuncionarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Funcionarios")
@CrossOrigin(origins="*")
public class FuncionarioResource {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/funcionario")
	@ApiOperation(value="Retorna uma lista de funcionarios")
	public List<Funcionario> listaFuncionarios(){
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/funcionario/{id}")
	@ApiOperation(value="Retorna um unico funcionario")
	public Funcionario listaFuncionarioUnico(@PathVariable(value="id") long id) {
		return funcionarioRepository.findById(id);
	}
	
	@PostMapping("/funcionario")
	@ApiOperation(value="Cadastra funcionário")
	public Funcionario salvaFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
		
	}
	
	@DeleteMapping("/funcionario")
	@ApiOperation(value="Deleta funcionario")
	public void deletaFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepository.delete(funcionario);

	}
	
	@PutMapping("/funcionario")
	@ApiOperation(value="Atualiza funcionario")
	public Funcionario atualizaFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);

	}
	
}
