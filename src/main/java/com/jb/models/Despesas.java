package com.jb.models;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Despesas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String item;
	
	@Column(name = "user_id")
	private Long userId;
	
	private String valor;
	
	@Column(name = "data_do_registro")
	private Date dataRegistro;
	
	@Column(name = "formas_de_pagamento")
	private String formasPagamento;
	
	private String categoria;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(String formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataRegistro, item, userId);
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesas other = (Despesas) obj;
		return Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(item, other.item)
				&& Objects.equals(userId, other.userId);
	}
	
	public String toString() {
		
		return "Despesa registrada: " + item + " Valor: " + valor + " Data do registro: " + dataRegistro + " Forma de pagamento: " + formasPagamento ;
	}
	
}
