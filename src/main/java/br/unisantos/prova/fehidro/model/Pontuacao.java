package br.unisantos.prova.fehidro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tb_pontuacao")
@Entity
@NamedQueries({
	@NamedQuery(name = "Pontuacao.listarPorCriterio", 
		    query = "select p from Criterio c join c.pontuacoes p where c.id = ?1"),
	@NamedQuery(name = "Pontuacao.consultarPorId", 
			    query = "select p from Pontuacao p where p.id = ?1")
})
public class Pontuacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_titulo", length = 500)
	private String titulo;
	@Column(name = "nr_pontos")
	private Integer pontos;
	@Column(name = "bo_obrigatoria")
	private Boolean obrigatoria;
	public Pontuacao() {
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	public Boolean getObrigatoria() {
		return obrigatoria;
	}
	public void setObrigatoria(Boolean obrigatoria) {
		this.obrigatoria = obrigatoria;
	}

}
