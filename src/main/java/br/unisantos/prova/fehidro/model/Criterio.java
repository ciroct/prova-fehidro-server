package br.unisantos.prova.fehidro.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "tb_criterio")
@Entity
@NamedQueries({
	@NamedQuery(name = "Criterio.listarTodos", 
			    query = "select c from Criterio c"),
	@NamedQuery(name = "Criterio.consultarPorId", 
                query = "select c from Criterio c where c.id = ?1"),
	@NamedQuery(name = "Criterio.consultarPontuacao", 
                query = "select sum(c.pontuacaoMaxima) from Criterio c"),
	@NamedQuery(name = "Criterio.listarSubCriterios", 
                query = "select sc from Criterio c join c.subCriterio sc where c.id = ?1")
})
public class Criterio extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_titulo", length = 500)
	private String titulo;
	@Column(name = "nr_pontuacao_maxima")
	private Integer pontuacaoMaxima;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "fk_criterio_id")
	private List<Pontuacao> pontuacoes;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "fk_criterio_id")
	private List<Criterio> subCriterio;

	public Criterio() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getPontuacaoMaxima() {
		return pontuacaoMaxima;
	}

	public void setPontuacaoMaxima(Integer pontuacaoMaxima) {
		this.pontuacaoMaxima = pontuacaoMaxima;
	}

	@JsonIgnore
	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	@JsonProperty
	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}

	@JsonIgnore
	public List<Criterio> getSubCriterio() {
		return subCriterio;
	}

	@JsonProperty
	public void setSubCriterio(List<Criterio> subCriterio) {
		this.subCriterio = subCriterio;
	}		

}
