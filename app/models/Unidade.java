package models;

import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Unidade extends Model {
	@Id
	private Long id;

	@Required
	private String nome;
	
	@OneToMany(mappedBy="unidade")
	List<Produto> produto;

	public static Finder<Long, Unidade> find = new Finder<Long, Unidade>(
			Long.class, Unidade.class);

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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	public static Map<String, String> unidades() {
		LinkedHashMap<String, String> vals = new LinkedHashMap<String, String>();

		for (Unidade unidade : find.all()) {
			vals.put(unidade.getId().toString(), unidade.getNome());
		}
		return vals;

	}
	public static List<Unidade> findAll()
	{
		return find.all();
	}
	
	public static Unidade findById(Long id)
	{
		return find.byId(id);
	}

}
