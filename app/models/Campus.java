package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Campus extends Model {
	@Id
	private Long id;

	@Required
	private String nome;
	
	@OneToMany(mappedBy="campus")
	List<GerenteCompra> gerentesCompra;

	public static Finder<Long, Campus> find = new Finder<Long, Campus>(
			Long.class, Campus.class);

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

	public List<GerenteCompra> getGerentesCompra() {
		return gerentesCompra;
	}

	public void setGerentesCompra(List<GerenteCompra> gerenteCompra) {
		this.gerentesCompra = gerenteCompra;
	}

}
