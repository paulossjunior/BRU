package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class GerenteCompra extends Model {
	@Id
	private Long id;

	@Required
	private String nome;

	private String login;
	
	@OneToOne
	private Categoria categoria;

	private String senha;
	
	@OneToOne
	private Campus campus;
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public String getCategoriaString() {
		return categoria.getNome();
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public static Finder<Long, GerenteCompra> find = new Finder<Long, GerenteCompra>(
			Long.class, GerenteCompra.class);

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

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

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}	
	
}
