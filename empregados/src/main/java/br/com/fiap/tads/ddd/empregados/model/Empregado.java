package br.com.fiap.tads.ddd.empregados.model;

import java.time.LocalDate;

public class Empregado {

	private Long id;

	private String nome;

	private LocalDate dataAdmissao;

	private double salario;

	private LocalDate dataDesligamento;

	public Empregado(Long id, String nome, LocalDate dataAdmissao, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public Empregado(Long id, String nome, LocalDate dataAdmissao, double salario, LocalDate dataDesligamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
		this.dataDesligamento = dataDesligamento;
	}

	public Empregado() {
		super();
	}

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

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(LocalDate dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	@Override
	public String toString() {
		return "Empregado [id=" + id + ", nome=" + nome + ", dataAdmissao=" + dataAdmissao + ", salario=" + salario
				+ ", dataDesligamento=" + dataDesligamento + "]";
	}

}
