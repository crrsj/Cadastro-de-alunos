package com.projeto.escolar.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "seq_aluno",sequenceName = "sequence_aluno",allocationSize = 1, initialValue = 1)
public class Aluno implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente")	
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private int matricula;
	@Temporal(TemporalType.DATE)
	private Date dataMat;
	private String anoEscolaridade;
	private String curso;
	private String turma;
	private String turno;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getAnoEscolaridade() {
		return anoEscolaridade;
	}
	public void setAnoEscolaridade(String anoEscolaridade) {
		this.anoEscolaridade = anoEscolaridade;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public Date getDataMat() {
		return dataMat;
	}
	public void setDataMat(Date dataMat) {
		this.dataMat = dataMat;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

    







}
