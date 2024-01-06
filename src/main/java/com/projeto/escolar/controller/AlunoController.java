package com.projeto.escolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.escolar.model.Aluno;
import com.projeto.escolar.repository.AlunoRepository;



@RestController
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	Aluno aluno = new Aluno();
	
		
	@GetMapping(value = "listartodos")
	@ResponseBody
	public ResponseEntity<List<Aluno>>listAluno(){
		List<Aluno>alunos = alunoRepository.findAll();
		return new ResponseEntity<List<Aluno>>(alunos,HttpStatus.OK);
	}
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Aluno>salvar(@RequestBody Aluno aluno){
	Aluno alu = alunoRepository.save(aluno);
		return new ResponseEntity<Aluno>(alu,HttpStatus.CREATED);
	}
	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String>delete(@RequestParam Long idalunos ){
	    alunoRepository.deleteById(idalunos);
		return new ResponseEntity<String>("aluno deletado com sucesso",HttpStatus.OK);
	}
	@GetMapping(value = "buscaralunoid")
	@ResponseBody
	public ResponseEntity<Aluno>buscaralunoid(@RequestParam(name = "idalunos" ) Long idalunos){
	   Aluno aluno = alunoRepository.findById(idalunos).get();
		return new ResponseEntity<Aluno>(aluno,HttpStatus.OK);
	}
	
	@PutMapping(value = "atualizar")//PRECISA INFORMAR O ID PARA ATUALIZAR
	@ResponseBody
	public ResponseEntity<?>atualizar(@RequestBody Aluno aluno){
		if (aluno.getId() == null) {
			return new ResponseEntity<String>("Erro: Para atualizar altere algum dado",HttpStatus.OK);
		}
		
		Aluno alu = alunoRepository.saveAndFlush(aluno);
		return new ResponseEntity<Aluno>(alu,HttpStatus.OK);
	}
	
	 
	@GetMapping(value = "buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Aluno>>buscarPorNome(@RequestParam(name = "name" ) String name){
	    List<Aluno> aluno = alunoRepository.buscarPorNome(name.trim().toUpperCase());
		return new ResponseEntity<List<Aluno>>(aluno,HttpStatus.OK);
	}
	
	@GetMapping(value = "buscarCpf")
	@ResponseBody
	public ResponseEntity<List<Aluno>>buscarCpf(@RequestParam(name = "name" ) String name){
	    List<Aluno> aluno = alunoRepository.buscarCpf(name.trim().toUpperCase());
		return new ResponseEntity<List<Aluno>>(aluno,HttpStatus.OK);
	}	
	
	

}
