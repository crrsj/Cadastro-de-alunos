package com.projeto.escolar.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.escolar.model.Aluno;
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	@Query(value = "select a from Aluno a where upper(trim(a.nome)) like %?1% ") 
	List<Aluno>buscarPorNome(String name);
    @Query(value  = "select a from Aluno a where upper(trim(a.cpf)) like %?1% ")
    List<Aluno>buscarCpf(String name);
    

}
