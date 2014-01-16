package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Produto extends Model {
	@Id
	private Long id;

	@Required
	private String nome;
	
	@Required
	private String descricao;
	
	@Required
	private String numeroComprasNet;
	
	@Required
	@OneToOne
	private Categoria categoria;
	
	@OneToOne
	private Unidade unidade;
	
	public static Finder<Long, Produto> find = new Finder<Long, Produto>(
			Long.class, Produto.class);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumeroComprasNet() {
		return numeroComprasNet;
	}

	public void setNumeroComprasNet(String numeroComprasNet) {
		this.numeroComprasNet = numeroComprasNet;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	

}
