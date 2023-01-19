package com.ewave.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Agente implements Serializable {
	
	private static final long serialVersionUID = 7938154021714488078L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long codigo;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date data;	
	
	private String regiao;
	
	private BigDecimal geracao;

	private BigDecimal compra;
	
	private BigDecimal precoMedio;
	
	public Agente() {
	}

	public Agente(Long codigo, Date data, String regiao, BigDecimal geracao, BigDecimal compra,
			BigDecimal precoMedio) {
		this.codigo = codigo;
		this.data = data;
		this.regiao = regiao;
		this.geracao = geracao;
		this.compra = compra;
		this.precoMedio = precoMedio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public BigDecimal getGeracao() {
		return geracao;
	}

	public void setGeracao(BigDecimal geracao) {
		this.geracao = geracao;
	}

	public BigDecimal getCompra() {
		return compra;
	}

	public void setCompra(BigDecimal compra) {
		this.compra = compra;
	}

	public BigDecimal getPrecoMedio() {
		return precoMedio;
	}

	public void setPrecoMedio(BigDecimal precoMedio) {
		this.precoMedio = precoMedio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agente other = (Agente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Agente [id=" + id + ", codigo=" + codigo + ", data=" + data + ", regiao=" + regiao + ", geracao="
				+ geracao + ", compra=" + compra + ", precoMedio=" + precoMedio + "]";
	}
}
